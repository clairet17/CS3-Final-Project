import java.awt.*;
import javax.swing.*;
import java.util.*;
public class View
{
   private JFrame frame;
   private Controller controller;
   private int Turns_Per_Player;
   private int numPlayers;
   private GUIRB guiBoolean;
   private GUIRS guiString;
   private GUIRD guiRoll;
   
   public View()
   {
      frame=new JFrame();
      controller=new Controller();
      Turns_Per_Player=13;
      guiBoolean=new GUIRB();
      guiString=new GUIRS();
      guiRoll=new GUIRD(controller);
   }
   
   public void playGame()
   {
      int play=JOptionPane.showConfirmDialog(null, "Would you like to Play?");
      if(play==JOptionPane.YES_OPTION)
      {  
         int players=0;
         while(players<2 || players>6)
         {
            players=checkPlayers("Set Player Number", "How many players?", "Okay", "Invalid Input. Enter an Integer");
         }
         numPlayers=players;
         int playerTracker=0;
         String instructions=getInstructions();
         guiBoolean.promptUser("Okay", instructions, frame);
         for(int ii=1; ii<=Turns_Per_Player*numPlayers; ii++)
         {
            turn(playerTracker);
            if(playerTracker==numPlayers-1)
               playerTracker=0;
            else
               playerTracker++;
         }
         String winner=controller.getWinner();
         guiBoolean.promptUser("Okay", "Congratulations " +winner+ "! You Won!!!", frame);
         frame.setVisible(false);
      }
   }
   
   public void turn(int player)//need to play with the frame
   {
      int roll=1;
      Die[] currentHand=null;
      while(roll<4)
      {
         if(roll==1)
            currentHand=controller.roll(true, true, true, true, true);
         else
         {
            guiRoll.promptUser("Roll", "Choose Which Dice to Keep", frame, currentHand);   
            currentHand=controller.getHand();
         } 
      }
      boolean works=false;
      String score="";
      while(works==false)
      {
         guiString.promptUser("Submit String", "Choose one. Here are your choices: "+Arrays.toString(controller.getPossible()), frame);
         score=guiString.getString();
         works=testString(score);
      }
      controller.setScore(score);
      controller.endTurn();
      
   }
   
   private int checkPlayers(String SButton, String SLabel, String SErrorB, String SErrorL)
   {
      int players=0;
         try
         {
            guiString.promptUser(SButton, SLabel, frame);
            String p=guiString.getString();
            players=Integer.parseInt(p);
         }
         catch(NumberFormatException NFE)
         {
            guiBoolean.promptUser(SErrorB, SErrorL, frame);
         }
       return players;
   }
   private boolean testString(String scoringLoc)
   {
      String[] temp=controller.getPossible();
      for(int ii=0; ii<temp.length; ii++)
      {
         if(scoringLoc.equalsIgnoreCase(temp[ii]))
         {
            return true;
         }
      }
      return false;
        
   }
   private String getInstructions()
   {
      return "Welcome to Yahtzee. Yahtzee is played with 2-6 players.\n"+
             "In this game each player will sequentially have turns in which\n"+
             "they roll a group of 5 dice. The goal of this game is to score\n"+
             "any of the following: a Yahtzee(5 dice of the same value), a small\n"+ 
             "straight(three numbers in sequential order), a large straight\n"+
             "(four numbers in sequential order, a full house(a set of 2\n"+
             "matching numbers coupled with a set of 3 matching numbers), a four\n"+
             "of a kind, a three of a kind, a group of as many matching\n"+
             "numbers as possible. For example, if throughout my turn I roll 2 fives,\n"+
             "I can score that in the matching numbers box, lastly I can score any hand\n"+
             "of dice as a Chance(total all the dice and thats how many points you get).\n"+
             "Each of these scoring opportunities can only happen once per person. On a\n"+
             "given turn you roll the dice three times. On your second and third rolls you\n"+
             "you can select which, if any, dice you want to roll and which, if any, you\n"+
             "want to keep. At the end of the game, the person with the most points wins!";
             
   }    
     
}