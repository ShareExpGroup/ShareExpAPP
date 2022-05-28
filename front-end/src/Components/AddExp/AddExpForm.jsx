import * as React from 'react';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Paper from '@mui/material/Paper';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';
import BACK from "../../images/BACK.png"
import '../../App.css';
import AddExpButton from "./AddExpButton"
import {useEffect, useState} from "react";
import {addexp} from "../../service/Experience"
import {getcategories} from "../../service/Category"
function AddExpForm(){

  const [position, setPosition] = useState(0);


    const theme = createTheme({
        palette: {
            primary: {
              main: '#64748B',
            },
           neutral: {
             main: '#64748B',
             contrastText: '#fff',
           },
         },
       });
    /*backgroundImage: "url(/BACK.png)"*/   /*style={{   height: "599px",
          width: "900px",
           marginLeft:"20%"}}*/

           const [date, setDate] = React.useState(Date.now());
    const [values, setValues] = useState("");
    const [currValue, setCurrValue] = useState("");
    const [successful, setSuccessful] = useState(false);
    const handleChange = (event,child) => {

       console.log("hahyaa tbkhdekqgfqgg hhhhhhhhhhhhhhhhhhhhhhhhhhhhhh")
        setValues(event.target.value);
        console.log(event.target.value);
    };


    const handleSubmit = (event) => {
     console.log("addex");
      addexp(event,setSuccessful,values);
    };
 

    let [courses, setCourses] = useState({data: []});
    useEffect(() => {
       console.log("ana dkhlt")
            if (courses.data.length===0)
                getcategories(setCourses);
        
    }, []);


 return (
    <ThemeProvider theme={theme}>
      <Box      noValidate  component="form" onSubmit={handleSubmit} > 
     <div className='back' style={{   height: "665px",
          width: "1000px",
           marginLeft:"20%",marginBottom:"20%"}}>
<Grid container >

         <Grid item xs={12} sm={6} container >
         <Grid item xs={2} ></Grid>
         <Grid item xs={10} >
  
          <TextField
                margin="normal"
                color="primary"
                required
                fullWidth
                name="title"
                label="give your experience a title"
                type="String"
                id="title"
                 color="primary"
                style={{ marginBottom:"50px", marginTop:"50px"}}
            
            />


<FormControl fullWidth>
  <InputLabel id="Categoryall"  ></InputLabel>

  <Select
          labelId="category"
          id="category"
          value={values}
          label={values ? "category" : ""} //This tells Select to have gap in border
          onChange={handleChange}
          displayEmpty
          renderValue={(value) => value ? value : <em>category</em>}
          MenuProps={{
            PaperProps: {sx: {left: `${position}px !important`}}
            
          }}
          style={{ marginBottom:"50px", marginTop:"30px"}}
        >

  {courses.data.map((card) => {
   console.log(card);
    return  <MenuItem value={card.name} name={card.name}>{card.name}</MenuItem>
  }
   ) }

  </Select>
</FormControl>

<TextField
                                id="date"
                                name="date"
                                label="date "
                                type="date"
                                defaultValue="2000-05-24"
                                fullWidth
                                InputLabelProps={{
                                    shrink: true,
                                }}
                                
                style={{ marginBottom:"50px"}}
                            />
              <div>Insert a descriptif image</div>
                                <input class="form-control" type="file" id="image" name="image"
                                       accept="image/*,application/pdf"/>
            </Grid>     
          
             </Grid>
      
            
             <Grid item container xs={6}>  
             <Grid item xs={1}>   </Grid>
             <Grid item xs={9}>  
               <TextField
                margin="normal"
                color="primary"
                required
                fullWidth
                name="description"
                label="write your experience"
                type="String"
                id="description"
               
                multiline
  rows={15}
  maxRows={10}
                style={{ marginBottom:"50px"
                , marginTop:"50px",height: 38 
           }}
            
            /></Grid>
             <Grid item xs={2}>   </Grid>

            </Grid>
            
         
          
         
  </Grid>
  <Button      type="submit"  style={{color:"white"
      , marginTop:"10%",height: 50 
      ,marginLeft:"30%",width:"30%"}}
       className="button" 
      >Add my Experience</Button>

 

  </div>
  </Box>
  </ThemeProvider>
  );
        }
        export default AddExpForm; //<AddExpButton fct={handleSubmit}/>