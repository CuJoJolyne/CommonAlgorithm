package me.demo

class TreeNode<T> (
    var key: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null) {

    fun preOrderTraversal() {
        performAction()
        left?.preOrderTraversal()
        right?.preOrderTraversal()
    }
    
    fun inOrderTraversal() {
        left?.inOrderTraversal()
        performAction()
        right?.inOrderTraversal()
    }

    fun postOrderTraversal() {
        left?.postOrderTraversal()
        right?.postOrderTraversal()
        performAction()
    }

    private fun performAction() {
        println("Visited node with value: $key")
    }
}
