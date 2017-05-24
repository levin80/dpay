<%@ include file="/clouds/console/common/taglibs.jsp"%>

<%
if (request.getSession(false) != null) {
    session.invalidate();
}
%>

<c:redirect url="/clouds/console/login.jsp"/>