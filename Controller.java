public class Controller
{
   Model model;
   public Controller()
   {
      model=new Model();
   }
   
   public Die[] roll(boolean b1, boolean b2, boolean b3, boolean b4, boolean b5)
   {
      return model.roll(b1,b2, b3, b4, b5);
   }
   
   public void setPlayers(int players)
   {
      model.setPlayers(players);
   }
   
   public void endTurn()
   {
      model.endTurn();
   }
   
   public boolean setScore(String scoringLoc)
   {
      return model.setScore(scoringLoc);
   }
   
   public String[] getPossible()
   {
      return model.getPossible();
   }
   
   public Object[][] getScoreCard()
   {
      return model.getScoreCard();
   }
   
   public String getWinner()
   {
      return model.getWinner();
   }
   public int getScore()
   {
      return model.getScore();
   }
   
   public Die[] getHand()
   {
      return model.getHand();
   }  
}