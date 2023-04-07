package shop;

import shop.filter.Comparison;
import shop.filter.Filter;
import shop.product.Manufacturer;
import shop.product.Pen;
import shop.product.Product;
import shop.product.Ruller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    private List<Product> products = new ArrayList<>();
    private final List<Product> basket = new ArrayList<>();
    private final Filter filter = new Filter();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в онлайн магазин канцтоваров! \n"
                + "Доступные товары для покупки магазина:");
        fillProduct();
        printProducts(products);
        while (true) {
            int answer2 = -1;
            System.out.println("МЕНЮ: \n"
                    + "Для завершения покупок введите 0 \n"
                    + "Для покупки товара введите 1 \n"
                    + "Для сортировки товаров введите 2 \n"
                    + "Для вывода товаров в корзине введите 3 \n"
                    + "Для вывода всех товаров введите 4 \n");
            int answer = parseToInt(scanner, 4);
            if (answer == 0) {
                buy(basket);
                break;
            } else if (answer == 1) {
                while (true) {
                    System.out.println("Для добавления товара в корзину введите его номер, для выхода в меню введите 0");
                    answer2 = parseToInt(scanner, products.size());
                    if (answer2 == 0) {
                        break;
                    } else {
                        basket.add(products.get(answer2 - 1));
                    }
                }
            } else if (answer == 2) {
                while (answer2 != 0) {
                    System.out.println("Для выхода в меню введите 0 \n"
                            + "Для сортировке по рейтингу введите 1 \n"
                            + "Для сортировки товаров по цене введите 2 \n");
                    answer2 = parseToInt(scanner, 3);
                    if (answer2 == 1) {
                        products = filter.byRating(products);
                        printProducts(products);
                    } else if (answer2 == 2) {
                        System.out.println("Введите сумму для фильтрации: \n"
                                + "(положительное сумма выведет все товары превышающую сумму, \n"
                                + "отрицательное отрицательное выведет все товары не превышающую сумму) \n");
                        int sum = scanner.nextInt();
                        if (sum <= 0) {
                            products = filter.byPrice(products, sum, Comparison.LESS);
                            printProducts(products);
                        } else if (sum > 0) {
                            products = filter.byPrice(products, sum, Comparison.MORE);
                            printProducts(products);
                        }
                    }
                }
            } else if (answer == 3) {
                System.out.println("В вашей корзине:");
                printProducts(basket);
            } else {
                products.clear();
                fillProduct();
                printProducts(products);
            }
        }
        scanner.close();
    }

    private void printProducts(List<Product> products) {
        if (products.size() == 0) {
            System.out.println("Таких товаров нет! Выйдите в меню введя 0");
        } else {
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i));
            }
        }
        System.out.println();
    }

    private void fillProduct() {
        products.add(new Pen(15, 2, Manufacturer.USA, "зеленая"));
        products.add(new Pen(10, 5, Manufacturer.RUSSIA, "синяя"));
        products.add(new Pen(45, 3, Manufacturer.ENGLAND, "синяя"));
        products.add(new Ruller(90, 4, Manufacturer.ENGLAND, 30));
        products.add(new Ruller(150, 6, Manufacturer.ENGLAND, 45));
        products.add(new Ruller(50, 1, Manufacturer.RUSSIA, 30));
    }

    private int parseToInt(Scanner scanner, int quantity) {
        List<Integer> variants = new ArrayList<>();
        int result;
        for (int i = 0; i <= quantity; i++) {
            variants.add(i);
        }
        while (true) {
            scanner = new Scanner(System.in);
            String stringAnswer = scanner.nextLine();
            try {
                result = Integer.parseInt(stringAnswer);
                if (variants.contains(result))
                    break;
                else {
                    System.out.println("Такого варианта ответа нет! Попробуйте снова:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Надо вводить число! Попробуйте снова:");
            }
        }
        return result;
    }

    private void buy(List<Product> basket) {
        System.out.println("В вашей корзине:");
        printProducts(basket);
        int sum = 0;
        for (Product product : basket) {
            sum += product.getPrice();
        }
        System.out.println("ИТОГО: " + sum + " руб.");
    }
}
