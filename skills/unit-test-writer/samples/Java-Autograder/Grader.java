import java.util.*;

/**
 * You can write autograded tests here.<br><br>
 * Test format:
 * <pre>
 * Autograder grader = new Autograder();
 * grader.assertEqual(String testName, T studentOutput,
 *     T solutionOutput, String messagePass, String messageFail)</pre>
 * Alternative test format:
 * <pre>
 * boolean test = false;
 * grader.addTest(String testName, boolean testStatus,
 *     T studentOutput, T solutionOutput, String message);
 * </pre>
 * The autograder will automatically track and store all output from println and
 * print. This can be done with the following Autograder functions:
 * <pre>
 * grader.getOutput(String className);
 * grader.getOutputArrayList(String className);
 * </pre>
 * You can set the inputs that will be used on System.in. You need to do this
 * before each .main() call, and if you may need to clear them after using .clearInput().
 * This is in case the student's code doesn't consume all input. If you use
 * .setInputs() after, it overwrites and you're fine.
 * <pre>
 * MyProgram p1;
 * p1 = new MyProgram();
 * grader.setInputs(String[] inputs);
 * p1.main(new String[0]);
 * Solution p2;
 * p2 = new Solution();
 * grader.setInputs(String[] inputs);
 * p1.main(new String[0]);
 * </pre>
 * Something of note, files in the autograder will overwrite files of the
 * same name in the student code. This can be useful if you want an alterantive
 * version of the master code for a particular file.<br>
 * <br>
 * You can find some example tests in the code below.<br>
 * See documentation for further information.<br>
 */
public class Grader
{
    public static void main(String [] args)
    {
        Autograder grader = new Autograder();

        // Test 1
        // grader.assertEqual("This should pass",
        //     "1", "1", "Great!", "Please, try again.");

        // Test 2
        // grader.assertEqual("Asserts the same",
        //     "1", "0", "Great!", "Please, try again.");

        // Test 3
        // boolean test = false;
        // grader.addTest("Asserts something",
        //     test, "1", "0", "Please, try again.");

        // Test 4
        // MyProgram p1;
        // MyProgramSolution p2;
        // p1 = new MyProgram();
        // p2 = new MyProgramSolution();
        // grader.setInputs(new String[]{"Zach", "Jeremy"});
        // p1.main(new String[0]);
        // grader.setInputs(new String[]{"Zach"});
        // grader.addInput("Jeremy");
        // p2.main(new String[0]);
        // String studentOutput = grader.getOutput("MyProgram");
        // String solutionOutput = grader.getOutput("MyProgramSolution");
        // grader.assertEqual("Test output", studentOutput, solutionOutput, "Woop!", "Nooooope.");

        System.out.println(grader);
    }
}
