class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<Integer> st = new HashSet<Integer>();
        int n = nums.length;
        List<Integer> temp = new ArrayList<Integer>();

        Solve(temp, nums, n, result, st);

        return result;

    }

    public void Solve(List<Integer> temp, int[] nums, int n,  List<List<Integer>> result, Set<Integer> st){
        if(temp.size() == n){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < n; i++){
           if(st.contains(nums[i])){
               continue;                             //------- element already exists, skip
            }
               temp.add(nums[i]);                    //------- Take element and explore
               st.add(nums[i]);

               Solve(temp, nums, n, result, st);     // ----- explore

               temp.remove(temp.size()-1);           // ----- remove/reject that element and explore
               st.remove(nums[i]);
        }
    }
}
