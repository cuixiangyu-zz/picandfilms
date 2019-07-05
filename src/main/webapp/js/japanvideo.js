
    $(function(){
        /*公共部分
         * 导航栏
         * footer CopyRight
         */
        $(".headerpage").load("left.html");
		$(".footer-menu").load("footmenu.html");	
   var data = {"page":1};
   var oldurl = window.location.href;
   if(oldurl.indexOf("?")<=0){
   oldurl=1
   }else{
   oldurl = oldurl.slice(oldurl.indexOf("?")+13, oldurl.length);
   }
  
    $.ajax({
            url : "/picandfilms/gotonextjapanpage.do?currentPage="+oldurl,
            async : true,
            data:data,
            dataType : 'json',
            type : 'post',
            success : function(rtn, textStatus) {
                //业务控制
                var pagehtml = "";
 				for(var i = 0 ;i <rtn.japanvideoBaseinfo.length;i++){
 					pagehtml1="<dl class=\"col-xs-6 col-md-6\"><dt><a target=\"_blank\" href=\"#\" class=\"bq\">"+rtn.japanvideoBaseinfo[i].artist+"</a><a href=\"detail.html\"><img class=\"auto\" img src=\"/videocover/"+rtn.japanvideoBaseinfo[i].cover+".jpg alt=\"\"></a></dt><dd><a href=\"/artist.do?artist="+rtn.japanvideoBaseinfo[i].artist+"\">"+rtn.japanvideoBaseinfo[i].id+"</a></dd></dl>";
 					pagehtml+=pagehtml1; 
 				}
 				$("#doublepic").append(pagehtml);
 				var pagenum = "<div class=\"pagenum\"><ul class=\"pagination\" c><li><a href=\"/picandfilms/japanvideo.html?currentPage="+1+"\">«</li>";
 				if(rtn.currentPage<=5){
 					if(rtn.totalPage<10){
 					for(var i = 1 ;i <rtn.totalPage;i++){
 						if(rtn.currentPage==i){
 							var pagenum1="<li><a class=\"active\" href=\"#\">"+i+"</a></li>";
 							pagenum+=pagenum1;
 						}else{
 							var pagenum1="<li><a href=\"/picandfilms/japanvideo.html?currentPage="+i+"\">"+i+"</a></li>";
 							pagenum+=pagenum1;
 						}
 					
 					}
 					}else{
 					for(var i = 1 ;i <10;i++){
 						if(rtn.currentPage==i){
 							var pagenum1="<li><a class=\"active\" href=\"#\">"+i+"</a></li>";
 							pagenum+=pagenum1;
 						}else{
 							var pagenum1="<li><a href=\"/picandfilms/japanvideo.html?currentPage="+i+"\">"+i+"</a></li>";
 							pagenum+=pagenum1;
 						}
 					
 					}
 					}
 					
 					
 				}else{
 					if(rtn.currentPage+4>rtn.totalPage){
 					for(var i = rtn.currentPage-4 ;i <rtn.totalPage;i++){
 						if(rtn.currentPage==i){
 							var pagenum1="<li><a class=\"active\" href=\"#\">"+i+"</a></li>";
 							pagenum+=pagenum1;
 						}else{
 							var pagenum1="<li><a href=\"/picandfilms/japanvideo.html?currentPage="+i+"\">"+i+"</a></li>";
 							pagenum+=pagenum1;
 						}
 					
 					}
 					}else{
 					for(var i = rtn.currentPage-4 ;i <rtn.currentPage+4;i++){
 						if(rtn.currentPage==i){
 							var pagenum1="<li><a class=\"active\" href=\"#\">"+i+"</a></li>";
 							pagenum+=pagenum1;
 						}else{
 							var pagenum1="<li><a href=\"/picandfilms/japanvideo.html?currentPage="+i+"\">"+i+"</a></li>";
 							pagenum+=pagenum1;
 						}
 					
 					}
 					}
 					
 				}
 				
                pagenum+=" <li><a href=\"/picandfilms/japanvideo.html?currentPage="+rtn.totalPage+"\">»</a></li></ul></div>";
                $("#pagenum").append(pagenum);
            },
            error : function(jqXHR, textStatus,
                    errorThrown) {
                var sessionstatus = jqXHRgetResponseHeader("sessionstatus");
                if (sessionstatus == "timeout") {
                    alert(i1510.sessionOutMes);
                    var req_address = i1510.sessionOutUrl;
                    window.location.href = req_address;
                }
            }
 
        });
        
        $.ajax({
            url : "/picandfilms/latistjapanvideo.do?currentPage="+oldurl,
            async : true,
            data:data,
            dataType : 'json',
            type : 'post',
            success : function(rtn, textStatus) {
                //业务控制
                var pagehtml = "";
 				for(var i = 0 ;i <rtn.japanvideoBaseinfo.length;i++){
 					pagehtml1="<dl class=\"col-xs-4 col-md-4\"><dt><a href=\"/artist.do?artist="+rtn.japanvideoBaseinfo[i].cover+"\"><img class=\"auto\" src=\"/videocover/"+rtn.japanvideoBaseinfo[i].cover+"\" alt=\"\"/></a><div class=\"soon abs\">"+rtn.japanvideoBaseinfo[i].artist+"</div><!--显示为预告片--></dt><dd><a href=\"detail.html\">"+rtn.japanvideoBaseinfo[i].id+"</a></dd></dl>";
 					pagehtml+=pagehtml1; 
 				}
 				$("#latist").append(pagehtml);
            },
            error : function(jqXHR, textStatus,
                    errorThrown) {
                var sessionstatus = jqXHRgetResponseHeader("sessionstatus");
                if (sessionstatus == "timeout") {
                    alert(i1510.sessionOutMes);
                    var req_address = i1510.sessionOutUrl;
                    window.location.href = req_address;
                }
            }
 
        });
    });
