package portfolioOpgave.Sort;

import javax.print.DocFlavor;
import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int n = 100;
        int[] array = getRandomArray(n);

        //Arrays.stream(bubbleSort(array)).forEach(System.out::println);

        //array = getRandomArray(n);

        Arrays.stream(mergeSort(array)).forEach(System.out::println);

    }

    private static int[] bubbleSort(int[] array){
        for(int i = 0; i < array.length ; i++){
            for(int j = 1; j < array.length-i; j++){
                if(array[j-1]>array[j]){
                    int carrier = array[j];
                    array[j] = array[j-1];
                    array[j-1] = carrier;
                }
            }
        }
        return array;
    }

    private static int[] mergeSort(int[] array){
        if(array.length<2){
            return array;
        }

        //splits the array in 2 halves
        //in cases of unequal the left gets more
        //[0, 1], [2]
        int[] leftHalf = Arrays.copyOfRange(array,0,(int)(array.length/2));
        int[] rightHalf = Arrays.copyOfRange(array,(int)(array.length/2),array.length);

        leftHalf = mergeSort(leftHalf);
        rightHalf = mergeSort(rightHalf);

        int l = 0, r=0;

        for(int i = 0; i<array.length; i++){
            //&& r >= rightHalf.length  ) || leftHalf[l]<rightHalf[r]
            if(rightHalf.length <= r || (l < leftHalf.length && leftHalf[l]<rightHalf[r])){
                array[i] = leftHalf[l];
                l++;
            }else{
                array[i] = rightHalf[r];
                r++;
            }
        }

        return array;
    }



    private static int[] getRandomArray(int n){
        int[] result = new int[n];
        for(int i = 0; i < result.length; i++){
            result[i] = (int) (Math.random() * n);
        }
        return result;
    }
}
