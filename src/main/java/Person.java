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
    private final int age;
    private final TYPE_OF type;


    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.type = builder.type;
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public TYPE_OF getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (type != person.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", age=" + age +
                ", type=" + type +
                '}';
    }

    public Person[] leftUnion(Person[] personFirst, Person[] personSecond){

        int count = 0;
        Person [] temp = new Person[personFirst.length+personSecond.length];
        for (int i = 0; i < personFirst.length; i++) {
            for (int j = 0; j <personSecond.length ; j++) {
                if (personFirst[j].equals(personSecond[i])) {
                    temp[count] = personFirst[j];
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(temp));
        System.out.println(count);

        Person [] leftUnion = new Person[personFirst.length + count];

        for (int i = 0; i < personFirst.length; i++) {
            leftUnion[i] = personFirst[i];

        }
        int conter = 0;
        for (int i = 0; i < leftUnion.length ; i++) {
            for (int j = 0; j < temp.length; j++) {
                if(leftUnion[i].equals(null)){
                    leftUnion[i] = temp[conter];
                    conter++;}
            }
        }

        System.out.println(Arrays.toString(leftUnion));

        return leftUnion;
    }

    public static class Builder {
        private  String firstName;
        private  String lastName;
        private  int age;
        private  TYPE_OF type;

        public Builder() {
        }

        public Builder(Person original) {
            this.firstName = original.firstName;
            this.lastName = original.lastName;
            this.age = original.age;
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

        public Builder age(int age) {
            this.age = age;
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