package energybills.domain.model;

import java.util.Objects;

public class Fare {

    private int price;
    private int monthNumber;

    public Fare(int price, int monthNumber) {
        this.price = price;
        this.monthNumber = monthNumber;
    }

    public int getPrice() {
        return price;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fare fare = (Fare) o;
        return price == fare.price &&
                monthNumber == fare.monthNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, monthNumber);
    }
}
