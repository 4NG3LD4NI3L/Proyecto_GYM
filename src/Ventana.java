import javax.swing.JFrame;


public class Ventana extends JFrame {
    private static final long serialVersionUID = 1L;
	Login login;
    Clientes clientes;
    NuevoCliente newcliente;
    EditarCliente editCliente;
    Clases clases;
    EliminarCliente eliminarCliente;
    ConsultarCliente consultaCliente;
    Menu menu;
    Instructor instructor;
    ConsultarInstructor consultarInstructor;
    NuevoInstructor newInstructor;
    EditarInstructor editInstructor;
    EliminarInstructor eliminarInstructor;
    Tarifas tarifa;
    EditarTarifa tarifas_editar;
    CrearTarifa tarifas_crear;
    EliminarTarifa tarifas_eliminar;
    
    
    public Ventana(){
        this.setVisible(true);
        this.setLayout(null);
        this.setSize(700,522);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mostrarLogin();
        
        repaint();
        revalidate();
    }

    public void mostrarLogin(){
        login = new Login(this); 
        login.agregar();
    }
}