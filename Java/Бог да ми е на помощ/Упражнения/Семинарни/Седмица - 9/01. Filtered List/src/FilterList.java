import java.util.List;

public class FilterList {
    public static void main(String[] args) throws Exception {
        List<Integer> numbers = List.of(5, 12, 8, 20, 13, 14);
        List<Integer> evenNumbersGreaterThan10 = getEvenNumbersGreaterThan10(numbers);

        for (Integer number : evenNumbersGreaterThan10) {
            System.out.println(number);
        }
    }

    public static List<Integer> getEvenNumbersGreaterThan10(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .filter(n -> n > 10)
                .sorted()
                .toList();
    }

}
