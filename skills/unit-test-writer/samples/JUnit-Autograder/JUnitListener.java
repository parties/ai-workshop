import java.io.*;
import java.lang.*;
import java.util.*;

import org.json.*;

import org.opentest4j.AssertionFailedError;

import static java.util.stream.Stream.concat;
import static org.apiguardian.api.API.Status.MAINTAINED;

import org.apiguardian.api.API;
import org.junit.platform.commons.PreconditionViolationException;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;

public class JUnitListener implements TestExecutionListener {

    private ArrayList<TestCase> tests;

    public JUnitListener() {
        tests = new ArrayList<TestCase>();
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        switch (testExecutionResult.getStatus()) {
            case SUCCESSFUL: {
                if(testIdentifier.isTest()) {
                    addTest(testIdentifier.getDisplayName(), true, null, null, "Success!");
                }
                break;
            }

            case ABORTED: {
                break;
            }

            case FAILED: {
                // we can get structured data about: org.opentest4j.AssertionFailedError
                // https://github.com/ota4j-team/opentest4j/blob/master/src/main/java/org/opentest4j/AssertionFailedError.java
                if(testIdentifier.isTest()) {
                    Optional<Throwable> maybeThrowable = testExecutionResult.getThrowable();
                    if (maybeThrowable.isPresent()) {
                        Throwable throwable = maybeThrowable.get();
                        if (throwable instanceof AssertionFailedError) {
                            AssertionFailedError assertError = (AssertionFailedError) throwable;
                            addTest(testIdentifier.getDisplayName(), false, assertError.getActual(), assertError.getExpected(), throwable.toString());
                        } else {
                            addTest(testIdentifier.getDisplayName(), false, null, null, throwable.toString());
                        }
                    } else {
                        addTest(testIdentifier.getDisplayName(), false, null, null, "There was an error!");
                    }
                } else {
                    // we skip container identifiers.
                }
                break;
            }

            default:
                // This shouldnt happen!
                throw new PreconditionViolationException("Unsupported execution status:" + testExecutionResult.getStatus());
        }
    }

    public String toString() {
        JSONObject jsonResults = new JSONObject();
        JSONArray jsonTests = new JSONArray();
        jsonResults.put("tests", jsonTests);
        for (int i = 0; i < tests.size(); i++) {
            TestCase test = tests.get(i);
            JSONObject jsonTest = new JSONObject();
            jsonTest.put("success", test.success);
            jsonTest.put("test", test.test);
            jsonTest.put("message", test.message);
            jsonTest.put("studentOutput", test.studentOutput);
            jsonTest.put("solutionOutput", test.solutionOutput);
            jsonTests.put(jsonTest);
        }
        return "__unittests__" + jsonResults.toString();
    }

    public <T> void addTest(
        String testName,
        boolean status,
        T studentOutput,
        T solutionOutput,
        String message
    ) {
        tests.add(new TestCase(testName, status, message, studentOutput, solutionOutput));
    }

    class TestCase {

        private String message;
        private boolean success;
        private Object studentOutput;
        private Object solutionOutput;
        private String test;

        public TestCase(
            String test,
            boolean success,
            String message,
            Object studentOutput,
            Object solutionOutput
        ) {
            this.success = success;
            this.message = message;
            this.studentOutput = studentOutput;
            this.solutionOutput = solutionOutput;
            this.test = test;
        }
    }
}
