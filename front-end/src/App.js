import logo from './logo.svg';
import './App.css';
import Header from './Components/Home/header/Header'
import Home from "./Components/Home/Home"
import SignIn from "./Components/Signin/SignIn"
import SignUp from "./Components/signup/SignUp"
import {useEffect, useState} from "react";
import {BrowserRouter as Router, Route, Routes, useRoutes} from "react-router-dom";
import Dashboard from './Components/Dashboard/Dashboard';
import Article from './Components/Article/Article';
import AddExp from "./Components/AddExp/AddExp"

import {getRoutes} from "./routes"
function App() {

  return (
    <div className="App">
      
      <Router>
      
      {getRoutes()}
        
</ Router>

    </div>

  );
}

export default App;
