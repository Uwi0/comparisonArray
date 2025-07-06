import java.util.Arrays;

public class ArrayOperations {

    private final String[] inventory;
    private int size;

    public ArrayOperations(int capacity) {
        inventory = new String[capacity];
        size = 0;
    }

    public void insert(String item, int index) {
        if (size >= inventory.length || index > size || index < 0) return;
        for (int i = size; i > index; i--) {
            inventory[i] = inventory[i - 1];
        }
        inventory[index] = item;
        size++;
    }

    public void delete(String item) {
        int index = searchLinear(item);
        if (index == -1) return;
        for (int i = index; i < size - 1; i++) {
            inventory[i] = inventory[i + 1];
        }
        inventory[size - 1] = null;
        size--;
    }

    public int searchLinear(String item) {
        for (int i = 0; i < size; i++) {
            if (inventory[i].equals(item)) return i;
        }
        return -1;
    }

    public int searchBinary(String item) {
        String[] copy = Arrays.copyOf(inventory, size);
        Arrays.sort(copy);
        return Arrays.binarySearch(copy, item);
    }

    public void traverse() {
        System.out.println("Array Inventory: " + Arrays.toString(Arrays.copyOf(inventory, size)));
    }
}
