//Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

//You must do it in place.

class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int[] arr1 = new int[m];
        int[] array2=new int[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    arr1[i]=-1;
                    array2[j]=-1;
                }

            }
        }
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                    if(arr1[i]==-1||array2[j]==-1){
                        matrix[i][j]=0;
                    }
                }
        }
    }
}
