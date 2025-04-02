let joinForm=new Array(2);
let loginForm=new Array(2);

window.onload=function(){
    joinForm[0]= document.querySelector("#joinModal");
    loginForm[0] =document.querySelector("#loginModal");
    joinForm[1]= document.querySelector("#joinModalBg");
    loginForm[1] =document.querySelector("#modalBg");
    joinForm[1].addEventListener("click", function(){
        joinForm[0].style.display="none";
    });
    loginForm[1].addEventListener("click", function(){
        loginForm[0].style.display="none";
    });
}

function join(){
    joinForm[0].style.display="block";
}
function login(){
    
    loginForm[0].style.display="block";
}