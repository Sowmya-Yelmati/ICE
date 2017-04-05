<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           <%@ page import="java.util.Collection,
                 java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
  <style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
<form method="post" action="hello">
   Enter Symbol:<br>
  <input type="text" name="symbol" Placeholder="Enter the symbol ex:PCS" autocomplete="on">  <input type="submit" name="AddSymbol" value="Add to portfolio"> 
  <br><br>
  <input type="submit" name="search" value="search"> 
</form> 
<br><br><br><br>
<form method= "get" action= "DB">
<input type="submit" value="My Portfolio">
</form>

<form method="post" action="del">
<table border = "5">
<tr>
<th> Company Name </th>
<th> Symbol </th>
<th> Last Trade Price </th>
</tr>
    <c:forEach items="${requestScope.listobj}" var="stockBean">
        <tr>
            <td> <c:out value="${stockBean.getCompanyName()}" /> </td>
            <td> <c:out value="${stockBean.getSymbol()}" /> </td>
            <td> <c:out value="${stockBean.getLastTradePrice()}" /> </td>
            <td> <c:out value="${stockBean.getSharesOwned()}" /> </td>
            <td> <form action="del" method="get">
    			<input type="hidden" name="symbolid" value="${stockBean.getSymbol()}" />
    			<input type="submit" name="delete" value="remove" /></form> </td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>