import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Form, Button } from 'react-bootstrap';
import logo from '../icons/LOGO.svg'


const LoginForm = ({ onLogin }) => {
    const [username, setLogin] = useState('');
    const [password, setPassword] = useState('');

    useEffect(() => {
        const user = localStorage.getItem('user');
        if (user) {
            window.location.href = '/';
        }
    }, []);

    const handleLoginSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8082/employees/login', { username, password });
            if(response?.data){
                const user = {...response.data};
                localStorage.setItem('user', JSON.stringify(user));
                window.location.href = '/';
            } else {
                alert('Hibás felhasználónév vagy jelszó!');
            }
        } catch (error) {
            console.error(error);
        }
    };

    return (
       <div className='row justify-content-center align-items-center h-100'>
           <div className='col-md-6 text-center'>
               <a className="nav-brand mb-4" href="/">
                   <img src={logo} alt="logo" style={{ maxHeight: '56px' }} />
               </a>
               <Form onSubmit={handleLoginSubmit} style={{ maxWidth: '400px', margin: '0 auto' }}>
                   <Form.Group className='mb-4' controlId='loginName'>
                       <Form.Label>Felhasználónév</Form.Label>
                       <Form.Control
                           type='text'
                           name='username'
                           value={username}
                           onChange={(e) => setLogin(e.target.value)}
                       />
                   </Form.Group>
                   <Form.Group className='mb-4' controlId='loginPassword'>
                       <Form.Label>Jelszó</Form.Label>
                       <Form.Control
                           type='password'
                           name='password'
                           value={password}
                           onChange={(e) => setPassword(e.target.value)}
                       />
                   </Form.Group>
                   <button type='submit' className='btn btn-block mb-4 btn-brown'>
                       Bejelentkezés
                   </button>
               </Form>
           </div>
       </div>

    );
};

export default LoginForm;

