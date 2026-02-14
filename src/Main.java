import model.Account;
import model.Transaction;
import service.BankService;

void main() {
    // Cuenta inicial con 1000
    Account account = new Account(
            1,
            new BigDecimal("1878.97"),
            new ArrayList<>()
    );

    // Transacciones a ejecutar
    List<Transaction> newTransactions = List.of(
            new Transaction(1, Transaction.Type.DEPOSIT, new BigDecimal("200.00")),
            new Transaction(2, Transaction.Type.WITHDRAWAL, new BigDecimal("150.00")),
            new Transaction(3, Transaction.Type.FEE, new BigDecimal("70.00"))
    );

    BankService bankService = new BankService();

    try {
        Account updatedAccount = bankService.execute(newTransactions, account);

        System.out.println("Account ID: " + updatedAccount.id());
        System.out.println("Final Balance: " + updatedAccount.balance());
        System.out.println("Transactions:");

        for (Transaction t : updatedAccount.transactions()) {
            System.out.println(" - ID: " + t.id() + ", Type: " + t.type() + ", Amount: " + t.amount());
        }

    } catch (IllegalArgumentException e) {
        System.out.println("Error processing transactions: " + e.getMessage());
    }
}