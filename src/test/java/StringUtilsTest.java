import org.junit.jupiter.api.Assertions;

public class StringUtilsTest {

    @org.junit.jupiter.api.Test
    public void testToArray_source_not_null() {
        // given:
        final String[] expected = {"T", "E", "S", "T"};
        final String source = "T:E:S:T";
        // when:
        final String[] result = StringUtils.toArray(source, ':');
        // then:
        Assertions.assertArrayEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    public void testToArray_source_null() {
        // given:
        final String source = null;
        // when:
        final String[] result = StringUtils.toArray(source, ':');
        // then:
        Assertions.assertNotNull(StringUtils.toArray(null, ':'),
                " Массив строк не создан");
    }

    @org.junit.jupiter.api.Test
    public void testIsEmpty_content() {
        // given:
        final String text = "TEST";
        // when:
        final boolean result = StringUtils.isEmpty(text);
        // then:
        Assertions.assertFalse(result, "Непустая строка");
    }

    @org.junit.jupiter.api.Test
    public void testIsEmpty_not_content() {
        // given:
        final String text = "";
        // when:
        final boolean result = StringUtils.isEmpty(text);
        // then:
        Assertions.assertTrue(result,"Пустая строка не распознана" );
    }
    @org.junit.jupiter.api.Test
    public void testIsEmpty_space () {
        // given:
        final String text = " ";
        // when:
        final boolean result = StringUtils.isEmpty(text);
        // then:
        Assertions.assertTrue(result,"Пробелы не распознаны" );
    }

    @org.junit.jupiter.api.Test
    public void testFromDouble() {
        // given:
        final double source = 3.1415;
        final String expected = "3.1415";
        // when:
        final String actual = StringUtils.doubleToString(source);
        // then:
        Assertions.assertEquals(expected, actual, "Неверный результат");

    }
}
