package shop.filter;

import shop.product.Product;

import java.util.List;

public interface FilterbyPrice {
    List<Product> byPrice(List<Product> list, int price, Comparison comparison);
}
