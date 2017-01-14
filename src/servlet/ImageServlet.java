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
 * 生成图片
 * @author 孙清
 *
 */

@SuppressWarnings("serial")
public class ImageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedImage bi=new BufferedImage(80, 22, BufferedImage.TYPE_INT_RGB);//定义图像数据缓冲区
		Graphics g=bi.getGraphics();//获得绘笔
		g.setColor(new Color(220, 220, 220));//背景色
		g.fillRect(0, 0, 80, 22);//绘制背景
		
		//绘制文字
		char[] code="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		StringBuffer sBuffer=new StringBuffer();
		Random r=new Random();
		int len=code.length,index;
		for(int i=0;i<4;i++){//4位验证码
			index=r.nextInt(len);//随机获得数组下标
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));//随机设置一种颜色
			g.drawString(code[index]+"", (i*15)+3, 18);//绘制验证字符，
			sBuffer.append(code[index]);//保存字符
		}
		
		request.getSession().setAttribute("codeImage", sBuffer.toString());//将验证码值保存在Session中
		ImageIO.write(bi, "jpg", response.getOutputStream());//图片写入到输出流
	}
}
