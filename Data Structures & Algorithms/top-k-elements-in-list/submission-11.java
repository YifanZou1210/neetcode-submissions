class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>(); 
        // calculate frequency of each key 
        for(int i = 0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1); 
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2)->e1.getValue()-e2.getValue()); 
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
            pq.add(entry); 
            if(pq.size()>k){
                pq.poll(); //only sustain k elements inside priorityqueue, better tc
            }
        }
        int[] res = new int[k]; 
        int idx = 0; 
        while(!pq.isEmpty()){
            res[idx++] = pq.poll().getKey();
        }
        return res; 
    }
}
