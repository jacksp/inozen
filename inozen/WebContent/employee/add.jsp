<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/inozen" %>
<%@ include file="/include/popupheader.jsp" %>
<%
	out.print(request.getAttribute("result"));
	out.print("<BR>");
	out.print(request.getAttribute("status"));
	out.print("<BR>");
	out.print(request.getAttribute("model"));
%>
<o:popuppage title="사원등록">
	<o:formbuttons />
	
	<o:form>
		<o:ftext label="이름" path="userName" size="10" maxlength="20" />
		<o:ftext label="아이디" path="loginId" size="15" maxlength="20" desc="최대 20자리까지 입력 할 수 있습니다." />
		<o:fpassword label="패스워드" path="password" size="10" maxlength="16" desc="최대 16자리까지 입력 할 수 있습니다." />
		<o:fradiobuttons label="성별" path="sex" items="${ref.sexType}" />
		<%--o:fcheckboxes label="취미" path="hobbies" items="${ref.hobbyType}" />
		<o:fselect label="국적" path="location" items="${ref.locations}" isCOV="yes" />
		<o:fdate label="생일" path="birthday" />
		<o:ftextarea label="메모" path="memo" rows="3" cols="50" /--%>
	</o:form>
</o:popuppage>

<%@ include file="/include/popupfooter.jsp" %>