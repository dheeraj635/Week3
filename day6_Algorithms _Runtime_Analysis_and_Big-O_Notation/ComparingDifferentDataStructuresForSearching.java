import java.util.*;

public class ComparingDifferentDataStructuresForSearching {
    public static void main(String[] args) {
        int dataSize = 1_000_000;
        int searchElement = dataSize - 1;

        List<Integer> arrayList = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < dataSize; i++) {
            arrayList.add(i);
            hashSet.add(i);
            treeSet.add(i);
        }

        long start, end;

        start = System.nanoTime();
        arrayList.contains(searchElement);
        end = System.nanoTime();
        System.out.println("ArrayList search time: " + (end - start) + " ns");

        start = System.nanoTime();
        hashSet.contains(searchElement);
        end = System.nanoTime();
        System.out.println("HashSet search time: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.contains(searchElement);
        end = System.nanoTime();
        System.out.println("TreeSet search time: " + (end - start) + " ns");
    }
}
