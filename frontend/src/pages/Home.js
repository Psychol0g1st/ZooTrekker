import React from 'react';
import Layout from '../components/Layout';
import { getFullDayName } from '../utils/date';
import { isWorkingDay } from '../utils/working-day';

export default function Home() {
    const user = localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')) : null;
    const days = user?.workDays?.split(',').map((day) => day.trim());
    return(
        <Layout>
            <h2 className="text">Munkabeosztásod</h2>
            {days && (
                <div className="container mt-3">
                    <div className="row row-cols-2 row-cols-md-4 g-4">
                        {days.map((day, index) => (
                        <div key={index} className="col">
                            <div className={`card h-100 ${isWorkingDay(day) ? 'bg-success' : 'bg-secondary'}` }>
                            <div className="card-body">
                                <h5 className="card-title text-white">{getFullDayName(day)}</h5>
                                <p className="card-text text-white">Hours: {user?.workStartHour} - {user?.workEndHour}</p>
                                <ul className="list-group">
                                <li className="list-group-item">Tasks:</li>
                                {/* {day.tasks.map((task, taskIndex) => (
                                    <li key={taskIndex} className="list-group-item">{task}</li>
                                ))} */}
                                </ul>
                            </div>
                            </div>
                        </div>
                        ))}
                    </div>
                </div>
            )}
            {!days && (
                <h3 className="">Nincs</h3>
            )}
        </Layout>
    )
}