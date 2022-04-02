public class StringUtils {

    private StringUtils() { }

    public static String joinArray(final String[] source, final char del) {
        if (source == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < source.length - 1; i++) {
            result.append(source[i]);
            result.append(del);
        }

        result.append(source[source.length - 1]);

        return result.toString();
    }

    public static String[] toArray(final String source, final char delimiter) {
        if (source == null) {
            return new String[]{};
        }
        return source.split(Character.toString(delimiter));
    }

    public static boolean isEmpty(final String subject) {
        if (subject == null) return true;
        if (subject.replaceAll("\\s", "").isEmpty()) return true;
        return false;
    }

    public static double toDouble(final String source) {
        if (source == null) {
            return Double.NaN;
        }
        return Double.valueOf(source);
    }

    public static String doubleToString (final double source) {
        return String.valueOf(source);
    }
}
