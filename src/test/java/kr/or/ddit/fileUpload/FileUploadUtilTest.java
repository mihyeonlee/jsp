package kr.or.ddit.fileUpload;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUploadUtilTest {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtilTest.class);

	@Test
	public void getFilenametest() {
		/***Given***/

		String contentDisposition = "form-data; name=\"img\"; filename=\"sally.png\"";
		/***When***/
		String filename = FileUploadUtil.getFilename(contentDisposition);

		/***Then***/
		assertEquals(filename, "sally.png");
	}
	
	@Test
	public void UUIDtest() {
		/***Given***/
		
		/***When***/
		String uuid = UUID.randomUUID().toString();
		logger.debug("uuid : {}", uuid);
		
		/***Then***/
	}
	
	@Test
	public void getExtensiontest() {
		/***Given***/
		String filename = "sally.png";
		
		/***When***/
		String extension = FileUploadUtil.getExtension(filename); 
		logger.debug("extension : {}", extension);
		
		/***Then***/
		assertEquals("png", extension);
	}

}
