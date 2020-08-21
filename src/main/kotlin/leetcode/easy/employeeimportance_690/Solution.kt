package leetcode.easy.employeeimportance_690

/*
 *	// Definition for Employee.
 *	class Employee {
 *		var id:Int = 0
 *		var importance:Int = 0
 *		var subordinates:List<Int> = listOf()
 *	}
 */

class Employee {
    var id:Int = 0
    var importance:Int = 0
    var subordinates:List<Int> = listOf()
}

class Solution {
    fun getImportance(employees: List<Employee?>, id: Int): Int {
        if(employees.isEmpty()) return 0
        val map = mutableMapOf<Int, Employee>()
        employees.forEach { employee ->
            employee?.let {
                map[it.id] = it
            }
        }
        return sum(map, id)
    }

    private fun sum(employees: MutableMap<Int, Employee>, id: Int): Int {
        val employee = employees[id]!!
        var sum = employee.importance
        employee.subordinates.forEach { subId ->
            sum += sum(employees, subId)
        }
        return sum
    }
}