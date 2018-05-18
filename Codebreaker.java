import java.util.Scanner;
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

    private final int NUM_OF_ROUNDS = 15;
    
    
    // Junqi's stuff
    private String[] possibleGuesses;
    private final char[] colors = {'R', 'O', 'Y', 'G', 'B', 'P', 'W', 'T'};
    private String prevGuess;

    public Codebreaker(Scanner sc)
    {
        _sc = sc;

        _guesses = new String[NUM_OF_ROUNDS];
        _responses = new String[NUM_OF_ROUNDS];
        
        // Junqi's stuff
        possibleGuesses = new String[32768];
        // generate all of the possible guesses
        for(int i = 0; i < possibleGuesses.length; i++)
        {
            // get octal
            String octal = Integer.toOctalString(i);
            // pad zeros
            octal = String.format("%05d", Integer.parseInt(octal));
            // convert five digit octal to guess
            String guess = "";
            for(int j = 0; j < octal.length(); j++)
            {
                // get each individual digit of the octal
                int index = Integer.parseInt(octal.substring(j, j + 1));
                // added the color to the guess
                guess += colors[index];
            }
            // add the guess to the array
            possibleGuesses[i] = guess;
        }
        prevGuess = "";
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
     * Uses magic to guess the code
     * 
     * @author Junqi
     * @return The computer's guess as a String object.
     */
    public String makeCPUGuess2()
    {
        // the first guess
        if(prevGuess.isEmpty())
        {
            // remove the guess and return it
            String guess = possibleGuesses[9];
            possibleGuesses[9] = "";
            prevGuess = guess;
            return guess;
        }
        
        for(int i = 0; i < possibleGuesses.length; i++)
        {
            if(!possibleGuesses[i].isEmpty())
            {
                // remove the guess and return it
                String guess = possibleGuesses[i];
                possibleGuesses[i] = "";
                prevGuess = guess;
                return guess;
            }
        }
        return "Whoops, something went wrong!";
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
     * Keeps track of all user responses with magic
     * 
     * @author Junqi
     * @param response The reponse that the Codemaker gave to the previous guess.
     */
    public void addResponse2(String response)
    {
        if(response.equals("bbbbb"))
        {
            System.out.println("I win!");
            return;
        }
        
        for(int i = 0; i < possibleGuesses.length; i++)
        {
            if(!possibleGuesses[i].isEmpty())
            {
                // get the sample response if this possible guess was the actual code
                Code c = new Code(possibleGuesses[i]);
                String sampleRes = c.getResponse(prevGuess);
                // remove the sample from the possible guesses if the responses don't match
                if(!sampleRes.equals(response))
                {
                    possibleGuesses[i] = "";
                }
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
        while(guess.length() != 5)
        {
            System.out.println("Your guess needs to be 5 characters long");
            guess = _sc.nextLine();
        }

        return guess;
    }
}
