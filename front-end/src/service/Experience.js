import axios from "axios";
import {goto} from "./utils";

export function addexp(event, setSuccessful) {
  console.log("hanadkhlt")
    event.preventDefault();
    const tempData = new FormData(event.currentTarget);
    for (let i of tempData.entries())
        console.log(i);
    let data =  new FormData();
   
    data.append('title', tempData.get('title'));
    data.append('like', 4);
    data.append('description', tempData.get('description'));
    data.append('image', tempData.get('image'));
    console.log("hado les valeurs")
    console.log( tempData.get('description'))
    console.log(  tempData.get('title'))
    console.log( tempData.get('image'))
    console.log(  tempData.get('like'))
    
    console.log("*******************");

    console.log(data);
/*   private final String title;
    private final int like;
    private final String description;
    MultipartFile image;*/
    console.log("the current user")

    console.log(localStorage.getItem("currentUser"))

    axios.post(`http://localhost:8080/api/exp/add`, data
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

 
export function getPopularExperiences( setExperiences){//
    axios.get(`http://localhost:8080/api/exp/Popular`
    ).then(
        async (res) => {

            console.log("res");
            console.log(res);
            setExperiences({data: res.data});

        }
        ,
        (err) => {
            alert("erreur lors de l'acces à vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );
}

export function getExperienceById(id, setExperience){//
    console.log("id :  ",id);
    axios.get(`http://localhost:8080/api/exp/${id}`
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