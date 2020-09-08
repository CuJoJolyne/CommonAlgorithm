package me.demo

object BinaryTree {

    // maximum-depth-of-binary-tree
    fun maxDepth(root: TreeNode<Int>?): Int {
        val result = maxDepthInternal(root)
        println("max depth is $result")
        return result
    }

    private fun maxDepthInternal(root: TreeNode<Int>?): Int {
        if (root == null) {
            return 0
        }
        val left = maxDepthInternal(root.left)
        val right = maxDepthInternal(root.right)
        return if (left > right) {
            left + 1
        } else {
            right + 1
        }
    }

    // balanced-binary-tree
    fun isBalanced(root: TreeNode<Int>?): Boolean {
        val result = maxDepthForBalanced(root)
        println("isBalanced is $result")
        if (result == -1)
            return false
        return true
    }

    private fun maxDepthForBalanced(root: TreeNode<Int>?): Int {
        if (root == null) {
            return 0
        }
        val left = maxDepthForBalanced(root.left)
        val right = maxDepthForBalanced(root.right)

        // left balanced && right balanced && abs(left-right)<=1
        if (left == -1 || right == -1 || left-right > 1 || right-left > 1) {
            return -1
        }
        return if (left > right) {
            left + 1
        } else {
            right + 1
        }
    }

    // binary-tree-maximum-path-sum
    fun maxPathSum(root: TreeNode<Int>?): Int {
        var result = maxPathSumInternal(root)
        println("max path sum is ${result.MaxPath}")
        return result.MaxPath
    }

    data class ResultType(
        var SinglePath: Int,  // single max
        var MaxPath: Int)  // max (single max or single with root value)

    private fun maxPathSumInternal(root: TreeNode<Int>?): ResultType {
        if (root == null)
            return ResultType(0, -(1 shl 16))

        // divide
        val left =  maxPathSumInternal(root.left)
        val right =  maxPathSumInternal(root.right)

        // conquer
        var result = ResultType(0, -(1 shl 16))
        // single max
        if (left.SinglePath > right.SinglePath) {
            result.SinglePath = max(left.SinglePath+root.key, 0)
        } else {
            result.SinglePath = max(right.SinglePath+root.key, 0)
        }
        var maxPath = max(left.MaxPath, right.MaxPath)
        result.MaxPath = max(maxPath, left.SinglePath+right.SinglePath+root.key)
        return result
    }
    
    private fun max(a: Int, b: Int): Int {
        return if (a > b) {
            a
        } else {
            b
        }
    }

    // lowest-common-ancestor-of-a-binary-tree
    fun lowestCommonAncestor(root: TreeNode<Int>?, p: TreeNode<Int>, q: TreeNode<Int>): TreeNode<Int>? {
        //Traversal.levelOrderTraversalBfs(root)
        var result = lowestCommonAncestorInternal(root, p, q)
        println("lowest common ancestor is ${result?.key}")
        return result
    }

    private fun lowestCommonAncestorInternal(root: TreeNode<Int>?, p: TreeNode<Int>, q: TreeNode<Int>): TreeNode<Int>? {
        // if have left or right child tree's common ancestor, return it's, else return child tree's parent
        if (root == null)
            return root

        if (root.key == p.key || root.key == q.key) {
            //println("root is ${root.key}")
            return root
        }

        // divide
        var left = lowestCommonAncestorInternal(root.left, p, q)
        var right = lowestCommonAncestorInternal(root.right, p, q)
        //println("${left?.key} , ${right?.key}")

        // conquer
        // if neither of left and right is null, root is ancestor
        if (left != null && right != null)
            return root
        if (left != null)
            return left
        if (right != null)
            return right
        return null
    }
}
