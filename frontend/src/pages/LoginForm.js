import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Form, Button } from 'react-bootstrap';

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
        <div className='row justify-content-center'>
            <Form onSubmit={handleLoginSubmit}>
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
                <Button type='submit' className='btn btn-primary btn-block mb-4'>
                    Bejelentkezés
                </Button>
            </Form>
        </div>
    );
};

export default LoginForm;

