public class find {
	public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 从右上角开始查找 同理也可以从左下角开始
        int r = 0;
        int c = matrix[0].length - 1;
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    	int[][] matrix = {
    		{1, 2, 8 ,9},
    		{2, 4, 9, 12},
    		{4, 7, 10 ,13},
    		{6, 8, 11, 15}
    	};
    	boolean exist1 = findNumberIn2DArray(matrix, 7);
    	boolean exist2 = findNumberIn2DArray(matrix, 5);
    	System.out.println(exist1);
    	System.out.println(exist2);

    }
}

// 自己的解法 超出时间限制

/** public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        } else {
            return exist(matrix, target, 0, 0);
        }  
    }

    public static boolean exist(int[][] matrix, int target, int i, int j) {
        int row = matrix.length;
        int column = matrix[0].length;
        while (i < row && j < column) {
            if (matrix[i][j] == target) {
                return true;
            }
            return exist(matrix, target, i + 1, j) || exist(matrix, target, i, j + 1);
        }
        return false;
    }
} */