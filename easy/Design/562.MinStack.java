import java.util.ArrayList;


// solution from: 
class MinStack {
    private long min = 0;
    private ArrayList<Long> list;

    /** initialize your data structure here. */
    public MinStack() {
        min = 0;
        list = new ArrayList<>();
    }
    
    public void push(int x) {
        if(list.size() == 0) {
            min = x;
            list.add(0L);
        } else {
            list.add(x - min);
            if(x < min) {
                min = x;
            }
        }
    }
    
    public void pop() {
        int idx = list.size() - 1;
        
        long diff = list.get(idx);
        list.remove(idx);
        
        if(diff < 0) {
            min = min - diff;
        }
        
        return;
    }
    
    public int top() {
        int idx = list.size() - 1;        
        long diff = list.get(idx);
        if(diff < 0) {
            return (int) min;
        }
        return (int) (min + diff);
    }
    
    public int getMin() {
        return (int) min;
    }

    public String toString() {
        return "min: " + min + " stack: " + list.toString();
    }
}

/* Best Solution */ 
/* 
class MinStack {

    ArrayList<Integer> stack;
    ArrayList<Integer> minList;
    
    public MinStack() {
        stack = new ArrayList<Integer>();
        minList = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        int min = 0;
        if(stack.size()==0){
            min = x;
        } else{
            min = Math.min(x, minList.get(stack.size()-1));
        }
        
        stack.add(x);
        minList.add(min);
    }
    
    public void pop() {
        if(stack.size()!=0){
            minList.remove(stack.size()-1);
            stack.remove(stack.size()-1); 
        }
    }
    
    public int top() {
        if(stack.size()!=0){
            return stack.get(stack.size()-1);
        } else{
            return 0;
        }
    }
    
    public int getMin() {
        if(stack.size()!=0){
            return minList.get(stack.size()-1);
        } else{
            return 0;
        }
    }
}
*/

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

 class Main {
    static public void main(String[] args) {
        MinStack obj = new MinStack();

        /* basic test */
        // obj.push(-2);
        // obj.push(0);
        // obj.push(-3);

        // System.out.println("getMin: " + obj.getMin());
        // obj.pop();
        // System.out.println("top: " + obj.top());
        // System.out.println("getMin: " + obj.getMin());

        obj.push(2147483647);
        System.out.println(obj.toString());

        obj.push(-2147483648);
        System.out.println(obj.toString());

        System.out.println("top: " + obj.top());
        System.out.println("getMin: " + obj.getMin());
    }
 }