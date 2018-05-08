<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="${pageContext.request.contextPath}/css/orders.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/personage.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon/css/bootstrap.min.css">
	<link href="${pageContext.request.contextPath}/css/icon/css/cropper.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/icon/css/sitelogo.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon/css/font-awesome.min.css">
</head>
<body>
<!-- 页面顶部-->
<jsp:include page="header.jsp"></jsp:include>
<!-- nav主导航-->
<jsp:include page="topNav.jsp"></jsp:include>
<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>个人中心</a></li>
    </ul>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
    <!-- 左边栏-->
    <jsp:include page="left.jsp"></jsp:include>
    <!-- 右边栏-->
    <!--个人信息头部-->
    <div class="rightsidebar_box rt">
        <div class="rs_header">
            <span class="rs_header_active"><a href="${pageContext.request.contextPath}/main/showPersonInfo.do">我的信息</a></span>
            <span><a href="${pageContext.request.contextPath}/main/showPersonal.do">安全管理</a></span>
        </div>

        <!--个人信息具体内容 -->
        <div class="rs_content">
            <!--头像-->
            <div class="rs_content_headPortrait">
	                <span class="same" style="float:left">我的头像：</span>
	                <img style="float:left" src="${pageContext.request.contextPath}/images/personage/touxiang.png" alt="" id="icon" width="50px" height="50px"/>
	        	    <form action="" enctype="multipart/form-data" style="float:left;margin-left:20px;margin-top:20px;">
	                	<input  type="file" name="file" value="" id="iconPic" onchange="getImage()">
	                </form>
	               <!-- <input type="hidden" name="iconPic" value="" id="iconPic"> -->
	               <!--  <span class="change_headPortrait same_click" data-toggle="modal" data-target="#avatar-modal" >更改头像</span>-->         </div>
            <!--用户名-->
       <form id="personInfo">
            <div class="rs_content_username">
                <span class="same">用户名：</span>
                <span class="same rs_username"></span>
                <input style="height:20px" class="ed_username" value="${user.username}" name="username"/>
                <span class="change_username same_click">更改用户名</span>
                <span id="userNameSpan"></span>
            </div>
            <!--性别-->
            
            <div class="rs_content_sex" style="display:none">
                <span class="same">性别：</span>
                <span class="man selected">
                    <img src="${pageContext.request.contextPath}/images/personage/select.png" alt=""/>男
                </span>
                <span class="women">
                    <img src="${pageContext.request.contextPath}/images/personage/un_select.png" alt=""/>女
                </span>
            </div>
            <div class="rs_content_sex">
                <span class="same">性别：</span>
                <input type="radio" name="gender" id="gender" value="0" 
                	<c:if test="${user.gender==0}">checked</c:if>/>男
                <input type="radio" name="gender" id="gender" value="1"
                	<c:if test="${user.gender==1}">checked</c:if>/>女
            </div>            
            <!--绑定电话-->
            <div class="rs_content_tel">
                <span class="same">绑定电话：</span>
                <input type="text" value="${user.phone}" name="phone"/>
            </div>
            <!--绑定邮箱-->
            <div class="rs_content_mail">
                <span class="same">绑定邮箱：</span>
                <input class="ed_email" value="${user.email}" name="email"/>
                <span class="rs_mail"></span>
                <span class="same_click change_mail">更改邮箱</span>
            </div>
            <!--保存按钮-->
            <div class="save">
               	<a href="#" onclick="btnUpdate()" style="text-decoration-style: none;color:black;">保存更改</a>
            </div>
        </form>
        </div>
    </div>
</div>
<!-- 头像插件 -->
<div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1"> 
    <div class="modal-dialog modal-lg"> 
        <div class="modal-content"> 
            <!--<form class="avatar-form" action="upload-logo.php" enctype="multipart/form-data" method="post">--> 
            <form class="avatar-form"> 
                <div class="modal-header"> 
                    <button class="close" data-dismiss="modal" type="button">×</button> 
                    <h4 class="modal-title" id="avatar-modal-label">上传图片</h4> 
                </div> 
                <div class="modal-body"> 
                    <div class="avatar-body"> 
                        <div class="avatar-upload"> 
                            <input class="avatar-src" name="avatar_src" type="hidden"> 
                            <input class="avatar-data" name="avatar_data" type="hidden"> 
                            <label for="avatarInput" style="line-height: 35px;">图片上传</label> 
                            <button class="btn btn-info"  type="button" style="height: 35px;" onClick="$('input[id=avatarInput]').click();">请选择图片</button> 
                            <span id="avatar-name"></span> 
                            <input class="avatar-input hide" id="avatarInput" name="avatar_file" type="file"></div> 
                        <div class="row"> 
                            <div class="col-md-9"> 
                                <div class="avatar-wrapper"></div> 
                            </div> 
                            <div class="col-md-3"> 
                                <div class="avatar-preview preview-lg" id="imageHead"></div> 
                                <!--<div class="avatar-preview preview-md"></div> 
                        <div class="avatar-preview preview-sm"></div>--> 
                            </div> 
                        </div> 
                        <div class="row avatar-btns"> 
                            <div class="col-md-4"> 
                                <div class="btn-group"> 
                                    <button class="btn btn-info fa fa-undo" data-method="rotate" data-option="-90" type="button" title="Rotate -90 degrees"> 向左旋转</button> 
                                </div> 
                                <div class="btn-group"> 
                                    <button class="btn  btn-info fa fa-repeat" data-method="rotate" data-option="90" type="button" title="Rotate 90 degrees"> 向右旋转</button> 
                                </div> 
                            </div> 
                            <div class="col-md-5" style="text-align: right;">                                 
                                <button class="btn btn-info fa fa-arrows" data-method="setDragMode" data-option="move" type="button" title="移动"> 
                                <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper("setDragMode", "move")"> 
                                </span> 
                              </button> 
                              <button type="button" class="btn btn-info fa fa-search-plus" data-method="zoom" data-option="0.1" title="放大图片"> 
                                <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper("zoom", 0.1)"> 
                                  <!--<span class="fa fa-search-plus"></span>--> 
                                </span> 
                              </button> 
                              <button type="button" class="btn btn-info fa fa-search-minus" data-method="zoom" data-option="-0.1" title="缩小图片"> 
                                <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper("zoom", -0.1)"> 
                                  <!--<span class="fa fa-search-minus"></span>--> 
                                </span> 
                              </button> 
                              <button type="button" class="btn btn-info fa fa-refresh" data-method="reset" title="重置图片"> 
                                    <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper("reset")" aria-describedby="tooltip866214"> 
                               </button> 
                            </div> 
                            <div class="col-md-3"> 
                                <button id="button_save" class="btn btn-info btn-block avatar-save fa fa-save" type="button" data-dismiss="modal"> 保存修改</button> 
                            </div> 
                        </div> 
                    </div> 
                </div> 
            </form> 
        </div> 
    </div> 
</div> 
<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="${pageContext.request.contextPath}/images/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="${pageContext.request.contextPath}/images/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="${pageContext.request.contextPath}/images/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="${pageContext.request.contextPath}/images/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
             <p class="footer1"><img src="${pageContext.request.contextPath}/images/footer/logo.png" alt="" class=" footLogo"/></p>
             <p class="footer2"><img src="${pageContext.request.contextPath}/images/footer/footerFont.png" alt=""/></p>
        </div>
        <div class="foot_left lf">
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="${pageContext.request.contextPath}/images/footer/wechat.png" alt=""/>
                    <img src="${pageContext.request.contextPath}/images/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>学子商城客户端</p>
            <img src="${pageContext.request.contextPath}/images/footer/ios.png" class="lf">
            <img src="${pageContext.request.contextPath}/images/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="${pageContext.request.contextPath}/images/footer/erweima.png">
        </div>
		<!-- 页面底部-备案号 #footer -->
        <div class="record">
            &copy;2017 达内集团有限公司 版权所有 京ICP证xxxxxxxxxxx
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.page.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/orders.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/personal.js"></script>
<script src="${pageContext.request.contextPath}/js/icon/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/icon/cropper.js"></script>
<script src="${pageContext.request.contextPath}/js/icon/sitelogo.js"></script>
<script src="${pageContext.request.contextPath}/js/icon/html2canvas.min.js" type="text/javascript" charset="utf-8"></script> 
<script type="text/javascript"> 
	//上传头像
	function getImage(){
		//创建表单数据对象
		var formData=new FormData();
		//获取file节点
		var fileNode=document.getElementById("iconPic");
		formData.append("file",fileNode.files[0]);
		$.ajax({
			"url":"${pageContext.request.contextPath}/user/upload.do",
			"data":formData,
			"type":"POST",
			"dataType":"json",
			"contentType":false,//文件上传必须设置
			"processData":false,//让服务器不要处理提交的文件
			"success":function(obj){
				//实现显示图片功能
				var url=window.URL.createObjectURL(fileNode.files[0]);
				icon.src=url;//直接改写id的src属性
			}
		})
	}
	
	//段保护保存更改按钮
	function btnUpdate(){
		$.ajax({
			"url":"${pageContext.request.contextPath}/user/personInfo.do",
			"data":$("#personInfo").serialize(),
			"type":"POST",
			"dataType":"json",
			"success":function(obj){
				if(obj.state==1){
					location="${pageContext.request.contextPath}/main/showPersonInfo.do";
				}else{
					$("#userNameSpan").html(obj.message);
					$("#userNameSpan").css("color","red");					
				}
			}
		})
	}



//做个下简易的验证  大小 格式  
    $('#avatarInput').on('change', function(e) {
        var filemaxsize = 1024 * 5;//5M 
        var target = $(e.target); 
        var Size = target[0].files[0].size / 1024; 
        if(Size > filemaxsize) { 
            alert('图片过大，请重新选择!'); 
            $(".avatar-wrapper").childre().remove; 
            return false; 
        } 
        if(!this.files[0].type.match(/image.*/)) { 
            alert('请选择正确的图片!') 
        } else { 
            var filename = document.querySelector("#avatar-name"); 
            var texts = document.querySelector("#avatarInput").value; 
            var teststr = texts; //你这里的路径写错了 
            testend = teststr.match(/[^\\]+\.[^\(]+/i); //直接完整文件名的 
            filename.innerHTML = testend; 
        } 
     
    }); 
 
    $(".avatar-save").on("click", function() { 
        var img_lg = document.getElementById('imageHead'); 
        // 截图小的显示框内的内容 
        html2canvas(img_lg, { 
            allowTaint: true, 
            taintTest: false, 
            onrendered: function(canvas) { 
                canvas.id = "mycanvas"; 
                //生成base64图片数据 
                var dataUrl = canvas.toDataURL("image/png"); 
                var newImg = document.createElement("img"); 
                newImg.src = dataUrl; 
                imagesAjax(dataUrl) 
            } 
        }); 
    }) 
    function imagesAjax(src) { 
        var data = {}; 
        data.img = src; 
        $.ajax({ 
            url: "", 
            data: data, 
            type: "POST", 
            dataType: 'json', 
            success: function(re) {
            	if (re) {
	                if(re.status == 200) {
	                    $('#icon').attr('src',re.data.url );
	                    $('#iconPic').val(re.data.url);
	                }else {
						alert("上传失败")
					} 
					
				}
            } 
        });
    } 
</script>
<script type="text/javascript">
$("#icon").click(function() {
	window.open($(this).attr("src"));
})
</script> 
<!--<script>
	$(".x").click(function(){
		$(".modal").hide();
	})
	$(".change_headPortrait").click(function(){
		$(".modal").show();
	})
</script>-->
<script>
	$("#button_save").click(function(){
		var url = $("#imageHead img").attr("src");
		$('#icon').attr('src',url);
	})
	
	//左边栏
	$(function(){
	    $("#leftsidebar_box dd").hide();//所有的dd隐藏
	    $("#leftsidebar_box .count_managment dd").show();//让帐号管理显示
	  //列表标题后面的图片显示向右
        $("#leftsidebar_box dt img").attr("src","../images/myOrder/myOrder2.png");
      //帐号管理标题后面图片显示向下
        $("#leftsidebar_box .count_managment").find('img').attr("src","../images/myOrder/myOrder1.png");
	});
</script>
</html>