$(function() {
    $(".link-confirm").click(function(e) {
        var comment = $(this).data("comment") || "정말 이동하시겠습니까?";
        return window.confirm(comment);
    });
});