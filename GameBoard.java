import java.util.Scanner;
/**
 * Write a description of class GameBoard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameBoard
{
   private Scanner _sc;
   private Codemaker _maker;
   private Codebreaker _breaker;
   private boolean _userIsMaker;
   private int _userPoints;
   private int _cpuPoints;
   
   private final int NUM_OF_MATCHES = 6;
   private final int NUM_OF_ROUNDS = 10;
   
   /**
    * 
    */
   public GameBoard(Scanner sc) 
   {
      _sc = sc;
      
      _userIsMaker = true;
      _userPoints = 0;
      _cpuPoints = 0;
  
   }
   
   public void playGame() 
   {
      for(int i = 0; i < NUM_OF_MATCHES; i++)
      {
          System.out.println("\nMatch " + (i + 1) + "\n" );
          playMatch();
          
      }
   }
   
   private void playMatch()
   {
      _userIsMaker = !_userIsMaker;
      _maker = new Codemaker(_userIsMaker, _sc);
      _breaker = new Codebreaker(_sc);
     
      for(int i = 0; i < NUM_OF_ROUNDS; i++)
      {
          // play the round and end the match early if the code is guessed
          System.out.println("\nRound " + (i + 1) + "\n" );
          if(playRound())
          {
              System.out.println( "Congrats you won!" );
              return;
          }
          // give a point to the maker
          addPoints();
      }
      System.out.println( "Sorry, you couldn't guess the code. It was " + _maker.getCode() );
      
      // if the code is not guessed, give the maker a bonus point
      addPoints();
   }
   
   private boolean playRound()
   {
       String guess;
       String response;
       if(_userIsMaker)
       {
           guess = _breaker.makeCPUGuess2();
           response = _maker.getUserResponse(guess);
           _breaker.addResponse2(response);
       } 
       else 
       {
           guess = _breaker.makeUserGuess();
           response = _maker.getCPUResponse(guess);
           System.out.println("Computer's response: " + response);
       }
       
       // return if the round is won or not
       return response.equals("bbbbb");
   }
   
   private void addPoints()
   {
       // give the maker one point
       if(_userIsMaker)
           _userPoints++;
       else
           _cpuPoints++;
           
       
        System.out.println("User Points: " + _userPoints ); //Remove later
        System.out.println("CPU Points: " + _cpuPoints ); //Remove later
   }
   /*
   private boolean userIsMaker() 
   {
       // the user is the Codemaker on even rounds
   //    return _matchNum % 2 == 0l
   }
   */
}
