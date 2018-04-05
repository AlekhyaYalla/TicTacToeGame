import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;


public class TicTacGameTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void emptyGridTest(){
//        new TicTacGame().main(String[] args);
    }

    @Test
    public  void isValidInputTestForTrue(){
        char[][] grid = {{'.', '.', '.'}, {'.', '.', '.'}, {'.', '.', '.'}};
        assertTrue(new TicTacGame(grid,3).validInput(new Player(1,1)));
    }

    @Test
    public  void isValidInputTestForFalse(){
        char[][] grid = {{'X', '.', '.'}, {'.', '.', '.'}, {'.', '.', '.'}};
        assertFalse(new TicTacGame(grid,3).validInput(new Player(0,0)));
    }

    @Test
    public  void wonFalseForNotEquals(){
        char[][] grid = {{'X', '.', '.'}, {'.', '.', '.'}, {'.', '.', '.'}};
        assertFalse(new TicTacGame(grid,3).won());
    }

    @Test
    public  void wonTrueWithLeftToRightDiagnolElementsSame(){
        char[][] grid = {{'X', '.', '.'}, {'.', 'X', '.'}, {'.', '.', 'X'}};
        assertTrue(new TicTacGame(grid,3).won());
    }

    @Test
    public  void wonTrueWithRightToLeftDiagnolElementsSame(){
        char[][] grid = {{'X', '.', 'O'}, {'.', 'O', 'X'}, {'O', '.', 'X'}};
        assertTrue(new TicTacGame(grid,3).won());
    }
}