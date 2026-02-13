import java.math.BigDecimal;
import java.util.List;

public class BankService {
    public Account execute(List<Transaction> transactions, Account account) {
        BigDecimal currentBalance = account.balance();
        List<Transaction> transactionList = new java.util.ArrayList<>(account.transactions());
        int id = account.id();

        for (Transaction transaction : transactions) {
            switch (transaction.type()) {
                case DEPOSIT -> {
                    currentBalance = currentBalance.add(transaction.amount());
                    transactionList.add(transaction);
                }
                case WITHDRAWAL, FEE -> {
                    if (currentBalance.subtract(transaction.amount()).compareTo(BigDecimal.ZERO) < 0) {
                        throw new IllegalArgumentException("Illegal Transaction> Insufficient funds");
                    } else {
                        currentBalance = currentBalance.subtract(transaction.amount());
                        transactionList.add(transaction);
                    }
                }
            }
        }

        return new Account(id, currentBalance, List.copyOf(transactionList));
    }
}
