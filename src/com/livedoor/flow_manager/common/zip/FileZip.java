package com.livedoor.flow_manager.common.zip;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

public class FileZip {
	

		public void zipImg(String[] fileName,HttpServletResponse res) throws IOException{
		ZipOutputStream out = new ZipOutputStream(res.getOutputStream());
		
		for (int i = 0; i < fileName.length; i++) {
			ZipEntry ze = new ZipEntry(subFileName(fileName[i]));
			out.putNextEntry(ze);
			FileInputStream in = new FileInputStream(fileName[i]);
			int b;	
			while ( (b = in.read()) != -1) {
				out.write(b);
			}
			in.close();	
			
			
			
		}
		out.close();
		
	}
	
	public  String subFileName(String fileName){
		
		return fileName.substring(fileName.lastIndexOf("\\")+1,fileName.length());
		
	}
	
	public static void main(String[] args) throws IOException {
		FileZip fz = new FileZip();
	}
}
