package servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����ͼƬ
 * @author ����
 *
 */

@SuppressWarnings("serial")
public class ImageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedImage bi=new BufferedImage(80, 22, BufferedImage.TYPE_INT_RGB);//����ͼ�����ݻ�����
		Graphics g=bi.getGraphics();//��û��
		g.setColor(new Color(220, 220, 220));//����ɫ
		g.fillRect(0, 0, 80, 22);//���Ʊ���
		
		//��������
		char[] code="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		StringBuffer sBuffer=new StringBuffer();
		Random r=new Random();
		int len=code.length,index;
		for(int i=0;i<4;i++){//4λ��֤��
			index=r.nextInt(len);//�����������±�
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));//�������һ����ɫ
			g.drawString(code[index]+"", (i*15)+3, 18);//������֤�ַ���
			sBuffer.append(code[index]);//�����ַ�
		}
		
		request.getSession().setAttribute("codeImage", sBuffer.toString());//����֤��ֵ������Session��
		ImageIO.write(bi, "jpg", response.getOutputStream());//ͼƬд�뵽�����
	}
}
