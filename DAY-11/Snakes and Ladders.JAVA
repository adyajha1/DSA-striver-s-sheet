/*You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

You start on square 1 of the board. In each move, starting from square curr, do the following:

Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.
A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 are not the starting points of any snake or ladder.

Note that you only take a snake or ladder at most once per dice roll. If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.

For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
Return the least number of dice rolls required to reach the square n2. If it is not possible to reach the square, return -1.*/

class Solution {
    public static int[] getPosition(int s, int n) {
        int row = n - 1 - (s - 1) / n;
        int col = (s - 1) % n;
        if ((n - 1 - row) % 2 == 1) {
            col = n - 1 - col;
        }
        return new int[] {row, col};
    }

    public static int snakesAndLadders(int[][] board) {
        int n = board.length;

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {1, 0});  
        visited.add(1);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int square = current[0];
            int steps = current[1];

            for (int move = 1; move <= 6; move++) {
                int nextSquare = square + move;
                if (nextSquare > n * n) continue;

                int[] position = getPosition(nextSquare, n);
                int row = position[0];
                int col = position[1];

                if (board[row][col] != -1) {
                    nextSquare = board[row][col];
                }

                if (nextSquare == n * n) {
                    return steps + 1;
                }

                if (!visited.contains(nextSquare)) {
                    visited.add(nextSquare);
                    queue.offer(new int[] {nextSquare, steps + 1});
                }
            }
        }

        return -1;  
    }
}