package Algorithm;
//import src.Algorithm.Scanner;

public class PhenotypeFitness {

	public static int getK() {
		int k = 3;
		return k;
	}

	public static void SeperateTOPhenotype(int[][] matrixCopy) {
		int xt = 0, k = 3; // int k = getK();
		int[][] matrixPhen = new int[MainMethodCalls.rows][k];

		for (int i = 0; i < ((matrixCopy.length / k) - 1); i += k) {
			for (int j = 0; j < matrixCopy[i].length; j += k) {

				for (int row = 0; row < MainMethodCalls.rows; row++) {
					for (int col = 0; col < (k); col++) {
						for (int x = 0; x < MainMethodCalls.rows; x++) {

							System.arraycopy(matrixCopy[x], xt, matrixPhen[x], 0, k);

						}
					}
				}
				// MainMethodCalls.matrixPhen = matrixPhen; //not needed anymore
				// System.out.println("\nPhenotype population");// outputin //shows atleast 50
				// MainMethodCalls.printMatrix(matrixPhen);// outputin //shows atleast 50
				xt += k;
			}
		}
	}

	/**
	 * 1 - NON-Deceptive - Gets fitness of every phenotype chromosome in the
	 * population
	 **/
	public static int evaluatePhenFitness(int[][] matrixPhen) {
		int maxSum = 0, sum, chosenIn = 0;
		System.out.println("\nCreatures Phenotype Fitness");// output
		for (int i = 0; i < matrixPhen.length; i++) {
			sum = 0;
			for (int j = 0; j < matrixPhen[i].length; j++) {
				if (matrixPhen[i][j] == 1)
					sum++;
			}
			if (sum > maxSum) {
				maxSum = sum;
				chosenIn = i; // new
			}
			System.out.println("Fitness of Phenotype " + (i + 1) + ": " + sum);// output
		}
		System.out.println("Highest Phenotype Fitness: " + maxSum);// output
		System.out.println("Chosen index: " + chosenIn);// out //new
		return chosenIn; // new

	}

	/**
	 * 2 - NON-Deceptive - Phenotype Fitness Function - Gets fitness and index of
	 * individual chromosome
	 **/
	public static int[] getRowsFitnessPhenotype(int matrixPhen[][], int rowIndex) {
		return FitnessFunctions.getRowFitness(matrixPhen, rowIndex);
	}

	/**
	 * 1 - Deceptive - Gets fitness of every phenotype chromosome in the population
	 **/
	public static int evaluateDeceptivePhenFitness(int[][] matrix) {
		int maxSum = 0, sum, chosenIn = 0, count = 0;
		System.out.println("\nCreatures Phenotype Fitness");

		for (int i = 0; i < matrix.length; i++) {
			sum = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				if (j % 3 == 0)
					count = 0;
				if (matrix[i][j] == 1)
					sum++;
				else
					count++;
				if (count == 3) 
					sum += 20;
			}
			if (sum > maxSum) {
				maxSum = sum;
				chosenIn = i; // new
			}
			System.out.println("Fitness of Phenotype " + (i + 1) + ": " + sum); // out
		}
		System.out.println("Highest Phenotype Fitness: " + maxSum); // out
		System.out.println("Chosen index: " + (chosenIn + 1));// out //new
		return chosenIn; // new

	}

	/**
	 * 2 - Deceptive - Phenotype Fitness Function - Gets fitness and index of
	 * individual chromosome
	 **/
	public static int[] getDeceptiveRowFitnessPhenotype(int matrixPhen[][], int rowIndex) {
		int sum = 0, count = 0, i = 0;
		
		int[] row = matrixPhen[rowIndex];
		for (int value : row) {	
			if (i % 3 == 0)
				count = 0;
			i++;
			if (value == 1)
				sum++;
			else
				count++;
			if (count == 3) 
				sum += 20;// added
		}

		 System.out.println("The sum of value in row " + (rowIndex + 1) + ": " + sum);//output

		int ar[] = new int[2];
		ar[0] = sum;
		ar[1] = rowIndex;

		return ar;

	}

	public static int evaluatePhenRowsFitness(int[][] matrixPhen, int[] sumIn1, int[] sumIn2) {
		return FitnessFunctions.evaluateRowsFitness(matrixPhen, sumIn1, sumIn2);
	}

	public static int overallPhenPopulationFitness(int[][] matrixPhen) {
		return FitnessFunctions.overallPopulationFitness(matrixPhen);
	}
}