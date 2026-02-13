import java.math.BigDecimal;
import java.util.List;

public record Account(int id, BigDecimal balance, List<Transaction> transactions) {}