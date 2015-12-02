package swftools;

import org.junit.Test;

import com.bkweb.common.utils.swf.SwfTools;

public class TestSwfTools {

	@Test
	public void pdf2swf() {
		String swfPath = "C:\\Users\\Administrator\\Desktop\\a.swf";
		String pdfPath = "C:\\Users\\Administrator\\Desktop\\p.pdf";
		try {
			SwfTools.pdf2swf(pdfPath, swfPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
