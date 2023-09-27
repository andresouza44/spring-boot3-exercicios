import './App.css';
import AddEmployeeComponont from './components/AddEmployeeComponent';
import EditEmployeeComponent from './components/EditEmployeeComponent';
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import { ListEmployeeComponent } from './components/ListEmployeeComponent';
import {BrowserRouter as Router, Routes,Route} from 'react-router-dom'

function App() {
  return (
    <div>
      <Router>
      <HeaderComponent/>
        <div className='container'>
          <Routes>
            <Route exact path="/" Component={ListEmployeeComponent}></Route>
            <Route path="/employees" Component={ListEmployeeComponent}></Route>
            <Route path="/addemployee" Component={AddEmployeeComponont}></Route>
            <Route path="/edit-employee/:id" Component={EditEmployeeComponent}></Route>
          </Routes>
        </div>
      </Router>
      <FooterComponent/>
    </div>
  );
}

export default App;
