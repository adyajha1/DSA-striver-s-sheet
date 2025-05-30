//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

//You may assume that each input would have exactly one solution, and you may not use the same element twice.

//You can return the answer in any order.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    arr[0]=i;
                    arr[1]=j;
                }
            }
        }
        return arr;
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr=new int[2];
        HashMap<Integer,Integer> sum=new HashMap<>();
        for(int i=0;i<nums.length;i++){
           int num=target-nums[i];
            if(sum.containsKey(num)){
                arr[0]=i;
                arr[1]=sum.get(num);
            }else sum.put(nums[i],i);

        }
        return arr;
    }
}