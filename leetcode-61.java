// Q  : https://leetcode.com/problems/task-scheduler/description/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // A B _ A B _ A B
        int m = tasks.length;
        int[] freqOfTasks = new int[26];

        for(char task : tasks){
            freqOfTasks[task - 'A'] += 1;
        }

        Arrays.sort(freqOfTasks);
        int maxFreq = freqOfTasks[25];

        int idleSlots = (maxFreq-1) * n;
        for(int i=24;i>=0 && freqOfTasks[i] > 0;i--){
            idleSlots -= Math.min(maxFreq-1, freqOfTasks[i]);
        }

        return idleSlots > 0 ? m + idleSlots : m;
    }
}
