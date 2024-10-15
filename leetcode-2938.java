// Q : https://leetcode.com/problems/separate-black-and-white-balls/description/

class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        int i = 0;
        int j = n-1;
        long ans = 0;

        while(i<j){
            while(i<n && s.charAt(i) == '0') i++;
            while(j>=0 && s.charAt(j) == '1') j--;
            if(i<j){
                ans += j-i;
                i++;
                j--;
            }
        }

        return ans;
    }
}
