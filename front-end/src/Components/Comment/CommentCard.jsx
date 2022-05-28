import React from 'react';
import { Divider, Avatar, Grid, Paper } from "@mui/material";

const imgLink =
  "https://images.pexels.com/photos/1681010/pexels-photo-1681010.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260";

const CommentCard = (props) => {
    return (
        <div>
        <Paper style={{ padding: "40px 20px" ,marginLeft:"17%",marginRight:"22%", marginBottom: "10px", backgroundColor: "black"}}>
        
        <Grid container wrap="nowrap" spacing={2}>
          <Grid item>
           
          </Grid>
          <Grid justifyContent="left" item xs zeroMinWidth style={{color: "white"}}>
            <h4 style={{ margin: 0, textAlign: "left" }}>{props.username}</h4>
            <p style={{ textAlign: "left" }}>
              {props.text}{" "}
            </p>
            <p style={{ textAlign: "left", color: "gray" }}>
              posted {props.date} ago
            </p>
          </Grid>
        </Grid>
        
      </Paper>
        </div>
    );
};

export default CommentCard;