package alfa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static int pow(int value){
        return value*value;
    }

    public static int chkPointAndCircle(int[] circle, int radius, int[] point){
        int chk =  pow(point[0]-circle[0])+pow(point[1]-circle[1]);
        radius = pow(radius);
        return (chk<radius) ?  1: (chk==radius) ? 0: 2;
    }

    public static List readFile(String path) throws IOException {
        List<int[]> res = new ArrayList<>();
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = new String();
        while ((line = br.readLine()) != null){
            String[] readedLine = line.split(" ");
            int[] result = new int[readedLine.length];
            for (int i = 0; i < readedLine.length; i++) {
                try {
                    result[i] = Integer.parseInt(readedLine[i]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            res.add(result);
        }
        return res;
    }

    public static void main (String[] args) throws IOException {

        List<int[]> circle = readFile(args[0]);

        List<int[]> points = readFile(args[1]);
        int radius = circle.get(1)[0];
        for (int[] point: points)
            System.out.print(chkPointAndCircle(circle.get(0),radius,point)+" ");
    }
}
