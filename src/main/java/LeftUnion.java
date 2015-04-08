import java.util.Arrays;

public class LeftUnion {


    public int[] leftUnion(int[] leftArray, int[] rightArray){

        int count = 0;
        int [] temp = new int[rightArray.length+leftArray.length];
        for (int i = 0; i < rightArray.length; i++) {
            for (int j = 0; j <leftArray.length ; j++) {
                if (leftArray[j] == rightArray[i]) {
                    temp[count] = leftArray[j];
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(temp));
        System.out.println(count);

        int [] leftUnion = new int[leftArray.length + count];

        for (int i = 0; i < leftArray.length; i++) {
            leftUnion[i] = leftArray[i];

        }
        int s = 0;
        for (int i = 0; i < leftUnion.length ; i++) {
            for (int j = 0; j < temp.length; j++) {
                if(leftUnion[i] == 0){
                    leftUnion[i] = temp[s];
                    s++;}
            }
        }

        System.out.println(Arrays.toString(leftUnion));

        return leftUnion;
    }



    public int[] secondUnion(int[] leftArray, int[] rightArray){

        int count = 0;
        int [] temp = new int[rightArray.length + leftArray.length];


        for (int i = 0; i < rightArray.length; i++) {  /*3, 5, 24, 4, 1, 2, 34, 45, 32, 5*/
            for (int j = 0; j <leftArray.length ; j++) {  /*1, 5, 4, 23, 65, 32, 78*/
                if(rightArray[i] == leftArray[j]){
                    temp[i]=rightArray[i];
                    count++;
                }
            }
        }

        int [] secondUnion = new int[rightArray.length+leftArray.length - count];

        for (int i = 0; i < leftArray.length ; i++) {
            secondUnion[i]= leftArray[i];
        }

        int s = 0;
        int[] temp2 = new int[count];
        for (int i = 0; i < rightArray.length ; i++) {
            if(temp[i]== 0)
            {
                temp2[s] = rightArray[i];
                s++;
            }

        }

        int a = 0;
        for (int i = 0; i < secondUnion.length ; i++) {
            for (int j = 0; j < temp2.length; j++) {
                if(secondUnion[i] == 0){
                    secondUnion[i] = temp2[a];
                    a++;}
            }
        }

        System.out.println(Arrays.toString(temp));
        System.out.println(count);
//        System.out.println(Arrays.toString(temp2));





        System.out.println(Arrays.toString(secondUnion));

        return secondUnion;
    }


    public static void main(String[] args) {
        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        LeftUnion leftUnion1 = new LeftUnion();


        int [] res = {1, 5, 4, 23, 65, 32, 78,5,4,1,32,5};
        int [] res2 = {1,5,4,23,65,32,78,3,24,2,34,45};
        System.out.println(Arrays.equals(leftUnion1.leftUnion(leftArray, rightArray),res));
        System.out.println();
        System.out.println(Arrays.equals(leftUnion1.secondUnion(leftArray, rightArray),res2));
    }
}
