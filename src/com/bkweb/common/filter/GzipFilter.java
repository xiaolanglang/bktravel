package com.bkweb.common.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GzipFilter implements Filter {

	public void destroy() {
	}

	/**
	 * 判断浏览器是否支持GZIP
	 * 
	 * @param request
	 * @return
	 */
	private static boolean isGZipEncoding(HttpServletRequest request) {
		boolean flag = false;
		String encoding = request.getHeader("Accept-Encoding");
		if (encoding.indexOf("gzip") != -1) {
			flag = true;
		}
		return flag;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		if (isGZipEncoding(req)) {
			HttpServletResponse resp = (HttpServletResponse) response;

			System.out.println(req.getRequestURI());
			MyHttpServletResponseWrapper wrapper = new MyHttpServletResponseWrapper(resp);
			chain.doFilter(request, wrapper);
			byte[] gzipData = gzip(wrapper.getResponseData());
			resp.addHeader("Content-Encoding", "gzip");
			resp.setContentLength(gzipData.length);
			ServletOutputStream output = response.getOutputStream();
			output.write(gzipData);
			output.flush();

		} else {
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig config) throws ServletException {

	}

	private byte[] gzip(byte[] data) {
		ByteArrayOutputStream byteOutput = new ByteArrayOutputStream(10240);
		GZIPOutputStream output = null;
		try {
			output = new GZIPOutputStream(byteOutput);
			output.write(data);
		} catch (IOException e) {
		} finally {
			try {
				output.close();
			} catch (IOException e) {
			}
		}
		return byteOutput.toByteArray();
	}

	private class MyHttpServletResponseWrapper extends HttpServletResponseWrapper {
		public static final int OT_NONE = 0, OT_WRITER = 1, OT_STREAM = 2;
		private int outputType = OT_NONE;
		private ServletOutputStream output = null;
		private PrintWriter writer = null;
		private ByteArrayOutputStream buffer = null;

		public MyHttpServletResponseWrapper(HttpServletResponse resp) throws IOException {
			super(resp);
			buffer = new ByteArrayOutputStream();
		}

		public PrintWriter getWriter() throws IOException {
			if (outputType == OT_STREAM)
				throw new IllegalStateException();
			else if (outputType == OT_WRITER)
				return writer;
			else {
				outputType = OT_WRITER;
				writer = new PrintWriter(new OutputStreamWriter(buffer, getCharacterEncoding()));
				return writer;
			}
		}

		public ServletOutputStream getOutputStream() throws IOException {
			if (outputType == OT_WRITER)
				throw new IllegalStateException();
			else if (outputType == OT_STREAM)
				return output;
			else {
				outputType = OT_STREAM;
				output = new WrappedOutputStream(buffer);
				return output;
			}
		}

		public void flushBuffer() throws IOException {
			if (outputType == OT_WRITER)
				writer.flush();
			if (outputType == OT_STREAM)
				output.flush();
		}

		public void reset() {
			outputType = OT_NONE;
			buffer.reset();
		}

		public byte[] getResponseData() throws IOException {
			flushBuffer();
			return buffer.toByteArray();

		}

		class WrappedOutputStream extends ServletOutputStream {
			private ByteArrayOutputStream buffer;

			public WrappedOutputStream(ByteArrayOutputStream buffer) {
				this.buffer = buffer;
			}

			public void write(int b) throws IOException {
				buffer.write(b);
			}

			@SuppressWarnings("unused")
			public byte[] toByteArray() {
				return buffer.toByteArray();
			}
		}
	}
}
