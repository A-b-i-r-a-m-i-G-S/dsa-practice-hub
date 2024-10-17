// Q : https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/

class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int a = 0, b = 0, c = 0;
        int ans = 0;

        for(;end<n;end++){
            if(s.charAt(end) == 'a') a+=1;
            if(s.charAt(end) == 'b') b+=1;
            if(s.charAt(end) == 'c') c+=1;

            while(a>=1 && b>=1 && c>=1){
                ans+=s.length()-end;
                if(s.charAt(start) == 'a') a-=1;
                if(s.charAt(start) == 'b') b-=1;
                if(s.charAt(start) == 'c') c-=1;

                start++;
            }                        
        }
        return ans;
    }
}
