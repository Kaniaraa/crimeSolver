import java.util.Scanner;

class CrimeSolverLogin {
    private QueueLogin queueLogin;  
    private Account head;

    public CrimeSolverLogin() {
        queueLogin = new QueueLogin();  
    }
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
    // Sign-up akun baru
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
            queueLogin.enqueue(username);  // Memasukkan ke dalam antrian login hanya jika login berhasil
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
            System.out.println("3. Lihat Akun yang Login");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");
            
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Silakan pilih angka antara 1 dan 4.");
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
                        // Pastikan login berhasil baru masuk ke game
                        AyoMain gameSystem = new AyoMain();
                        gameSystem.startGame();  
                    }
                    break;
                case 3:
                    queueLogin.displayLoginAccounts();
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}