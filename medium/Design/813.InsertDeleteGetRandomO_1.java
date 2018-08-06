import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    private HashMap<Integer, Integer> map;  // val => pos_of_list
    private ArrayList<Integer> list;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        if(this.map.containsKey(val)) {
            return false;
        }

        this.list.add(val);
        this.map.put(val, this.list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        if(!this.map.containsKey(val))  {
            return false;
        }

        int pos = this.map.get(val);

        // move last val to current pos 
        if(pos < this.list.size() - 1) {
            int lastVal = this.list.get(this.list.size() - 1);
            this.list.set(pos, lastVal);
            this.map.put(lastVal, pos);
        }

        this.map.remove(val);
        this.list.remove(this.list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if(this.list.size() == 0) {
            return 0;
        } 

        if(this.list.size() == 1) {
            return this.list.get(0);
        }

        int pos = rand.nextInt(this.list.size());
        
        return this.list.get(pos);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */

class InsertDeleteGetRandomO1 {
    public static void main(String[] args) {
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println("insert(1): " + randomSet.insert(1));

        // Returns false as 2 does not exist in the set.
        System.out.println("remove(2): " + randomSet.remove(2));

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println("insert(2): " + randomSet.insert(2));

        // getRandom should return either 1 or 2 randomly.
        System.out.println("getRandom(): " + randomSet.getRandom());

        // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println("remove(1): " + randomSet.remove(1));

        // 2 was already in the set, so return false.
        System.out.println("insert(2): " + randomSet.insert(2));

        // Since 2 is the only number in the set, getRandom always return 2.
        System.out.println("getRandom(): " + randomSet.getRandom());
    }
}