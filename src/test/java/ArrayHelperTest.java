import static junit.framework.Assert.assertEquals;
import org.junit.Test;

import java.util.ArrayList;

public class ArrayHelperTest {

    @Test
    public void testLeftUnion() throws MyException
    {
//           initialize variable inputs
        ArrayList<Person> personsFirst = new ArrayList <>();

        personsFirst.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .age(20)
                .type(TYPE_OF.DEVELOPER)
                .build()
        );

        personsFirst.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .age(20)
                .type(TYPE_OF.QA)
                .build()
        );

        ArrayList<Person> personsSecond = new ArrayList <>();

        personsSecond.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .age(34)
                .type(TYPE_OF.DIRECTOR)
                .build());

        personsSecond.add(new Person.Builder()
                .firstName("Ivan")
                .lastName("Donald")
                .age(20)
                .type(TYPE_OF.QA)
                .build());


        ArrayList<Person> expectedValue = new ArrayList<>();
        expectedValue.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .age(20)
                .type(TYPE_OF.DEVELOPER)
                .build());

        expectedValue.add(new Person.Builder()
                .firstName("Jack")
                .lastName("Donald")
                .age(20)
                .type(TYPE_OF.QA)
                .build());

//     initialize class to test
         ArrayHelper testClass = new ArrayHelper();
//     invoke method on class to test
        ArrayList<Person> returnedValue = testClass.leftUnion(personsFirst, personsSecond);
//     assert return value
        assertEquals(expectedValue, returnedValue);

    }
}
