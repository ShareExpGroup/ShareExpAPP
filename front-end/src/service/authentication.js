import {goto} from "./utils";

function isMentee() {
    return localStorage.getItem("isMentee") === "true";
}

function isMentor() {
    return localStorage.getItem("isMentee") === "false";
}

function isAdmin() {
    return localStorage.getItem("isAdmin") === "true";
}

function isGuest() {
    return localStorage.getItem("currentUser") === null || localStorage.getItem("currentUser") === undefined;
}
function logOut(){
    localStorage.removeItem("currentUser");
    localStorage.removeItem("isMentee");
    localStorage.removeItem("isAdmin");
    goto("/");
}


export {isMentee,isMentor,isGuest,isAdmin,logOut}