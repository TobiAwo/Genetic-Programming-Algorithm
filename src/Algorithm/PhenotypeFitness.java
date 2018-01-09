package Algorithm;
import java.util.Scanner;
//import src.Algorithm.Scanner;

public class PhenotypeFitness {

	public static void SeperateTOPhenotype(int[][] matrixCopy) {
		//1,1,1,1,1,1  k=4, col=0 //0,1,1,1,1,0   x,1,x,0,k
		int k = 3,  xt = 0, count = 0;
		int[][] matrixPhen = new int[MainMethodCalls.rows][k];

		for (int row = 0; row < MainMethodCalls.rows; row++) {
			for (int col = 0; col < (k - 1); col++) {
				for (int x = 0; x < MainMethodCalls.rows; x++) {
					
					System.arraycopy(matrixCopy[x], 0, matrixPhen[x], 0, k);
				}
			}
		}
		MainMethodCalls.matrixPhen = matrixPhen;
		System.out.println("\nPhenotype Fitness");
		MainMethodCalls.printMatrix(matrixPhen);
	}
	
	public static void evaluatePhenFitness(int[][] matrixPhen) {
		int maxSum = 0;
		int sum = 0;
		System.out.println("\nCreatures Phenotype Fitness");// \\
		for (int i = 0; i < matrixPhen.length; i++) {
			sum = 0;
			int currentSum = 0;
			for (int j = 0; j < matrixPhen[i].length; j++) {

				sum += matrixPhen[i][j];
				currentSum += matrixPhen[i][j];
			}

			if (currentSum > maxSum) {
				maxSum = currentSum;
			}

			System.out.println("Fitness of Phenotype " + (i + 1) + ": " + sum);
		}
		// System.out.println();
		System.out.println("Highest Phenotype Fitness: " + maxSum);
	}
	
	public static int[] countRowsFitnessPhenotype(int matrixPhen[][], int rowIndex) {

		return FitnessFunctions.countRowsFitness(matrixPhen, rowIndex);
	}
	
	public static int evaluatePhenRowsFitness(int[][] matrixPhen, int[] sumIn1, int[] sumIn2) {
		
		return FitnessFunctions.evaluateRowsFitness(matrixPhen, sumIn1, sumIn2);

	}

}
