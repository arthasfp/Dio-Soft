
public class Main {
    public static void main(String[] args) {

//        Создайте Main class
//        - распечатайте в консоль все параметры которые передаются как параметры при запуске
//        - распечатай количество переданных параметров

        for (String par : args)
        {
            System.out.println(par);
        }
        System.out.println(args.length);

//        Создайте POJO класс
//        Создайте POJO класс, поля которого являются final (Person)
//                Создайте Enum который характеризует экзмпляр POJO класса (Должность:DIRECTOR, DEVELOPER, QA)
//        Добавьте Enum как поле в POJO
//        Cгенерируйте equals/hashcode методы
//        Создайте Main класс, в main методе которого проведите сравнение экземпляров по ссылке и через метод equals

        Person firstPerson = new Person("Jack", "London", 22, TYPE_OF.DEVELOPER);
        Person secondPerson = new Person("Jack", "London", 25, TYPE_OF.DEVELOPER);


        System.out.println(firstPerson);
        System.out.println(secondPerson);

        System.out.println("Are equals by '==': " + (firstPerson == secondPerson));
        System.out.println("Are equals by method equals: " + firstPerson.equals(secondPerson));

    }
}
