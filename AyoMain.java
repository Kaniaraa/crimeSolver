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
            System.out.println("\n╔══════════════════════════╗");
            System.out.println("║    Crime Solver Menu     ║");
            System.out.println("╠══════════════════════════╣");
            System.out.println("║ 1. Kunjungi Lokasi       ║");
            System.out.println("║ 2. Lihat Jejak Perjalanan║");
            System.out.println("║ 3. Lihat Semua Lokasi    ║");
            System.out.println("║ 4. Selesaikan Teka-Teki  ║");
            System.out.println("║ 5. Keluar                ║");
            System.out.println("╚══════════════════════════╝");
            System.out.print("Pilihan Anda: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clean up newline character
            
            switch (choice) {
                case 1:
                    // Menampilkan daftar lokasi yang tersedia
                    System.out.println("Pilih lokasi yang ingin dikunjungi:");
                    lokasiGraph.displayLoc();
                    System.out.print("Masukkan nama lokasi: ");
                    String visitLocation = scanner.nextLine();
                    Node lokasi = lokasiGraph.cariLokasi(visitLocation);
                    if (lokasi != null) {
                        jejakPerjalanan.push(visitLocation);
                        System.out.println("Kamu telah mengunjungi lokasi: " + visitLocation);
                        lokasi.displayClue();  // Menampilkan petunjuk di lokasi yang dikunjungi
                        lokasi.displayConnections();  // Menampilkan lokasi terhubung
                    } else {
                        System.out.println("Lokasi tidak ditemukan!");
                    }
                    break;
                case 2:
                    jejakPerjalanan.display();  // Menampilkan jejak perjalanan pemain
                    break;
                case 3:
                    lokasiGraph.displayLoc();  // Menampilkan semua lokasi yang ada
                    break;
                case 4:
                    tekaTeki.solve();  // Menyelesaikan teka-teki
                    break;
                case 5:
                    running = false;
                    System.out.println("Terima kasih telah bermain Crime Solver!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
    private void initializeGame() {
        // Menambahkan lokasi-lokasi awal ke game
        lokasiGraph.addLokasi("TKP");
        lokasiGraph.addLokasi("Kamar Tersangka");
        lokasiGraph.addLokasi("Dapur");
        lokasiGraph.addLokasi("Taman");
        lokasiGraph.addLokasi("Garasi");
        lokasiGraph.addLokasi("Gudang");
    
        // Menambahkan petunjuk untuk lokasi-lokasi tersebut
        Node tKPLokasi = lokasiGraph.cariLokasi("TKP");
        if (tKPLokasi != null) {
            tKPLokasi.addClue("Sidik jari ditemukan di meja. Ada noda darah di lantai.");
        }
        Node kamarTersangka = lokasiGraph.cariLokasi("Kamar Tersangka");
        if (kamarTersangka != null) {
            kamarTersangka.addClue("Hasil DNA cocok dengan tersangka. Ada jejak sepatu di karpet.");
        }
        Node dapur = lokasiGraph.cariLokasi("Dapur");
        if (dapur != null) {
            dapur.addClue("Saksi mendengar suara keras dari dapur pada malam kejadian.");
        }
        Node taman = lokasiGraph.cariLokasi("Taman");
        if (taman != null) {
            taman.addClue("Tersangka sering terlihat di taman. Terdapat surat yang sobek.");
        }
        Node garasi = lokasiGraph.cariLokasi("Garasi");
        if (garasi != null) {
            garasi.addClue("Ada bekas ban mobil di tanah. Mobil tersangka terparkir di sana.");
        }
        Node gudang = lokasiGraph.cariLokasi("Gudang");
        if (gudang != null) {
            gudang.addClue("Ada jejak kaki basah yang mengarah ke gudang. Ditemukan barang bukti di sana.");
        }
        // Menghubungkan lokasi-lokasi yang relevan
        lokasiGraph.connectLokasi("TKP", "Kamar Tersangka");
        lokasiGraph.connectLokasi("TKP", "Dapur");
        lokasiGraph.connectLokasi("TKP", "Taman");
        lokasiGraph.connectLokasi("Kamar Tersangka", "Garasi");
        lokasiGraph.connectLokasi("Taman", "Gudang");
        lokasiGraph.connectLokasi("Dapur", "Gudang");
        // Menambahkan lokasi tambahan yang lebih dinamis
        lokasiGraph.addLokasi("Pusat Polisi");
        Node pusatPolisi = lokasiGraph.cariLokasi("Pusat Polisi");
        if (pusatPolisi != null) {
            pusatPolisi.addClue("Ada laporan saksi yang melihat mobil tersangka meninggalkan lokasi pada malam kejadian.");
        }
        lokasiGraph.connectLokasi("Gudang", "Pusat Polisi");
        // Menambahkan petunjuk lebih lanjut berdasarkan hubungan antara lokasi
        if (garasi != null) {
            garasi.addClue("Mobil tersangka terlihat berada di garasi. Ditemukan kunci mobil di meja TKP.");
        }
        if (taman != null) {
            taman.addClue("Surat yang ditemukan di taman mencurigakan. Itu adalah ancaman yang ditulis oleh tersangka.");
        }
        // Menambahkan bukti yang lebih spesifik
        if (tKPLokasi != null) {
            tKPLokasi.addClue("Ditemukan bukti darah yang mengarah ke kamar tersangka.");
        }
        if (garasi != null) {
            garasi.addClue("Ada bekas rem di tanah yang menunjukkan mobil tersangka berusaha melarikan diri.");
        }
    }
}