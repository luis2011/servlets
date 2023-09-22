<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="./components/header.jsp"%>
<%@include file="./components/bodyPrimeraParte.jsp"%>

<h1 class="h3 mb-2 ml-4 text-gray-800">Ver Usuarios</h1>
<p class="mb-4 ml-4" >
    A continuación podrá visualizar la lista completa de usuarios
</p>

<!-- DataTales Example -->
<div class="card shadow mb-4 ml-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Rol</th>
                        <th style="width: 210px;">Acción</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Rol</th>
                        <th style="width: 210px;">Acción</th>

                    </tr>
                </tfoot>

                <%
                    List<Usuario> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");

                %>                             

                <tbody>
                    <% for (Usuario usu : listaUsuarios) {%>
                    <tr>
                        <td><%=usu.getId_usuario()%></td>
                        <td><%=usu.getNombreUsuario()%></td>
                        <td><%=usu.getRol()%></td>

                        <td style="display: flex;width: 230px;" >
                            <form name="eliminar" action="SvElimUsuarios"  method="POST"  style="margin-right: 5px;">
                                <button type="submit" class="btn btn-primary btn-user btn-block" 
                                        style="background-color:red; margin-right: 5px;" >
                                    <i class="fas fa-trash-alt"></i> Eliminar    
                                </button>
                                <input type="hidden" name="id" value="<%=usu.getId_usuario()%>">                      
                            </form>
                            <form name="editar" action="SvEditUsuarios"  method="GET" >
                                <button type="submit" class="btn btn-primary btn-user btn-block"
                                        style="margin-right: 5px;">
                                    <i class="fas fa-pencil-alt"></i> Editar    
                                </button>
                                <input type="hidden" name="id" value="<%=usu.getId_usuario()%>">                      
                            </form>                                   

                        </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
    </div>
</div>



<%@include file="./components/bodySegundaParte.jsp"%>
