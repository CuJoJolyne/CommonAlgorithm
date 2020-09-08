package me.demo

object CommonSort {

    fun MergeSort(nums: ArrayList<Int>): ArrayList<Int> {
        val result = mergeSort(nums)
        println("merge is $result")
        return result
    }

    private fun mergeSort(nums: ArrayList<Int>): ArrayList<Int> {
        if (nums.size <= 1)
            return nums
        // divide
        val mid: Int = nums.size / 2
        // may use additional memory, consider using .subList
        val left: ArrayList<Int> = mergeSort(ArrayList(nums.slice(0 until mid)))
        val right: ArrayList<Int> = mergeSort(ArrayList(nums.slice(mid until nums.size)))
        // merge two parts
        val result = merge(left, right)
        return result
    }

    private fun merge(left: ArrayList<Int>, right: ArrayList<Int>): ArrayList<Int> {
        val result: ArrayList<Int> = ArrayList()
        var l: Int = 0
        var r: Int = 0
        while (l < left.size && r < right.size) {
            if (left[l] < right[r]) {
                result.add(left[l])
                l++
            } else {
                result.add(right[r])
                r++
            }
        }
        if (l < left.size) {
            result.addAll(left.subList(l, left.size))
        }
        if (r < right.size) {
            result.addAll(right.subList(r, right.size))
        }
        return result
    }

    fun QuickSort(nums: ArrayList<Int>) {
        // divide array into 2 parts, left < right, just swap, no need to merge
        quickSort(nums, 0, nums.size-1)
        println("quick is ${nums.joinToString(" ")}")
    }

    private fun quickSort(nums: ArrayList<Int>, start: Int, end: Int) {
        if (start < end) {
            val pivot: Int = partition(nums, start, end)
            quickSort(nums, start, pivot-1)
            quickSort(nums, pivot+1, end)
        }
    }

    private fun partition(nums: ArrayList<Int>, start: Int, end: Int): Int {
        val t = nums[end]
        var i = start
        for (j in start..end) {
            if (nums[j] < t) {
                swap(nums, i, j)
                i++
            }
        }
        swap(nums, i, end)
        return i
    }

    private fun swap(nums: ArrayList<Int>, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}
