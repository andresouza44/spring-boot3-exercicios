import axios from 'axios'
import React, { useEffect, useState } from 'react'
import EmployeeService from './EmployeeService';

export const ListEmployeeComponent = () => {
  
    const [ employees, setEmployees] = useState([])

    useEffect(()=>{
        EmployeeService.getAllEmployee().then((response) => {
        setEmployees(response.data)
        } ).catch(erro =>{
            console.log(erro);
        })
    },[]);
/*
    const loadEmployee = async () =>{
        const result = await axios.get("http://localhost:8080/employee")
        setEmployees(result.data)
        console.log(result.data)
    }
*/
  return (
    <div className='container'>
        <h2> Employees List</h2>
        <br/>
        <table className='table table-bordered table-stripde'>
            <thead>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </thead>
            <tbody>{
                employees.map(
                    employees =>
                    <tr key = {employees.id}>
                        <td> {employees.id}</td>
                        <td>{employees.firstName}</td>
                        <td>{employees.lastName}</td>
                        <td>{employees.emailId}</td>
                    </tr>
                )
                }
            </tbody>
        </table>
    </div>
  )
}


