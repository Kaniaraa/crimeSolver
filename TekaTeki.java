import java.util.Scanner;

class TekaTeki {
    private final Teka root;  // Root dari pohon teka-teki
    // Konstruktor untuk mengatur pohon teka-teki
    public TekaTeki() {
        // Menyusun kata kata untuk pohon teka-teki
        root = new Teka("Apakah kamu menemukan sidik jari?");
        root.yesBranch = new Teka("Apakah sidik jarinya cocok dengan tersangka?");
        root.noBranch = new Teka("Ayo periksa CCTV");

        root.yesBranch.yesBranch = new Teka("Kamu benar! Pelakunya berhasil ditangkap!");
        root.yesBranch.noBranch = new Teka("Ayo cari petunjuk lain.");
        root.noBranch.yesBranch = new Teka("Ayo periksa wajah di CCTV sudah benar atau belum.");
        root.noBranch.noBranch = new Teka("Ayo lanjutkan penyelidikan di tempat lain.");
    }
    public void solve() {
        Scanner scanner = new Scanner(System.in);
        Teka current = root;  // Mulai dari pertanyaan pertama
        while (current.yesBranch != null || current.noBranch != null) {
            System.out.println(current.QnA);
            System.out.print("Jawab (Ya/Tidak): ");
            String jawaban = scanner.nextLine().toLowerCase();
            if (jawaban.equals("ya")) {
                current = current.yesBranch; 
            } else if (jawaban.equals("tidak")) {
                current = current.noBranch;
            } else {
                System.out.println("Jawab hanya dengan 'Ya' atau 'Tidak'.");
            }
        }
        System.out.println(current.QnA);
    }
}