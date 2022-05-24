import {goto} from "./utils";


function isshaereExpuser() {
    return localStorage.getItem("isshaereExpuser") === "true";
}

function isAdmin() {
    return localStorage.getItem("isAdmin") === "true";
}

function isGuest() {
    return localStorage.getItem("currentUser") === null || localStorage.getItem("currentUser") === undefined;
}
function logOut(){
    localStorage.removeItem("currentUser");
    localStorage.removeItem("isshaereExpuser");

    goto("/");
}


export {isshaereExpuser,isGuest,isAdmin,logOut}