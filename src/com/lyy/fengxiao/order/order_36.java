package com.lyy.fengxiao.order;

import java.util.HashMap;
import java.util.Map;

public class order_36 {

    public static boolean isValidSudoku(char[][] board) {
        Map<Character, Map<Integer, Integer>> map = new HashMap<>();
        int length = 9;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                Map<Integer, Integer> aDefault = map.getOrDefault(c, new HashMap<>());
                //向同行
                if (aDefault.containsKey(i)) {
                    return false;
                }
                //相同列
                if (aDefault.containsValue(j)) {
                    return false;
                }
                //3*3单元格
                for (Map.Entry<Integer, Integer> entry : aDefault.entrySet()) {
                    Integer key = entry.getKey();
                    Integer value = entry.getValue();
                    if (key / 3 == i / 3 && value / 3 == j / 3) {
                        return false;
                    }
                }
                aDefault.put(i, j);
                map.put(c, aDefault);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board=new char[][]{{'.','4','.','.','.','.','.','.','.'}, {'.','.','4','.','.','.','.','.','.'}, {'.','.','.','1','.','.','7','.','.'}, {'.','.','.','.','.','.','.','.','.'}, {'.','.','.','3','.','.','.','6','.'}, {'.','.','.','.','.','6','.','9','.'}, {'.','.','.','.','1','.','.','.','.'}, {'.','.','.','.','.','.','2','.','.'}, {'.','.','.','8','.','.','.','.','.'}};
        System.out.println(isValidSudoku(board));
    }
}
