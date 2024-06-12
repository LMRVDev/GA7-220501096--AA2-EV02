/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.crm.web;

import com.crm.datos.ClienteDaoJDBC;
import com.crm.dominio.Cliente;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/*
 * Esta clase servlet maneja las solicitudes HTTP entrantes a la URL "/ServletControlador".
 * Utiliza anotaciones de Java (@WebServlet) para la mapeo y se interactúa con una clase
 * ClienteDaoJDBC (probablemente en un paquete separado) para las operaciones de base de datos.
 */
@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

    /**
     * Maneja las solicitudes HTTP GET. - Recupera el parámetro "accion" de la
     * solicitud. - Según el valor de "accion", delega en los métodos adecuados
     * para manejar diferentes acciones (por ejemplo, editar, eliminar,
     * predeterminado). - Si no se especifica "accion", llama al método
     * accionDefault.
     *
     * @param request El objeto HttpServletRequest que representa la solicitud
     * entrante
     * @param response El objeto HttpServletResponse para enviar la respuesta
     * @throws ServletException Si se produce una excepción que obstaculiza la
     * ejecución del servlet
     * @throws IOException Si se produce un error de E/S durante el
     * procesamiento de la solicitud
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        }

    }

    /**
     * Maneja las solicitudes HTTP POST. - Similar a doGet, recupera el
     * parámetro "accion" y delega en métodos adecuados en función del valor
     * (insertar, modificar, eliminar).
     *
     * @param request El objeto HttpServletRequest que representa la solicitud
     * entrante
     * @param response El objeto HttpServletResponse para enviar la respuesta
     * @throws ServletException Si se produce una excepción que obstaculiza la
     * ejecución del servlet
     * @throws IOException Si se produce un error de E/S durante el
     * procesamiento de la solicitud
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        }

    }

     /**
     * El método de acción predeterminado, utilizado cuando no se proporciona
     * una "acción" específica o para la carga inicial de la página.
     * - Crea un nuevo objeto ClienteDaoJDBC para interactuar con la base de datos.
     * - Llama al método listar() en ClienteDaoJDBC para recuperar una lista de objetos Cliente.
     * - Almacena la lista recuperada en la HttpSession como un atributo llamado "Clientes".
     * - Establece otro atributo llamado "totalClientes" en la sesión, probablemente
     *   conteniendo el número total de clientes.
     * - Redirecciona la respuesta a "clientes.jsp" utilizando sendRedirect.
     *
     * @param request  El objeto HttpServletRequest que representa la solicitud entrante
     * @param response El objeto HttpServletResponse para enviar la respuesta
     * @throws ServletException   Si se produce una excepción que obstaculiza la ejecución del servlet
     * @throws IOException        Si se produce un error de E/S durante el procesamiento de la solicitud
     */
    protected void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
        * Se utiliza la entidad DaoJDBC para interactuar con la base de datos
        * y extraer la lista de clientes
         */
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("Clientes = " + clientes);

        HttpSession session = request.getSession();

        /*
         */
        session.setAttribute("Clientes", clientes);

        session.setAttribute("totalClientes", clientes.size());

        /*
         */
        response.sendRedirect("clientes.jsp");
    }

    protected void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = new ClienteDaoJDBC().buscar(new Cliente(idCliente));
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

    }

    protected void modificarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("name");
        String direccion = request.getParameter("address");
        String ciudad = request.getParameter("city");
        String barrio = request.getParameter("neighborhood");
        String telefono = request.getParameter("phone_number");

        Cliente cliente = new Cliente(direccion, ciudad, nombre, barrio, telefono);
        int registrosModificados = new ClienteDaoJDBC().actualizar(cliente);
        this.accionDefault(request, response);
    }

    protected void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("name");
        String direccion = request.getParameter("address");
        String ciudad = request.getParameter("city");
        String barrio = request.getParameter("neighborhood");
        String telefono = request.getParameter("phone_number");

        Cliente cliente = new Cliente(direccion, ciudad, nombre, barrio, telefono);
        int registrosModificados = new ClienteDaoJDBC().insertar(cliente);
        this.accionDefault(request, response);
    }

    protected void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = new Cliente(idCliente);
        int registrosModifiados = new ClienteDaoJDBC().eliminar(cliente);
        this.accionDefault(request, response);

    }

}
