import java.util.ArrayList;
import java.util.Arrays;

public class ServiceDelegate {
private final ArrayHelper arrayHelper;

    public ServiceDelegate(ArrayHelper arrayHelper) {
        this.arrayHelper = arrayHelper;
    }

    public void leftUnion(ArrayList<Person> personFirst, ArrayList<Person> personSecond)
    {
        arrayHelper.leftUnion(personFirst, personSecond);
        System.out.println("Входные данные " + personFirst + ", " + personSecond);
        System.out.println("Результат " + arrayHelper.leftUnion(personFirst, personSecond) );

    }

    public void merge(ArrayList<Person> personFirst, ArrayList<Person> personSecond)
    {
        arrayHelper.merge(personFirst,personSecond);
        System.out.println("Входные данные " + personFirst + ", " + personSecond);
        System.out.println("Результат " + arrayHelper.merge(personFirst, personSecond) );
    }

    public void innerUnion (ArrayList<Person> personFirst, ArrayList<Person> personSecond)
    {
        arrayHelper.innerUnion(personFirst,personSecond);
        System.out.println("Входные данные " + personFirst + ", " + personSecond);
        System.out.println("Результат " + arrayHelper.innerUnion(personFirst, personSecond) );
    }

    public void outerUnion (ArrayList<Person> personFirst, ArrayList<Person> personSecond)
    {
        arrayHelper.outerUnion(personFirst,personSecond);
        System.out.println("Входные данные " + personFirst + ", " + personSecond);
        System.out.println("Результат " + arrayHelper.outerUnion(personFirst, personSecond) );
    }


}
