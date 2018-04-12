import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class MaxCode {

    public TreeSet<String> maxCode(int[][] gr, int index, TreeSet<String> ans) {

        List<Integer> value = val(gr, index); // подсчет степеней вершин
        List<Integer> maxVer = maxVertex(value, index); // список вершин с максимальной степенью

        for (int i = 0; i < maxVer.size(); i++) {
            if (index >= 0) {
                perm(gr, maxVer.get(i), index);
                maxCode(gr, index + 1, ans);
            }
        }
        if (maxVer.size() == 0) {
            String maxCode = "";
            for (int i = 0; i < gr.length; i++) {
                for (int j = i + 1; j < gr.length; j++) {
                    maxCode += String.valueOf(gr[i][j]);
                }
            }
            ans.add(maxCode);
        }
        return ans;
    }

    private List<Integer> val(int[][] gr, int index) {
        List<Integer> value = new ArrayList<>();
        for (int i = index; i < gr.length; i++) {
            value.add(0);
            for (int j = 0; j < gr.length; j++) {
                if (gr[i][j] == 1) {
                    value.set(i - index, value.get(i - index) + 1);
                }
            }
        }
        return value;
    }

    private List<Integer> maxVertex(List<Integer> value, int index) {
        List<Integer> maxVer = new ArrayList<>();
        if (value.size() != 0) {
            int maxVal = value.get(0);
            for (int i = 0; i < value.size(); i++) {
                if (value.get(i) == maxVal) {
                    maxVer.add(i + index);
                } else if (value.get(i) > maxVal) {
                    maxVer.clear();
                    maxVal = value.get(i);
                    maxVer.add(i + index);
                }
            }
        }
        return maxVer;
    }

    private void perm(int[][] gr, int ind, int index) {
        int[] vert = gr[ind];
        gr[ind] = gr[index];
        gr[index] = vert;

        for (int i = 0; i < gr.length; i++) {
            int vol = gr[i][ind];
            gr[i][ind] = gr[i][index];
            gr[i][index] = vol;
        }
    }
}
