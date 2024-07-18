<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<td>TicketId</td>
			<td>${ticketdata.ticketId}</td>
		</tr>
		<tr>
			<td>From</td>
			<td>${ticketdata.from}</td>
		</tr>
		<tr>
			<td>To</td>
			<td>${ticketdata.to}</td>
		</tr>
		<tr>
			<td>DOJ</td>
			<td>${ticketdata.doj}</td>
		</tr>
		<tr>
			<td>TicketAmount</td>
			<td>${ticketdata.ticketamt}</td>
		</tr>
		<tr>
			<td>TicketStatus</td>
			<td>${ticketdata.ticketStatus}</td>
		</tr>

	</table>
	<a href="/">Back to home?</a>

</body>
</html>