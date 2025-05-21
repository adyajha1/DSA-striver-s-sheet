//You are given an integer array nums of length n and a 2D array queries, where queries[i] = [li, ri].

//For each queries[i]:

//Select a subset of indices within the range [li, ri] in nums.
//Decrement the values at the selected indices by 1.
//A Zero Array is an array where all elements are equal to 0.

//Return true if it is possible to transform nums into a Zero Array after processing all the queries sequentially, otherwise return false.


//this aproach is failing for some testcases giving TLE.. will find a better solution
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];

            for (int i = l; i <= r; i++) {
                if (nums[i] > 0) {
                    nums[i] -= 1;
                }
            }
        }

        for (int num : nums) {
            if (num != 0) return false;
        }

        return true;
    }
}
