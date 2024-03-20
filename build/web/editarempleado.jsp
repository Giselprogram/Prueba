<%@page import="Control.accionesEmpleado"%>
<%@page import="modelo.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <h1>Tabla Para Actualizar Empleados</h1>
    <br> 
    <form method="post" name="actualizarempleado" action="actualizarEmpleado">
        <table border="2">
            <% 
                int id = Integer.parseInt(request.getParameter("id"));
                Empleado e = accionesEmpleado.buscarEmpleadoById(id);
                if (e != null) {
            %>
                <tr>
                    <td>ID</td>
                    <td><input type="hidden" name="id2" value="<%= e.getId() %>"></td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre2" size="30" value="<%= e.getNombre() %>"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password2" size="30" value="<%= e.getPassword() %>"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email2" size="30" value="<%= e.getEmail() %>"></td>
                </tr>
                <tr>
                    <td>Pais:</td>
                    <td>
                        <select name="pais2">
                            <option value="Mexico">Mexico</option>
                            <option value="Colombia">Colombia</option>
                            <option value="España">España</option>
                            <option value="Venezuela">Venezuela</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Actualizar Empleado">
                    </td>
                </tr>
            <% } else { %>
                <tr>
                    <td colspan="2">Empleado no encontrado</td>
                </tr>
            <% } %>
        </table>
    </form>
    <br>
</body>
</html>

