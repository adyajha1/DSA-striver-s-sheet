//You are given positive integers n and m.

//Define two integers as follows:

//num1: The sum of all integers in the range [1, n] (both inclusive) that are not divisible by m.
//num2: The sum of all integers in the range [1, n] (both inclusive) that are divisible by m.
//Return the integer num1 - num2.

class Solution {
    public int differenceOfSums(int n, int m) {
        int sum1=0;
        int sum2=0;
        for(int i=1;i<=n;i++){
            if(i%m==0){
                sum1=sum1+i;
            }
            if(i%m!=0){
                sum2=sum2+i;
            }
        }
        return sum2-sum1;
    }
}