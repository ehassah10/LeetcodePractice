import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0){
            return true;
        }
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] prerequisite : prerequisites){
            indegree[prerequisite[0]] +=1;
            if(!map.containsKey(prerequisite[1])){
                map.put(prerequisite[1], new ArrayList<>());
            }
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                count++;
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            List<Integer> li = map.get(q.poll());
            if(li == null){
                continue;
            }
            for(int l:li){
                indegree[l] -= 1;
                if(indegree[l] == 0){
                    count++;
                    q.add(l);
                }
            }
        }
        //System.out.println(count);
        return count == numCourses;
    }
}