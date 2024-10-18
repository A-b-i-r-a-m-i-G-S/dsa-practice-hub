// Q : https://leetcode.com/problems/delete-nodes-and-return-forest/

class Solution {
    private boolean traverse(TreeNode node, HashSet<Integer> del, List<TreeNode> ans){
        if(node == null) return false;

        boolean left = traverse(node.left, del, ans);
        boolean right = traverse(node.right, del, ans);

        
        if(left){
            node.left = null;
        }
        if(right){
            node.right = null;
        }

        if(del.contains(node.val)){
            if(node.left!=null){
                ans.add(node.left);
            }
            if(node.right!=null){
                ans.add(node.right);
            }

            node.left = null;
            node.right = null;

            return true;
        }

        return false;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        HashSet<Integer> del = new HashSet<>();
        for(int n : to_delete) del.add(n);
        traverse(root, del, ans);
        if(!del.contains(root.val)) ans.add(root);
        return ans;
    }
}
