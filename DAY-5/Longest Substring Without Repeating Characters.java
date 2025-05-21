//Given a string s, find the length of the longest substring without duplicate characters.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int curr=0;
        int sum=0;
        int len=0;
        HashMap<Character,Integer> map= new HashMap<>();
        if(s.length()>0){
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))&&map.get(s.charAt(i))>=len){
                len=map.get(s.charAt(i))+1;
               
            }
              curr = (i+1) - len;
              map.put(s.charAt(i),i);
              sum=Math.max(sum,curr);

        }
        }
        return sum;
    }
}