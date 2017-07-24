<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>分数添加</title>
  <script language="javascript" src="JS/AjaxRequest.js"></script>
  <script language="javascript">
    function getProvince(){
		var loader=new net.AjaxRequest("addServlet?action=getProvince&nocache"+new Date().getTime(), deal_getProvince, onerror, "GET");
	}
	function deal_getProvince(){
		provinceArr=this.req.responseText.split(",");
		for(i=0;i<provinceArr.length;i++){
			document.getElementById("Pname").options[i]=new Option(provinceArr[i],provinceArr[i]);
		}
	}
  	function getSchool(){
  		var loader=new net.AjaxRequest("addServlet?action=getSchool&nocache"+new Date().getTime(), deal_getSchool, onerror, "Get");
  	}
  	function deal_getSchool(){
  		schoolArr=this.req.responseText.split(",");
  		for(i=0;i<schoolArr.length;i++){
  			document.getElementById("Sname").options[i]=new Option(schoolArr[i],schoolArr[i]);
  		}
  	}
  	function sub(){
  		if(document.getElementById("Sname").value==""){
  			alert("请输入学校名称");
  			document.getElementById("Sname").focus();
    		return false;
  		}else
  		if(document.getElementById("Sadd").value==""){
  			alert("请输入学校地址");
  			document.getElementById("Sadd").focus();
    		return false;
  		}else
  		if(document.getElementById("Sintro").value==""){
  			alert("请输入学校简介");
  			document.getElementById("Sintro").focus();
    		return false;
  		}else
  		if(document.getElementById("Surl").value==""){
  			alert("请输入官网地址");
  			document.getElementById("Surl").focus();
    		return false;
  		}else{
  			return true;
  		}
  	}
  	window.onload=function(){
  		getSchool();
  		getProvince();
  	}
  </script>
  </head>
  
  <body>
	<form action="addServlet" method="post" onsubmit="return sub()">
	<input type="hidden" name="action" value="goal">
		<table align="center">
			<tr>
				<td align="center" colspan="2">
					<h1>学校添加</h1>
				</td>
			</tr>
			<tr>
				<td>学校名称</td>
				<td>
					<select name="Sname" id="Sname">
					
					</select>
				</td>
			</tr>
			<tr>
				<td>省份</td>
				<td>
					<select name="Pname" id="Pname">
					
					</select>
				</td>
			</tr>
			<tr>
				<td>文理</td>
				<td>
					<select name="Nid" id="Nid">
						<option value="1">文科</option>
						<option value="2">理科</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>2014分数线</td>
				<td>
					<input type="text" name="y2014" id="y2014">
				</td>
			</tr>
			<tr>
				<td>2015分数线</td>
				<td>
					<input type="text" name="y2015" id="y2015">
				</td>
			</tr>
			<tr>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
				<td>2016分数线</td>
				<td>
					<input type="text" name="y2016" id="y2016">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="添加">
				</td>
			</tr>
		</table>
	</form> 
  </body>
</html>