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


const onSubmit = async (e) => {
  e.preventDefault();
  await axios.put(`http://localhost:8080/employee/${id}`,employee)
  navigate("/")
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
        <form onSubmit={(e) => onSubmit(e)}>
          <div className='mb-3'>
              <label htmlFor='firstName' className='form-label'>First Name</label>
              <input
                type={"text"}
                className='form-control'
                placeholder='Enter your First Name'
                name="firstName"
                value={firstName}
                onChange={(e) => onInputChange(e)}
              />
            </div>
          <div className='mb-3'>
            <label htmlFor='lastName' className='form-label'>Last Name</label>
            <input
              type={"text"}
              className='form-control'
              placeholder='Enter your Last Name'
              name="lastName"
              value={lastName}
              onChange={(e) => onInputChange(e)}
            />
          </div>
          <div className='mb-3'>
            <label htmlFor='emailIde' className='form-label'>Email</label>
            <input
              type={"email"}
              className='form-control'
              placeholder='Enter yourEmail'
              name="emailId"
              value={emailId}
              onChange={(e) => onInputChange(e)}
            />
          </div>
          <button type='submit' className='btn btn-outline-primary'>
                        Submit
                    </button>
                    <Link className='btn btn-outline-danger mx-2' to="/">
                        Cancel
                    </Link>
          
        </form>

      </div>

    </div>

   </div>
)
}
export default EditEmployeeComponent