package com.kosta.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UploadFileHelper {
	//이미지들의 이름
	//파라메터들
	//{"photos":["aa.png","bb.png"]}, {"param1":"aa", "param2":"bb", "param3":"cc"}
	public static Map<String, Object> uploadFile(String UPLOAD_DIR, HttpServletRequest multi) {		
		Map<String, Object> map = new HashMap<>();
		Map<String, String> params = new HashMap<>();
		
		List<String> fileNames = new ArrayList<String>();
		try {
			List<Part> parts = (List<Part>) multi.getParts();
			for (Part part : parts) {
				if (part.getName().equalsIgnoreCase("photos")) {
					String fileName = getFileName(part);
					fileNames.add(fileName);
					String applicationPath = multi.getServletContext().getRealPath("");
					//File.separator는 /,\\
					String basePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;
					InputStream inputStream = null;
					OutputStream outputStream = null;
					try {
						File outputFilePath = new File(basePath + fileName);
						inputStream = part.getInputStream();
						outputStream = new FileOutputStream(outputFilePath);
						int read = 0;
						final byte[] bytes = new byte[1024];
						while ((read = inputStream.read(bytes)) != -1) {
							outputStream.write(bytes, 0, read);
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					} finally {
						if (outputStream != null) outputStream.close();
						if (inputStream != null) inputStream.close();		 
					}
				}else {
					params.put(part.getName(), multi.getParameter(part.getName()));
					//System.out.println(part.getName()+" => "+multi.getParameter(part.getName()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("photos", fileNames);
		map.put("params", params);
		
		return map;
	}

	private static String getFileName(Part part) {				
		for (String content : part.getHeader("content-disposition").split(";")) {			 
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
