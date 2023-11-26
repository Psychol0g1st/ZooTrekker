import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Form, Button } from 'react-bootstrap';

const LoginForm = ({ onLogin }) => {
    const [login, setLogin] = useState('');
    const [password, setPassword] = useState('');

    useEffect(() => {
        const token = localStorage.getItem('token');
        if (token) {
            window.location.href = '/';
        }
    }, []);

    const handleLoginSubmit = async (e) => {
        e.preventDefault();
        try {
            //TODO send login and password to server return token
            // const response = await axios.post('/api/login', { login, password });
            // const token = response.data.token;
            const token = '1234567890';
            localStorage.setItem('token', token);
            window.location.href = '/';
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
                        name='login'
                        value={login}
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

