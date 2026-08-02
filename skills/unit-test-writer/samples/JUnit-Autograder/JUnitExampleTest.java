import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JUnitExampleTest {
    @Test
    @DisplayName("Fail Test")
    void failTest() {
        assertEquals(2, 3);
    }

    @Test
    @DisplayName("Pass Test")
    void passTest() {
        assertEquals("Hello", "Hello");
    }

}
