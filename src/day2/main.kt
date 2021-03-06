package day2

import intCode.IntCode
import intCode.IntCodeComputer
import intCode.readIntCodeProgram

fun main() {
    val program = readIntCodeProgram("src/day2/input.txt")

    val computer = IntCodeComputer(program)
    computer.memory[1] = 12
    computer.memory[2] = 2
    computer.run()
    println("First result: ${computer.memory[0]}")

    val (noun, verb) = findNounAndVerbFor(computer, 19690720)
    println("Second result: ${100 * noun + verb}")
}

fun findNounAndVerbFor(computer: IntCodeComputer, expectedResult: IntCode): NounVerb {
    for (noun in 0..99L) {
        for (verb in 0..99L) {
            computer.reset()
            computer.memory[1] = noun
            computer.memory[2] = verb
            computer.run()
            if (computer.memory[0] == expectedResult)
                return NounVerb(noun, verb)
        }
    }
    throw Error("Not found")
}

data class NounVerb(val noun: IntCode, val verb: IntCode)

