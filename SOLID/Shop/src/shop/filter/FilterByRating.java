package shop.filter;

import shop.product.Product;

import java.util.List;

public interface FilterByRating {
    public List<Product> byRating(List<Product> list);
}
