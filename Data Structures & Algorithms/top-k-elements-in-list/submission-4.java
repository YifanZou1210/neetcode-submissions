class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fre = new HashMap<>();
        for(int num:nums){
            fre.put(num, fre.getOrDefault(num, 0)+1);
        }
        List<Map.Entry<Integer, Integer>> entrylist = new ArrayList<>(fre.entrySet());
        entrylist.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        int[] res = new int[k];
        for(int i = 0; i<k; i++){
            res[i] = entrylist.get(i).getKey();
        }
        return res;
    }
}
