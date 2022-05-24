import axios from "axios";
import {goto} from "./utils";

export function addexp(event, setSuccessful) {
    console.log("raah daazt")
    event.preventDefault();
    const tempData = new FormData(event.currentTarget);
    for (let i of tempData.entries())
        console.log(i);
    let data =  new FormData();

    console.log("data");
    console.log(data);
    data.append('title', tempData.get('title'));
    data.append('like', 4);
    data.append('description', tempData.get('description'));
    data.append('image', tempData.get('image'));
    console.log({
        title: tempData.get('title'),
        description: tempData.get('description'),
        img: tempData.get('image'),
        like: tempData.get('like'),
    });


    axios.post(`http://localhost:8000/api/exp/add`, data
        , {
            headers: {
                "Authorization": `${localStorage.getItem("currentUser")}`
            }
        }
    ).then(
        (res) => {

            setSuccessful(true);
            
            goto("/");
        }
        ,
        (err) => {
            alert(err.response.data.error + "\nerreur lors de l'ajout de l'offre, veuillez reentrer vos données, en cas de besoin contacter l'admin\n" );
            console.error(err);
        }
    );
}
    
