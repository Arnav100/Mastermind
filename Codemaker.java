import java.util.Scanner;
/**
 * Write a description of class Codemaker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Codemaker
{ 
    private Code _code;
    private Scanner _sc;
    private final char[] _colors = {'R', 'O', 'Y', 'G', 'B', 'P', 'W', 'T'};
    private final int CODE_LENGTH = 5;

    /**
     * Used when the user is the codemaker, this creates a new Codemaker object and takes in the user's code. 
     * 
     * @param input String the code the user would like to use
     * @param sc Scanner a pointer for the _sc so that Codemaker can prompt the user when necessary
     * @author Arnav Parashar
     */
    public Codemaker(boolean userIsMaker, Scanner sc)
    {
        _sc = sc;
        String input = "";
        if(userIsMaker){
            System.out.println("Input your code for the computer to guess: ");
            input = _sc.nextLine();
        }
        else {
           
            for(int i = 0; i < CODE_LENGTH; i++)
                input = input + _colors[(int)(Math.random() * _colors.length)];

          //  System.out.println("The actual code (For Testing Purposes):   " + input); //remove later
        }
        _code = new Code(input);
    }

    /**
     * Used when the CPU is the codemaker, this responds with the correct amount of black and white pegs for the user's guess
     * 
     * @param userGuess String the guess of the user to be compared to the correct code
     * @return a String with the correct amount of black and white pegs for the guess
     * @author Arnav Parashar
     */

    public String getCPUResponse(String userGuess) 
    {
        return _code.getResponse(userGuess);
    }

    /**
     * Used when the user is the codemaker, has the user respond with what they think to be the correct amount of black and white pegs for the CPU's guess
     * 
     * @param cpuGuess String the guess of the cpu to be compared to the correct code
     * @return a String with the user's amount of black and white pegs for the guess
     * @author Arnav Parashar
     */
    public String getUserResponse(String cpuGuess)
    {
        System.out.println("The computer responded with " + cpuGuess + "\nNow you can tell what it did wrong. (Ex. bwww)" );
        String response = _sc.nextLine();

        return response;
    } 
    
    public String getCode()
    {
        return _code.getCode();
    }
}
