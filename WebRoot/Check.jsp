<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>验证码校验</title>
  </head>
  
  <body>
    <%
      String checkcode=request.getParameter("checkCode");
      if(checkcode.equals("")||checkcode==null){
         out.print("<script>alert('请输入正确验证码');window.location.href('Login.html')</script>");
      }else{
         if(!checkcode.equalsIgnoreCase((String)session.getAttribute("randCheckCode"))){
              out.print("<script>alter('验证码不正确，请重新输入');history.back(-1);</script>");
         }else{
               out.print("登陆成功");
         }
      }
     %>
  </body>
</html>
