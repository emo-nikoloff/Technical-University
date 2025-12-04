/*Напишете програма, която чете n реда стрингове и извлича името и възрастта на дадено лице. Името на човека ще бъде между „@“ и „|“. Възрастта на човека ще бъде между „#“ и „*“.
Пример: „Hello my name is @Peter| and I am #20* years old.“ За всяко намерено име и възраст, отпечатайте ред във формат „{name} is {age} years old.“*/

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
