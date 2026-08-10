class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        if(Arrays.equals(sc, tc)) return true;
        // 比较数组内容，不要使用.equals()而要使用Arrays.equals(),因为数组是Object,用object.equals会比较引用
        // 但是List, String等可以用String.equals(), List.equals()
        return false;
    }
}
