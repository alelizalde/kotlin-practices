fun main() {
    val employeeOne = Employee("Al", 1)
    val employeeTwo = Employee("Wen", 2)
    val employeeThree = Employee("Wen", 2)

    println(employeeOne === employeeTwo)
    println(employeeTwo === employeeThree)
    println(employeeOne == employeeTwo)
    println(employeeTwo == employeeThree)
}

data class Employee(val name: String, val id: Int){

}