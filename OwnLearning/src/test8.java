import java.util.Scanner;

public class test8 {
    public static double grossYearlySalary(double hoursPerWeek, double hourlyRate){
        return hoursPerWeek * hourlyRate * 52;
    }

    public static double bonus(int daysOfVacation, double hourlyRate){
        return (8 * hourlyRate * daysOfVacation);
    }
    public static double salaryWithBonus(double grossYearlySalary, double bonus){
        return grossYearlySalary + bonus;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of hours per week: ");
        double hoursPerWeek = input.nextDouble();
        System.out.print("Enter the hourly rate: $");
        double hourlyRate = input.nextDouble();
        System.out.print("Enter the number of vacation days: ");
        int daysOfVacation = input.nextInt();

        double grossYearlySalary = grossYearlySalary(hoursPerWeek, hourlyRate);
        double bonus = bonus(daysOfVacation, hourlyRate);
        double salaryWithBonus = salaryWithBonus(grossYearlySalary, bonus);
        System.out.println("The gross yearly salary is $"
                            + grossYearlySalary + " and the bonus is $" + bonus
                            + " that's a total of $" + salaryWithBonus);
    }
}
