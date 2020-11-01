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
      this.setState({ Courses: response.data });
    });
  }

  render() {
    const courses = this.state.Courses.map((course, index) => (
      <div key={index}>
        <h3>{course.id}</h3>
        <p>{course.name}</p>
      </div>
    ));

    return (
      <div id='layout-content' className='layout-content-wrapper'>
        <div className='panel-list'>{courses}</div>
      </div>
    );
  }
}
