$(document).ready(function(){
	$('.bxslider').bxSlider({
		  pagerCustom: '#bx-pager'
		});
	
	$("#Watchlist").click(function (){
		var url2 = window.location.href; 
		var a = url2.split('.');
		url2 = a[0] + "/addToWatchlist.html";
		console.log(url2);
		$.ajax({
			method:'GET',
			url: url2,
			 success: function (data) {
                 $('#Watchlist').before('<p>Added to watchlist !</p>');
                 $('#Watchlist').remove();
             },
             error: function () {
                 alert("Failed to add to watchlist");
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
                 $('#MoviePref').before('<p>Added to preferences !</p>');
                 $('#MoviePref').remove();
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
                 $('#ActorPref').before('<p>Added to preferences !</p>');
                 $('#ActorPref').remove();
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






