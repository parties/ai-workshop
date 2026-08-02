# Java Autograder — Reference Guide

## How It Works

CodeHS provides these files (do not modify):
- `Autograder.java` — test registry + I/O interception coordinator
- `Interceptor.java` — overrides `System.out` to capture all print/println by class name
- `InputProvider.java` — overrides `System.in` to feed mock Scanner input
- `ObjectTracker.java` — optional; tracks class instances if student class extends it

You write: **`Grader.java`** only.

The `Interceptor` captures output using the stack trace to identify which class called `println`. Output is stored keyed to class name. This is why `grader.getOutput("MyProgram")` works — it retrieves everything that `MyProgram` printed.

## Full API

```java
// Set Scanner inputs before running a program
grader.setInputs(String[] inputs)     // sets all inputs at once (newline-separated)
grader.addInput(String input)          // appends one input
grader.clearInput()                    // resets input buffer

// Retrieve captured output
grader.getOutput(String className)          // all output as single concatenated String
grader.getOutputArrayList(String className) // each println as separate ArrayList entry

// Clear output between tests (ALWAYS do this)
grader.clearOutput()                   // clears all classes
grader.clearOutput(String className)   // clears one class only

// Add test results
grader.assertEqual(String testName, T studentOutput, T solutionOutput,
    String messagePass, String messageFail)

grader.addTest(String testName, boolean status,
    T studentOutput, T solutionOutput, String message)
```

## Multi-Test Pattern

```java
public static void main(String[] args) {
    Autograder grader = new Autograder();

    String[][] testInputs = {
        {"Alice"},
        {"Bob"},
        {""}
    };

    for (String[] inputs : testInputs) {
        MyProgram student = new MyProgram();
        MyProgramSolution solution = new MyProgramSolution();

        grader.setInputs(inputs);
        student.main(new String[0]);

        grader.setInputs(inputs);
        solution.main(new String[0]);

        String studentOut = grader.getOutput("MyProgram");
        String solutionOut = grader.getOutput("MyProgramSolution");

        grader.assertEqual("Input: " + String.join(", ", inputs),
            studentOut, solutionOut,
            "Correct output.", "Output mismatch.");

        grader.clearOutput();
    }

    System.out.println(grader);
}
```

## Checking Individual Output Lines

Use `getOutputArrayList` when the assignment requires specific lines in specific positions:

```java
student.main(new String[0]);
ArrayList<String> lines = grader.getOutputArrayList("MyProgram");

// Check line count
grader.addTest("Prints exactly 3 lines",
    lines != null && lines.size() == 3,
    lines != null ? String.valueOf(lines.size()) : "null",
    "3",
    lines != null && lines.size() == 3 ? "Correct." : "Expected 3 lines.");

// Check specific line content
boolean line1correct = lines != null && lines.size() > 0
    && lines.get(0).trim().equals("Hello, World!");
grader.addTest("First line is 'Hello, World!'",
    line1correct,
    lines != null && lines.size() > 0 ? lines.get(0) : "(no output)",
    "Hello, World!\n",
    line1correct ? "Correct." : "First line mismatch.");
```

## Partial/Contains Check

When exact output doesn't matter but a keyword must appear:

```java
String out = grader.getOutput("MyProgram");
boolean containsName = out != null && out.toLowerCase().contains("alice");
grader.addTest("Output contains the name",
    containsName,
    out != null ? out : "(no output)",
    "(contains 'alice')",
    containsName ? "Found the name." : "Name not found in output.");
```

## Numeric Output Check

When program prints a number and exact string formatting may vary:

```java
String out = grader.getOutput("MyProgram").trim();
String solutionOut = grader.getOutput("MyProgramSolution").trim();
grader.assertEqual("Numeric output matches", out, solutionOut,
    "Correct.", "Mismatch.");
```

## ObjectTracker Usage

If the assignment requires tracking how many instances of a class were created (e.g., "create 3 Dog objects"):

Student class must extend `ObjectTracker`:
```java
// Grader can then check:
ArrayList<Object> dogs = ObjectTracker.getObjectsForClass("Dog");
grader.addTest("Created 3 Dog objects",
    dogs != null && dogs.size() == 3,
    dogs != null ? String.valueOf(dogs.size()) : "0",
    "3",
    dogs != null && dogs.size() == 3 ? "Correct." : "Wrong number of Dog objects.");
```

## Common Mistakes

| Mistake | Effect | Fix |
|---|---|---|
| Forget `grader.clearOutput()` | Output from test N bleeds into test N+1 | Call after each `assertEqual` block |
| Forget `setInputs` before solution | Solution runs with no input, may throw | Set inputs before both student and solution |
| Forget `System.out.println(grader)` | CodeHS sees no results, shows 0 tests | Always last line of main |
| Wrong class name in `getOutput()` | Returns null → NPE or "forgot to print" | Must match exact Java class name |
| Instantiate `new MyProgram()` once, reuse | State bleeds between runs | Instantiate fresh instance per test |
