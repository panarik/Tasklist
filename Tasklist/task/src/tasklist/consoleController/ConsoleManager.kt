package tasklist.consoleController

import tasklist.task.TaskManager

class ConsoleManager {

    private val tasksManager = TaskManager()

    fun runMenu() {
        while (true) {
            println("Input an action (add, print, end):")
            val inputType = readln()
            if (inputType == "end") {
                println("Tasklist exiting!")
                break
            } else operateTasks(inputType)
        }
    }

    private fun operateTasks(inputType: String) {
        when (inputType) {
            "add" -> addTask()
            "print" -> ConsoleOutputController(tasksManager.tasks).printAll()
            else -> println("The input action is invalid")
        }
    }

    private fun addTask() {
        println("Input a new task (enter a blank line to end):")
        val taskLines = ConsoleInputController().getTaskLines()
        if (taskLines.isEmpty()) {
            println("The task is blank")
        }
        else tasksManager.addTask(taskLines)
    }

}