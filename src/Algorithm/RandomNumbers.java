package Algorithm;
//import MainMethodCalls;
import java.util.Random;

public class RandomNumbers {
	
	public static int getRandomFitness() {
		int minimum = 0;
		int maximum = 2;
		int randomNum = minimum + (int) (Math.random() * maximum);
		return randomNum;
	}

	public static int getRandomRow() {
		int minimum = 0;
		int maximum = (MainMethodCalls.rows);
		int randomNum = minimum + (int) (Math.random() * maximum);
		return randomNum;
	}

	public static int getRandomColumn() {
		int minimum = 0;
		int maximum = (MainMethodCalls.columns);
		int randomNum = minimum + (int) (Math.random() * maximum);
		return randomNum;
	}
	
	public static int rouletteWheelSelection(double[] wts, Random rnd) {

		  int selected = 0;
		    double total = wts[0];

		    for( int i = 1; i < wts.length; i++ ) {
		        total += wts[i];            
		        if( rnd.nextDouble() <= (wts[i] / total)) 
		        	selected = i;
		    }

		    return selected;   
	}
	
	public static void FitnessBasedonFitness(int[][] tempMatrix) {
		int mAXFitness = 0, fitness = 0, difference = 0, mAXdifference = 0;
		int bestFitness = (difference/mAXdifference) + (fitness/mAXFitness);


	}

}
