import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int asteroid:asteroids){
            while(!stack.isEmpty() && asteroid<0 && stack.peek()>0){
                if(stack.peek()>-asteroid){
                    asteroid=0;
                    break;
                }else if(stack.peek()==-asteroid){
                    stack.pop();
                    asteroid=0;
                    break;
                }else{
                    stack.pop();
                }
            }
            if(asteroid!=0){
                stack.push(asteroid);
            }
        }
        int[] result=new int[stack.size()];
        for(int i=0;i<stack.size();i++){
            result[i]=stack.get(i);
        }
        return result;
    }
}