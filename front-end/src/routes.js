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
import AddCateg from "./Components/AddCategory/AddCateg"
import ListCoach from "./Components/Admin/ListCoach"
import DashbordAdmin from "./Components/Admin/DashboardAdmin/DashbordAdmin"

const IsshaereExpuserRoutes = () => useRoutes([
    {path:"/", element: <Dashboard/>},
    {path:"/experience/:id", element: <Article/>},
    {path:"/AddExp", element: <AddExp/>},
    {path:"/AddCateg", element: <AddCateg/>},
    {path:"/ListUsers", element: <ListCoach/>},
    {path:"/DashbordAdmin", element: <DashbordAdmin/>},


]);

const AdminRoutes = () => useRoutes([
    {path:"/AddCateg", element: <AddCateg/>},
    {path:"/ListUsers", element: <ListCoach/>},
    {path:"/", element: <DashbordAdmin/>},


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