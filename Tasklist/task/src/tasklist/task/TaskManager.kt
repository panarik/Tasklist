package tasklist.task

class TaskManager {

    private val tasksHolder = mutableListOf<Task>()
    val tasks get():List<Task> = tasksHolder

    fun addTask(lines: List<String>) {
        val title = lines[0]
        val body = mutableListOf<String>()
        for (i in 1..lines.lastIndex) body.add(lines[i])
        tasksHolder.add(Task(title, body))
    }

    fun isEmpty(): Boolean = this.tasks.isEmpty()

}