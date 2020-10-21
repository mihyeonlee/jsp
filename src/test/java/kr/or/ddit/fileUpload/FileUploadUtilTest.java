package kr.or.ddit.fileUpload;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileUploadUtilTest {

	@Test
	public void getFilename() {
		/***Given***/

		String contentDisposition = "form-data; name=\"img\"; filename=\"sally.png\"";
		/***When***/
		String filename = FileUploadUtil.getFilename(contentDisposition);

		/***Then***/
		assertEquals(filename, "sally.png");
	}

}
