import React from "react";
import '../../../../App.css';
import Image from './Image'
import Description from "./Description"
import Start from "./Start"
import Grid from '@mui/material/Grid';
function Body() {
  return (

<Grid
  container
 >
<Grid item xs={2}> </Grid>
       <Grid item xs={4} container> 
       <Grid item xs={12}>
    <p style={{

fontFamily: 'Fira Sans Condensed',
fontStyle: "normal",
fontWeight: "700",
fontSize: "70px",
         }} className="color">
 Welcome Admin!
        </p>

        <p  className="descr">
   It's time to add a new category
   you can also delete a shareexp user 
        </p>
       </Grid>
        <Grid item xs={6}>
        <Start href="/AddCateg" name="Add Category" />
         </Grid>
         <Grid item xs={6}>
        <Start href="/ListUsers" name="user's list" />
         </Grid>
         </Grid>
<Grid item xs={6}>
        <Image/> </Grid>
        </Grid>
       
   
  );
}
export default Body;
