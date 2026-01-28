import java.util.Scanner;

public class Aparicio_assignment2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Setting my public variables
        double loanAmount;
        double interestRate;
        int years;

        // Promp questions for user
        System.out.println("How much is the loan amount?");
        loanAmount = sc.nextDouble();
        System.out.println("What is the annual interest rate?");
        interestRate = sc.nextDouble();
        System.out.println("Enter the number of years: ");
        years = sc.nextInt();

        // print user input to console
        System.out.printf("Loan Amount: $%.2f", loanAmount);
        System.out.println();

        System.out.printf("Interest Rate: %.2f%%", interestRate * 100);
        System.out.println();

        // calculate monthly payment
        int loanPeriod = years * 12;
        double monthlyPayment = ((interestRate/12) * loanAmount) / (1 - Math.pow(1 + (interestRate/12), -loanPeriod));
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

        // Calculating the balance
        double balance = loanAmount;

        for (int period = 1; period <= loanPeriod; period++){
            double interestAmount = balance * (interestRate/12);
            double principalAmount = monthlyPayment - interestAmount;
            balance -= (monthlyPayment - interestAmount);

            System.out.printf("Monthly Payment: $%.2f", monthlyPayment);
            System.out.printf(" Principal Amount: $%.2f", principalAmount);
            System.out.printf(" Interest Amount: $%.2f", interestAmount);
            System.out.printf(" Amount Left: $%.2f", balance);

            System.out.println();

            // output each year in the statement
            if (period % 12 == 0){
                int year = period / 12;
                System.out.println("--- End of Year " + year + "---");
            }

            if(monthlyPayment>=balance){
                monthlyPayment = balance;
                principalAmount = monthlyPayment;
                interestAmount = 0;
                balance -= monthlyPayment;

                System.out.printf("Monthly Payment: $%.2f", monthlyPayment);
                System.out.printf(" Principal Amount: $%.2f", principalAmount);
                System.out.printf(" Interest Amount: $%.2f", interestAmount);
                System.out.printf(" Amount Left: $%.2f", balance);

                System.out.println();
                System.out.println("--- End of Year " + ((period/12) + 1) + " ---");

                // Once it reaches condition it stops from repeating calculation
                break;
            }

        }
    }
}
