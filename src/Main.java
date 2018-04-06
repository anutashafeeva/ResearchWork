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

        Scanner sc = new Scanner(System.in);

        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        PrintWriter outSameGraphs = new PrintWriter("outputSameGraphs.txt");
        PrintWriter out = new PrintWriter("output.txt");
        PrintWriter outMaxMatrixCode = new PrintWriter("outputMaxMatrixCode.txt");
        BufferedReader inMaxCode = new BufferedReader(new FileReader("outputMaxMatrixCode.txt"));

        System.out.println("Введите количество вершин исходных графов");
        int sz = sc.nextInt();

        startTime = System.currentTimeMillis();

        //TreeMap<String, Integer> allResults = new TreeMap<>();
        String s = in.readLine();
        Integer integer = 1;
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
            //String number = "";
            for (String subgraphs : listSubgr) {
                //number += listSubgr;
                outMaxMatrixCode.print(subgraphs + " ");
            }
            outMaxMatrixCode.println();

            /*if (allResults.containsKey(number)){
                allResults.replace(number, 2);
            }
            else {
                allResults.put(number, 1);
            }*/

            s = in.readLine();
            integer++;
            if (integer % 1000 == 0)
                System.out.println(integer);
        }

        /*if (allResults.containsValue(2)){
            System.out.println("Беда");
        }*/

        out.close();
        in.close();
        outMaxMatrixCode.close();
    }
}
