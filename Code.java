/**
 * Used to store the code for gameplay and check guesses. 
 *
 * @author Arnav Parashar and Junqi Wu
 * @version 5/8/18
 */
public class Code
{
    private char[] _code;

    /**
     * Converts the desired code to a char array
     * 
     * @param code String to be used as the code
     * @author Arnav Parashar and Junqi Wu
     */
    public Code( String code )
    {
        _code = code.toCharArray();
    }

    /**
     * Takes in a guess for the the code could be, and checks to see what parts of it are correct
     * 
     * @param guessStr String the guess to check against the code
     * @return a String with b and/or w to represent the black and white pegs the guesser recieves
     * @author Arnav Parashar
     */
    public String getResponse( String guessStr )
    {
        guessStr = guessStr.toUpperCase();
        char[] guess = guessStr.toCharArray();
        String blackPegs = "";
        String whitePegs = "";

        for( int i = 0; i < guess.length; i ++ )  //i goes through each spot on the guess
        {

            boolean whitePegFound = false;
            boolean blackPegFound = false;

            // Checks to see if the guess char is in the same position as the actual char, hence a black peg is given
            if( guess[ i ] == _code[ i ] )
            {
                blackPegs = blackPegs + "b";
                blackPegFound = true;
            }

            int j = 0; //j goes through each spot on the actual code
            //Searches for a white peg until either all spots are checked, a white peg is found, or if a blackpeg is already found, it won't run
            while( j < _code.length && !whitePegFound && !blackPegFound )
            {
                //1. Makes sure it is not checking the same spot on both codes (Black peg checker already takes care of this case)
                //2. Checks to see if the two spots you are comparing are the same (hence a white peg is given)
                //3. Checks to see if where you are about to place a white peg, is not actually a spot where you should give a black peg
                if( j != i && guess[ i ] == _code[ j ] && _code[ j ] != guess[ j ] )
                {
                    int numOfCharActual = 0;
                    int numOfCharGuess = 0;
                    //This is to make sure we are not giving multiple white pegs for when the guess has repeats in it

                    for( int a = i-1; a >=0; a-- )//Checks to see how many of the same guess char occur in the guess
                    {                        
                        if( guess[ i ] == guess[ a ] && guess[ a ] != _code[ a ] ) //before this current char, and excludes spots where black pegs are given 
                            numOfCharGuess++;
                    }
                    for(int b = j-1; b >= 0; b--) //Checks to see how many of the same guess char occur in the actual code
                    {                      
                        if( guess[ i ] == _code[ b ] && guess[ b ] != _code[ b ] )//before the current spot they are checking, and excluedes black peg spots
                            numOfCharActual++;
                    }
                    if( numOfCharGuess == numOfCharActual ) // If the amount of same chars before are same, then this must be a new white peg spot
                    { 
                        whitePegs = whitePegs + "w";
                        whitePegFound = true;
                    }
                }
                j++;
            }
        }
        return blackPegs + whitePegs;
    }
    
    /**
     * Returns the code which is being stored
     * 
     * @return the String representation of the code
     * @author Arnav Parashar
     */
    public String toString() 
    {
        String code = "";
        for( int i = 0; i < _code.length; i++ )
            code = code + _code[i];
        return code;
       
    }
}