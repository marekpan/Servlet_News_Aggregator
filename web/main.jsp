<%@ page import="marekpan.news.model.*" %>
<%@ page import="java.util.List" %>
<%@ page pageEncoding="UTF-8" %>
<% List<News> news = (List) request.getAttribute("news"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Feed</title>
</head>
<body>
<div class="container">

<div class="page-header text-center">
<h1>News Aggregator by marekpan</h1>
</div>

<% for (News src : news) {%>
<table class="table table-hover table-condensed">
<thead>
<tr>
<th><strong><h3> <%=src.getName()%> </h3></strong></th>
</tr>
</thead>
<tbody>

<% List<NewsItem> paper = src.getNews(); %>
<% for(NewsItem item : paper) { %>
<tr>
<td><span class="glyphicon glyphicon-align-justify"></span><a href=" <%=item.getLink()%> "> <%= item.getText() %> </td>
</tr>
<% } %>
</tbody>
</table>
<% } %>

</div>
</body>
</html>