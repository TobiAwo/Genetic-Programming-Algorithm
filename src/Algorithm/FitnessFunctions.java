package Algorithm;

public class FitnessFunctions {
	
	public static void evaluateOverallFitness(int[][] matrix) {///0.5
		int maxSum = 0,  sum = 0;
		System.out.println("Creatures Fitness");//\\
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
		//System.out.println();
		System.out.println("Highest Fitness: " + maxSum);

	}

	public static int[] countRowsFitness(int matrix[][], int rowIndex) {//compare rows//1
		int sum = 0;
		int[] row = matrix[rowIndex];
		for (int value : row) {
			sum = sum + value;
		}
		if (sum == 0) {

			sum = 0;
		}
		//System.out.println("The sum of value in row " + (rowIndex + 1) + ": " + sum);

		int ar[] = new int[2];
		ar[0] = sum;
		ar[1] = rowIndex;

		return ar;
	}

	public static int evaluateRowsFitness(int[][] matrix, int[] sumIn1, int[] sumIn2) {////////////////////2

		int biggestRowSumIndex = 0;
		if ((sumIn1[0]) > (sumIn2[0])) {

			//System.out.println("Row: " + (sumIn1[1] + 1) + " contains greater Fitness of: " + (sumIn1[0]) + "\n");
			biggestRowSumIndex = sumIn1[1];
		} else if ((sumIn1[0]) < (sumIn2[0]) || ((sumIn1[0]) == (sumIn2[0]))) {

			biggestRowSumIndex = sumIn2[1];

			//System.out.println("Row: " + (sumIn2[1] + 1) + " contains greater/equal Fitness of: " + (sumIn2[0]) + "\n");
		}

		return biggestRowSumIndex;

	}
}
