/*
$(document).ready(function(){
	
	$('mainDiv').css( "width", screen.width);
	$('mainDiv').css( "height", screen.height);
	
	$('mainTable').css( "width", screen.width);
	$('mainTable').css( "height", screen.height);
	
	
	$('headerDiv').css("width", screen.width);
	$('headerDiv').css( "height", screen.height*.1);
	
	$('contentDiv').css("width", screen.width);
	$('contentDiv').css( "height", screen.height*.85);
	
	$('footerDiv').css("width", screen.width);
	$('footerDiv').css( "height", screen.height*.05);
	
});*/
/*
$(function() {
	alert("hhhhhhhhhhh");
    $( "#form:tourDate" ).datepicker();
    $( "#form:tourDate" ).datepicker("show");
 });*/

$(document).ready(function() {

    $(".tourDate").datepicker({ dateFormat: 'yy-mm-dd' });

});
