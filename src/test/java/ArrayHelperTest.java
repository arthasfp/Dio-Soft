import common.Person;
import common.TYPE_OF;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;




public class ArrayHelperTest {


    @Test
    public void testLeftUnion() throws MyException
    {
//           initialize variable inputs
        ArrayList<Person> personsFirst = new ArrayList <>();

        personsFirst.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.DEVELOPER)
                .build()
        );

        personsFirst.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.QA)
                .build()
        );

        ArrayList<Person> personsSecond = new ArrayList <>();

        personsSecond.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamDir@gmail.com")
                .type(TYPE_OF.DIRECTOR)
                .build());

        personsSecond.add(new Person.Builder()
                .firstName("Ivan")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.QA)
                .build());


        ArrayList<Person> expectedValue = new ArrayList<>();
        expectedValue.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.DEVELOPER)
                .build());

        expectedValue.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.QA)
                .build());

//     initialize class to test
        ArrayHelper testClass = new ArrayHelper();
//     invoke method on class to test
        ArrayList<Person> returnedValue = testClass.leftUnion(personsFirst, personsSecond);
//     assert return value
        assertEquals(expectedValue, returnedValue);

    }



    @Test
    public void testMerge() throws MyException
    {
//           initialize variable inputs
        ArrayList<Person> personsFirst = new ArrayList <>();

        personsFirst.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.DEVELOPER)
                .build()
        );

        personsFirst.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.QA)
                .build()
        );

        ArrayList<Person> personsSecond = new ArrayList <>();

        personsSecond.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamDir@gmail.com")
                .type(TYPE_OF.DIRECTOR)
                .build());

        personsSecond.add(new Person.Builder()
                .firstName("Ivan")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.QA)
                .build());


        HashSet<Person> expectedValue = new HashSet<>();
        expectedValue.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.DEVELOPER)
                .build());

        expectedValue.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.QA)
                .build());

        expectedValue.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamDir@gmail.com")
                .type(TYPE_OF.DIRECTOR)
                .build());

        expectedValue.add(new Person.Builder()
                .firstName("Ivan")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.QA)
                .build());

//     initialize class to test
        ArrayHelper testClass = new ArrayHelper();
//     invoke method on class to test

//     assert return value
        assertEquals(expectedValue, testClass.merge(personsFirst, personsSecond));

    }

    @Test
    public void testInnerUnion() throws MyException
    {
//           initialize variable inputs
        ArrayList<Person> personsFirst = new ArrayList <>();

        personsFirst.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.DEVELOPER)
                .build()
        );

        personsFirst.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.QA)
                .build()
        );

        ArrayList<Person> personsSecond = new ArrayList <>();

        personsSecond.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamDir@gmail.com")
                .type(TYPE_OF.DIRECTOR)
                .build());

        personsSecond.add(new Person.Builder()
                .firstName("Ivan")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.QA)
                .build());


        HashSet<Person> expectedValue = new HashSet<>();
//     initialize class to test
        ArrayHelper testClass = new ArrayHelper();
//     invoke method on class to test

//     assert return value
        assertEquals(expectedValue, testClass.innerUnion(personsFirst, personsSecond));

    }

    @Test
    public void testOuterUnion() throws MyException
    {
//           initialize variable inputs
        ArrayList<Person> personsFirst = new ArrayList <>();

        personsFirst.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.DEVELOPER)
                .build()
        );

        personsFirst.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.QA)
                .build()
        );

        ArrayList<Person> personsSecond = new ArrayList <>();

        personsSecond.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamDir@gmail.com")
                .type(TYPE_OF.DIRECTOR)
                .build());

        personsSecond.add(new Person.Builder()
                .firstName("Ivan")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.QA)
                .build());


        HashSet<Person> expectedValue = new HashSet<>();
        expectedValue.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.DEVELOPER)
                .build());

        expectedValue.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.QA)
                .build());

        expectedValue.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .email("IamDir@gmail.com")
                .type(TYPE_OF.DIRECTOR)
                .build());

        expectedValue.add(new Person.Builder()
                .firstName("Ivan")
                .lastName("Donald")
                .email("IamJack@gmail.com")
                .type(TYPE_OF.QA)
                .build());

//     initialize class to test
        ArrayHelper testClass = new ArrayHelper();
//     invoke method on class to test

//     assert return value
        assertEquals(expectedValue, testClass.outerUnion(personsFirst, personsSecond));

    }
}
