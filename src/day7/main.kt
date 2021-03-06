package day7

import intCode.IntCode
import intCode.IntCodeProgram
import intCode.readIntCodeProgram
import java.lang.Long.max

fun main() {
    val program = readIntCodeProgram("src/day7/input.txt")

    val part1 = findMaxThrustForPhases(program, listOf(0, 1, 2, 3, 4))
    println("Part 1: Max thruster signal is $part1")

    val part2 = findMaxThrustForPhases(program, listOf(5, 6, 7, 8, 9))
    println("Part 2: Max thruster signal is $part2")
}

fun findMaxThrustForPhases(program: IntCodeProgram, phases: List<Int>): IntCode {
    var maxOutput = Long.MIN_VALUE
    val permutations = permutations(phases)

    for (phase in permutations) {
        val circuit = AmplificationCircuit(program, phase)
        circuit.run()
        maxOutput = max(maxOutput, circuit.getOutput())
    }

    return maxOutput
}