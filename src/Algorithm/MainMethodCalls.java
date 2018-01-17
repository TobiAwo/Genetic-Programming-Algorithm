package Algorithm;
import java.util.Arrays;
import java.util.Random;

public class MainMethodCalls {

	public static int rows = 6;//100
	public static int columns = 5;//20
	static int[][] matrix = new int[rows][columns];
	static int[][] matrixNext = new int[rows][columns];
	static int[][] matrixPhen;
	static Random rnd = new Random();
	static int GEN = 1;//100

	public static void main(String[] args) {

		System.out.println("Number of Rows: " + rows);
		System.out.println("Number of Columns: " + columns + "\n");

		/** INITALIZE FIRST POPULATION **/
		fillMatrix(matrix);
		System.out.println("---------------- \t Initial Popluation \t ----------------\n");
		printMatrix(matrix);
		System.out.println();
		/** 1. EVALUATE FITNESS **/
		//FitnessFunctions.DisplayEachRowFitness(matrix);
		/** 2. EVALUATE PHENOTYPE FITNESS **/
		PhenotypeFitness.SeperateTOPhenotype(matrix);//Phenotype
		PhenotypeFitness.evaluatePhenFitness(matrixPhen);//Phenotype
		System.out.println();
		for (int g = 0; g < GEN; g++) {
			System.out.println("---------------- \t New Generation \t ----------------");
			/** - EVALUATE FITNESS - **/
			/** TOURNAMENT SELECTION **/
			for (int i = 0; i < rows; i++) {
				
				/** 1. Entire Row Fitness Function **/
				//fillMatrixNext(matrix, matrixNext, FitnessFunctions.evaluateRowsFitness(matrix,
						//(FitnessFunctions.getRowFitness(matrix, RandomNumbers.getRandomRow())), 
									//(FitnessFunctions.getRowFitness(matrix, RandomNumbers.getRandomRow()))), i);

				/** 2. Phenotype Fitness Function **/
				//fillMatrixNext(matrix, matrixNext, PhenotypeFitness.evaluatePhenRowsFitness(matrixPhen,
				//		(PhenotypeFitness.countRowsFitnessPhenotype(matrixPhen, RandomNumbers.getRandomRow())), 
				//					(PhenotypeFitness.countRowsFitnessPhenotype(matrixPhen, RandomNumbers.getRandomRow()))), i);

				/** 2. Phenotype Fitness Function with Roulette Wheel Selection **/
				fillMatrixNext(matrix, matrixNext, PhenotypeFitness.evaluatePhenRowsFitness(matrixPhen,
						(PhenotypeFitness.countRowsFitnessPhenotype(matrixPhen, RandomNumbers.rouletteWheelSelection(matrixPhen))), 
									(PhenotypeFitness.countRowsFitnessPhenotype(matrixPhen, RandomNumbers.getRandomRow()))), i);			
			}
			
			/** MUTATION **/
			Mutation.mutation(matrixNext, RandomNumbers.getRandomRow(), RandomNumbers.getRandomColumn());
			/** CROSSOVER **/
			Crossover.crossover(matrixNext, RandomNumbers.getRandomRow(), RandomNumbers.getRandomRow());
			/** UPDATE POPULATION **/
			updatePopulation();
		}
		
		System.out.println("--------------- \t Final Generation \t ----------------\n");
		printMatrix(matrix);
		System.out.println();
		//FitnessFunctions.DisplayEachRowFitness(matrix);
		PhenotypeFitness.SeperateTOPhenotype(matrix);//Phenotype
		PhenotypeFitness.evaluatePhenFitness(matrixPhen);//Phenotype

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