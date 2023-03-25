
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Старт программы");

        logger.log("Приветствие пользователя");
        System.out.println("Добрый день!");

        logger.log("Создаем переменную для хранения размера длинны списка");
        int numSize = -1;

        logger.log("Создаем переменную для хранения максимального значения списка");
        int maxValue;

        logger.log("Создаем переменную для хранения порога фильтрации");
        int treshold;

        logger.log("Создаем сканер");
        Scanner scanner = new Scanner(System.in);

        logger.log("Запускаем цикл вводы размера списка");
        while (numSize <= 0) {
            try {
                logger.log("Просим ввести пользователя размер списка");
                System.out.println("Введите размер списка:");

                String inSize = scanner.nextLine();
                logger.log("Читаем строку веденную пользователем");

                logger.log("Парсим строку веденную пользователем");
                numSize = Integer.parseInt(inSize);

                if (numSize <= 0) {
                    logger.log("Выводим ошибку о недопустимости числового значения для размера списка");
                    System.out.println("Размер списка должен быть больше нуля!");
                }
            } catch (RuntimeException e) {
                logger.log("Выводим ошибку о нечисловом вводе размера списка");
                System.out.println("Неправильно введены данные! Размер списка должен быть числом!");
            }
        }

        logger.log("Запускаем цикл вводы максимального значения списка");
        while (true) {
            try {
                logger.log("Просим ввести пользователя максимального значения списка");
                System.out.println("Введите размер максимального значения списка:");

                String stringMaxValue = scanner.nextLine();
                logger.log("Читаем строку веденную пользователем");

                logger.log("Парсим строку веденную пользователем");
                maxValue = Integer.parseInt(stringMaxValue);
                break;

            } catch (RuntimeException e) {
                logger.log("Выводим ошибку о нечисловом вводе максимального значения списка");
                System.out.println("Неправильно введены данные! Максимальное значения должно быть числом!");
            }
        }

        logger.log("Создаем список");
        List<Integer> list = new ArrayList<>();
        logger.log("Заполняем список случайными значениями");
        for (int i = 0; i < numSize; i++) {
            list.add(new Random().nextInt(maxValue));
        }
        System.out.println(list);

        logger.log("Запускаем цикл вводы порога фильтрации списка");
        while (true) {
            try {
                logger.log("Просим ввести пользователя порог фильтрации списка");
                System.out.println("Введите размер порога фильтрации списка:");

                String stringTreshold = scanner.nextLine();
                logger.log("Читаем строку веденную пользователем");

                logger.log("Парсим строку веденную пользователем");
                treshold = Integer.parseInt(stringTreshold);
                break;

            } catch (RuntimeException e) {
                logger.log("Выводим ошибку о нечисловом вводе порога фильтрации списка");
                System.out.println("Неправильно введены данные! Порог фильтрации должен быть числом!");
            }
        }
        Filter filter = new Filter(treshold);
        List<Integer> result = filter.filterOut(list);

        logger.log("Выводим отфильтрованный список");
        System.out.println(result);
    }
}