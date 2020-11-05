package kr.or.ddit.fileUpload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUploadUtil {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);
	
	//form-data; name="img" , filename="sally.png"
	//=> sally.png
	public static String getFilename(String contentDisposition) {
		String[] conarr = contentDisposition.split("; ");
		
		for(String constr : conarr) {
			String[] selectDisposition = constr.split("=");
			if(selectDisposition[0].equals("filename")) {
				return selectDisposition[1].replaceAll("\"", "");
			}
		}
		return "";
	}
	
	//filename : sally.png => png
	public static String getExtension(String filename) {
		if(filename == null || filename.indexOf(".") == -1) {
			return "";
		}else {
			return filename.split("\\.")[1];
			
		}
	}
	
	
}
