import axios from 'axios'
import {React, useEffect, useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom'

function EditEmployeeComponent  ()  {

  let navigate = useNavigate()
  const {id} = useParams()
  const [employee, setEmployee]=useState({
    firstName:"",
    lastName:"",
    emailId:"",

})

const{firstName,lastName,emailId}=employee
const onInputChange = (e) => {
setEmployee({...employee,[e.target.name]:e.target.value})
};


useEffect(() => {
  loadUser();
}, []);


const EditEmployee = async (e) => {
  e.preventDefault();

  await axios.put("http://localhost:8080/employee",employee)
}

const loadUser = async () => {
  const result= await axios.get(`http://localhost:8080/employee/${id}`)
  setEmployee(result.data)
}

  return (
   <div className='container'>
    <div className='row'>
      <div className='col-md-6 offset-md-3 border rounde p-4 mt2 shadow'>
        <h2 className='text-center m-4'>Edit Employee</h2>

      </div>

    </div>

   </div>
)
}
export default EditEmployeeComponent