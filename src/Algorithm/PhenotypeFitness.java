package Algorithm;
//import src.Algorithm.Scanner;

public class PhenotypeFitness {
	
	public static int getK() {
		int k = 3;
		return k;
	}
	public static void SeperateTOPhenotype(int[][] matrixCopy) {
		//1,1,1,1,1,1  k=4, col=0 //0,1,1,1,1,0   x,1,x,0,k
		//int k = 3,  xt = 0;
		int xt = 0;
		int k = getK();
		int[][] matrixPhen = new int[MainMethodCalls.rows][k];

		for (int row = 0; row < MainMethodCalls.rows; row++) {
			for (int col = 0; col < (k - 1); col++) {
				for (int x = 0; x < MainMethodCalls.rows; x++) {
					
					System.arraycopy(matrixCopy[x], xt, matrixPhen[x], 0, k);
				}
			}
		}
		MainMethodCalls.matrixPhen = matrixPhen;
		System.out.println("\nPhenotype population");//outputin
		MainMethodCalls.printMatrix(matrixPhen);//outputin
	}
	
	/** 1 - NON-Deceptive - Gets fitness of every phenotype chromosome in the population **/
	public static void evaluatePhenFitness(int[][] matrixPhen) {
		int maxSum = 0, sum;
		//System.out.println("\nCreatures Phenotype Fitness");//output
		for (int i = 0; i < matrixPhen.length; i++) {
			sum = 0;
			for (int j = 0; j < matrixPhen[i].length; j++) {
				if (matrixPhen[i][j] == 1)		
					sum++;
			}
			if (sum > maxSum) {
				maxSum = sum;
			}
			//System.out.println("Fitness of Phenotype " + (i + 1) + ": " + sum);//output
		}
		//System.out.println("Highest Phenotype Fitness: " + maxSum);//output
	}
	
	/** 2 - NON-Deceptive - Phenotype Fitness Function - Gets fitness and index of individual chromosome **/
	public static int[] getRowsFitnessPhenotype(int matrixPhen[][], int rowIndex) {
		return FitnessFunctions.getRowFitness(matrixPhen, rowIndex);
	}
	
	/** 1 - Deceptive - Gets fitness of every phenotype chromosome in the population **/
	public static int evaluateDeceptivePhenFitness(int[][] matrixPhen) {
		int maxSum = 0, sum;
		boolean isSame = true; //added
		System.out.println("\nCreatures Phenotype Fitness");
		for (int i = 0; i < matrixPhen.length; i++) {
			sum = 0;
			isSame = true; //added
			for (int j = 0; j < matrixPhen[i].length; j++) {
				if (matrixPhen[i][j] == 1)	{
					sum++;
					isSame = false; //added
				}
			}
			if (isSame)   //added
				sum = 20; //added
			if (sum > maxSum) {
				maxSum = sum;
			}
			//System.out.println("Fitness of Phenotype " + (i + 1) + ": " + sum); //out
		}
		//System.out.println("Highest Phenotype Fitness: " + maxSum); //out
		return maxSum;
	}
	
	/** 2 - Deceptive - Phenotype Fitness Function - Gets fitness and index of individual chromosome **/
	public static int[] getDeceptiveRowFitnessPhenotype(int matrixPhen[][], int rowIndex) {
		return FitnessFunctions.getDeceptiveRowFitness(matrixPhen, rowIndex);
	}
	
	public static int evaluatePhenRowsFitness(int[][] matrixPhen, int[] sumIn1, int[] sumIn2) {
		return FitnessFunctions.evaluateRowsFitness(matrixPhen, sumIn1, sumIn2);
	}
	
	public static int overallPhenPopulationFitness(int[][] matrixPhen) {
		return FitnessFunctions.overallPopulationFitness(matrixPhen);
	}
}