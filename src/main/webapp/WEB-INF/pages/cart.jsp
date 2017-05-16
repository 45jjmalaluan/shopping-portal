<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Shopping Cart</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

    <jsp:include page="menu.jsp" />

    <fmt:setLocale value="en_US" scope="session"/>

    <div class="page-title">My Cart</div>

    <c:if test="${empty cartDto or empty cartDto.items}">
        <h2>Empty Cart</h2>
        <a href="${pageContext.request.contextPath}/products">Show Product List</a>
    </c:if>

    <c:if test="${ not empty cartDto and not empty cartDto.items }">
        <form:form method="POST" modelAttribute="cartDto"
                   action="${pageContext.request.contextPath}/cart">

            <c:forEach items="${cartDto.items}" var="item" varStatus="varStatus">
                <div class="product-preview-container">
                    <ul>
                        <li>Code: ${item.product.id}
                            <form:hidden path="items[${varStatus.index}].product.id" />

                        </li>
                        <li>Description: ${item.product.description}</li>
                        <li>Price:
                            <span class="price">
                                <fmt:formatNumber value="${item.product.price}" type="currency"/>
                           </span>
                        </li>
                        <li>Quantity: <form:input path="items[${varStatus.index}].quantity" /></li>
                        <li>Subtotal:
                             <span class="subtotal">
                                <fmt:formatNumber value="${item.amount}" type="currency"/>
                             </span>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/removeCartProduct?productId=${item.product.id}">Delete</a></li>
                    </ul>
                </div>
            </c:forEach>
            <div style="clear: both"></div>
            <input class="button-update-sc" type="submit" value="Update Quantity" />
            <a class="navi-item" href="${pageContext.request.contextPath}/products">Continue Buy</a>
        </form:form>

    </c:if>

</body>
</html>
