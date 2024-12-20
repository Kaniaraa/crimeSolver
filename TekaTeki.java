import java.util.Scanner;
class Teka {
    String clue;   // Clue atau petunjuk yang diberikan
    Teka opsi1;  // Pilihan pertama
    Teka opsi2;  // Pilihan kedua
    String opsi1Text;  // Teks untuk pilihan pertama
    String opsi2Text;  // Teks untuk pilihan kedua

    public Teka(String clue, String opsi1Text, String opsi2Text) {
        this.clue = clue;
        this.opsi1Text = opsi1Text;
        this.opsi2Text = opsi2Text;
        this.opsi1 = null;
        this.opsi2 = null;
    }
}
class TekaTeki {
    private final Teka root;  // Root dari teka-teki
    public TekaTeki() {
        // Menyusun teka-teki dengan pilihan
        root = new Teka(
            "Kamu menemukan sidik jari di tempat kejadian.",
            "Periksa sidik jarinya lebih lanjut.",
            "Periksa CCTV untuk petunjuk."
        );
        root.opsi1 = new Teka(
            "Sidik jari cocok dengan salah satu tersangka!",
            "Tanya tersangka apakah dia ada di TKP.",
            "Cari bukti lebih lanjut di lokasi."
        );   
        root.opsi2 = new Teka(
            "CCTV menunjukkan seseorang di sekitar lokasi kejadian.",
            "Periksa wajah orang tersebut.",
            "Cari petunjuk lain di lokasi."
        );
        // Pilihan lanjutan untuk opsi1
        root.opsi1.opsi1 = new Teka(
            "Wajah orang tersebut cocok dengan deskripsi saksi.",
            "Tanya orang tersebut.",
            "Periksa alibi orang tersebut."
        );
        root.opsi1.opsi2 = new Teka(
            "Tidak ada petunjuk lebih lanjut di lokasi.",
            "Periksa tempat lain.",
            "Lanjutkan penyelidikan."
        );
        root.opsi2.opsi1 = new Teka(  // Ini sebelumnya tertimpa oleh root.opsi1
            "Wajah orang tersebut cocok dengan deskripsi saksi.",
            "Tanya orang tersebut.",
            "Periksa alibi orang tersebut."
        );
        root.opsi2.opsi2 = new Teka(  // Ini sebelumnya tertimpa oleh root.opsi1
            "Tidak ada petunjuk lebih lanjut di lokasi.",
            "Periksa tempat lain.",
            "Lanjutkan penyelidikan."
        );
    }
    public void solve() {
        Scanner scanner = new Scanner(System.in);
        Teka current = root;  // Mulai dari pertanyaan pertama

        while (current.opsi1 != null || current.opsi2 != null) {
            System.out.println(current.clue);
            System.out.println("1. " + current.opsi1Text);
            System.out.println("2. " + current.opsi2Text);
            System.out.print("Pilih 1 atau 2: ");
            String jawaban = scanner.nextLine();

            if (jawaban.equals("1")) {
                current = current.opsi1; 
            } else if (jawaban.equals("2")) {
                current = current.opsi2;
            } else {
                System.out.println("Pilihan tidak valid, pilih 1 atau 2.");
            }
        }
        System.out.println(current.clue);
        System.out.println("Penyelidikan selesai!");
    }
}