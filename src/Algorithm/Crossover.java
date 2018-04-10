package Algorithm;

import java.util.Arrays;

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

	//use tournament selection here for index one
	//call evaluateRowsFitness
	public static void guidedCrossover(int[][] matrix, int selectedRowIndex) {
		float equation = 0, equationBest = 0;
		int groupSize = PhenotypeFitness.getK();
		int numGroups = ((matrix[0].length) / groupSize);
		int[][] sums = new int[matrix.length][numGroups];
		int maxDiff = 0, chosenInd = 0, jindexMaxEquation = 0;	
		
		for (int r = 0; r < matrix.length; r++) {
			int[] row = matrix[r];

			for (int g = 0; g < numGroups; g++) {
				int[] group = Arrays.copyOfRange(row, g * 3, g * 3 + groupSize);
				int groupSum = sumOf(group);
				
				/** NON-Deceptive Begins Here **/
				if (Arrays.asList(groupSum).contains(000))
					groupSum = 20;
				/** NON-Deceptive Ends Here **/

				sums[r][g] = groupSum;
			}
		}

		int[] selectedRowGroups = sums[selectedRowIndex];
		int[] differences = new int[matrix.length];

		for (int r = 0; r < matrix.length; r++) {

			int diff = 0;
			for (int g = 0; g < numGroups; g++)
				diff += Math.abs(selectedRowGroups[g] - sums[r][g]);

			differences[r] = diff;
			
			if (diff > maxDiff) {
				maxDiff = diff;
				chosenInd = r;
			}
		}
		System.out.println("\n population");
		System.out.println(Arrays.toString(differences));
		System.out.println("Max difference: " + maxDiff);
		System.out.println("Chosen Index: " + chosenInd);
		
					//////////////////////\\\\\\\\\\\\\\\\\\\\
		
		for (int r = 0; r < matrix.length; r++) {
		/** NON-Deceptive Begins Here **/
		//int[] maxIndFitness = PhenotypeFitness.getMaxPhenotype(matrix);
		//int[] fitnessJ = PhenotypeFitness.getRowsFitnessPhenotype(matrix, r);
		/** NON-Deceptive Ends Here **/
		/** Deceptive **/
		int[] maxIndFitness = PhenotypeFitness.getMaxDeceptivePhenotype(matrix);
 		int[] fitnessJ = PhenotypeFitness.getDeceptiveRowFitnessPhenotype(matrix, r);
		/** Deceptive Ends Here **/
		
			int diff = 0;
			for (int g = 0; g < numGroups; g++)
				diff += Math.abs(selectedRowGroups[g] - sums[r][g]);

			differences[r] = diff;	
			equation = ((float) (((float)diff / ((float)maxDiff)) + (((float)fitnessJ[0])) / ((float)maxIndFitness[0])));
			//System.out.println("SUM: " + fitnessJ[0]); dup
			//System.out.println("Max: " + maxIndFitness[0]);dup
				
			System.out.println("\nfor index: " + fitnessJ[1]);
			System.out.println("Fitness: " + fitnessJ[0]);
			System.out.println("maxFitness: " + maxIndFitness[0]);
			System.out.println("difference beteeen I and J: " + diff);
			System.out.println("max difference: " + maxDiff);
			System.out.println("equation: " + equation);
			System.out.println("Best Current Equation : " + equationBest);
			
			if (equation > equationBest) {
				equationBest = equation;
				jindexMaxEquation = fitnessJ[1];
				System.out.println("max equation changed: " + jindexMaxEquation + "\n" + equationBest);///
			}
		}
		System.out.println("\n"+"FINAL MAX EQUATION SUM IS : " + equationBest);
		System.out.println("SECOND ROW CHOSEN IS: " + (jindexMaxEquation));
		
		/** NON-Deceptive Begins Here **/
		//int[] finalFitnessJ = PhenotypeFitness.getRowsFitnessPhenotype(matrix, jindexMaxEquation);
		/** NON-Deceptive Ends Here **/
		/** Deceptive **/
 		 int[] finalFitnessJ = PhenotypeFitness.getDeceptiveRowFitnessPhenotype(matrix, jindexMaxEquation);
		/** Deceptive Ends Here **/
		System.out.println("FITNESS OF SECOND ROW CHOSEN IS: " + (finalFitnessJ[0]) + "\n");//prints fitness of chosen creature
		crossover(matrix, selectedRowIndex, jindexMaxEquation); //calls crossover method to cross both creatures
		MainMethodCalls.printMatrix(matrix); // prints new matrix

	}

	public static int sumOf(int[] integers) {
		int total = 0;
		for (int i = 0; i < integers.length; i++) {
			if (integers[i] == 1)
				total++;
			//System.out.println("\n integer i:" + integers[i]);
		}
		//System.out.println("\n sum:" + total);
		return total;
	}
	
	
}