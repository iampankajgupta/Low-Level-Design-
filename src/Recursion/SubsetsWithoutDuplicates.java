package Recursion;

import java.util.*;

public class SubsetsWithoutDuplicates {
    public static void main(String[] args) {
        int[]nums =  {1,2,2};
        List<List<Integer>> result = new ArrayList<>();
        helper2(nums, 0, new ArrayList<>(), result);
        for(List<Integer> ans : result) {
            for(int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /*
    🧠 Rule of Thumb:
        Whenever you're storing 2^N things, and each thing is size N, your space complexity is O(2^N * N), not just O(2^N).
     */

    // My Assumption Time Complexity
    // Sort Element -> O(NLogN) + O ( 2^N) this much time checking if contain and it not adding
    // adding elements to StringBuilder O(2^N)

    // O(NLogN) +  O ( 2^N) +  O ( 2^N)

    // Space Complexity
    // O(N) + O(2^N) HashSet, O(N) -> StringBuilder

    // ChatGPT
    /*
    🚀 Summary:
        Step	Complexity
        Generate all subsets	O(2^N)
        For each subset, build string	O(N)
        For each subset, hash set check/add	O(1) avg
        ✅ Total	O(2^N * N)


✅ Time and Space Complexity (corrected):
Let’s break it down:

🔹 Time Complexity:
Sorting: O(N log N)

Backtracking traversal: You generate all possible subsets → O(2^N)

Building subset string with StringBuilder: In the worst case, each of the 2^N subsets has up to N elements → O(N * 2^N)

Set lookup/insert (amortized): O(1) per subset → total O(2^N)

So total:
Time: O(N log N + N * 2^N)
You can drop O(2^N) and keep the dominant N * 2^N.

🔹 Space Complexity:
Recursion stack: At most O(N)

Temp list storage: O(N) per subset, but reused

Result list: Can store up to 2^N subsets → O(2^N * N) (each subset has up to N elements)

Set<String>: Up to 2^N strings (average string length = O(N)) → O(2^N * N)

StringBuilder: Single instance, max length = O(N)

So total:

Space: O(2^N * N)
✅ Final Verdict:
Aspect	Status
Correctness	✅ Correct for all inputs
Time complexity	✅ O(N log N + N * 2^N)
Space complexity	✅ O(2^N * N)
Style	✅ Clean and maintainable

     */


    //
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        // For Storing the Unique elements
        Set<String> set = new HashSet<>();
        // for cases like [ 1, 2, 1 ] because [1,2] [2, 1] are duplicates
        Arrays.sort(nums);
        helper(nums, 0, temp, ans, set, new StringBuilder());
        return ans;
    }


    public void helper(int[]nums, int index,List<Integer> temp, List<List<Integer>> ans, Set<String> set, StringBuilder builder) {
        if(index >= nums.length) {
            String currString = builder.toString();
            // if the set does not contain the string then add
            if(!set.contains(currString)) {
                set.add(currString);
                ans.add(new ArrayList<>(temp));
            }
            return;

        }

        temp.add(nums[index]);
        int prevLength = builder.length();
        builder.append(nums[index] + ",");
        // take
        helper(nums, index+1, temp, ans, set, builder);
        if(temp.size() != 0) {
            temp.remove(temp.size() - 1);

        }
        // setting builder to prevLength
        builder.setLength(prevLength);
        // not take
        helper(nums, index+1, temp, ans, set, builder);

    }


    // Optimise Solution
    // Thought Process
    // Sort the array and if index of i is not equal to index - 1 then only call recursion else do not

    public static void helper2(int[]nums, int index,List<Integer> temp, List<List<Integer>> ans) {
        if(index >= nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[index]);
        helper2(nums, index + 1, temp, ans);
        if(!temp.isEmpty()) temp.remove(temp.size() -1);
        // loop until idx element is same as idx-1
        int idx = index + 1;
        /// until element is equal increment to avoid duplicate
        while(idx < nums.length && nums[idx] == nums[idx - 1]) idx++;
        helper2(nums, idx, temp, ans);
    }


    // another way to write

    public List<List<Integer>> subsetsWithDup3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort to bring duplicates together
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> tempList, List<List<Integer>> res) {
        res.add(new ArrayList<>(tempList)); // Always add current subset

        for (int i = start; i < nums.length; i++) {
            // Step 2: Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            tempList.add(nums[i]);
            backtrack(nums, i + 1, tempList, res);
            tempList.remove(tempList.size() - 1); // backtrack
        }
    }
}
