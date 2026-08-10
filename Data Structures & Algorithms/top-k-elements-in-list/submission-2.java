class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num:nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freq.entrySet());
        entries.sort((e1, e2)->e2.getValue().compareTo(e1.getValue()));
        int[] res = new int[k];
        System.out.print(entries);
        for(int i=0;i<k;i++){
            System.out.print(entries.get(i));
            res[i] = entries.get(i).getKey();
        }
        return res;
    }
}
