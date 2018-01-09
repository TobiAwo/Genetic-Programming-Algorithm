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
		FitnessFunctions.evaluateOverallFitness(matrix);
		// EVALUATE PHENOTYPE FITNESS
		//PhenotypeFitness.SeperateTOPhenotype(matrix);
		//PhenotypeFitness.evaluatePhenFitness(matrixPhen);

		System.out.println();

		for (int g = 0; g < GEN; g++) {

			System.out.println("---------------- \t New Generation \t ----------------");

			// EVALUATE FITNESS
			// TOURNAMENT SELECTION
			for (int i = 0; i < rows; i++) {
				//Entire Row
/*				fillMatrixNext(matrix, matrixNext, FitnessFunctions.evaluateRowsFitness(matrix,
						(FitnessFunctions.countRowsFitness(matrix, RandomNumbers.getRandomRow())), 
									(FitnessFunctions.countRowsFitness(matrix, RandomNumbers.getRandomRow()))), i);*/
				
				
				int[] OutputCountRowsFitness = FitnessFunctions.countRowsFitness(matrix, RandomNumbers.getRandomRow());
				int[] OutputCountRowsFitness2 = FitnessFunctions.countRowsFitness(matrix, RandomNumbers.getRandomRow());
				
				int OutputEvaluateRowsFitness = FitnessFunctions.evaluateRowsFitness(matrix,
																	(OutputCountRowsFitness), (OutputCountRowsFitness2));
				fillMatrixNext(matrix, matrixNext, OutputEvaluateRowsFitness, i);
				System.out.println("OutputCountRowsFitness\n"+OutputCountRowsFitness[0] + "\t" + OutputCountRowsFitness[1]);
				System.out.println("OutputCountRowsFitnes2\n"+OutputCountRowsFitness2[0] + "\t" + OutputCountRowsFitness2[1]);
				System.out.println("OutputEvaluateRowsFitness\n"+OutputEvaluateRowsFitness);



//				fillMatrixNext(int[][] matrixCopy, int[][] matrixNextCopy, int biggestRowSumIndexIn, int nextRow);
//				fillMatrixNext(matrix, matrixNext, ew, q, i);
//				evaluateRowsFitness(int[][] matrix, int[] sumIn1, int[] sumIn2);
//				evaluateRowsFitness(matrix, sumIn1, sumIn2);//big	I
//				countRowsFitness(int matrix[][], int rowIndex);
//				
//				int[] enw = FitnessFunctions.countRowsFitness(matrix, RandomNumbers.getRandomRow());
//				int here = FitnessFunctions.evaluateRowsFitness(matrix,(enw),(enw));
//				
//				q = FitnessFunctions.countRowsFitness(matrix, RandomNumbers.getRandomRow());
				
				
			}

			// MUTATION
			//Mutation.mutation(matrixNext, RandomNumbers.getRandomRow(), RandomNumbers.getRandomColumn());

			// CROSSOVER
			//Crossover.crossover(matrixNext, RandomNumbers.getRandomRow(), RandomNumbers.getRandomRow());

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
		FitnessFunctions.evaluateOverallFitness(matrix);
		//PhenotypeFitness.SeperateTOPhenotype(matrix);
		//PhenotypeFitness.evaluatePhenFitness(matrixPhen);


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