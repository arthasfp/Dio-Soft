import java.util.Arrays;

public class ServiceDelegate {
private final ArrayHelper arrayHelper;

    public ServiceDelegate(ArrayHelper arrayHelper) {
        this.arrayHelper = arrayHelper;
    }

    public void leftUnion(Person[] personFirst, Person[] personSecond)
    {
        arrayHelper.leftUnion(personFirst, personSecond);
        System.out.println("Входные данные " + Arrays.toString(personFirst) + ", " + Arrays.toString(personSecond));
        System.out.println("Результат " + Arrays.toString(arrayHelper.leftUnion(personFirst, personSecond)) );

    }


}
