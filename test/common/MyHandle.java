package common;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.result.PrintingResultHandler;
import org.springframework.util.CollectionUtils;

import com.bkweb.common.utils.StringUtils;

/**
 * 自定义Handle
 * 
 * @author Administrator
 *
 */
public class MyHandle {
	private MyHandle() {
	}

	/**
	 * Print {@link MvcResult} details to the "standard" output stream.
	 */
	public static ResultHandler print() {
		return new ConsolePrintingResultHandler();
	}

	/**
	 * An {@link PrintingResultHandler} that writes to the "standard" output
	 * stream
	 */
	private static class ConsolePrintingResultHandler extends PrintingResultHandler {

		public ConsolePrintingResultHandler() {
			super(new ResultValuePrinter() {

				public void printHeading(String heading) {
					// System.out.println();
					// System.out.println(String.format("%20s:", heading));
				}

				public void printValue(String label, Object value) {
					if (value != null && value.getClass().isArray()) {
						value = CollectionUtils.arrayToList(value);
					}
					// System.out.println(String.format("%20s = %s", label,
					// value));
					if ("Body".equals(label) && !StringUtils.isEmpty(value.toString())) {
						System.out.println(String.format("返回内容：\r"+value));
					}
				}
			});
		}
	}

}
