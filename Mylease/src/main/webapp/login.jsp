<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC >
<html>

<head>
	<meta charset="utf-8">
	<title>登录</title>
</head>

<body>

	<div id="LoginBox">
		<h1 class="row1">登录界面</h1>
		<form class="form-horizontal col-md-12" role="form" method="post" action="UserController/login">
			<div class="form-group">
				<lable class="col-md-2 control-label">
					学号：
				</lable>
				<div class="col-md-7">
					<input type="text" class="form-control" placeholder="请输入学号" name="userName">
				</div>
			</div>
			<div class="form-group">
				<lable class="col-md-2 control-label">
					密码：
				</lable>
				<div class="col-md-7">
					<input type="password" class="form-control" placeholder="请输入密码" name="password">
				</div>
			</div>

					<input type="submit" name="submit" id="submit">
					<input type="reset" name="reset" id="reset">

		</form>
	</div>


</body>

</html>