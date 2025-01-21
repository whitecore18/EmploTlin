data class Employee(
    val name: String,
    val age: Int,
    val salary: Double
)

fun sortEmployeesByName(employees: List<Employee>): List<Employee> {
    return employees.sortedBy { it.name }
}

fun sortEmployeesByAge(employees: List<Employee>): List<Employee> {
    return employees.sortedBy { it.age }
}

fun sortEmployeesBySalary(employees: List<Employee>): List<Employee> {
    return employees.sortedBy { it.salary }
}

fun sortMatrixRows(matrix: Array<IntArray>): Array<IntArray> {
    return matrix.map { it.sorted().toIntArray() }.toTypedArray()
}

fun isSawtooth(array: IntArray): Boolean {
    if (array.size < 2) return false
    for (i in 1 until array.size - 1) {
        if (!((array[i] > array[i - 1] && array[i] > array[i + 1]) ||
                    (array[i] < array[i - 1] && array[i] < array[i + 1]))) {
            return false
        }
    }
    return true
}

fun countAndFindSawtoothArrays(matrix: Array<IntArray>): Pair<Int, List<IntArray>> {
    val sawtoothArrays = matrix.filter { isSawtooth(it) }
    return sawtoothArrays.size to sawtoothArrays
}

fun main() {
    val employees = listOf(
        Employee("Alice", 30, 5000.0),
        Employee("Bob", 25, 4500.0),
        Employee("Charlie", 35, 6000.0)
    )

    val sortedByName = sortEmployeesByName(employees)
    println("Сотрудники отсортированы по имени:")
    sortedByName.forEach { println(it) }

    val sortedByAge = sortEmployeesByAge(employees)
    println("\nСотрудники отсортированы по возрасту:")
    sortedByAge.forEach { println(it) }

    val sortedBySalary = sortEmployeesBySalary(employees)
    println("\nСотрудники отсортированы по зарплате:")
    sortedBySalary.forEach { println(it) }

    val matrix = arrayOf(
        intArrayOf(5, 1, 7, 2),  // Пилообразный массив
        intArrayOf(9, 8, 7, 6),  // Не пилообразный массив
        intArrayOf(3, 4, 1, 5)   // Пилообразный массив
    )

    val sortedMatrix = sortMatrixRows(matrix)
    println("\nОтсортированная матрица:")
    sortedMatrix.forEach { println(it.joinToString(" ")) }

    // Поиск пилообразных массивов в матрице
    val (count, sawtoothArrays) = countAndFindSawtoothArrays(matrix)
    println("\nПилообразных массивов: $count")
    sawtoothArrays.forEach { println(it.joinToString(" ")) }
}