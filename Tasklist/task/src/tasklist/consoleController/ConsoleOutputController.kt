package tasklist.consoleController

import tasklist.task.Task
import java.lang.StringBuilder

class ConsoleOutputController(private val tasks: List<Task>) {

    fun printAll() {
        if (tasks.isEmpty()) println("No tasks have been input")
        else println(collectAllTasksToLine())
    }

    private fun collectAllTasksToLine(): String {
        val outputLayouts = mutableListOf<String>()
        for (taskIndex in tasks.indices) {
            outputLayouts.add(collectToBlock(taskIndex))
        }
        return outputLayouts.joinToString("\n")
    }

    private fun collectToBlock(index: Int): String {
        val currentTaskLines = collectTaskToLines(tasks[index])
        val resultBlock = StringBuilder()
        if (index < 9) resultBlock.append("${index + 1}  ${currentTaskLines[0]}\n")
        else resultBlock.append("${index + 1} ${currentTaskLines[0]}\n")
        for (lineIndex in 1..currentTaskLines.lastIndex) {
            resultBlock.append("   ${currentTaskLines[lineIndex]}\n")
        }
        return resultBlock.toString()
    }

    private fun collectTaskToLines(task: Task): List<String> {
        val taskLines = mutableListOf(task.title)
        task.body.forEach { taskLines.add(it) }
        return taskLines
    }

}