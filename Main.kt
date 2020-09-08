package me.demo

import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    println("Hello me!")
    val time = measureTimeMillis {
        //bttTest()
        //csTest()
        btTest()
    }
    println("total time: $time ms")
}

private fun bttTest() {
    //      3
    //    /   \
    //   4     5
    //  / \   / 
    // 0   1 2
    val zero = TreeNode(0)
    val one = TreeNode(1)
    val two = TreeNode(2)
    val four = TreeNode(4)
    val five = TreeNode(5)
    val root = TreeNode(3)
    root.left = four
    root.right = five
    four.left = zero
    four.right = one
    five.left = two

    println("pre order:")
    //root.preOrderTraversal()
    Traversal.preOrderTraversal(root)
    Traversal.preOrderTraversalNoRecursion(root)
    Traversal.preOrderTraversalDfsUpDown(root)
    Traversal.preOrderTraversalDfsDownUpDivideAndConquer(root)
    println("in order:")
    Traversal.inOrderTraversal(root)
    Traversal.inOrderTraversalNoRecursion(root)
    println("post order:")
    Traversal.postOrderTraversal(root)
    Traversal.postOrderTraversalNoRecursion(root)
    println("level order:")
    Traversal.levelOrderTraversalBfs(root)
}

private fun csTest() {
    val nums: ArrayList<Int> = arrayListOf(39, 17, 45, 2, 7, 88, 10)
    println("src is ${nums.joinToString(" ")}")
    CommonSort.MergeSort(nums)
    CommonSort.QuickSort(nums)
    //val mid = nums.size / 2
    //nums.sliceArray(0..mid).forEach { print(it) }
    //nums.sliceArray(mid until nums.size).forEach(System.out::print)
    //println(nums.sliceArray(0 until mid).joinToString(" "))
    //println(nums.sliceArray(mid until nums.size).joinToString(" "))
}

private fun btTest() {
    /*
    //      3
    //    /   \
    //   4     5
    //  / \   / 
    // 0   1 2
    val root = TreeNode(3)
    val node0 = TreeNode(0)
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node4 = TreeNode(4)
    val node5 = TreeNode(5)
    root.left = node4
    root.right = node5
    node4.left = node0
    node4.right = node1
    //node5.left = node2
    node1.left = node2

    BinaryTree.maxDepth(root)
    BinaryTree.isBalanced(root)
    */

    /*
    //     -10
    //    /   \
    //   9     20
    //        /  \ 
    //      15    7
    val root = TreeNode(-10)
    val node9 = TreeNode(9)
    val node20 = TreeNode(20)
    val node15 = TreeNode(15)
    val node7 = TreeNode(7)

    root.left = node9
    root.right = node20
    node20.left = node15
    node20.right = node7

    BinaryTree.maxPathSum(root)
    */

    //      3
    //    /   \
    //   5     1
    //  / \   / \ 
    // 6   2 0   8
    //    / \
    //   7   4
    // root = [3,5,1,6,2,0,8,null,null,7,4], p=5, q=0
    val root = TreeNode(3)
    val node5 = TreeNode(5)
    val node1 = TreeNode(1)
    val node6 = TreeNode(6)
    val node2 = TreeNode(2)
    val node0 = TreeNode(0)
    val node8 = TreeNode(8)
    val node7 = TreeNode(7)
    val node4 = TreeNode(4)

    root.left = node5
    root.right = node1
    node5.left = node6
    node5.right = node2
    node1.left = node0
    node1.right = node8
    node2.left = node7
    node2.right = node4

    BinaryTree.lowestCommonAncestor(root, TreeNode(5), TreeNode(0))
    BinaryTree.lowestCommonAncestor(root, TreeNode(5), TreeNode(4))
    BinaryTree.lowestCommonAncestor(root, TreeNode(2), TreeNode(6))
}
