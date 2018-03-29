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
	public static void crossoverGuided(int[][] matrixPhen, int indexRow1) {
		//rename matrixphen to matrix
		float maxFitness = 0, mAXdifference = 0, equation = 0, equationBest = 0;
		int difference = 0, indexMaxDifference = 0;
		int differenceIJ = 0, jindexMaxEquation = 0;
		
		/** NON-Deceptive Begins Here **/
		int[] nonDecfitnessRow1 = PhenotypeFitness.getRowsFitnessPhenotype(matrixPhen, indexRow1);
		/** NON-Deceptive Ends Here **/
		/** Deceptive **/
 		int[] decFitnessRow1 = PhenotypeFitness.getDeceptiveRowFitnessPhenotype(matrixPhen, indexRow1);
		/** Deceptive Ends Here **/
		
		System.out.println("FIRST ROW CHOSEN IS ------: " + (indexRow1 + 1));// prints index one for me to see //out
		System.out.println("FITNESS OF FIRST ROW CHOSEN IS: " + decFitnessRow1[0] + "\n"); // Prints fitness of index 1 //out

		for (int i = 0; i<10 ; i++) {
			
			int[] rowFitnesses = PhenotypeFitness.getDeceptiveRowFitnessPhenotype(matrixPhen, i);
			
			
		}
		
		System.out.println("test");
	}
	
	public static void decepFitCrossover(int[][] matrix, int selectedRowIndex) { 
		int maxDiff = 0, chosenInd = 0;	
		int groupSize = PhenotypeFitness.getK();
		int numGroups = ((matrix[0].length) / groupSize);
		int[][] sums = new int[matrix.length][numGroups];

		for (int r = 0; r < matrix.length; r++) {
			int[] row = matrix[r];

			for (int g = 0; g < numGroups; g++) {
				int[] group = Arrays.copyOfRange(row, g * 3, g * 3 + groupSize);
				// System.out.println("\n sum:"+groupSize);// outputin //shows atleast 50
				int groupSum = sumOf(group);

				if (Arrays.asList(groupSum).contains(000))
					groupSum = 20;

				sums[r][g] = groupSum;
				// System.out.println("\n sum:"+sums[r][g]);// outputin //shows atleast 50
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
	}

	public static int sumOf(int[] integers) {
		int total = 0;
		for (int i = 0; i < integers.length; i++) {
			if (integers[i] == 1)
				total++;
			System.out.println("\n integer i:" + integers[i]);

		}
		System.out.println("\n sum:" + total);

		return total;
	}
}