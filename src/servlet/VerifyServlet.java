package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=(String) request.getSession().getAttribute("codeImage");//获得session中保存的验证码值
		String vcode=request.getParameter("verificationCode").toUpperCase();//获得用户输入的信息[忽略大小写]
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();//获得输出流
		if(code.equals(vcode)){//比较
			out.println("验证码输入正确");
		}else {
			out.print("验证码输入错误");
		}
	}
}
