package shop.filter;

import shop.product.Manufacturer;
import shop.product.Product;

import java.util.List;

public interface FilterbyManufacturer {
    List<Product> byManufacturer(List<Product> list, Manufacturer manufacturer);
}
