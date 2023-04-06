package shop.product;

public class Ruller extends Product {
    private int lenght;

    public Ruller(int price, int rating, Manufacturer manufacturer, int lenght) {
        super(price, rating, manufacturer);
        this.lenght = lenght;
        name = "Линейка";
    }

    @Override
    public String toString() {
        return name + " " + lenght + "см. - " + price + " руб." + " (" + manufacturer + "), рейтинг " + rating;
    }
}
