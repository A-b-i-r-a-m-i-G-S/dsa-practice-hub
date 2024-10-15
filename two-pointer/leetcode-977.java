// Q : https://leetcode.com/problems/squares-of-a-sorted-array/

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int i = 0;
        int j = n-1;

        for(int idx=n-1;idx>=0;idx--){
            if(nums[i] * nums[i] > nums[j] * nums[j]){
                ans[idx] = nums[i] * nums[i];
                i++;
            }
            else{
                ans[idx] = nums[j] * nums[j];
                j--;
            }
        }

        return ans;
    }
}
