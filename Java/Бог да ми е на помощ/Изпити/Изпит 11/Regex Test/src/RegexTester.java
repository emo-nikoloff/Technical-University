import java.util.ArrayList;
import java.util.List;

public class RegexTester {
    public static List<Boolean> test(Regex regex, String[] strings) {
        List<Boolean> results = new ArrayList<>();
        for (String string : strings) {
            if (string.matches(regex.getPattern())) {
                results.add(true);
            } else {
                results.add(false);
            }
        }
        return results;
    }
}
