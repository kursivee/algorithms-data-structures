package leetcode.medium.findnodebintreeclone_1379;

import leetcode.easy.mergetwobinarytrees_617.TreeNode;

public class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(cloned != null && cloned.getLeft() == null && cloned.getRight() == null) return cloned;
        return recursive(cloned, target.getVal());
    }

    private TreeNode recursive(TreeNode node, int target) {
        if(node == null) return null;
        if(node.getVal() == target) return node;
        if(node.getLeft() == null && node.getRight() == null) return null;
        TreeNode left = recursive(node.getLeft(), target);
        if(left != null) return left;
        return recursive(node.getRight(), target);
    }
}
