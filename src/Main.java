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
        BufferedReader in1 = new BufferedReader(new FileReader("input.txt"));
        BufferedReader in2 = new BufferedReader(new FileReader("input.txt"));
        PrintWriter outSameGraphs = new PrintWriter("outputSameGraphs.txt");
        PrintWriter out = new PrintWriter("output.txt");
        PrintWriter outMaxMatrixCode = new PrintWriter("outputMaxMatrixCode.txt");
        BufferedReader inMaxCode1 = new BufferedReader(new FileReader("outputMaxMatrixCode.txt"));
        BufferedReader inMaxCode2 = new BufferedReader(new FileReader("outputMaxMatrixCode.txt"));
        PrintWriter outMin = new PrintWriter("min.txt");
        PrintWriter outMax = new PrintWriter("max.txt");

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

            for (String subgraphs : listSubgr) {
                outMaxMatrixCode.print(subgraphs + " ");
            }
            outMaxMatrixCode.println();

            if (listSubgr.size() == 1){
                outMin.println(s + " - " + listSubgr.first());
            }
            else if (listSubgr.size() == matrix.length){
                outMax.print(s + " - ");
                for (String subgraphs : listSubgr) {
                    outMax.print(subgraphs + " ");
                }
                outMax.println();
            }

            s = in.readLine();
            integer++;
            if (integer % 1000 == 0)
                System.out.println(integer);
        }

        out.close();
        in.close();
        outMaxMatrixCode.close();
        outMax.close();
        outMin.close();

        TreeMap<String, TreeSet<String>> sameGraphs = new TreeMap<>();
        String s1 = inMaxCode1.readLine();
        String graph1 = in1.readLine();
        while (s1 != null){
            String s2 = inMaxCode2.readLine();
            String graph2 = in2.readLine();
            while (s2 != null){
                if (s1.equals(s2) && !graph1.equals(graph2)){
                    if (sameGraphs.containsKey(s1)){
                        if (!sameGraphs.get(s1).contains(graph1)){
                            TreeSet<String> newSet= sameGraphs.get(s1);
                            newSet.add(graph1);
                            sameGraphs.replace(s1, newSet);
                        }
                        if (!sameGraphs.get(s1).contains(graph2)){
                            TreeSet<String> newSet= sameGraphs.get(s1);
                            newSet.add(graph2);
                            sameGraphs.replace(s1, newSet);
                        }
                    } else {
                        TreeSet<String> newSet= sameGraphs.get(s1);
                        newSet.add(graph1);
                        newSet.add(graph2);
                        sameGraphs.put(s1, newSet);
                    }
                }

                s2 = inMaxCode2.readLine();
                graph2 = in2.readLine();
            }

            s1 = inMaxCode1.readLine();
            graph1 = in1.readLine();
        }

        for (String code: sameGraphs.keySet()) {
            outSameGraphs.print(code + " - ");
            for (String graphs: sameGraphs.get(code)) {
                outSameGraphs.print(graphs + " ");
            }
            outSameGraphs.println();
        }

        in.close();
        in2.close();
        outSameGraphs.close();
    }
}
