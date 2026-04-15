package portfolioOpgave.Kompleksitet;

import java.util.*;

public class Opgave2 {

    public static void main(String[] args) {
        ArrayListVsLinkedList();
        ArrayListVsHashSet();
        HashSetVsTreeSet();
    }

    private static void ArrayListVsLinkedList(){
        int amount = 500000;
        ArrayList<Integer> arrayList = (ArrayList<Integer>) addDataToList(new ArrayList<>(), amount);
        LinkedList<Integer> linkedList = (LinkedList<Integer>) addDataToList(new LinkedList<>(), amount);

        System.out.println("Arraylists");
        testList(arrayList);

        System.out.println("LinkedList");
        testList(linkedList);
    }

    private static void testList(List<Integer> list){
        System.out.println("get");
        long start = System.currentTimeMillis();
        System.out.println(list.get(list.size()/2));
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();

        System.out.println("add");
        start = System.currentTimeMillis();
        list.add(list.size()/2,99);
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();

        System.out.println("remove");
        start = System.currentTimeMillis();
        list.remove(list.size()/2);
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();
    }

    private static void ArrayListVsHashSet(){
        int amount = 500000;
        ArrayList<Integer> arrayList = (ArrayList<Integer>) addDataToList(new ArrayList<>(), amount);
        HashSet<Integer> hashset = (HashSet<Integer>) addDataToSet(new HashSet<>(), amount);

        System.out.println("ArrayList");

        System.out.println("Contains");
        long start = System.currentTimeMillis();
        System.out.println(arrayList.contains(amount/2));
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();

        System.out.println("Does not Contains");
        start = System.currentTimeMillis();
        System.out.println(arrayList.contains(amount*2));
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();

        System.out.println("Hashset");

        System.out.println("Contains");
        start = System.currentTimeMillis();
        System.out.println(hashset.contains(amount/2));
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();

        System.out.println("Does not Contains");
        start = System.currentTimeMillis();
        System.out.println(hashset.contains(amount*2));
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();
    }

    private static void HashSetVsTreeSet() {
        int amount = 500000;
        TreeSet<ComparableDummy> treeset = (TreeSet<ComparableDummy>) addComparableDataToSet(new TreeSet<>(), amount);
        HashSet<ComparableDummy> hashset = (HashSet<ComparableDummy>) addComparableDataToSet(new HashSet<>(), amount);

        int repeatCount = 100000;

        System.out.println("treeset");
        testSet(treeset,repeatCount);
        System.out.println("hashset");
        testSet(hashset,repeatCount);
    }

    private static void testSet(Set<ComparableDummy> set, int n){
        System.out.println("adding to set");
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++){
            set.add(new ComparableDummy((int) (Math.random()*n)));
        }
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();

        System.out.println("removing from set");
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++){
            set.add(new ComparableDummy((int) (Math.random()*set.size())));
        }
        System.out.println("ms: " + (System.currentTimeMillis() - start));
        System.out.println();

        System.out.println("finding in set");
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++){
            set.add(new ComparableDummy((int) (Math.random()*set.size())));
        }
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

    public static Set<ComparableDummy> addComparableDataToSet(Set<ComparableDummy> set, int amount){
        for (int i = 0; i < amount; i++){
            set.add(new ComparableDummy(i));
        }
        return set;
    }
}
