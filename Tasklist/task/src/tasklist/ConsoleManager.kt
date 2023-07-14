package tasklist

import tasklist.task.TaskManager
import java.util.Scanner

class ConsoleManager {

    private lateinit var tasksManager:TaskManager;

    fun createTasks() {
        tasksManager = TaskManager().createTasks(getLines())
    }

    fun printTasks() {
        if (tasksManager.isEmpty()) println("No tasks have been input")
        else tasksManager.getTasks().forEach{ println(it) }
    }

    private fun getLines():List<String> {
        println("Input the tasks (enter a blank line to end):")
        val scanner = Scanner(System.`in`)
        val tasksTitles = mutableListOf<String>()
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            if (line.isEmpty() || Regex("\\s+").matches(line)) return tasksTitles
            tasksTitles.add(line)
        }
        return tasksTitles
    }
}