import React, { useState } from "react";
import axios from "axios";

//USING REACT HOOKS

const Users = () => {
  const [users, setUsers] = useState([]);
  const [showUsers, setUserResults] = useState(false);
  const [showForms, setShowForm] = useState(false);
  const [formData, setFormData] = useState({name: ""});

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

  const handleSubmit = () => {
    axios.post("http://localhost:8080/users", formData).then(response =>
      console.log(response)
    ).catch(error =>
      console.log(error)
    )
  };

  const handleChange = (event) => {
    setFormData({
      [event.target.name]: event.target.value
    });
  };

  const onClick = (button) => {
    if (button === "view") {
      setUserResults(!showUsers);
      if (showUsers === false) { //Dont fetch data again if hiding results
        fetchUsers();
      }
    } else {
      setShowForm(!showForms);
    }
  };

  return (
    <div>
      <input type='submit' value='View All Users' onClick={() => onClick("view")} />
      <input type='submit' value='Add a new user' onClick={() => onClick("add")} />
      
      {showForms ? (
      <form onSubmit={handleSubmit}>
        <label>
          Name:
          <input type="text" name="name" value={formData.name} onChange={handleChange}/>
        </label>
        <input type="submit" value="Submit" />
      </form>
      ) : null}
      
      {showUsers ? <DisplayUsers /> : null}
    </div>
  );
};

export default Users;
