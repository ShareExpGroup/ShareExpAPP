import React from "react";
import { Button } from '@mui/material';


function MyButton(props) {
  let style = {
    backgroundColor: props.bgColor || "rgba(37, 99, 235, 1)",
    color: props.fgColor,
    float: "right",
  
    marginRight: "10px",
    marginTop: "1px",
 
    fontSize: props.size || "12px",
    fontFamily: "Montserrat",
    fontStyle: "bold",
    minWidth: "130px",
  };
  if (props.style !== undefined) {
    style = { ...style, ...props.style };
  }
  return (
    <Button
      style={style}
      variant="contained"
      color="primary"
      className={props.className}
      size="small"
      href={props.url}
      onClick={props.onClick}
      startIcon={props.startIcon}
     
    >
      {props.value}
    </Button>
  );
}
export default MyButton;
