(function(b){b.iTextSuggest=function(d,h){var a=this,c=null;a.$el=b(d);a.el=d;a.$el.data("iTextSuggest",a);a.init=function(){a.options=b.extend({},b.iTextSuggest.defaultOptions,h);b("body").append("<div id='"+a.options.id+"'></div>");var i=b('<span class="itextsuggestpreloader"></span>'),d=null;c=b("#"+a.options.id);a.$el.before(i);a.$el.attr(a.options.attribute)==void 0&&a.$el.attr(a.options.attribute,a.$el.val()).addClass(a.options.blurClass);a.$el.focus(function(){a.$el.val()==a.$el.attr(a.options.attribute)&&
a.$el.val("").removeClass(a.options.blurClass).addClass(a.options.activeClass);a.options.minLength<=a.$el.val().length&&c.show()});a.$el.blur(function(){a.$el.val()==""&&a.$el.val(a.$el.attr(a.options.attribute)).removeClass(a.options.activeClass).addClass(a.options.blurClass);setTimeout(function(){c.hide()},200)});b(window).resize(function(){a.setPos()});b("ul li a",c).live("mouseover",function(){b("ul li a",c).removeClass("active")});b.isFunction(a.options.onSelect)&&b("ul li a",c).live("click",
function(){a.$el.val(b(this).text());b(this).text();a.$el.trigger("keyup").focus();a.options.onSelect(b(this).text());return false});a.$el.keyup(function(e){var f=a.$el.val(),h=encodeURIComponent(f),g=b("ul li a",c).index(b("a.active")),j=b("ul li a",c).length;a.setPos();clearTimeout(d);b("ul li a",c).removeClass("active");switch(e.keyCode){case 38:case 40:e=e.keyCode==38?g<0?b("ul li a:last",c):b("ul li a",c).eq(g-1):g<0||g==j-1?b("ul li a:first",c):b("ul li a",c).eq(g+1);e.addClass("active");a.$el.val(e.text());
if(b.isFunction(a.options.onChange))a.options.onChange(e.text());break;case 13:a.$el.trigger("submit.itextsuggest");break;default:f.length==0?a.$el.trigger("empty.itextsuggest"):a.options.minLength>f.length?c.hide():(a.options.minLength<=f.length&&(d=setTimeout(function(){i.show();b.get(a.options.url,"q="+h+"&target="+a.options.targetMode,function(a){a.length>3?c.html(a).show():c.hide().empty()}).complete(function(){i.hide()})},250)),a.$el.trigger("keydown.itextsuggest"))}})};a.$el.bind("empty.itextsuggest",
function(){if(b.isFunction(a.options.onEmpty))a.options.onEmpty()});a.$el.bind("submit.itextsuggest",function(){if(b.isFunction(a.options.onSubmit))a.options.onSubmit(a.$el.val())});a.$el.bind("keydown.itextsuggest",function(){if(b.isFunction(a.options.onKeydown))a.options.onKeydown(a.$el.val())});a.setPos=function(){var b=a.$el.parents("div.searchbox").outerWidth(),d=a.$el.parents("div.searchbox").outerHeight(),e=a.$el.parents("div.searchbox").offset().top+4,f=a.$el.parents("div.searchbox").offset().left;
c.css({width:b+"px",top:e+d+"px",left:f+"px"})};a.init()};b.iTextSuggest.defaultOptions={attribute:"rel",id:"itextsuggest",minLength:1,targetMode:"",url:"php/google_suggestions_results.php",activeClass:"fieldActive",blurClass:"fieldBlurred",onKeydown:null,onSelect:null,onChange:null,onSubmit:null,onEmpty:null};b.fn.iTextSuggest=function(d){return this.each(function(){new b.iTextSuggest(this,d)})}})(jQuery);