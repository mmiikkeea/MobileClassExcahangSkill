<?php
	$con=mysqli_connect("localhost","myuser","mypassword","mydb");

	$name=$_POST["name"];
	$password=$_POST["password"];

	$statement=mysqli_prepare($con,"SELECT * FROM user WHERE name = ? AND password = ?");
	mysqli_stmpt_bind_param($statement,"s",$name,$password);
	mysqli_stmt_execute($statement);
	mysqli_stmt_store_result($statement);
	myseli_bind_result($statement,$userID,$name,$password,$age,$skillA,$interestA,$skillB,$interestB,$major);
	$user =array();

	while (mysqli_stmpt_fetch($statement)) {
		# code...
		$user[name]=$name;
		$user[password]=$password;
		$user[age]=$age;
		$user[skillA]=$skillA;
		$user[skillB]=$skillB;
		$user[interestA]=$interestA;
		$user[interestB]=$interestB;
		$user[major]=$major;
	}
	echo json_encode($user);


	mysqli_stmt_close($statement);

	mysqli_close($con)
?>