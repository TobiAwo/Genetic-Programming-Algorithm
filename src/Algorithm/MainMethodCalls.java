package Algorithm;

import java.util.Arrays;
//import RandomNumbers;

public class MainMethodCalls {

	public static int rows = 10;//100
	public static int columns = 6;//20
	static int[][] matrix = new int[rows][columns];
	static int[][] matrixNext = new int[rows][columns];
	static int[][] matrixPhen;
	static int GEN = 1;//100
//	System.out.println("Number of Phenotypes: ");
//	int k = new Scanner(System.in).nextInt();

	public static void main(String[] args) {

		System.out.println("Number of Rows: " + rows);
		System.out.println("Number of Columns: " + columns + "\n");

		// INITALIZE FIRST POPULATION
		fillMatrix(matrix);
		System.out.println("---------------- \t Initial Popluation \t ----------------\n");
		printMatrix(matrix);
		System.out.println();
		// EVALUATE FITNESS
		//FitnessFunctions.evaluateOverallFitness(matrix);
		// EVALUATE PHENOTYPE FITNESS
		PhenotypeFitness.SeperateTOPhenotype(matrix);
		PhenotypeFitness.evaluatePhenFitness(matrixPhen);

		System.out.println();

		for (int g = 0; g < GEN; g++) {

			System.out.println("---------------- \t New Generation \t ----------------");

			// EVALUATE FITNESS
			// TOURNAMENT SELECTION
			for (int i = 0; i < rows; i++) {
				//Entire Row Fitness Function			
				int[] OutputCountRowsFitness1 = FitnessFunctions.countRowsFitness(matrix, RandomNumbers.getRandomRow());
				int[] OutputCountRowsFitness2 = FitnessFunctions.countRowsFitness(matrix, RandomNumbers.getRandomRow());
				int OutputEvaluateRowsFitness = FitnessFunctions.evaluateRowsFitness(matrix,
																	(OutputCountRowsFitness1), (OutputCountRowsFitness2));
				fillMatrixNext(matrix, matrixNext, OutputEvaluateRowsFitness, i);

				//Phenotype Fitness Function
				int[] OutputPhenFitness1 = PhenotypeFitness.countRowsFitnessPhenotype(matrixPhen, RandomNumbers.getRandomRow());
				int[] OutputPhenFitness2 = PhenotypeFitness.countRowsFitnessPhenotype(matrixPhen, RandomNumbers.getRandomRow());
				int OutputEvaluatePhenFitness = PhenotypeFitness.evaluatePhenRowsFitness(matrixPhen,
																	(OutputPhenFitness1), (OutputPhenFitness2));
				fillMatrixNext(matrix, matrixNext, OutputEvaluatePhenFitness, i);

			}

			// MUTATION
			Mutation.mutation(matrixNext, RandomNumbers.getRandomRow(), RandomNumbers.getRandomColumn());

			// CROSSOVER
			Crossover.crossover(matrixNext, RandomNumbers.getRandomRow(), RandomNumbers.getRandomRow());

			// UPDATE POPULATION
			for (int j = 0; j < rows; j++) {
				for (int k = 0; k < columns; k++) {
					matrix[j][k] = matrixNext[j][k];
				}
			}
		}
		System.out.println("--------------- \t Final Generation \t ----------------\n");
		printMatrix(matrix);
		System.out.println();
		//FitnessFunctions.evaluateOverallFitness(matrix);
		PhenotypeFitness.SeperateTOPhenotype(matrix);
		PhenotypeFitness.evaluatePhenFitness(matrixPhen);


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
	
/*	public static int[][] getMatrixPhen() {
		return matrixPhen;
	}

	public static void setTempMatrix(int[][] matrixPhen) {
		MainMethodCalls.matrixPhen = matrixPhen;
	}*/

/*	public static int getColumns() {
	return columns;
}
public static void setColumns(int columns) {
	MainMethodCalls.columns = columns;
}*/
}