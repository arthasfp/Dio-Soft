import java.util.Arrays;

//        HW2  *Переписано под Builder
//             Создайте POJO класс
//             Создайте POJO класс, поля которого являются final (Person)
//             Создайте Enum который характеризует экзмпляр POJO класса (Должность:DIRECTOR, DEVELOPER, QA)
//             Добавьте Enum как поле в POJO
//             Cгенерируйте equals/hashcode методы
//             Создайте Main класс, в main методе которого проведите сравнение экземпляров по ссылке и через метод equals

public class Person {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final TYPE_OF type;


    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.type = builder.type;
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public TYPE_OF getType() {
        return type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (email != null ? !email.equals(person.email) : person.email != null) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (type != person.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                '}';
    }

    public static class Builder {
        private  String firstName;
        private  String lastName;
        private  String email;
        private  TYPE_OF type;

        public Builder() {
        }

        public Builder(Person original) {
            this.firstName = original.firstName;
            this.lastName = original.lastName;
            this.email = original.email;
            this.type = original.type;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder type(TYPE_OF type) {
            this.type = type;
            return this;
        }

        public Person build()
        {
            return new Person(this);
        }

    }
}