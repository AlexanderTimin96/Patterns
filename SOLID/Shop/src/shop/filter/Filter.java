package shop.filter;

import shop.product.Manufacturer;
import shop.product.Product;

import java.util.List;
import java.util.stream.Collectors;


public class Filter implements FilterbyPrice, FilterbyManufacturer, FilterByRating {
    @Override
    public List<Product> byPrice(List<Product> list, int price, Comparison comparison) {
        List<Product> result;

        if (Comparison.LESS == comparison) {
            int priceMod = price * (-1);
            result = list.stream()
                    .filter(product -> product.getPrice() <= priceMod)
                    .collect(Collectors.toList());
            return result;
        } else {
            result = list.stream()
                    .filter(product -> product.getPrice() >= price)
                    .collect(Collectors.toList());
            return result;
        }
    }

    public List<Product> byManufacturer(List<Product> list, Manufacturer manufacturer) {
        List<Product> result = list.stream()
                .filter(product -> product.getManufacturer() == manufacturer)
                .collect(Collectors.toList());
        return result;
    }

    public List<Product> byRating(List<Product> list) {
        List<Product> result = list.stream()
                .sorted(new ProductComporator())
                .collect(Collectors.toList());
        return result;
    }
}
