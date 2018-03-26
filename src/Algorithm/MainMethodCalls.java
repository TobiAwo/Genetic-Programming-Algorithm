package Algorithm;
import java.util.Arrays;
import java.util.Random;

public class MainMethodCalls {

	public static int rows = 6;//100
	public static int columns = 15;//20
	static int[][] matrix = new int[rows][columns];
	static int[][] matrixNext = new int[rows][columns];
	static int[][] matrixPhen;
	static int[][] matrixPhenNext;
	static Random rnd = new Random();
	static int GEN = 5;//100

	public static void main(String[] args) {

		System.out.println("Number of Rows: " + rows);
		System.out.println("Number of Columns: " + columns + "\n");

		/** INITALIZE FIRST POPULATION **/
		fillMatrix(matrix);
		System.out.println("---------------- \t Initial Popluation \t ----------------\n");
		printMatrix(matrix);
		System.out.println();
		/** 1. EVALUATE FITNESS **/
		//FitnessFunctions.DisplayEachRowFitness(matrix); //non deceptive
		//FitnessFunctions.DisplayEachDeceptiveRowFitness(matrix); //deceptive
		/** 2. EVALUATE PHENOTYPE FITNESS **/
		PhenotypeFitness.SeperateTOPhenotype(matrix);//Phenotype
		//PhenotypeFitness.evaluatePhenFitness(matrixPhen);//Phenotype //non deceptive
		//PhenotypeFitness.evaluatePhenFitness(matrix);//Phenotype //non deceptive
		PhenotypeFitness.evaluateDeceptivePhenFitness(matrix);//Phenotype // deceptive


		System.exit(0);
		
		//PhenotypeFitness.evaluateDeceptivePhenFitness(matrixPhen);//Phenotype //deceptive
		
		for (int g = 0; g < GEN; g++) {
			System.out.println("---------------- \t New Generation ("+(g+1)+") \t ----------------");
			/** - EVALUATE FITNESS - **/
			/** TOURNAMENT SELECTION **/
			for (int i = 0; i < rows; i++) {
				
				/** 1.1 Entire Row Fitness Function with non-deceptive landscape **/
				//fillMatrixNext(matrix, matrixNext, FitnessFunctions.evaluateRowsFitness(matrix,
						//(FitnessFunctions.getRowFitness(matrix, RandomNumbers.getRandomRow())), 
									//(FitnessFunctions.getRowFitness(matrix, RandomNumbers.getRandomRow()))), i);
				
				/** 1.2 Entire Row Fitness Function with deceptive landscape **/
				//fillMatrixNext(matrix, matrixNext, FitnessFunctions.evaluateRowsFitness(matrix,
						//(FitnessFunctions.getDeceptiveRowFitness(matrix, RandomNumbers.getRandomRow())), 
									//(FitnessFunctions.getDeceptiveRowFitness(matrix, RandomNumbers.getRandomRow()))), i);

				/** 2.1 Phenotype Fitness Function **/
				fillMatrixNext(matrix, matrixNext, PhenotypeFitness.evaluatePhenRowsFitness(matrixPhen,
						(PhenotypeFitness.getRowsFitnessPhenotype(matrixPhen, RandomNumbers.getRandomRow())), 
									(PhenotypeFitness.getRowsFitnessPhenotype(matrixPhen, RandomNumbers.getRandomRow()))), i);
			
				/** 2.2 Phenotype Row Fitness Function with deceptive landscape **/
				//fillMatrixNext(matrix, matrixNext, PhenotypeFitness.evaluatePhenRowsFitness(matrixPhen,
						//(PhenotypeFitness.getDeceptiveRowFitnessPhenotype(matrixPhen, RandomNumbers.getRandomRow())), 
									//(PhenotypeFitness.getDeceptiveRowFitnessPhenotype(matrixPhen, RandomNumbers.getRandomRow()))), i);
				
				/** 2.3 Phenotype Fitness Function with Roulette Wheel Selection TODO**/
				//fillMatrixNext(matrix, matrixNext, PhenotypeFitness.evaluatePhenRowsFitness(matrixPhen,
				//		(PhenotypeFitness.getRowsFitnessPhenotype(matrixPhen, RandomNumbers.rouletteWheelSelection(matrixPhen))), 
				//					(PhenotypeFitness.getRowsFitnessPhenotype(matrixPhen, RandomNumbers.getRandomRow()))), i);	
				
/*				//Phenotype Fitness Function
				int[] OutputPhenFitness1 = PhenotypeFitness.getRowsFitnessPhenotype(matrixPhen, RandomNumbers.getRandomRow());
				int[] OutputPhenFitness2 = PhenotypeFitness.getRowsFitnessPhenotype(matrixPhen, RandomNumbers.getRandomRow());
				int OutputEvaluatePhenFitness = PhenotypeFitness.evaluatePhenRowsFitness(matrixPhen,(OutputPhenFitness1),(OutputPhenFitness2));*/
			//	fillMatrixNext(matrix, matrixNext, OutputEvaluatePhenFitness, i);

				/** GUIDED CROSSOVER **/
				//Crossover.crossoverGuided(matrixPhen, OutputEvaluatePhenFitness);
			
			}
			/** UPDATE PHENOTYPE POPULATION **/
			PhenotypeFitness.SeperateTOPhenotype(matrixNext);//Phenotype

			/** MUTATION **/
			Mutation.mutation(matrixNext, RandomNumbers.getRandomRow(), RandomNumbers.getRandomColumn());
			
			/** STANDARD CROSSOVER **/
			Crossover.crossover(matrixNext, RandomNumbers.getRandomRow(), RandomNumbers.getRandomRow());
			
			/** GUIDED CROSSOVER **/
			//Crossover.crossoverGuided(matrixNext, FitnessFunctions.DisplayEachRowFitness(matrixNext)); //non deceptive
			//Crossover.crossoverGuided(matrixNext, FitnessFunctions.DisplayEachDeceptiveRowFitness(matrixNext)); //deceptive
			//Crossover.crossoverGuided(matrixPhen, PhenotypeFitness.evaluatePhenFitness(matrixPhen)); //non deceptive
			//Crossover.crossoverGuided(matrixPhen, PhenotypeFitness.evaluateDeceptivePhenFitness(matrixPhen));
			
			/** UPDATE POPULATION **/
			updatePopulation();
			
		}
		
		System.out.println("--------------- \t Final Generation \t ----------------\n");
		printMatrix(matrix);
		System.out.println();
		//FitnessFunctions.DisplayEachRowFitness(matrix);
		//PhenotypeFitness.SeperateTOPhenotype(matrix);//Phenotype
		//PhenotypeFitness.evaluatePhenFitness(matrixPhen);//Phenotype

	}

	public static void fillMatrix(int[][] matrix) {
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				matrix[row][col] = RandomNumbers.getRandomFitness();
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
				matrix[j][k] = matrixNext[j][k];
			}
		}		
	}
}