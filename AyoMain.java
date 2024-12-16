import java.util.Scanner;

class AyoMain {
    private final Graph lokasiGraph;
    private final Stack jejakPerjalanan;
    private final TekaTeki tekaTeki;
    public AyoMain() {
        lokasiGraph = new Graph();
        jejakPerjalanan = new Stack();
        tekaTeki = new TekaTeki();
    }
    public void startGame() {
        initializeGame();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n=== Crime Solver Menu ===");
            System.out.println("1. Tambahkan Lokasi");
            System.out.println("2. Kunjungi Lokasi");
            System.out.println("3. Lihat Jejak Perjalanan");
            System.out.println("4. Lihat Semua Lokasi");
            System.out.println("5. Selesaikan Teka-Teki");
            System.out.println("6. Keluar");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama lokasi baru: ");
                    String newLocation = scanner.nextLine();
                    lokasiGraph.addLokasi(newLocation);
                    break;

                case 2:
                    System.out.print("Masukkan nama lokasi yang ingin dikunjungi: ");
                    String visitLocation = scanner.nextLine();
                    Node lokasi = lokasiGraph.cariLokasi(visitLocation);
                    if (lokasi != null) {
                        jejakPerjalanan.push(visitLocation);
                        lokasi.displayClue();  // petunjuk di lokasi
                    } else {
                        System.out.println("Lokasi tidak ditemukan!");
                    }
                    break;

                case 3:
                    jejakPerjalanan.display();  // jejak perjalanan pemain
                    break;

                case 4:
                    lokasiGraph.displayLoc();  // daftar lokasi
                    break;

                case 5:
                    tekaTeki.solve();  // teka-teki
                    break;

                case 6:
                    running = false;
                    System.out.println("Terima kasih telah bermain Crime Solver!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
    private void initializeGame() {
        // nambahin lokasi-lokasi awal ke game
        lokasiGraph.addLokasi("TKP");
        lokasiGraph.addLokasi("Kamar");
        lokasiGraph.addLokasi("Dapur");

        // nambahin petunjuk untuk lokasi-lokasi tersebut
        lokasiGraph.cariLokasi("TKP").addClue("Sidik jari ditemukan di meja.");
        lokasiGraph.cariLokasi("Kamar").addClue("Hasil DNA cocok dengan tersangka.");
        lokasiGraph.cariLokasi("Dapur").addClue("Saksi memberikan informasi tentang tersangka.");
    }
}