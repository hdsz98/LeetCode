package mianshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // String s = scanner.next();
        String s = "He15l154lo87wor7l87d";
        List<Integer> res = new ArrayList<>();
        int i = 0, temp = 0, flag = 0;
        while (i < s.length()) {
            flag = 0;
            while (i < s.length() && Character.isAlphabetic(s.charAt(i))) {
                i++;
                temp = 0;
            }
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                flag = 1;
                temp = temp * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
                i++;
            }
            if (flag == 1)
                res.add(temp);
        }
        res.sort((a, b) -> {return a - b;});
        for (i = 0; i < res.size(); i++)
            System.out.println(res.get(i));
    }
}
