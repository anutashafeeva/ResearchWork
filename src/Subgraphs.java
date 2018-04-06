import java.util.ArrayList;
import java.util.List;

public class Subgraphs {
    public List<int[][]> subgr(int[][] matrix){

        List<int[][]> subgraphs = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int[][] subgr = new int[matrix.length - 1][matrix.length - 1];
            for (int j = 0; j < matrix.length; j++) {
                if (j < i) {
                    for (int k = 0; k < matrix.length; k++) {
                        if (k < i) {
                            subgr[j][k] = matrix[j][k];
                        }
                        else if (k > i){
                            subgr[j][k - 1] = matrix[j][k];
                        }
                    }
                }
                else if (j > i) {
                    for (int k = 0; k < matrix.length; k++) {
                        if (k < i) {
                            subgr[j - 1][k] = matrix[j][k];
                        }
                        else if (k > i){
                            subgr[j - 1][k - 1] = matrix[j][k];
                        }
                    }
                }
            }
            subgraphs.add(subgr);
        }
        return subgraphs;
    }
}
