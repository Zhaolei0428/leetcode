import javafx.util.Pair;

import java.util.*;

/**
 * Question Sudoku Solver
 */
public class ThirtySeven {
    public void solveSudoku(char[][] board) {
        List<Pair<Integer, Integer>> blank = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0; i<9; i++){
            for(int j=0; j<9; j++){
                char number = board[i][j];
                if(number != '.'){
                    hashSet.add(number + "in row" + i);
                    hashSet.add(number + "in col" + j);
                    hashSet.add(number + "in blo" + i/3 + "-" + j/3);
                }
                else {
                    blank.add(new Pair<>(i,j));
                }
            }
        }
        ListIterator<Pair<Integer, Integer>> iterator = blank.listIterator();
        while (iterator.hasNext()){
            Pair<Integer, Integer> pair = iterator.next();
            int i = pair.getKey();
            int j = pair.getValue();
            char number = '1';
            if(board[i][j] != '.'){
                number = board[i][j];
                hashSet.remove(number + "in row" + i);
                hashSet.remove(number + "in col" + j);
                hashSet.remove(number + "in blo" + i/3 + "-" + j/3);
                number = (char) (number + 1);
            }
            while (number <= '9'){
                if(!hashSet.contains(number + "in row" + i) &&
                        !hashSet.contains(number + "in col" + j) &&
                        !hashSet.contains(number + "in blo" + i/3 + "-" + j/3)){
                    board[i][j] = number;
                    hashSet.add(number + "in row" + i);
                    hashSet.add(number + "in col" + j);
                    hashSet.add(number + "in blo" + i/3 + "-" + j/3);
                    break;
                }
                number++;
            }
            if(number > '9'){
                board[i][j] = '.';
                iterator.previous();
                iterator.previous();
            }
        }
    }
    public static void main(String[] args){
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};
        ThirtySeven thirtySeven = new ThirtySeven();
        thirtySeven.solveSudoku(board);
        for(char[] a: board){
            for (char b: a){
                System.out.print(b+ " ");
            }
            System.out.print("\n");
        }
    }
}
