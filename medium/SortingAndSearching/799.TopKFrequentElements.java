import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        // bucket sort
        TreeMap<Integer, ArrayList<Integer>> buckets = new TreeMap<Integer, ArrayList<Integer>>();

        for(java.util.Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if(!buckets.containsKey(freq)) {
                buckets.put(freq, new ArrayList<>());
            }
            buckets.get(freq).add(entry.getKey());
        }

        while(ans.size() < k) {
            ArrayList<Integer> bucket = buckets.pollLastEntry().getValue();
            for(int j = 0;j < bucket.size() && ans.size() < k;j++) {
                ans.add(bucket.get(j));
            }
        }

        return ans;
    }
}

class TopKFrequent {
    static public void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println("[1,1,1,2,2,3] k=2 => expect([1,2]) acutal: " + sol.topKFrequent(new int[]{1,1,1,2,2,3}, 2).toString());
        System.out.println("[4,1,-1,2,-1,2,3] k=2 => expect([-1,2]) acutal: " + sol.topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2).toString());
    }
}