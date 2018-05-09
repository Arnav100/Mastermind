
/**
 * Used to store the code for gameplay and check guesses. 
 *
 * @author Arnav Parashar and Junqi Wu
 * @version 5/8/18
 */
public class Code
{
    char[] _code;
    
    /**
     * 
     */
    public Code(String code)
    {
        _code = code.toCharArray();
    }
    
    /**
     * Takes in a guess for the the code could be, and checks to see what parts of it are correct
     * 
     * @param guess char[] the guess to check against the code
     * @return a String with b and/or w to represent the black and white pegs the guesser recieves
     * @author Arnav Parashar
     */
    public String getResponse(String guessStr)
    {
        char[] guess = guessStr.toCharArray();
        
        String blackPegs = "";
        String whitePegs = "";
        
        for(int i = 0; i < guess.length; i ++)
        {
            for(int j = 0; j < _code.length; j ++)
            {
                if(j == i && guess[i] == _code[j])
                    blackPegs = blackPegs + "b";

                else if(guess[i] == _code[j])
                    whitePegs = whitePegs + "w";

            }
        }
        return blackPegs + " " + whitePegs;
    }
}
