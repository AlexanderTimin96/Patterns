package shop.product;

public abstract class Product {

    protected String name;
    protected final int price;
    protected final int rating;

    protected final Manufacturer manufacturer;

    public Product(int price, int rating, Manufacturer manufacturer) {
        this.price = price;
        this.rating = rating;
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }
}
