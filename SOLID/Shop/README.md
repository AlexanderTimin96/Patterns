### Используемые принципы хорошего кода:

1. Single-responsibility principle - каждый класс выполняет только свои действия (Класс shop - занимается всеми действиями 
с продуктами, фильтруются продукты с помощью
отдельного класса Filter) - (Класс Filter, класс Shop - 17 строчка)
2. Магические числа не используются - используется products.size() (Magics) (Класс Shop - 40 строчка)
3. Все повторяющиеся действия вынесены в отдельные методы или циклы (DRY) (Класс Shop - 91, 101, 124 строчка)
4. Liskov substitution principle, Dependency inversion principle, Open-closed principle - класс Product абстрактный, все добавляемые продукты
наследуются и модифицируют/расширяют данный класс. При добавлении новых продуктов нет необходимости менять класс Product.
Все продукты (наследники Product(Pen, Ruller)) хранятся в списке, который принимает родителя - List<Product> (Класс Product, Pen, Ruller, 
Класс Shop - 15, 16)
5. Interface segregation principle - разделили большие интерефейсы на маленькие. Класс (Filter implements FilterbyPrice, FilterbyManufacturer, FilterByRating)


