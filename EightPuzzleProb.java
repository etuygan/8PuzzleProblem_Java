	
	import java.util.ArrayList;
	import java.util.Iterator;

public class EightPuzzleProb {

		private static int[][] matrix = new int[3][3];
		private static int numberOfMovements = 0;
		static ArrayList<Integer> allVisited = new ArrayList<>();
		
		////////////////////////////////////////////
		
		//initial matrix is: 
		
		public int[][] initial(){
			
			matrix[0][0] = 0;
			matrix[0][1] = 1;
			matrix[0][2] = 3;
			matrix[1][0] = 4;
			matrix[1][1] = 2;
			matrix[1][2] = 5;
			matrix[2][0] = 7;
			matrix[2][1] = 8;
			matrix[2][2] = 6;
			
			return matrix;
		}
		
		////////////////////////////////////////////
		
		//goal matrix is: 
		
		public static int[][] goal(){
			
			matrix[0][0] = 1;
			matrix[0][1] = 2;
			matrix[0][2] = 3;
			matrix[1][0] = 4;
			matrix[1][1] = 5;
			matrix[1][2] = 6;
			matrix[2][0] = 7;
			matrix[2][1] = 8;
			matrix[2][2] = 0;
			
			return matrix;
		}

		////////////////////////////////////////////
		
		//PRINT MATRIX
		// Print the given matrix to console
		
		public static void printMatrix(int matrix[][])
		{
		    for (int row = 0; row < matrix.length; row++) 
		    {
		        for (int column = 0; column < matrix[row].length;column++) 
		        {
		            System.out.print(matrix[row][column] + " ");
		        }
		        System.out.println();
		    }
		}
		
		////////////////////////////////////////////
		
		//PRINT ARRAY
		// Print the given array to console
		
		public static void printArray(int list[]){
		    for (int i = 0; i < list.length; i++) {
		    	System.out.print(list[i] + " ");
		    }
		    System.out.println();
		    }

		/////////////////////////////////////////////////
		
		//MATRIX TO ARRAY
		// takes matrix returns it as array
		
		public static int[] matrixToArray (int[][] matrix){
			
			int[]  list = new int[9];
			int k = 0;
			
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length ; j++) {
					list[k] = matrix[i][j];
					k++;
				}
			}
			return list;
		}
		
		////////////////////////////////////////////
		
		//SORT ARRAY
		//takes array returns sorted array with increasing order
		
		public static int[] sortArray(int[] list){

			   int swap = 0;
		         for(int i=0; i<list.length;i++) {
		             for(int k=0; k<list.length;k++) {
		                 if(list[k]>list[i])
		                 {
		                     swap   = list[i];
		                     list[i]= list[k];
		                     list[k]= swap;
		                 }
		             } 
		         } 
		      return list;
		    }
		 
		
		////////////////////////////////////////////
		
		//STEP1 
		//HAS REPEAT
		//Check if initial step has repeat or not
		
		public static void hasRepeat(int[][] matrix){

	    	int[] unsortlist =  matrixToArray(matrix);
			int[] list = sortArray(unsortlist);
			
			String answer = null;
			
			for (int i = 1; i < list.length; i++) {
					if(list[i-1] == list[i])
						answer = "Initial matrix has repeat: " + list[i];	
					else
						answer = "Initial matrix has no repeat";	
				}
			
			System.out.println(answer);
			}

		
		////////////////////////////////////////////
		

		//STEP2
		//Check if the initial state's given numbers are correct
		
		//SUM OF NUMBERS
		
		public static void sumOfNumbers(int[][] matrix){
			
			int totalnumber = 0;
			
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length ; j++) {
					totalnumber =  matrix[i][j] + totalnumber;
					if(totalnumber == 36)
						System.out.println("Sum of numbers in initial state is 36!");
			
		}}}
		
		public static int square(int k){
			return k*k;
		}
		
		//SUM OF SQUARES
		public static void sumOfSquares(int[][] matrix){
			
			int totalnumber = 0;
			
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length ; j++) {
					totalnumber =  square(matrix[i][j]) + totalnumber; 
					if(totalnumber == 204)
						System.out.println("Sum of squares of numbers in initial state is 204!");
			
		}}}
		

		////////////////////////////////////////////
		
		//INVERSIONS
		//checks each element in the given matrix
		//for each element, it finds smaller elements comes after that element 
		
		
	    public static int inversions(int[][] matrix) {

	    	int[] list =  matrixToArray(matrix);
	        int inversion = 0;
	        
	        for (int i = 0; i < list.length; i++) {
	        	for (int j = 0; j < i; j++) {
					if(list[i] != 0 && list[j] != 0){
						if(list[i] < list[j])
							inversion++;
					}	
	        	}
	        }
	        
	        return inversion;
	    }
		
		////////////////////////////////////////////
		
		//STEP3
	    //IS SOLVABLE
		//Check if the puzzle is solvable or not
		
		public static void isSolvable(int inv){
			
			String result = "false";
		
			if (inv % 2 == 0)
			System.out.println("Sum of inversitons are even, Puzzle is solvable!");
			
			else
			System.out.println("Sum of inversitons are odd, Puzzle is not solvable!");
		}
		
		////////////////////////////////////////////
		
		//MISPLACED TILES
		//take the matrix(as array) returns number of misplaced tiles
		
	    public static int misplacedTiles(int[][] matrix) {
	    	
	    	int[] list =  matrixToArray(matrix);
	    	int tiles = 0;
	    	
	        for(int i = 0; i < list.length; i++){
	            if(list[i] != i+1 && list[i] != 0)
	            	tiles++;
	        }
	        return tiles;
	    }
		
		/////////////////////////////////////////////
	    
		//STEP4 
		//HEURISTIC FUNCTION
	    
	    
	    // #1
	    //HAMMING PRIORITY
	  	//The number of blocks in the wrong position +  the number of moves made so far to get to the state;
	  	
	  	public static int HammingPriority(int tiles){
	  		return  tiles + numberOfMovements;
	  	}
	  	
		/////////////////////////////////////////////
	  	
	  	//DISTANCES
	    // gives sum of the distances of the tiles from their goal positions
	    // first for each item find its goal position
	    // then calculate how many positions it needs to move to get into that position

		public static int distances(int[][] matrix){
		
			int totalDis=0;
			int row = 0;
			int col = 0; 
			int k = 1;
			
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if(k<9){
						row = findIndex(k, matrix)[0];
						col = findIndex(k, matrix)[1];
						
						if(matrix[i][j] != k){
							totalDis += Math.abs(row - i);
							totalDis += Math.abs(col - j);
							k++;
						}
						else{
							k++;	
				}
				}
			}
			}
			return totalDis;
		}
		
		///////////////////////////////////////////////////////
		
		//FIND INDEX
		//finds place of the given element in matrix
		public static int[] findIndex(int number, int[][] matrix){
			
			int[] index = new int[2];
			
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if(matrix[i][j] == number){
						index[0]= i;
						index[1]= j;
					}
				}
			}
			return index;
			
		}

		/////////////////////////////////////////////////
		
		// #2
		// MANHATTAN DISTANCE
		//The sum of the distances from the blocks to their goal positions + the number of moves made so far to get to the state
		
		public static int ManhattanDistance(int dist){
			
			return dist + numberOfMovements;
		
		}
		
		/////////////////////////////////////////////////
		
		// FIND GAP
		// checks all index of given matrix and find where is the GAP
		// GAP is represented as "0"
		
		public  static int[] findGap(int matrix[][]){
		
		int[] index = new int[2];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if(matrix[i][j] == 0){
					index[0] = i;
					index[1] = j;
		}
		}
		}
		return index;
		}
		
		/////////////////////////////////////////////////////////
		
		//     	MOVEMENTS!
		
		// MOVE UP
		// Move the GAP one step up and returns new matrix
		// if GAP is on the border it returns given matrix
		
		public   static int[][] moveUp(int index[], int matrix[][]){
		
		int x = index[0];
		int y = index[1];
		
		int[][] moveUpMatrix = new int[3][3];
		
		if (0<x){	
			
			moveUpMatrix = matrix;
			
			int i = matrix[x][y];
			int j = matrix[x-1][y];
			
			moveUpMatrix[x-1][y] = i;
			moveUpMatrix[x][y]   = j; 
			
		}
		else{
			moveUpMatrix = matrix;
		}
		
		return moveUpMatrix;
		}
		
		
		////////////////////////////////////////////
		
		// MOVE DOWN
		// Move the GAP one step down and returns new matrix
		// if GAP is on the border it returns given matrix
		
		public  static int[][] moveDown(int index[], int matrix[][]){
		
		int x = index[0];
		int y = index[1];
		
		int[][] moveDownMatrix = new int[3][3];
		
		if (x<2){
			
			moveDownMatrix = matrix;
			
			int i = matrix[x][y];
			int j = matrix[x+1][y];
			
			moveDownMatrix[x+1][y] = i;
			moveDownMatrix[x][y]   = j; 

			
		}
		else{
			moveDownMatrix = matrix;
		}
		return moveDownMatrix;
		}
		
		
		////////////////////////////////////////////
		
		// MOVE LEFT
		// Move the GAP one step Left and returns new matrix
		// if GAP is on the border it returns 0  given matrix
		
		public  static int[][] moveLeft(int index[], int matrix[][]){
		
		int x = index[0];
		int y = index[1];
		
		int[][] moveLeftMatrix = new int[3][3];
		
		if (0<y){

			moveLeftMatrix = matrix;
			
			int i = matrix[x][y];
			int j = matrix[x][y-1];
			
			moveLeftMatrix[x][y-1] = i;
			moveLeftMatrix[x][y]   = j; 

			
		}
		else{
			moveLeftMatrix = matrix;
		}
		return moveLeftMatrix;
		}
		
		
		////////////////////////////////////////////
		
		// MOVE RIGHT
		// Move the GAP one step Right and returns new matrix
		// if GAP is on the border it returns given matrix
		
		public static int[][] moveRight(int index[], int matrix[][]){
		
		int x = index[0];
		int y = index[1];
		
		int[][] moveRightMatrix = new int[3][3];
		
		if (y<2){
		
		
			moveRightMatrix = matrix;
			
			
			int i = matrix[x][y];
			int j = matrix[x][y+1];
			
			moveRightMatrix[x][y+1] = i;
			moveRightMatrix[x][y]   = j; 

		}
		else{
		moveRightMatrix = matrix;
		}
		return moveRightMatrix;
		}
		
		
		//////////////////////////////////////////
		//////////////////////////////////////////
		/////////////////////////////////////////
		

		
		
		//finds minimum element in given list
		//returns index of minimum element
		
		public static int FindMinIndex(int[] list){
			
			int k = list[0];
			int n = 0;
			for (int i = 1; i < list.length; i++) {
				if(k>list[i]){
					k = list[i];
					n = i;
				}	
			}
			return n;
		}
		
		///////////////////////////////////////////
		
		//add matrix to visited list
		
		public static void addToVisited(int[][] matrix){
		
			String matt = "";
			int[] m= matrixToArray(matrix);
			
			for (int i = 0; i < m.length; i++) {
				matt += m[i]+"";
			}		
			int matr = Integer.parseInt(matt);
			
			allVisited.add(matr);
		}
		
		//////////////////////////////////////////

		//COMPARE TO
		//take all possible children of given matrix
		//finds which one has smaller HammingPriority and ManhattanDistance
		//returns that state
		// number of movement ++

		
		public static int[][] CompareTo(int[] l1, int[] l2, int[] l3, int[] l4, int[][] matrix){
			
			int[][] m = new int[3][3];
			
			int[] h_list = {l1[0], l2[0], l3[0], l4[0]};
			int[] m_list = {l1[1], l2[1], l3[1], l4[1]};
			
			if(notVisited(matrix)){

			if((FindMinIndex(h_list) == 0) || (FindMinIndex(m_list) == 0))
				m=moveUp(findGap(matrix), matrix);
			if((FindMinIndex(h_list) == 1)  || (FindMinIndex(m_list) == 1))
				m=moveDown(findGap(matrix), matrix);
			if((FindMinIndex(h_list) == 2)  || (FindMinIndex(m_list) == 2))
				m=moveLeft(findGap(matrix), matrix);
			if((FindMinIndex(h_list) == 3)  || (FindMinIndex(m_list) == 3))
				m=moveRight(findGap(matrix), matrix);

			}
			
			else{
			
			 //////////

				
			}
			
			
			addToVisited(m);
			System.out.println("chosen next state is: ");
			return m;
		}
		
		////////////////////////////////////////////
		
		public static int[][] chooseOtherChild(int[][] matrix, int[][] matt){
			
			int[][] m = new int[3][3];
		
		
			int [][] m1=moveUp(findGap(matrix), matrix);
			int [][] m2=moveDown(findGap(matrix), matrix);
			int [][] m3=moveLeft(findGap(matrix), matrix);
			int [][] m4=moveRight(findGap(matrix), matrix);

			if(matt != m1)
				m = m1;
			else if(matt != m2)
				m = m2;
			else if(matt != m3)
				m = m3;
			else if(matt != m4)
				m = m4;
			
			return m;
		}
		
		////////////////////////////////////////////

		//check if the state is visited before
		public static boolean notVisited(int[][] matrix){
			
			boolean ans = true;
			
			String matt = "";
			int[] m= matrixToArray(matrix);
			
			for (int i = 0; i < m.length; i++) {
				matt += m[i]+"";
			}		
			int matr = Integer.parseInt(matt);
			
			for(int i=0; i<allVisited.size(); i++){
				if(allVisited.get(i) == matr){
					ans=false;
				}
					
			}
			return ans;
			
		}
		///////////////////////////////////////////
		
		public static void printVisited(){
			
			for (int i = 0; i< allVisited.size(); i++) {
				System.out.println(allVisited.get(i));
			}
		}
		
		////////////////////////////////////////////

		// Checks if we have reached the goal state
		// if so returns "true"
		
		public static int[][] isItGoalState(int numberoftiles, int[][] matrix){
			
			int[][] newMat = new int[3][3];

			if(misplacedTiles(matrix) != 0){
				
				newMat = CompareTo(childUp(matrix), childDown(matrix), childLeft(matrix), childRight(matrix), matrix);
				isItGoalState(misplacedTiles(newMat), newMat);	
			}
			else{
				newMat = goal();
		
			}
			
			return newMat;

		}
				
		////////////////////////////////////////////

		
		
		public static void main(String[] args) {
			
			EightPuzzleProb ep = new EightPuzzleProb();
			
			int[][] m = ep.initial();
			
			System.out.println("initial matrix is: ");
			printMatrix(m);
			
			System.out.println("****************************************");
			System.out.println("goal matrix is: ");
			printMatrix(goal());
			
			System.out.println("****************************************");
			System.out.println("Initial Matrix to Array is: ");
			printArray(matrixToArray(m));
			
			System.out.println("****************************************");
			System.out.println("Sorted Initial Matrix in Array is: ");
			printArray(sortArray(matrixToArray(m)));
			
			System.out.println("****************************************");
			System.out.println("Initial matrix has repeats?: ");
			hasRepeat(ep.initial());
			
			System.out.println("****************************************");
			sumOfNumbers(m);
			sumOfSquares(m);
			
			System.out.println("****************************************");
			System.out.println("Sum of inversions is: " + inversions(m));
			
			System.out.println("****************************************");
			System.out.println("Is puzzle solvable?");
			isSolvable(inversions(m));
			
			System.out.println("****************************************");
			System.out.println("Sum of misplaced tiles is: " + misplacedTiles(m));
			
			System.out.println("****************************************");
			System.out.println("HammingPriority is: " + HammingPriority(misplacedTiles(m)));
			

			System.out.println("****************************************");
			System.out.println("Sum of distances for each to their goal positions: " + distances(m));
			
			System.out.println("****************************************");
			System.out.println("Manhattan Distance is: " + ManhattanDistance(distances(m)));
			
			System.out.println("****************************************");
			System.out.println("GAP's position is: ");
			printArray(findGap(m));
			
			System.out.println("****************************************");
			System.out.println("move UP");
			printMatrix(moveUp(findGap(ep.initial()), ep.initial()));
			System.out.println("move DOWN");
			printMatrix(moveDown(findGap(ep.initial()), ep.initial()));
			System.out.println("move LEFT");
			printMatrix(moveLeft(findGap(ep.initial()), ep.initial()));
			System.out.println("move RIGHT");
			printMatrix(moveRight(findGap(ep.initial()), ep.initial()));

					
			System.out.println("****************************************");
			System.out.println("****************************************");
			
			
			
			printMatrix(isItGoalState(misplacedTiles(ep.initial()), ep.initial()));
			
			

		}
		
		
	}
