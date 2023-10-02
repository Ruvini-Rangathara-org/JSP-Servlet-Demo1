<%@ page import="com.app.controller.CustomerController" %>
<%@ page import="com.app.entity.Customer" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<%@include file="header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-12">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>#Id</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Salary</th>
                    <tr>Option</tr>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Customer> allCustomers = new CustomerController().findAllCustomers();
                    for(Customer c:  allCustomers){
                %>
                <tr>
                    <td><%=c.getId()%></td>
                    <td><%=c.getName()%></td>
                    <td><%=c.getAddress()%></td>
                    <td><%=c.getSalary()%></td>
                    <td>
                        <a class="btn btn-danger" href="delete_customer.jsp?id=<%=c.getId()%>">Delete</a> |
                        <a class="btn btn-success" href="edit_customer.jsp?id=<%=c.getId()%>" target="_blank">Update</a>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
