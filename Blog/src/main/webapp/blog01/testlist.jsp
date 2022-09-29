<%--
  Created by IntelliJ IDEA.
  User: hung
  Date: 9/14/2022
  Time: 11:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>User Management Application</title>
</head>
<body>
<center>
  <h1>User Management</h1>
  <h2>
    <a href="/users?action=create">Add New User</a>
  </h2>
  <div class="input-group rounded">
    <form action="/users" method="get">
      <input type="text" name="name">
      <button>search</button>
    </form>
  </div>
</center>
<div class="row tm-row">
  <c:forEach var="p" items="${listPost}">
    <article class="col-12 col-md-6 tm-post">
      <hr class="tm-hr-primary">
      <a href="post.html" class="effect-lily tm-post-link tm-pt-60">
        <div class="tm-post-link-inner">
          <img src="blog01/img/${p.image}" alt="Image" class="img-fluid">
        </div>
        <span class="position-absolute tm-new-badge">New</span>
        <h2 class="tm-pt-30 tm-color-primary tm-post-title">${p.title}</h2>
      </a>
      <p class="tm-pt-30">
          ${p.content}
      </p>
      <div class="d-flex justify-content-between tm-pt-45">
        <span class="tm-color-primary">Travel . Events</span>
        <span class="tm-color-primary">June 24, 2020</span>
      </div>
      <hr>
      <div class="d-flex justify-content-between">
        <span>36 comments</span>
        <span>by Admin Nat</span>
      </div>
    </article>
  </c:forEach>
</div>
</body>
</html>
