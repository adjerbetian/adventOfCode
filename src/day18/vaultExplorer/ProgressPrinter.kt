package day18.vaultExplorer

import java.time.Duration
import java.time.Instant

class ProgressPrinter(private val explorerDFS: VaultExplorerDFS) {
    private val LOG_INTERVAL = Duration.ofSeconds(10)
    private var lastLog = Instant.now()
    private val counters = HashMap<String, Long>()

    fun trackProgress(type: String) {
        counters[type] = (counters[type] ?: 0) + 1

        if (Duration.between(lastLog, Instant.now()) > LOG_INTERVAL)
            printProgress()
    }

    fun printProgress() {
        counters.entries.forEach { println("${it.key} : ${prettyInt(it.value)}") }
        println("best path length: ${explorerDFS.bestPathLength}")
        println("---")

        lastLog = Instant.now()
    }

    private fun prettyInt(n: Long): String {
        return n.toString()
            .reversed()
            .map { it.toString() }
            .reduce { acc, s -> if (acc.length % 4 == 3) "$acc $s" else acc + s }
            .reversed()
    }
}