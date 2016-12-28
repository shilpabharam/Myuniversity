app.filter('removeSpacesThenLowercase', function () {
    return function (text) {
		var str = text.replace(/\s+/g, '');
		return str;
    };
})