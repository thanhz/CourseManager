import React, {useState, useEffect} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from "axios";

const Users = () => {

  const [users, setUsers] = useState([]);
  
  const fetchUsers = () => {
    axios.get("http://localhost:8080/users").then(response => {
      console.log(response);
      setUsers(response.data);
    });
  };

  useEffect(() => {
    fetchUsers();
  }, []);

  return users.map((user, index) => {
    return(
      <div key={index}>
        <h1>{user.id}</h1>
        <p>{user.name}</p>
      </div>
    )
  })
};

function App() {
  return (
    <div className="App">
      <Users />
    </div>
  );
}

export default App;
