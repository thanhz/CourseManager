import React from 'react';
import logo from './logo.svg';
import './App.css';
import Users from "./Users"
import Courses from './Courses'


function App() {
  return (
    <div className="App">
      <h1>Course Manager</h1>
      <h2>USERS</h2>
      <Users />
      <h2>COURSES</h2>
      <Courses/>
    </div>
  );
}

export default App;
