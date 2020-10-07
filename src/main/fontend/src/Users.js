import React, { Component, useState, useEffect } from "react";
import axios from "axios";

//USING REACT HOOKS

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

  export default Users;