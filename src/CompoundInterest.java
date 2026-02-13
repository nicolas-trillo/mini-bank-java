import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CompoundInterest {
    String num = IO.readln(">MONTO: ");

    public CompoundInterest() {
        this.num = IO.readln(">MONTO: ").replaceAll(",", ".");
    }

    private BigDecimal inicial = new BigDecimal(num);

    // Compound interest
    private MathContext mc = new MathContext(15, RoundingMode.HALF_UP);

    private BigDecimal rate = new BigDecimal("0.2");
    private BigDecimal monthlyRate = rate.divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP);

    private BigDecimal factor = BigDecimal.ONE
            .add(monthlyRate, mc)
            .pow(36);

    public BigDecimal cf = inicial.multiply(factor).setScale(2, RoundingMode.HALF_UP);

    public void print() {
        IO.println(">CI AMOUNT: " + inicial);
        IO.println(">CI RATE: " + rate);
        IO.println(">CI MONTHLY RATE: " + monthlyRate);
        IO.println(">CI FACTOR: " + factor);
        IO.println(">CI COMPOUND AMOUNT: " + cf);
        IO.println();

    }
    // IO.println(new BigDecimal(12000*Math.pow(1+(0.2/12),(12*3))));
}
