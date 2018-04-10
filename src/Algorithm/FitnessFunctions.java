package Algorithm;

public class FitnessFunctions {

	/** 1 - Gets fitness of every chromosome in the population **/
	public static int[] DisplayEachIndidvidualFitness(int[][] matrix) {
		int maxFitness = 0, sum, chosenIn = 0;
		//System.out.println("Creatures Fitness");//out
		for (int i = 0; i < matrix.length; i++) {
			sum = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 1)
					sum++;
			}
			if (sum > maxFitness) {
				maxFitness = sum;
				chosenIn = i; //new
			}
			System.out.println("Fitness of Creature " + (i) + ": " + sum);//out
		}
		//System.out.println("Highest Fitness in the population: " + maxFitness);//out
		//System.out.println("Chosen index: " + chosenIn);//out //new
		int maxIndiv[] = new int[2];
		maxIndiv[0] = maxFitness;
		maxIndiv[1] = chosenIn;
		return maxIndiv; // new
	}

	/** 2 - Fitness Function - Gets fitness and index of individual chromosome **/
	public static int[] getRowFitness(int matrix[][], int rowIndex) {
		int sum = 0;
		int[] row = matrix[rowIndex];
		for (int value : row) {
			if (value == 1)
				sum++;
		}
		//System.out.println("The sum of value in row " + (rowIndex + 1) + ": " + sum);
		int ar[] = new int[2];
		ar[0] = sum;
		ar[1] = rowIndex;

		return ar;
	}

	/** 1 - Deceptive - Gets fitness of every chromosome in the population **/
	public static int DisplayEachDeceptiveIndividualFitness(int[][] matrix) {
		int maxFitness = 0, sum, chosenIn = 0;
		boolean isSame = true; //added
		//System.out.println("Creatures Fitness"); //out
		for (int i = 0; i < matrix.length; i++) {
			sum = 0;
			isSame = true; //added
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 1) {
					sum++;
					isSame = false; //added
				}
			}
			if (isSame)   //added
				sum = 20; //added
			if (sum > maxFitness) {
				maxFitness = sum;
				chosenIn = i; //new
			}
			//System.out.println("Fitness of Creature " + (i + 1) + ": " + sum); //out
		}
		//System.out.println("Highest Fitness: " + maxSum); //out
		//System.out.println("Chosen index: " + chosenIn);//out //new
		
		return chosenIn; //new
	}

	/** 2-Deceptive-Fitness Function-Gets fitness + index of individual chromosome**/
	public static int[] getDeceptiveRowFitness(int matrix[][], int rowIndex) {
		int sum = 0;
		boolean isSame = true; //added

		int[] row = matrix[rowIndex];
		for (int value : row) {
			if (value == 1) {
				sum++;
				isSame = false; //added
			}
		}
		if (isSame) //added
			sum = 20; //added
		//System.out.println("The sum of value in row " + (rowIndex + 1) + ": " + sum);//output
		int ar[] = new int[2];
		ar[0] = sum;
		ar[1] = rowIndex;

		return ar;
	}

	/** 3 - Compares fitness of two chosen chromosome and gets highest **/// - Tournament selection
	public static int tournamentSelection(int[][] matrix, int[] individual1, int[] individual2) {
		int bestIndividualIndex = 0;
		if ((individual1[0]) > (individual2[0])) {
			bestIndividualIndex = individual1[1];
			// System.out.println("Row: " + (individual1[1] + 1) + " contains greater Fitness of:
			// " + (individual1[0]) + "\n");
		} else if ((individual1[0]) < (individual2[0]) || ((individual1[0]) == (individual2[0]))) {
			bestIndividualIndex = individual2[1];
			// System.out.println("Row: " + (individual2[1] + 1) + " contains greater/equal
			// Fitness of: " + (individual2[0]) + "\n");
		}
		return bestIndividualIndex;
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
