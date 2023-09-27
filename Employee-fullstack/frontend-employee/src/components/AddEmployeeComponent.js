import {React, useEffect, useState } from 'react'
import EmployeeService from './EmployeeService'
import { Link, useNavigate, useParams } from 'react-router-dom'

const AddEmployeeComponent = () => {
/* uma abordagem
  const [employee, setEmployees]= useState({
    firstname:"",
    lastname:"",
    email:"",
  })
// const{firstname,lastname,email}= employee

const onInputChange = (e) =>{
  setEmployees[{...employee,[e.target.firstname]:e.target.value}]
}
*/


let navigate = useNavigate()

const [firstName, SetFirstName] = useState("")
const [lastName, SetLastName] = useState("")
const [emailId, Setemail] = useState("")

const {id} = useParams()

const saveEmployee =  (e) => {
  e.preventDefault();
  const result = {firstName,lastName,emailId}
  EmployeeService.saveEmployee(result).then((response) =>{
        console.log(response.data)
        navigate("/")
  }).catch(error=> {
     console.log(error)
})

//  await axios.post("http://localhost:8080/employee",result)
}

  return (
  
    <div>
      <br/><br/>
      <div className='container'>
        <div className='row'>
          <div className='card col-md-6 offset-md-3 offset-md-3'>
            <h2 className='text-center'>Add Employee</h2>
            <div className='card-body'>
              <form>
                <div className='form-group mb-2'>
                  <label className='form-label'>First Name: </label>
                  <input
                    type = "text"
                    placeholder='Enter First Name'
                    name='firstName'
                    className='form-control'
                    value={firstName}
                    onChange={(e) => SetFirstName(e.target.value)}
                  >
                  </input>
                  <label className='form-label'>Last Name: </label>
                  <input
                    type = "text"
                    placeholder='Enter Last Name'
                    name='lastName'
                    className='form-control'
                    value={lastName}
                    onChange={(e) => SetLastName(e.target.value)}
                  >
                  </input>
                  <label className='form-label'>Email: </label>
                  <input
                    type = "email"
                    placeholder='Enter email'
                    name='email'
                    className='form-control'
                    value={emailId}
                    onChange={(e) => Setemail(e.target.value)}
                  >
                  </input>
                  <br/>
                  <button className='btn btn-success btn-sm mx-1' onClick={ (e) => saveEmployee(e)}>Submit</button>
                  <Link to="/employees" className='btn btn-danger btn-sm mx-1'>Cancel</Link>
            


                </div>
              
              </form>
            </div>


          </div>
        </div>

      </div>
    </div>
  )
}

export default AddEmployeeComponent