//You are given an integer array nums.

//Return the smallest index i such that the sum of the digits of nums[i] is equal to i.

//If no such index exists, return -1.

class Solution {
    public int smallestIndex(int[] nums) {
     for (int i = 0; i < nums.length; i++) {
            int sumdigits = 0;
            int tempr = nums[i];

            while (tempr > 0) {
                sumdigits += tempr % 10;
                tempr /= 10;
            }

            if (sumdigits == i) {
                return i;
            }
        }
        return -1;
    }
}