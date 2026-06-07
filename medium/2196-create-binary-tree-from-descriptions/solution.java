/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> mpp = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < descriptions.length; i++) {
            int[] d = descriptions[i];
            int parent = d[0], child = d[1], isLeft = d[2];

            mpp.putIfAbsent(parent, new TreeNode(parent));
            mpp.putIfAbsent(child, new TreeNode(child));

            if (isLeft == 1) {
                mpp.get(parent).left = mpp.get(child);
            } else {
                mpp.get(parent).right = mpp.get(child);
            }
            set.add(child);
        }

        for (int[] d : descriptions) {
            if (!set.contains(d[0])) {
                return mpp.get(d[0]);
            }
        }

        return null;

    }
}