import java.math.BigDecimal;

public record Transaction(int id, Type type, BigDecimal amount) {
    public enum Type {DEPOSIT, WITHDRAWAL, FEE}

    public Transaction {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("> Illegal Transaction: Negative amount");
        }
        if (Integer.toString(id).length() != 10) {
            throw new IllegalArgumentException("> Illegal Transaction: Invalid ID");
        }
    }
}
