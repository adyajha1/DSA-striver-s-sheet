//You are given a 0-indexed array of strings words and a character x.

//Return an array of indices representing the words that contain the character x.

//Note that the returned array may be in any order.

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list= new ArrayList<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                if(Character.toLowerCase(words[i].charAt(j))==x){
                    list.add(i);
                    break;
                }

            }
            
        }
        return list;
    }
}

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list= new ArrayList<>();
        for(int i=0;i<words.length;i++){
           char[] word=words[i].toCharArray();
           Arrays.sort(word);
            for(int j=0;j<word.length;j++){
                if(Character.toLowerCase(words[i].charAt(j))==x){
                    list.add(i);
                    break;
                }

            }
            
        }
        return list;
    }
}