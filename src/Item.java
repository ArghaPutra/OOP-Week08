public class Item {
    private String name;
    private String type;
    private int price; // pakai int agar tampil tanpa desimal

    public Item(String name, String type, int price) {
        this.name  = name;
        this.type  = type;
        this.price = price;
    }

    public String getName()  { return name; }
    public String getType()  { return type; }
    public int    getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("Nama  : %s%nTipe  : %s%nHarga : %d",
                name, type, price);
    }
}
