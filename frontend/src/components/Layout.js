import React from 'react';
import Navbar from './Navbar';
import Sidebar from './Sidebar';

const Layout = ({ children }) => {
    return (
        <div className='d-flex flex-row flex-md-row flex-grow-1'>
            <Sidebar />
            <div className='d-flex flex-column content flex-grow-1'>
                <Navbar />
                <main className='flex-grow-1 d-flex flex-column p-3'>
                    {children}
                </main>
            </div>
        </div>
    );
};

export default Layout;


