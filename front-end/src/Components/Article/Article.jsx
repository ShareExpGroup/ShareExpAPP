import { width } from '@mui/system';
import React, {useEffect, useState} from 'react';
import Header from '../Home/header/Header';
import ArticleCard from './ArticleCard';
import '../../style/ArticleCard.css'
import { Button } from '@mui/material';
import CommentCard from '../Comment/CommentCard';
import { getExperienceById } from '../../service/Experience';
import { addcomment } from '../../service/Comment';


const Article = () => {
    let [experience, setExperience] = useState({data : ""});
    
    
    useEffect(() => {
        return () => {
            if (experience.data === "")
                getExperienceById( window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1), setExperience);
    
        };
    },[experience.data]);

    const [values, setValues] = useState([]);
    const [currValue, setCurrValue] = useState("");
    const [successful, setSuccessful] = useState(false);
    
    const handleSubmit = (event) => {
     console.log("addex");
      addcomment(event,setSuccessful, experience.data);
    };
 
    
    

    
    

    const comments = [
        {
          username: "Michel Michel", 
          text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean luctus ut est sed faucibus. Duis bibendum ac ex vehicula laoreet. Suspendisse congue vulputate lobortis.",
          date: "1 minute" 
        }
        ,
        {
            username: "abcd", 
            text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean luctus ut est sed faucibus. Duis bibendum ac ex vehicula laoreet. Suspendisse congue vulputate lobortis.",
            date: "2 minutes" 
        }
    ]
    
    return (
        <div>
            <Header/>
            <div style={{width: "900px", margin:"auto"}}>
            <h2 style={{color: "#2563EB", fontSize: "28px"}}>{experience.data.title}</h2>
            <h6 style={{color: "#ABB5BE"}}>By Amina Chaabane | {experience.data.creationDate}</h6>
            </div>
            <ArticleCard experience={experience.data}/>
            <p style={{
                width: "900px", margin:"auto", marginTop: "30px", 
                color: "white", fontWeight: "300", fontSize: "22px",
                lineHeight: "40px", marginBottom: "30px",
                paddingBottom: "30px",
                borderBottom: "1px solid #AF51C5"
                }}>{experience.data.description}</p>
            <h5 style={{color: "#2563EB", fontWeight: 500, fontSize: "27px", width: "900px", margin:"auto", marginBottom: "30px"}}>Comments</h5>
            <form action="" className='form_comment' onSubmit={handleSubmit}>
                <input id="username" type="text" placeholder='username...' name='username' style={{
                    background: "black", color: "white", border: "1px solid rgba(0, 0, 0, 0.5)",
                    }} onChange={handleSubmit}/>
                <input id="input_comment" type="text" placeholder='your comment...' name='content' style={{
                    background: "black", color: "white", border: "1px solid rgba(0, 0, 0, 0.5)",
                    }} onChange={handleSubmit}/>
                <Button  style={{color :"white", width: "133px", height: "40px", marginLeft: "50px"}} className="button" type='submit'>Comment</Button>
            </form>
            {comments.map((comment) => (
                <CommentCard comment={comment}/>
            ))}
            
        </div>
    );
};

export default Article;