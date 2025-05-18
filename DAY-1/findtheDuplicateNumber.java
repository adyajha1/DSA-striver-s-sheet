//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

//There is only one repeated number in nums, return this repeated number.

//You must solve the problem without modifying the array nums and using only constant extra space.

class Solution {
    public int findDuplicate(int[] nums) {
     int[] arr=new int[nums.length];
     for(int i=0;i<nums.length;i++){
        if(arr[nums[i]]==0){
        arr[nums[i]]=1;

        }
        else return nums[i];
     }
     return -1;
}
}
