import React from 'react';
import Grid from '@mui/material/Grid';

import Card from '@mui/material/Card'
import '../../style/Body_dash.css'
import HorizontalScroll from 'react-scroll-horizontal';
import { Link } from '@mui/material';
import { CardActionArea, CardActions, CardContent, CardMedia, Typography } from '@mui/material';
import {useEffect, useState} from "react";
import {getcategories} from "../../service/Category"
import {getExperienceBycategory} from "../../service/Experience"
import     TextButton from "../usedComponents/TextButton"
import Header from "../Home/header/Header"
function ListeExperience(props){
    let [experiences, setExperiences] = useState({data: []});
    useEffect(() => {
       console.log("ana dkhlt")
           
            if (experiences.data.length===0)
            getExperienceBycategory(window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1), setExperiences);
        
    }, []);
   
    return(
        <div>
            <Header/>
            <Grid container  style={{marginTop:"2%"}}>
         
{
experiences.data.map((experience) =>(
   
    <Grid item xs={4}>
    <Card sx={{ maxWidth: 345 }} style={{
        backgroundColor: "black", 
        color: "white",
        height: "auto",
        width: "400px",
        marginTop:"10%",
        marginLeft:'10%',
        flex: "none"

        }}>
        <CardActionArea href={"/ListeExperience/"+ window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1)}>
            <CardMedia 
            component="img"
            height="150"
            image={"http://localhost:8080/api/document/" + experience.image}
            alt="green iguana"
            />
            <CardContent>
            <Typography gutterBottom variant="h4" component="div" style={{color: "#2563EB"}}>
                {experience.title}
            </Typography>
            <Typography variant="body2">
                {experience.description}
            </Typography>
            < TextButton value="details" url={"http://localhost:3000/experience/"+experience.id}/>
            </CardContent>
        </CardActionArea>
        <CardActions>
        <Typography gutterBottom variant="h10" component="div" style={{
                color: "#ABB5BE",
                fontSize: "13px"
            }}>
                {experience.creationDate}
            </Typography>
        </CardActions>
    </Card>
    </Grid>   
))

}

</Grid>
</div>
)

}
export default ListeExperience;