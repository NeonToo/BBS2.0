<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log In</title>
 <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>

    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <style type="text/css">
        body {
            margin: 0px;
            padding: 0px;
            background-color: #CCFFCC;
        }
        .block {
            margin-top: 140px;
            margin-left: 30%;
            width: 500px;
            height: 300px;
            background-image: url("../img/background.jpg");
            background-repeat: no-repeat;
        }
        h2 {
            font-family: "微软雅黑";
            font-weight: bold;
            color: white;
            margin-left: 120px;
            padding-top: 30px;
            margin-bottom:0;
            padding-bottom:0;
            letter-spacing: 1.5em;
        }
        .style3 {
            color: #FFFFFF;
        }
        .row{
            margin-top:30px;
        }
    </style>
    <script type="text/javascript">
	function check() {
		with(document.all) {
			if(user_id.value == ""){
				alert("账户不能为空！");
				return false;
			}
			if(password.value == "") {
				alert("密码不能为空！");
				return false;
			}
			else{
				document.forms[0].submit();
			}
		}
	}
</script>
</head>
<body>

<div class="block">
    <div class="title">
        <h2>论坛登录</h2>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-1">
            <img src="../img/star.png">
        </div>
        <div class="col-md-7">
            <form style="margin-top:30px;" action="/bbs2.0/UserServlet?method=login" method="post">
                <table>
                    <tr>
                        <td><span class="style3">账号</span></td>
                        <td><input type="text" name="user_id"></td>
                    </tr>
                    <tr>
                        <td><span class="style3 ">密码</span></td>
                        <td><input type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td><br/></td>
                    </tr>
                    <tr>
                        <td><input type="button" style="background-color: #FFF000" value="登录" onclick="return check(this)"></td>
                        <td><input type="button" style="background-color: #FFF000" value="注册" onclick="location.href='register.jsp'"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>