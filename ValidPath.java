import java.util.*;
class Solution {
    Map<Integer, List<Integer>> map;
    boolean visited[];
    boolean result;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        map = new HashMap<>();
        result = false;
        buildGraph(edges);
        visited = new boolean[n];
        isPath(source, destination);
        return result;
    }
    private void isPath(int source, int destination){
        //base
        if(result){
            return;
        }
        if(source == destination){
            result = true;
            return;
        }
        
        //logic
        if(!map.containsKey(source)){
            return;
        }
        List<Integer> li = map.get(source);
        for(int l:li){
            if(source == destination){
                result = true;
                return;
            }
            if(!visited[l]){
                visited[l] = true;
                isPath(l, destination);  
            }
        }
    }
    private void buildGraph(int[][] edges){
        for(int[] edge: edges){
            if(!map.containsKey(edge[0])){
                map.put(edge[0], new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
    }
}
/*
visited
[false,false,false,false,false,false]
Map<Integer, List<Integer>>
0: 1, 2, 3
1: 0
2: 0
3: 4, 5
4: 3, 5
5: 3, 4
*/