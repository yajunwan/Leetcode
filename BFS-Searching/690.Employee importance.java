// You have a data structure of employee information, which includes the employee's unique id, their importance value, and their direct subordinates' id.

// You are given an array of employees employees where:

// employees[i].id is the ID of the ith employee.
// employees[i].importance is the importance value of the ith employee.
// employees[i].subordinates is a list of the IDs of the subordinates of the ith employee.
// Given an integer id that represents the ID of an employee, return the total importance value of this employee and all their subordinates.

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int sum = 0;
        Queue<Integer>empQueue = new LinkedList<>();
        Map<Integer,Employee>empHashMap = new HashMap<>();
        for(Employee e: employees){
            empHashMap.put(e.id,e);
        }
        if (empHashMap.get(id).subordinates.size()==0){
            return empHashMap.get(id).importance;
        }else{
            sum+=empHashMap.get(id).importance;
            for(int subId: empHashMap.get(id).subordinates){
                empQueue.add(subId);
            }
        }
        while(empQueue.size()!=0){
            int empId = empQueue.remove();
            for(int subId: empHashMap.get(empId).subordinates){
                empQueue.add(subId);
            }
            sum+=empHashMap.get(empId).importance;
        }
        return sum;
    }
 
}