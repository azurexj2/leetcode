package junxiao.leetcode.reconstruct_itinerary;

import java.util.*;

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        // construct the graph
        for (String[] route : tickets){
            String depart = route[0];
            String arrvial = route[1];
            if (!graph.containsKey(depart)){
                List<String> list = new ArrayList<>();
                graph.put(depart,list);
            }
            graph.get(depart).add(arrvial);
        }
        //sort the arrvial list
        for (List<String> l : graph.values()){
            Collections.sort(l);
        }
        List<String> res = new ArrayList<>();
        List<String> route = new ArrayList<>();
        route.add("JFK");
        int count = tickets.length;
        dfs("JFK",graph,res,route, count+1);
        return res;
        
    }
    private void dfs(String depart, Map<String,List<String>> graph, List<String> res, List<String> route, int count){
        if (res.size()!=0) return; //only one result is enouth in this problem
        if (route.size()==count){
           res.addAll(route);
           return;
        }
        List<String> des = graph.get(depart);
        if (des!=null){
            for (int i =0; i <des.size();++i){
                String city = des.get(i);
                des.remove(i);
                route.add(city);
                dfs(city,graph,res,route,count);
                route.remove(route.size()-1);
                des.add(i,city);
                
            }
        }
        
    }
}