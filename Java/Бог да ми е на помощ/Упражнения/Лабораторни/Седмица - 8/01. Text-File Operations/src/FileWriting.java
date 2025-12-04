/*Цел: Напишете програма, която чете файл и замества всички срещания на определен текст с друг текст, използвайки регулярни изрази.
Вход: Файл със съдържание, където думата "старо" трябва да бъде заменена с "ново".
Изход: Файл с променено съдържание.*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriting {
    public static void main(String[] args) throws Exception {
        File inputFile = new File(
                "C:\\Users\\Емо Николов\\Desktop\\Проекти\\От университета\\Java\\Бог да ми е на помощ\\Упражнения\\Лабораторни\\Седмица - 8\\01. Text-File Operations\\src\\data\\input.txt");
        File outputFile = new File(
                "C:\\Users\\Емо Николов\\Desktop\\Проекти\\От университета\\Java\\Бог да ми е на помощ\\Упражнения\\Лабораторни\\Седмица - 8\\01. Text-File Operations\\src\\data\\output.txt");

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("old", "new");

                writer.write(line);
                writer.newLine();
            }
            System.out.println("Готово! Замяната е извършена.");
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
