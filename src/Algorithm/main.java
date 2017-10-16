package Algorithm;

import java.util.Arrays;

public class main {

	private static int rows = 100;
	private static int columns = 20;
	static int[][] matrix = new int[rows][columns];
	static int[][] matrixNext = new int[rows][columns];
	static int countRows = matrix.length;
	static int countColumns = matrix[0].length;
	static int GEN = 100;

	public static void main(String[] args) {

		System.out.println("Number of Rows: " + countRows);
		System.out.println("Number of Columns: " + countColumns + "\n");

		// initialise population
		fillMatrix(matrix);
		System.out.println("---------------- \t Initial Popluation \t ----------------\n");
		printMatrix(matrix);
		System.out.println();
		evaluateOverallFitness(matrix);
		System.out.println();

		for (int g = 0; g < GEN; g++) {

			System.out.println("---------------- \t New Generation \t ----------------");

			// evaluate fitnesses
			// evaluateFitness(matrix);

			System.out.println();

			// tournament selection
			for (int i = 0; i < rows; i++) {
				fillMatrixNext(matrix, matrixNext, evaluateRows(matrix, (FindSumforRow(matrix, getRandomRow())),
						(FindSumforRowTwo(matrix, getRandomRow()))), i);
				// printMatrix(matrixNext);
				// mutation
				// crossover
			}

//			mutation
//			System.out.println("MUTATION");
			printMatrix(matrixNext);
			mutation(matrixNext, getRandomRow(), getRandomColumn());

			// crossover
			//System.out.println("CROSSOVER");
			//printMatrix(matrixNext);
			crossover(matrixNext, getRandomRow(), getRandomRow());
			//System.out.println("AFTER -------------- CROSSOVER");
			//printMatrix(matrixNext);


			// update population
			for (int j = 0; j < rows; j++) {
				for (int k = 0; k < columns; k++) {
					matrix[j][k] = matrixNext[j][k];
				}
			}

			// mutation

		}
		System.out.println("------------- \t Final Popluation \t -------------\n");
		printMatrix(matrix);
		System.out.println();
		evaluateOverallFitness(matrix);
		// System.out.println("-----------------------\t Final Popluation \t
		// -----------------------");
		// printMatrix(matrixNext);
	}

	public static int getRandomFitness() {
		int minimum = 0;
		int maximum = 2;
		int randomNum = minimum + (int) (Math.random() * maximum);
		return randomNum;
	}

	public static int getRandomRow() {
		int minimum = 0;
		int maximum = (rows);/// rows-1
		int randomNum = minimum + (int) (Math.random() * maximum);
		return randomNum;
	}

	public static int getRandomColumn() {
		int minimum = 0;
		int maximum = (columns);
		int randomNum = minimum + (int) (Math.random() * maximum);
		// System.out.println("random"+randomNum);
		return randomNum;
	}

	public static void fillMatrix(int[][] matrix) {

		for (int row = 0; row < countRows; row++) {
			for (int col = 0; col < countColumns; col++) {
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

	public static int[] FindSumforRow(int matrix[][], int rowIndex) {
		int sum = 0;
		int[] row = matrix[rowIndex];
		for (int value : row) {
			sum = sum + value;
		}
		System.out.println("\nThe Sum of value in row " + (rowIndex + 1) + ": is " + sum);

		int ar[] = new int[2];
		ar[0] = sum;
		ar[1] = rowIndex;

		return ar;
	}

	public static int[] FindSumforRowTwo(int[][] matrix, int rowIndex) {
		int sum = 0;
		int[] row = matrix[rowIndex];
		for (int value : row) {
			sum = sum + value;
		}
		System.out.println("The Sum of value in row " + (rowIndex + 1) + ": is " + sum);

		int ar[] = new int[2];
		ar[0] = sum;
		ar[1] = rowIndex;

		return ar;
	}

	public static int evaluateRows(int[][] matrix, int[] sumIn1, int[] sumIn2) {

		int biggestRowSumIndex = 0;
		if ((sumIn1[0]) > (sumIn2[0])) {

			System.out.println("Row: " + (sumIn1[1] + 1) + " contains greater Fitness of: " + (sumIn1[0]) + "\n");
			biggestRowSumIndex = sumIn1[1];
		} else if ((sumIn1[0]) < (sumIn2[0])) {
			biggestRowSumIndex = sumIn2[1];

			System.out.println("Row: " + (sumIn2[1] + 1) + " contains greater Fitness of: " + (sumIn2[0]) + "\n");
		} else if ((sumIn1[0]) == (sumIn2[0])) {
			biggestRowSumIndex = sumIn1[1];
			System.out.println("Row: " + (sumIn2[1] + 1) + " and " + (sumIn1[1] + 1) + " contains equal fitness of: "
					+ (sumIn1[0]) + " \n");
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

			System.out.println("Fitness of Creature " + (i + 1) + ": " + sum);
		}
		System.out.println();
		System.out.println("Highest Fitness: " + maxSum);

	}

	public static void mutation(int[][] matrix, int ranRow, int ranCol) {

		//System.out.println("ROW : " + (ranRow + 1));
		//System.out.println("COLUMN: " + (ranCol + 1));

		if ((matrix[ranRow][ranCol]) == 0) {
			// System.out.println("000000000000000000000000: ");

			matrix[ranRow][ranCol] = 1;

		} else if ((matrix[ranRow][ranCol]) == 1) {
			// System.out.println("11111111111111111111111111: ");

			matrix[ranRow][ranCol] = 0;

		}
	}
	public static void crossover(int[][] matrixCopy, int ranRow1, int ranRow2) {
		
		int[][] tempMatrix = new int[rows][columns];
		int halfRows = (countRows/2);
	    
		for (int row = 0; row < countRows; row++) {
			for (int col = 0; col < countColumns; col++) {

				tempMatrix[row][col] = matrixCopy[row][col];
			}
		}
		//System.out.println("Random row 1: " + ranRow1);
		//System.out.println("Random row 2: " + ranRow2);
		System.arraycopy(tempMatrix[ranRow1], 0, matrixCopy[ranRow2], 0, (matrixCopy[0].length/2));
		System.arraycopy(tempMatrix[ranRow2], 0, matrixCopy[ranRow1], 0, (matrixCopy[0].length/2));
	}
}