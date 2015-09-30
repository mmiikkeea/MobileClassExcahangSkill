<?php
	$con=mysqli_connect("localhost","myuser","mypassword","mydb");

	$name=$_POST["name"];
	$password=$_POST["password"];
	$age=$_POST["age"];
	$skillA=$_POST["skillA"];
	$interestA=$_POST["interestA"];
	$skillB=$_POST["skillB"];
	$interestB=$_POST["interestB"];
	$major=$_POST["major"];

	$statement=mysqli_prepare($con,"INSERT INTO user (name,password,age,skillA,interestA,skillB,interestB,major) VALUES (?,?,?,?,?,?,?,?)")
	mysqli_stmt_bind_param($statement,"ssisssss",$name,$password,$age,$skillA,$interestA,$skillB,$interestB,$major);

	mysqli_stmt_execute($statement);
	mysqli_stmt_close($statement);



mysqli_close($con)
?>
