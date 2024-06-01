class Solution {
    fun solution(numList: IntArray): Int {
        for (idx in numList.indices) {
            if (numList[idx] < 0) {
                return idx
            }
        }
        return -1
    }
}
