<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Play Lottery</title>
</head>

<body>

	<font color="black">
		<center />
		<h1>SELECT YOUR WINNING NUMBERS</h1>
		<h2>Pick 6 numbers from 1-46</h2>
		<form action="play.do" method="post">
			<input name="num1" type="number" min="1" max="46"><br /> <input
				name="num2" type="number" min="1" max="46"><br /> <input
				name="num3" type="number" min="1" max="46"><br /> <input
				name="num4" type="number" min="1" max="46"><br /> <input
				name="num5" type="number" min="1" max="46"><br /> <input
				name="num6" type="number" min="1" max="46"><br />
			<button type="submit">Enter</button>
		</form> <c:if test="${!empty winningnumbers }">

			<div class="display">
				<p>Your Picks</p>
				<c:forEach var="num" items="${yourpicks}">
					<c:out value="${num }" />
				</c:forEach>
				<br />
				<p>Winning Numbers</p>
				<c:forEach var="win" items="${winningnumbers}">
					<c:out value="${win }" />
				</c:forEach>
			</div>
			<h3>History</h3>
			<c:forEach var="pastSet" items="${winningHistory}">
				<c:forEach var="oldNum" items="${pastSet }">
					<c:out value="${oldNum }" />
				</c:forEach>
				<br />
			</c:forEach>
		</c:if>
	</font>
</body>
</html>