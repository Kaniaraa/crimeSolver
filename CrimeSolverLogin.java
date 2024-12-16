import java.util.Scanner;

public class CrimeSolverLogin {
    // Node untuk menyimpan akun pengguna
    static class Account {
        String username;
        String password;
        Account next;

        public Account(String username, String password) {
            this.username = username;
            this.password = password;
            this.next = null;
        }
    }

    // Head untuk linked list akun
    private Account head;

    // Sign-Up untuk menambahkan akun baru
    public void signUp(String username, String password) {
        if (findAccount(username) != null) {
            System.out.println("Username sudah digunakan. Silakan gunakan username lain.");
            return;
        }

        Account newAccount = new Account(username, password);
        if (head == null) {
            head = newAccount;
        } else {
            Account current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newAccount;
        }
        System.out.println("Akun berhasil dibuat! Silakan login.");
    }

    // Login untuk memeriksa username dan password
    public boolean login(String username, String password) {
        Account account = findAccount(username);
        if (account != null && account.password.equals(password)) {
            System.out.println("Login berhasil! Selamat datang, " + username + "!");
            return true;
        }
        System.out.println("Login gagal. Username atau password salah.");
        return false;
    }

    // Mencari akun berdasarkan username
    private Account findAccount(String username) {
        Account current = head;
        while (current != null) {
            if (current.username.equals(username)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Menu utama program
    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Crime Solver Login System ===");
            System.out.println("1. Sign-Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String newPassword = scanner.nextLine();
                    signUp(newUsername, newPassword);
                    break;

                case 2:
                    System.out.print("Masukkan username: ");
                    String username = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String password = scanner.nextLine();
                    if (login(username, password)) {
                        gameMenu(scanner, username);
                    }
                    break;

                case 3:
                    System.out.println("Terima kasih telah menggunakan Crime Solver. Sampai jumpa!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }

    // Menu permainan setelah login berhasil
    private void gameMenu(Scanner scanner, String username) {
        System.out.println("\n=== Selamat Datang, " + username + "! ===");
        System.out.println("Fitur permainan akan dikembangkan lebih lanjut.");
        System.out.println("Misalnya: Jelajahi lokasi, kumpulkan petunjuk, dsb.");
        System.out.println("Kembali ke login dengan menutup aplikasi.");
    }

    // Main method untuk menjalankan program
    public static void main(String[] args) {
        CrimeSolverLogin loginSystem = new CrimeSolverLogin();
        loginSystem.mainMenu();
    }
}
