package cz.bedla;

public class Snek {
    public static void main(String[] args) {
        int size = 6;

        int[][] board = new int[size][size];

        int value = 1;
        Direction direction = Direction.RIGHT;

        int row = 0;
        int col = 0;
        while (value <= size * size) {
            if (board[row][col] == 0) {
                board[row][col] = value;
                value++;
            }

            switch (direction) {
                case RIGHT:
                    if (col + 1 < board[row].length && board[row][col + 1] == 0) {
                        col++;
                    } else {
                        direction = Direction.DOWN;
                    }
                    break;
                case LEFT:
                    if (col - 1 >= 0 && board[row][col - 1] == 0) {
                        col--;
                    } else {
                        direction = Direction.UP;
                    }
                    break;
                case DOWN:
                    if (row + 1 < board.length && board[row + 1][col] == 0) {
                        row++;
                    } else {
                        direction = Direction.LEFT;
                    }
                    break;
                case UP:
                    if (row - 1 >= 0 && board[row - 1][col] == 0) {
                        row--;
                    } else {
                        direction = Direction.RIGHT;
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + direction);
            }
        }

        System.out.println(dumpMatrix(board));
    }

    enum Direction {
        RIGHT, LEFT, DOWN, UP
    }


    public static String dumpMatrix(int[][] matrix) {
        StringBuilder output = new StringBuilder();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                output.append(anInt).append("\t");
            }
            output.append("\n");
        }
        return output.toString();
    }
}
