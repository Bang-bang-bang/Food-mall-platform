<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>零食小舍后台管理系统</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="dist/css/_all-skins.min.css">
    <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker-bs3.css">
  </head>
  <body class="hold-transition skin-yellow sidebar-mini">
    <div class="wrapper">

      <!-- Main Header -->
      <header class="main-header">

        <!-- Logo -->
        <a href="index.html" class="logo">
          <!-- mini logo for sidebar mini 50x50 pixels -->
          <span class="logo-mini"></span>
          <!-- logo for regular state and mobile devices -->
          <span class="logo-lg"><b>零食小舍-管理系统</b></span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
          </a>
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              <li>
              <button type="submit" class="btn btn-flat btn-warning btn-lg" style="border:none;height:50px" ><i class="fa fa-sign-out"><b>注销</b></i></button>
              </li>
            </ul>
          </div>
        </nav>
      </header>
     
	  <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar Menu -->
          <ul class="sidebar-menu">
            <li class="header"></li>
            <!-- Optionally, you can add icons to the links -->
      			<li><a href="goods_upload.html"><i class="fa fa-cloud-upload"></i> <span>商品上传</span></a></li>
            <li class="treeview">
              <a href="#"><i class="fa fa-shopping-cart"></i> <span>商品管理</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="goods_info.html"><i class="fa fa-circle-o"></i> 商品信息管理</a></li>
				        <li><a href="goods_num.html"><i class="fa fa-circle-o"></i> 商品库存管理</a></li>
              </ul>
            </li>
      			<li class="treeview active">
              <a href="#"><i class="fa fa-sticky-note"></i> <span>订单管理</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li class="active"><a href="order_unfilled.html"><i class="fa fa-circle-o"></i>未发货订单管理</a></li>
                <li><a href="order_filled.html"><i class="fa fa-circle-o"></i>已完成订单管理</a></li>
              </ul>
            </li>
			      <li><a href="user_info.html"><i class="fa fa-users"></i> <span>用户信息管理</span></a></li>
            <li class="treeview">
              <a href="#"><i class="fa fa-user"></i> <span>系统管理员管理</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="manager_add.html"><i class="fa fa-circle-o"></i>增加管理员</a></li>
                <li><a href="manager_info.html"><i class="fa fa-circle-o"></i> 管理员信息管理</a></li>
              </ul>
            </li>
          </ul><!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
      </aside>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h2></h2>
          <ol class="breadcrumb">
            <li><a href="index.html"><i class="fa fa-dashboard"></i>首页</a></li>
            <li>订单管理</li>
            <li>未发货订单管理</li>
            <li>未发货订单信息编辑</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
			<!-- Horizontal Form -->
              <div class="box box-info">
                <div class="box-header with-border">
                  <h3 class="box-title"></h3>
                </div><!-- /.box-header -->
                <!-- form start -->
                <form class="form-horizontal">
                  <div class="box-body">
                    <div class="form-group">
                      <label class="col-sm-3 control-label">订单号</label>
                      <div class="col-sm-6">
                        <label class="control-label">00123</label>
                      </div>
                    </div>
					          <div class="form-group">
                      <label class="col-sm-3 control-label">收件人</label>
                      <div class="col-sm-6">
                        <input type="text" class="form-control" value="王小明">
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-3 control-label">电话</label>
                      <div class="col-sm-6">
                        <input type="text" class="form-control" value="18817654324">
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-3 control-label">收货地址</label>
                      <div class="col-sm-6">
                        <textarea class="form-control" rows="2">广东省广州市番禺区广州大学城广东药科大学生活区1栋455室</textarea>
                      </div>
                    </div>
					          <div class="form-group">
                      <label class="col-sm-3 control-label">总价</label>
                      <div class="col-sm-6">
                        <input type="text" class="form-control" value="12.80">
                      </div>
                    </div>
					          <div class="form-group">
                      <label class="col-sm-3 control-label">状态</label>
                      <div class="col-sm-6">
                        <input type="text" class="form-control" value="未发货">
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-3 control-label">生成日期</label>
                      <div class="col-sm-6">
                        <label class="control-label">09/11/2016(mm/dd/yy)</label>
                      </div>
                    </div>
                  </div><!-- /.box-body -->
                  <div class="box-footer">
          					<div class="col-sm-6">
                              <button type="submit" class="col-sm-2 btn btn-default pull-right">取消</button>
          					</div>
          					<div class="col-sm-6">
                              <button type="submit" class="col-sm-2 btn btn-info">修改</button>
          					</div>
                  </div><!-- /.box-footer -->
                </form>
              </div><!-- /.box -->
           
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
    </div><!-- ./wrapper -->

    <!-- REQUIRED JS SCRIPTS -->

    <!-- jQuery 2.1.4 -->
    <script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <!-- AdminLTE App -->
    <script src="dist/js/app.min.js"></script>
	  <!-- DataTables -->
    <script src="plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
  </body>
</html>
