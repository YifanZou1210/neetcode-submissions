class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int num: nums){
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }
        List<Map.Entry<Integer, Integer>> entrylist = new ArrayList<>(hm.entrySet());
        entrylist.sort(Comparator.comparing(Map.Entry<Integer, Integer> ::getValue).reversed());
        int[] res = new int[k];
        for(int i = 0; i<k;i++){
            res[i] = entrylist.get(i).getKey();
        }
        return res;
    }
}
