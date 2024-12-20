public class CrimeSolver {
    public static void main(String[] args) {
        CrimeSolverLogin loginSystem = new CrimeSolverLogin();
        loginSystem.mainMenu();

        System.out.println("Selamat datang di permainan Crime Solver!");
        System.out.println("Silakan ikuti petunjuk di layar untuk menyelesaikan misteri.");

        AyoMain gameSystem = new AyoMain();
        gameSystem.startGame();
    }
}