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
    private String[] _guesses;
    private String[] _responses;
    
    public Codebreaker(Scanner sc)
    {
        _sc = sc;
        
        _guesses = new String[15];
        _responses = new String[15];
    }
    
    /**
     * !!! TODO !!!
     * Uses an AI algorithm to guess the code based on
     * previous guesses and responses.
     * 
     * @return The computer's guess as a String object.
     */
    public String makeCPUGuess() 
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
        for(int i = 0; i < _responses.length; i++)
        {
            if(_responses[i] == null)
            {
                _responses[i] = response;
                return;
            }
        }
    }
    
    /**
     * Scans a user guess and returns it as a String object
     * 
     * @return The user's guess as a String object
     */
    public String makeUserGuess()
    {
        String guess = _sc.nextLine();
        return guess;
    }
}
