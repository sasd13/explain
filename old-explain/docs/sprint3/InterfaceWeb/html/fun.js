(function() {
	$(document).ready(function() {

		// Cache le message #javascriptNotEnabledMessage
		$('#javascriptNotEnabledMessage').hide();

		// Affiche la fenetre de connexion.
		$('#authentificationBox').show();

		// Process the auth form
		$('#authentificationForm').submit(function(event) {

			var authData = {
				'server'	: $('#server').val(),
				'login'		: $('#login').val(),
				'password'	: $('#login').val()
			};

			// Send auth request to server			
			var authRequest = $.ajax({
				type	: 'POST',
				url		: 'http://ip-api.com/json',
				// http://www.timeapi.org/utc/now?\S
				data 	:  authData,
				dataType: 'json'
			});
			
			authRequest.done(function(data) {
				console.log("done");
			});
			
			authRequest.fail(function(data) {
				console.log("fail");
			});

			authRequest.always(function(data) {
				console.log("always");
				$('#authentificationBox').hide();
				startHome();
				console.log(data);
			}); 

			event.preventDefault();
		});

	});
})();

// Affiche l'accueil
function startHome() {
	$('header').show();
	$('#dashboard').show();
	$('footer').show();
	
	$('#search').submit(function(event) {
		event.preventDefault();
	});
	
	$('#dashboardLink').click(function(event) {
		hideMainContent();
		$('#dashboard').show();
		event.preventDefault();
	});
	
	$('#myCoursesLink').click(function(event) {
		hideMainContent();
		$('#courses').show();
		
		$('#addExerciceLink').click(function(event) {
			hideMainContent();
			$('#addExercice').show();
		});
		event.preventDefault();
	});
	
	$('#myAccountLink').click(function(event) {
		hideMainContent();
		$('#account').show();
		event.preventDefault();
	});
	
	$('#aboutLink').click(function(event) {
		hideMainContent();
		$('#about').show();
		event.preventDefault();
	}); 

}

function hideMainContent() {
	$('#dashboard').hide();
	$('#courses').hide();
	$('#account').hide();
	$('#about').hide();
	$('#addExercice').hide();
}
