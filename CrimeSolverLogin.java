import java.util.Scanner;

class CrimeSolverLogin {
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
    private Account head;
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
    public boolean login(String username, String password) {
        Account account = findAccount(username);
        if (account != null && account.password.equals(password)) {
            System.out.println("Login berhasil! Selamat datang, " + username + "!");
            return true;
        }
        System.out.println("Login gagal. Username atau password salah.");
        return false;
    }
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
    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Crime Solver Login ===");
            System.out.println("1. Sign-Up");
            System.out.println("2. Login");
            System.out.println("3. Keluar");
            System.out.print("Pilihan: ");
            
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Silakan pilih angka antara 1 dan 3.");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    signUp(username, password);
                    break;
                case 2:
                    System.out.print("Username: ");
                    username = scanner.nextLine();
                    System.out.print("Password: ");
                    password = scanner.nextLine();
                    if (login(username, password)) {
                        new AyoMain().startGame();  // Pastikan AyoMain dan startGame sudah ada.
                    }
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    scanner.close();  // Menutup scanner dengan hati-hati
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}