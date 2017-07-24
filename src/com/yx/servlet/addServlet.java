package com.yx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yx.dao.ProvinceDao;
import com.yx.dao.SchoolDao;
import com.yx.model.Goal;
import com.yx.model.Minformation;
import com.yx.model.Nature;
import com.yx.model.Province;
import com.yx.model.School;

public class addServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("GBK");
		resp.setCharacterEncoding("GBK");
		resp.setContentType("text/html");
		String action=req.getParameter("action");
		if("getProvince".equals(action)){//异步寻找省份
			List<Province> list=null;
			ProvinceDao pdao=new ProvinceDao();
			list=pdao.SelectAllPro();
			String text="";
			if(list!=null){
				for(int i=0;i<list.size();i++){
					text=text+list.get(i).getPname()+",";
				}
				text=text.substring(0, text.length()-1);
			}
			PrintWriter out=resp.getWriter();
			out.print(text);
			out.flush();
			out.close();
		}else
		if("getSchool".equals(action)){//异步寻找学校
			List<School> list=null;
			SchoolDao sdao=new SchoolDao();
			list=sdao.SelectAllSch();
			String text="";
			if(list!=null){
				for(int i=0;i<list.size();i++){
					text=text+list.get(i).getSname()+",";
				}
				text=text.substring(0, text.length()-1);
			}
			PrintWriter out=resp.getWriter();
			out.print(text);
			out.flush();
			out.close();
		}else
		if("add".equals(action)){//学校添加方法
			Minformation minfor=new Minformation();
			String Sname=req.getParameter("Sname");
			SchoolDao sdao=new SchoolDao();
			String Sid=sdao.SearchID(Sname);
			System.out.print("添加成功？");
			if(Sid==null)
				System.out.println("false");
			else
				System.out.println("true");
			String Nid=req.getParameter("Nid");
			String Nname=sdao.SearchNature(Nid);
			Nature nature=new Nature();//设置Nature属性
			nature.setNid(Nid);
			nature.setNname(Nname);
			
			String Sadd=req.getParameter("Sadd");
			String Pname=req.getParameter("Pname");
			String Sintro=req.getParameter("Sintro");
			if(Sintro.indexOf("\n")!=-1){			//将content里所有换行符替换成<br>
				Sintro=Sintro.replaceAll("\n", "<br>");
			}
			String Surl=req.getParameter("Surl");
			ProvinceDao pdao=new ProvinceDao();
			String Pid=pdao.SearchID(Pname);
			
			Province province=new Province();//设置Province属性
			province.setPid(Pid);
			province.setPname(Pname);
			
			minfor.setSid(Sid);
			minfor.setNature(nature);
			minfor.setSadd(Sadd);
			minfor.setProvince(province);
			minfor.setSintro(Sintro);
			minfor.setSurl(Surl);
			
			boolean success=sdao.addSchool(minfor);
			if(success==true){
				System.out.println("minfor has been saved");
			}else{
				System.out.println("minfor failed to save");
			}
			resp.sendRedirect("school.jsp");
		}else
		if("goal".equals(action)){//分数添加
			String Sname=req.getParameter("Sname");
			SchoolDao sdao=new SchoolDao();
			String Sid=sdao.SearchID(Sname);
			String Pname=req.getParameter("Pname");
			ProvinceDao pdao=new ProvinceDao();
			String Pid=pdao.SearchID(Pname);
			String y2014=req.getParameter("y2014");
			String y2015=req.getParameter("y2015");
			String y2016=req.getParameter("y2016");
			String Nid=req.getParameter("Nid");
			Goal goal=new Goal();
			String Gid=Sid+Pid+Nid;//分数id=学校id（4位）+省份id（2位）+文理属性id（1位）
			goal.setGid(Gid);
			goal.setY2014(y2014);
			goal.setY2015(y2015);
			goal.setY2016(y2016);
			boolean success=sdao.addGoal(goal);
			if(success==false){
				System.out.println("载入分数出错");
			}else{
				System.out.println("成功载入分数");
			}
			resp.sendRedirect("goal.jsp");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
