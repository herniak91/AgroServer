<html>
	<head>
		<title>Post Sender</title>
		<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
	</head>
	<body>
		<table>
			<tr>
				<td>
					<div>URL</div>
				</td>
				<td>
					<input id="url" style="width:400px;" value="http://localhost:8080/AgroServer/Perfil/crear"></input>
				</td>
			</tr>
			<tr>
				<td>
					<div>Json to send</div>
				</td>
				<td>
					<textarea type="text" id="json_input" style="width:1100px; height:500px;"></textarea>
				</td>
			</tr>
			<tr>
				<td/>
				<td>
					<button id="postButton" onClick="postData()">Post</button>
				</td>
			</tr>
		</table>
		<script>
			function postData(){
				var jsonContent = $("#json_input").val();
				var urlToBeUsed = $("#url").val();
				$.ajax({ 
					url: urlToBeUsed,    
					type:"POST", 
					contentType: "application/json; charset=utf-8",
					data: JSON.stringify(jsonContent),
					success: function(resp){
						alert(resp)
					},
					fail: function(resp){
						alert(resp)
					}
				});
			}
		</script>
	</body>
</html>
