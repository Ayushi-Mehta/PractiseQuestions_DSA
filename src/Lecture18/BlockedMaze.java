package Lecture18;

public class BlockedMaze {

	public static void main(String[] args) {
		int[][] maze = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
		blockedMaze(maze, 0, 0, "", new boolean[maze.length][maze[0].length]);
		// default value of boolean[][] is false at all places
	}

	public static void blockedMaze(int[][] maze, int row, int col, String ans, boolean[][] visited) {
		if (row == maze.length - 1 && col == maze[0].length - 1) {// +ve base case
			System.out.println(ans);
			return;
		}
		if (row > maze.length - 1 || col > maze[0].length - 1 || row < 0 || col < 0) {
			return;// -ve base case
		}
		if (maze[row][col] == 1 || visited[row][col]) {
			return;// blocked parts of maze cannot be used
		}

		// put a mark
		visited[row][col] = true;

		// upward(T)
		blockedMaze(maze, row - 1, col, ans + "T", visited);

		// downward(D)
		blockedMaze(maze, row + 1, col, ans + "D", visited);

		// left(L)
		blockedMaze(maze, row, col - 1, ans + "L", visited);

		// right(R)
		blockedMaze(maze, row, col + 1, ans + "R", visited);

		// remove the mark
		visited[row][col] = false;//explicitly undo
		// backtracking

	}
}
