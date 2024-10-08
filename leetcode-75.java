// Q : https://leetcode.com/problems/sort-colors/description/

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zero = 0;
        int one = 0;
        int two = n-1;

        while(one <= two){
            if(nums[one] == 1){
                one++;
            }
            else if(nums[one] == 0){
                nums[one] = nums[zero];
                nums[zero] = 0;
                zero++;
                one++;
            }
            else{
                nums[one] = nums[two];
                nums[two] = 2;
                two--;
            }
        }
    }
}
