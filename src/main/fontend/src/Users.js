import React, { useState } from "react";
import axios from "axios";

//USING REACT HOOKS

const Users = () => {
  const [users, setUsers] = useState([]);
  const [showResults, setShowResults] = useState(false);

  const fetchUsers = () => {
    axios.get("http://localhost:8080/users").then((response) => {
      console.log(response);
      setUsers(response.data);
    });
  };

  const DisplayUsers = () => {
    return users.map((user, index) => {
      return (
        <div key={index}>
          <h1>{user.id}</h1>
          <p>{user.name}</p>
        </div>
      );
    });
  };

  const onClick = () => {
    setShowResults(!showResults);
    fetchUsers();
  };

  return (
    <div>
      <input type='submit' value='View All Users' onClick={onClick} />
      <input type='submit' value='Add a new user' onClick={onClick} />
      {showResults ? <DisplayUsers /> : null}
    </div>
  );
};

export default Users;
