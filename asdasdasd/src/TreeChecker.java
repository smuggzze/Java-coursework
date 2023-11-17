
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
class TreeChecker {

    public List<Integer> preOrder(TreeNode x){
        List<Integer> result = new ArrayList<Integer>();
        result.add(x.val);
        if (x.left != null){
            preOrder(x.left);
        }

        if (x.right != null){
            preOrder(x.right);
        }
        return result;

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> resultP = preOrder(p);
        List<Integer> resultQ = preOrder(q);
        if (resultP == resultQ){
            return true;
        }
        else{
            return false;
        }


    }
}