package Algorithm;

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

	public static void crossoverGuided(int[][] matrixPhen) {
		int maxFitness = 0;			
		//int[][] matrix = MainMethodCalls.matrix;
		FitnessFunctions.DisplayEachRowFitness(matrixPhen);

		//``````````````````````				 SAME BELOW						````````````````````\\
		int difference = 0, mAXdifference = 0, indexRow1, indexMaxDifference = 0;
		int differenceIJ = 0, equation = 0, equationBest = 0, jindexMaxEquation = 0;

		indexRow1 = RandomNumbers.rouletteWheelSelection(matrixPhen); //gets index one
		System.out.println("---- Row 1 index------: " + (indexRow1 + 1));//prints index one for me to see

		int fitnessRow1 = 0;
		int[] row = matrixPhen[indexRow1]; //puts in index one so that we can get fitness of index one
		for (int value : row) {
			fitnessRow1 = fitnessRow1 + value; //Gets/counts fitness of fitness one
		}
		System.out.println("---- Row 1 Fitness--------: " + fitnessRow1 + "\n"); //Prints fitness of index 1

		// int[][] tempMatrix = new int[matrixPhen.length][matrixPhen[i].length];
		
		//``````````````````````				 SAME ABOVE						````````````````````\\
		
		//``````````````````````				 SAME BELOW						````````````````````\\
		for (int indexRow2 = 0; indexRow2 < matrixPhen.length; indexRow2++) {
			int fitnessRow2 = 0;//Starts count from zero again
			for (int k = 0; k < matrixPhen[indexRow2].length; k++) { // marks one individual
				fitnessRow2 += matrixPhen[indexRow2][k]; //counting 1's
			}
			System.out.println("---- Row 2 index------: " + (indexRow2 + 1)); //printing out index of second creature
			System.out.println("---- Row 2 fitness--------: " + (fitnessRow2)); //printing out index of second creature
			if (fitnessRow2 > maxFitness) { //NEW
				maxFitness = fitnessRow2; //COUNTS MAX DIFFERENCE
			}
			if (fitnessRow1 == fitnessRow2) {
				System.out.println("rows are the same\n");
				difference = 0;
			}
			if (fitnessRow1 > fitnessRow2) {
				System.out.println("row 1 bigger\n");
				difference = (fitnessRow1 - fitnessRow2);
			}
			if (fitnessRow1 < fitnessRow2) {
				System.out.println("row 2 bigger\n");
				difference = (fitnessRow2 - fitnessRow1);
			}
			if (difference > mAXdifference) {
				mAXdifference = difference;
				indexMaxDifference = indexRow2;
				System.out.println("max difference: " + mAXdifference  + "\n");
			}
		}
		System.out.println("\nlast max difference: " + mAXdifference); //prints out index of max difference
		System.out.println("\nlast max difference index: " + (indexMaxDifference+1)); //prints out index of max index creature
		//``````````````````````				 SAME BELOW						````````````````````\\
		
		//``````````````````````			 FORMULA ABOVE PART 1						````````````````````\\
		
		for (int jindex = 0; jindex < matrixPhen.length; jindex++) {//new loop through all creatures starting
			int JsumFitness = 0;
			for (int coll = 0; coll < matrixPhen[jindex].length; coll++) {
				JsumFitness += matrixPhen[jindex][coll];
			}
			System.out.println("Fitness of Creature " + (jindex + 1) + ": " + JsumFitness);		
						
			if (fitnessRow1 == JsumFitness) {
				System.out.println("rows are the same\n");
				differenceIJ = 0;
//				equationBest = (differenceIJ/mAXdifference) + (JsumFitness/maxFitness);
//				if (equation > equationBest) {
//					equationBest = equation;
//					jindexMaxEquation = jindex;
//					System.out.println("max equation: " + jindexMaxEquation + "\n");
//				}
			}
			if (fitnessRow1 > JsumFitness) {
				System.out.println("row 1 bigger\n");
				differenceIJ = (fitnessRow1 - JsumFitness);
//				equationBest = (differenceIJ/mAXdifference) + (JsumFitness/maxFitness);
//				if (equation > equationBest) {
//					equationBest = equation;
//					jindexMaxEquation = jindex;
//					System.out.println("max equation: " + jindexMaxEquation + "\n");
//				}
			}
			if (fitnessRow1 < JsumFitness) {
				System.out.println("row 2 bigger\n");
				differenceIJ = (JsumFitness - fitnessRow1);
//				equationBest = (differenceIJ/mAXdifference) + (JsumFitness/maxFitness);
//				if (equation > equationBest) {
//					equationBest = equation;
//					jindexMaxEquation = jindex;
//					System.out.println("max equation: " + jindexMaxEquation + "\n");
//				}
			}
			equationBest = (differenceIJ/mAXdifference) + (JsumFitness/maxFitness);				
			if (equation > equationBest) {
				equationBest = equation;
				jindexMaxEquation = jindex;
				System.out.println("max equation: " + jindexMaxEquation + "\n");
			}
			System.out.println("\nlast max equation: " + equationBest);
			System.out.println("\nlast max j equation index: " + (jindexMaxEquation + 1));
		} //Loop of all creatures ending	
		
		//``````````````````````			 FORMULA ABOVE PART 1						````````````````````\\

		int fitnessRow2 = 0; //Separate fitness 2
		row = matrixPhen[indexMaxDifference]; //maxdiffrence creature is marked as row to count
		for (int value : row) { //loops till the end of row
			fitnessRow2 = fitnessRow2 + value; //counting the genes
		}
		System.out.println("---- Row 2 Fitness--------: " + (fitnessRow2) + "\n"); //prints fitness of chosen creature
		int[][]matrix = MainMethodCalls.matrix; // gets matrix
		crossover(MainMethodCalls.matrix, indexRow1, jindexMaxEquation); // calls crossover method to cross both creatures
		MainMethodCalls.printMatrix(matrix); // prints new matrix

	}
}