// Q : https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int start = 0;
        int end = 0;

        int ans = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(;end<nums.length;end++){
            map.put(nums[end], map.getOrDefault(nums[end],0) + 1);
            while(map.lastKey() - map.firstKey() > limit){
                map.put(nums[start], map.get(nums[start])-1);
                if(map.get(nums[start]) == 0){
                    map.remove(nums[start]);
                }
                start++;
            }            

            ans = Math.max(ans, end-start+1);
        }

        return ans;
    }
}
