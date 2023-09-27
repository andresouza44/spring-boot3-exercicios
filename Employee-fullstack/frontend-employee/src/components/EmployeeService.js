import axios from "axios";

const  EMPLOYEE_BASE_URL = "http://localhost:8080/employee";

class EmployeeService{
    getAllEmployee(){
        return axios.get(EMPLOYEE_BASE_URL)
    }

    saveEmployee(employee){
        return axios.post(EMPLOYEE_BASE_URL,employee)
    }
}
export default new EmployeeService();