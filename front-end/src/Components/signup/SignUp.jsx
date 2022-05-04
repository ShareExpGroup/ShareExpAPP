import React, {useState, Component} from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Paper from '@mui/material/Paper';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import image from "../../images/logo.png"
import {signUpService} from "../../service/signing";
import axios from "axios";
import {goto} from "../../service/utils";
function Copyright(props: any) {
  return (
    <Typography variant="body2" color="text.secondary" align="center" {...props}>
      {'Copyright © '}
      <Link color="inherit" href="http://localhost:3000/">
       SHAREexp
      </Link>{' '}
      {new Date().getFullYear()}
      {'.'}
    </Typography>
  );
}

const theme = createTheme();

export default function SignUp() {
  const [successful, setSuccessful] = useState(false);
    const [value, setValue] = useState("");
    const [isCoach, setIsCoach] = useState(false);
    const handleChange = e => {
        setValue(e.target.value);
        if (e.target.value == "coach")
            setIsCoach(true);
        else setIsCoach(false);
    };

    const handleSubmit = (event) => {
        signUpService(event,setSuccessful);
    };


  return (
    <ThemeProvider theme={theme} style={{backgroundColor:"rgba(17, 24, 39, 1)"}}>
      <Grid container component="main" sx={{ height: '100vh' }} >
        <CssBaseline />
        <Grid className="test" style={{backgroundColor:"rgba(17, 24, 39, 1)"}}
          item
          xs={false}
          sm={4}
          md={6}
         >  <img src={image} alt="smile"   style={{marginTop:"20%" ,marginLeft:"10%"}}/></Grid>
        
        <Grid item xs={12} sm={12} md={6} component={Paper} elevation={6} square style={{backgroundColor:"white" }} >
          <Box
          style={{backgroundColor:"white"}}
            sx={{
              my: 8,
              mx: 4,
              display: 'flex',
              flexDirection: 'column',
              alignItems: 'center',
            }}
          >
            <Avatar sx={{ m: 1, bgcolor: 'rgba(175, 81, 197, 1)' }}>
          
            </Avatar>
            <Typography component="h1" variant="h5" >
              Sign Up
            </Typography>
            <Box component="form"   style={{width:"369.73px"}}  
            noValidate onSubmit={handleSubmit} >

<TextField
                margin="normal"
                color="secondary"
                required
                fullWidth
                name="firstName"
                label="First Name"
                type="string"
                id="firstName"
               
                style={{backgroundColor:"white" ,color:"red"}}
                
              />
                 <TextField
                margin="normal"
                color="secondary"
                required
                fullWidth
                name="lastName"
                label="last Name "
                type="String"
                id="lastName"
                
                style={{backgroundColor:"white" ,color:"red"}}
                
              />
              <TextField
                margin="normal"
                required
                fullWidth
                id="email"
                label="Email Address"
                name="email"
                autoComplete="email"
                autoFocus
                style={{backgroundColor:"white"}}
                color="secondary"
               
              />

            
                 <TextField
                                id="date"
                                name="date"
                                label="date de naissance"
                                type="date"
                                defaultValue="2000-05-24"
                                style={{width:"100%"}}
                                sx={{ width: 220 }}
                                InputLabelProps={{
                                    shrink: true,
                                }}
                            />
              <TextField
                margin="normal"
                color="secondary"
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
                autoComplete="current-password"
                style={{backgroundColor:"white" ,color:"red"}}
                
              />
              
              <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
               style={{backgroundColor:"rgba(175, 81, 197, 1)"}}
              >
                Sign Up              </Button>
              <Grid container>
                <Grid item xs>
                  <Link href="/" variant="body2" onSubmit={handleSubmit} >
                    SignIn
                  </Link>
                </Grid>
                
              </Grid>
              
              <Copyright sx={{ mt: 5 }} />
            </Box>
            {successful && (
        <Box mt={5}>
            <div
                style={{
                    padding: "10px",
                    marginBottom: "-20px",
                    borderRadius: "3px 3px 3px 3px",
                    color: "#270",
                    backgroundColor: "#DFF2BF",
                }}
            >
                Succès
            </div>
        </Box>
    )}

          </Box>
        </Grid>
      </Grid>
    </ThemeProvider>
  );
}