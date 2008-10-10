//package com.livedoor.flow_manager.img;
//
//import java.awt.Font;
//import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.FileOutputStream;
//
//public class ImgChange {
//
//	File _file = new File("E:/temp/a.jpg"); 
//	Image src = javax.imageio.ImageIO.read(_file);
//	BufferedImage tag = new BufferedImage(src.getWidth(null),src.getHeight(null),BufferedImage.TYPE_INT_RGB);
//	Graphics2D g2=tag.createGraphics();
//	g2.drawImage(src, 0, 0,src.getWidth(null), src.getHeight(null),null);
//	Font font = new Font("宋体",Font.BOLD,15);			
//	g2.setFont(font);
//	int x = 5;
//	int y = 20;
//	int random = 0;
//	double[] rotates = new double[]{-0.25, 0, 0.25, 0, -.25};
//	for(int i=0; i<5; i++){
//	     random = Double.valueOf(Math.random()*20).intValue();
//	     g2.rotate(rotates[i] , x , y );//旋转
//	     g2.drawString(String.valueOf(i), x + i*font.getSize(), y + random);
//	}			
//	FileOutputStream out=new FileOutputStream("E:/temp/a1.jpg"); 
//	JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam( tag );		
//	JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//	encoder.encode(tag,jep); 
//	out.flush();
//	out.close(); 
//}
