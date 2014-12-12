<!DOCTYPE html>

<head>
<title></title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document)
			.ready(
					function() {

						var jobNumber = 0;
						var maxNumber;

						function pollServer() {
							

							$
									.ajax({
										type : 'get', // it's easier to read GET request parameters
										url : 'fibservlet',
										dataType : 'JSON',
										data : {
											jobNum : jobNumber,
											max : maxNumber
										// look here!
										},

										success : function(responseJson) {

											$('#main').hide();
											jobNumber = responseJson[1];

											document.getElementById("somediv1").innerHTML = "Job Number: "+ jobNumber;

											var result = responseJson[0];

											if (result != '0') {

												document.getElementById("somediv2").innerHTML = "Fib Sequence: "+ responseJson[0];

												
												$('#somebutton2').css("visibility","visible");
												clearInterval(interval);

											} else {
												document.getElementById("somediv2").innerHTML = "Page will refresh in 10s.";

											}

										},
										error : function(data) {
											alert('fail');

										}
									});

						}
						function getMax() {
							return $('#maxNumber').val();
						}
						$('#somebutton2').click(function(event) {
							$('#main').show();
							$('#somediv1').css("visibility","hidden");
							$('#somediv2').css("visibility","hidden");
							$('#maxNumber').val('')
							
							$('#somebutton2').css("visibility","hidden");

						});
						$('#somebutton').click(function(event) {

							maxNumber = getMax();
							pollServer()
							interval = setInterval(pollServer, 2000);
							$('#somediv1').css("visibility","visible");
							$('#somediv2').css("visibility","visible");

						});

					});
</script>
</head>
<body>
	<div id="main" >
		<p>Fibonacci Sequence Length<p>
		<p><input type="text" id="maxNumber"></p>
		<p>(Value 1-100)</p>
		<button id="somebutton">Submit</button>
	</div>

	<div id="somediv1"></div>
	<div id="somediv2"></div>
	<button id="somebutton2" style="visibility:hidden"><a href="http://localhost:8080/FibonacciService/">Back to Start</a></button>

</body>
</html>