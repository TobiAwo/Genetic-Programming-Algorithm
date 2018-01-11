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
		int totalSum = 0, addedSum = 0, minimum = 0, maximum;
		for (int i = 0; i < matrix.length; i++) {
			for (int k = 0; k < matrix[i].length; k++) {
				totalSum += matrix[i][k];
			}
		}
		maximum = totalSum;
		int randomNum = minimum + (int) (Math.random() * maximum);
		//System.out.println("random index: " + randomNum);

		for (int i = 0; i < matrix.length; i++) {
			for (int k = 0; k < matrix[i].length; k++) {
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
