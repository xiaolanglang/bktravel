<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglibs.jsp" %>
<%@ attribute name="content" type="java.lang.String" required="true" description="消息内容"%>
<%@ attribute name="type" type="java.lang.String"
	description="消息类型：info、success、warning、error、loading"%>
<c:if test="${not empty content}">
	<script type="text/javascript">
		if (top.jBox!=null) {
			new top.jBox("Notice", {
				content: "${content}",
				position: {
					x: "center",
					y: "center"
				},
				autoClose: 3000
			});
		}
	</script>
</c:if>