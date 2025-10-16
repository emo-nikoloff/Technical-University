import java.util.Scanner;

public class Business {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        CompanyET company = new CompanyET();

        System.out.print("Enter the company's name: ");
        company.setName(input.nextLine());

        System.out.print("Enter the company's founding date: ");
        company.setDate(input.nextLine());

        System.out.print("Enter the company's Bulstat: ");
        company.setBulstat(input.nextLine());

        System.out.print("Enter the founder's name: ");
        company.setFounderName(input.nextLine());

        System.out.print("Enter the starting fund: ");
        company.setStartingFund(Double.parseDouble(input.nextLine()));

        System.out.print("Enter the current fund: ");
        company.setRealFund(Double.parseDouble(input.nextLine()));

        double todayFund = company.todayFund();

        System.out.println("\n--- Company Information ---");
        System.out.println("Company's name: " + company.getName());
        System.out.println("Company's founding date: " + company.getDate());
        System.out.println("Company's bulstat: " + company.getBulstat());
        System.out.println("Company's founder: " + company.getFounderName());
        System.out.println("Company's starting fund: " + company.getStartingFund());
        System.out.println("Company's current fund: " + company.getRealFund());
        System.out.println("The difference from the start till now: " + todayFund);

        input.close();
    }
}
