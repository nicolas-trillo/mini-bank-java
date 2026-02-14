package model;

import exception.IllegalAmountException;
import exception.InvalidIdException;

import java.math.BigDecimal;

public record Transaction(int id, Type type, BigDecimal amount) {
    public enum Type {DEPOSIT, WITHDRAWAL, FEE}

    public Transaction {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalAmountException("> Illegal Transaction: Negative Amount");
        }
        if (id <= 0) {
            throw new InvalidIdException("> Illegal Transaction: Invalid ID");
        }
    }
}
