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

        return leftUnion;
    }

    public int[] merge (int[] leftArray, int[] rightArray){

        int count = 0;
        int [] temp = new int[rightArray.length + leftArray.length];

        for (int i = 0; i < rightArray.length; i++) {
            for (int j = 0; j <leftArray.length ; j++) {
                if(rightArray[i] == leftArray[j]){
                    temp[i]=rightArray[i];
                    count++;
                }
            }
        }

        int [] merge = new int[rightArray.length+leftArray.length - count];

        for (int i = 0; i < leftArray.length ; i++) {
            merge[i]= leftArray[i];
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
        for (int i = 0; i < merge.length ; i++) {
            for (int j = 0; j < temp2.length; j++) {
                if(merge[i] == 0){
                    merge[i] = temp2[a];
                    a++;}
            }
        }

        return merge;
    }

     public int[] innerUnion (int[] leftArray, int[] rightArray)
     {
         int count = 0;

         int [] temp = new int[rightArray.length + leftArray.length];


         for (int i = 0; i < rightArray.length; i++) {
             for (int j = 0; j <leftArray.length ; j++) {
                     if (leftArray[j] == rightArray[i]) {
                     temp[count] = leftArray[j];
                     count++;
                 }
             }
         }

         int counter2 = 0;

         int [] temp2 = new int[count];

         for (int i = count-1; i >= 0; i--) {
             for (int j = i-1; j >= 0; j--) {
                 if (temp[i] == temp[j])
                 {
                     temp2[count-counter2-1] = temp[i];
                     counter2++;
                 }
             }
         }

         int [] innerUnion = new int[count - counter2];

         int a = 0;
         for (int i = 0; i < innerUnion.length ; i++) {

                 if(temp2[i] == 0)
                 {
                     innerUnion[a] = temp[i];
                     a++;
                 }
         }

         return innerUnion;
     }

    public int [] outerUnion (int[] leftArray, int[] rightArray){

        int counter = 0;
        int [] temp = new int[leftArray.length + rightArray.length];
        for (int i = 0; i < leftArray.length ; i++) {
            for (int j = 0; j < rightArray.length; j++) {
                if(leftArray[i] == rightArray[j])
                {
                    temp[counter] = leftArray[i];
                    counter++;
                }
            }
        }

        int [] testOuterUnion = new int[rightArray.length + leftArray.length - counter];

        int[] temp2 = new int[leftArray.length];
        for (int i = 0; i < leftArray.length; i++) {
            for (int j = 0; j < counter ; j++) {
                 if (leftArray[i] == temp[j])
                 {
                      temp2[i] = leftArray[i];
                 }
            }
        }

        int counter2 = 0;
        for (int i = 0; i < temp2.length; i++) {
            if (temp2[i] == 0)
            {
               testOuterUnion[counter2] = leftArray[i];
                counter2++;
            }
        }

        int[] temp3 = new int[rightArray.length];
        for (int i = 0; i < rightArray.length; i++) {
            for (int j = 0; j < counter ; j++) {
                if (rightArray[i] == temp[j])
                {
                    temp3[i] = rightArray[i];
                }
            }
        }

        int counter3 = 0;
        for (int i = 0; i < temp3.length; i++) {
            if (temp3[i] == 0)
            {
                testOuterUnion[counter2 + counter3] = rightArray[i];
                counter3++;
            }
        }

        int [] outerUnion = new int[counter2 + counter3];

        System.arraycopy(testOuterUnion,0,outerUnion,0, outerUnion.length);

        return outerUnion;
    }

    public static void main(String[] args) {
        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        LeftUnion leftUnion1 = new LeftUnion();


        int [] res = {1, 5, 4, 23, 65, 32, 78,5,4,1,32,5};
        int [] res2 = {1,5,4,23,65,32,78,3,24,2,34,45};
        int [] res3 = {5,4,1,32};
        int [] res4 = {23,65,78,3,24,2,34,45};
        System.out.println(Arrays.equals(leftUnion1.leftUnion(leftArray, rightArray),res));
        System.out.println(Arrays.equals(leftUnion1.merge(leftArray, rightArray),res2));
        System.out.println(Arrays.equals(leftUnion1.innerUnion(leftArray, rightArray),res3));
        System.out.println(Arrays.equals(leftUnion1.outerUnion(leftArray, rightArray), res4));
    }
}
