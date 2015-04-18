import java.util.Arrays;

// ResourceForDelegation

public class ArrayHelper {


    public Person[] leftUnion(Person[] personFirst, Person[] personSecond){

        int count = 0;
        Person[] temp = new Person[personFirst.length+personSecond.length];
        for (int i = 0; i < personFirst.length; i++) {
            for (int j = 0; j <personSecond.length ; j++) {
                if (personFirst[j].equals(personSecond[i])) {
                    temp[count] = personFirst[j];
                    count++;
                }
            }
        }
//        System.out.println(Arrays.toString(temp));
//        System.out.println(count);

        Person[] leftUnion = new Person[personFirst.length + count];

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

//        System.out.println(Arrays.toString(leftUnion));
        return leftUnion;
    }


}