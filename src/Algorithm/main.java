package Algorithm;

import java.util.Arrays;

public class main {

	private static int rows = 10;
	private static int columns = 10;
	static int[][] matrix = new int[rows][columns];
	static int[][] matrixNext = new int[rows][columns];
	static int GEN = 1;

	public static void main(String[] args) {

		System.out.println("Number of Rows: " + rows);
		System.out.println("Number of Columns: " + columns + "\n");

		// INITALIZE FIRST POPULATION
		fillMatrix(matrix);
		System.out.println("---------------- \t Initial Popluation \t ----------------\n");
		printMatrix(matrix);
		System.out.println();
		// EVALUATE FITNESS
		evaluateOverallFitness(matrix);
		// EVALUATE PHENOTYPE FITNESS
		countRowsFitnessPhenotype(matrix);
		System.out.println();

		for (int g = 0; g < GEN; g++) {

			System.out.println("---------------- \t New Generation \t ----------------");

			// EVALUATE FITNESS
			// TOURNAMENT SELECTION
			for (int i = 0; i < rows; i++) {

				fillMatrixNext(matrix, matrixNext, evaluateRowsFitness(matrix,
						(countRowsFitness(matrix, getRandomRow())), (countRowsFitness(matrix, getRandomRow()))), i);
			}

			// MUTATION
			mutation(matrixNext, getRandomRow(), getRandomColumn());

			// CROSSOVER
			crossover(matrixNext, getRandomRow(), getRandomRow());

			// UPDATE POPULATION
			for (int j = 0; j < rows; j++) {
				for (int k = 0; k < columns; k++) {
					matrix[j][k] = matrixNext[j][k];
				}
			}
		}
		System.out.println("------------- \t Final Popluation \t -------------\n");
		printMatrix(matrix);
		System.out.println();
		evaluateOverallFitness(matrix);
	}

	public static int getRandomFitness() {
		int minimum = 0;
		int maximum = 2;
		int randomNum = minimum + (int) (Math.random() * maximum);
		return randomNum;
	}

	public static int getRandomRow() {
		int minimum = 0;
		int maximum = (rows);
		int randomNum = minimum + (int) (Math.random() * maximum);
		return randomNum;
	}

	public static int getRandomColumn() {
		int minimum = 0;
		int maximum = (columns);
		int randomNum = minimum + (int) (Math.random() * maximum);
		return randomNum;
	}

	public static void fillMatrix(int[][] matrix) {

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				matrix[row][col] = getRandomFitness();
			}
		}
	}

	public static void fillMatrixNext(int[][] matrixCopy, int[][] matrixNextCopy, int biggestRowSumIndexIn,
			int nextRow) {

		System.arraycopy(matrixCopy[biggestRowSumIndexIn], 0, matrixNextCopy[nextRow], 0,
				(matrixCopy[biggestRowSumIndexIn].length));

	}

	public static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}

	public static int[] countRowsFitness(int matrix[][], int rowIndex) {
		int sum = 0;
		int[] row = matrix[rowIndex];
		for (int value : row) {
			sum = sum + value;
		}
		if (sum == 0) {

			sum = 0;
		}
		System.out.println("\nThe Sum of value in row " + (rowIndex + 1) + ": is " + sum);

		int ar[] = new int[2];
		ar[0] = sum;
		ar[1] = rowIndex;

		return ar;
	}

	public static int evaluateRowsFitness(int[][] matrix, int[] sumIn1, int[] sumIn2) {

		int biggestRowSumIndex = 0;
		if ((sumIn1[0]) > (sumIn2[0])) {

			System.out.println("\n" + "Row: " + (sumIn1[1] + 1) + " contains greater Fitness of: " + (sumIn1[0]));
			biggestRowSumIndex = sumIn1[1];
		} else if ((sumIn1[0]) < (sumIn2[0]) || ((sumIn1[0]) == (sumIn2[0]))) {

			biggestRowSumIndex = sumIn2[1];

			System.out.println("\n" + "Row: " + (sumIn2[1] + 1) + " contains greater/equal Fitness of: " + (sumIn2[0]));
		}

		return biggestRowSumIndex;

	}

	public static void evaluateOverallFitness(int[][] matrix) {
		int maxSum = 0;
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum = 0;
			int currentSum = 0;
			for (int j = 0; j < matrix[i].length; j++) {

				sum += matrix[i][j];
				currentSum += matrix[i][j];
			}

			if (currentSum > maxSum) {
				maxSum = currentSum;
			}
			// number zero
			if (i == 0) {

				i = 0;
			}
			// End
			System.out.println("Fitness of Creature " + (i + 1) + ": " + sum);
		}
		System.out.println();
		System.out.println("Highest Fitness: " + maxSum);

	}

	public static void mutation(int[][] matrix, int ranRow, int ranCol) {

		if ((matrix[ranRow][ranCol]) == 0) {

			matrix[ranRow][ranCol] = 1;

		} else if ((matrix[ranRow][ranCol]) == 1) {

			matrix[ranRow][ranCol] = 0;
		}
	}

	public static void crossover(int[][] matrixCopy, int ranRow1, int ranRow2) {

		int[][] tempMatrix = new int[rows][columns];

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {

				tempMatrix[row][col] = matrixCopy[row][col];
			}
		}
		System.arraycopy(tempMatrix[ranRow1], 0, matrixCopy[ranRow2], 0, (matrixCopy[0].length / 2));
		System.arraycopy(tempMatrix[ranRow2], 0, matrixCopy[ranRow1], 0, (matrixCopy[0].length / 2));
	}

	public static void countRowsFitnessPhenotype(int[][] matrixCopy) {
		int k = 3;
		int count = 0, countPlus = 0, countSame = 0;
		
		int[][] tempMatrix = new int[rows][k];

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < (k-1); col++) {
				for (int x = 0; x < rows; x++) {

					 System.arraycopy(matrixCopy[x], count, tempMatrix[x], 0, k);
					 //countSame++;
			
					 }
			}

		}
		System.out.println("\nPhenotype Fitness");
		printMatrix(tempMatrix);	

	}

	public static void countRowsFitnessPhenotypDDDDDDDDDDDDDDDDDe(int[][] matrixCopy) {
		int k = 3;
		int maxSum = 0;
		int sum = 0;
		System.out.println("\n");
		for (int i = 0; i < matrix.length; i++) {
			sum = 0;
			int currentSum = 0;
			for (int j = 0; j < k; j++) {

				sum += matrix[i][j];
				currentSum += matrix[i][j];
			}

			if (currentSum > maxSum) {
				maxSum = currentSum;
			}

			System.out.println("Phenotype Fitness of Creature " + (i + 1) + ": " + sum);
		}
		System.out.println();
		System.out.println("Highest Phenotype Fitness: " + maxSum);

		////////////////////////// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		int[][] tempMatrix = new int[k][columns];

		for (int i = 0; i < rows; i++) {
			sum = 0;
			int currentSum = 0;
			for (int j = 0; j < rows; j++) {

				System.arraycopy(matrixCopy[i], 0, tempMatrix[i], 0, (rows));

			}

			// printMatrix(tempMatrix);

			///////////////////////////////////////////////////////////////////
			// int[][] tempMatrix = new int[k][columns];

			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < k; col++) {

					tempMatrix[row][k] = matrixCopy[row][k];
				}
			}
			// System.arraycopy(tempMatrix[ranRow1], 0, matrixCopy[ranRow2], 0,
			// (matrixCopy[0].length / 2));

			////
		}
	}

}