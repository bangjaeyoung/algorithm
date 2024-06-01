class Solution {
    fun solution(numList: IntArray, n: Int): IntArray {
        val answer = mutableListOf<Int>()
        for (idx in n - 1 until numList.size) {
            answer.add(numList[idx])
        }
        return answer.toIntArray()
    }
}
