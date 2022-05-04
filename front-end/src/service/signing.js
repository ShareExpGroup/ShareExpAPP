import axios from "axios";
import {goto} from "./utils";

const signUpService = (event,setSuccessful) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    createClient(data,setSuccessful);
}
const createClient = (data,setSuccessful) => {
    console.log("data");
    const dataToSend = {
        firstName: data.get('firstName'),
        lastName: data.get('lastName'),
        email: data.get('email'),
        password: data.get('password'),
        birth_date : data.get("date")
    }
    console.log("data");
    console.log(dataToSend);
    axios.post(`http://localhost:8080/api/account/create/client`, dataToSend, {
        headers: {
            'Content-Type': 'application/json',
      
           
        }
    }).then(
        (res) => {

            setSuccessful(true);
            console.log(res);
            goto("/signin");
        }
        ,
        (err) => {
            alert("erreur lors de l'authentification, veuillez reentrer vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );

};



export {signUpService};