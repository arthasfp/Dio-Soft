
public class Person {
   private final String FirstName;
   private final String LastName;
   private final int age;
   private final TYPE_OF type;

    public Person(String firstName, String lastName, int age, TYPE_OF type) {
        FirstName = firstName;
        LastName = lastName;
        this.age = age;
        this.type = type;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
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
        if (FirstName != null ? !FirstName.equals(person.FirstName) : person.FirstName != null) return false;
        if (LastName != null ? !LastName.equals(person.LastName) : person.LastName != null) return false;
        if (type != person.type) return false;

        return true;
    }

    @Override
        public int hashCode() {
        int result = FirstName != null ? FirstName.hashCode() : 0;
        result = 31 * result + (LastName != null ? LastName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", age=" + age +
                ", type=" + type +
                '}';
    }
}
