class Solution {
    fun solution(startNum: Int, endNum: Int): List<Int> {
        val answer = mutableListOf<Int>()
        for (i in startNum downTo endNum) {
            answer.add(i)
        }
        return answer
    }
}