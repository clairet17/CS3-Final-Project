public class Player
{
   private ScoreCard score;
   private Hand hand;
   
   public Player()
   {
      score=new ScoreCard();
      hand=new Hand();
   }
   
   public Die[] roll(boolean d1, boolean d2, boolean d3, boolean d4, boolean d5)
   {
      hand.roll(d1, d2, d3, d4, d5);
      return hand.getDie();
   }
   
   public void setScore(String scoringLoc)
   {
      score.setScore(scoringLoc, hand);
   }
   
   public String[] getPossible()
   {
      return score.getPossible();
   }
   
   public int getScore()
   {
      int sum=0;
      Object[][] temp=score.getScoreCard();
      for(int ss=0; ss<13; ss++)
      {
         if(temp[ss][2] !=null && temp[ss][2] instanceof Integer)
         {
            int temp2=(int) ((Integer)temp[ss][2]);//This may not work, check in testing
            sum+=temp2;
         }
      }
      return sum;
   }
   
   public Object[][] getScoreCard()
   {
      return score.getScoreCard();
   }  
}