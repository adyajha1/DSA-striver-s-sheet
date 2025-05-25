//You are given an array of strings words. Each element of words consists of two lowercase English letters.

//Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.

//Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.

//A palindrome is a string that reads the same forward and backward.

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int length = 0;
        boolean middle = false;

        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();

            if (map.containsKey(reversed) && map.get(reversed) > 0) {
                
                length += 4; 
                map.put(reversed, map.get(reversed) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        
        for (String key : map.keySet()) {
            if (key.charAt(0) == key.charAt(1) && map.get(key) > 0) {
                middle = true;
                break;
            }
        }

        return middle ? length + 2 : length;
    }
}
