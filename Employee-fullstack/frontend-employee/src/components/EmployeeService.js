import axios from "axios";

const  EMPLOYEE_BASE_URL = "http://localhost:8080/employee";

class EmployeeService{
    getAllEmployee(){
        return axios.get(EMPLOYEE_BASE_URL)
    }
}
export default new EmployeeService();