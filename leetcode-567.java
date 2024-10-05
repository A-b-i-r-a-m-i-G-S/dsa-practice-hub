// Q : https://leetcode.com/problems/permutation-in-string/description/?envType=daily-question&envId=2024-10-04

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int m = s1.length();

        if(m > n) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        for(int i=0;i<m;i++){
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i),0) + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i),0) + 1);
        }

        if(map1.equals(map2)) return true;        

        for(int start = 0, end = m; end < n; start++, end++){
            map2.put(s2.charAt(start), map2.get(s2.charAt(start))-1);
            if(map2.get(s2.charAt(start)) == 0) map2.remove(s2.charAt(start));

            map2.put(s2.charAt(end), map2.getOrDefault(s2.charAt(end),0)+1);

            if(map1.equals(map2)) return true;
        }

        return false;
    }
}
