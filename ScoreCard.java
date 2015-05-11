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
      return 0;  
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