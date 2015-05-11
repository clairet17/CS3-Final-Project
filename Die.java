import java.util.*;
public class Die
{
   private int currentValue;
   private Random random;
   
   public Die()
   {
      currentValue=1;
      random=new Random();
   }
   public void roll(boolean isValid)
   {
      if(isValid==true)
      {
         int temp=random.nextInt(6)+1;
         currentValue=temp;
      }
   }
   
   public int getValueOfDie()
   {
      return currentValue;
   }
}
