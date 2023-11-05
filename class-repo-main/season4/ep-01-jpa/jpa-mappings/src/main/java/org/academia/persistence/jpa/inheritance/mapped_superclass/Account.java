package org.academia.persistence.jpa.inheritance.mapped_superclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account extends AbstractModel {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                "} " + super.toString();
    }
}
