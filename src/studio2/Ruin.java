import java.util.Random;
import java.util.Scanner;

public class Ruin {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("How much money are you betting? ($1)");
        int startAmount = in.nextInt();
        int baseMoney = startAmount;

        System.out.println("What is the probability that you will win?");
        double winChance = in.nextDouble();

        System.out.println("At what amount of money do you want to walk?");
        double winLimit = in.nextDouble();

        System.out.println("How many days are you going to bet?");
        int totalSimulations = in.nextInt();


        int dayCount = 0;
        int lossCount = 0;
        double percentRuin = 0.0;
        double expectedRuin = 0.0;
        if (winChance == 0.5) { 
            expectedRuin = 100 * (1 - startAmount / winLimit);
        }
        else {
            expectedRuin = 100 * ((Math.pow((1-winChance)/winChance, startAmount) - Math.pow((1-winChance)/winChance, winLimit))) / (1 - Math.pow((1-winChance)/winChance, winLimit));
        }

        while (dayCount < totalSimulations) { 
            startAmount = baseMoney;
            while (startAmount < winLimit && startAmount != 0) {
            if (Math.random() < winChance) {
                startAmount ++;  
            }
            else {
                startAmount --;
            }
            
        }   
        dayCount ++;  
         if (startAmount >= winLimit){ 
            System.out.println("This is day number " + dayCount + " You Won!");
    
        }
        else {
            System.out.println("This is day number " + dayCount + " You Lost!");
            lossCount ++;
        }
        }
      percentRuin = ((lossCount * 1.0 / (dayCount)) * 100); 
      System.out.println("This time you played for " + dayCount + " days. Your ruin rate was " + percentRuin + "%");
        System.out.println("The expected ruin rate is " + expectedRuin + "%");

    }
}
