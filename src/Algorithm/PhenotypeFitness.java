package Algorithm;
//import src.Algorithm.Scanner;

import java.awt.Insets;
import java.lang.reflect.Array;
import java.util.Arrays;

public class PhenotypeFitness {

	public static int getK() {
		int k = 3;
		return k;
	}

	public static void SeperateToPhenotype(int[][] population) {
		int start = 0, k = getK();
		int[][] phenPopulation = new int[MainMethodCalls.rows][k];

		for (int i = 0; i < ((population.length / k) - 1); i += k) {
			for (int j = 0; j < population[i].length; j += k) {

				for (int row = 0; row < MainMethodCalls.rows; row++) {//change
					for (int col = 0; col < (k); col++) {
						for (int x = 0; x < MainMethodCalls.rows; x++) {//change

							System.arraycopy(population[x],start, phenPopulation[x], 0, k);
						}
					}
				}
				// MainMethodCalls.matrixPhen = matrixPhen; //not needed anymore
				 System.out.println("\nPhenotype population");// outputin //shows atleast 50
				 MainMethodCalls.printMatrix(phenPopulation);// outputin //shows atleast 50
				start += k;
			}
		}
	}

	/**
	 * 1 - NON-Deceptive - Gets fitness of every phenotype chromosome in the
	 * population
	 **/
	public static int[] getMaxPhenotype(int[][] phenPopulation) {
		int maxFitness = 0, fitness, chosenIn = 0;
		//System.out.println("\nCreatures Phenotype Fitness");// output
		for (int i = 0; i < phenPopulation.length; i++) {
			fitness = 0;
			for (int j = 0; j < phenPopulation[i].length; j++) {
				if (phenPopulation[i][j] == 1)
					fitness++;
			}
			if (fitness > maxFitness) {
				maxFitness = fitness;
				chosenIn = i; // new
			}
			//System.out.println("Fitness of Phenotype " + (i + 1) + ": " + fitness);// output
		}
		//System.out.println("Highest Phenotype Fitness: " + maxFitness);// output
		//System.out.println("Chosen index: " + chosenIn);// out //new
		int maxIndiv[] = new int[2];
		maxIndiv[0] = maxFitness;
		maxIndiv[1] = chosenIn;
		return maxIndiv; // new

	}

	/**
	 * 2 - NON-Deceptive - Phenotype Fitness Function - Gets fitness and index of
	 * individual chromosome
	 **/
	public static int[] getRowsFitnessPhenotype(int phenPopulation[][], int rowIndex) {
		return FitnessFunctions.getRowFitness(phenPopulation, rowIndex);
	}

	/**
	 * 1 - Deceptive - Gets fitness of every phenotype chromosome in the population
	 **/
	public static int[] getMaxDeceptivePhenotype(int[][] matrix) {
		int maxFitness = 0, fitness, chosenIn = 0, count = 0;
		//System.out.println("\nCreatures Phenotype Fitness");
		for (int i = 0; i < matrix.length; i++) {
			fitness = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				if (j % getK() == 0)
					count = 0;
				if (matrix[i][j] == 1)
					fitness++;
				else
					count++;
				if (count == getK())
					fitness += 20;
			}
			if (fitness > maxFitness) {
				maxFitness = fitness;
				chosenIn = i; // new
			}
			//System.out.println("Fitness of Phenotype " + (i + 1) + ": " + fitness); // out
		}
		//System.out.println("Highest Phenotype Fitness: " + maxFitness); // out
		//System.out.println("Chosen index: " + (chosenIn + 1));// out //new
		
		int maxIndiv[] = new int[2];
		maxIndiv[0] = maxFitness;
		maxIndiv[1] = chosenIn;
		return maxIndiv; // new
	}

	/**
	 * 2 - Deceptive - Phenotype Fitness Function - Gets fitness and index of
	 * individual chromosome
	 **/
	public static int[] getDeceptiveRowFitnessPhenotype(int phenPopulation[][], int rowIndex) {
		int fitness = 0, count = 0, i = 0;
		int[] row = phenPopulation[rowIndex];
		for (int value : row) {
			if (i % getK() == 0)
				count = 0;
			i++;
			if (value == 1)
				fitness++;
			else
				count++;
			if (count == getK())
				fitness += 20;// added
		}
		//System.out.println("The fitness of value in row " + (rowIndex) + ": " + fitness);// output
		int ar[] = new int[2];
		ar[0] = fitness;
		ar[1] = rowIndex;
		return ar;
	}
	public static float[] increasingFitness(int phenPopulation[][], int rowIndex) {
		float fitness = 0, fitnessTotal = 0;
		int count = 0;
		float i = 0;
		int[] row = phenPopulation[rowIndex];
		for (int value : row) {
			
			if (value == 1) {
				fitness++;
			}
			count++;
			
			if (count % getK() == 0) {
				i +=(0.5);
				
				fitness= fitness*i;	
				fitnessTotal+=fitness;

				fitness = 0;				
			}
		}
		System.out.println();
		System.out.println("The fitness of value in row " + (rowIndex) + ": " + fitnessTotal);// output
		float ar[] = new float[2];
		ar[0] = fitnessTotal;
		ar[1] = rowIndex;
		return ar;
	}
	
	public static float[] getMaxIncreasingFitness(int[][] matrix) {
		int chosenIn = 0, count = 0;
		float maxFitness = 0, fitness, fitnessTotal = 0, x = 0;
		System.out.println("\nCreatures Phenotype Fitness");
		for (int i = 0; i < matrix.length; i++) {
			fitness = 0;
			x = 0;
			fitnessTotal = 0;
			for (int j = 0; j < matrix[i].length; j++) {			
				if (matrix[i][j] == 1)
					fitness++;
				count++;
								
				if (count % getK() == 0) {
					x +=(0.5);
					fitness= fitness*x;	
					fitnessTotal+=fitness;
					fitness = 0;				
				}					
			}
			
			if (fitnessTotal > maxFitness) {
				maxFitness = fitnessTotal;
				chosenIn = i; // new
			}
			System.out.println("Fitness of Phenotype " + (i) + ": " + fitnessTotal); // out
		}
		System.out.println("Highest Phenotype Fitness: " + maxFitness); // out
		System.out.println("Chosen index: " + (chosenIn));// out //new
		
		float maxIndiv[] = new float[2];
		maxIndiv[0] = maxFitness;
		maxIndiv[1] = chosenIn;
		return maxIndiv; // new
	}

	public static int phenotypeTournamentSelection(int[][] phenPopulation, int[] sumIn1, int[] sumIn2) {
		return FitnessFunctions.tournamentSelection(phenPopulation, sumIn1, sumIn2);
	}

	public static int overallPhenPopulationFitness(int[][] phenPopulation) {
		return FitnessFunctions.overallPopulationFitness(phenPopulation);
	}
}