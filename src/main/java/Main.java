import com.diosoft.training.ArrayHelperForPrim;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

//      HW1  Создайте Main class
//        - распечатайте в консоль все параметры которые передаются как параметры при запуске
//        - распечатай количество переданных параметров

        for(String par : args)
        {
            System.out.println(par);
        }
        System.out.println(args.length);

//       HW5   - Переписать свой Pojo в соответствии Builder паттерну
//             - Написать метод  Type[] merge(Type[] leftArray, Type[] rightArray) в отдельном классе (ArrayHelper)
//             - Создать ServiceDelegate для ArrayHelper
//             - написать позитивные тесты
//             - добавить проверку для каждого Person на не пустой и не null name

        Person person = new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .age(20)
                .type(TYPE_OF.DEVELOPER)
                .build();

        Person personCopy = new Person.Builder(person)
                .type(TYPE_OF.QA)
                .build();

        Person personCopy2 = new Person.Builder(person)
                .age(34)
                .type(TYPE_OF.DIRECTOR)
                .build();

        Person personCopy3 = new Person.Builder(person)
                .firstName("Ivan")
                .type(TYPE_OF.QA)
                .build();

        System.out.println(person == personCopy);
        System.out.println(personCopy2.equals(personCopy3));



        Person [] personsFirst = {person, personCopy};
        Person [] personsSecond = {personCopy2, personCopy3};


        ArrayHelper helper = new ArrayHelper();

        ServiceDelegate delegate = new ServiceDelegate(helper);
        delegate.leftUnion(personsFirst, personsSecond);

    }
}