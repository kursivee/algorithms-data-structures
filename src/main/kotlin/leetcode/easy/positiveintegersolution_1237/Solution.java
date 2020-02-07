package leetcode.easy.positiveintegersolution_1237;

import java.util.ArrayList;
import java.util.List;

interface CustomFunction {
    int f(int x, int y);
}

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= z; i++) {
            for(int j = i; j <= z; j++) {
                if(customfunction.f(i, j) == z) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
                if(customfunction.f(j, i) == z && i != j) {
                    List<Integer> list = new ArrayList<>();
                    list.add(j);
                    list.add(i);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}