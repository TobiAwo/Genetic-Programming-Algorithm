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

	public static void crossoverGuided(int[][] matrixPhen, int indexRow1) {
		//rename matrixphen to matrix
		float maxFitness = 0, mAXdifference = 0, equation = 0, equationBest = 0;
		int difference = 0, indexMaxDifference = 0;
		int differenceIJ = 0, jindexMaxEquation = 0, fitnessRow1 = 0;

		//System.out.println("FIRST ROW CHOSEN IS ------: " + (indexRow1 + 1));// prints index one for me to see //out
		int[] row = matrixPhen[indexRow1]; // puts in index one so that we can get fitness of index one
		for (int value : row) {
			fitnessRow1 = fitnessRow1 + value; // Gets/counts fitness of fitness one
		}
		//System.out.println("FITNESS OF FIRST ROW CHOSEN IS: " + fitnessRow1 + "\n"); // Prints fitness of index 1 //out

		for (int indexRow2 = 0; indexRow2 < matrixPhen.length; indexRow2++) {
			int fitnessRow2 = 0;// Starts count from zero again
			for (int k = 0; k < matrixPhen[indexRow2].length; k++) { // marks one individual
				fitnessRow2 += matrixPhen[indexRow2][k]; // counting 1's
			}
			//System.out.println("Row 2 index : " + (indexRow2 + 1)); // printing out index of second creature //out
			//System.out.println("Row 2 fitness : " + (fitnessRow2)); // printing out fitness of second creature//out
			if (fitnessRow2 > maxFitness) { // NEW
				maxFitness = fitnessRow2; // COUNTS MAX FITNESS
			}
			if (fitnessRow1 == fitnessRow2) {
				//System.out.println("- Fitness equal -\n");//out
				difference = 0;
			}
			if (fitnessRow1 > fitnessRow2) {
				//System.out.println(" - row 1 bigger -\n");//out
				difference = (fitnessRow1 - fitnessRow2);
			}
			if (fitnessRow1 < fitnessRow2) {
				//System.out.println(" - row 2 bigger -\n");//out
				difference = (fitnessRow2 - fitnessRow1);
			}
			if (difference > mAXdifference) {
				mAXdifference = difference;
				indexMaxDifference = indexRow2;
				//System.out.println("max difference: " + mAXdifference);//out
			}
		}
		//System.out.println("last max difference and fitness: " + (mAXdifference) + " " +(maxFitness)); // prints out index of max difference//out
		//System.out.println("last max difference index: " + (indexMaxDifference + 1)); // prints out index of max index
																						// creature//out

		// `````````````````````` FORMULA ABOVE PART 1 ````````````````````\\
		//System.out.println("\n`FORMULA ABOVE PART 1`\n"); //out
		for (int jindex = 0; jindex < matrixPhen.length; jindex++) {// new loop through all creatures starting
			int JsumFitness = 0;
			for (int coll = 0; coll < matrixPhen[jindex].length; coll++) {
				JsumFitness += matrixPhen[jindex][coll];
			}
			//System.out.println("Fitness of Creature " + (jindex + 1) + ": " + JsumFitness);//out

			if (fitnessRow1 == JsumFitness) {
				//System.out.println("- Fitness equal -\n");//out
				differenceIJ = 0;
			}
			if (fitnessRow1 > JsumFitness) {
				//System.out.println(" - row 1 bigger -\n");//out
				differenceIJ = (fitnessRow1 - JsumFitness);
			}
			if (fitnessRow1 < JsumFitness) {
				//System.out.println(" - row 2 bigger -\n");//out
				differenceIJ = (JsumFitness - fitnessRow1);
			}
			equation = (differenceIJ / mAXdifference) + (JsumFitness / maxFitness);
//			System.out.println("for i: " + jindex);
//			System.out.println("differenceIJ: " + differenceIJ);
//			System.out.println("mAXdifference: " + mAXdifference);
//			System.out.println("JsumFitness: " + JsumFitness);
//			System.out.println("maxFitness: " + maxFitness);
//			System.out.println("equation: " + equation);
//			System.out.println("equationBest: " + equationBest);
			if (equation > equationBest) {
				equationBest = equation;
				jindexMaxEquation = jindex;
				//System.out.println("max equation changed: " + jindexMaxEquation + "\n");//out
			}
		} // Loop of all creatures ending
		//System.out.println("last max equation sum is : " + equationBest);//out
		//System.out.println("SECOND ROW CHOSEN IS ------: " + (jindexMaxEquation + 1));//out
		// `````````````````````` FORMULA BELOW PART 1 ````````````````````\\

		int fitnessRow2 = 0; // Separate fitness 2
		row = matrixPhen[jindexMaxEquation]; // maxdiffrence creature is marked as row to count
		for (int value : row) { // loops till the end of row
			fitnessRow2 = fitnessRow2 + value; // counting the genes
		}
		//System.out.println("FITNESS OF SECOND ROW CHOSEN IS: " + (fitnessRow2) + "\n");//prints fitness of chosen creature//out
		int[][] matrix = MainMethodCalls.matrix; // gets matrix
		crossover(MainMethodCalls.matrix, indexRow1, jindexMaxEquation);
		//calls crossover method to cross both creatures
		//MainMethodCalls.printMatrix(matrix); // prints new matrix //out
	}
}