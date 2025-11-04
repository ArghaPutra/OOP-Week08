public class Credit extends Payment {
    private int installment;            // cicilan yang sudah dibayar
    private int maxInstallmentAmount;   // total banyak cicilan (misal 6)

    public Credit(Item item, int maxInstallmentAmount) {
        super(item);
        this.maxInstallmentAmount = maxInstallmentAmount;
        this.installment = 0;           // awalnya belum ada cicilan
    }

    // bayar 1 kali cicilan; kembalikan nominal yang harus dibayar untuk cicilan ini
    @Override
    public int pay() {
        if (isPaidOff) return 0;

        int perCicilan = item.getPrice() / maxInstallmentAmount;
        installment++;

        if (installment >= maxInstallmentAmount) {
            isPaidOff = true;
        }
        return perCicilan;
    }

    public String getClassName() {
        return "CREDIT";
    }

    @Override
    public int getRemainingAmount() {
        if (isPaidOff) return 0;

        int perCicilan = item.getPrice() / maxInstallmentAmount;
        int sudahDibayar = perCicilan * installment;
        int sisa = item.getPrice() - sudahDibayar;
        // kalau ada pembulatan, jangan negatif
        return Math.max(0, sisa);
    }
}
