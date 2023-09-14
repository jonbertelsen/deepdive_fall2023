package dat;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise7
{
    public static void main(String[] args) {

        List<Transaction> transactions = Transaction.getTransactionList();

        // Calculate the total sum of all transaction amounts
        double totalSum = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
        System.out.println("Total sum of all transactions: " + totalSum);

        // Group transactions by currency and calculate sum for each currency
        transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCurrency))
                .forEach((currency, transactionList) -> {
                    double sum = transactionList.stream()
                            .mapToDouble(Transaction::getAmount)
                            .sum();
                    System.out.println(currency + ": " + sum);
                });

        // Find the highest transaction amount
        double highestAmount = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .max()
                .getAsDouble();
        System.out.println("Highest transaction amount: " + highestAmount);

        // Find the average transaction amount
        double averageAmount = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .average()
                .getAsDouble();
        System.out.println("Average transaction amount: " + averageAmount);
    }
}
