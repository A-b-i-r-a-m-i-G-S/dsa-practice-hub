// https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/

class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int[] zeroCount = new int[n];

        zeroCount[0] = (s.charAt(0) == '0') ? 1:0;
        for(int i=1;i<n;i++){
            zeroCount[i] = zeroCount[i-1] + ((s.charAt(i) == '0') ? 1:0);
        }

        int oneCount = 0;
        int maxScore = Integer.MIN_VALUE;
        for(int i=n-1;i>=1;i--){
            oneCount += (s.charAt(i) == '1') ? 1:0;
            maxScore = Math.max(maxScore, zeroCount[i-1] + oneCount);
        }

        return maxScore;
    }
}
