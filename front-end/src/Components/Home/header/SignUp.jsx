import React from "react";
import MyButton from "../../usedComponents/MyButton";

function SignUp() {
  return (
    <MyButton
      bgColor="rgba(31, 41, 55, 1)"
      fgColor="white"
      className="signUp"
      value="sign Up"
      url="/signup"
    />
  );
}
export default SignUp;
