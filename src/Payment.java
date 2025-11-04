import java.util.ArrayList;
import java.util.List;

public class Payment {
    protected List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        if (item != null) items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotal() {
        return items.stream().mapToDouble(i -> i.getPrice() * 1.0).sum();
    }

    public void printBill() {
        System.out.println("===== BILL =====");
        for (Item i : items) {
            System.out.printf("%s x%d @ %.0f = %.0f%n",
                    i.getName(), 1, (double) i.getPrice(), (double) i.getPrice());
        }
        System.out.printf("TOTAL: %.0f%n", getTotal());
    }
}
