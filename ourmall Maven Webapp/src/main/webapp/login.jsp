<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>零食小舍后台管理系统</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="plugins/icheck/blue.css">

    <style type="text/css">
    <!--
    body {
     background: url(img/login_background01.png) top left;
     background-repeat: no-repeat;
     background-size:100% 100%;
    }
    .login-box-body{
      /*background-color: #FFECB3;*/
      -webkit-box-shadow:0 0 10px;  
      -moz-box-shadow:0 0 10px;  
      box-shadow:0 0 10px;
    }
    -->
    </style>
  </head>
  <body class="hold-transition">
    <div class="login-box">
      <div class="login-box-body">
        <div class="login-logo">
          <h3>零食小舍后台管理系统</h3>
        </div><!-- /.login-logo -->
        <form action="index.html" method="post">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="用户名">
          </div>
          <div class="form-group">
            <input type="password" class="form-control" placeholder="密码">
          </div>
          <div class="row">
            <div class="col-xs-8">
              <div class="checkbox icheck">
                <label>
                  <input type="checkbox"> 记住我
                </label>
              </div>
            </div><!-- /.col -->
          </div>
		  <div class="row">
			<div class="col-xs-9">
              <button type="submit" class="btn btn-info col-xs-7 pull-right">登录</button>
            </div><!-- /.col -->
		  </div>
        </form>
      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->

    <!-- jQuery 2.1.4 -->
    <script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="plugins/icheck/icheck.min.js"></script>
    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_flat-blue',
          radioClass: 'iradio_flat-blue',
          increaseArea: '20%' // optional
        });
      });
    </script>
  </body>
</html>
