import React from "react";
import image from "../../images/logo.png"
import '../../App.css';
import { Button } from '@mui/material';

function AddExpButton(props) {
  return (
    
      <Button   style={{color:"white"
      , marginTop:"10%",height: 50 
      ,marginLeft:"30%",width:"30%"}}
       className="button" href="/"
        type="submit" >Add my Experience</Button>
 
  );
}
export default AddExpButton;
/*
  <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
               style={{backgroundColor:"rgba(175, 81, 197, 1)"}}

              >
                test
              </Button>*/