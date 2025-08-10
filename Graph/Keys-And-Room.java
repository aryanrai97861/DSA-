//dfs
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited=new HashSet<>();
        dfs(0,rooms,visited);
        return visited.size()==rooms.size(); 
    }
    private void dfs(int currentRoom,List<List<Integer>> rooms,Set<Integer> visited){
        if(visited.contains(currentRoom)) return;
        visited.add(currentRoom);
        for(int key: rooms.get(currentRoom)){
            dfs(key,rooms,visited);
        }
    }
}

//bfs
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Intger> visited=new HashSet<>();
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        
        while(!queue.iseEmpty()){
            int currentRoom=queue.poll();
            if(visited.contains(currentRoom)) continue;
            visited.add(currentRoom);
            for (int key : rooms.get(currentRoom)) queue.add(key);
        }
        return visited.size() == rooms.size();
    }
}