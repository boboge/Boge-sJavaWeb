var su = $.extend({},su);

su.serializeForm = function(form){/*表单序列化*/
	var o = {};
	$.each(form.serializeArray(),function(index){
		if(o[this['name']]){
			o[this['name']] = o[this['name']]+","+this['value'];
		}else{
			o[this['name']] = this['value'];
		}
	});
	return o;
	
};