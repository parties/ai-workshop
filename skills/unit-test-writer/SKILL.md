---
name: unit-test-writer
description: This skill should be used when the user asks to "write autograder tests", "generate unit tests for CodeHS", "create tests for this assignment", or "write a Grader for this". Applies when provided a CodeHS Java assignment description and solution code.
version: 0.1.0
---

# CodeHS Java Unit Test Writer

Generates autograder test files for CodeHS Java assignments. Supports both the **Java Autograder** (console I/O) and **JUnit Autograder** (method/OOP testing) formats.

## Inputs

The user will provide:
1. Assignment description — markdown doc explaining what the program must do
2. Solution code — one or more `.java` files showing correct implementation

## Autograder Type Selection

Choose based on what the assignment tests:

| Assignment shape | Use |
|---|---|
| Program prints output, reads Scanner input, `main()` is entry point | **Java Autograder** → write `Grader.java` |
| Methods with return values, OOP classes, data structures | **JUnit** → write `JUnitExampleTest.java` |
| Mixed (class with both I/O and methods) | **JUnit** — better assertions; note I/O limitations |

If ambiguous, recommend and state why. Do not ask unless genuinely unclear.

## Workflow

1. Read assignment description. Identify: what inputs the program takes, what outputs it produces, what methods/classes are defined.
2. Read all solution `.java` files. Note class names, method signatures, return types. Note the directory path of the solution files.
3. Select autograder type (see table above). State choice and reasoning in one sentence.
4. Generate the test file content following the format guide for the chosen type.
5. **Write the file to disk** using the Write tool — place it in the same directory as the solution code. Filename: `Grader.java` (Java Autograder) or `JUnitExampleTest.java` (JUnit).
6. Confirm the file path written. List any assumptions made (e.g., exact output phrasing, edge cases skipped).

## Java Autograder — Test File: `Grader.java`

Write tests inside `Grader.main()`. Use `Autograder` API to intercept I/O.

**Core pattern — console output test:**
```java
public static void main(String[] args) {
    Autograder grader = new Autograder();

    // Test: run student code and solution with same inputs, compare output
    MyProgram student = new MyProgram();
    MyProgramSolution solution = new MyProgramSolution();

    grader.setInputs(new String[]{"Alice", "5"});
    student.main(new String[0]);

    grader.setInputs(new String[]{"Alice", "5"});
    solution.main(new String[0]);

    String studentOut = grader.getOutput("MyProgram");
    String solutionOut = grader.getOutput("MyProgramSolution");

    grader.assertEqual("Test with name Alice and count 5",
        studentOut, solutionOut,
        "Output matches.", "Output does not match expected.");

    grader.clearOutput();

    System.out.println(grader);
}
```

**Rules:**
- Call `grader.clearOutput()` between tests to prevent output bleed
- Call `grader.setInputs()` before **each** `.main()` call — even the solution's
- Use `grader.getOutput("ClassName")` keyed to exact class name
- Always end with `System.out.println(grader)` — omitting it silently produces no results
- Solution class must be in the autograder file set; name it `[OriginalClass]Solution` by convention

See **`references/java-autograder-guide.md`** for advanced patterns (multiple test cases, input variations, partial output matching).

## JUnit Autograder — Test File: `JUnitExampleTest.java`

Write standard JUnit 5 tests. The `JUnitMain.java` and `JUnitListener.java` are provided by CodeHS and do not need to be modified.

**Core pattern:**
```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JUnitExampleTest {

    @Test
    @DisplayName("getArea returns correct value for 3x4 rectangle")
    void testGetArea() {
        Rectangle r = new Rectangle(3, 4);
        assertEquals(12, r.getArea());
    }

    @ParameterizedTest
    @DisplayName("getArea works for multiple dimensions")
    @CsvSource({"3, 4, 12", "5, 5, 25", "0, 7, 0"})
    void testGetAreaParameterized(int w, int h, int expected) {
        Rectangle r = new Rectangle(w, h);
        assertEquals(expected, r.getArea());
    }
}
```

**Rules:**
- Every test needs `@Test` and `@DisplayName` — display name appears in CodeHS results
- Use `@ParameterizedTest` + `@CsvSource` for value-driven tests (preferred over copy-paste)
- Import only from `org.junit.jupiter` — not JUnit 4
- Do not modify `JUnitMain.java`; it already selects `JUnitExampleTest.class`

See **`references/junit-autograder-guide.md`** for assertion reference and OOP patterns.

## Output Format

Write the file to disk (do not only print to console). Confirm with: `Written: <absolute-path>`. Then list assumptions below.

## Additional Resources

- **`references/java-autograder-guide.md`** — Full Java Autograder API, multi-test patterns, I/O edge cases
- **`references/junit-autograder-guide.md`** — JUnit 5 assertion reference, OOP test patterns
- **`samples/Java-Autograder/`** — Live CodeHS-provided framework files
- **`samples/JUnit-Autograder/`** — Live CodeHS-provided JUnit harness files
