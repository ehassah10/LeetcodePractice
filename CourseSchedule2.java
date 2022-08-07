import java.util.*;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0){
            if(numCourses > 0){
                int[] res = new int[numCourses];
                for(int i=0; i<numCourses; i++){
                    res[i] = i;
                }
                return res;
            }
            return new int[numCourses];
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
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                result.add(i);
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
                    result.add(l);
                    count++;
                    q.add(l);
                }
            }
        }
        if(count == numCourses){
            int[] res = new int[numCourses];
            int j=0;
            for(int r: result){
                res[j++] = r;
            }
            return res;
        }else{
            return new int[0];
        }
    }
}