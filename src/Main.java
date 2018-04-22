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
        PrintWriter outOne = new PrintWriter("one.txt");
        PrintWriter outTwo = new PrintWriter("two.txt");
        PrintWriter outThree = new PrintWriter("three.txt");
        PrintWriter outFour = new PrintWriter("four.txt");
        PrintWriter outFive = new PrintWriter("five.txt");
        PrintWriter outSix = new PrintWriter("six.txt");
        PrintWriter outSeven = new PrintWriter("seven.txt");
        PrintWriter outEight = new PrintWriter("eight.txt");
        PrintWriter outNine = new PrintWriter("nine.txt");
        PrintWriter outTen = new PrintWriter("ten.txt");


        startTime = System.currentTimeMillis();

        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int eight = 0;
        int nine = 0;
        int ten = 0;
        String s = in.readLine();
        while (s != null) {
            MatrixAndG6 mg6 = new MatrixAndG6();
            int[][] matrix = mg6.g6ToMatrix(s);

            List<int[][]> subgr = new Subgraphs().subgr(matrix);

            TreeMap<String, Integer> listSubgr = new TreeMap<>();
            for (int i = 0; i < subgr.size(); i++) {
                TreeSet<String> maxC = new TreeSet<>();
                new MaxCode().maxCode(subgr.get(i), 0, maxC);
                if (listSubgr.containsKey(maxC.last()))
                    listSubgr.put(maxC.last(), listSubgr.get(maxC.last()) + 1);
                else listSubgr.put(maxC.last(), 1);
            }

            outMaxMatrixCode.print(s + " - ");
            for (String subgraphs : listSubgr.keySet()) {
                outMaxMatrixCode.print(listSubgr.get(subgraphs) + "*(" + subgraphs + ") ");
            }
            outMaxMatrixCode.flush();
            outMaxMatrixCode.println();

            if (listSubgr.size() == 1) {
                one++;
                outOne.println(s + " - " + listSubgr.get(listSubgr.firstKey()) + "*(" + listSubgr.firstKey() + ")");
                outOne.flush();
            } else if (listSubgr.size() == 2) {
                two++;
                outTwo.print(s + " - ");
                for (String subgraphs : listSubgr.keySet()) {
                    outTwo.print(listSubgr.get(subgraphs) + "*(" + subgraphs + ") ");
                }
                outTwo.println();
                outTwo.flush();
            } else if (listSubgr.size() == 3) {
                three++;
                outThree.print(s + " - ");
                for (String subgraphs : listSubgr.keySet()) {
                    outThree.print(listSubgr.get(subgraphs) + "*(" + subgraphs + ") ");
                }
                outThree.println();
                outThree.flush();
            } else if (listSubgr.size() == 4) {
                four++;
                outFour.print(s + " - ");
                for (String subgraphs : listSubgr.keySet()) {
                    outFour.print(listSubgr.get(subgraphs) + "*(" + subgraphs + ") ");
                }
                outFour.println();
                outFour.flush();
            } else if (listSubgr.size() == 5) {
                five++;
                outFive.print(s + " - ");
                for (String subgraphs : listSubgr.keySet()) {
                    outFive.print(listSubgr.get(subgraphs) + "*(" + subgraphs + ") ");
                }
                outFive.println();
                outFive.flush();
            } else if (listSubgr.size() == 6) {
                six++;
                outSix.print(s + " - ");
                for (String subgraphs : listSubgr.keySet()) {
                    outSix.print(listSubgr.get(subgraphs) + "*(" + subgraphs + ") ");
                }
                outSix.println();
                outSix.flush();
            } else if (listSubgr.size() == 7) {
                seven++;
                outSeven.print(s + " - ");
                for (String subgraphs : listSubgr.keySet()) {
                    outSeven.print(listSubgr.get(subgraphs) + "*(" + subgraphs + ") ");
                }
                outSeven.println();
                outSeven.flush();
            } else if (listSubgr.size() == 8) {
                eight++;
                outEight.print(s + " - ");
                for (String subgraphs : listSubgr.keySet()) {
                    outEight.print(listSubgr.get(subgraphs) + "*(" + subgraphs + ") ");
                }
                outEight.println();
                outEight.flush();
            } else if (listSubgr.size() == 9) {
                nine++;
                outNine.print(s + " - ");
                for (String subgraphs : listSubgr.keySet()) {
                    outNine.print(listSubgr.get(subgraphs) + "*(" + subgraphs + ") ");
                }
                outNine.println();
                outNine.flush();
            } else if (listSubgr.size() == 10) {
                ten++;
                outTen.print(s + " - ");
                for (String subgraphs : listSubgr.keySet()) {
                    outTen.print(listSubgr.get(subgraphs) + "*(" + subgraphs + ") ");
                }
                outTen.println();
                outTen.flush();
            }

            s = in.readLine();
        }

        System.out.println("one = " + one);
        System.out.println("two = " + two);
        System.out.println("three = " + three);
        System.out.println("four = " + four);
        System.out.println("five = " + five);
        System.out.println("six = " + six);
        System.out.println("seven = " + seven);
        System.out.println("eight = " + eight);
        System.out.println("nine = " + nine);
        System.out.println("ten = " + ten);

        in.close();
        outMaxMatrixCode.close();
        outOne.close();
        outTwo.close();
        outThree.close();
        outFour.close();
        outFive.close();
        outSix.close();
        outSeven.close();
        outEight.close();
        outNine.close();
        outTen.close();
    }
}
