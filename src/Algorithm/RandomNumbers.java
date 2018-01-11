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
	
	public static int getRandomTotalSum() {
		int minimum = 0;
		int maximum = FitnessFunctions.overallPopulationFitness(MainMethodCalls.matrix);
		int randomNum = minimum + (int) (Math.random() * maximum);
		System.out.println("random index: " + randomNum);
		return randomNum;
	}
	
	public static int rouletteWheelSelection(int [][] matrix, int totalSum, int randomNum) {
		totalSum = FitnessFunctions.overallPopulationFitness(matrix);
		int addedSum = 0;

		for (int i = 0; i < MainMethodCalls.rows; i++) {
			for (int k = 0; k < MainMethodCalls.columns; k++) {
				addedSum += matrix[i][k];
			}
			if (addedSum >= randomNum) {
				System.out.println("i: " + i);
				return i;
			}
		}
		return -1;
	}
}
