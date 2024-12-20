public class CrimeSolver {
    public static void main(String[] args) {
        System.out.println("=== Selamat datang di permainan Crime Solver ===");
        System.out.println("Silakan login untuk memulai permainan.");
        CrimeSolverLogin loginSystem = new CrimeSolverLogin();
        loginSystem.mainMenu();
        
        AyoMain gameSystem = new AyoMain();
        gameSystem.startGame();
    }
}