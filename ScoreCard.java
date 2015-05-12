import java.util.*;
public class ScoreCard
{
   private Object[][] scoreTracker;
   private String[] possible;
   private int numYahtzees;
   
   public ScoreCard()
   {
      possible= new String[]{"Aces", "Twos", "Threes", "Fours", "Fives", "Sixes", "3 of a kind",
                           "4 of a kind", "Full House", "Sm Straight", "Lg Straight", "YAHTZEE",
                           "Chance"};
      numYahtzees=0;
      scoreTracker=new Object[13][2];
      for(int ii=0; ii<13; ii++)
      {
         scoreTracker[ii][1]=possible[ii];
         scoreTracker[ii][2]=null;
      }  
      
   }
   
   public void setScore(String scoringLoc, Hand hand)
   {
      int location=findString(scoringLoc);
      if(location != -1)
      {
         int temp=calcScore(scoringLoc, hand, location);
         scoreTracker[location][2]=temp; 
      }
   }
   
   public String[] getPossible()
   {
      return possible;
   }
   
   public Object[][] getScoreCard()
   {
      return scoreTracker;
   }
   
   public int calcScore(String scoringLoc, Hand hand, int location)
   {
      int value=0;
      if(scoreTracker[location][2]==null || scoringLoc.equals("YAHTZEE"))
      {
         if(scoringLoc.equals("Chance"))
         {
            value=hand.totalHand();
            return value;
         }
         if(location>=0 && location<=5)
         {
            value=hand.addUp(location+1);
         }
         else
         {
            if(scoringLoc.equals("3 of a kind"))
            {
               for(int three=1; three<7; three++)
               {
                  int temp=hand.addUp(three);
                  if(temp>=3)
                  {
                     value=hand.totalHand();
                  }
               }
            }
            if(scoringLoc.equals("4 of a kind"))
            {
               for(int four=1; four<7; four++)
               {
                  int temp=hand.addUp(four);
                  if(temp>=4)
                  {
                     value=hand.totalHand();
                  }
               }
            }
            if(scoringLoc.equals("Full House"))//maybe do a good ole ignore case to make more user friendly
            {
               boolean has2=false;
               boolean has3=false;
               for(int FL=1; FL<7; FL++)
               {
                  int temp=hand.addUp(FL);
                  if(temp==3)
                     has3=true;
                  if(temp==2)
                     has2=true;
               }
               if(has2==true && has3==true)
                  value=25;
            }
            if(scoringLoc.equals("YAHTZEE"))
            {
               for(int Y=1; Y<7; Y++)//possible to eliminate redundancy with refactoring?
               {
                  int temp=hand.addUp(Y);
                  if(temp==5)
                  {
                     numYahtzees++;
                     value=50*numYahtzees;
                  }
               }
            }
            
            if(scoringLoc.equals("Sm Straight"))
            {
               int[] temp=new int[5];
               for(int set=0; set<6; set++)
               {
                  if(hand.addUp(set+1)<=1)//removes chance of doubles
                  {
                     temp[set]=hand.getValueOfDie(set);
                  }
               }
               Arrays.sort(temp);
            }
         }
      }
   }
   
   private int findString(String scoringLoc)
   {
      int loc=-1;
      for(int ss=0; ss<13; ss++)
      {
         if(possible[ss].equals(scoringLoc))
         {
            loc=ss;
         }
      }
      return loc;
   }
}  