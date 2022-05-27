import React from "react";
import image from "../../../../images/logo.png"
import '../../../../App.css';
import { Button } from '@mui/material';

function Start(props) {
  return (
    
      <Button  style={{color :"white"}} className="button" href= {props.href}>{props.name}</Button>
 
  );
}
export default Start;
