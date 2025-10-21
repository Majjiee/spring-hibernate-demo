<html>
<head><title>Products</title></head>
<body>
<h2>Product List</h2>
<table border="1">
    <tr><th>Name</th><th>Price</th><th>Category</th></tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.category.name}</td>
        </tr>
    </c:forEach>
</table>

<h3>Add New Product</h3>
<form action="products/add" method="post">
    Name: <input type="text" name="name"/><br>
    Price: <input type="number" name="price"/><br>
    Category:
    <select name="categoryId">
        <c:forEach var="c" items="${categories}">
            <option value="${c.id}">${c.name}</option>
        </c:forEach>
    </select><br>
    <input type="submit" value="Add Product"/>
</form>
</body>
</html>
