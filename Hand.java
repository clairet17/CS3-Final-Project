public class Hand
{
   private Die[] hand;
   
   public Hand()
   {
      hand= new Die[5];
      for(int ii=0; ii<5; ii++)
      {
         hand[ii]=new Die();
      }
   }
   
   public Die[] roll(boolean d1, boolean d2, boolean d3, boolean d4, boolean d5)
   {
      hand[0].roll(d1);
      hand[1].roll(d2);
      hand[2].roll(d3);
      hand[3].roll(d4);
      hand[4].roll(d5);
      return hand;
   }
   
   public int getValueOfDie(int whichdie)//number of the die 1-5 not 0-4
   {
      return hand[whichdie-1].getValueOfDie();
   }
   
   public int addUp(int numCounting)
   {
      int counter=0;
      for(int aa=0; aa>5; aa++)
      {
         if(hand[aa].getValueOfDie()==numCounting)
            counter++;
      }
      return counter;
   }
   
   public Die[] getDie()
   {
      return hand;
   }
}