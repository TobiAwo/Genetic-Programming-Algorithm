package Algorithm;

public class Mutation {

	public static void mutation(int[][] matrix, int ranRow, int ranCol) {

		if ((matrix[ranRow][ranCol]) == 0) {

			matrix[ranRow][ranCol] = 1;

		} else if ((matrix[ranRow][ranCol]) == 1) {

			matrix[ranRow][ranCol] = 0;
		}
	}
	
}
