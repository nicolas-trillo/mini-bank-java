import java.math.BigDecimal;

public class Feb11 {
    void thing() {
        Transaction one = new Transaction(1, Transaction.Type.DEPOSIT, new BigDecimal("1000"));
        Transaction two = new Transaction(2, Transaction.Type.WITHDRAWAL, new BigDecimal("500"));
        Transaction three = new Transaction(3, Transaction.Type.FEE, new BigDecimal("100"));
        Transaction four = new Transaction(4, Transaction.Type.DEPOSIT, new BigDecimal("2000"));

        Transaction[] transactions = {one, two, three, four};
        IO.println(reportTransactions(transactions));
    }

    String reportTransactions(Transaction[] transactions) {
        int deposits = 0;
        int withdrawals = 0;
        int fees = 0;

        for (Transaction transaction : transactions) {
            switch (transaction.type()) {
                case DEPOSIT -> deposits++;
                case WITHDRAWAL -> withdrawals++;
                case FEE -> fees++;
                default -> throw new IllegalStateException("Illegal value: " + transaction.type());
            }
        }

        return String.format("Deposits: %d, Withdrawals: %d, Fees: %d", deposits, withdrawals, fees);
    }
}
