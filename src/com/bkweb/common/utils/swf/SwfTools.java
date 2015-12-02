package com.bkweb.common.utils.swf;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SwfTools {
	private static String toolsPath = "C:\\Users\\Administrator\\Desktop\\";

	/*
	 * 转换成swf
	 */
	public static void pdf2swf(String sourseFilePath, String targetFilePath) throws Exception {
		Runtime r = Runtime.getRuntime();
		File sourceFile = new File(sourseFilePath);
		File targetFile = new File(targetFilePath);

		int environment = 1;
		if (!targetFile.exists()) {
			if (sourceFile.exists()) {
				if (environment == 1)// windows环境处理
				{
					try {
						// 这里根据SWFTools安装路径需要进行相应更改
						Process p = r.exec(toolsPath + "pdf2swf.exe " + sourceFile.getPath() + " -o "
								+ targetFile.getPath() + " -T 9");
						System.out.print(loadStream(p.getInputStream()));
						System.err.print(loadStream(p.getErrorStream()));
						System.out.print(loadStream(p.getInputStream()));
						System.err.println("****swf转换成功，文件输出：" + targetFile.getPath() + "****");
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					}
				} else if (environment == 2)// linux环境处理
				{
					try {
						Process p = r.exec("pdf2swf " + sourceFile.getPath() + " -o " + targetFile.getPath() + " -T 9");
						System.out.print(loadStream(p.getInputStream()));
						System.err.print(loadStream(p.getErrorStream()));
						System.err.println("****swf转换成功，文件输出：" + targetFile.getPath() + "****");
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					}
				}
			} else {
				System.out.println("****资源文件不存在，无法转换****");
			}
		} else {
			System.out.println("****目标文件已存在不需要转换****");
		}
	}

	private static String loadStream(InputStream in) throws IOException {
		int ptr = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder buffer = new StringBuilder();
		while ((ptr = reader.read()) != -1) {
			buffer.append((char) ptr);
		}
		return buffer.toString();
	}
}
