// Q : https://leetcode.com/problems/rank-transform-of-an-array/description/?envType=daily-question&envId=2024-10-02

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] temp = Arrays.stream(arr).distinct().sorted().toArray();
        int m = temp.length;
        
        for (int i=0; i<m; i++) {
            map.put(temp[i], i + 1);
        }

        for (int i=0; i<n; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
