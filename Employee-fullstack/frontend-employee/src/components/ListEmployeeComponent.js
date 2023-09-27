
import React, { useEffect, useState } from 'react'
import EmployeeService from './EmployeeService';
import { Link,Navigate, useNavigate, useParams } from 'react-router-dom';
import axios from 'axios'

export const ListEmployeeComponent = () => {
let navigate = useNavigate()

const {id} =  useParams()  
    const [ employees, setEmployees] = useState([])

    useEffect(()=>{
       getAllEmployees();
    },[]);

    const getAllEmployees = () =>{
        EmployeeService.getAllEmployee().then((response) => {
            setEmployees(response.data)
            } ).catch(erro =>{
                console.log(erro);
            })


    }

    const deleteEmployee = async (id) => {
        await axios.delete(`http://localhost:8080/employee/${id}`)
        getAllEmployees()
       
        
    }



  return (
    <div className='container'  >
        <h2 className='text-center'> Employees List</h2>
        <Link to="/addemployee" className='btn btn-primary md-2'>Add Employee</Link>
        <br/><br/>
        <table className='table table-bordered table-striped'>
            <thead className="table">
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Actions</th>
            </thead>
            <tbody>{
                employees.map(
                    employees =>
                    <tr key = {employees.id}>
                        <td> {employees.id}</td>
                        <td>{employees.firstName}</td>
                        <td>{employees.lastName}</td>
                        <td>{employees.emailId}</td>
                        <td>
                            <Link className='btn btn-info btn-sm mx-1' to={`/edit-employee/${employees.id}`}>Update</Link>
                       

                        <button className="btn btn-danger btn-sm mx-1" onClick={() => deleteEmployee(employees.id)}>Deletar</button>
                        </td>
                        
                    </tr>
                )
                }
            </tbody>
        </table>
    </div>
  )
}


