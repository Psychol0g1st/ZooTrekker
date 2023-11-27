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
import Climates from './pages/Climates';
import Substances from './pages/Substance';
import { Helmet } from 'react-helmet';
import favicon from './favicon.ico';

function App() {
  useEffect(() => {
    const user = localStorage.getItem('user');
    if (!user && window.location.pathname !== '/login') {
      window.location.href = '/login';
    }
  }, []);
  document.title = 'ZooTrekker';

  return (
    <div className="App">
      <Helmet>
        <link rel="icon" type="image/x-icon" href={favicon} />
      </Helmet>
      {/* További alkalmazáskód */}
    <BrowserRouter>
      <Routes>
        <Route path='/employees' element={<Dolgozok/>}/>
        <Route path='/animals' element={<Allatok/>}/>
        <Route path='/animaldiets' element={<Etrendek/>}/>
        <Route path='/substances' element={<Substances/>}/>
        <Route path='/cages' element={<Ketrecek/>}/>
        <Route path='/species' element={<Allatfajok/>}/>
        <Route path='/climates' element={<Climates/>}/>
        <Route path='/login' element={<LoginForm/>}/>
        <Route index path="/" element={<Home />}/>
        <Route element={<LoginForm />}/>
        <Route path="*" element={<h1>404</h1>} />
      </Routes>
      </BrowserRouter>
      </div>
    
  )
}


export default App;
