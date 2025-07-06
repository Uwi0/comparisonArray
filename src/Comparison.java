import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparison {
    public static void main(String[] args) {
        int dataSize = 1000;
        List<String> testItems = new ArrayList<>();
        for (int i = 0; i < dataSize; i++) {
            testItems.add("Item" + i);
        }
        Collections.shuffle(testItems);

        ArrayOperations arrayOps = new ArrayOperations(dataSize);
        ArrayListOperations arrayListOps = new ArrayListOperations();

        long start, end;

        start = System.nanoTime();
        for (int i = 0; i < dataSize; i++) {
            arrayOps.insert(testItems.get(i), i);
        }
        end = System.nanoTime();
        System.out.println("Array Insertion Time: " + (end - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < dataSize; i++) {
            arrayListOps.insert(testItems.get(i), i);
        }
        end = System.nanoTime();
        System.out.println("ArrayList Insertion Time: " + (end - start) + " ns");

        start = System.nanoTime();
        int indexArray = arrayOps.searchLinear("Item500");
        end = System.nanoTime();
        System.out.println("Array Linear Search Time: " + (end - start) + " ns, found at index " + indexArray);

        start = System.nanoTime();
        int indexList = arrayListOps.search("Item500");
        end = System.nanoTime();
        System.out.println("ArrayList Search Time: " + (end - start) + " ns, found at index " + indexList);

        start = System.nanoTime();
        int binaryIndexArray = arrayOps.searchBinary("Item500");
        end = System.nanoTime();
        System.out.println("Array Binary Search Time: " + (end - start) + " ns, index = " + binaryIndexArray);

        start = System.nanoTime();
        int binaryIndexList = arrayListOps.searchBinary("Item500");
        end = System.nanoTime();
        System.out.println("ArrayList Binary Search Time: " + (end - start) + " ns, index = " + binaryIndexList);

        start = System.nanoTime();
        arrayOps.delete("Item500");
        end = System.nanoTime();
        System.out.println("Array Deletion Time: " + (end - start) + " ns");

        start = System.nanoTime();
        arrayListOps.delete("Item500");
        end = System.nanoTime();
        System.out.println("ArrayList Deletion Time: " + (end - start) + " ns");

        arrayOps.traverse();
        arrayListOps.traverse();
    }
}