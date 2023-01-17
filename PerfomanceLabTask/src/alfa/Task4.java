package alfa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task4 {
    public static List readFile(String path) throws IOException {
        List<Integer> res = new ArrayList<>();
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = new String();
        while ((line = br.readLine()) != null){
            res.add(Integer.parseInt(line));
        }
        return res;
    }

    public static void main (String[] args) throws IOException {
        List<Integer> nums = readFile(args[0]);
        Collections.sort(nums);
        int m = nums.size()/2;
        int res = 0;
        for (int x:nums)
            res+=Math.abs(x-m);
        System.out.println(res);
    }
}
