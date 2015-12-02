package com.bkweb.common.utils.hibernatepage;

public class HpageUtils {

	private static String funcName = "bk.page";// 函数名称
	private static int length = 5;// 分页长度
	private static int slider = 1;// 前后显示页面长度

	public static String page(HPage<?> page) {
		int first = 1, pageNum = page.getPageNum(), pageSize = page.getPageSize(), last = 0, prev = 0, next = 0;
		long count = page.getCount();

		last = (int) (count / (pageSize < 1 ? 20 : pageSize) + first - 1);

		if (count % pageSize != 0 || last == 0) {
			last++;
		}

		if (last < first) {
			last = first;
		}

		if (pageNum <= 1) {
			pageNum = first;
		}

		if (pageNum >= last) {
			pageNum = last;
		}

		if (pageNum < last - 1) {
			next = pageNum + 1;
		} else {
			next = last;
		}

		if (pageNum > 1) {
			prev = pageNum - 1;
		} else {
			prev = first;
		}

		// 2
		if (pageNum < first) {// 如果当前页小于首页
			pageNum = first;
		}

		if (pageNum > last) {// 如果当前页大于尾页
			pageNum = last;
		}

		StringBuilder sb = new StringBuilder();

		if (pageNum == first) {// 如果是首页
			sb.append("<a class=\"disabled btn btn-default\" href=\"javascript:\">上一页</a>\n");
		} else {
			sb.append("<a class=\"btn btn-default\" href=\"javascript:\" onclick=\"" + funcName + "(" + prev + "," + pageSize + ");\">上一页</a>\n");
		}

		int begin = pageNum - (length / 2);

		if (begin < first) {
			begin = first;
		}

		int end = begin + length - 1;

		if (end >= last) {
			end = last;
			begin = end - length + 1;
			if (begin < first) {
				begin = first;
			}
		}

		if (begin > first) {
			int i = 0;
			for (i = first; i < first + slider && i < begin; i++) {
				sb.append("<a class=\"btn btn-default\" href=\"javascript:\" onclick=\"" + funcName + "(" + i + "," + pageSize + ");\">"
						+ (i + 1 - first) + "</a>\n");
			}
			if (i < begin) {
				sb.append("<a class=\"disabled btn btn-default\" href=\"javascript:\">...</a>\n");
			}
		}

		for (int i = begin; i <= end; i++) {
			if (i == pageNum) {
				sb.append("<a class=\"active btn btn-default\" href=\"javascript:\">" + (i + 1 - first) + "</a>\n");
			} else {
				sb.append("<a class=\"btn btn-default\" href=\"javascript:\" onclick=\"" + funcName + "(" + i + "," + pageSize + ");\">"
						+ (i + 1 - first) + "</a>\n");
			}
		}

		if (last - end > slider) {
			sb.append("<a class=\"disabled btn btn-default\" href=\"javascript:\">...</a>\n");
			end = last - slider;
		}

		for (int i = end + 1; i <= last; i++) {
			sb.append("<a class=\"btn btn-default\" href=\"javascript:\" onclick=\"" + funcName + "(" + i + "," + pageSize + ");\">"
					+ (i + 1 - first) + "</a>\n");
		}

		if (pageNum == last) {
			sb.append("<a class=\"disabled btn btn-default\" href=\"javascript:\">下一页 </a>\n");
		} else {
			sb.append("<a class=\"btn btn-default\" href=\"javascript:\" onclick=\"" + funcName + "(" + next + ");\">" + "下一页</a>\n");
		}

//		sb.append("<a class=\"disabled controls btn btn-default\" href=\"javascript:\">当前第");
//		sb.append("<input type=\"text\" value=\"" + pageNum
//				+ "\" onkeypress=\"var e=window.event||this;var c=e.keyCode||e.which;if(c==13)");
//		sb.append(funcName + "(this.value," + pageSize + ");\" onclick=\"this.select();\"/> / ");
//		sb.append("<input type=\"text\" value=\"" + pageSize
//				+ "\" onkeypress=\"var e=window.event||this;var c=e.keyCode||e.which;if(c==13)");
//		sb.append(funcName + "(" + pageNum + ",this.value);\" onclick=\"this.select();\"/> 条，");
//		sb.append("</a>\n");

//		sb.append("<div style=\"clear:both;\"></div>");

		 sb.insert(0,"<div>\n").append("</div>\n");

		return sb.toString();
	}
}
