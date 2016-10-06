<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
<body>
	<form name="form1" action="" method="get">
		usergoodid<input type="text" name="usergoodid" id="usergoodid">userid
		<input type="text" name="userid" id="userid"> goodsid<input
			type="text" name="goodsid" id="goodsid"> goodsnumbers<input
			type="text" name="goodsnumbers" id="goodsnumbers"> <a
			onclick="ajaxSure()">tijiao </a>
	</form>
</body>
<script type="text/javascript">
	function ajaxSure() {
		var usergoodid = document.form1.usergoodid.value;
		var userid = document.form1.userid.value;
		var goodsid = document.form1.goodsid.value;
		var goodsnumbers = document.form1.goodsnumbers.value;
		$.ajax({
			data : {
				'userid' : userid,
				'mymGoodsCarts' : JSON.stringify([ {
					'usergoodid' : usergoodid,
					'goodsid' : goodsid,
					'goodsnumbers' : goodsnumbers
				} ])
			},
			type : "GET",
			dataType : "json",
			url : "http://localhost:8080/ourmall/userController/addOrder.do",
			error : function(json) {
				alert("jjj");
			},
			success : function(json) {
				alert(json.data.price);
			}
		});
		alert(userid);

		debugger;
	}
</script>
</html>
