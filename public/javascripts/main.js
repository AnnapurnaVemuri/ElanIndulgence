$("#designerButton").hover(function () {
	$(this).css('text-decoration', 'underline');
});

$(document).ready(function () {
	$("body").css('background-image', '@routes.Assets.at("javascripts/bg1.img")');
});