<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020-07-30
  Time: 上午 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
            background-color: #EAEAEA;
        }
        .box{
            border: 1px solid #0C0C0C;
            width: 400px;
            height: 300px;
            position: absolute;
            top: auto;
            margin: 16% 0px 0px 37%;
        }
        .center-in-center{
            position: absolute;
            top: 50%;
            left: 50%;
            -webkit-transform: translate(-50%, -50%);
            -moz-transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            -o-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
    </style>
</head>
<body>
<div  class="box">
    <div class="center-in-center"><span style="font-size: larger">
        用户登录
    </span>
        <form action="${pageContext.request.contextPath}/user/Login" >
            <table>
                <tr>
                    <td><label for="">用户名</label></td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="text" name="userpassword" id=""></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" id="submit" value="登录" style="width: 5em">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
