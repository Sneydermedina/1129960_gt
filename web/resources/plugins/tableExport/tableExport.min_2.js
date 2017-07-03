/*
 tableExport.jquery.plugin

 Copyright (c) 2015,2016 hhurz, https://github.com/hhurz/tableExport.jquery.plugin
 Original work Copyright (c) 2014 Giri Raj, https://github.com/kayalshri/

 Licensed under the MIT License, http://opensource.org/licenses/mit-license
*/
(function(c){c.fn.extend({tableExport:function(u){function R(b){var a=[];c(b).find("thead").first().find("th").each(function(b,d){void 0!==c(d).attr("data-field")?a[b]=c(d).attr("data-field"):a[b]=b.toString()});return a}function x(b,h,e,d,y){if(-1==c.inArray(e,a.ignoreRow)&&-1==c.inArray(e-d,a.ignoreRow)){var g=c(b).filter(function(){return"none"!=c(this).data("tableexport-display")&&(c(this).is(":visible")||"always"==c(this).data("tableexport-display")||"always"==c(this).closest("table").data("tableexport-display"))}).find(h),
t=0;g.each(function(b){if("always"==c(this).data("tableexport-display")||"none"!=c(this).css("display")&&"hidden"!=c(this).css("visibility")&&"none"!=c(this).data("tableexport-display")){var d=b,h=!1;0<a.ignoreColumn.length&&("string"==typeof a.ignoreColumn[0]?H.length>d&&"undefined"!=typeof H[d]&&-1!=c.inArray(H[d],a.ignoreColumn)&&(h=!0):"number"!=typeof a.ignoreColumn[0]||-1==c.inArray(d,a.ignoreColumn)&&-1==c.inArray(d-g.length,a.ignoreColumn)||(h=!0));if(!1===h&&"function"===typeof y){var h=
0,m,f=0;if("undefined"!=typeof A[e]&&0<A[e].length)for(d=0;d<=b;d++)"undefined"!=typeof A[e][d]&&(y(null,e,d),delete A[e][d],b++);c(this).is("[colspan]")&&(h=parseInt(c(this).attr("colspan")),t+=0<h?h-1:0);c(this).is("[rowspan]")&&(f=parseInt(c(this).attr("rowspan")));y(this,e,b);for(d=0;d<h-1;d++)y(null,e,b+d);if(f)for(m=1;m<f;m++)for("undefined"==typeof A[e+m]&&(A[e+m]=[]),A[e+m][b+t]="",d=1;d<h;d++)A[e+m][b+t-d]=""}}});if("undefined"!=typeof A[e]&&0<A[e].length)for(b=0;b<=A[e].length;b++)"undefined"!=
typeof A[e][b]&&(y(null,e,b),delete A[e][b])}}function aa(b){!0===a.consoleLog&&console.log(b.output());if("string"===a.outputMode)return b.output();if("base64"===a.outputMode)return F(b.output());if("window"===a.outputMode)window.open(URL.createObjectURL(b.output("blob")));else try{var h=b.output("blob");saveAs(h,a.fileName+".pdf")}catch(e){C(a.fileName+".pdf","data:application/pdf;base64,",b.output())}}function ba(b,a,e){var d=0;"undefined"!=typeof e&&(d=e.colspan);if(0<=d){for(var h=b.width,c=
b.textPos.x,t=a.table.columns.indexOf(a.column),m=1;m<d;m++)h+=a.table.columns[t+m].width;1<d&&("right"===b.styles.halign?c=b.textPos.x+h-b.width:"center"===b.styles.halign&&(c=b.textPos.x+(h-b.width)/2));b.width=h;b.textPos.x=c;"undefined"!=typeof e&&1<e.rowspan&&(b.height*=e.rowspan);if("middle"===b.styles.valign||"bottom"===b.styles.valign)e=("string"===typeof b.text?b.text.split(/\r\n|\r|\n/g):b.text).length||1,2<e&&(b.textPos.y-=(2-1.15)/2*a.row.styles.fontSize*(e-2)/3);return!0}return!1}function ca(b,
a,e){"undefined"!=typeof e.images&&a.each(function(){var a=c(this).children();if(c(this).is("img")){var h=da(this.src);e.images[h]={url:this.src,src:this.src}}"undefined"!=typeof a&&0<a.length&&ca(b,a,e)})}function ja(b,a){function h(b){if(b.url){var d=new Image;c=++g;d.crossOrigin="Anonymous";d.onerror=d.onload=function(){if(d.complete&&(0===d.src.indexOf("data:image/")&&(d.width=b.width||d.width||0,d.height=b.height||d.height||0),d.width+d.height)){var h=document.createElement("canvas"),e=h.getContext("2d");
h.width=d.width;h.height=d.height;e.drawImage(d,0,0);b.src=h.toDataURL("image/jpeg")}--g||a(c)};d.src=b.url}}var d,c=0,g=0;if("undefined"!=typeof b.images)for(d in b.images)b.images.hasOwnProperty(d)&&h(b.images[d]);(d=g)||(a(c),d=void 0);return d}function ea(b,h,e){h.each(function(){var d=c(this).children();if(c(this).is("div")){var h=N(E(this,"background-color"),[255,255,255]),g=N(E(this,"border-top-color"),[0,0,0]),t=O(this,"border-top-width",a.jspdf.unit),m=this.getBoundingClientRect(),f=this.offsetLeft*
e.dw,k=this.offsetTop*e.dh,l=m.width*e.dw,m=m.height*e.dh;e.doc.setDrawColor.apply(void 0,g);e.doc.setFillColor.apply(void 0,h);e.doc.setLineWidth(t);e.doc.rect(b.x+f,b.y+k,l,m,t?"FD":"F")}else c(this).is("img")&&"undefined"!=typeof e.images&&(k=da(this.src),h=e.images[k],"undefined"!=typeof h&&(g=b.width/b.height,t=this.width/this.height,f=b.width,l=b.height,k=0,t<g?(l=Math.min(b.height,this.height),f=this.width*l/this.height):t>g&&(f=Math.min(b.width,this.width),l=this.height*f/this.width),l<b.height&&
(k=(b.height-l)/2),e.doc.addImage(h.src,b.textPos.x,b.y+k,f,l),b.textPos.x+=f));"undefined"!=typeof d&&0<d.length&&ea(b,d,e)})}function S(b,a,e){return b.replace(new RegExp(a.replace(/([.*+?^=!:${}()|\[\]\/\\])/g,"\\$1"),"g"),e)}function ka(b){b=S(b||"0",a.numbers.html.decimalMark,".");b=S(b,a.numbers.html.thousandsSeparator,"");return"number"===typeof b||!1!==jQuery.isNumeric(b)?b:!1}function w(b,h,e){var d="";if(null!==b){var y=c(b),g;y[0].hasAttribute("data-tableexport-value")?g=y.data("tableexport-value"):
(g=y.html(),""!=g&&(b=c.parseHTML(g),g="",c.each(b,function(){if(c(this).is("input"))g+=y.find("input").val();else if(c(this).is("select"))g+=y.find("select option:selected").text();else return g+=y.html(),!1})));"function"===typeof a.onCellHtmlData&&(g=a.onCellHtmlData(y,h,e,g));if(!0===a.htmlContent)d=c.trim(g);else{var t=g.replace(/\n/g,"\u2028").replace(/<br\s*[\/]?>/gi,"\u2060");b=c("<div/>").html(t).contents();t="";c.each(b.text().split("\u2028"),function(b,a){0<b&&(t+=" ");t+=c.trim(a)});c.each(t.split("\u2060"),
function(b,a){0<b&&(d+="\n");d+=c.trim(a).replace(/\u00AD/g,"")});if(a.numbers.html.decimalMark!=a.numbers.output.decimalMark||a.numbers.html.thousandsSeparator!=a.numbers.output.thousandsSeparator)if(b=ka(d),!1!==b){var m=(""+b).split(".");1==m.length&&(m[1]="");var f=3<m[0].length?m[0].length%3:0,d=(0>b?"-":"")+(a.numbers.output.thousandsSeparator?(f?m[0].substr(0,f)+a.numbers.output.thousandsSeparator:"")+m[0].substr(f).replace(/(\d{3})(?=\d)/g,"$1"+a.numbers.output.thousandsSeparator):m[0])+(m[1].length?
a.numbers.output.decimalMark+m[1]:"")}}!0===a.escape&&(d=escape(d));"function"===typeof a.onCellData&&(d=a.onCellData(y,h,e,d))}return d}function la(b,a,e){return a+"-"+e.toLowerCase()}function N(b,a){var h=/^rgb\((\d{1,3}),\s*(\d{1,3}),\s*(\d{1,3})\)$/.exec(b),d=a;h&&(d=[parseInt(h[1]),parseInt(h[2]),parseInt(h[3])]);return d}function fa(b){var a=E(b,"text-align"),e=E(b,"font-weight"),d=E(b,"font-style"),f="";"start"==a&&(a="rtl"==E(b,"direction")?"right":"left");700<=e&&(f="bold");"italic"==d&&
(f+=d);""===f&&(f="normal");a={style:{align:a,bcolor:N(E(b,"background-color"),[255,255,255]),color:N(E(b,"color"),[0,0,0]),fstyle:f},colspan:parseInt(c(b).attr("colspan"))||0,rowspan:parseInt(c(b).attr("rowspan"))||0};null!==b&&(b=b.getBoundingClientRect(),a.rect={width:b.width,height:b.height});return a}function E(b,a){try{return window.getComputedStyle?(a=a.replace(/([a-z])([A-Z])/,la),window.getComputedStyle(b,null).getPropertyValue(a)):b.currentStyle?b.currentStyle[a]:b.style[a]}catch(e){}return""}
function O(b,a,e){a=E(b,a).match(/\d+/);if(null!==a){a=a[0];b=b.parentElement;var d=document.createElement("div");d.style.overflow="hidden";d.style.visibility="hidden";b.appendChild(d);d.style.width=100+e;e=100/d.offsetWidth;b.removeChild(d);return a*e}return 0}function T(){if(!(this instanceof T))return new T;this.SheetNames=[];this.Sheets={}}function ma(a){for(var b=new ArrayBuffer(a.length),e=new Uint8Array(b),d=0;d!=a.length;++d)e[d]=a.charCodeAt(d)&255;return b}function na(a){for(var b={},e=
{s:{c:1E7,r:1E7},e:{c:0,r:0}},d=0;d!=a.length;++d)for(var c=0;c!=a[d].length;++c){e.s.r>d&&(e.s.r=d);e.s.c>c&&(e.s.c=c);e.e.r<d&&(e.e.r=d);e.e.c<c&&(e.e.c=c);var g={v:a[d][c]};if(null!==g.v){var t=XLSX.utils.encode_cell({c:c,r:d});if("number"===typeof g.v)g.t="n";else if("boolean"===typeof g.v)g.t="b";else if(g.v instanceof Date){g.t="n";g.z=XLSX.SSF._table[14];var m=g,f;f=(Date.parse(g.v)-new Date(Date.UTC(1899,11,30)))/864E5;m.v=f}else g.t="s";b[t]=g}}1E7>e.s.c&&(b["!ref"]=XLSX.utils.encode_range(e));
return b}function da(a){var b=0,c,d,f;if(0===a.length)return b;c=0;for(f=a.length;c<f;c++)d=a.charCodeAt(c),b=(b<<5)-b+d,b|=0;return b}function C(a,c,e){var b=window.navigator.userAgent;if(!1!==a&&(0<b.indexOf("MSIE ")||b.match(/Trident.*rv\:11\./)))if(window.navigator.msSaveOrOpenBlob)window.navigator.msSaveOrOpenBlob(new Blob([e]),a);else{if(c=document.createElement("iframe"))document.body.appendChild(c),c.setAttribute("style","display:none"),c.contentDocument.open("txt/html","replace"),c.contentDocument.write(e),
c.contentDocument.close(),c.focus(),c.contentDocument.execCommand("SaveAs",!0,a),document.body.removeChild(c)}else if(b=document.createElement("a")){b.style.display="none";!1!==a?b.download=a:b.target="_blank";0<=c.toLowerCase().indexOf("base64,")?b.href=c+F(e):b.href=c+encodeURIComponent(e);document.body.appendChild(b);if(document.createEvent)null===P&&(P=document.createEvent("MouseEvents")),P.initEvent("click",!0,!1),b.dispatchEvent(P);else if(document.createEventObject)b.fireEvent("onclick");else if("function"==
typeof b.onclick)b.onclick();document.body.removeChild(b)}}function F(a){var b="",c,d,f,g,t,m,k=0;a=a.replace(/\x0d\x0a/g,"\n");d="";for(f=0;f<a.length;f++)g=a.charCodeAt(f),128>g?d+=String.fromCharCode(g):(127<g&&2048>g?d+=String.fromCharCode(g>>6|192):(d+=String.fromCharCode(g>>12|224),d+=String.fromCharCode(g>>6&63|128)),d+=String.fromCharCode(g&63|128));for(a=d;k<a.length;)c=a.charCodeAt(k++),d=a.charCodeAt(k++),f=a.charCodeAt(k++),g=c>>2,c=(c&3)<<4|d>>4,t=(d&15)<<2|f>>6,m=f&63,isNaN(d)?t=m=64:
isNaN(f)&&(m=64),b=b+"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(g)+"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(c)+"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(t)+"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(m);return b}var a={consoleLog:!1,csvEnclosure:'"',csvSeparator:",",csvUseBOM:!0,displayTableName:!1,escape:!1,excelstyles:[],fileName:"tableExport",htmlContent:!1,ignoreColumn:[],
ignoreRow:[],jsonScope:"all",jspdf:{orientation:"p",unit:"pt",format:"a4",margins:{left:20,right:10,top:10,bottom:10},autotable:{styles:{cellPadding:2,rowHeight:12,fontSize:8,fillColor:255,textColor:50,fontStyle:"normal",overflow:"ellipsize",halign:"left",valign:"middle"},headerStyles:{fillColor:[52,73,94],textColor:255,fontStyle:"bold",halign:"center"},alternateRowStyles:{fillColor:245},tableExport:{onAfterAutotable:null,onBeforeAutotable:null,onTable:null,outputImages:!0}}},numbers:{html:{decimalMark:".",
thousandsSeparator:","},output:{decimalMark:".",thousandsSeparator:","}},onCellData:null,onCellHtmlData:null,outputMode:"file",pdfmake:{enabled:!1},tbodySelector:"tr",tfootSelector:"tr",theadSelector:"tr",tableName:"myTableName",type:"csv",worksheetName:"xlsWorksheetName"},r=this,P=null,p=[],k=[],l=0,A=[],n="",H=[],z;c.extend(!0,a,u);H=R(r);if("csv"==a.type||"txt"==a.type){var D="",I=0,l=0,U=function(b,h,e){b.each(function(){n="";x(this,h,l,e+b.length,function(b,c,e){var d=n,g="";if(null!==b)if(b=
w(b,c,e),c=null===b||""===b?"":b.toString(),b instanceof Date)g=a.csvEnclosure+b.toLocaleString()+a.csvEnclosure;else if(g=S(c,a.csvEnclosure,a.csvEnclosure+a.csvEnclosure),0<=g.indexOf(a.csvSeparator)||/[\r\n ]/g.test(g))g=a.csvEnclosure+g+a.csvEnclosure;n=d+(g+a.csvSeparator)});n=c.trim(n).substring(0,n.length-1);0<n.length&&(0<D.length&&(D+="\n"),D+=n);l++});return b.length},I=I+U(c(r).find("thead").first().find(a.theadSelector),"th,td",I);c(r).find("tbody").each(function(){I+=U(c(this).find(a.tbodySelector),
"td,th",I)});a.tfootSelector.length&&U(c(r).find("tfoot").first().find(a.tfootSelector),"td,th",I);D+="\n";!0===a.consoleLog&&console.log(D);if("string"===a.outputMode)return D;if("base64"===a.outputMode)return F(D);if("window"===a.outputMode){C(!1,"data:text/"+("csv"==a.type?"csv":"plain")+";charset=utf-8,",D);return}try{z=new Blob([D],{type:"text/"+("csv"==a.type?"csv":"plain")+";charset=utf-8"}),saveAs(z,a.fileName+"."+a.type,"csv"!=a.type||!1===a.csvUseBOM)}catch(b){C(a.fileName+"."+a.type,"data:text/"+
("csv"==a.type?"csv":"plain")+";charset=utf-8,"+("csv"==a.type&&a.csvUseBOM?"\ufeff":""),D)}}else if("sql"==a.type){var l=0,v="INSERT INTO `"+a.tableName+"` (",p=c(r).find("thead").first().find(a.theadSelector);p.each(function(){x(this,"th,td",l,p.length,function(a,c,e){v+="'"+w(a,c,e)+"',"});l++;v=c.trim(v);v=c.trim(v).substring(0,v.length-1)});v+=") VALUES ";c(r).find("tbody").each(function(){k.push.apply(k,c(this).find(a.tbodySelector))});a.tfootSelector.length&&k.push.apply(k,c(r).find("tfoot").find(a.tfootSelector));
c(k).each(function(){n="";x(this,"td,th",l,p.length+k.length,function(a,c,e){n+="'"+w(a,c,e)+"',"});3<n.length&&(v+="("+n,v=c.trim(v).substring(0,v.length-1),v+="),");l++});v=c.trim(v).substring(0,v.length-1);v+=";";!0===a.consoleLog&&console.log(v);if("string"===a.outputMode)return v;if("base64"===a.outputMode)return F(v);try{z=new Blob([v],{type:"text/plain;charset=utf-8"}),saveAs(z,a.fileName+".sql")}catch(b){C(a.fileName+".sql","data:application/sql;charset=utf-8,",v)}}else if("json"==a.type){var J=
[],p=c(r).find("thead").first().find(a.theadSelector);p.each(function(){var a=[];x(this,"th,td",l,p.length,function(b,c,d){a.push(w(b,c,d))});J.push(a)});var V=[];c(r).find("tbody").each(function(){k.push.apply(k,c(this).find(a.tbodySelector))});a.tfootSelector.length&&k.push.apply(k,c(r).find("tfoot").find(a.tfootSelector));c(k).each(function(){var a={},h=0;x(this,"td,th",l,p.length+k.length,function(b,c,f){J.length?a[J[J.length-1][h]]=w(b,c,f):a[h]=w(b,c,f);h++});!1===c.isEmptyObject(a)&&V.push(a);
l++});u="";u="head"==a.jsonScope?JSON.stringify(J):"data"==a.jsonScope?JSON.stringify(V):JSON.stringify({header:J,data:V});!0===a.consoleLog&&console.log(u);if("string"===a.outputMode)return u;if("base64"===a.outputMode)return F(u);try{z=new Blob([u],{type:"application/json;charset=utf-8"}),saveAs(z,a.fileName+".json")}catch(b){C(a.fileName+".json","data:application/json;charset=utf-8;base64,",u)}}else if("xml"===a.type){var l=0,B='<?xml version="1.0" encoding="utf-8"?>',B=B+"<tabledata><fields>",
p=c(r).find("thead").first().find(a.theadSelector);p.each(function(){x(this,"th,td",l,p.length,function(a,c,e){B+="<field>"+w(a,c,e)+"</field>"});l++});var B=B+"</fields><data>",ga=1;c(r).find("tbody").each(function(){k.push.apply(k,c(this).find(a.tbodySelector))});a.tfootSelector.length&&k.push.apply(k,c(r).find("tfoot").find(a.tfootSelector));c(k).each(function(){var a=1;n="";x(this,"td,th",l,p.length+k.length,function(b,c,d){n+="<column-"+a+">"+w(b,c,d)+"</column-"+a+">";a++});0<n.length&&"<column-1></column-1>"!=
n&&(B+='<row id="'+ga+'">'+n+"</row>",ga++);l++});B+="</data></tabledata>";!0===a.consoleLog&&console.log(B);if("string"===a.outputMode)return B;if("base64"===a.outputMode)return F(B);try{z=new Blob([B],{type:"application/xml;charset=utf-8"}),saveAs(z,a.fileName+".xml")}catch(b){C(a.fileName+".xml","data:application/xml;charset=utf-8;base64,",B)}}else if("excel"==a.type||"xls"==a.type||"word"==a.type||"doc"==a.type){u="excel"==a.type||"xls"==a.type?"excel":"word";var K="excel"==u?"xls":"doc",q='xmlns:x="urn:schemas-microsoft-com:office:'+
u+'"',G="";c(r).filter(function(){return"none"!=c(this).data("tableexport-display")&&(c(this).is(":visible")||"always"==c(this).data("tableexport-display"))}).each(function(){var b=c(this);l=0;H=R(this);G+="<table><thead>";p=b.find("thead").first().find(a.theadSelector);p.each(function(){n="";x(this,"th,td",l,p.length,function(b,e,d){if(null!==b){var f="";n+="<th";for(var g in a.excelstyles)if(a.excelstyles.hasOwnProperty(g)){var h=c(b).css(a.excelstyles[g]);""!==h&&"0px none rgb(0, 0, 0)"!=h&&"rgba(0, 0, 0, 0)"!=
h&&(f+=""===f?'style="':";",f+=a.excelstyles[g]+":"+h)}""!==f&&(n+=" "+f+'"');c(b).is("[colspan]")&&(n+=' colspan="'+c(b).attr("colspan")+'"');c(b).is("[rowspan]")&&(n+=' rowspan="'+c(b).attr("rowspan")+'"');n+=">"+w(b,e,d)+"</th>"}});0<n.length&&(G+="<tr>"+n+"</tr>");l++});G+="</thead><tbody>";b.find("tbody").each(function(){k.push.apply(k,c(this).find(a.tbodySelector))});a.tfootSelector.length&&k.push.apply(k,b.find("tfoot").find(a.tfootSelector));c(k).each(function(){var b=c(this);n="";x(this,
"td,th",l,p.length+k.length,function(e,d,f){if(null!==e){var g="",h=c(e).data("tableexport-msonumberformat");"undefined"==typeof h&&"function"===typeof a.onMsoNumberFormat&&(h=a.onMsoNumberFormat(e,d,f));"undefined"!=typeof h&&""!==h&&(g="style=\"mso-number-format:'"+h+"'");for(var m in a.excelstyles)a.excelstyles.hasOwnProperty(m)&&(h=c(e).css(a.excelstyles[m]),""===h&&(h=b.css(a.excelstyles[m])),""!==h&&"0px none rgb(0, 0, 0)"!=h&&"rgba(0, 0, 0, 0)"!=h&&(g+=""===g?'style="':";",g+=a.excelstyles[m]+
":"+h));n+="<td";""!==g&&(n+=" "+g+'"');c(e).is("[colspan]")&&(n+=' colspan="'+c(e).attr("colspan")+'"');c(e).is("[rowspan]")&&(n+=' rowspan="'+c(e).attr("rowspan")+'"');n+=">"+w(e,d,f).replace(/\n/g,"<br>")+"</td>"}});0<n.length&&(G+="<tr>"+n+"</tr>");l++});a.displayTableName&&(G+="<tr><td></td></tr><tr><td></td></tr><tr><td>"+w(c("<p>"+a.tableName+"</p>"))+"</td></tr>");G+="</tbody></table>";!0===a.consoleLog&&console.log(G)});q='<html xmlns:o="urn:schemas-microsoft-com:office:office" '+q+' xmlns="http://www.w3.org/TR/REC-html40">'+
('<meta http-equiv="content-type" content="application/vnd.ms-'+u+'; charset=UTF-8">')+"<head>";"excel"===u&&(q+="\x3c!--[if gte mso 9]>",q+="<xml>",q+="<x:ExcelWorkbook>",q+="<x:ExcelWorksheets>",q+="<x:ExcelWorksheet>",q+="<x:Name>",q+=a.worksheetName,q+="</x:Name>",q+="<x:WorksheetOptions>",q+="<x:DisplayGridlines/>",q+="</x:WorksheetOptions>",q+="</x:ExcelWorksheet>",q+="</x:ExcelWorksheets>",q+="</x:ExcelWorkbook>",q+="</xml>",q+="<![endif]--\x3e");q+="<style>br {mso-data-placement:same-cell;}</style>";
q+="</head>";q+="<body>";q+=G;q+="</body>";q+="</html>";!0===a.consoleLog&&console.log(q);if("string"===a.outputMode)return q;if("base64"===a.outputMode)return F(q);try{z=new Blob([q],{type:"application/vnd.ms-"+a.type}),saveAs(z,a.fileName+"."+K)}catch(b){C(a.fileName+"."+K,"data:application/vnd.ms-"+u+";base64,",q)}}else if("xlsx"==a.type){var W=[],X=[],l=0,k=c(r).find("thead").first().find(a.theadSelector);c(r).find("tbody").each(function(){k.push.apply(k,c(this).find(a.tbodySelector))});a.tfootSelector.length&&
k.push.apply(k,c(r).find("tfoot").find(a.tfootSelector));c(k).each(function(){var a=[];x(this,"th,td",l,k.length,function(b,c,d){if("undefined"!==typeof b&&null!==b){var e=parseInt(b.getAttribute("colspan")),g=parseInt(b.getAttribute("rowspan"));b=w(b,c,d);""!==b&&b==+b&&(b=+b);X.forEach(function(b){if(l>=b.s.r&&l<=b.e.r&&a.length>=b.s.c&&a.length<=b.e.c)for(var c=0;c<=b.e.c-b.s.c;++c)a.push(null)});if(g||e)e=e||1,X.push({s:{r:l,c:a.length},e:{r:l+(g||1)-1,c:a.length+e-1}});a.push(""!==b?b:null);
if(e)for(g=0;g<e-1;++g)a.push(null)}});W.push(a);l++});u=new T;K=na(W);K["!merges"]=X;u.SheetNames.push(a.worksheetName);u.Sheets[a.worksheetName]=K;u=XLSX.write(u,{bookType:a.type,bookSST:!1,type:"binary"});try{z=new Blob([ma(u)],{type:"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=UTF-8"}),saveAs(z,a.fileName+"."+a.type)}catch(b){C(a.fileName+"."+a.type,"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=UTF-8",W)}}else if("png"==a.type)html2canvas(c(r)[0]).then(function(b){b=
b.toDataURL();for(var c=atob(b.substring(22)),e=new ArrayBuffer(c.length),d=new Uint8Array(e),f=0;f<c.length;f++)d[f]=c.charCodeAt(f);!0===a.consoleLog&&console.log(c);if("string"===a.outputMode)return c;if("base64"===a.outputMode)return F(b);if("window"===a.outputMode)window.open(b);else try{z=new Blob([e],{type:"image/png"}),saveAs(z,a.fileName+".png")}catch(g){C(a.fileName+".png","data:image/png,",b)}});else if("pdf"==a.type)if(!0===a.pdfmake.enabled){var Y=[],Z=[],l=0,p=c(this).find("thead").first().find(a.theadSelector);
p.each(function(){var a=[];x(this,"th,td",l,p.length,function(b,c,f){a.push(w(b,c,f))});a.length&&Z.push(a);for(var c=Y.length;c<a.length;c++)Y.push("*");l++});c(this).find("tbody").each(function(){k.push.apply(k,c(this).find(a.tbodySelector))});a.tfootSelector.length&&k.push.apply(k,c(this).find("tfoot").find(a.tfootSelector));c(k).each(function(){var a=[];x(this,"td,th",l,p.length+k.length,function(b,c,d){a.push(w(b,c,d))});a.length&&Z.push(a);l++});pdfMake.createPdf({pageOrientation:"landscape",
content:[{table:{headerRows:p.length,widths:Y,body:Z}}]}).getBuffer(function(b){try{var c=new Blob([b],{type:"application/pdf"});saveAs(c,a.fileName+".pdf")}catch(e){C(a.fileName+".pdf","data:application/pdf;base64,",b)}})}else if(!1===a.jspdf.autotable){u={dim:{w:O(c(r).first().get(0),"width","mm"),h:O(c(r).first().get(0),"height","mm")},pagesplit:!1};var ha=new jsPDF(a.jspdf.orientation,a.jspdf.unit,a.jspdf.format);ha.addHTML(c(r).first(),a.jspdf.margins.left,a.jspdf.margins.top,u,function(){aa(ha)})}else{var f=
a.jspdf.autotable.tableExport;if("string"===typeof a.jspdf.format&&"bestfit"===a.jspdf.format.toLowerCase()){var L={a0:[2383.94,3370.39],a1:[1683.78,2383.94],a2:[1190.55,1683.78],a3:[841.89,1190.55],a4:[595.28,841.89]},Q="",M="",ia=0;c(r).filter(":visible").each(function(){if("none"!=c(this).css("display")){var a=O(c(this).get(0),"width","pt");if(a>ia){a>L.a0[0]&&(Q="a0",M="l");for(var f in L)L.hasOwnProperty(f)&&L[f][1]>a&&(Q=f,M="l",L[f][0]>a&&(M="p"));ia=a}}});a.jspdf.format=""===Q?"a4":Q;a.jspdf.orientation=
""===M?"w":M}f.doc=new jsPDF(a.jspdf.orientation,a.jspdf.unit,a.jspdf.format);!0===f.outputImages&&(f.images={});"undefined"!=typeof f.images&&(c(r).filter(function(){return"none"!=c(this).data("tableexport-display")&&(c(this).is(":visible")||"always"==c(this).data("tableexport-display"))}).each(function(){var b=0;p=c(this).find("thead").find(a.theadSelector);c(this).find("tbody").each(function(){k.push.apply(k,c(this).find(a.tbodySelector))});a.tfootSelector.length&&k.push.apply(k,c(this).find("tfoot").find(a.tfootSelector));
c(k).each(function(){x(this,"td,th",p.length+b,p.length+k.length,function(a,b,d){"undefined"!==typeof a&&null!==a&&(b=c(a).children(),"undefined"!=typeof b&&0<b.length&&ca(a,b,f))});b++})}),p=[],k=[]);ja(f,function(b){c(r).filter(function(){return"none"!=c(this).data("tableexport-display")&&(c(this).is(":visible")||"always"==c(this).data("tableexport-display"))}).each(function(){var b,e=0;H=R(this);f.columns=[];f.rows=[];f.rowoptions={};if("function"===typeof f.onTable&&!1===f.onTable(c(this),a))return!0;
a.jspdf.autotable.tableExport=null;var d=c.extend(!0,{},a.jspdf.autotable);a.jspdf.autotable.tableExport=f;d.margin={};c.extend(!0,d.margin,a.jspdf.margins);d.tableExport=f;"function"!==typeof d.beforePageContent&&(d.beforePageContent=function(a){1==a.pageCount&&a.table.rows.concat(a.table.headerRow).forEach(function(b){0<b.height&&(b.height+=(2-1.15)/2*b.styles.fontSize,a.table.height+=(2-1.15)/2*b.styles.fontSize)})});"function"!==typeof d.createdHeaderCell&&(d.createdHeaderCell=function(a,b){a.styles=
c.extend({},b.row.styles);if("undefined"!=typeof f.columns[b.column.dataKey]){var e=f.columns[b.column.dataKey];if("undefined"!=typeof e.rect){var g;a.contentWidth=e.rect.width;if("undefined"==typeof f.heightRatio||0===f.heightRatio)g=b.row.raw[b.column.dataKey].rowspan?b.row.raw[b.column.dataKey].rect.height/b.row.raw[b.column.dataKey].rowspan:b.row.raw[b.column.dataKey].rect.height,f.heightRatio=a.styles.rowHeight/g;g=b.row.raw[b.column.dataKey].rect.height*f.heightRatio;g>a.styles.rowHeight&&(a.styles.rowHeight=
g)}"undefined"!=typeof e.style&&!0!==e.style.hidden&&(a.styles.halign=e.style.align,"inherit"===d.styles.fillColor&&(a.styles.fillColor=e.style.bcolor),"inherit"===d.styles.textColor&&(a.styles.textColor=e.style.color),"inherit"===d.styles.fontStyle&&(a.styles.fontStyle=e.style.fstyle))}});"function"!==typeof d.createdCell&&(d.createdCell=function(a,b){var c=f.rowoptions[b.row.index+":"+b.column.dataKey];"undefined"!=typeof c&&"undefined"!=typeof c.style&&!0!==c.style.hidden&&(a.styles.halign=c.style.align,
"inherit"===d.styles.fillColor&&(a.styles.fillColor=c.style.bcolor),"inherit"===d.styles.textColor&&(a.styles.textColor=c.style.color),"inherit"===d.styles.fontStyle&&(a.styles.fontStyle=c.style.fstyle))});"function"!==typeof d.drawHeaderCell&&(d.drawHeaderCell=function(a,b){var c=f.columns[b.column.dataKey];return(!0!==c.style.hasOwnProperty("hidden")||!0!==c.style.hidden)&&0<=c.rowIndex?ba(a,b,c):!1});"function"!==typeof d.drawCell&&(d.drawCell=function(a,b){var c=f.rowoptions[b.row.index+":"+b.column.dataKey];
if(ba(a,b,c)){f.doc.rect(a.x,a.y,a.width,a.height,a.styles.fillStyle);if("undefined"!=typeof c&&"undefined"!=typeof c.kids&&0<c.kids.length){var d=a.height/c.rect.height;if(d>f.dh||"undefined"==typeof f.dh)f.dh=d;f.dw=a.width/c.rect.width;ea(a,c.kids,f)}f.doc.autoTableText(a.text,a.textPos.x,a.textPos.y,{halign:a.styles.halign,valign:a.styles.valign})}return!1});f.headerrows=[];p=c(this).find("thead").find(a.theadSelector);p.each(function(){b=0;f.headerrows[e]=[];x(this,"th,td",e,p.length,function(a,
c,d){var g=fa(a);g.title=w(a,c,d);g.key=b++;g.rowIndex=e;f.headerrows[e].push(g)});e++});0<e&&c.each(f.headerrows[e-1],function(){var a=this;1<e&&null===this.rect&&(a=f.headerrows[e-2][this.key]);null!==a&&f.columns.push(a)});var l=0;k=[];c(this).find("tbody").each(function(){k.push.apply(k,c(this).find(a.tbodySelector))});a.tfootSelector.length&&k.push.apply(k,c(this).find("tfoot").find(a.tfootSelector));c(k).each(function(){var a=[];b=0;x(this,"td,th",e,p.length+k.length,function(d,e,g){if("undefined"===
typeof f.columns[b]){var h={title:"",key:b,style:{hidden:!0}};f.columns.push(h)}"undefined"!==typeof d&&null!==d?(h=fa(d),h.kids=c(d).children()):(h=c.extend(!0,{},f.rowoptions[l+":"+(b-1)]),h.colspan=-1);f.rowoptions[l+":"+b++]=h;a.push(w(d,e,g))});a.length&&(f.rows.push(a),l++);e++});if("function"===typeof f.onBeforeAutotable)f.onBeforeAutotable(c(this),f.columns,f.rows,d);f.doc.autoTable(f.columns,f.rows,d);if("function"===typeof f.onAfterAutotable)f.onAfterAutotable(c(this),d);a.jspdf.autotable.startY=
f.doc.autoTableEndPosY()+d.margin.top});aa(f.doc);"undefined"!=typeof f.headerrows&&(f.headerrows.length=0);"undefined"!=typeof f.columns&&(f.columns.length=0);"undefined"!=typeof f.rows&&(f.rows.length=0);delete f.doc;f.doc=null})}return this}})})(jQuery);