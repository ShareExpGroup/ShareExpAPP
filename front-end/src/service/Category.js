import axios from "axios";
import {goto} from "./utils";

export function addcateg(event, setSuccessful) {
  
    event.preventDefault();
    const tempData = new FormData(event.currentTarget);
    for (let i of tempData.entries())
        console.log(i);
    let data =  new FormData();
  
    data.append('name', tempData.get('name'));
 
    data.append('image', tempData.get('image'));
    console.log( tempData.get('name'))
  
    console.log( tempData.get('image'))
   

    console.log(data);

    console.log("the current user")

    console.log(localStorage.getItem("currentUser"))

    axios.post(`http://localhost:8080/api/categ/add`, data
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
    

export function getcategories(setCategories){
    axios.get(`http://localhost:8080/api/categ/all`
).then(
        async (res) => {

            console.log("res");
            console.log(res);
            setCategories({data: res.data});

            
        }
        ,
        (err) => {
            alert("erreur lors de l'acces à vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );
}