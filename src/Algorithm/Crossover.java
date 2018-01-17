package Algorithm;

public class Crossover {

	public static void crossover(int[][] matrixCopy, int ranRow1, int ranRow2) {

		int[][] tempMatrix = new int[MainMethodCalls.rows][MainMethodCalls.columns];

		for (int row = 0; row < MainMethodCalls.rows; row++) {
			for (int col = 0; col < MainMethodCalls.columns; col++) {

				tempMatrix[row][col] = matrixCopy[row][col];
			}
		}
		System.arraycopy(tempMatrix[ranRow1], 0, matrixCopy[ranRow2], 0, (matrixCopy[0].length / 2));
		System.arraycopy(tempMatrix[ranRow2], 0, matrixCopy[ranRow1], 0, (matrixCopy[0].length / 2));
	}

	public static void crossoverGuided(int[][] matrix, int ranRow1Fitness) {
		// int[][] tempMatrix = new int[matrix.length][matrix[i].length];
		int difference = 0, mAXdifference = 0;
		ranRow1Fitness = RandomNumbers.rouletteWheelSelection(matrix);

		for (int i = 0; i < matrix.length; i++) {
			int ranRow2Fitness = 0;
			for (int k = 0; k < matrix[i].length; k++) {
				ranRow2Fitness += matrix[i][k];
			}
			if (ranRow1Fitness == ranRow2Fitness) {
				difference = 0;
				if (difference > mAXdifference) {
					mAXdifference = difference;
				}
			}
			if (ranRow1Fitness > ranRow2Fitness) {
				difference = (ranRow1Fitness - ranRow2Fitness);
				if (difference > mAXdifference) {
					mAXdifference = difference;
				}
			}
			if (ranRow1Fitness < ranRow2Fitness) {
				difference = (ranRow2Fitness - ranRow1Fitness);
				if (difference > mAXdifference) {
					mAXdifference = difference;
				}
			}
		}
		System.out.println("Highest Fitness: " + mAXdifference);
	}
}
