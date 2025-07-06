
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant=new LinkedList<>();
        Queue<Integer> dire=new LinkedList<>();

        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R') radiant.offer(i);
            else dire.offer(i);
        }
        while(!radiant.isEmpty() && !dire.isEmpty()){
            int r=radiant.poll();
            int d=dire.poll();
            if(r<d){
                radiant.offer(r+senate.length());
            }else{
                dire.offer(d+senate.length());
            }
        }
        if(!radiant.isEmpty()){
            return "Radiant";
        }else{
            return "Dire";
        }
    }
}