import { width } from '@mui/system';
import React, {useEffect, useState} from 'react';
import Header from '../Home/header/Header';
import ArticleCard from './ArticleCard';
import '../../style/ArticleCard.css'
import { Button } from '@mui/material';
import CommentCard from '../Comment/CommentCard';
import { getExperienceById } from '../../service/Experience';
import { addcomment,getComments } from '../../service/Comment';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';


const Article = (props) => {
    const [val, setVal] = useState("");
    let [experience, setExperience] = useState({data : ""});
  
    useEffect(() => {
        return () => {
            if (experience.data === "")
            getExperienceById( window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1), setExperience,setVal);
      
            if (props.test=== "fromcategory")
            getExperienceById(props.test,setExperience,setVal) 
            
     
        
    
        };

    },[]);

    useEffect(() => {
        console.log("ana dkhlt luse effect")
         return () => {
             getComments(window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1) , setComment)
         
     
         };
 
     },[]);

    const [values, setValues] = useState([]);
    const [currValue, setCurrValue] = useState("");
    const [successful, setSuccessful] = useState(false);
    
    const handleSubmit = (event) => {
console.log("knsubmittze")
      addcomment(event,setSuccessful,  window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1) );
      console.log(experience.data.title)
    };
 
    
    
    const [comment,setComment] =  useState({data : []});
    
 


    
    return (
        <div>
            <Header/>
            <div style={{width: "900px", margin:"auto"}}>
            <h2 style={{color: "#2563EB", fontSize: "28px"}}>{experience.data.title}</h2>
            <h6 style={{color: "#ABB5BE"}}>By {val} | {experience.data.creationDate}</h6>
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
            
            <form action="post" className='form_comment' onSubmit={handleSubmit}>
             
                <input id="content" type="text" placeholder='your comment...' name='content' style={{
                    background: "black", color: "white", border: "1px solid rgba(0, 0, 0, 0.5)",
                    }} onChange={handleSubmit}/>
                <Button  style={{color :"white", width: "133px", height: "40px", marginLeft: "50px"}} className="button" type='submit'>Comment</Button>
            </form>
            {comment.data.map((com) => (
                <CommentCard                  username={val}  text={com.content}
                />
            ))}
            
        </div>
    );
};

export default Article; /*<input id="content" type="text" placeholder='your comment...' name='content' style={{  width: "500px",height:"50px",
                    background: "black", color: "white", border: "1px solid rgba(0, 0, 0, 0.5)",
                    }}/>*/