package Algorithm;

public class FitnessFunctions {
    
	/** 1 - Gets fitness of every chromosome in the population **/
	public static void DisplayEachRowFitness(int[][] matrix) {
		int maxSum = 0, sum;
		System.out.println("Creatures Fitness");
		for (int i = 0; i < matrix.length; i++) {
			sum = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 1)		
					sum++;
			}
			if (sum > maxSum) 
				maxSum = sum;
			System.out.println("Fitness of Creature " + (i + 1) + ": " + sum);
		}
		// System.out.println();
		System.out.println("Highest Fitness: " + maxSum);
	}

	/** 2 - Fitness Function - Gets fitness and index of individual chromosome **/
	public static int[] getRowFitness(int matrix[][], int rowIndex) {
		int sum = 0;
		int[] row = matrix[rowIndex];
		for (int value : row) {
			sum = sum + value;
		}
		// System.out.println("The sum of value in row " + (rowIndex + 1) + ": " + sum);
		int ar[] = new int[2];
		ar[0] = sum;
		ar[1] = rowIndex;

		return ar;
	}
	
	/** 3 - Compares fitness of two chosen chromosome and gets highest **/
	public static int evaluateRowsFitness(int[][] matrix, int[] sumIn1, int[] sumIn2) {
		int biggestRowSumIndex = 0;
		if ((sumIn1[0]) > (sumIn2[0])) {
			biggestRowSumIndex = sumIn1[1];
			// System.out.println("Row: " + (sumIn1[1] + 1) + " contains greater Fitness of:
			// " + (sumIn1[0]) + "\n");
		} else if ((sumIn1[0]) < (sumIn2[0]) || ((sumIn1[0]) == (sumIn2[0]))) {
			biggestRowSumIndex = sumIn2[1];
			// System.out.println("Row: " + (sumIn2[1] + 1) + " contains greater/equal
			// Fitness of: " + (sumIn2[0]) + "\n");
		}
		return biggestRowSumIndex;
	}
	
	public static int overallPopulationFitness(int[][]matrix) {
		int totalSum = 0;
		for (int i = 0; i <  matrix.length; i++) {
			for (int k = 0; k < matrix[i].length; k++) {
				totalSum += matrix[i][k];
			}
		}
	//System.out.println("sum: " + totalSum);
	return totalSum;
	}
}
