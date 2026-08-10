class Solution {
    public boolean isAnagram(String s, String t) {
        /**
        // toCharArray()返回的是char[], 而List<Character>是对象类型的列表
        // Arrays.sort()只适用于数组而不是list
        List<Character> cs = s.toCharArray();
        List<Character> ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        // 比较数组不能用==，equals
        if(cs==ct) return true;
        return false;
        */
        if(s.length()!=t.length()) return false;
        char[] cs = s.toCharArray(), ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs, ct);
    }
}
