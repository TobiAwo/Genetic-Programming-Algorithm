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
			if (sum > maxSum) {
				maxSum = sum;
			}
			System.out.println("Fitness of Creature " + (i + 1) + ": " + sum);
		}
		// System.out.println();
		System.out.println("Highest Fitness: " + maxSum);
	}

	public static void fyp() {
		boolean flag = true;
		int[] matrix = new int[] { 0, 0, 0, 0, 0, 0 };
		// int[] matrix = new int[]{1,1,1,1,1,1};
		int[] tempMatrix = new int[] { 0 };
		int first = tempMatrix[0];
		for (int i = 1; i < 6 && flag; i++) {
			if (matrix[i] != first)
				flag = false;
			System.out.println(flag);
			System.out.println(matrix[i]);

		}
		if (flag)
			System.out.println("ok");
		if (!flag)
			System.out.println("not ok");
	}

	public static void DisplayEachDeceptiveRowFitness(int[][] matrix) {
		int maxSum = 0, sum;
		boolean isSame = true;
		int[][] tempMatrix = new int[][] { { 0 } };
		int marker = tempMatrix[0][0];

		System.out.println("Creatures Fitness");
		for (int i = 0; i < matrix.length; i++) {
			sum = 0; isSame = true;
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] != marker)
					isSame = false;
				if (matrix[i][j] == 1) 
					sum++;
			}
			if (isSame) {
				sum  = 20;	
				System.out.println("ok");
			}
			if (!isSame)
				System.out.println("not ok");
			if (sum > maxSum)
				maxSum = sum;
			System.out.println("Fitness of Creature " + (i + 1) + ": " + sum);
		}
		System.out.println("Highest Fitness: " + maxSum);
	}

	/** 2 - Fitness Function - Gets fitness and index of individual chromosome **/
	public static int[] getRowFitness(int matrix[][], int rowIndex) {
		int sum = 0;
		int[] row = matrix[rowIndex];
		for (int value : row) {
			if (value == 1)
				sum++;
		}
		System.out.println("The sum of value in row " + (rowIndex + 1) + ": " + sum);
		int ar[] = new int[2];
		ar[0] = sum;
		ar[1] = rowIndex;

		return ar;
	}
	
	public static int[] getDeceptiveRowFitness(int matrix[][], int rowIndex) {
		int sum = 0;
		int[] row = matrix[rowIndex];
		for (int value : row) {
			if (value == 1)
				sum++;
		}
		System.out.println("The sum of value in row " + (rowIndex + 1) + ": " + sum);
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

	public static int overallPopulationFitness(int[][] matrix) {
		int totalSum = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int k = 0; k < matrix[i].length; k++) {
				if (matrix[i][k] == 1)
					totalSum++;
			}
		}
		System.out.println("sum: " + totalSum);
		return totalSum;
	}
}
