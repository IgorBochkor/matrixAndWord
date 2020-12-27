package matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MainTest {
    Main main = new Main();

    @Test
    void null_operation_NotOk() {
        assertThrows(NullPointerException.class, () -> {
            main.matrixAndWord(null, null);
        });
    }

    @Test
    void empty_operation_Ok() {
        String expected = "";
        String actual = main.matrixAndWord("", "");
        assertEquals(expected, actual);
    }

    @Test
    void sizeMatrix_length_square_Ok() {
        assertTrue(main.isSizeMatrixSquare("ASDFGHJKL"));
    }

    @Test
    void first_argument_must_be_larger_then_second() {
        assertTrue(main.isFirstLargerThenSecond("ASDFGHJKL", "GF"));
    }

    @Test
    void string_must_be_uppercase_Ok() {
        assertTrue(main.isOnlyLowerCase("TYUGHJBNM", "QWE"));
    }

    @Test
    void runtimeException_while_incorrect_data_Ok() {
        assertThrows(RuntimeException.class, () -> {
            main.matrixAndWord("RRFFFGGSD", "123");
        });
    }

    @Test
    void performance_result_Ok() {
        String expected = "[1,2]->[1,3]->[0,3]->[0,2]";
        String actual = main.matrixAndWord("QLGNAEKIRLRNGEAE", "KING");
        assertEquals(expected, actual);
    }
}
