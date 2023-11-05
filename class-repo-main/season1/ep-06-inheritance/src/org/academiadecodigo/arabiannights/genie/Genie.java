package org.academiadecodigo.arabiannights.genie;

/**
 * Class with some common Genie behaviour
 * NOT MEANT to be instantiated
 */
public class Genie {

    private int wishLimit;
    private int grantedWishes;

    /**
     * Genius Constructor
     * @param wishLimit Maximum number of wishes the genius grants
     */
    Genie(int wishLimit) {
        this.wishLimit = wishLimit;
    }

    public int getWishLimit() {
        return wishLimit;
    }

    public int getGrantedWishes() {
        return grantedWishes;
    }

    /**
     * Calculates the number wishes the Genie can still grant
     * @return number of remaining wishes
     */
    public int getRemainingWishes() {
        int remaining = getWishLimit() - getGrantedWishes();
        return remaining >= 0 ? remaining : 0;
    }

    /**
     * Verifies if this genie has wishes left to grant
     * @return true if genie still has wishes to grant
     */
    public boolean hasWishesLeft() {
        return getRemainingWishes() > 0;
    }

    /**
     * Actual wish granting
     */
    private void doGrantWish() {
        this.grantedWishes++;
        System.out.println("Wish granted by " + this.getClass().getSimpleName());
    }

    /**
     * Request a wish from the Genie
     * @return if the wish was granted or not
     */
    public boolean grantWish() {

        if (!hasWishesLeft()) {
            return false;
        }

        doGrantWish();
        return true;

    };

    /**
     * Obtain the status of the Genie
     * @return the current Genie status
     */
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append(" has granted ");
        stringBuilder.append(getGrantedWishes());
        stringBuilder.append(" and still has ");
        stringBuilder.append(getRemainingWishes());
        stringBuilder.append(" to grant.");

        return stringBuilder.toString();

    };

}
