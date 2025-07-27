import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingObservation {
    public static void main(String[] args) {

//        int target = 12;
//        int slot = 2;
////        List<Integer> ans = findMissingObservation(target, slot, finalSlot, new ArrayList<>());
////        if(!ans.isEmpty()) {
////            ans.forEach(a -> System.out.println(a));
////        }
//
//        List<Integer> ans = new ArrayList<>(slot);
//        for(int i = 0; i<slot; i++) ans.add(1);
//        int t = findMissingObservations(target-ans.size(), ans);
//        if(t == -1) System.out.println("No Ans");
//        else  {
//            ans.forEach(System.out::println);
//        }

        int[] rolls = {1,2,3,4};
        int mean = 6;
        int n = 4;


        int sum = 0;
        for (int i = 0; i < rolls.length; i++) {
            sum += rolls[i];
        }

        int target = (mean * (rolls.length + n) - sum);
        if (target < 0 || target < n) {
            System.out.println("No Valid Ans");
        } else  {
            int[][]dp = new int[n][n];
            for(int i = 0; i<n ;i++) {
                for(int j = 0; j<n; j++) {
                dp[i][j] = -1;

                }
            }
            int[]temp = helper(n, target, 0, new int[n], dp);
            if(temp == null) System.out.println("No Valid Ans");
            for(int i = 0; i<temp.length ;i++) {
                System.out.println(temp[i]);
            }
        }

//        int[] missing = missingRolls(rolls, mean, n);
//        for(int i = 0; i<missing.length; i++) {
//            System.out.println(missing[i]);
//        }

    }



    private static int[] helper(int slot, int target, int index, int[] ans, int[][]dp) {
        if (slot == 0) {
            return (target == 0) ? ans.clone() : null;
        }

        if(index <= slot && dp[slot][index] != -1) return null;

        for (int i = 1; i <= 6; i++) {
            if (target - i < 0) break;

            ans[index] = i;
            dp[slot][index] = target-i;
            int[] result = helper(slot - 1, target - i, index + 1, ans, dp);
            if (result != null) {
                return result;
            }

            ans[index] = 0;
        }

        return null;
    }

    // working
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int i = 0; i < rolls.length; i++) {
            sum += rolls[i];
        }
        int target = ((rolls.length + n) * mean) - sum;
        int[] ans = new int[n];
        if (target <= 0 || target < n) return new int[0];

        for (int i = 0; i < n; i++) ans[i] = 1;
        int t = findMissingObservations(target - n, ans);
        if (t != 0) return new int[0];
        return ans;

    }

    public static int findMissingObservations(int target, int[] ans) {
        if (target == 0) return 0;
        for (int i = 0; i < ans.length; i++) {
            int currentValue = ans[i] + 5;
            if (target <= 5) {
                ans[i] = ans[i] + target;
                return 0;
            } else {
                ans[i] = currentValue;
                target -= 5;
                if (target == 0) return 0;
            }

        }

        if (target == 0) return 0;
        return -1;
    }
}
