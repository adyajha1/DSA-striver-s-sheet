Given an integer array nums, find the subarray with the largest sum, and return its sum.

class Solution {
    public int maxSubArray(int[] nums) {
        int  maxsum=nums[0];
        int  currentsum=nums[0];
        if(nums.length>0){
           
            for(int i=1;i<nums.length;i++){
                currentsum=Math.max(nums[i],currentsum+nums[i]);
                if(currentsum>=maxsum){
                    maxsum=currentsum;
                }
                
            }
        } 
        return maxsum;
    }
}


class Solution {
    public int maxSubArray(int[] nums) {
        int  maxsum=nums[0];
        int  currentsum=nums[0];
        if(nums.length>0){
           
            for(int i=1;i<nums.length;i++){
                currentsum=Math.max(nums[i],currentsum+nums[i]);
                if(currentsum>=maxsum){
                    maxsum=currentsum;
                }
                
            }
        } 
        return maxsum;
    }
}