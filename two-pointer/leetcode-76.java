// Q : https://leetcode.com/problems/minimum-window-substring/description/

class Solution {
    public String minWindow(String s, String t) {
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : t.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        int sIndex = -1;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int n = t.length();
        while(end < s.length()){
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    count++;
                }
                map.put(ch, map.get(ch) - 1);
            }

            while(count == n){
                if(end-start+1 < minLen){
                    minLen = end-start+1;
                    sIndex = start;
                }
                char chl = s.charAt(start);
                if (map.containsKey(chl)) {
                    map.put(chl, map.get(chl) + 1);
                    if (map.get(chl) > 0) {
                        count--;
                    }
                }
                start++;
            }

            end++;
        }

        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
        
    }
}
