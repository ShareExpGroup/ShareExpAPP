import axios from "axios";
import { useState } from "react";
import {goto} from "./utils";


export function addcomment(event, setSuccessful,title) {

      event.preventDefault();
      const tempData = new FormData(event.currentTarget);
      for (let i of tempData.entries())
          console.log(i);
      let data =  new FormData();
      data.append('experience',title);
      data.append('content', tempData.get('content'));
    
    
      
      
      ;
      console.log("hado les valeurs")
      console.log( tempData.get('title'))
      console.log(  tempData.get('content'))
     
      console.log("*******************");
  
      console.log(data);
  /*   private final String title;
      private final int like;
      private final String description;
      MultipartFile image;*/
      console.log("the current user")
  
      console.log(localStorage.getItem("currentUser"))
  
      axios.post(`http://localhost:8080/api/comment/create`, data
      , {
        headers: {
            "Authorization": `${localStorage.getItem("currentUser")}`
        }} 
      ).then(
          (res) => {
            console.log("hado homa");
              setSuccessful(true);
              console.log(res);
              console.log(data);

              goto("/");
          }
          ,
          (err) => {
              alert(err.response.data.error + "\nerreur lors de l'ajout de l'offre, veuillez reentrer vos données, en cas de besoin contacter l'admin\n" );
              console.error(err);
          }
      );  }   
      
      export function getComments(id, setExperience){

        console.log("rak dkhlti lgetcomments")
        console.log("id :  ",id);
        axios.get(`http://localhost:8080/api/comment/${id}`
        ).then(
            async (res) => {
                setExperience({data: res.data});
                console.log(res.data);
                console.log(res.data.shareExpClientDto)
            }
            ,
            (err) => {
                alert("erreur lors du demande des ressources, en cas de besoin contacter l'admin");
                console.error(err);
            }
        );
    }
  