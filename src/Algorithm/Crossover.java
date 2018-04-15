package Algorithm;

import java.util.Arrays;

public class Crossover {

	public static void crossover(int[][] population, int ranRow1, int ranRow2) {

		int[][] tempMatrix = new int[MainMethodCalls.rows][MainMethodCalls.columns];
		for (int row = 0; row < population.length; row++) {
			for (int col = 0; col < population[row].length; col++) {

				tempMatrix[row][col] = population[row][col];
			}
		}
		System.arraycopy(tempMatrix[ranRow1], 0, population[ranRow2], 0, (population[0].length / 2));
		System.arraycopy(tempMatrix[ranRow2], 0, population[ranRow1], 0, (population[0].length / 2));
	}

	public static void guidedCrossover(int[][] population, int selectedRowIndex) {
		float equation = 0, equationBest = 0;
		int groupSize = PhenotypeFitness.getK();
		int numGroups = ((population[0].length) / groupSize);
		int[][] sums = new int[population.length][numGroups];
		int maxDiff = 0, chosenInd = 0, jindexMaxEquation = 0;	
		
		for (int r = 0; r < population.length; r++) {
			int[] row = population[r];

			for (int g = 0; g < numGroups; g++) {
				int[] group = Arrays.copyOfRange(row, g*groupSize, g*groupSize+groupSize);
				int groupSum = sumOf(group);
				
				/** Deceptive Begins Here **/
				if (groupSum == 0)
					groupSum = 20;
				/** Deceptive Ends Here **/

				sums[r][g] = groupSum;
			}
		}

		int[] selectedRowGroups = sums[selectedRowIndex];
		int[] differences = new int[population.length];

		for (int r = 0; r < population.length; r++) {

			int diff = 0;
			for (int g = 0; g < numGroups; g++)
				diff += Math.abs(selectedRowGroups[g] - sums[r][g]);

			differences[r] = diff;
			
			if (diff > maxDiff) {
				maxDiff = diff;
				chosenInd = r;
			}
		}
		for (int r = 0; r < population.length; r++) {
		/** NON-Deceptive Begins Here **/
		 //int[] maxIndFitness = PhenotypeFitness.getMaxPhenotype(population);
		 //int[] fitnessJ = PhenotypeFitness.getRowsFitnessPhenotype(population, r);
		/** NON-Deceptive Ends Here **/
		/** Deceptive **/
		int[] maxIndFitness = PhenotypeFitness.getMaxDeceptivePhenotype(population);
 		int[] fitnessJ = PhenotypeFitness.getDeceptiveRowFitnessPhenotype(population, r);
		/** Deceptive Ends Here **/
		
			int diff = 0;
			for (int g = 0; g < numGroups; g++)
				diff += Math.abs(selectedRowGroups[g] - sums[r][g]);

			differences[r] = diff;	
			equation = ((float) (((float)diff / ((float)maxDiff)) + (((float)fitnessJ[0])) / ((float)maxIndFitness[0])));
			
			if (equation > equationBest) {
				equationBest = equation;
				jindexMaxEquation = fitnessJ[1];
			}
		}
		crossover(population, selectedRowIndex, jindexMaxEquation); //calls crossover method to cross both creatures

	}

	public static int sumOf(int[] integers) {
		int total = 0;
		for (int i = 0; i < integers.length; i++) {
			if (integers[i] == 1)
				total++;
		}
		return total;
	}
}