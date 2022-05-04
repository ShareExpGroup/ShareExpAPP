import React from "react";
import MyButton from "../../usedComponents/MyButton";

function SignIn() {
  return (
    <MyButton
      bgColor="rgba(37, 99, 235, 1)"
      fgColor="white"
      className="signIn"
      value="Sign In"
      url="/signin"
    />
  );
}
export default SignIn;
