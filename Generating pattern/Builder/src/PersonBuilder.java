public class PersonBuilder {
    protected String name = null;
    protected String surname = null;
    protected int age = -1;
    protected String address = null;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalStateException("Возраст должен быть от 0 до 100 лет!");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Фамилия или имя не заполнено!");
        }
        return new Person(name, surname, age, address);
    }
}
