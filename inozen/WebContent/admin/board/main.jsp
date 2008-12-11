<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/inozen" %>
<%@ taglib prefix="a" tagdir="/WEB-INF/tags/inozen/admin" %>
<%@ include file="/admin/include/searchheader.jsp" %>
<div id="title">
	<h1>게시판 관리</h1>
</div>
		
<div id="tree" class="ifrmbox40">
	<iframe id="tree" name="tree" src="/common/tree/tree.do?type=2&target=boardList&src=/admin/board/boardList.do" height="300" scrolling="auto" frameborder="0" width="100%">
	</iframe>
</div>
<div id="list" class="ifrmbox60">
	<iframe id="boardList" name="boardList" src="boardList.do" height="300" scrolling="auto" frameborder="0" width="100%">
	</iframe>
</div>
<%@ include file="/admin/include/searchfooter.jsp" %>