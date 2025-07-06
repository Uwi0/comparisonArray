import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperations {
    private final ArrayList<String> inventory = new ArrayList<>();

    public void insert(String item, int index) {
        if (index >= 0 && index <= inventory.size()) {
            inventory.add(index, item);
        }
    }

    public void delete(String item) {
        inventory.remove(item);
    }

    public int search(String item) {
        return inventory.indexOf(item);
    }

    public int searchBinary(String item) {
        ArrayList<String> sorted = new ArrayList<>(inventory);
        Collections.sort(sorted);
        return Collections.binarySearch(sorted, item);
    }

    public void sort() {
        Collections.sort(inventory);
    }

    public void traverse() {
        System.out.println("ArrayList Inventory: " + inventory);
    }
}
