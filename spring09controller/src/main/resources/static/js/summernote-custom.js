$(function() {
	$("[name=boardContent]").summernote({
		height: 250,//높이(px)
		minHeight: 200, //최소높이(px)
		maxHeight: 400, //최대높이(px)

		placeholder: "타인에 대한 무분별한 비방 시 예고 없이 삭제될 수 있습니다",

		//메뉴(toolbar) 설정
		toolbar: [
			//['메뉴명', ['버튼명', '버튼명', ...]]
			["font", ["style", "fontname", "fontsize", "forecolor", "backcolor"]],
			["style", ["bold", "italic", "underline", "strikethrough"]],
			["attach", ["picture"]],
			["tool", ["ol", "ul", "table", "hr", "fullscreen"]],
			// ["action", ["undo", "redo"]],
		],
	});
});