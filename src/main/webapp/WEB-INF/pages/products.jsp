<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

   <jsp:include page="menu.jsp" />

   <fmt:setLocale value="en_US" scope="session"/>

   <div class="page-title">Product List</div>

   <c:forEach items="${productDtos}" var="product">
       <div class="product-preview-container">
           <ul>
               <li>Id: ${product.id}</li>
               <li>Description: ${product.description}</li>
               <li>Price: <fmt:formatNumber value="${product.price}" type="currency"/></li>
               <li><a href="${pageContext.request.contextPath}/buyProduct?id=${product.id}">
                    Buy Now
                   </a>
               </li>
           </ul>
       </div>

   </c:forEach>

</body>
</html>