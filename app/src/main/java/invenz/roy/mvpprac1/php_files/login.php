<?php

	require "Connection.php";
	
	
	if($con){
		//echo "OK";

		/*
		$email = "email";
		$username = "john";
		$password = "123";
		*/
		//$email = $_POST["email"];
		
		$username = $_POST["username"];
		$password = $_POST["password"];


		$sql = "Select * from user where name = '".$username."' and password = '".$password."' ";
		$result = mysqli_query($con, $sql);
		$response = array();
		
		if(mysqli_num_rows($result)){
			
			$row = mysqli_fetch_row($result);
			
			$id = $row[0];
			$name = $row[1];
			
			$response["code"] = "success";
			$response["message"] = "successfully logged in";
			
		}else{
			$response["code"] = "failed";
			$response["message"] = "Invalid username or password";
		}
		
		echo json_encode($response);
		mysqli_close($con);
		
	}else{
		echo "NO";
	}
	
	

?>