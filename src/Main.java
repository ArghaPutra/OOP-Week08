import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Item>    ListOfItems    = new ArrayList<>();
    static ArrayList<Payment> ListOfPayments = new ArrayList<>();
    static Scanner s = new Scanner(System.in);

    public static void seedData() {
        ListOfItems.add(new Item("Kulkas", "Elektronik",  4800000));
        ListOfItems.add(new Item("TV",     "Elektronik", 12800000));
        ListOfItems.add(new Item("Laptop", "Komputer",    6000000));
        ListOfItems.add(new Item("PC",     "Komputer",   12000000));
    }

    public static void printItem(Item item) {
        System.out.println("Nama  : " + item.getName());
        System.out.println("Tipe  : " + item.getType());
        System.out.println("Harga : " + item.getPrice());
    }

    public static int readInt() {
        while (!s.hasNextInt()) {
            s.nextLine();
            System.out.print("Masukkan angka: ");
        }
        int v = s.nextInt(); s.nextLine();
        return v;
    }

    public static void main(String[] args) {
        int opt = 0;
        seedData();
        do {
            System.out.println("----Program Toko Elektronik----");
            System.out.println("1. Pesan Barang");
            System.out.println("2. Lihat Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");
            opt = readInt();

            if (opt == 1) {
                System.out.println("----Daftar Barang----");
                for (int i = 0; i < ListOfItems.size(); i++) {
                    System.out.println("No  : " + (i + 1));
                    printItem(ListOfItems.get(i));
                    System.out.println("------------------------------");
                }
                System.out.print("Pilih : ");
                int pilih = readInt();
                if (pilih < 1 || pilih > ListOfItems.size()) {
                    System.out.println("Salah Input");
                    continue;
                }

                Item chosen = ListOfItems.get(pilih - 1);

                System.out.print("Metode (C)ash / (K)redit : ");
                String m = s.nextLine().trim().toLowerCase();

                if (m.equals("c")) {
                    Cash pay = new Cash(chosen);
                    int dibayar = pay.pay();
                    ListOfPayments.add(pay);
                    System.out.println("Metode   : CASH");
                    System.out.println("Dibayar  : " + dibayar);
                    System.out.println("Status   : " + pay.getStatus());
                } else if (m.equals("k")) {
                    System.out.print("Masukkan jumlah cicilan (misal 6): ");
                    int tenor = Math.max(1, readInt());
                    Credit pay = new Credit(chosen, tenor);
                    int cicilanPertama = pay.pay();  // langsung bayar cicilan pertama
                    ListOfPayments.add(pay);
                    System.out.println("Metode          : CREDIT");
                    System.out.println("Cicilan pertama : " + cicilanPertama);
                    System.out.println("Sisa            : " + pay.getRemainingAmount());
                    System.out.println("Status          : " + pay.getStatus());
                } else {
                    System.out.println("Salah Input");
                }

            } else if (opt == 2) {
                if (ListOfPayments.isEmpty()) {
                    System.out.println("(Belum ada pesanan)");
                } else {
                    System.out.println("----Daftar Pesanan----");
                    for (int i = 0; i < ListOfPayments.size(); i++) {
                        Payment p = ListOfPayments.get(i);
                        String jenis = (p instanceof Cash) ? "CASH" : "CREDIT";
                        System.out.println("No  : " + (i + 1));
                        System.out.println("Nama  : " + p.getItemName());
                        System.out.println("Jenis : " + jenis);
                        System.out.println("Status: " + p.getStatus());
                        System.out.println("Sisa  : " + p.getRemainingAmount());
                        System.out.println("------------------------------");
                    }
                }

            } else if (opt == 0) {
                System.out.println("Terima Kasih");
            } else {
                System.out.println("Salah Input");
            }
        } while (opt != 0);
    }
}
