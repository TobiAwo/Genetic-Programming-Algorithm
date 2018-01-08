package Algorithm;
import java.util.Scanner;
//import src.Algorithm.Scanner;

public class PhenotypeFitness {
	

	public static void SeperateTOPhenotype(int[][] matrixCopy) {
		//1,1,1,1,1,1        k=4, col=0
		//0,1,1,1,1,0        x,1,x,0,k
		int k = 3,  xt = 0, count = 0;
		int[][] tempMatrix = new int[MainMethodCalls.rows][k];

		for (int row = 0; row < MainMethodCalls.rows; row++) {
			for (int col = 0; col < (k - 1); col++) {
				for (int x = 0; x < MainMethodCalls.rows; x++) {
					
					System.arraycopy(matrixCopy[x], 0, tempMatrix[x], 0, k);
				}
			}
		}
		System.out.println("\nPhenotype Fitness");
		MainMethodCalls.printMatrix(tempMatrix);
		countRowsFitnessPhenotype(tempMatrix);
	}
	
	public static void countRowsFitnessPhenotype(int[][] tempMatrix) {
		int maxSum = 0;
		int sum = 0;
		System.out.println("\nCreatures Phenotype Fitness");// \\
		for (int i = 0; i < tempMatrix.length; i++) {
			sum = 0;
			int currentSum = 0;
			for (int j = 0; j < tempMatrix[i].length; j++) {

				sum += tempMatrix[i][j];
				currentSum += tempMatrix[i][j];
			}

			if (currentSum > maxSum) {
				maxSum = currentSum;
			}

			System.out.println("Fitness of Phenotype " + (i + 1) + ": " + sum);
		}
		// System.out.println();
		System.out.println("Highest Phenotype Fitness: " + maxSum);
	}
}
