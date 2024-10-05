// Q : https://leetcode.com/problems/make-sum-divisible-by-p/description/?envType=daily-question&envId=2024-10-03
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum = (totalSum + nums[i]) %p;
        }

        if(totalSum % p == 0) return 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        int sum = 0;
        int minLen = n;
        int target = totalSum % p;

        for(int i=0;i<n;i++){
            sum = (sum + nums[i])%p;
            int req = (sum - target + p) % p;

            if(map.containsKey(req)){
                minLen = Math.min(minLen, i-map.get(req));
            }

            map.put(sum, i);
        }

        return minLen == n ? -1 : minLen;

    }
}
