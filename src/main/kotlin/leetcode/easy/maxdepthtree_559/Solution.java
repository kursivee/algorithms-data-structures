package leetcode.easy.maxdepthtree_559;

import java.util.List;

// https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        return maxDepth(root, 0);
    }

    private int maxDepth(Node root, int depth) {
        int curr = ++depth;
        if(!root.children.isEmpty()) {
            for(int i = 0; i < root.children.size(); i++) {
                int d = maxDepth(root.children.get(i), depth);
                if(d > curr) {
                    curr = d;
                }
            }
        }
        return curr;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}