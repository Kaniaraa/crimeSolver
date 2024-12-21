public class CrimeSolver {
    public static void main(String[] args) {
        System.out.println("\033[31;1m   ██████╗██████╗ ██╗███╗   ███╗███████╗    ███████╗ ██████╗ ██╗     ██╗   ██╗███████╗██████╗ ");
        System.out.println("\033[31;1m  ██╔════╝██╔══██╗██║████╗ ████║██╔════╝    ██╔════╝██╔═══██╗██║     ██║   ██║██╔════╝██╔══██╗");
        System.out.println("\033[31;1m  ██║     ██████╔╝██║██╔████╔██║█████╗      █████╗  ██║   ██║██║     ██║   ██║█████╗  ██████╔╝");
        System.out.println("\033[31;1m  ██║     ██╔═══╝ ██║██║╚██╔╝██║██╔══╝      ██╔══╝  ██║   ██║██║     ██║   ██║██╔══╝  ██╔═══╝ ");
        System.out.println("\033[31;1m  ╚██████╗██║     ██║██║ ╚═╝ ██║███████╗    ██║     ╚██████╔╝███████╗╚██████╔╝███████╗██║     ");
        System.out.println("\033[31;1m   ╚═════╝╚═╝     ╚═╝╚═╝     ╚═╝╚══════╝    ╚═╝      ╚═════╝ ╚══════╝ ╚═════╝ ╚══════╝╚═╝     ");
        System.out.println("\033[34;1m         A Mystery Adventure Game - Solve the Case and Catch the Culprit!");
        System.out.println("\033[33;1mWelcome to CRIME SOLVER! Let's unravel the mysteries!\n");
        
        CrimeSolverLogin loginSystem = new CrimeSolverLogin();
        loginSystem.mainMenu();

        AyoMain gameSystem = new AyoMain();
        gameSystem.startGame();
    }
}