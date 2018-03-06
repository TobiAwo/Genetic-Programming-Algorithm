package Algorithm;

public class Crossover {

	public static void crossover(int[][] matrixCopy, int ranRow1, int ranRow2) {

		int[][] tempMatrix = new int[MainMethodCalls.rows][MainMethodCalls.columns];
		for (int row = 0; row < matrixCopy.length; row++) {
			for (int col = 0; col < matrixCopy[row].length; col++) {

				tempMatrix[row][col] = matrixCopy[row][col];
			}
		}
		System.arraycopy(tempMatrix[ranRow1], 0, matrixCopy[ranRow2], 0, (matrixCopy[0].length / 2));
		System.arraycopy(tempMatrix[ranRow2], 0, matrixCopy[ranRow1], 0, (matrixCopy[0].length / 2));
	}

	public static void crossoverGuided(int[][] matrixPhen) {
		/////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		int maxSum = 0, sum;
		System.out.println("Creatures Fitness");
		for (int i = 0; i < matrixPhen.length; i++) {
			sum = 0;
			for (int j = 0; j < matrixPhen[i].length; j++) {
				sum += matrixPhen[i][j];
			}
			if (sum > maxSum) {
				maxSum = sum;
			}
			//System.out.println("Fitness of Creature " + (i + 1) + ": " + sum);
		}
		// System.out.println();
		System.out.println("Highest Fitness: " + maxSum);
		/////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
			
		//int[][] matrix = MainMethodCalls.matrix;
		FitnessFunctions.DisplayEachRowFitness(matrixPhen);
		int difference = 0, mAXdifference = 0, indexRow1, indexMaxDifference = 0;
		
		indexRow1 = RandomNumbers.rouletteWheelSelection(matrixPhen);
		System.out.println("---- Row 1 index------: " + (indexRow1 + 1));

		int fitnessRow1 = 0;
		int[] row = matrixPhen[indexRow1];
		for (int value : row) {
			fitnessRow1 = fitnessRow1 + value;
		}
		System.out.println("---- Row 1 Fitness--------: " + fitnessRow1 + "\n");

		// int[][] tempMatrix = new int[matrixPhen.length][matrixPhen[i].length];

		for (int indexRow2 = 0; indexRow2 < matrixPhen.length; indexRow2++) {
			int fitnessRow2 = 0;
			for (int k = 0; k < matrixPhen[indexRow2].length; k++) {
				
				fitnessRow2 += matrixPhen[indexRow2][k];
			}
			System.out.println("---- Row 2 index------: " + (indexRow2 + 1));
			System.out.println("---- Row 2 fitness--------: " + (fitnessRow2));

			if (fitnessRow1 == fitnessRow2) {
				System.out.println("rows are the same\n");
				difference = 0;
				if (difference > mAXdifference) {
					mAXdifference = difference;
					indexMaxDifference = indexRow2;
					System.out.println("max difference: " + mAXdifference + "\n");
				}
			}
			if (fitnessRow1 > fitnessRow2) {
				System.out.println("row 1 bigger\n");
				difference = (fitnessRow1 - fitnessRow2);
				if (difference > mAXdifference) {
					mAXdifference = difference;
					indexMaxDifference = indexRow2;
					System.out.println("max difference: " + mAXdifference + "\n");

				}
			}
			if (fitnessRow1 < fitnessRow2) {
				System.out.println("row 2 bigger\n");
				difference = (fitnessRow2 - fitnessRow1);
				if (difference > mAXdifference) {
					mAXdifference = difference;
					indexMaxDifference = indexRow2;
					System.out.println("max difference: " + mAXdifference + "\n");
				}
			}
		}
		System.out.println("\nlast max difference: " + mAXdifference);
		System.out.println("\nlast max difference index: " + (indexMaxDifference + 1));

		int fitnessRow2 = 0;
		row = matrixPhen[indexMaxDifference];
		for (int value : row) {
			fitnessRow2 = fitnessRow2 + value;
		}
		System.out.println("---- Row 2 Fitness--------: " + (fitnessRow2) + "\n");
		int[][] matrix = MainMethodCalls.matrix;
		crossover(MainMethodCalls.matrix, indexRow1, indexMaxDifference);
	
		///////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

		System.out.println("Creatures Evaluationn for Equation");
		for (int i = 0; i < matrixPhen.length; i++) {
			int fitnessJ = 0;
			for (int j = 0; j < matrixPhen[i].length; j++) {
				fitnessJ += matrixPhen[i][j];
			}
			/////////////////////////////Equation Here\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
			System.out.println("Fitness of Creature " + (i + 1) + ": " + fitnessJ);
			
			int formulaMax = 0, differenceIJ = 0, finalChosenJ= 0;
			
			int formula = (differenceIJ/mAXdifference) + (fitnessJ/maxSum);
			
			
			///////////////////////////////Equation\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\			
		}
		// System.out.println();
		System.out.println("Highest Fitness: " + maxSum);

		
		///////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

		
		///////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		int formulaMax = 0, differenceIJ = 0, fitnessJ = 0, maxFitness = 0, finalChosenJ= 0;
		maxFitness = maxSum;
		int formula = (differenceIJ/mAXdifference) + (fitnessJ/maxFitness);
		if (formula>formulaMax) {
			formulaMax = formula;
		//finalChosenJ;
		}
		///////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		MainMethodCalls.printMatrix(matrix);

	}
}
