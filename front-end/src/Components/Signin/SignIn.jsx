import * as React from 'react';
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
import axios from "axios";
import {useState} from "react";
import {goto} from "../../service/utils";

function getRole(key) {
    return key.substring(1, key.length - 1);
}

function getJWT(value) {
    return value.authorization;
}

function extractRoleAndJWT(data) {
    let tempRole = undefined;
    let tempAuth = undefined;
    Object.entries(data).forEach(([key, value]) => {
        tempRole = getRole(key);
        tempAuth = getJWT(value);
        return;
    });
    return [tempRole, tempAuth];
}
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

export default function SignIn() {
  const [successful, setSuccessful] = useState(false);

  const handleSubmit = (event) => {

    event.preventDefault();
    // alert(event.currentTarget)
    console.log(event.currentTarget)
    const data = new FormData(event.currentTarget);
    // eslint-disable-next-line no-console
    console.log({
        email: data.get('email'),
        password: data.get('password'),
    });
    const dataToSend = {
        email: data.get('email'),
        password: data.get('password')

    }

    axios.post(`http://localhost:8080/login`, dataToSend, {
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': "*"
        }
    }).then(
        (res) => {
            let resData = extractRoleAndJWT(res.data);
            localStorage.setItem("currentUser", resData[1]);
           if (resData[0] === "ROLE_CLIENT") {
                localStorage.setItem("isshaereExpuser", "true");
            } else if (resData[0] === "ROLE_SUPERUSER") {
                localStorage.setItem("isAdmin", "true");
            }

            setSuccessful(true);
            console.log(resData);
            console.log(localStorage);
            goto("/");
        }
        ,
        (err) => {
            alert("erreur lors de l'authentification, veuillez reentrer vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );

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
              Sign in
            </Typography>
            <Box component="form"   style={{width:"369.73px"}}  
            noValidate onSubmit={handleSubmit} >
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
              <FormControlLabel
                control={<Checkbox value="remember" color="primary" />}
                label="Remember me"
              />
              <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
               style={{backgroundColor:"rgba(175, 81, 197, 1)"}}
               onSubmit={handleSubmit}
              >
                Sign In
              </Button>
              <Grid container>
                <Grid item xs>
                  <Link href="#" variant="body2">
                    Forgot password?
                  </Link>
                </Grid>
                <Grid item>
                  <Link href="/signup" variant="body2">
                    {"Don't have an account? Sign Up"}
                  </Link>
                </Grid>
              </Grid>
              <Copyright sx={{ mt: 5 }} />
            </Box>
          </Box>
        </Grid>
      </Grid>
    </ThemeProvider>
  );
}