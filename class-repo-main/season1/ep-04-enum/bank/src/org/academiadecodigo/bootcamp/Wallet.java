package org.academiadecodigo.bootcamp;

/**
 * Wallet Class
 */
public class Wallet {

    private int money = 0;

    public int getMoney() {
        return money;
    }

    public void add(int money) {
        this.money += money;
    }

    // returns the money removed from the wallet
    public int use(int money) {

        // exception case handling
        if (money > this.money) {
            int removedMoney = this.money;
            this.money = 0;
            return removedMoney;
        }

        // normal case
        this.money -= money;
        return money;

    }

    @Override
    public String toString() {
        return "Wallet{" +
                "money=" + money +
                '}';
    }
}
