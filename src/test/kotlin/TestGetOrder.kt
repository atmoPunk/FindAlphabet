import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class TestGetOrder {

    @Test
    fun simpleTest() {
        val words = (0 until 26).map {
            ('a' + it).toString().repeat(Random.nextInt(1, 7))
        }.toList()
        assertEquals((0 until 26).map { 'a' + it }, getOrder(words))
    }

    @Test
    fun impossibleTest() {
        val words = listOf("abc", "bcd", "ade")
        assertFailsWith(Graph.CycleFoundException::class) { getOrder(words) }
    }

    @Test
    fun anotherTest() {
        val words = listOf("ivan", "igor", "nikolay", "nadya", "timur", "vasiliy", "dmitriy", "denis", "alexander",
            "anton", "sergey")
        val expectedOrder = listOf('z', 'y', 'x', 'w', 'u', 'r', 'q', 'p', 'o', 'm', 'l', 'k', 'j', 'i', 'n', 't', 'v',
            'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a', 's')
        assertEquals(expectedOrder, getOrder(words))
    }
}
