public class MatrixAndG6 {

    // функция перевода g6 в матрицу
    public int[][] g6ToMatrix(String string){
        StringBuilder matr = new StringBuilder();
        int size = ((int) string.charAt(0)) - 63;
        int[][] matrix = new int[size][size];
        for (int i = 1; i < string.length(); i++) {
            int number = ((int) string.charAt(i)) - 63;
            StringBuilder str = new StringBuilder();
            str.append(Integer.toBinaryString(number));
            while (str.length() < 6)
                str.reverse().append("0").reverse();
            matr.append(str);
        }
        String m = String.valueOf(matr);
        int pos = 0;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] = Integer.parseInt(m.substring(pos, pos+1));
                matrix[j][i] = Integer.parseInt(m.substring(pos, pos+1));
                pos++;
            }
        }
        return matrix;
    }
}
