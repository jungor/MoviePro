$(function () {
    var nav = $(".nav-aside").children();
    var personalInfo = $(".personal-info");
    var infoPage = $(".info-page");
    var editPage = $(".edit-page");
    var orderList = $(".order-list");
    var editButton = $(".btn-edit");
    var editForm = $(".form-group");
    var info = $(".info");
    nav.click(function() {
    	if (!$(this).hasClass("active")) {
    		nav.toggleClass("active");
	    	personalInfo.toggleClass("hidden");
	    	orderList.toggleClass("hidden");
    	}
    });
    editButton.click(function() {
        infoPage.toggleClass("hidden");
        editPage.toggleClass("hidden");
    });
    $(".info-edit").click(function(e) {
        e.preventDefault();
        editForm.addClass("hidden");
        info.removeClass("hidden");
        $(this).parents(".info-block").children(".info").addClass("hidden");
        $(this).parents(".info-block").children(".form-group").removeClass("hidden");
    });
    $(".btn-cancel").click(function() {
        $(this).parents(".info-block").children(".info").removeClass("hidden");
        $(this).parents(".info-block").children(".form-group").addClass("hidden");
    });
});
