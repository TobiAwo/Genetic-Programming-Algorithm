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

	public static void crossoverGuided(int[][] matrix) {
		int difference = 0, mAXdifference = 0, indexRow1;
		indexRow1 = RandomNumbers.rouletteWheelSelection(matrix);
		System.out.println("---- Row 1 index------: " + (indexRow1 + 1));

		int fitnessRow1 = 0;
		int[] row = matrix[indexRow1];
		for (int value : row) {
			fitnessRow1 = fitnessRow1 + value;
		}
		System.out.println("---- Row 1 Fitness--------: " + fitnessRow1 + "\n");

		// int[][] tempMatrix = new int[matrix.length][matrix[i].length];

		for (int indexRow2 = 0; indexRow2 < matrix.length; indexRow2++) {
			int fitnessRow2 = 0;
			for (int k = 0; k < matrix[indexRow2].length; k++) {
				fitnessRow2 += matrix[indexRow2][k];
			}
			System.out.println("---- Row 2 index------: " + (indexRow2 + 1));
			System.out.println("---- Row 2 fitness--------: " + (fitnessRow2));

			if (fitnessRow1 == fitnessRow2) {
				// System.out.println("rows are the same");
				System.out.println("rows are the same\n");
				difference = 0;
				if (difference > mAXdifference) {
					mAXdifference = difference;
					System.out.println("max difference: " + mAXdifference  + "\n");
				}
			}
			if (fitnessRow1 > fitnessRow2) {
				System.out.println("row 1 bigger\n");
				difference = (fitnessRow1 - fitnessRow2);
				if (difference > mAXdifference) {
					mAXdifference = difference;
					System.out.println("max difference: " + mAXdifference  + "\n");

				}
			}
			if (fitnessRow1 < fitnessRow2) {
				System.out.println("row 2 bigger\n");
				difference = (fitnessRow2 - fitnessRow1);
				if (difference > mAXdifference) {
					mAXdifference = difference;
					System.out.println("max difference: " + mAXdifference  + "\n");
				}
			}
		}
		System.out.println("\nlast max difference: " + mAXdifference);
	}
}
