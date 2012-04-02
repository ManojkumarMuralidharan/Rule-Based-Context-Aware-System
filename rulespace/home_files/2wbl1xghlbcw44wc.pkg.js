/*    HTTP Host:  b.static.ak.fbcdn.net                                        */
/*    Generated:  April 21st 2009 10:05:21 AM PDT                              */
/*      Machine:  10.16.140.110                                                */
/*       Source:  Local Cache                                                  */
/*     Location:  rsrc:2b37kcqn:en_US:/html/js/2wbl1xghlbcw44wc.pkg.js:141     */
/*       Locale:  en_US                                                        */
/*         Path:  js/2wbl1xghlbcw44wc.pkg.js                                   */


function editor_two_level_change(selector,subtypes_array,sublabels_array)
{selector=ge(selector);if(selector.getAttribute("typefor"))
subselector=ge(selector.getAttribute("typefor"));if(selector&&subselector){subselector.options.length=1;type_value=selector.options[selector.selectedIndex].value;if(type_value==""){type_value=-1;}
index=1;suboptions=subtypes_array[type_value];if(typeof(suboptions)!="undefined"){for(var key=0;key<suboptions.length;key++){if(typeof(suboptions[key])!="undefined"){subselector.options[index++]=new Option(suboptions[key],key);}}}
if(sublabels_array){if(sublabels_array[type_value]){subselector.options[0]=new Option(sublabels_array[type_value],"");subselector.options[0].selected=true;}else{subselector.options[0]=new Option("---","");subselector.options[0].selected=true;}}
subselector.disabled=subselector.options.length<=1;}}
function editor_two_level_set_subselector(subselector,value)
{subselector=ge(subselector);if(subselector){opts=subselector.options;for(var index=0;index<opts.length;index++){if((opts[index].value==value)||(value===null&&opts[index].value=='')){subselector.selectedIndex=index;}}}}
function editor_network_change(selector,prefix,orig_value){selector=ge(selector);if(selector&&selector.value>0){show('display_network_message');}else{hide('display_network_message');}}
function editor_rel_change(selector,prefix,orig_value)
{selector=ge(selector);for(var rel_type=2;rel_type<=6;rel_type++){if(rel_type==selector.value){show(prefix+'_new_partner_'+rel_type);}else{hide(prefix+'_new_partner_'+rel_type);}}
if(selector&&ge(prefix+'_new_partner')){if(selector.value>1){show(prefix+'_new_partner');}else{hide(prefix+'_new_partner');}}
if(selector&&ge(prefix+'_rel_uncancel')){if(selector.value>1)
editor_rel_uncancel(selector,prefix,selector.value);else
editor_rel_cancel(selector,prefix);}
_editor_rel_toggle_awaiting(selector,prefix,orig_value);}
function rel_typeahead_onsubmit(){return false;}
function rel_typeahead_onselect(friend){if(!friend)
return;$('new_partner').value=friend.i;show($('relationship_warning'));set_inner_html($('relationshipee'),htmlize(friend.t));}
function _editor_rel_toggle_awaiting(selector,prefix,orig_value)
{selector=ge(selector);if(selector&&ge(prefix+'_rel_required')){if(selector.value==orig_value){hide(prefix+'_rel_required');show(prefix+'_rel_awaiting');}
else{show(prefix+'_rel_required');hide(prefix+'_rel_awaiting');}}}
function editor_rel_cancel(selector,prefix)
{if(ge(prefix+'_rel_uncancel'))
show(prefix+'_rel_uncancel');if(ge(prefix+'_rel_cancel'))
hide(prefix+'_rel_cancel');selector=ge(selector);if(ge(selector)&&$(selector).selectedIndex>1)
_editor_rel_set_value(selector,1);}
function editor_rel_cancel_new(selector,prefix,orig_value)
{hide($('relationship_warning'));$('new_partner').value='';$('relationship_typeahead').typeahead.clear();_editor_rel_set_value($(selector),orig_value);editor_rel_change($(selector),prefix,orig_value);}
function editor_rel_uncancel(selector,prefix,rel_value)
{if(ge(prefix+'_rel_uncancel'))
hide(prefix+'_rel_uncancel');if(ge(prefix+'_rel_cancel'))
show(prefix+'_rel_cancel');if(rel_value==4||rel_value==5){hide(prefix+'_rel_with');show(prefix+'_rel_to');}else if(rel_value>1){show(prefix+'_rel_with');hide(prefix+'_rel_to');}
if(ge(selector)&&$(selector).selectedIndex<=1)
_editor_rel_set_value(selector,rel_value);_editor_rel_toggle_awaiting(selector,prefix,rel_value);}
function editor_autocomplete_onselect(result){var hidden=ge(/(.*)_/.exec(this.obj.name)[1]+'_id');if(result){hidden.value=result.i==null?result.t:result.i;}
else{hidden.value=-1;}}
function _editor_rel_set_value(selector,value)
{selector=ge(selector);if(selector){opts=selector.options;opts_length=opts.length;for(var index=0;index<opts_length;index++){if((opts[index].value==value)||(value===null&&opts[index].value=='')){selector.selectedIndex=index;}}}}
function enableDisable(gainFocus,loseFocus){loseFocus=ge(loseFocus);if(loseFocus){if(loseFocus.value)loseFocus.value="";if(loseFocus.selectedIndex)loseFocus.selectedIndex=0;}}
function show_editor_error(error_text,exp_text)
{$('editor_error_text').innerHTML=error_text;$('editor_error_explanation').innerHTML=exp_text;show('error');}
function make_explanation_list(list,num,type){var exp='';if(type=='missing'){if(num==1){exp=_tx("{thing-1} is required.",{'thing-1':list[0]});}else if(num==2){exp=_tx("{thing-1} and {thing-2} are required.",{'thing-1':list[0],'thing-2':list[1]});}else if(num==3){exp=_tx("{thing-1}, {thing-2}, and {thing-3} are required.",{'thing-1':list[0],'thing-2':list[1],'thing-3':list[2]});}else if(num==4){exp=_tx("{thing-1}, {thing-2}, {thing-3}, and {thing-4} are required.",{'thing-1':list[0],'thing-2':list[1],'thing-3':list[2],'thing-4':list[3]});}else if(num>4){exp=_tx("{thing-1}, {thing-2}, {thing-3}, and {num} other fields are required.",{'thing-1':list[0],'thing-2':list[1],'thing-3':list[2],'num':num-3});}}else if(type=='bad'){if(num==1){exp=_tx("{thing-1} appears to be invalid.",{'thing-1':list[0]});}else if(num==2){exp=_tx("{thing-1} and {thing-2} appear to be invalid.",{'thing-1':list[0],'thing-2':list[1]});}else if(num==3){exp=_tx("{thing-1}, {thing-2}, and {thing-3} appear to be invalid.",{'thing-1':list[0],'thing-2':list[1],'thing-3':list[2]});}else if(num==4){exp=_tx("{thing-1}, {thing-2}, {thing-3}, and {thing-4} appear to be invalid.",{'thing-1':list[0],'thing-2':list[1],'thing-3':list[2],'thing-4':list[3]});}else if(num>4){exp=_tx("{thing-1}, {thing-2}, {thing-3}, and {num} other fields appear to be invalid.",{'thing-1':list[0],'thing-2':list[1],'thing-3':list[2],'num':num-3});}}
return exp;}
function TimeSpan(start_prefix,end_prefix,span,auto){this.get_start_ts=function(){return _get_date_time_ts(_start_month,_start_day,_start_year,_start_hour,_start_min,_start_ampm);}
this.get_end_ts=function(){var start_ts=_get_date_time_ts(_start_month,_start_day,_start_year,_start_hour,_start_min,_start_ampm);var end_ts=_get_date_time_ts(_end_month,_end_day,_end_year,_end_hour,_end_min,_end_ampm);if(start_ts>end_ts&&!(_start_year&&_end_year)){var future_date=new Date();future_date.setTime(end_ts);future_date.setFullYear(future_date.getFullYear()+1);return future_date.getTime();}else{return end_ts;}}
var _start_month=ge(start_prefix+'_month');var _start_day=ge(start_prefix+'_day');var _start_hour=ge(start_prefix+'_hour');var _start_year=ge(start_prefix+'_year');var _start_min=ge(start_prefix+'_min');var _start_ampm=ge(start_prefix+'_ampm');var _end_month=ge(end_prefix+'_month');var _end_day=ge(end_prefix+'_day');var _end_year=ge(end_prefix+'_year');var _end_hour=ge(end_prefix+'_hour');var _end_min=ge(end_prefix+'_min');var _end_ampm=ge(end_prefix+'_ampm');var _bottom_touched;if(auto){_bottom_touched=false;}else{_bottom_touched=true;}
var _start_touched=function(){if(!_bottom_touched){_propogate_time_span(_start_month,_start_day,_start_year,_start_hour,_start_min,_start_ampm);}}
var _end_touched=function(){_bottom_touched=true;}
var _propogate_time_span=function(){var start_ts=_get_date_time_ts(_start_month,_start_day,_start_year,_start_hour,_start_min,_start_ampm);var end_ts=start_ts+span*60000;_set_date_time_from_ts(end_ts,_end_month,_end_day,_end_year,_end_hour,_end_min,_end_ampm);}
var _get_date_time_ts=function(m,d,y,h,min,ampm){var this_date=new Date();var date_this_day=this_date.getDate();var date_this_month=this_date.getMonth();var date_this_year=this_date.getFullYear();var month=m.value-1;var date=d.value;var hour;var minutes=min.value;var year;hour=parseInt(h.value);if(ampm.value!=''){if(hour==12)hour=0;if(ampm.value=='pm'){hour=hour+12;}}
if(!y){if(month<date_this_month){year=date_this_year+1;}else{if(month==date_this_month&&date<date_this_day){year=date_this_year+1;}else{year=date_this_year;}}}else{year=y.value;}
var new_date=new Date(year,month,date,hour,minutes,0,0);var ts=new_date.getTime();return ts;}
var _set_date_time_from_ts=function(ts,m,d,y,h,min,ampm){var new_date=new Date();new_date.setTime(ts);var old_month=m.value;var new_month=new_date.getMonth()+1;var new_day=new_date.getDate();var new_hour=new_date.getHours();var new_minutes=new_date.getMinutes();var new_year=new_date.getFullYear();var new_ampm;if(ampm.value!=''){if(new_hour>11){new_ampm='pm';if(new_hour>12){new_hour=new_hour-12;}}else{if(new_hour==0)new_hour=12;new_ampm='am';}}else{new_ampm='';}
if(new_minutes<10){new_minutes="0"+new_minutes;}
m.value=new_month;d.value=new_day;if(y){y.value=new_year;}
h.value=new_hour;min.value=new_minutes;ampm.value=new_ampm;if(old_month!=new_month){editor_date_month_change(m,d,y?y:false);}}
var _start_month_touched=function(){_start_touched();editor_date_month_change(_start_month,_start_day,_start_year?_start_year:false);}
var _end_month_touched=function(){_end_touched();editor_date_month_change(_end_month,_end_day,_end_year?_end_year:false);}
var _end_hour_touched=function(){_end_touched();var start_ts=_get_date_time_ts(_start_month,_start_day,_start_year,_start_hour,_start_min,_start_ampm);var end_ts=_get_date_time_ts(_end_month,_end_day,_end_year,_end_hour,_end_min,_end_ampm);if(end_ts<start_ts){var twelve_hours=12*60*60000;end_ts+=parseInt((start_ts-end_ts+twelve_hours-1)/twelve_hours)*twelve_hours;_set_date_time_from_ts(end_ts,_end_month,_end_day,_end_year,_end_hour,_end_min,_end_ampm);}}
_start_month.onchange=_start_month_touched;_start_day.onchange=_start_touched;if(_start_year){_start_year.onchange=_start_touched;}
_start_hour.onchange=_start_touched;_start_min.onchange=_start_touched;_start_ampm.onchange=_start_touched;_end_month.onchange=_end_month_touched;_end_day.onchange=_end_touched;if(_end_year){_end_year.onchange=_end_touched;}
_end_hour.onchange=_end_hour_touched;_end_min.onchange=_end_touched;_end_ampm.onchange=_end_touched;}
function editor_date_month_change(month_el,day_el,year_el){var month_el=ge(month_el);var day_el=ge(day_el);var year_el=year_el?ge(year_el):false;var new_num_days=_month_get_num_days(month_el.value,year_el.value&&year_el.value!=-1?year_el.value:false);var b=day_el.options[0].value==-1?1:0;for(var i=day_el.options.length;i>new_num_days+b;i--){DOM.remove(day_el.options[i-1]);}
for(var i=day_el.options.length;i<new_num_days+b;i++){day_el.options[i]=new Option(i+(b?0:1),i+(b?0:1));}}
function _month_get_num_days(month,year){var temp_date;if(month==-1){return 31;}
temp_date=new Date(year?year:1912,month,0);return temp_date.getDate();}
function toggleEndWorkSpan(prefix){if(shown(prefix+'_endspan')){hide(prefix+'_endspan');show(prefix+'_present');}else{show(prefix+'_endspan');hide(prefix+'_present');}}
function regionCountryChange(label_id,country_id,region_id,label_prefix){switch(country_id){case'326':show(region_id);$(label_id).innerHTML=label_prefix+_tx("Province");break;case'398':show(region_id);$(label_id).innerHTML=label_prefix+_tx("State");break;default:$(label_id).innerHTML=label_prefix+_tx("Country");hide(region_id);break;}}
function regionCountryChange_twoLabels(country_label_id,region_label_id,country_id,region_id,label_prefix){show(country_label_id);$(country_label_id).innerHTML=label_prefix+_tx("Country");switch(country_id){case'326':show(region_id);show(region_label_id);$(region_label_id).innerHTML=label_prefix+_tx("Province");break;case'':case'398':show(region_id);show(region_label_id);$(region_label_id).innerHTML=label_prefix+_tx("State");break;default:$(region_label_id).innerHTML=label_prefix+_tx("State");$(region_id).disabled=true;break;}}
function regionCountyChange_setUSifStateChosen(country_select_id,region_select_id){region_select=ge(region_select_id);country_select=ge(country_select_id);if(region_select.value!=''&&country_select.value==''){country_select.value=398;}}
function regionCountryChange_restrictions(country_select_id,region_select_id){country_select=ge(country_select_id);if(country_select.value==398){country_select.value='';}else if(country_select.value==326){region_select=ge(region_select_id);if(region_select.value){country_select.value='';}}}
function mobile_phone_nag(words,obj,anchor){var nagged=false;var callback=function(){if(nagged){return;}
for(var i=0;i<words.length;i++){if((new RegExp('\\b'+words[i]+'\\b','i')).test(obj.value)){nagged=true;(new AsyncRequest()).setURI('/ajax/mobile_phone_nag.php').setHandler(function(async){var html=async.getPayload();if(html){var div=document.createElement('div');div.innerHTML=html;CSS.setClass(div,'mobile_nag');div.style.display='none';anchor.parentNode.insertBefore(div,anchor);animation(div).blind().show().from('height',0).to('height','auto').go();}}).setReadOnly(true).setOption('suppressErrorHandlerWarning',true).send();break;}}}
addEventBase(obj,'keyup',callback);addEventBase(obj,'change',callback);}
function mobile_phone_nag_hide(obj){while(obj.parentNode&&obj.className!='mobile_nag'){obj=obj.parentNode;}
obj.parentNode.removeChild(obj);}

function SelectableTextInputControl(textinput){textinput.listen('click',this.inputClick.bind(this));return this.parent.construct(this,textinput);}
SelectableTextInputControl.extend('TextInputControl');SelectableTextInputControl.prototype.focusSelectText=false;SelectableTextInputControl.prototype.focusAndSelect=function(){this.focusSelectText=true;this.getRoot().focus();}
SelectableTextInputControl.prototype.setFocused=function(focused,e){if($E(e)&&$E(e).type=='blur'){this.focusSelectText=false;return this.parent.setFocused(focused);}else if(this.focusSelectText==true){var return_value=this.parent.setFocused(false);this.getRoot().select();return return_value;}
return this.parent.setFocused(focused);}
SelectableTextInputControl.prototype.isEmpty=function(){if(this.focusSelectEmpty){return false;}else{return this.parent.isEmpty();}}
SelectableTextInputControl.prototype.onupdate=function(e){if($E(e)&&$E(e).type=='keydown'){if(this.focusSelectText==true){this.focusSelectText=false;this.focusSelectEmpty=true;this.setFocused(true);this.focusSelectEmpty=false;return;}}
return this.parent.onupdate(e);}
SelectableTextInputControl.prototype.inputClick=function(e){if(this.focusSelectText==true){this.focusSelectText=false;this.setFocused(true);}}

function focus_login(enable_precog,focuslogin){var e=ge('email');var p=ge('pass');if(e&&p){var e_control=new SelectableTextInputControl(e);e_control.setPlaceholderText(_tx("Email"));if(enable_precog){p.onkeyup=(function(e){return function(){precog(e.value);}})(e);}
if(!e_control.getValue()){p.addClass('hidden_elem');$('pass_placeholder').removeClass('hidden_elem');new PasswordInputControl($('pass_placeholder'),p).setPlaceholderText(_tx("Password"));}
if(focuslogin){if(e_control.getValue()&&!p.value){p.focus();}else{e_control.focusAndSelect();}}}}
function precog(value){if(!value||precog.done){return;}
precog.done=true;var e=encodeURIComponent(value);(new Image()).src='/ajax/precog.php?email='+e+"&"+Math.random();}
function PasswordInputControl(textinput,passwordinput){this.passwordInput=passwordinput;return this.parent.construct(this,textinput);}
PasswordInputControl.extend('TextInputControl');PasswordInputControl.prototype.passwordInput=null;PasswordInputControl.prototype.setFocused=function(focused){if(focused){this.parent.setFocused(true);CSS.removeClass(this.passwordInput,'hidden_elem');CSS.addClass(this.getRoot(),'hidden_elem');this.passwordInput.focus();return;}else{return this.parent.setFocused();}}

function RegUtil(){}
RegUtil.genderFemale=1;RegUtil.genderMale=2;RegUtil.errorFields=[];RegUtil.DAY_FIELD='birthday_day';RegUtil.MONTH_FIELD='birthday_month';RegUtil.YEAR_FIELD='birthday_year';RegUtil.PASSWORD_FIELD='reg_passwd__';RegUtil.NAME_FIELD='name';RegUtil.FIRSTNAME_FIELD='firstname';RegUtil.LASTNAME_FIELD='lastname';RegUtil.EMAIL_FIELD='reg_email__';RegUtil.GENDER_FIELD='sex';RegUtil.errorFields[6]=RegUtil.PASSWORD_FIELD;RegUtil.errorFields[7]=RegUtil.PASSWORD_FIELD;RegUtil.errorFields[8]=RegUtil.PASSWORD_FIELD;RegUtil.errorFields[9]=RegUtil.PASSWORD_FIELD;RegUtil.errorFields[40]=RegUtil.PASSWORD_FIELD;RegUtil.errorFields[10]=RegUtil.NAME_FIELD;RegUtil.errorFields[48]=RegUtil.NAME_FIELD;RegUtil.errorFields[15]=RegUtil.YEAR_FIELD;RegUtil.errorFields[16]=RegUtil.EMAIL_FIELD;RegUtil.errorFields[18]=RegUtil.EMAIL_FIELD;RegUtil.errorFields[25]=RegUtil.EMAIL_FIELD;RegUtil.errorFields[26]=RegUtil.EMAIL_FIELD;RegUtil.errorFields[27]=RegUtil.EMAIL_FIELD;RegUtil.errorFields[37]=RegUtil.EMAIL_FIELD;RegUtil.errorFields[43]=RegUtil.GENDER_FIELD;RegUtil.getInstance=function(){if(!RegUtil._instance){RegUtil._instance=new RegUtil();}
return RegUtil._instance;}
RegUtil.prototype.get_captcha=function(){if($('captcha_response').value){return this.finish_captcha();}
if(this.validate_data()){this.hide_error();this.show_captcha();}}
RegUtil.prototype.register_no_captcha=function(){if(this.validate_data()){this.register();}}
RegUtil.prototype.ajax_validate_data=function(validation_rules,confirmation_node,redirect){var reg=this;onDone=function(asyncResponse){hide('async_status');hide('captcha_async_status');var payload=asyncResponse.getPayload();if(payload['redirect']){window.location.href=payload['redirect'];}else if(payload['field_validation_succeeded']){reg.hide_error();reg.show_captcha();}else if(payload['bad_captcha']){DOM.setContent($('outer_captcha_box'),HTML(payload['html']));reg.show_error('captcha_response',payload['error']);}else if(payload['tooyoung']){DOM.setContent($(confirmation_node),HTML(payload['html']));}else if(payload['registration_succeeded']){if(redirect){var form=$('confirmation_email_form');var field=$('confirmation_email');field.value=payload['email'];form.submit();}else{DOM.setContent($(confirmation_node),HTML(payload['html']));}
CSS.setStyle($('fb_menubar_aux'),'visibility','hidden');}else{if(ge(RegUtil.FIRSTNAME_FIELD)){RegUtil.errorFields[10]=[RegUtil.FIRSTNAME_FIELD,RegUtil.LASTNAME_FIELD];}
var field=RegUtil.errorFields[payload['error_code']];reg.show_error(field,payload['error']);}}
var reg_form=$('reg');var data=serialize_form(reg_form);if(validation_rules&&validation_rules['ignore']){data['ignore']=validation_rules['ignore'].join('|');}
show('async_status');show('captcha_async_status');new AsyncRequest().setURI('/ajax/register.php').setData(data).setReadOnly(true).setHandler(onDone).send();}
RegUtil.prototype.validate_data=function(){this.hide_error();var reg_data={'fullname':this.get_full_name(),'firstname':ge('firstname')?$('firstname').value:'','lastname':ge('lastname')?$('lastname').value:'','month':$(RegUtil.monthField).value,'day':$(RegUtil.dayField).value,'year':$(RegUtil.yearField).value,'email':this.normalize_email($('reg_email__').value),'gender':$('sex').value};if(ge('reg_instance')){reg_data['reg_instance']=$('reg_instance').value;}
var pwd=this.normalize_password($('reg_passwd__').value),pwd2=ge('reg_passwd2__')?this.normalize_password($('reg_passwd2__').value):undefined;var error_code=null;error_code=this.validate_name(reg_data['fullname'])||this.validate_birthday(reg_data['month'],reg_data['day'],reg_data['year'])||this.validate_email(reg_data['email'])||this.validate_password(pwd,pwd2)||this.validate_gender(reg_data['gender']);reg_data['error_code']=error_code||-1;var req=new AsyncRequest().setURI('/ajax/register/logging.php').setData(reg_data).setReadOnly(true).send();return!error_code;}
RegUtil.prototype.finish_captcha=function(){if($('captcha_response').value){this.register();}else{this.show_error('captcha_response',_tx("You didn't correctly type the text in the box."));return;}}
RegUtil.prototype.register=function(){this.show_progress();$('reg').submit();}
RegUtil.prototype.show_captcha=function(){this.hide_reg_form();create_captcha();show('reg_captcha');CSS.removeClass($('tos_container'),'hidden_elem');if(ge('reg_pages_msg')){hide($('reg_pages_msg'));}
if(ge('reg_captcha_buttons')){show('reg_captcha_buttons');}
if(ge('captcha_buttons')){show('captcha_buttons');}
try{$('captcha_response').focus();}catch(ignore){}}
RegUtil.prototype.hide_captcha=function(){hide('reg_captcha');CSS.addClass($('tos_container'),'hidden_elem');if(ge('reg_captcha_buttons')){hide('reg_captcha_buttons');}
if(ge('captcha_buttons')){hide('captcha_buttons');}
this.hide_error();}
RegUtil.prototype.show_progress=function(msg){this.hide_error();this.hide_reg_form();this.hide_captcha();if(msg){DOM.setContent($('progress_msg'),HTML(msg));}
show('reg_progress');}
RegUtil.prototype.hide_progress=function(){hide('reg_progress');}
RegUtil.prototype.attach_error_to_field=function(field,msg){var field_nodes=[];var error_class='UIErrorFlag';if(field instanceof Array){error_class+=' UIErrorFlag_MultiField';for(var k=0;k<field.length;k++){field_nodes[k]=$(field[k]);}}else{field_nodes[0]=$(field);}
var error_div=$N('div',{className:'UIErrorFlag_Inner'});error_div.innerHTML=msg;var inline=$N('div',{className:error_class},error_div);var position=(field_nodes[0].parentNode.offsetWidth)+8;var start_pos=position+'px';var end_pos=(position+7)+'px';var direction='left';if(intl_locale_is_rtl()){direction='right';inline.style.right=end_pos;}else{inline.style.left=end_pos;}
DOM.insertAfter(field_nodes[0],inline);for(var k=0;k<field_nodes.length;k++){CSS.addClass(field_nodes[k].parentNode,'error_field');}
animation(inline).from(direction,end_pos).to(direction,start_pos).duration(300).ease(function(p){return-1*Math.sin(11*p);}).go();}
RegUtil.prototype.show_error=function(field,msg){if(field==undefined){field='';}
if(ge('reg_pages_msg')){CSS.addClass($('reg_pages_msg'),'hidden_elem');}
var is_reg_page=CSS.hasClass(document.body,'registration');if(field&&is_reg_page){this.hide_error();this.attach_error_to_field(field,msg);}
if(field){if(field=='captcha_response'){this.show_captcha();}else{this.show_reg_form();}
try{$(field).focus();}catch(ignore){}}
if(!is_reg_page||!field){var reg_error=$('reg_error');var reg_error_inner=$('reg_error_inner');try{if(ge('name')){$('name').focus();}else{$('firstname').focus();}}catch(ignore){}
if(field!='captcha_response'){this.show_reg_form();}
if(typeof animation=='function'){DOM.setContent(reg_error_inner,HTML(msg));CSS.setOpacity(reg_error,0);animation(reg_error).show().to('height','auto').duration(100).checkpoint().from('opacity',0).to('opacity',1.0).duration(400).go();}else{show(reg_error);}}}
RegUtil.prototype.hide_error=function(){if(shown($('reg_error'))&&CSS.getOpacity($('reg_error'))>0){hide($('reg_error'));}
var error_containers=DOM.scry(document,'div.error_field');error_containers.each(function(c){CSS.removeClass(c,'error_field');});var error_flags=DOM.scry(document,'div.UIErrorFlag');error_flags.each(function(e){DOM.remove(e);});}
RegUtil.prototype.show_reg_form=function(){show('reg_form_box');if(ge('reg_pages_msg')){show($('reg_pages_msg'));}}
RegUtil.prototype.hide_reg_form=function(){hide('reg_form_box');}
RegUtil.prototype.normalize_name=function(name){name=name.replace(/^\s+|\s+$/g,'');name=name.replace(/\s+/g,' ');return name;}
RegUtil.prototype.normalize_email=function(email){return email;}
RegUtil.prototype.normalize_password=function(pwd){return pwd;}
RegUtil.prototype.validate_name=function(name,allow_empty_name){var kMinWords=2;var kMaxWords=4;var words=name?name.split(' '):[];var error_str=null;var error_code=null;if(!name){if(allow_empty_name){return true;}
error_str=_tx("Please enter your full name.");}else if(ge('firstname')&&(!$('firstname').value||!$('lastname').value)){error_str=_tx("You must provide your full name.");}else if(words.length==2&&words[0]==words[1]){error_str=_tx("You must provide your full name.");}else if(words.length>kMaxWords){error_str=_tx("The name contains too many words.");}
if(!error_str){for(word in words){len=word.length
if(len==1){continue;}
c=word[len-1];if('A'<=c&&c<='Z'){error_str=_tx("The name contains too many capital letters.");}}}
if(error_str){this.show_error('name',error_str);error_code=10;}
return error_code;}
RegUtil.prototype.validate_email=function(email){var error_str=null;var error_code=null;if(!email){error_str=_tx("Please enter your email address");error_code=12;}
else if(email.indexOf('@')==-1){error_str=_tx("Please enter a valid email address");error_code=16;}else{var email_parts=email.split('@');var domain=email_parts[1];if(domain=='facebook.com'){error_str=_tx("Please enter your personal email address.");error_code=50;}}
if(error_str)
this.show_error('reg_email__',error_str);return error_code;}
RegUtil.prototype.validate_gender=function(gender){var error_str=null;var error_code=null;if(gender!=RegUtil.genderMale&&gender!=RegUtil.genderFemale){error_str=_tx("Please select either Male or Female.");error_code=43;}
if(error_str){this.show_error('sex',error_str);}
return error_code;}
RegUtil.prototype.validate_password=function(pwd,pwd2){var kMinLength=6;var kDisallowedWords=['password','facebook'];var error_str=name=null;var error_code=null;if(!pwd){error_str=_tx("Please create a password to use on Facebook");error_code=6;}else if(pwd.length<kMinLength){error_str=_tx("Your password must be at least 6 characters long.");error_code=8;}else if(pwd2!=undefined&&pwd!=pwd2){error_str=_tx("Your passwords do not match. Please try again.");error_code=40;}else{var name=this.get_full_name();var names=name.toLowerCase().split(' ');var disallowed=names.concat(kDisallowedWords);for(var i=0;i<disallowed.length;++i){if(pwd.toLowerCase()==disallowed[i]){error_str=_tx("Your password should be more secure.");error_code=9;break;}}}
if(error_str)
this.show_error('reg_passwd__',error_str);return error_code;}
RegUtil.prototype.get_full_name=function(){if(ge('name')){return this.normalize_name($('name').value);}
return this.normalize_name($('firstname').value+' '+
$('lastname').value);}
RegUtil.prototype.validate_birthday=function(month,day,year){var error_str=null;var error_code=null;if(month==-1||day==-1||year==-1){error_str=_tx("Please enter your full birthday.");}else if(year<=1910){error_str=_tx("Please enter your real birthday.");}
if(error_str){this.show_error(RegUtil.monthField,error_str);error_code=15;}
return error_code;}
RegUtil.prototype.show_birthday_help=function(){new Dialog().setClassName('birthday_warning_popup').setTitle(_tx("Why do I need to provide my birthday?")).setBody(_tx("Facebook requires all users to provide their real date of birth as both a safety precaution and as a means of preserving the integrity of the site. You will be able to hide this information from your profile if you wish.")+'<br /><br />'+
_tx("You are about to create a personal account. If you are here to represent your band, business, or product you should first")+' <a href="/pages/create.php" title="Create a Page">'+
_tx("create a Facebook Page")+'</a>.').setButtons([Dialog.OK]).show();}
RegUtil.prototype.show_reg_dialog=function(){var req=new AsyncRequest().setURI('/ajax/simple_reg.php').setReadOnly(true);new Dialog().setAsync(req).show();}
RegUtil.prototype.set_topper_content=function(topper_html){DOM.replace($('UIContentTopper'),HTML(topper_html));}
RegUtil.prototype.show_reg_area=function(){CSS.removeClass($('simple_registration_container'),'hidden_elem');}
RegUtil.prototype.hide_reg_area=function(){CSS.addClass($('simple_registration_container'),'hidden_elem');}
RegUtil.prototype.show_openid_area=function(){CSS.removeClass($('openid_welcome_area'),'hidden_elem');}
RegUtil.prototype.hide_openid_area=function(){CSS.addClass($('openid_welcome_area'),'hidden_elem');}
RegUtil.prototype.set_form_field=function(field,field_value){if(ge(field)){$(field).value=field_value;}}
RegUtil.prototype.set_openid_field=function(openid_token_value){$('openid_token').value=openid_token_value;}
function RegKeyPressListen(is_invite_landing_test){var reg_form_box=ge('reg_form_box');if(reg_form_box){reg_form_box.listen('keypress',function(event){if(event.keyCode==KEYS.RETURN&&shown(reg_form_box)){if(is_invite_landing_test){RegUtil.getInstance().ajax_validate_data({ignore:['captcha']});}else{RegUtil.getInstance().get_captcha();}
return false;}});}}
function CaptchaBoxKeyPressListen(is_invite_landing_test,confirmation_node,redirect){var reg_captcha=ge('reg_captcha');if(reg_captcha){reg_captcha.listen('keypress',function(event){if(event.keyCode==KEYS.RETURN&&shown(reg_captcha)){if(is_invite_landing_test){RegUtil.getInstance().ajax_validate_data(null,confirmation_node,redirect);}else{RegUtil.getInstance().finish_captcha();}
return false;}});}}
function regform_listen_focus(reg_form,action){var reg_form_box=ge(reg_form);if(reg_form_box){var reg_instance='';if(ge('reg_instance')){reg_instance=$('reg_instance').value;}
log_fnc=fireonce(function(){new AsyncRequest().setURI('/ajax/register/logging.php').setData({action:action,reg_instance:reg_instance}).setOption('asynchronous',false).setReadOnly(true).send();});Event.listen(reg_form_box,'click',log_fnc);Event.listen(reg_form_box,'keypress',log_fnc);}}

if (window.Bootloader) { Bootloader.done(["js\/2wbl1xghlbcw44wc.pkg.js"]); }