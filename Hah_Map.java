class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        HashMap<Integer,Integer> p=new HashMap<Integer,Integer>();
        for(int i=0;i<mat.length;i++){
            HashMap<Integer,Integer> m=new HashMap<Integer,Integer>();
            for(int j=0;j<mat[0].length;j++){
                m.put(mat[i][j],m.getOrDefault(mat[i][j],0)+1);
            }
            if(m.containsKey(1)){
            p.put(i,m.get(1));
            }
            else{
                p.put(i,0);
            }
            }
        p = p.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int[] arr=new int[k];
        int j=0;
        for(int i:p.keySet()){
            if(j<k){
            arr[j]=i;
                j=j+1;
            }
        }
        return arr;
    }
}
