<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>语音通知文件上传</title>
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath}/CTD" method="post"
            enctype="multipart/form-data">
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<input type="text" name="serviceName" value="setPlayVoiceRequest"
							hidden="true" class="form-control">
					</div>
				</div>
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon">vccId:</span><input type="text"
							name="vccId" class="form-control">
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon">displayNum</span><input
							type="text" name="displayNum" class="form-control">
					</div>
				</div>
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon">bussinessId</span><input
							type="text" name="bussinessId" class="form-control">
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon">serviceKey</span><input
							type="text" name="serviceKey" class="form-control">
					</div>
				</div>
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon">playMode</span><input
							type="text" name="playMode" class="form-control">
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon">playMediaName</span><input
							type="text" name="playMediaName" class="form-control">
					</div>
				</div>
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon">welcomeIvrName</span><input
							type="text" name="welcomeIvrName" class="form-control">
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon">playMediaFile:</span><input
							type="file" name="playMediaFile" class="form-control">
					</div>
				</div>
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon">welcomeIvrFile:</span><input
							type="file" name="welcomeIvrFile" class="form-control">
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4">
					<input class="btn btn-primary" type="submit" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>