//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

//P   A   H   N
//A P L S I I G
//Y   I   R
//And then read line by line: "PAHNAPLSIIGYIR"

//Write the code that will take a string and make this conversion given a number of rows:

//string convert(string s, int numRows);


class Solution {
    public String convert(String s, int numRows) {
     if (numRows == 1 || s.length() <= numRows) return s;

        char[][] matrix = new char[numRows][s.length()];
        for (char[] row : matrix) {
            java.util.Arrays.fill(row, ' ');
        }

        int row = 0, col = 0;
        boolean goingDown = true;

        for (int i = 0; i < s.length(); i++) {
            matrix[row][col] = s.charAt(i);

            if (goingDown) {
                if (row == numRows - 1) {
                    goingDown = false;
                    row--;
                    col++;
                } else {
                    row++;
                }
            } else {
                if (row == 0) {
                    goingDown = true;
                    row++;
                } else {
                    row--;
                    col++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
       for (char[] r : matrix) {
    for (char c : r) {
        if (c != ' ') {  
            sb.append(c);
        }
    }
        
        }

        return sb.toString();
    }
}
    
