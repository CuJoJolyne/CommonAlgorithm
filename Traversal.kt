package me.demo

object Traversal {

    fun preOrderTraversal(root: TreeNode<Int>?) {
        if (root == null)
            return
        println("Visited node with value: ${root.key}")
        preOrderTraversal(root.left)
        preOrderTraversal(root.right)
    }

    fun preOrderTraversalNoRecursion(root: TreeNode<Int>?): ArrayList<Int>? {
        if (root == null) {
            println("pre order no recursion result is null")
            return null
        }
        var head: TreeNode<Int>? = root
        val result: ArrayList<Int> = ArrayList()
        val stack: ArrayList<TreeNode<Int>> = ArrayList()
        while (head != null || stack.size != 0) {
            while (head != null) {
                result.add(head.key)
                stack.add(head)
                head = head.left
            }
            // pop
            val node = stack.last()
            stack.removeLast()
            //stack.removeAt(stack.lastIndex)
            head = node.right
        }
        println("pre order no recursion result is $result")
        return result
    }

    fun preOrderTraversalDfsUpDown(root: TreeNode<Int>?) {
        var result: ArrayList<Int> = ArrayList()
        dfsUpDown(root, result)
        println("pre order dfs up down result is $result")
    }

    private fun dfsUpDown(root: TreeNode<Int>?, result: ArrayList<Int>) {
        if (root == null) {
            return
        }
        result.add(root.key)
        dfsUpDown(root.left, result)
        dfsUpDown(root.right, result)
    }

    fun preOrderTraversalDfsDownUpDivideAndConquer(root: TreeNode<Int>?) {
        var result: ArrayList<Int> = ArrayList()
        result = divideAndConquer(root)
        println("pre order dfs down up divide and conquer result is $result")
    }

    private fun divideAndConquer(root: TreeNode<Int>?): ArrayList<Int> {
        var result: ArrayList<Int> = ArrayList()
        var left: ArrayList<Int> = ArrayList()
        var right: ArrayList<Int> = ArrayList()
        if (root == null) {
            return result
        }
        // divide, get part result
        left = divideAndConquer(root.left)
        right = divideAndConquer(root.right)
        // conquer, merge result
        result.add(root.key)
        result.addAll(left)
        result.addAll(right)
        return result
    }

    fun inOrderTraversal(root: TreeNode<Int>?) {
        if (root == null)
            return
        inOrderTraversal(root.left)
        println("Visited node with value: ${root.key}")
        inOrderTraversal(root.right)
    }

    fun inOrderTraversalNoRecursion(root: TreeNode<Int>?): ArrayList<Int>? {
        if (root == null) {
            println("in order no recursion result is null")
            return null
        }
        var head: TreeNode<Int>? = root
        val result: ArrayList<Int> = ArrayList()
        val stack: ArrayList<TreeNode<Int>> = ArrayList()
        while (head != null || stack.size > 0) {
            while (head != null) {
                stack.add(head)
                head = head.left
            }
            val node = stack.last()
            stack.removeLast()
            result.add(node.key)
            head = node.right
        }
        println("in order no recursion result is $result")
        return result
    }

    fun postOrderTraversal(root: TreeNode<Int>?) {
        if (root == null)
            return
        postOrderTraversal(root.left)
        postOrderTraversal(root.right)
        println("Visited node with value: ${root.key}")
    }

    fun postOrderTraversalNoRecursion(root: TreeNode<Int>?): ArrayList<Int>? {
        if (root == null) {
            println("post order no recursion result is null")
            return null
        }
        var head: TreeNode<Int>? = root
        var lastVisit: TreeNode<Int>? = null
        val result: ArrayList<Int> = ArrayList()
        val stack: ArrayList<TreeNode<Int>> = ArrayList()
        while (head != null || stack.size > 0) {
            while (head != null) {
                stack.add(head)
                head = head.left
            }
            val node = stack.last()
            // parent must pop after right child
            if (node.right == null || lastVisit == node.right) {
                stack.removeLast()
                result.add(node.key)
                lastVisit = node
            } else {
                head = node.right
            }
        }
        println("post order no recursion result is $result")
        return result
    }

    fun levelOrderTraversalBfs(root: TreeNode<Int>?) {
        val result: ArrayList<Int> = levelOrder(root)
        println("level order bfs result is $result")
    }

    private fun levelOrder(root: TreeNode<Int>?): ArrayList<Int> {
        var result: ArrayList<Int> = ArrayList()
        var mainQueue: ArrayList<TreeNode<Int>> = ArrayList()
        var levelLength: Int = 0
        if (root == null) {
            return result
        }
        mainQueue.add(root)
        levelLength = mainQueue.size
        while (mainQueue.size > 0) {
            var levelList: ArrayList<Int> = ArrayList()
            if (levelLength == mainQueue.size) {
                while (levelLength > 0) {
                    levelList.add(mainQueue.first().key)
                    levelLength--
                    val node = mainQueue.removeFirst()
                    if (node.left != null)
                        mainQueue.add(node.left!!)
                    if (node.right != null)
                        mainQueue.add(node.right!!)
                }
                // next level
                levelLength = mainQueue.size
            }
            result.addAll(levelList)
        }
        return result
    }
}
