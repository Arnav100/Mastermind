import java.util.Scanner;
/**
 * The MastermindRunner plays the game Mastermind with the user. 
 *
 * @author Arnav Parashar and Junqi Wu
 * @version 5/21/18
 */
public class MastermindRunner
{
    private static GameBoard _gameBoard;
    private static Scanner _sc;
    
    /**
     * Plays the Mastermind game for as long as the user would like. 
     */
    public static void main()
    {
        System.out.println("Welcome to Mastermind \n \nThe object of the game as Codebreaker is to guess the secret code, \nas Codemaker you create a code"
        + " for the computer to guess \nThe code will be made of five color pegs, with possible repeats, from the following eight colors: \n"
        + "(R)ed, (O)range, (Y)ellow, (G)reen, (P)urple, (B)lue, (W)hite, (T)an \n"
        + "(b)lack key pegs will be the responses indicating a correct code peg. \n"
        + "(w)hite key pegs will be the responses indicating a correct color in the wrong spot \n"
        + "You will have ten chances to break the code \n \n"
        + "Begin enter guesses, for example ROYGB");
        
        System.out.println("Would you like to play?");
        _sc = new Scanner(System.in);
        String response = _sc.nextLine();
        while(response.charAt(0) == 'Y' || response.charAt(0) == 'y')
        {
            _gameBoard = new GameBoard(_sc);
            _gameBoard.playGame();
            System.out.println("Would you like to play again?");
            response = _sc.nextLine();
        }
    }
}
