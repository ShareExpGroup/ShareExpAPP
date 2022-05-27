import axios from "axios";
import { useState } from "react";
import {goto} from "./utils";

export function addcomment(event, setSuccessful, experience) {
  
    event.preventDefault();
    const tempData = new FormData(event.currentTarget);
    for (let i of tempData.entries())
        console.log(i);
    let data =  new FormData();
  
    data.append('content', tempData.get('content'));
    data.append('experience', experience);
 

    console.log( tempData.get('content'))
    console.log(experience)
  
   

    console.log(data);

    console.log("the current user")

    console.log(localStorage.getItem("currentUser"))

    axios.post(`http://localhost:8080/api/comment/create`, data
    , {
        headers: {
            "Authorization": `${localStorage.getItem("currentUser")}`
        }} 
    
         
    ).then(
        (res) => {

            setSuccessful(true);
            console.log(res);
            goto("/");
        }
        ,
        (err) => {
            alert(err.response.data.error + "\nerreur lors de l'ajout de l'offre, veuillez reentrer vos données, en cas de besoin contacter l'admin\n" );
            console.error(err);
        }
    );
}