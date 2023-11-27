import React from "react";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
  import { faUser } from '@fortawesome/free-solid-svg-icons'

export default function Navbar() {
    const user = localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')) : null;
    return (
        <div><nav className="navbar navbar-expand-lg bg-body-tertiary border">
            <div className="container-fluid">
                <div className="d-flex w-100">
                    {user && (
                    <div className="nav-link ms-auto ">
                        <a className="btn btn-brown " href={"/employee/" + user?.id}> <FontAwesomeIcon icon={faUser}/> {user?.firstName + " " + user?.lastName} </a>
                    </div>
                    )}

                </div>

                
            </div>
        </nav>
        </div>
    )
}