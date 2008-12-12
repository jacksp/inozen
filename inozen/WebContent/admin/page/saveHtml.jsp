<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ include file="/admin/include/popupheader.jsp" %>

<div id="title">
	<h1>페이지 등록</h1>
</div>
<div id="buttons">

	<script>
		var saveHandler = function() {
			$("form").submit();
		}
	
		var cancelHandler = function() {
			window.close();
		}
	</script>	

	<a href="javascript:void(1)" id="savebtn" class="savebtn">저장</a>
	<a href="javascript:void(1)" id="cancelbtn" class="cancelbtn">취소</a>
	
	<script type="text/javascript"> 
		Event.observe("savebtn", "click", saveHandler, false);
	
		Event.observe("cancelbtn", "click", cancelHandler, false);	
	</script>
</div>
<div id="formbox">
	<form id="form" action="/admin/page/saveHtml.do" method="post">
		<div class="formblock">
			<p>
				<label>페이지 이름 :</label>
				<input id="pageName" name="pageName" type="text" value="" size="50" maxlength="15"/>&nbsp;
			</p>
			<p>
				<label>페이지 제목 :</label>
				<input id="pageTitle" name="pageTitle" type="text" value="" size="100" maxlength="255"/>&nbsp;
			</p>
			<p>
				<label>메타정보1 :</label>
				<input id="pageMetaInfo1" name="pageMetaInfo1" type="text" value="" size="100" maxlength="255"/>&nbsp;
			</p>
			<p>
				<label>메타정보2 :</label>
				<input id="pageMetaInfo2" name="pageMetaInfo2" type="text" value="" size="100" maxlength="255"/>&nbsp;
			</p>
			<p>
				<label>메타정보3 :</label>
				<input id="pageMetaInfo3" name="pageMetaInfo3" type="text" value="" size="100" maxlength="255"/>&nbsp;
			</p>
			<p>
				<label>메타정보4 :</label>
				<input id="pageMetaInfo4" name="pageMetaInfo4" type="text" value="" size="100" maxlength="255"/>&nbsp;
			</p>
			<p>
				<label>메타정보5 :</label>
				<input id="pageMetaInfo5" name="pageMetaInfo5" type="text" value="" size="100" maxlength="255"/>&nbsp;
			</p>
			<p>
				<label>페이지 태그 :</label>
				<input id="pageTag" name="pageTag" type="text" value="" size="100" maxlength="100"/>&nbsp;
			</p>
			<p>
				<label>페이지 경로 :</label>
				<input id="pageLocation" name="pageLocation" type="text" value="" size="100" maxlength="255"/>&nbsp;
			</p>
		</div>
	</form>
</div>
<%@ include file="/admin/include/popupfooter.jsp" %>