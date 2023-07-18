package tasklist.consoleController

import java.util.*

class ConsoleInputController {

    fun getTaskLines(): List<String> {
        val scanner = Scanner(System.`in`)
        val taskLines = mutableListOf<String>()
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine().replace(Regex("^\\s+"), "")
            if (line.isEmpty() || Regex("\\s+").matches(line)) return taskLines
            else taskLines.add(line)
        }
        return taskLines
    }

}