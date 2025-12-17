package matrixPuzzle;

public class Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[5][5];
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				arr[i][j] = (int)(Math.random() * 15) + 1;
				System.out.print(arr[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println(detectEquivalentAdjacentPairs(arr));
		checkDuplicates(arr);
		shiftRight(arr, 2, 3);
	}
	public static int detectEquivalentAdjacentPairs(int[][] arr) {
		int count = 0;
		int temp = 0;
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				temp = arr[i][j];
				if (j < 5)
				{
					if (arr[i][j + 1] == temp) {
						count++;
					}
				}
			}
		}
		return count;
	}
	public static void checkDuplicates(int[][] arr) {
		int[] countArr = new int[16];
		int temp = 0;
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				temp = arr[i][j];
				countArr[temp]++;
			}
		}
		for (int k = 0; k <= 15; k++) {
			if (countArr[k] > 0) {
				System.out.println(k + ": " + countArr[k]);
			}	
		}
	}
	public static void shiftRight(int[][] arr, int shift, int row) {
		int[] tempArrary = new int[5];
		for (int i = 0; i < 5; i++)
		{
			if (i >= 5 - shift) {
				tempArrary[shift + (5 - shift) - 1] = arr[row][i];
			}
			else {
				tempArrary[i + shift] = arr[row][i];
			}
		}
		arr[row] = tempArrary;
	}
}
