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
                 alert("Failed to load names");
             }
		})
	});
});






