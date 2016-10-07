<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>零食小舍后台管理系统</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="dist/css/_all-skins.min.css">
<link rel="stylesheet"
	href="plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="plugins/daterangepicker/daterangepicker-bs3.css">
</head>
<body class="hold-transition skin-yellow sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<header class="main-header">

			<!-- Logo -->
			<a href="index.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"></span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>零食小舍-管理系统</b></span>
			</a>

			<!-- Header Navbar -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>
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
					<li class="active"><a href="goods_upload.html"><i
							class="fa fa-cloud-upload"></i> <span>商品上传</span></a></li>
					<li class="treeview"><a href="#"><i
							class="fa fa-shopping-cart"></i> <span>商品管理</span> <i
							class="fa fa-angle-left pull-right"></i></a>
						<ul class="treeview-menu">
							<li><a href="goods_info.html"><i class="fa fa-circle-o"></i>
									商品信息管理</a></li>
							<li><a href="goods_num.html"><i class="fa fa-circle-o"></i>
									商品库存管理</a></li>
						</ul></li>
					<li class="treeview"><a href="#"><i
							class="fa fa-sticky-note"></i> <span>订单管理</span> <i
							class="fa fa-angle-left pull-right"></i></a>
						<ul class="treeview-menu">
							<li><a href="order_unfilled.html"><i
									class="fa fa-circle-o"></i>未发货订单管理</a></li>
							<li><a href="order_filled.html"><i
									class="fa fa-circle-o"></i>已完成订单管理</a></li>
						</ul></li>
					<li><a href="user_info.html"><i class="fa fa-users"></i> <span>用户信息管理</span></a></li>
					<li class="treeview"><a href="#"><i class="fa fa-user"></i>
							<span>系统管理员管理</span> <i class="fa fa-angle-left pull-right"></i></a>
						<ul class="treeview-menu">
							<li><a href="manager_add.html"><i class="fa fa-circle-o"></i>增加管理员</a></li>
							<li><a href="manager_info.html"><i
									class="fa fa-circle-o"></i> 管理员信息管理</a></li>
						</ul></li>
				</ul>
				<!-- /.sidebar-menu -->
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
					<li>商品上传</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<!-- Horizontal Form -->
				<div class="box box-info">
					<div class="box-header with-border">
						<h3 class="box-title"></h3>
					</div>
					<!-- /.box-header -->
					<!-- form start -->
					<form class="form-horizontal" action="goodsController/upload.do"
						method="post" enctype="multipart/form-data">
						<div class="box-body">
							<div class="form-group">
								<label class="col-sm-3 control-label">商品名称描述</label>
								<div class="col-sm-6">
									<textarea class="form-control" rows="3" name="goodsDetals"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">类别</label>
								<div class="col-sm-6">
									<select class="form-control" name="goodsClass">
										<option>饼干零食</option>
										<option>坚果蜜饯</option>
										<option>进口零食</option>
										<option>饮品</option>
										<option>糖果巧克力</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">原产地</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" name="goodsBornPlace">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">销售价格</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" name="goodsPrice">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">生产日期</label>
								<div class="col-sm-6">
									<input type="text" class="form-control pull-right"
										id="reservation" name="goodsBornTime">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">商品数量</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" name="goodsTotal">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">商品图片</label>
								<div class="col-sm-6">
									<input type="file" multiple class="col-sm-6" name="file"> 
								</div>
							</div>
				
							<div class="form-group">
								<label class="col-sm-3 control-label">商品详情图片</label>
								<div class="col-sm-6">
									<input type="file" name="file1" multiple class="col-sm-6"> 
								</div>
							</div>
						</div>
						<!-- /.box-body -->
						<div class="box-footer">
							<div class="col-sm-6">
								<button type="submit"
									class="col-sm-2 btn btn-default pull-right">取消</button>
							</div>
							<div class="col-sm-6">
								<button type="submit" class="col-sm-2 btn btn-info">上传</button>
							</div>
						</div>
						<!-- /.box-footer -->
					</form>
				</div>
				<!-- /.box -->

			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
	</div>
	<!-- ./wrapper -->

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
	<!-- date-range-picker -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
	<script src="plugins/daterangepicker/daterangepicker.js"></script>

	<script type="text/javascript">
		$(function() {
			//Date range picker
			$('#reservation').daterangepicker();
		});
	</script>
	<div class="daterangepicker dropdown-menu show-calendar opensleft"
		style="display: none;">
		<div class="calendar first left">
			<div class="calendar-date">
				<table class="table-condensed">
					<thead>
						<tr>
							<th class="prev available"><i
								class="fa fa-arrow-left icon icon-arrow-left glyphicon glyphicon-arrow-left"></i></th>
							<th colspan="5" class="month">Sep 2016</th>
							<th class="next available"><i
								class="fa fa-arrow-right icon icon-arrow-right glyphicon glyphicon-arrow-right"></i></th>
						</tr>
						<tr>
							<th>Su</th>
							<th>Mo</th>
							<th>Tu</th>
							<th>We</th>
							<th>Th</th>
							<th>Fr</th>
							<th>Sa</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="available off" data-title="r0c0">28</td>
							<td class="available off" data-title="r0c1">29</td>
							<td class="available off" data-title="r0c2">30</td>
							<td class="available off" data-title="r0c3">31</td>
							<td class="available" data-title="r0c4">1</td>
							<td class="available" data-title="r0c5">2</td>
							<td class="available" data-title="r0c6">3</td>
						</tr>
						<tr>
							<td class="available" data-title="r1c0">4</td>
							<td class="available" data-title="r1c1">5</td>
							<td class="available" data-title="r1c2">6</td>
							<td class="available" data-title="r1c3">7</td>
							<td class="available" data-title="r1c4">8</td>
							<td class="available" data-title="r1c5">9</td>
							<td class="available" data-title="r1c6">10</td>
						</tr>
						<tr>
							<td class="available" data-title="r2c0">11</td>
							<td class="available" data-title="r2c1">12</td>
							<td class="available" data-title="r2c2">13</td>
							<td class="available" data-title="r2c3">14</td>
							<td class="available active start-date end-date"
								data-title="r2c4">15</td>
							<td class="available" data-title="r2c5">16</td>
							<td class="available" data-title="r2c6">17</td>
						</tr>
						<tr>
							<td class="available" data-title="r3c0">18</td>
							<td class="available" data-title="r3c1">19</td>
							<td class="available" data-title="r3c2">20</td>
							<td class="available" data-title="r3c3">21</td>
							<td class="available" data-title="r3c4">22</td>
							<td class="available" data-title="r3c5">23</td>
							<td class="available" data-title="r3c6">24</td>
						</tr>
						<tr>
							<td class="available" data-title="r4c0">25</td>
							<td class="available" data-title="r4c1">26</td>
							<td class="available" data-title="r4c2">27</td>
							<td class="available" data-title="r4c3">28</td>
							<td class="available" data-title="r4c4">29</td>
							<td class="available" data-title="r4c5">30</td>
							<td class="available off" data-title="r4c6">1</td>
						</tr>
						<tr>
							<td class="available off" data-title="r5c0">2</td>
							<td class="available off" data-title="r5c1">3</td>
							<td class="available off" data-title="r5c2">4</td>
							<td class="available off" data-title="r5c3">5</td>
							<td class="available off" data-title="r5c4">6</td>
							<td class="available off" data-title="r5c5">7</td>
							<td class="available off" data-title="r5c6">8</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="calendar second right">
			<div class="calendar-date">
				<table class="table-condensed">
					<thead>
						<tr>
							<th></th>
							<th colspan="5" class="month">Sep 2016</th>
							<th class="next available"><i
								class="fa fa-arrow-right icon icon-arrow-right glyphicon glyphicon-arrow-right"></i></th>
						</tr>
						<tr>
							<th>Su</th>
							<th>Mo</th>
							<th>Tu</th>
							<th>We</th>
							<th>Th</th>
							<th>Fr</th>
							<th>Sa</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="off disabled" data-title="r0c0">28</td>
							<td class="off disabled" data-title="r0c1">29</td>
							<td class="off disabled" data-title="r0c2">30</td>
							<td class="off disabled" data-title="r0c3">31</td>
							<td class="off disabled" data-title="r0c4">1</td>
							<td class="off disabled" data-title="r0c5">2</td>
							<td class="off disabled" data-title="r0c6">3</td>
						</tr>
						<tr>
							<td class="off disabled" data-title="r1c0">4</td>
							<td class="off disabled" data-title="r1c1">5</td>
							<td class="off disabled" data-title="r1c2">6</td>
							<td class="off disabled" data-title="r1c3">7</td>
							<td class="off disabled" data-title="r1c4">8</td>
							<td class="off disabled" data-title="r1c5">9</td>
							<td class="off disabled" data-title="r1c6">10</td>
						</tr>
						<tr>
							<td class="off disabled" data-title="r2c0">11</td>
							<td class="off disabled" data-title="r2c1">12</td>
							<td class="off disabled" data-title="r2c2">13</td>
							<td class="off disabled" data-title="r2c3">14</td>
							<td class="available active start-date end-date"
								data-title="r2c4">15</td>
							<td class="available" data-title="r2c5">16</td>
							<td class="available" data-title="r2c6">17</td>
						</tr>
						<tr>
							<td class="available" data-title="r3c0">18</td>
							<td class="available" data-title="r3c1">19</td>
							<td class="available" data-title="r3c2">20</td>
							<td class="available" data-title="r3c3">21</td>
							<td class="available" data-title="r3c4">22</td>
							<td class="available" data-title="r3c5">23</td>
							<td class="available" data-title="r3c6">24</td>
						</tr>
						<tr>
							<td class="available" data-title="r4c0">25</td>
							<td class="available" data-title="r4c1">26</td>
							<td class="available" data-title="r4c2">27</td>
							<td class="available" data-title="r4c3">28</td>
							<td class="available" data-title="r4c4">29</td>
							<td class="available" data-title="r4c5">30</td>
							<td class="available off" data-title="r4c6">1</td>
						</tr>
						<tr>
							<td class="available off" data-title="r5c0">2</td>
							<td class="available off" data-title="r5c1">3</td>
							<td class="available off" data-title="r5c2">4</td>
							<td class="available off" data-title="r5c3">5</td>
							<td class="available off" data-title="r5c4">6</td>
							<td class="available off" data-title="r5c5">7</td>
							<td class="available off" data-title="r5c6">8</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="ranges">
			<div class="range_inputs">
				<div class="daterangepicker_start_input">
					<label for="daterangepicker_start">从</label> <input
						class="input-mini" type="text" name="daterangepicker_start"
						value="">
				</div>
				<div class="daterangepicker_end_input">
					<label for="daterangepicker_end">至</label> <input
						class="input-mini" type="text" name="daterangepicker_end" value="">
				</div>
				<button class="applyBtn btn btn-small btn-sm btn-info">确定</button>
				&nbsp;
				<button class="cancelBtn btn btn-small btn-sm btn-default">取消</button>
			</div>
		</div>
	</div>
</body>
</html>
