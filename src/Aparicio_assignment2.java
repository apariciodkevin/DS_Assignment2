import java.util.Scanner;

public class Aparicio_assignment2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Setting my public variables
        double loanAmount;
        float interestRate;
        int years;

        // Promp questions for user
        System.out.println("How much is the loan amount?");
        loanAmount = sc.nextDouble();
        System.out.println("What is the annual interest rate?");
        interestRate = sc.nextFloat();
        System.out.println("Enter the number of years: ");
        years = sc.nextInt();

        // print user input to console
        System.out.printf("Loan Amount: $%.2f", loanAmount);
        System.out.println();

        System.out.printf("Interest Rate: %.2f%%", interestRate * 100);
        System.out.println();

        // calculate monthly payment
        int loanPeriod = years * 12;
        double monthlyPayment = (interestRate * loanAmount) / (1 - Math.pow(1 + interestRate, -loanPeriod));
        System.out.printf("Monthly Payment: $%.2f", monthlyPayment);
        System.out.println();

        // calculate total cost
        double totalCost = monthlyPayment * loanPeriod;
        System.out.printf("Total Cost: $%.2f", totalCost);
        System.out.println();

        // calculate ratio over principal
        double ratioOverPrincipal = ((monthlyPayment * loanPeriod) - loanAmount) * 100 / loanAmount;
        System.out.printf("Ratio paid over principal: %.2f%%", ratioOverPrincipal);
        System.out.println();


    }


}
