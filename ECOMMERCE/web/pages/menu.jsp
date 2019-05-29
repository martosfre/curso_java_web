<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ECOMMERCE:.Menú General.::</title>
<%-- Código Java - Directiva de Declaración --%>
<%!HttpSession sesion = null;%>
<!-- Código HTML -->
</head>
<body>
	<%--Scriptlets --%>
	<%
		session = request.getSession();
	%>
	<div id="divGen">
		<div id="divBanner">
			<table>
				<tr>
					<%-- Directiva de Expresión --%>
					<td><img src="./resources/img/imgBannerEcommerce800x150.png" /></td>
					<td><div
							style="background-color: #e6e6e6; height: 86px; padding-top: 65px;">
							<label><b>Usuario:<%=session.getAttribute("usuario")%></b></label>
							<br></br>
							<a href="./abz333">Salir</a>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div id="divContenido"></div>
		<div id="divFooter"></div>
	</div>
</body>
</html>