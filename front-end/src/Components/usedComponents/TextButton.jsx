import React from "react";
import { Button } from '@mui/material';


function TextButton(props) {
  let style = {
    backgroundColor: props.bgColor,
    color: props.fgColor,
    borderRadius: 100,
    float: "right",
  
    marginRight: props.margin || "20px",
  };
  return (
    <Button
      style={style}
      className={props.className}
      size={props.size || "small"}
      href={props.url}
    >
      {props.value}
    </Button>
  );
}
export default TextButton;
