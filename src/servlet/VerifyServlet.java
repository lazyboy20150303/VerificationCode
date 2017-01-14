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
		String code=(String) request.getSession().getAttribute("codeImage");//���session�б������֤��ֵ
		String vcode=request.getParameter("verificationCode").toUpperCase();//����û��������Ϣ[���Դ�Сд]
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();//��������
		if(code.equals(vcode)){//�Ƚ�
			out.println("��֤��������ȷ");
		}else {
			out.print("��֤���������");
		}
	}
}
