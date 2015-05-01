

import common.Event;
import common.Person;
import common.TYPE_OF;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

//      HW1  Создайте Main class
//        - распечатайте в консоль все параметры которые передаются как параметры при запуске
//        - распечатай количество переданных параметров

//        for(String par : args)
//        {
//            System.out.println(par);
//        }
//        System.out.println(args.length);

//       HW5   - Переписать свой Pojo в соответствии Builder паттерну
//             - Написать метод  Type[] merge(Type[] leftArray, Type[] rightArray) в отдельном классе (ArrayHelper)
//             - Создать ServiceDelegate для ArrayHelper
//             - написать позитивные тесты
//             - добавить проверку для каждого common.Person на не пустой и не null name

        Person person = new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.DEVELOPER)
                .build();

        Person personCopy = new Person.Builder(person)
                .type(TYPE_OF.QA)
                .build();

        Person personCopy2 = new Person.Builder(person)
                .email("IamDir@gmail.com")
                .type(TYPE_OF.DIRECTOR)
                .build();

        Person personCopy3 = new Person.Builder(person)
                .firstName("Ivan")
                .type(TYPE_OF.QA)
                .build();

        ArrayList<Person> personsFirst = new ArrayList<>();
        personsFirst.add(person);
        personsFirst.add(personCopy);

        ArrayList<Person> personsSecond = new ArrayList<>();
        personsSecond.add(personCopy2);
        personsSecond.add(personCopy3);

        ArrayHelper helper = new ArrayHelper();

        ServiceDelegate delegate = new ServiceDelegate(helper);
        delegate.leftUnion(personsFirst, personsSecond);
        System.out.println();
        delegate.merge(personsFirst, personsSecond);
        System.out.println();
        delegate.innerUnion(personsFirst, personsSecond);
        System.out.println();
        delegate.outerUnion(personsFirst, personsSecond);


        Event event = new Event.Builder()
                .description("HW")
                .build();
        System.out.println(event);

    }
}