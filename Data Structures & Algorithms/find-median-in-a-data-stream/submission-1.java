class MedianFinder {
    private double median;
    private List<Integer> array;

    public MedianFinder() {
        this.median = 0.0;
        this.array = new ArrayList<>();
    }
    
    public void addNum(int num) {
        array.add(num);
    }
    
    public double findMedian() {
        Collections.sort(array); // 每次调用时排序（不高效）
        int n = array.size();
        if (n % 2 == 1) {
            return array.get(n / 2); // 奇数时取中间值
        } else {
            return (array.get(n / 2 - 1) + array.get(n / 2)) / 2.0; // 偶数取中间两个的平均
        }
    }
}
