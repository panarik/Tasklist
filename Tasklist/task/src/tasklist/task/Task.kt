package tasklist.task

data class Task(val title: String, val body:List<String>) {

    fun hasBody():Boolean = body.isNotEmpty()
}