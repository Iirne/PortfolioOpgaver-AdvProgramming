package portfolioOpgave.Kompleksitet;

import java.util.*;

public class Opgave2 {

    public static void main(String[] args) {
        ArrayListVsLinkedList();
        ArrayListVsHashSet();
    }

    private static void ArrayListVsLinkedList(){
        int amount = 500000;
        ArrayList<Integer> arrayList = (ArrayList<Integer>) addDataToList(new ArrayList<Integer>(), amount);
        LinkedList<Integer> linkedList = (LinkedList<Integer>) addDataToList(new LinkedList<Integer>(), amount);

        System.out.println("Arraylists");
        testList(arrayList);

        System.out.println("LinkedList");
        testList(linkedList);
    }

    private static void testList(List<Integer> list){
        System.out.println("get");
        long start = System.currentTimeMillis();
        System.out.println(list.get((int)list.size()/2));
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();

        System.out.println("add");
        start = System.currentTimeMillis();
        list.add((int)list.size()/2,99);
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();

        System.out.println("remove");
        start = System.currentTimeMillis();
        list.remove((int)list.size()/2);
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();
    }

    private static void ArrayListVsHashSet(){
        int amount = 500000;
        ArrayList<Integer> arrayList = (ArrayList<Integer>) addDataToList(new ArrayList<Integer>(), amount);
        HashSet<Integer> hashset = (HashSet<Integer>) addDataToSet(new HashSet<Integer>(), amount);

        System.out.println("ArrayList");
        System.out.println("Contains");
        long start = System.currentTimeMillis();
        System.out.println(arrayList.contains((int)amount/2));
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();
        System.out.println("Does not Contains");
        start = System.currentTimeMillis();
        System.out.println(arrayList.contains((int)amount*2));
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();

        System.out.println("Hashset");
        System.out.println("Contains");
        start = System.currentTimeMillis();
        System.out.println(hashset.contains((int)amount/2));
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();
        System.out.println("Does not Contains");
        start = System.currentTimeMillis();
        System.out.println(hashset.contains((int)amount*2));
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();
    }


    public static List<Integer> addDataToList(List<Integer> list, int amount){
        for (int i = 0; i < amount; i++){
            list.add(amount-i);
        }
        return list;
    }

    public static Set<Integer> addDataToSet(Set<Integer> set, int amount){
        for (int i = 0; i < amount; i++){
            set.add(amount-i);
        }
        return set;
    }
}
