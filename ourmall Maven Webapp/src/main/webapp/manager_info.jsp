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
    <link rel="stylesheet" href="plugins/icheck/blue.css">
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
            <li class="treeview">
              <a href="#"><i class="fa fa-sticky-note"></i> <span>订单管理</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="order_unfilled.html"><i class="fa fa-circle-o"></i>未发货订单管理</a></li>
                <li><a href="order_filled.html"><i class="fa fa-circle-o"></i>已完成订单管理</a></li>
              </ul>
            </li>
            <li><a href="user_info.html"><i class="fa fa-users"></i> <span>用户信息管理</span></a></li>
            <li class="treeview active">
              <a href="#"><i class="fa fa-user"></i> <span>系统管理员管理</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="manager_add.html"><i class="fa fa-circle-o"></i>增加管理员</a></li>
                <li class="active"><a href="manager_info.html"><i class="fa fa-circle-o"></i> 管理员信息管理</a></li>
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
            <li>系统管理员管理</li>
            <li>管理员信息管理</li>
          </ol>
        </section>
        <!-- Main content -->
        <section class="content">
      <!-- Horizontal Form -->
              <div class="box box-info">
                <div class="box-header">
                  <h3 class="box-title">管理员信息列表</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                  <div class="mailbox-messages">
                    <table id="example1" class="table table-hover">
                      <thead>
                        <tr>
                          <th>
                            <button class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i></button>
                            <button class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
                          </th>
                          <th>ID</th>
                          <th>用户名</th>
                          <th>性别</th>
                          <th>密码</th>
                          <th>电话</th>
                          <th>加入日期</th>
                          <th><a href="manager_add.html"><button class="btn btn-info btn-sm"><i class="fa fa-plus"></i></button></a></th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td><input type="checkbox"></td>
                          <td>001</td>
                          <td>张三</td>
                          <td>男</td>
                          <td>asdfghjkl</td>
                          <td>16678909876</td>
                          <td>10/23/2016</td>
                          <td><a href="manager_edit.html">编辑</a></td>
                        </tr>
                        <tr>
                          <td><input type="checkbox"></td>
                          <td>002</td>
                          <td>张三</td>
                          <td>男</td>
                          <td>asdfghjkl</td>
                          <td>16678909876</td>
                          <td>10/23/2016</td>
                          <td><a href="manager_edit.html">编辑</a></td>
                        </tr>
                        <tr>
                          <td><input type="checkbox"></td>
                          <td>003</td>
                          <td>张三</td>
                          <td>男</td>
                          <td>asdfghjkl</td>
                          <td>16678909876</td>
                          <td>10/23/2016</td>
                          <td><a href="manager_edit.html">编辑</a></td>
                        </tr>
                        <tr>
                          <td><input type="checkbox"></td>
                          <td>004</td>
                          <td>张三</td>
                          <td>男</td>
                          <td>asdfghjkl</td>
                          <td>16678909876</td>
                          <td>10/23/2016</td>
                          <td><a href="manager_edit.html">编辑</a></td>
                        </tr>
                        <tr>
                          <td><input type="checkbox"></td>
                          <td>005</td>
                          <td>张三</td>
                          <td>男</td>
                          <td>asdfghjkl</td>
                          <td>16678909876</td>
                          <td>10/23/2016</td>
                          <td><a href="manager_edit.html">编辑</a></td>
                        </tr>
                        <tr>
                          <td><input type="checkbox"></td>
                          <td>006</td>
                          <td>张三</td>
                          <td>男</td>
                          <td>asdfghjkl</td>
                          <td>16678909876</td>
                          <td>10/23/2016</td>
                          <td><a href="manager_edit.html">编辑</a></td>
                        </tr>
                        <tr>
                          <td><input type="checkbox"></td>
                          <td>007</td>
                          <td>张三</td>
                          <td>男</td>
                          <td>asdfghjkl</td>
                          <td>16678909876</td>
                          <td>10/23/2016</td>
                          <td><a href="manager_edit.html">编辑</a></td>
                        </tr>
                        <tr>
                          <td><input type="checkbox"></td>
                          <td>008</td>
                          <td>张三</td>
                          <td>男</td>
                          <td>asdfghjkl</td>
                          <td>16678909876</td>
                          <td>10/23/2016</td>
                          <td><a href="manager_edit.html">编辑</a></td>
                        </tr>
                        <tr>
                          <td><input type="checkbox"></td>
                          <td>009</td>
                          <td>张三</td>
                          <td>男</td>
                          <td>asdfghjkl</td>
                          <td>16678909876</td>
                          <td>10/23/2016</td>
                          <td><a href="manager_edit.html">编辑</a></td>
                        </tr>
                        <tr>
                          <td><input type="checkbox"></td>
                          <td>010</td>
                          <td>张三</td>
                          <td>男</td>
                          <td>asdfghjkl</td>
                          <td>16678909876</td>
                          <td>10/23/2016</td>
                          <td><a href="manager_edit.html">编辑</a></td>
                        </tr>
                        <tr>
                          <td><input type="checkbox"></td>
                          <td>011</td>
                          <td>张三</td>
                          <td>男</td>
                          <td>asdfghjkl</td>
                          <td>16678909876</td>
                          <td>10/23/2016</td>
                          <td><a href="manager_edit.html">编辑</a></td>
                        </tr>
                        <tr>
                          <td><input type="checkbox"></td>
                          <td>012</td>
                          <td>张三</td>
                          <td>男</td>
                          <td>asdfghjkl</td>
                          <td>16678909876</td>
                          <td>10/23/2016</td>
                          <td><a href="manager_edit.html">编辑</a></td>
                        </tr>
                        <tr>
                          <td><input type="checkbox"></td>
                          <td>013</td>
                          <td>张三</td>
                          <td>男</td>
                          <td>asdfghjkl</td>
                          <td>16678909876</td>
                          <td>10/23/2016</td>
                          <td><a href="manager_edit.html">编辑</a></td>
                        </tr>
                        <tr>
                          <td><input type="checkbox"></td>
                          <td>014</td>
                          <td>张三</td>
                          <td>男</td>
                          <td>asdfghjkl</td>
                          <td>16678909876</td>
                          <td>10/23/2016</td>
                          <td><a href="manager_edit.html">编辑</a></td>
                        </tr>
                        <tr>
                          <td><input type="checkbox"></td>
                          <td>015</td>
                          <td>张三</td>
                          <td>男</td>
                          <td>asdfghjkl</td>
                          <td>16678909876</td>
                          <td>10/23/2016</td>
                          <td><a href="manager_edit.html">编辑</a></td>
                        </tr>
                        <tr>
                          <td><input type="checkbox"></td>
                          <td>016</td>
                          <td>张三</td>
                          <td>男</td>
                          <td>asdfghjkl</td>
                          <td>16678909876</td>
                          <td>10/23/2016</td>
                          <td><a href="manager_edit.html">编辑</a></td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div><!-- /.box-body -->
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
    <!-- iCheck -->
    <script src="plugins/icheck/icheck.min.js"></script>

    <!-- page script -->
    <script>
      $(function () {
        $("#example1").DataTable({
          "aoColumnDefs":[{
              "bSortable":false,
              "aTargets":[0,3,4,5,7]
            }],
          language:{
            "sLengthMenu":"显示 _MENU_ 项结果",
            "sZeroRecords":"没有匹配结果",
            "sInfo":"显示第_START_至_END_项结果，共_TOTAL_项",
            "sInfoEmpty":"显示第 0 至 0 项结果，共 0 项",
            "sInfoFiltered":"（由_MAX_项结果筛选）",
            "sSearch":"搜索：",
            "sEmptyTable":"表中数据为空",
            "oPaginate":{
              "sPrevious":"上页",
              "sNext":"下页",
              "sLast":"末页"
            }
          }
        });
        
        //iCheck for checkbox and radio inputs
        $('.mailbox-messages input[type="checkbox"]').iCheck({
          checkboxClass: 'icheckbox_flat-blue',
          radioClass: 'iradio_flat-blue'
        });

        //Enable check and uncheck all functionality
        $(".checkbox-toggle").click(function () {
          var clicks = $(this).data('clicks');
          if (clicks) {
            //Uncheck all checkboxes
            $(".mailbox-messages input[type='checkbox']").iCheck("uncheck");
            $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
          } else {
            //Check all checkboxes
            $(".mailbox-messages input[type='checkbox']").iCheck("check");
            $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
          }
          $(this).data("clicks", !clicks);
        });
      });
    </script>
  </body>
</html>
