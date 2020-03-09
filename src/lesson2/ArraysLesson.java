package lesson2;

import java.util.Arrays;

public class ArraysLesson {
    public static void main(String[] args) {
        System.out.println("Arrays");
        int[] someArr ;
//        int someArr2[];
        someArr = new int[2];
        int[] someArr2 = {7,4,2, 1,3,-55};
//        System.out.println(Arrays.toString(someArr));
        System.out.println(Arrays.toString(someArr2));
        System.out.println(someArr2.length);
        System.out.println(someArr.length);
        System.out.println(someArr2[2]); //ArrayIndexOutOfBoundsException
        someArr2[2] = 456;
        System.out.println(Arrays.toString(someArr2));
        someArr2 = new int[]{23,1,-10,5};
        System.out.println(Arrays.toString(someArr2));
        for (int i = 0; i < someArr2.length; i++) {
            someArr2[i]*=2;
        }
        System.out.println(Arrays.toString(someArr2));
        for (int elem: someArr2){
            elem *=3;
            System.out.println(elem);
        }
        System.out.println(Arrays.toString(someArr2));

        someArr2 = new int[]{13,1,-10,51};
//        int[] arr = someArr2; // pointer
//        System.out.println(Arrays.toString(arr));
        int[] cloneArr = someArr2.clone();
        someArr = new int[40];
        System.arraycopy(someArr2, 1, someArr, 10, 3);
        System.out.println(Arrays.toString(someArr));
        int[] copyArr = Arrays.copyOf(someArr2, 1);
        System.out.println(Arrays.toString(copyArr));

        someArr = new int[]{23,1,-10,51};
        someArr2 = new int[]{23,1,-10,51};
        int[] arr = someArr2; // pointer
        System.out.println(Arrays.equals(someArr,someArr2));
        System.out.println(someArr2.equals(arr));
        int[] someArr3 = new int[someArr.length];
        for (int i = 0; i < someArr.length; i++) {
           someArr3[i]= someArr[i] +someArr2[i];
            System.out.println(someArr3[i]);
        }
        System.out.println(Arrays.toString(someArr3));

        someArr = new int[]{23,1,-10,51,7};
      //  Arrays.sort(someArr);
        System.out.println(Arrays.toString(someArr));
        System.out.println(Arrays.binarySearch(someArr, 7));
        int [] [] [] newArr = new int[2][3][4];
        int [][] newArr2 = {{1,2,3},{4,5},{6},{7,8}};
        System.out.println(Arrays.deepToString(newArr2));

        for (int i = 0; i < newArr2.length; i++) {
            for (int j = 0; j < newArr2[i].length; j++) {
                newArr2[i][j]*=newArr2[i][j];
            }
        }
        System.out.println(Arrays.deepToString(newArr2));
    }
}
