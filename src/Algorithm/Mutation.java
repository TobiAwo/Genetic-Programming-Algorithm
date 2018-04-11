package Algorithm;

public class Mutation {

	public static void mutation(int[][] population, int ranRow, int ranCol) {
		
		if ((population[ranRow][ranCol]) == 0) {
			population[ranRow][ranCol] = 1;
		} else if ((population[ranRow][ranCol]) == 1) {
			population[ranRow][ranCol] = 0;
		}
	}
	
}
