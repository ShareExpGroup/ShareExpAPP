import axios from "axios";
import {goto} from "./utils";

export function addexp(event, setSuccessful) {
  
    event.preventDefault();
    const tempData = new FormData(event.currentTarget);
    for (let i of tempData.entries())
        console.log(i);
    let data =  new FormData();
  
    data.append('title', tempData.get('title'));
    data.append('like', "4");
    data.append('description', tempData.get('description'));
    data.append('image', tempData.get('image'));
    console.log( tempData.get('description'))
    console.log(  tempData.get('title'))
    console.log( tempData.get('image'))
    console.log(  tempData.get('like'))

    console.log(data);
/*   private final String title;
    private final int like;
    private final String description;
    MultipartFile image;*/

    axios.post(`http://localhost:8080/api/exp/add`, data
      
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
        , {
            headers: {
                "Authorization": `${localStorage.getItem("currentUser")}`
            }
        }
    ).then(
        async (res) => {

            console.log("res");
            console.log(res.data);
            setExperiences({data: res.data});

        }
        ,
        (err) => {
            alert("erreur lors de l'acces à vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );
}
