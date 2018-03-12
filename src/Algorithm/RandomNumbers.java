package Algorithm;

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

	public static int rouletteWheelSelection(int[][] matrix) {
		int totalSum = 0;
		int addedSum = 0, minimum = 0, maximum;
		for (int i = 0; i < matrix.length; i++) {
			for (int k = 0; k < matrix[i].length; k++) {
				if (matrix[i][k] == 1)
					totalSum ++;
			}
		}
		maximum = totalSum;
		/** randomNum to stop index at **/
		int randomNum = minimum + (int) (Math.random() * maximum);
		//System.out.println("random Number: " + randomNum);
		for (int i = 0; i < matrix.length; i++) {
			for (int k = 0; k < matrix[i].length; k++) {
				if (matrix[i][k] == 1)
				addedSum ++;
			}
			if (addedSum >= randomNum) {
				//System.out.println("i: " + i);
				return i;
			}
		}
		return -1;
	}

	public static void FitnessBasedonFitness(int[][] tempMatrix) {
		int mAXFitness = 0, fitness = 0, difference = 0, mAXdifference = 0;
		int bestFitness = (difference / mAXdifference) + (fitness / mAXFitness);
	}

}
