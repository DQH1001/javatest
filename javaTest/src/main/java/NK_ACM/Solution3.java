package NK_ACM;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
/**
 * 法二
 * 链接：https://www.nowcoder.com/questionTerminal/8a19cbe657394eeaac2f6ea9b0f6fcf6
 * 来源：牛客网
 *
 * public class Solution {
 *     public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
 *         TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
 *         return root;
 *     }
 *     //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
 *     private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
 *
 *         if(startPre>endPre||startIn>endIn)
 *             return null;
 *         TreeNode root=new TreeNode(pre[startPre]);
 *
 *         for(int i=startIn;i<=endIn;i++)
 *             if(in[i]==pre[startPre]){
 *                 root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
 *                 root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
 *                       break;
 *             }
 *
 *         return root;
 *     }
 * }
 */

import java.util.Arrays;
public class Solution3 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre.length==0){
            return null;
        }

        int rootval=pre[0];

        if(pre.length==1){
            return new TreeNode(rootval);
        }

        TreeNode tree = new TreeNode(rootval);
        int rootIndex = 0;
        for(int i=0;i<in.length;i++){
            if(rootval==in[i]){
                rootIndex = i;
                break;
            }
        }

        tree.left=reConstructBinaryTree(Arrays.copyOfRange(pre,1,rootIndex+1),Arrays.copyOfRange(in,0,rootIndex));
        tree.right=reConstructBinaryTree(Arrays.copyOfRange(pre,rootIndex+1,pre.length),Arrays.copyOfRange(in,rootIndex+1,in.length));
        return tree;
    }
}
