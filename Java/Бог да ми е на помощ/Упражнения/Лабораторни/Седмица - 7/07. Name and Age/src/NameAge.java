import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameAge {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Въведете изречение: ");
        String sentence = input.nextLine();

        Pattern pattern = Pattern.compile("@(?<name>[a-zA-Z]+)\\|[^#*]*#(?<age>\\d+)\\*");
        Matcher matcher = pattern.matcher(sentence);

        if (matcher.find()) {
            String name = matcher.group("name");
            int age = Integer.parseInt(matcher.group("age"));
            System.out.printf("%s is %d years old.%n", name, age);
        } else {
            System.out.println("Няма намерени данни.");
        }

        input.close();
    }
}
