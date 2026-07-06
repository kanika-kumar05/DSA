class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> arr=new ArrayList<>();
        int frow=0;
        int lrow=matrix.length-1;
        int fcol=0;
        int lcol=matrix[0].length-1;
        while(frow<=lrow && fcol<=lcol){
            for(int i=fcol;i<=lcol;i++){
                arr.add(matrix[frow][i]);
            }
            frow++;
            for(int j=frow;j<=lrow;j++){
                arr.add(matrix[j][lcol]);
            }
            lcol--;
            if(frow<=lrow){
                for(int i=lcol;i>=fcol;i--){
                arr.add(matrix[lrow][i]);
            }
            lrow--;
            }
            if(fcol<=lcol){
                for(int j=lrow;j>=frow;j--){
                arr.add(matrix[j][fcol]);
            }
            fcol++;
            }
        }
        return arr;
    }
}