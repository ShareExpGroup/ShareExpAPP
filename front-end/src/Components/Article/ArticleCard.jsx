import React from 'react';
import '../../style/ArticleCard.css'
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import ChatBubbleOutlineIcon from '@mui/icons-material/ChatBubbleOutline';
import FacebookIcon from '@mui/icons-material/Facebook';
import TwitterIcon from '@mui/icons-material/Twitter';
import LinkedInIcon from '@mui/icons-material/LinkedIn';

const ArticleCard = ({article}) => {
    return (
        <div className='card'>
            <div className='card_hero'>
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIyjuxRxTy14Ea7S8F94Heq5xByHw3QS7N_A&usqp=CAU" alt="" className='card_img'/>
            </div>
            <div className='card_content'>
                <div className='card_header'>
                    <FavoriteBorderIcon style={{ fontSize: 20 }}/>
                    <span id='like'>{article.likes} Likes</span>
                    <ChatBubbleOutlineIcon className='comments' style={{ fontSize: 20 }}/>
                    <span id='comment'>{article.comments} comments</span>
                    <div className='social_media'>
                    <FacebookIcon style={{ fontSize: 26 , color: '#AF51C5'}} className='media_item'/>
                    <TwitterIcon style={{ fontSize: 26 , color: '#AF51C5'}} className='media_item'/>
                    <LinkedInIcon style={{ fontSize: 26 , color: '#AF51C5'}} className='media_item'/>
                    </div>
                    
                </div>
                <div className='card_desc'>{article.description}</div>
            </div>
        </div>
    );
};

export default ArticleCard;