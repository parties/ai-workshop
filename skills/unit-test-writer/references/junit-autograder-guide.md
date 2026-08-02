# JUnit Autograder — Reference Guide

## How It Works

CodeHS provides (do not modify):
- `JUnitMain.java` — entry point; discovers and runs `JUnitExampleTest.class`
- `JUnitListener.java` — captures results in CodeHS JSON format

You write: **`JUnitExampleTest.java`** only.

JUnit 5 (Jupiter) is available. Use `org.junit.jupiter.*` imports only — not JUnit 4.

## Core Assertions

```java
import static org.junit.jupiter.api.Assertions.*;

assertEquals(expected, actual)
assertEquals(expected, actual, "failure message")
assertNotEquals(unexpected, actual)
assertTrue(condition)
assertFalse(condition)
assertNull(object)
assertNotNull(object)
assertThrows(ExceptionType.class, () -> { /* code */ })
```

## Test Structure

```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JUnitExampleTest {

    @Test
    @DisplayName("Description shown in CodeHS results")
    void testSomething() {
        MyClass obj = new MyClass();
        assertEquals(expected, obj.someMethod());
    }
}
```

Every test must have both `@Test` and `@DisplayName`. The `@DisplayName` string is what students see in feedback.

## Parameterized Tests

Use `@ParameterizedTest` + `@CsvSource` to run one test across many inputs without copy-paste:

```java
@ParameterizedTest
@DisplayName("area(w, h) returns correct value")
@CsvSource({
    "3, 4, 12",
    "5, 5, 25",
    "10, 2, 20",
    "0, 7, 0"
})
void testArea(int w, int h, int expected) {
    Rectangle r = new Rectangle(w, h);
    assertEquals(expected, r.area());
}
```

Each CSV row maps to one test run. Column types must match parameter types exactly.

## OOP Patterns

### Constructor + getter
```java
@Test
@DisplayName("Dog constructor sets name correctly")
void testDogName() {
    Dog d = new Dog("Rex");
    assertEquals("Rex", d.getName());
}
```

### Method modifies state
```java
@Test
@DisplayName("deposit increases balance")
void testDeposit() {
    BankAccount acct = new BankAccount(100.0);
    acct.deposit(50.0);
    assertEquals(150.0, acct.getBalance(), 0.001); // delta for doubles
}
```

### Exception expected
```java
@Test
@DisplayName("withdraw throws when insufficient funds")
void testOverdraft() {
    BankAccount acct = new BankAccount(10.0);
    assertThrows(IllegalArgumentException.class, () -> acct.withdraw(100.0));
}
```

### Collection / array return
```java
@Test
@DisplayName("getItems returns all added items")
void testGetItems() {
    ShoppingCart cart = new ShoppingCart();
    cart.addItem("apple");
    cart.addItem("banana");
    assertEquals(2, cart.getItems().size());
    assertTrue(cart.getItems().contains("apple"));
}
```

### Double equality (use delta)
```java
assertEquals(3.14159, circle.getArea(), 0.001);
```

## @BeforeEach Setup

When multiple tests share the same object setup:

```java
class JUnitExampleTest {
    private MyClass obj;

    @BeforeEach
    void setUp() {
        obj = new MyClass();
    }

    @Test
    @DisplayName("method A works")
    void testA() {
        assertEquals(1, obj.methodA());
    }
}
```

## Assertion Failure Messages

Include a failure message on complex assertions so CodeHS feedback is useful:

```java
assertEquals(expected, actual, "getPerimeter() should return 2*(w+h)");
assertTrue(result > 0, "result should be positive");
```

## Common Mistakes

| Mistake | Effect | Fix |
|---|---|---|
| Missing `@DisplayName` | CodeHS shows method name instead of description | Always add it |
| JUnit 4 imports (`org.junit.Test`) | Compile error | Use `org.junit.jupiter.api.*` |
| Float/double equality with `assertEquals` no delta | Flaky test | Add `0.001` delta |
| Modifying `JUnitMain.java` | Could break test discovery | Never touch it |
| One giant test with many assertions | First failure hides rest | Split into one assertion per test |
