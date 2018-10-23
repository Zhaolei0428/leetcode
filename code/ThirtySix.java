import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ThirtySix {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet<>();
        Set<Character> colSet = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j<9;j++){
                //检查行
                if(board[i][j]!= '.'){
                    if(rowSet.contains(board[i][j]))
                        return false;
                    rowSet.add(board[i][j]);
                }
                //检查列
                if(board[j][i]!= '.'){
                    if(colSet.contains(board[j][i]))
                        return false;
                    colSet.add(board[j][i]);
                }
            }
            colSet.clear();
            rowSet.clear();
        }
        for(int rStart = 0; rStart<9; rStart+=3){
            for (int cStart = 0; cStart<9; cStart+=3) {
                for(int i=rStart; i<rStart+3; i++){
                    for(int j=cStart; j< cStart+3; j++){
                        //检查方格
                        if(board[i][j]!= '.'){
                            if(rowSet.contains(board[i][j]))
                                return false;
                            rowSet.add(board[i][j]);
                        }
                    }
                }
                rowSet.clear();
            }
        }
        return true;
    }
}
