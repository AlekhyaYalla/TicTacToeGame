import java.util.Scanner;

public class TicTacGame {

    public static char[][] grid ;
    static Scanner consoleReader = new Scanner(System.in).useDelimiter("\\s*");
    static int count = 1;
    static int gridMagnitude;

    public TicTacGame(char[][] grid,int gridMagnitude){
        this.grid = grid;
        this.gridMagnitude = gridMagnitude;

    }


    public static void main(String[] args) {

        System.out.println("***** Welcome to Tic Tac game *****");
        printGrid();

        while (!won() && count <= Math.pow(gridMagnitude,2)) {
            if (count % 2 == 0)
                promptAndSet('O'/*, o_player, o_count*/);
            else
                promptAndSet('X'/*, x_player, o_count*/);
            count++;
            printGrid();

        }
        System.out.println("***** GAME OVER !!! *****");


    }

    private static void promptAndSet(char mark/*, Player[] player, int player_count*/) {

        System.out.println("\n"+mark + " >");
        Player current = new Player((consoleReader.nextInt()) - 1,(consoleReader.nextInt()) - 1);
//        current.row = (consoleReader.nextInt()) - 1;
//        current.column = (consoleReader.nextInt()) - 1;
        if (!validInput(current)) {
            System.out.println("\n  ^ ^ ^ ^ Incorrect input ^ ^ ^ ^");
            count--;
            return;
        }
        grid[current.row][current.column] = mark;

    }

    public static boolean validInput(Player current) {
        if (grid[current.row][current.column] == '.')
            return true;
        return false;
    }


    public static boolean won() {
        if( isBothSideDiagonalElementsOfGridAreSame()) {
            return true;
        }
        if(isAnyRowOrColumnHavingSameElements()) {
            return true;
        }

        return false;
    }

    private static boolean isAnyRowOrColumnHavingSameElements() {
        for(int i=0;i<gridMagnitude-1;i++){
            for(int j=0;i<gridMagnitude-1;j++){
                if(grid[i][j] != grid[i][j+1])
                    return false;
            }
        }
        return false;
    }

    private static boolean isBothSideDiagonalElementsOfGridAreSame() {

        if(grid[gridMagnitude/2][gridMagnitude/2]== '.' )
            return false;
        for (int i = 0; i < gridMagnitude - 1; i++) {
            if ((grid[i][i] != grid[i + 1][i + 1]) && grid[i][gridMagnitude-(i+1)]!=grid[i+1][gridMagnitude-(i+2)])
                return false;
        }
//        winner = "* * "+grid[i][i] + " WON * *";
        return true;
    }

    private static void printGrid() {
        System.out.println();
        for (int i = 0; i < gridMagnitude; i++) {
            for (int j = 0; j < gridMagnitude; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
