package org.academiadecodigo.bootcamp;

/**
 * Person Class
 */
public class Person {

    private String name;

    private PiggyBank piggyBank;
    private Wallet wallet;

    public Person(String name, PiggyBank piggyBank, Wallet wallet, int money) {

        this.name = name;
        this.piggyBank = piggyBank;
        this.wallet = wallet;

        wallet.add(money);

    }

    // returns amount of money spent
    public int spend(int money)  {
        return wallet.use(money);
    }

    public void fillWallet(int money) {
        wallet.add(piggyBank.withdraw(money));
    }

    public void saveMoney(int money) {
        piggyBank.deposit(wallet.use(money));
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", piggyBank=" + piggyBank +
                ", wallet=" + wallet +
                '}';
    }
}
