import React from 'react';
import Grid from '@mui/material/Grid';
import Start from './Start';
import Card from '@mui/material/Card'
import '../../style/Body_dash.css'
import HorizontalScroll from 'react-scroll-horizontal';
import { CardActionArea, CardActions, CardContent, CardMedia, Typography } from '@mui/material';

const Body_dash = () => {
    const categories = [{
            name: "Category1",
            image: "https://kharkiv-travel.com/wp-content/uploads/2021/12/Travel000000.jpg"
        },
        {
            name: "Category2",
            image: "https://media.istockphoto.com/photos/colored-powder-explosion-on-black-background-picture-id1140180560?k=20&m=1140180560&s=612x612&w=0&h=X_400OQDFQGqccORnKt2PHYvTZ3dBLeEnCH_hRiUQrY="
        },
        {
            name: "Category3",
            image: "https://static.fnac-static.com/multimedia/Images/FD/Comete/114332/CCP_IMG_ORIGINAL/1481839.jpg"
        },
        {
            name: "Category4",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRa1pNzfnQgeABOdREljz2rAoIwly9tG9JOxQ&usqp=CAU"
        }
    ]
    const articles = [
        {
            title: "title1",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIyjuxRxTy14Ea7S8F94Heq5xByHw3QS7N_A&usqp=CAU",
            description: "This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer. This is a wider card with supporting text below as a natural lead-in to additional content.",
            date: "December 2, 2018"
        },
        {
            title: "title2",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIyjuxRxTy14Ea7S8F94Heq5xByHw3QS7N_A&usqp=CAU",
            description: "This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.This is a wider card with supporting text below as a natural lead-in to additional content",
            date: "January 25, 2020"
        },
        {
            title: "title3",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIyjuxRxTy14Ea7S8F94Heq5xByHw3QS7N_A&usqp=CAU",
            description: "This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.This is a wider card with supporting text below as a natural lead-in to additional content.",
            date: "April 15, 2016"
        },
        {
            title: "title4",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIyjuxRxTy14Ea7S8F94Heq5xByHw3QS7N_A&usqp=CAU",
            description: "This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.This is a wider card with supporting text below as a natural lead-in to additional content.",
            date: "February 19, 2020"
        }
        
    ]
    return (
        <Grid
            container
            direction="row"
            marginLeft="10%"
            marginTop="6%">
            <Grid item xs={12}>
            <p style={{
                fontFamily: 'Fira Sans Condensed',
                fontStyle: "normal",
                fontWeight: "800",
                fontSize: "70px",
                color: "#2563EB"
            }}>Welcome to ShareExp!</p>
            
            
        <p style={{
                fontFamily: 'Fira Sans Condensed',
                fontStyle: "normal",
                fontWeight: "20",
                fontSize: "25px",
                color: "white"
            }}>Do you have an inspiring experience or an exciting story ? share it now with us  from here! </p>
            <Start/>
            </Grid>
            <Grid item xs={10}>
                <h1 className='categories' style={{
                    fontFamily: 'Fira Sans Condensed',
                    color: "#AF51C5",
                    marginTop: "15%"
                }}>Categories</h1>
              <HorizontalScroll>
                  {categories.map((category) => (
                       
                        <div className="category_card">
                            <div>{category.name}</div>
                            <img src={category.image} alt={category.name} style={{
                                width: "300px",
                                height: "200px",
                                margin: "40px",
                                cursor: "pointer",
                            }}/>
                            
                        </div>
                        
                  ))}
               
            </HorizontalScroll>     
            </Grid>
            <Grid item xs={10}>
                <h1 className='articles' style={{
                    fontFamily: 'Fira Sans Condensed',
                    color: "#AF51C5",
                    marginTop: "30%"
                }}>Popular Articles</h1>
                <HorizontalScroll>
                    {articles.map((article) =>(
                        <Card sx={{ maxWidth: 345 }} style={{
                            backgroundColor: "black", 
                            color: "white",
                            height: "auto",
                            width: "400px",
                            margin: "1%",
                            flex: "none"

                            }}>
                            <CardActionArea>
                                <CardMedia 
                                component="img"
                                height="150"
                                image={article.image}
                                alt="green iguana"
                                />
                                <CardContent>
                                <Typography gutterBottom variant="h4" component="div" style={{color: "#2563EB"}}>
                                    {article.title}
                                </Typography>
                                <Typography variant="body2">
                                    {article.description}
                                </Typography>
                                </CardContent>
                            </CardActionArea>
                            <CardActions>
                            <Typography gutterBottom variant="h10" component="div" style={{
                                    color: "#ABB5BE",
                                    fontSize: "13px"
                                }}>
                                    {article.date}
                                </Typography>
                            </CardActions>
                        </Card>
                    ))}
                </HorizontalScroll>
            </Grid>
            
        </Grid>
    );
};

export default Body_dash;