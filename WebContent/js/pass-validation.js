$(document).ready(function () {
		
		$('.needs-validation').submit(function(){	
		var pass1 = $('#password').val();
		var pass2 = $('#password2').val();

		if ( pass1 == pass2 ) {
			$('#error2').text("coincide");
		} else {
			alert("Las contraseñas deben ser iguales");
			(document).getElementById("password").value="";
			(document).getElementById("password2").value="";
			(document).getElementById("password").focus();			
			}
	});	
});
