<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="goodsController/upload.do" method="post" enctype="multipart/form-data">  
    <label>用户名：</label><input type="text" name="name"/><br/>  
    <label>密 码：</label><input type="password" name="password"/><br/>  
    <label>头 像1</label><input type="file" name="file"/><br/>  
    <label>头 像2</label><input type="file" name="file"/><br/>  
    <input type="submit" value="提  交"/>  
</form>  
  </body>
</html>
