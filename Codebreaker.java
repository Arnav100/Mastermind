import java.util.Scanner;
import java.util.ArrayList;
/**
 * The Codebreaker handles the guessing of the code.
 * It contains methods to generate a computer guess or
 * input a user guess.
 *
 * @author Junqi
 * @version 5/8/2018
 */
public class Codebreaker
{

    private Scanner _sc;
    
    // the guesses and responses that the computer has previously made
    private ArrayList<char[]> _guesses;
    private ArrayList<String> _responses;
    
    public Codebreaker(Scanner sc)
    {
        _sc = sc;
        
        _guesses = new ArrayList<char[]>();
        _responses = new ArrayList<String>();
    }
    
    /**
     * !!! TODO !!!
     * Uses an AI algorithm to guess the code based on
     * previous guesses and responses.
     * 
     * @return The computer's guess as a character array.
     */
    public char[] makeCPUGuess() 
    {
        return null;
    }
    
    /**
     * Adds a response from the Codemaker to the Codebreaker's
     * previous responses. This is used to help the AI algorithm
     * in makeCPUGuess().
     * 
     * @param response The reponse that the Codemaker gave to the previous guess.
     */
    public void addResponse(String response)
    {
        _responses.add(response);
    }
    
    /**
     * Scans a user guess and returns a character array
     * of the colors.
     * 
     * @return The user's guess as a character array.
     */
    public char[] makeUserGuess()
    {
        String guess = _sc.nextLine();
        return guess.toCharArray();
    }
}
