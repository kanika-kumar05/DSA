class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int r = mat.length;
        int c = mat[0].length;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            int count = 0;
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0)
                    break;
                count++;
            }
            list.add(new int[] {
                    count, i
            });
        }

        Collections.sort(list,(e1,e2)->{
            if(e1[0]==e2[0]){
                return e1[1]-e2[1];
            }
            return e1[0]-e2[0];
        });

        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=list.get(i)[1];
        }
        return res;
    }

}