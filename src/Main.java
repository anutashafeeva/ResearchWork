import java.io.*;
import java.util.*;

public class Main {

    private static long startTime = 0;
    private static long endTime = 0;

    public static void main(String[] args) throws IOException {

        new Main().app();

        endTime = System.currentTimeMillis() - startTime;
        System.out.println("time = " + endTime);
    }

    private void app() throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        PrintWriter outMaxMatrixCode = new PrintWriter("outputMaxMatrixCode.txt");
        PrintWriter outMin = new PrintWriter("min.txt");
        PrintWriter outMax = new PrintWriter("max.txt");

        startTime = System.currentTimeMillis();

        int max = 0;
        int min = 0;
        String s = in.readLine();
        while (s != null) {
            MatrixAndG6 mg6 = new MatrixAndG6();
            int[][] matrix = mg6.g6ToMatrix(s);

            List<int[][]> subgr = new Subgraphs().subgr(matrix);

            TreeSet<String> listSubgr = new TreeSet<>();
            for (int i = 0; i < subgr.size(); i++) {
                TreeSet<String> maxC = new TreeSet<>();
                new MaxCode().maxCode(subgr.get(i), 0, maxC);
                listSubgr.add(maxC.last());
            }

            outMaxMatrixCode.print(s + " - ");
            for (String subgraphs : listSubgr) {
                outMaxMatrixCode.print(subgraphs + " ");
            }
            outMaxMatrixCode.println();

            if (listSubgr.size() == 1){
                min++;
                outMin.println(s + " - " + listSubgr.first());
            }
            else if (listSubgr.size() == matrix.length){
                max++;
                outMax.print(s + " - ");
                for (String subgraphs : listSubgr) {
                    outMax.print(subgraphs + " ");
                }
                outMax.println();
            }

            s = in.readLine();
        }

        System.out.println("max = " + max);
        System.out.println("min = " + min);

        in.close();
        outMaxMatrixCode.close();
        outMax.close();
        outMin.close();
    }
}
