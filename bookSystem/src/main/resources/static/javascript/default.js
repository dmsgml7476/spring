/**
 * default.js
 */

$(function(){  //window.onload=function(){}
  $("#menuToggle").click(function(){ //document.getElementsByClassName("menuShow")[0].addElement
	$(".menuShow").toggle();
	$(".menuHide").toggle();
	var left = $("#userBox").css("left");
	left=Math.abs(parseInt(left));  // abs 절대값
	console.log(left);
	$("#userBox").css("left",(left-125)+"px");
	
	});
});