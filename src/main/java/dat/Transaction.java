package dat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class Transaction
{
    private int id;
    private double amount;
    private String currency;

    public static List<Transaction> getTransactionList()
    {
        return List.of(
            new Transaction(1, 100.0, "USD"),
            new Transaction(2, 150.0, "EUR"),
            new Transaction(3, 200.0, "USD"),
            new Transaction(4, 75.0, "GBP"),
            new Transaction(5, 120.0, "EUR"),
            new Transaction(6, 300.0, "GBP")
    );
    }
}
