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
import { isshaereExpuser,isGuest, isAdmin } from "./service/authentication"
import AddCategForm from "./Components/AddCategory/AddCategForm"

const IsshaereExpuserRoutes = () => useRoutes([
    {path:"/", element: <Dashboard/>},
    {path:"/article", element: <Article/>},
   
    {path:"/AddExp", element: <AddExp/>},
    {path:"/AddCateg", element: <AddCategForm/>},
 

]);

const AdminRoutes = () => useRoutes([
    {path: "/", element: <Home/>},
    {path: "/signin", element: <SignIn/>},
    {path:"/signup", element: <SignUp/>},
    {path:"/dashboard", element: <Dashboard/>},
    {path:"/article", element: <Article/>},
   
    {path:"/AddExp", element: <AddExp/>},


]);
const GuestRoutes = () => useRoutes([
    {path: "/", element: <Home/>},
    {path: "/signin", element: <SignIn/>},
    {path:"/signup", element: <SignUp/>},
   

//    {path: "/forgotPassword", element: <Forgot/>},
//    {path: "/EmailSent", element: <EmailSent/>},
//    {path: "/NewPassword/:userId", element: <NewPassword/>},

]);


const getRoutes = () => {
    console.log("luser likhdam ");
 
    console.log(localStorage.getItem("currentUser"))
 
 if (isshaereExpuser())
  return <IsshaereExpuserRoutes />;
    if (isGuest()) return <GuestRoutes />;
    if (isAdmin()) return <AdminRoutes />;
    return <GuestRoutes />;
}



export { getRoutes };