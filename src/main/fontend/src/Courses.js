import React, { Component } from "react";
import axios from "axios";

export default class Courses extends Component {
  constructor(props) {
    super(props);

    this.state = { Courses: [] };
  }

  componentDidMount() {
    axios.get("http://localhost:8080/courses").then((response) => {
      console.log(response);
      this.setState({Courses:response.data});
    });
  }

  render() {
    const courses = this.state.Courses.map((course, index) => (
      <div>
        <div key={index}>
        <h1>{course.id}</h1>
        <p>{course.name}</p>
      </div>
      </div>
    ));

    return (
      <div id='layout-content' className='layout-content-wrapper'>
        <div className='panel-list'>{courses}</div>
      </div>
    );
  }
}
