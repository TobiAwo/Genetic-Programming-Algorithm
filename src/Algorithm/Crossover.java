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

	
	
	
	public static void crossoverGuidedFake(int[][] matrixPhen, int indexRow1) {
		//rename matrixphen to matrix
		float maxFitness = 0, mAXdifference = 0, equation = 0, equationBest = 0;
		int difference = 0, indexMaxDifference = 0;
		int differenceIJ = 0, jindexMaxEquation = 0;
		
		/** NON-Deceptive Begins Here **/
		int[] fitnessRow1 = PhenotypeFitness.getRowsFitnessPhenotype(matrixPhen, indexRow1);
		/** NON-Deceptive Ends Here **/
		
		/** Deceptive **/
// 		int[] fitnessRow1 = PhenotypeFitness.getDeceptiveRowFitnessPhenotype(matrixPhen, indexRow1);
		/** Deceptive Ends Here **/
		
		System.out.println("FIRST ROW CHOSEN IS ------: " + (indexRow1 + 1));// prints index one for me to see //out
		System.out.println("FITNESS OF FIRST ROW CHOSEN IS: " + fitnessRow1[0] + "\n"); // Prints fitness of index 1 //out

		for (int indexRow2 = 0; indexRow2 < matrixPhen.length; indexRow2++) {
			int fitnessRow2 = 0;// Starts count from zero again
			for (int j = 0; j < matrixPhen[indexRow2].length; j++) { // marks one individual
				//fitnessRow2 += matrixPhen[indexRow2][j]; // counting 1's
				if (matrixPhen[indexRow2][j] == 1)
					fitnessRow2++;
			}
			System.out.println("Row 2 index : " + (indexRow2 + 1)); // printing out index of second creature //out
			System.out.println("Row 2 fitness : " + (fitnessRow2)); // printing out fitness of second creature//out
			
			if (fitnessRow2 > maxFitness) { // NEW
				maxFitness = fitnessRow2; // COUNTS MAX FITNESS
			}
			///////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
			int count = 0, saver = 0, minus =0;
			//if (j % 3 == 0)
				count = 0;//left here
			
			if (fitnessRow1[0] == fitnessRow2) {
				System.out.println("- Fitness equal -\n");//out
				difference = 0;
			}
			if (fitnessRow1[0] > fitnessRow2) {
				System.out.println(" - row 1 bigger -\n");//out
				difference = (fitnessRow1[0] - fitnessRow2);
			}
			if (fitnessRow1[0] < fitnessRow2) {
				System.out.println(" - row 2 bigger -\n");//out
				difference = (fitnessRow2 - fitnessRow1[0]);
			}
			//////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
			if (difference > mAXdifference) { // COUNTS MAX DIFFERENCE
				mAXdifference = difference;
				indexMaxDifference = indexRow2;
				System.out.println("max difference: " + mAXdifference);//out
			}
		}
		//Arrays.asList(matrixPhen).contains("21");
		System.out.println("last max difference and fitness: " + (mAXdifference) + " " +(maxFitness)); // prints out index of max difference//out
		System.out.println("last max difference index: " + (indexMaxDifference + 1)); // prints out index of max index
																						// creature//out


	}

	
	
	
	
	//use tournament selection here for index one
	//call evaluateRowsFitness
	public static void crossoverGuided(int[][] matrixPhen, int indexRow1) {
		//rename matrixphen to matrix
		float maxFitness = 0, mAXdifference = 0, equation = 0, equationBest = 0;
		int difference = 0, indexMaxDifference = 0;
		int differenceIJ = 0, jindexMaxEquation = 0;
		
		/** NON-Deceptive Begins Here **/
		//int[] fitnessRow1 = PhenotypeFitness.getRowsFitnessPhenotype(matrixPhen, indexRow1);
		/** NON-Deceptive Ends Here **/
		
		/** Deceptive **/
 		int[] fitnessRow1 = PhenotypeFitness.getDeceptiveRowFitnessPhenotype(matrixPhen, indexRow1);
		/** Deceptive Ends Here **/
		
		System.out.println("FIRST ROW CHOSEN IS ------: " + (indexRow1 + 1));// prints index one for me to see //out
		System.out.println("FITNESS OF FIRST ROW CHOSEN IS: " + fitnessRow1[0] + "\n"); // Prints fitness of index 1 //out

		for (int i = 0; i<10 ; i++) {
			
			int[] test = PhenotypeFitness.getDeceptiveRowFitnessPhenotype(matrixPhen, i);
			System.out.println(String.valueOf(test[0]));
		}
		
		System.out.println("test");
	}
}