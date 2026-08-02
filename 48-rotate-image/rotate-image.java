class Solution {
    public void rotate(int[][] matrix) {
        int m=matrix.length;
        for(int i=0;i<=m-2;i++){
            for(int j=i+1;j<=m-1;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        
        for(int j=0;j<m;j++){
            int left=0,right=m-1;
            while(left<right){
                int temp=matrix[j][left];
                matrix[j][left]=matrix[j][right];
                matrix[j][right]=temp;
                left++;
                right--;

            }

        }
    
    }
}