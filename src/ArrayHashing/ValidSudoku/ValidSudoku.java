package ArrayHashing.ValidSudoku;

import java.util.*;

public class ValidSudoku {

    //Solution 1: Brute Force
    // public boolean isValidSudoku(char[][] board) {

    //     //Step 1: Checking each row
    //     for(int row = 0; row<9; row++){
    //         Set<Character> seen = new HashSet<>();
    //         for(int i=0; i <9; i++){
    //             if(board[row][i] == '.') continue;
    //             if(seen.contains(board[row][i])) return false;
    //             seen.add(board[row][i]);
    //         }
    //     }

    //     //Step 2: Checking each column
    //     for(int col = 0; col < 9; col++){
    //         Set<Character> seen = new HashSet<>();
    //         for(int i=0; i < 9; i++){
    //             if(board[i][col] == '.') continue;
    //             if(seen.contains(board[i][col])) return false;
    //             seen.add(board[i][col]);
    //         }
    //     }

    //     //Step 3: Checking each 3x3 SubGrid
    //     for(int square = 0; square < 9; square++){
    //         Set<Character> seen = new HashSet<>();
    //         for(int i = 0; i<3; i++){
    //             for(int j = 0; j<3; j++){

    //                 int row = (square/3) * 3 + i;
    //                 int col = (square%3) * 3 + j;

    //                 if(board[row][col] == '.') continue;
    //                 if(seen.contains(board[row][col])) return false;
    //                 seen.add(board[row][col]);
    //             }
    //         }
    //     }

    //     return true;
    // }



//Solution 2: Hash Set (one Pass)

    public boolean isValidSudoku(char[][] board){

        //Step 1: Create All HashMaps
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        //Create nested for loop to iterate through each cells.
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                //If empty - continue
                if(board[r][c] == '.') continue;

                //To identify subgrid
                String squareKey = (r/3) + "," + (c/3);

                //if condition to check in row , col & squares in one pass., If same value found then return false.
                if(rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                        cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
                        squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c])){
                    return false;
                }

                //Else add values to the cell.
                rows.get(r).add(board[r][c]); //\track number in current row
                cols.get(c).add(board[r][c]); // track in current col
                squares.get(squareKey).add(board[r][c]); // track in current subgrid
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
        ValidSudoku solution = new ValidSudoku();
        System.out.println("Result:" + solution.isValidSudoku(board));
    }
}
