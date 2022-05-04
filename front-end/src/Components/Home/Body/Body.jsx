import React from "react";
import '../../../App.css';
import Image from './Image'
import Description from "./Description"
import Start from "./Start"
import Grid from '@mui/material/Grid';
function Body() {
  return (

<Grid
  container
  direction="row"
  justifyContent="center"
  alignItems="center">
<Grid item xs={2}> </Grid>
       <Grid item xs={4} container> 
       <Grid item xs={12}>
    <p style={{

width: "462px",
height: "168px",
fontFamily: 'Fira Sans Condensed',
fontStyle: "normal",
fontWeight: "700",
fontSize: "70px",
lineHeight: "84px"
        
        }} className="color">
      Inspiration
is everywhere
        </p>
       </Grid>
       <Grid item xs={12}>
        <Description/>
        </Grid>
        <Grid item xs={12}>
        <Start/>
         </Grid>
         </Grid>
<Grid item xs={6}>
        <Image/> </Grid>
        </Grid>
       
   
  );
}
export default Body;
