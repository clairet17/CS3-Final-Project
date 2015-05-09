public class Model
{
   private Player[] players;
   private int playerTracker;
   private int numPlayers;
   
   public Model()
   {
      playerTracker=0;
   }
   
   public void setPlayers(int numPlayers)
   {
      this.numPlayers=numPlayers;
      players=new Player[numPlayers];
      for(int ii=0; ii<numPlayers; ii++)
      {
         players[ii]=new Player();
      }  
   }
   
   public Hand roll(boolean d1, boolean d2, boolean d3, boolean d4, boolean b5)
   {
      return players[playerTracker].roll(d1, d2, d3, d4, d5);
   }
   
   public void endTurn()
   {
      if(playerTracker==numPlayers)//does this need to be numPlayers-1
      {
         playerTracker=0;
      }
      else
      {
         playerTracker++;
      }
   }
   
   public void setScore(String scoringLoc)
   {
      players[playerTracker].setScore(scoringLoc);
   }
   
   public String[] getPossible()
   {
      return players[playerTracker].getPossible();
   }
   
   public Object[][] getScoreCard()
   {
      return players[playerTracker].getScoreCard();
   }
   
   public int getWinner()//must have a way to check for ties(should this return a string)
   {
      int player=0;
      int highest=0;
      for(int ww=0; ww<players.length; ww++)
      {
         int playerScore=players[ii].getScore();
         if(playerScore>highest)
         {
            highest=playerScore;
            player=ii;
         }
      }
      return player+1;
   }
}