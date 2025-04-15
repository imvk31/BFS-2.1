/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
class EmpImp {
    
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> myEmp = new HashMap<>();
        for(Employee emp : employees){
            myEmp.put(emp.id, emp);
        }
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(id);
        int res = 0;
        while(!myQueue.isEmpty()){
            Employee emp = myEmp.get(myQueue.poll());
            res += emp.importance;
            for(int subId: emp.subordinates){
                myQueue.add(subId);
            }
        }
        return res;
    }
}