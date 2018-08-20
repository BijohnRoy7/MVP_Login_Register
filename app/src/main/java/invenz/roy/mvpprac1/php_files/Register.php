<?php

	require "Connection.php";
	
	
	if($con){
		//echo "OK";
		/*
		$username = "username";
		$email = "email";
		$password = "password";
		*/
		$username = $_POST["username"];
		$email = $_POST["email"];
		$password = $_POST["password"];
		
		$sql = "insert into user (name,email, password) values ( '".$username."', '".$email."', '".$password."' ) ";
		$result = mysqli_query($con, $sql);
		$response = array();
		
		if($result){
			
			$response["code"] = "success";
			$response["message"] = "successfully registered";
			
		}else{
			$response["code"] = "failed";
			$response["message"] = "Failed to register";
		}
		
		echo json_encode($response);
		mysqli_close($con);
		
	}else{
		echo "NO";
	}
	
	

?>