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
   private int _matchNum;
   private int _userPoints;
   private int _cpuPoints;
   
   private final int NUM_OF_MATCHES = 6;
   private final int NUM_OF_ROUNDS = 15;
   
   /**
    * 
    */
   public GameBoard(Scanner sc) 
   {
      _sc = sc;
      
      _matchNum = 1;
      _userPoints = 0;
      _cpuPoints = 0;
      
      for(int i = 0; i < NUM_OF_MATCHES; i++)
      {
          
      }
   }
   
   private void playMatch()
   {
      _maker = new Codemaker(_sc);
      _breaker = new Codebreaker(_sc);
      
      for(int i = 0; i < NUM_OF_ROUNDS; i++)
      {
          // play the round and end the match early if the code is guessed
          if(playRound())
          {
              return;
          }
          
          // give a point to the maker
          addPoints();
      }
      
      // if the code is not guessed, give the maker a bonus point
      addPoints();
   }
   
   private boolean playRound()
   {
       String guess;
       String response;
       if(userIsMaker())
       {
           guess = _breaker.makeCPUGuess();
           response = _maker.getUserResponse(guess);
           _breaker.addResponse(response);
       } 
       else 
       {
           guess = _breaker.makeUserGuess();
           response = _maker.getCPUResponse(guess);
           System.out.println(response);
       }
       
       // return if the round is won or not
       return response.equals("bbbbbb");
   }
   
   private void addPoints()
   {
       // give the maker one point
       if(userIsMaker())
       {
           _userPoints++;
       }
       else
       {
           _cpuPoints++;
       }
   }
   
   private boolean userIsMaker() 
   {
       // the user is the Codemaker on even rounds
       return _matchNum % 2 == 0;
   }
}
