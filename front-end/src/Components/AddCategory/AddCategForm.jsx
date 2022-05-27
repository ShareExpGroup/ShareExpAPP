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
import {addcateg} from "../../service/Category"
function AddCategForm(){
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
    const [values, setValues] = useState([]);
    const [currValue, setCurrValue] = useState("");
    const [successful, setSuccessful] = useState(false);
    const handleChange = (newValue) => {
        setDate(newValue);
    };
    const handleSubmit = (event) => {
     console.log("addex");
      addcateg(event,setSuccessful);
    };
    const handleKeyUp = (e) => {
        console.log(e.keyCode);
        if (e.keyCode == 32) {
            setValues((oldState) => [...oldState, e.target.value]);
            setCurrValue("");
        }
    };

    useEffect(() => {
        console.log(values);
    }, [values]);

    const handleChangee = (e) => {
        setCurrValue(e.target.value);
    };

    const handleDelete = ( item, index) =>{
        let arr = [...values]
        arr.splice(index,1)
        console.log(item)
        setValues(arr)
    }

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
                name="name"
                label="give the new category"
                type="String"
                id="name"
                
                style={{ marginBottom:"50px", marginTop:"50px"}}
            
            />



              <div>Insert a descriptif image</div>
                                <input class="form-control" type="file" id="image" name="image"
                                       accept="image/*,application/pdf"/>
            </Grid>     
          
             </Grid>
      
            
         
          
         
  </Grid>
  <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
               style={{backgroundColor:"rgba(175, 81, 197, 1)"}}
             
              >
                test
              </Button>

  </div>
  </Box>
  </ThemeProvider>
  );
        }
        export default AddCategForm; //<AddExpButton fct={handleSubmit}/>