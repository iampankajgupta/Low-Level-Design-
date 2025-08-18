package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
    public static void main(String[] args) {
        int[]nums = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,new ArrayList<>(), result);

        for(List<Integer> ans : result) {
            for(int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // Time complexity
    // There will be N! permutation of string so n!
    // So every n! string i will be checking whether it contain element is list or not so at max N -> O(N!) * N
    // further before back checking the size another O(N)
    // Complexity is O(N! * N)

    // Space Complexity
    // There will be N! Permutation so ans size would be N!
    // for every ans N size would be covered so another N
    // Recursion space would be N
    // Complexity would be O(N!*N)


    public static void helper(int[]nums,List<Integer> temp, List<List<Integer>> ans) {
        if(temp.size() >= nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // for loop is being used so the each element should be consider every time
        // For example
        /*
                1, 2 , 3 -> all ele are included
                1, 3, 2 -> backtrack remove 3 and again from 0 check 1 exists no -> 2
                2, 1, 3
                2, 3, 1
         */
        for(int i = 0; i< nums.length; i++) {
            if(!temp.contains(nums[i])) {
                // take t
                temp.add(nums[i]);
                helper(nums, temp, ans);
                if(!temp.isEmpty()) temp.remove(temp.size() - 1);
            }
        }
    }


    // Added HashSet as well but time complexity is still same O(N!*N)

    public static void helper(int[]nums,List<Integer> temp, HashSet<Integer> set, List<List<Integer>> ans) {
        if(temp.size() >= nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i< nums.length; i++) {
            if(!set.contains(nums[i])) {
                temp.add(nums[i]);
                set.add(nums[i]);
                helper(nums, temp, set, ans);
                if(!temp.isEmpty()){
                    temp.remove(temp.size() - 1);
                    set.remove(nums[i]);
                }
            }
        }
    }
}
