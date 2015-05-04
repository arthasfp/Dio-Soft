

import additional.ArrayHelper;
import additional.ServiceDelegate;
import common.Event;
import common.Person;
import common.TYPE_OF;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Main {

    public static final Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) {

        for(String par : args)
        {
            System.out.println(par);
        }
        System.out.println(args.length);

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


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        logger.info("Service activated");
    }
}







