$(document).ready(function(){
	
	$('.bxslider').bxSlider({
		  pagerCustom: '#bx-pager'
		});
	
	$("#add-watchlist").click(function (){
		var url2 = window.location.href; 
		var a = url2.split('.');
		url2 = a[0] + "/addToWatchlist.html";
		console.log(url2);
		$.ajax({
			method:'GET',
			url: url2,
			 success: function (data) {
				 $('#add-watchlist').before('<button id="remove-watchlist">Remove from Watchlist</button>');				 
                 $('#add-watchlist').remove();
                 window.location.reload();
             },
             error: function () {
                 alert("Failed to load names");
             }
		})
	});
	
	$("#remove-watchlist").click(function (){
		var url2 = window.location.href; 
		var a = url2.split('.');
		url2 = a[0] + "/removeFromWatchlist.html";
		console.log(url2);
		$.ajax({
			method:'GET',
			url: url2,
			 success: function (data) {
				 $('#remove-watchlist').before('<button id="add-watchlist">Add to Watchlist</button>');			 
                 $('#remove-watchlist').remove();
                 window.location.reload();
             },
             error: function () {
                 alert("Failed to load names");
             }
		})
	});
	
	$("#MoviePref").click(function (){
		var url2 = window.location.href; 
		var a = url2.split('.');
		url2 = a[0] + "/addToPref.html";
		console.log(url2);
		$.ajax({
			method:'GET',
			url: url2,
			 success: function (data) {
                 $('#MoviePref').before('<button id="remove-moviepref">Remove from preferences</button>');
                 $('#MoviePref').remove();
                 window.location.reload();
             },
             error: function () {
                 alert("Failed to add to preferences");
             }
		})
	});
	
	$("#remove-moviepref").click(function (){
		var url2 = window.location.href; 
		var a = url2.split('.');
		url2 = a[0] + "/removeFromPref.html";
		console.log(url2);
		$.ajax({
			method:'GET',
			url: url2,
			 success: function (data) {
                 $('#remove-moviepref').before('<button id="MoviePref">Add to Preferences</button>');
                 $('#remove-moviepref').remove();
                 window.location.reload();
             },
             error: function () {
                 alert("Failed to add to preferences");
             }
		})
	});
	
	$("#ActorPref").click(function (){
		var url2 = window.location.href; 
		var a = url2.split('.');
		url2 = a[0] + "/addToPref.html";
		console.log(url2);
		$.ajax({
			method:'GET',
			url: url2,
			 success: function (data) {
                 $('#ActorPref').before('<button id="remove-actorpref">Remove from Preferences</button>');
                 $('#ActorPref').remove();
                 window.location.reload();
             },
             error: function () {
                 alert("Failed to add to preferences");
             }
		})
	});
	
	$("#remove-actorpref").click(function (){
		var url2 = window.location.href; 
		var a = url2.split('.');
		url2 = a[0] + "/removeFromPref.html";
		console.log(url2);
		$.ajax({
			method:'GET',
			url: url2,
			 success: function (data) {
                 $('#remove-actorpref').before('<button id="ActorPref">Add to Preferences</button>');
                 $('#remove-actorpref').remove();
                 window.location.reload();
             },
             error: function () {
                 alert("Failed to add to preferences");
             }
		})
	});

	$("#commWithoutRating").click(function() {
		var url2 = window.location.href; 
		var a = url2.split('.');
		url2 = a[0] + ".html";
		console.log("hereeee "  + url2);
		 document.location.href=url2;
	});

});








