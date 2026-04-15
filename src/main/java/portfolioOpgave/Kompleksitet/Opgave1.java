package portfolioOpgave.Kompleksitet;

import java.util.ArrayList;
import java.util.Arrays;

public class Opgave1 {
    public static void main(String[] args) {
        int n = 100000000;
        O1(n);
        On(n);
        OLogn(n);
        OnSquared(n);
    }

    private static void O1(int n){
        System.out.println("O(1)");
        int[] toGetfrom = getRandomArray(n);
        int randomNumber = (int) (Math.random() * n);

        long start = System.currentTimeMillis();

        System.out.println("random number: " + toGetfrom[randomNumber]);

        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();
    }

    private static void On(int n){
        System.out.println("O(n)");
        int[] toSearch = getRandomArray(n);
        int toFind = (int) (Math.random() * n);

        long start = System.currentTimeMillis();

        System.out.println("finding: " + toFind);
        Integer found = null;
        for (int i : toSearch){
            if (i == toFind){
                found = i;
            }
        }
        if (found != null){
            System.out.println("found: " + found);
        }
        else {
            System.out.println("didn't find anything");
        }

        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();
    }

    private static void OLogn(int n){
        System.out.println("O(Log(n))");
        int[] toSort = getRandomArray(n);

        long start = System.currentTimeMillis();

        Arrays.sort(toSort);

        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();
    }

    private static void OnSquared(int n){
        System.out.println("O(n^2)");
        int[] toCheckDoubles = getRandomArray(n);

        long start = System.currentTimeMillis();

        boolean hasDoubles = false;
        for (int i : toCheckDoubles){
            for (int j : toCheckDoubles){
                if(i == j) {
                    hasDoubles = true;
                    break;
                }
            }
            if(hasDoubles){
                break;
            }
        }

        System.out.println("does the list have doubles: " + hasDoubles);
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();
    }

    private static int[] getRandomArray(int n){
        int[] result = new int[n];
        for(int i = 0; i < result.length; i++){
            result[i] = (int) (Math.random() * n);
        }
        return result;
    }
}
