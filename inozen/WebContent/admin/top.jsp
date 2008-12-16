<%@ page contentType="text/html; charset=euc-kr" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=euc-kr" />
		<title>Inozen Web Application</title>
		<link rel="stylesheet" media="screen" type="text/css" href="/css/base.css" />
		<style>
			body { background: url(/images/top_bar.png) repeat-x; }
			#logo {float:left; color:#FFFFFF; margin: 45px 10px 0 0;}
			h1 {
				color: #FFFFFF;
				font-size: 16px;
			}
			#user {float:right; color:#eee; margin: 48px 10px 0 0;}
			#logout {float:right; color:#eee; margin: 48px 10px 0 0;}
			#logout a {color:#eee;}
		</style>
	</head>
	<body>
		<div id="logo">
			<h1>INOZEN ADMIN page</h1>
		</div>
		<div id="logout">
			<a href="/j_spring_security_logout" target="_top">[Logout]</a>
		</div>
		<div id="user">
			InozenTest
		</div>
	</body>
</html>
