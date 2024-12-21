import java.util.Scanner;

class AyoMain {
    private int skor;
    private final Graph lokasiGraph;
    private final Stack jejakPerjalanan;
    private final TekaTeki tekaTeki;
    private static final int skor_max = 100;
    private static final int penalti = 30;
    private static final int skor_awal = 0;
    private String tersangkaTerpilih;

    public AyoMain() {
        lokasiGraph = new Graph();
        jejakPerjalanan = new Stack();
        tekaTeki = new TekaTeki();
        tersangkaTerpilih = null; 
        skor = skor_max;
    }
    public void startGame() {
        initializeGame();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nSkor : " + skor );
            System.out.println("╔══════════════════════════╗");
            System.out.println("║    Crime Solver Menu     ║");
            System.out.println("╠══════════════════════════╣");
            System.out.println("║ 1. Kunjungi Lokasi       ║");
            System.out.println("║ 2. Lihat Jejak Perjalanan║");
            System.out.println("║ 3. Lihat Semua Lokasi    ║");
            System.out.println("║ 4. Selesaikan Teka-Teki  ║");
            System.out.println("║ 5. Pilih Tersangka       ║");
            System.out.println("║ 6. Selesaikan Kasus      ║");
            System.out.println("║ 7. Keluar                ║");
            System.out.println("╚══════════════════════════╝");
            System.out.print("Pilihan Anda: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Pilih lokasi yang ingin dikunjungi:");
                    lokasiGraph.displayLoc();
                    System.out.print("Masukkan nama lokasi: ");
                    String visitLocation = scanner.nextLine();
                    Node lokasi = lokasiGraph.cariLokasi(visitLocation);
                    if (lokasi != null) {
                        jejakPerjalanan.push(visitLocation);
                        System.out.println("Kamu telah mengunjungi lokasi: " + visitLocation);
                        lokasi.displayClue();
                        lokasi.displayConnections(); 
                        mulaiPenyelidikan(lokasi); 
                    } else {
                        System.out.println("Lokasi tidak ditemukan!");
                        skor -= penalti;
                        if(gameOver()){
                            return;
                        }
                    }
                    break;
                case 2:
                    jejakPerjalanan.display(); 
                    break;
                case 3:
                    lokasiGraph.displayLoc(); 
                    break;
                case 4:
                    tekaTeki.solve(); 
                    break;
                case 5:
                    pilihTersangka(scanner);
                    break;
                case 6:
                    solveCase(scanner);
                    if(skor <= skor_awal){
                        running = false;
                    }    
                break;
                case 7:
                    running = false;
                    System.out.println("Terima kasih sudah bermain!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
    private void mulaiPenyelidikan(Node lokasi) {
        Scanner scanner = new Scanner(System.in);
        boolean selesai = false;
        boolean petunjukSudahDiperiksa = false;
    
        while (!selesai) {
            System.out.println("\n=== Penyelidikan di " + lokasi.name + " ===");
            System.out.println("1. Periksa petunjuk lebih detail");
            System.out.println("2. Kembali ke Menu Utama");
            //System.out.println("3. Kembali ke Menu Utama");
            System.out.print("Pilihan Anda: ");
    
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1:
                    if (petunjukSudahDiperiksa) {
                        System.out.println("Petunjuk tambahan ditemukan!");
                        tampilkanPetunjukTambahan(lokasi);
                    } else {
                        System.out.println("Memeriksa petunjuk lebih detail...");
                        lokasi.displayClue();
                        petunjukSudahDiperiksa = true; 
                    }
                    break;
                case 2:
                    selesai = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    private void tampilkanPetunjukTambahan(Node lokasi) {
        System.out.println("Petunjuk baru yang ditemukan: ");
        
        if (lokasi.name.equals("TKP")) {
            System.out.println("Tersangka A memiliki bekas luka di tangannya, yang mungkin terkait dengan noda darah di TKP.");
        } else if (lokasi.name.equals("Kamar Tersangka")) {
            System.out.println("Ada surat yang tergeletak di meja di kamar tersangka. Mungkin ini terkait dengan motif kejahatan.");
        } else if (lokasi.name.equals("Dapur")) {
            System.out.println("Tersangka A tampaknya sering berada di dapur. Ada noda yang belum kering di lantai.");
        } else if (lokasi.name.equals("Taman")) {
            System.out.println("Beberapa tanaman tampaknya baru dipindahkan, bisa jadi untuk menyembunyikan jejak.");
        } else if (lokasi.name.equals("Garasi")) {
            System.out.println("Ada bekas oli tumpah di lantai garasi. Mungkin mobil tersangka A digunakan untuk melarikan diri.");
        } else if (lokasi.name.equals("Gudang")) {
            System.out.println("Di gudang, ada petunjuk tambahan berupa barang yang terbalik. Mungkin ada sesuatu yang disembunyikan.");
        }
    }
    private void initializeGame() {
        lokasiGraph.addLokasi("TKP");
        lokasiGraph.addLokasi("Kamar Tersangka");
        lokasiGraph.addLokasi("Dapur");
        lokasiGraph.addLokasi("Taman");
        lokasiGraph.addLokasi("Garasi");
        lokasiGraph.addLokasi("Gudang");

        Node tKPLokasi = lokasiGraph.cariLokasi("TKP");
        if (tKPLokasi != null) {
            tKPLokasi.addClue("Sidik jari ditemukan di meja. Ada noda darah di lantai. Pelaku terindikasi A.");
        }
        Node kamarTersangka = lokasiGraph.cariLokasi("Kamar Tersangka");
        if (kamarTersangka != null) {
            kamarTersangka.addClue("Hasil DNA cocok dengan tersangka A. Ada jejak sepatu di karpet.");
        }
        Node dapur = lokasiGraph.cariLokasi("Dapur");
        if (dapur != null) {
            dapur.addClue("Saksi mendengar suara keras dari dapur pada malam kejadian.");
        }
        Node taman = lokasiGraph.cariLokasi("Taman");
        if (taman != null) {
            taman.addClue("Tersangka A sering terlihat di taman. Terdapat surat yang sobek.");
        }
        Node garasi = lokasiGraph.cariLokasi("Garasi");
        if (garasi != null) {
            garasi.addClue("Ada bekas ban mobil di tanah. Mobil tersangka A terparkir di sana.");
        }
        Node gudang = lokasiGraph.cariLokasi("Gudang");
        if (gudang != null) {
            gudang.addClue("Ada jejak kaki basah yang mengarah ke gudang. Ditemukan barang bukti di sana.");
        }
        lokasiGraph.connectLokasi("TKP", "Kamar Tersangka");
        lokasiGraph.connectLokasi("TKP", "Dapur");
        lokasiGraph.connectLokasi("TKP", "Taman");
        lokasiGraph.connectLokasi("Kamar Tersangka", "Garasi");
        lokasiGraph.connectLokasi("Taman", "Gudang");
        lokasiGraph.connectLokasi("Dapur", "Gudang");
        
    }
    private void solveCase(Scanner scanner) {
        System.out.println("\n=== Menyelesaikan Kasus ===");
        if (tersangkaTerpilih == null) {
            System.out.println("Tersangka belum dipilih. Silakan kunjungi lebih banyak lokasi untuk mendapatkan petunjuk.");
            skor -= penalti;
            if(gameOver()){
                return;
            }
            return;
        }
        System.out.println("Berdasarkan investigasi, sepertinya kamu mencurigai " + tersangkaTerpilih + " sebagai tersangka");

        String alibi = "";
        if (tersangkaTerpilih.equals("Tersangka A")) {
            alibi = "Tersangka A mengaku berada di rumah pada malam kejadian dan tidak meninggalkan rumah sama sekali.";
        } else if (tersangkaTerpilih.equals("Tersangka B")) {
            alibi = "Tersangka B mengaku berada di luar kota saat kejadian, dan ada bukti bahwa dia benar-benar berada di tempat lain.";
        } else if (tersangkaTerpilih.equals("Tersangka C")) {
            alibi = "Tersangka C mengaku tidur di kamar tidurnya pada malam kejadian, yang dapat dibuktikan oleh keluarganya.";
        }

        System.out.println("Alibi yang diberikan oleh tersangka: " + alibi);
        System.out.println("Apakah kamu yakin dia tersangkanya? (y/n): ");
        String pilihan = scanner.nextLine().toLowerCase();
        if(pilihan.equals("y")){
            if(tersangkaTerpilih.equals("Tersangka A")){
                System.out.println("Kamu benar pelakunya adalah tersangka A");
                skor += 20;
                System.out.println("\n==============================");
                System.out.println("     CONGRATULATIONS!         ");
                System.out.println("  You've solved the case!     ");
                System.out.println("==============================");
                System.out.println("   Well done, detective!      ");
                System.out.println("       Your score: " + skor);
                System.out.println("\nPress any key to exit...");
                return;
            }else{
                System.out.println("Kamu menuduh orang yang tidak bersalah.");
                skor -= penalti;
                if(gameOver()){
                    return;
                }
            }
        }else{
            System.out.println("Kamu menyerah pada penyilidikan ini");
            skor -= penalti;
        }
        System.out.println("Kasus sudah berakhir, skor akhirmu: " + skor);
        return;
    }
    private void pilihTersangka(Scanner scanner){
        System.out.println("\nSilahkan pilih orang yang kamu curigai");
        System.out.println("1. Tersangka A");
        System.out.println("2. Tersangka B");
        System.out.println("3. Tersangka C");

        System.out.print("Pilih nomor tersangka: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();
        
        switch (pilihan) {
            case 1:
                tersangkaTerpilih = "Tersangka A";
                break;
            case 2:
                tersangkaTerpilih = "Tersangka B";
                break;
            case 3:
                tersangkaTerpilih = "Tersangka C";
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }
        System.out.println("Kamu sepertinya mencurigai " + tersangkaTerpilih + " sebagai pelaku.");

        String alibi = "";
        if (tersangkaTerpilih.equals("Tersangka A")) {
            alibi = "Tersangka A mengaku berada di rumah pada malam kejadian dan tidak meninggalkan rumah sama sekali.";
        } else if (tersangkaTerpilih.equals("Tersangka B")) {
            alibi = "Tersangka B mengaku berada di luar kota saat kejadian, dan ada bukti bahwa dia benar-benar berada di tempat lain.";
        } else if (tersangkaTerpilih.equals("Tersangka C")) {
            alibi = "Tersangka C mengaku tidur di kamar tidurnya pada malam kejadian, yang dapat dibuktikan oleh keluarganya.";
        }

        System.out.println("Alibi " + tersangkaTerpilih + ": " + alibi);
    }
    private boolean gameOver(){
        if(skor <= skor_awal){
            System.err.println("\nGAME OVER!!!");
            System.out.println("Kamu kalah! Kasus tidak terpecahkan");
            return true;
        }
        return false;
    }
}