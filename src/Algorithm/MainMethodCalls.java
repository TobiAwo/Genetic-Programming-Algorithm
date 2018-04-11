package Algorithm;
import java.util.Arrays;
import java.util.Random;

public class MainMethodCalls {

	public static int rows = 10, columns = 30, GEN = 150;
	static int[][] population = new int[rows][columns], 
				   populationNext = new int[rows][columns];
	//static Random rnd = new Random();

	public static void main(String[] args) {

		System.out.println("Number of Rows: " + rows);
		System.out.println("Number of Columns: " + columns + "\n");

		/** INITALIZE FIRST POPULATION **/
		fillPopulation(population);
		System.out.println("---------------- \t Initial Popluation \t ----------------\n");
		printMatrix(population);
		System.out.println();
		/** 1. EVALUATE FITNESS **/
		//FitnessFunctions.DisplayEachRowFitness(matrix); //non deceptive
		//FitnessFunctions.DisplayEachDeceptiveRowFitness(matrix); //deceptive
		/** 2. EVALUATE PHENOTYPE FITNESS **/
		//PhenotypeFitness.SeperateTOPhenotype(matrix);//Phenotype
		
		//PhenotypeFitness.evaluatePhenFitness(matrix);//Phenotype //non deceptive 
		//PhenotypeFitness.evaluateDeceptivePhenFitness(matrix);//Phenotype // deceptive
		
		
		for (int g = 0; g < GEN; g++) {
			System.out.println("---------------- \t New Generation ("+(g+1)+") \t ----------------");
			/** - EVALUATE FITNESS - **/
			/** TOURNAMENT SELECTION **/
			for (int i = 0; i < rows; i++) {
				
				/** 1.1 Entire Row Fitness Function with non-deceptive landscape **/
				//fillMatrixNext(population, populationNext, FitnessFunctions.tournamentSelection(population,
						//(FitnessFunctions.getRowFitness(population, RandomNumbers.getRandomRow())), 
									//(FitnessFunctions.getRowFitness(population, RandomNumbers.getRandomRow()))), i);
				
				/** 1.2 Entire Row Fitness Function with deceptive landscape **/
				//fillMatrixNext(population, populationNext, FitnessFunctions.tournamentSelection(population,
						//(FitnessFunctions.getDeceptiveRowFitness(population, RandomNumbers.getRandomRow())), 
									//(FitnessFunctions.getDeceptiveRowFitness(population, RandomNumbers.getRandomRow()))), i);

				/** 2.1 Phenotype Fitness Function with non-deceptive landscape**/
				fillMatrixNext(population, populationNext, PhenotypeFitness.phenotypeTournamentSelection(population,
						(PhenotypeFitness.getRowsFitnessPhenotype(population, RandomNumbers.getRandomRow())), 
									(PhenotypeFitness.getRowsFitnessPhenotype(population, RandomNumbers.getRandomRow()))), i);
						
				/** 2.2 Phenotype Row Fitness Function with deceptive landscape **/
				//fillMatrixNext(population, populationNext, PhenotypeFitness.phenotypeTournamentSelection(population,
						//(PhenotypeFitness.getDeceptiveRowFitnessPhenotype(population, RandomNumbers.getRandomRow())), 
									//(PhenotypeFitness.getDeceptiveRowFitnessPhenotype(population, RandomNumbers.getRandomRow()))), i);
				
				/** 2.3 Phenotype Fitness Function with Roulette Wheel Selection TODO**/
				//fillMatrixNext(matrix, populationNext, PhenotypeFitness.evaluatePhenRowsFitness(matrixPhen,
						//(PhenotypeFitness.getRowsFitnessPhenotype(matrixPhen, RandomNumbers.rouletteWheelSelection(matrixPhen))), 
									//(PhenotypeFitness.getRowsFitnessPhenotype(matrixPhen, RandomNumbers.getRandomRow()))), i);	
				
			
			}
			
			int mutatepercentage = 10, crosspercentage = 80, elitismpercentage = 0;
			int mutationRate = (int)(rows*(mutatepercentage/100.0f));
			int crossoverRate = (int)(rows*(crosspercentage/100.0f));
			int elitismRate = (int)(rows*(elitismpercentage/100.0f));

			for (int rate = 0; rate < mutationRate; rate++) {
				/** MUTATION **/
				Mutation.mutation(populationNext, RandomNumbers.getRandomRow(), RandomNumbers.getRandomColumn());
			}

			for (int rate = 0; rate < crossoverRate; rate++) {
				
				/** STANDARD CROSSOVER **/
				//Crossover.crossover(populationNext, RandomNumbers.getRandomRow(), RandomNumbers.getRandomRow());

				/** GUIDED CROSSOVER **/
				
				/** Non-Deceptive Landscape**/
				int[] phenFitness1 = PhenotypeFitness.getRowsFitnessPhenotype(populationNext, RandomNumbers.getRandomRow());
				int[] phenFitness2 = PhenotypeFitness.getRowsFitnessPhenotype(populationNext, RandomNumbers.getRandomRow());

				/** Deceptive Landscape **/
//				int[] decphenFitness1 = PhenotypeFitness.getDeceptiveRowFitnessPhenotype(populationNext, RandomNumbers.getRandomRow());
//				int[] decphenFitness2 = PhenotypeFitness.getDeceptiveRowFitnessPhenotype(populationNext, RandomNumbers.getRandomRow());

				/** Common **/
				int betterPhenFitness = PhenotypeFitness.phenotypeTournamentSelection(populationNext,(phenFitness1),(phenFitness2));
				Crossover.guidedCrossover(populationNext, betterPhenFitness);
			}
			
			for (int rate = 0; rate < elitismRate; rate++) {
				/** ELITISM **/
				
				/** Non-Deceptive **/
				int[] output =  PhenotypeFitness.getMaxPhenotype(population);
				/** Deceptive **/
//				int[] decoutput =  PhenotypeFitness.getMaxDeceptivePhenotype(matrix);
				
				/** Common **/
				fillMatrixNext(population, populationNext, output[1], elitismRate);
			}

			/** UPDATE POPULATION **/
			updatePopulation();
			
		}
		
		System.out.println("--------------- \t Final Generation \t ----------------\n");
		printMatrix(population);
		System.out.println();
	}

	public static void fillPopulation(int[][] matrix) {
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				matrix[row][col] = RandomNumbers.getRandomGene();
			}
		}
	}
	
	public static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	public static void fillMatrixNext(int[][] matrixCopy, int[][] 
								matrixNextCopy, int biggestRowSumIndexIn, int nextRow) {

		System.arraycopy(matrixCopy[biggestRowSumIndexIn], 0, matrixNextCopy[nextRow], 0,
				(matrixCopy[biggestRowSumIndexIn].length));

	}
	
	public static void updatePopulation() {
		for (int j = 0; j < rows; j++) {
			for (int k = 0; k < columns; k++) {
				population[j][k] = populationNext[j][k];
			}
		}		
	}
}