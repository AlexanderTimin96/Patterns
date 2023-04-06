package shop.product;

import java.awt.*;

public class Pen extends Product {
    private String color;

    public Pen(int price, int rating, Manufacturer manufacturer, String  color) {
        super(price, rating, manufacturer);
        this.color = color;
        name = "Ручка";
    }

    @Override
    public String toString() {
        return name + " " + color + " - " + price + " руб." + " (" + manufacturer + "), рейтинг " + rating;
    }
}
