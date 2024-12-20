import java.util.Scanner;

class AyoMain {
    private final Graph lokasiGraph;
    private final Stack jejakPerjalanan;
    private final TekaTeki tekaTeki;
    private String tersangkaTerpilih; 
    public AyoMain() {
        lokasiGraph = new Graph();
        jejakPerjalanan = new Stack();
        tekaTeki = new TekaTeki();
        tersangkaTerpilih = null; 
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
            System.out.println("║ 5. Selesaikan Kasus      ║");  
            System.out.println("║ 6. Keluar                ║");
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
                    solveCase(scanner); 
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
    private void mulaiPenyelidikan(Node lokasi) {
        Scanner scanner = new Scanner(System.in);
        boolean selesai = false;
    
        while (!selesai) {
            System.out.println("\n=== Penyelidikan di " + lokasi.name + " ===");
            System.out.println("1. Periksa petunjuk lebih detail");
            System.out.println("2. Tanya saksi (jika ada)");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.print("Pilihan Anda: ");
    
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1:
                    System.out.println("Memeriksa petunjuk lebih detail...");
                    lokasi.displayClue();  
                    break;
                case 2:
                    System.out.println("Tidak ada saksi yang dapat diwawancarai di lokasi ini.");
                    break;
                case 3:
                    selesai = true;  
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
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
        
        lokasiGraph.connectLokasi("TKP", "Kamar Tersangka");
        lokasiGraph.connectLokasi("TKP", "Dapur");
        lokasiGraph.connectLokasi("TKP", "Taman");
        lokasiGraph.connectLokasi("Kamar Tersangka", "Garasi");
        lokasiGraph.connectLokasi("Taman", "Gudang");
        lokasiGraph.connectLokasi("Dapur", "Gudang");
        
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
        if (tKPLokasi != null) {
            tKPLokasi.addClue("Ditemukan bukti darah yang mengarah ke kamar tersangka.");
        }
        if (garasi != null) {
            garasi.addClue("Ada bekas rem di tanah yang menunjukkan mobil tersangka berusaha melarikan diri.");
        }
    }
    private void solveCase(Scanner scanner) {
        System.out.println("\n=== Menyelesaikan Kasus ===");
        if (tersangkaTerpilih == null) {
            System.out.println("Tersangka belum dipilih. Silakan kunjungi lebih banyak lokasi untuk mendapatkan petunjuk.");
            return;
        }
        System.out.println("Berdasarkan petunjuk yang ditemukan, siapa yang menurut Anda adalah tersangka?");
        System.out.println("Tersangka yang tersedia:");
        System.out.println("1. Tersangka A");
        System.out.println("2. Tersangka B");
        System.out.println("3. Tersangka C");

        System.out.print("Pilih nomor tersangka: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); 

        String hasil = "";
        switch (pilihan) {
            case 1:
                hasil = "Tersangka A adalah yang bertanggung jawab!";
                break;
            case 2:
                hasil = "Tersangka B adalah yang bertanggung jawab!";
                break;
            case 3:
                hasil = "Tersangka C adalah yang bertanggung jawab!";
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }
        System.out.println(hasil);
        System.out.println("Kasus berhasil diselesaikan. Terima kasih telah bermain!");
    }
}