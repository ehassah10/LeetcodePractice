/*
TC: O(n + m) where m is length of trust array
SC: O(n)
*/
class Solution {
    public int findJudge(int n, int[][] trust) {
        int judge = 0;
        int[] indegree = new int[n];
        for(int[] t: trust){
            indegree[t[0]-1] -= 1; 
            indegree[t[1]-1] += 1;
        }
        int judgeFound = 0;
        for(int i=0; i<n; i++){
            if(judgeFound == 0 && indegree[i] == n-1){
                judge = i+1;
                judgeFound++;
            }
        }
        return judgeFound == 1 ? judge : -1;
    }
}