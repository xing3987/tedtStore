<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传图片</title>
</head>
<body style="font-size:30px">
	<form action="${pageContext.request.contextPath}/test/doUpload.do" method="post" enctype="multipart/form-data">
		<input type="file" name="file" id="file"><br>
		<input type="submit" value="上传">
	</form>
</body>
</html>