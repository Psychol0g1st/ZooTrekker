import axios from 'axios';
import * as React from 'react';
import classNames from 'classnames';


export default class LoginForm extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            active: "login",
            firstName: "",
            lastName:"",
            login: "",
            password: "",
            onLogin: props.onLogin
        }
    }

    onChangeHandler = (event) => {
        let name = event.target.name;
        let value = event.target.value;
        this.setState({[name]: value});
    }

    onSubmitLogin = (e) => {
        this.state.onLogin(e, this.state.login, this.state.password);
    }

    render() {
        return(
            <div className='row justify-content-center'>
                <form>
                    <div className='form-outline mb-4'>
                        <label className='form-label' htmlFor='loginName'>Username</label>
                        <input type='login' id='loginName' name='login' className='form-control'/>
                    </div>
                    <div className='form-outline mb-4'>
                        <label className='form-label' htmlFor='loginPassword'>Password</label>
                        <input type='password' id='loginPassword' name='login' className='form-control'/>
                    </div>
                    <button type='submit' className='btn btn-primary btn-block mb-4'>Sign in</button>
                </form>
            </div>
        );
    }
}