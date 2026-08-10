class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fre = new HashMap<>();
        for(int num: nums){
            fre.put(num, fre.getOrDefault(num, 0)+1);
        }
        // 由于HashMap是无序数据结构，内部实现基于哈希表，不保证任何顺序（插入顺序、键大小、值大小都不保证）
        // 排序操作需要有序容器比如List
        List<Map.Entry<Integer, Integer>> entrylist = new ArrayList<>(fre.entrySet());
        entrylist.sort(Comparator.comparing(Map.Entry<Integer, Integer>::getValue).reversed());
        int [] res = new int[k];
        for(int i =0; i<k;i++){
            res[i] = entrylist.get(i).getKey();
        }
        return res;
    }
}
