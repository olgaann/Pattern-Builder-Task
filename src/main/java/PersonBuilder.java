public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age = -1;
    protected String address;
    protected boolean isAgeSet = false;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        isAgeSet = true;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }


    public Person build() throws IllegalStateException, IllegalArgumentException {
        Person person;
        if (name == null || surname == null || name.isEmpty() || surname.isEmpty()) {
            throw new IllegalStateException("У человека обязательно должны быть имя и фамилия.");
        }
        if ((age < 0 || age > 150) && isAgeSet) {
            throw new IllegalArgumentException("Возраст человека должен быть от 0 до 150 лет.");
        }
        person = new Person(name, surname, age);
        person.setAddress(address);
        return person;
    }
}
