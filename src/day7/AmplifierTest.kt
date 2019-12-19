package day7

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AmplifierTest {
    @Test
    fun simpleTest1() {
        val program = intArrayOf(3, 15, 3, 16, 1002, 16, 10, 16, 1, 16, 15, 15, 4, 15, 99, 0, 0)
        val circuit = AmplificationCircuit(program, intArrayOf(4, 3, 2, 1, 0))

        circuit.run()

        assertEquals(43210, circuit.getOutput())
    }

    @Test
    fun simpleTest2() {
        val program =
            intArrayOf(
                3, 23, 3, 24, 1002, 24, 10, 24, 1002, 23, -1, 23,
                101, 5, 23, 23, 1, 24, 23, 23, 4, 23, 99, 0, 0
            )
        val circuit = AmplificationCircuit(program, intArrayOf(0, 1, 2, 3, 4))

        circuit.run()

        assertEquals(54321, circuit.getOutput())
    }

    @Test
    fun simpleTest3() {
        val program =
            intArrayOf(
                3, 31, 3, 32, 1002, 32, 10, 32, 1001, 31, -2, 31, 1007, 31, 0, 33,
                1002, 33, 7, 33, 1, 33, 31, 31, 1, 32, 31, 31, 4, 31, 99, 0, 0, 0
            )
        val circuit = AmplificationCircuit(program, intArrayOf(1, 0, 4, 3, 2))

        circuit.run()

        assertEquals(65210, circuit.getOutput())
    }
}