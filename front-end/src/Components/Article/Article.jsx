import { width } from '@mui/system';
import React from 'react';
import Header from '../Home/header/Header';
import ArticleCard from './ArticleCard';
import '../../style/ArticleCard.css'
import { Button } from '@mui/material';


const Article = () => {
    const article = {
        title: "The More Important the Work, the More Important the Rest",
        author: "Jenny Wilson ",
        date: "December 2, 2018",
        likes: "33",
        comments: "10",
        description: "Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. Velit officia consequat duis enim velit mollit. Exercitation veniam consequat sunt nostrud amet. Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. Velit officia consequat duis enim velit mollit. Exercitation veniam consequat sunt nostrud amet. ",
        content: "Nulla Lorem mollit cupidatat irure. Laborum magna nulla duis ullamco cillum dolor. Voluptate exercitation incididunt aliquip deserunt reprehenderit elit laborum, nulla Lorem mollit cupidatat irure. Laborum magna nulla duis ullamco cillum dolor. Voluptate exercitation incididunt aliquip deserunt reprehenderit elit laborum. Nulla Lorem mollit cupidatat irure. Laborum magna nulla duis ullamco cillum dolor. Voluptate exercitation incididunt aliquip deserunt reprehenderit elit laborum."
                  + "Nulla Lorem mollit cupidatat irure. Laborum magna nulla duis ullamco cillum dolor. Voluptate exercitation incididunt aliquip deserunt reprehenderit elit laborum, nulla Lorem mollit cupidatat irure. Laborum magna nulla duis ullamco cillum dolor. Voluptate exercitation incididunt aliquip deserunt reprehenderit elit laborum. Nulla Lorem mollit cupidatat irure. Laborum magna nulla duis ullamco cillum dolor. Voluptate exercitation incididunt aliquip deserunt reprehenderit elit laborum"
    }
    
    return (
        <div>
            <Header/>
            <div style={{width: "900px", margin:"auto"}}>
            <h2 style={{color: "#2563EB", fontSize: "28px"}}>{article.title}</h2>
            <h6 style={{color: "#ABB5BE"}}>By {article.author} | {article.date}</h6>
            </div>
            <ArticleCard article={article}/>
            <p style={{
                width: "900px", margin:"auto", marginTop: "30px", 
                color: "white", fontWeight: "300", fontSize: "22px",
                lineHeight: "40px", marginBottom: "30px",
                paddingBottom: "30px",
                borderBottom: "1px solid #AF51C5"
                }}>{article.content}</p>
            <h5 style={{color: "#2563EB", fontWeight: 500, fontSize: "27px", width: "900px", margin:"auto", marginBottom: "30px"}}>Comments</h5>
            <form action="" className='form_comment'>
                <input id="username" type="text" placeholder='username...' style={{
                    background: "black", color: "white", border: "1px solid rgba(0, 0, 0, 0.5)",
                    }}/>
                <input id="input_comment" type="text" placeholder='your comment...' style={{
                    background: "black", color: "white", border: "1px solid rgba(0, 0, 0, 0.5)",
                    }}/>
                <Button  style={{color :"white", width: "133px", height: "40px", marginLeft: "50px"}} className="button" href="/signup">Comment</Button>
            </form>
            
        </div>
    );
};

export default Article;