import React, { useState, useEffect } from "react";
import SignUp from "./SignUp";
import SignIn from "./SignIn";
import ContactUs from "./ContactUs";
import AboutUs from "./AboutUs";
import Logout from "./Logout";
import Icon from "./Icon"


function Header() {
  const [logedIn, setLogedIn] = useState(false);
  useEffect(() => {
    if (
      localStorage.getItem("currentUser") !== undefined &&
      localStorage.getItem("currentUser") !== null
    )
      setLogedIn(true);
    console.log("header" + logedIn);
  });
  return (

    <div style={{marginTop:"20px" ,marginLet:"50px"}}>
      
      {logedIn ? <Logout /> : <SignUp />}
      {logedIn ? <SignIn />: <SignIn />}
   <ContactUs />
      <AboutUs />
      <Icon/>
     
   
    </div>
  );
}
export default Header;
