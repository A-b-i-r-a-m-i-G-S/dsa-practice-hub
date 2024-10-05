// Q : https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/description/?envType=daily-question&envId=2024-10-04

class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        long sum = skill[0] + skill[n-1];
        long chem = skill[0] * skill[n-1];

        for(int i=1;i<n/2;i++){
            if(skill[i] + skill[n-1-i] == sum){
                chem += skill[i] * skill[n-1-i];
            }
            else{
                return -1;
            }
        }

        return chem;
    }
}
