import axios from "axios";
import {goto} from "./utils";

export function getCoachData(setReceived, setFullName, setImage, setEmail, setSpeciality){
    axios.get(`http://localhost:8000/api/coach/me`
        , {
            headers: {
                "Authorization": `${localStorage.getItem("currentUser")}`
            }
        }
    ).then(
        (res) => {
            setReceived(true);
            setFullName(res.data.firstName + " " + res.data.lastName);
            setImage(res.data.image);
            setEmail(res.data.email);
            setSpeciality(res.data.speciality);
            console.log("res");
            console.log(res.data);
            // alert("hh");
            // goto("/this_link_is_not_yet_defined");
        }
        ,
        (err) => {
            alert("erreur lors de l'acces à vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );
}

export function getAllCoaches(setCoaches, createData, setSuccess){
    // alert("hh")
    console.log("hello")
    axios.get(`http://localhost:8080/api/superuser/listNotVerified`
        , {
            headers: {
                "Authorization": `${localStorage.getItem("currentUser")}`
            }
        }
    ).then(
        (res) => {
            let temp = [];
            for (let i of res.data){
                temp.push(
                    createData(
                        i.firstName,
                      i.lastName,
                        i.email
                    )
                );
            }
            setCoaches(temp);
            setSuccess(true);
            console.log("hado les données")
            console.log(res.data.firstName);
           
        }
        ,
        (err) => {
            alert("erreur lors de l'acces à vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );
}
export function verifyCoach(email){
    axios.delete(`http://localhost:8080/api/account/delete/ByEmail`
        , {
            headers: {
                "Authorization": `${localStorage.getItem("currentUser")}`,
                "email": email
            }
        }
    ).then(
        (res) => {
            window.location.reload();
        }
        ,
        (err) => {
            alert("veuillez contacter les dévellopeurs");
            console.error(err);
        }
    );
}
export function getId(){
    axios.get(`http://localhost:8000/api/superuser/me`
        , {
            headers: {
                "Authorization": `${localStorage.getItem("currentUser")}`
            }
        }
    ).then(
        (res) => {
            goto(`/NewPassword/${res.data.id}`);
        }
        ,
        (err) => {
            alert(err.response.data.error + "\nveuillez contacter les dévellopeurs");
            console.error(err.response.data);

        }
    );
}