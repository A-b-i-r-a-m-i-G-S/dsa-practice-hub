// Q : https://www.geeksforgeeks.org/problems/find-the-closest-pair-from-two-arrays4215/1

class Solution{
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        int left = 0;
        int right = brr.length-1;
        int diff = Integer.MAX_VALUE;
        int ans_l=0, ans_r=0;
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(left < arr.length && right >= 0){
            int sum = arr[left] + brr[right];
            if(Math.abs(sum - x) < diff){
                ans_l = left;
                ans_r = right;
                diff = Math.abs(sum - x);
            }
            
            if(sum > x){
                right--;
            }
            else{
                left++;
            }
            
        }
        
        ans.add(arr[ans_l]);
        ans.add(brr[ans_r]);
        
        return ans;
    }
}
