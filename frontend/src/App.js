import logo from './logo.svg';
import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import  {BrowserRouter, Routes, Route}  from 'react-router-dom';
import { useEffect } from 'react';
import Home from "./pages/Home"
import Dolgozok from "./pages/Employees"
import Allatok from "./pages/Animals"
import Etrendek from './pages/Diets'
import Ketrecek from './pages/Cage'
import Allatfajok from './pages/Species';
import LoginForm from './pages/LoginForm';


function App() {
  useEffect(() => {
    const token = localStorage.getItem('token');
    console.log(token)
    if (!token && window.location.pathname !== '/login') {
      window.location.href = '/login';
    }
  }, []);
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/employees' element={<Dolgozok/>}/>
        <Route path='/animals' element={<Allatok/>}/>
        <Route path='/animaldiets' element={<Etrendek/>}/>
        <Route path='/cages' element={<Ketrecek/>}/>
        <Route path='/species' element={<Allatfajok/>}/>
        <Route path='/login' element={<LoginForm/>}/>
        <Route index path="/" element={<Home />}/>
        <Route element={<LoginForm />}/>
          {/* <Route path="blogs" element={<Blogs />} />
          <Route path="contact" element={<Contact />} />
          <Route path="*" element={<NoPage />} /> */}
      </Routes>
    </BrowserRouter>
  )
}

export default App;
