package tasklist.task

class TaskManager {

    private val tasks = mutableListOf<Task>()

    fun createTasks(titles: List<String>): TaskManager {
        for (i in titles.indices) {
            tasks.add(Task(i, titles[i].replace(Regex("^\\s+"), "")))
        }
        return this
    }

    fun getTasks(): List<String> {
        val result = mutableListOf<String>()
        for (i in tasks.indices) {
            val taskIndex = tasks[i].index + 1
            val taskTitle = tasks[i].title
            if (i < 9) result.add("$taskIndex  $taskTitle")
            else result.add("$taskIndex $taskTitle")
        }
        return result.toList()
    }

    fun isEmpty(): Boolean = this.tasks.isEmpty()

}