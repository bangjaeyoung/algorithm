class Solution {
    fun solution(numList: IntArray, n: Int): IntArray {
        return numList.sliceArray(n - 1 until numList.size)
    }
}