package portfolioOpgave.Sort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int n = 10000000;
        int[] array = getRandomArray(n);
/*
        System.out.println("Bubblesort");
        long start = System.currentTimeMillis();
        bubbleSort(array);
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println("is array sorted:" + isSorted(array));
        System.out.println();


*/
        array = getRandomArray(n);

        System.out.println("Mergesort");
        long start = System.currentTimeMillis();
        mergeSort(array);
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println("is array sorted:" + isSorted(array));
        System.out.println();
        array = getRandomArray(n);

        System.out.println("Quicksort");
        start = System.currentTimeMillis();
        quicksort(array,0,array.length-1);
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println("is array sorted:" + isSorted(array));
        System.out.println();

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
        //in cases of unequal lengths the right gets more
        //[0], [1, 2]
        int[] leftHalf = Arrays.copyOfRange(array,0,(array.length/2));
        int[] rightHalf = Arrays.copyOfRange(array,(array.length/2),array.length);

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        int l = 0, r=0;
        //if the right side  is counted only add left
        //if the left side isn't counted and the left half is smaller than the right half
        for(int i = 0; i < array.length; i++){
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

    private static int[] quicksort(int[] array, int low, int high){
        if (low >= high){
            return array;
        }

        int i = low, pivot = array[high];
        for(int j = low; j < high; j++){
            if(array[j]<pivot){
                Swap(array,i,j);
                i++;
            }
        }
        Swap(array,i,high);

        quicksort(array,low, i-1);
        quicksort(array, i+1, high);

        return array;
    }

    private static void Swap(int[] array,int i, int j){
        int carrier = array[j];
        array[j] = array[i];
        array[i] = carrier;
    }

    private static int[] getRandomArray(int n){
        int[] result = new int[n];
        for(int i = 0; i < result.length; i++){
            result[i] = (int) (Math.random() * n);
        }
        return result;
    }

    private static boolean isSorted(int[] toCheck){
        for(int i = 1; i < toCheck.length; i++){
            if (toCheck[i] < toCheck[i-1]){
                return false;
            }
        }
        return true;
    }
}
