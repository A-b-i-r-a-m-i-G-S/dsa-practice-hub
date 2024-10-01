// Q : https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/

class Solution {
    public boolean canArrange(int[] arr, int k) {
      // Create a map to store the frequencies of each remainder
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for(int n : arr){
            int rem = (n%k + k)%k; // this formula ensures that negative numbers are handled correctly
            map.put(rem, map.getOrDefault(rem,0) + 1);
        }

        for(int rem = 0; rem <= k/2; rem++){
            if(rem == 0){
                if(map.getOrDefault(rem,0)%2!=0) return false; // numbers with remainder 0 can only pair with similar numbers
            }
            else{
                int p1 = map.getOrDefault(rem, 0);
                int p2 = map.getOrDefault(k-rem, 0);
                // numbers with remainder rem can only pair with numbers with remainder k-rem
                if(p1!=p2) return false;
            }
        }
        return true;
    }
}
