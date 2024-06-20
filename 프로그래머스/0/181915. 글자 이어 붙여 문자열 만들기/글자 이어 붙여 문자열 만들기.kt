class Solution {
    fun solution(my_string: String, index_list: IntArray): String {
        val result = StringBuilder()
        for (index in index_list) {
            result.append(my_string[index])
        }
        return result.toString()
    }
}