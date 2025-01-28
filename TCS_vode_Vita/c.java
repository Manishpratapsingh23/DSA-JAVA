import java.util.*;

public class c {
    static class State {
        int row, col, moves, lifts;

        State(int row, int col, int moves, int lifts) {
            this.row = row;
            this.col = col;
            this.moves = moves;
            this.lifts = lifts;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int startRow = scanner.nextInt();
        int startCol = scanner.nextInt();
        int destRow = scanner.nextInt();
        int destCol = scanner.nextInt();

        int result = bfs(board, N, M, startRow, startCol, destRow, destCol);
        System.out.println(result == Integer.MAX_VALUE ? "Impossible" : result);
    }

    private static int bfs(int[][] board, int N, int M, int startRow, int startCol, int destRow, int destCol) {
        int[] dCol = { -1, 1 }; 

        Queue<State> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        int stableStartRow = applyGravity(board, N, M, startRow, startCol);
        queue.add(new State(stableStartRow, startCol, 0, 0));
        visited[stableStartRow][startCol] = true;

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.row == destRow && current.col == destCol) {
                if (isStable(board, N, M, destRow, destCol)) {
                    return current.moves + current.lifts;
                } else {
                    continue;
                }
            }

            if (current.row == N - 1 || isStable(board, N, M, current.row, current.col)) {
                for (int dc : dCol) {
                    int newCol = current.col + dc;
                    if (newCol >= 0 && newCol < M && !visited[current.row][newCol]) {
                        int newRow = applyGravity(board, N, M, current.row, newCol);
                        queue.add(new State(newRow, newCol, current.moves + 1, current.lifts));
                        visited[newRow][newCol] = true;
                    }
                }
            }

            for (int newRow = current.row - 1; newRow >= 0; newRow--) {
                if (board[newRow][current.col] == 1) {
                    if (!visited[newRow][current.col]) {
                        queue.add(new State(newRow, current.col, current.moves, current.lifts + 1));
                        visited[newRow][current.col] = true;
                    }
                } else {
                    break; 
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    private static int applyGravity(int[][] board, int N, int M, int row, int col) {
        while (row < N - 1 && !isStable(board, N, M, row, col)) {
            row++;
        }
        return row;
    }

    private static boolean isStable(int[][] board, int N, int M, int row, int col) {
        return row == N - 1 || (row + 1 < N && board[row + 1][col] == 1);
    }
}
