$.extend($.fn.validatebox.defaults.rules, {
	validDate : {
		validator : function(value) {
			var date = $.fn.datebox.defaults.parser(value);
			var s = $.fn.datebox.defaults.formatter(date);
			return s == value;
		},
		message : 'Date format must be mm/dd/yyyy.'
	}
});

function clearForm() {
	$('#searchForm').form('clear');
}

