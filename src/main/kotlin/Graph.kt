internal class Graph {
    class CycleFoundException : Exception("Cycle found")

    private val matrix: Array<BooleanArray> = Array(26) { BooleanArray(26) }

    fun addEdge(from: Int, to: Int) {
        matrix[from][to] = true
    }

    private fun dfs(vertex: Int, used: IntArray, answer: ArrayList<Int>) {
        used[vertex] = 1
        for (to in matrix[vertex].indices) {
            if (matrix[vertex][to]) {
                if (used[to] == 0) {
                    dfs(to, used, answer)
                } else if (used[to] == 1) {
                    throw CycleFoundException()
                }
            }
        }
        used[vertex] = 2
        answer.add(vertex)
    }

    fun topologicalSort(): List<Int> {
        val used = IntArray(26)
        val answer = ArrayList<Int>()
        for (i in matrix.indices) {
            if (used[i] == 0) {
                dfs(i, used, answer)
            }
        }
        return answer.reversed()
    }
}
