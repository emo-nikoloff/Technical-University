import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        Object mutex = new Object();

        Thread reader = new Thread(() -> {
            while (true) {
                synchronized (mutex) {
                    for (Integer integer : list) {
                        System.out.printf("%d ", integer);
                    }
                    System.out.println();
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException error) {
                    error.printStackTrace();
                    input.close();
                }
            }
        });

        Thread writer = new Thread(() -> {
            while (true) {
                int number = Integer.parseInt(input.nextLine());
                synchronized (mutex) {
                    list.add(number);
                }
            }
        });

        writer.start();
        reader.start();
    }
}
