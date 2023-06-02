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
    
    


    public void mostrarConsultarInstructor(){
    	consultarInstructor = new ConsultarInstructor(this);
    	consultarInstructor.mostrar();
    }
    public void NuevoInstructor(){
        newInstructor = new NuevoInstructor(this);
        newInstructor.mostrar();
        repaint();
        revalidate();
    }
    public void EditarInstructor(){
        editInstructor = new EditarInstructor(this);
        editInstructor.mostrar();
        repaint();
        revalidate();
    }
    public void mostarEliminarInstructor(){
        eliminarInstructor = new EliminarInstructor(this);
        eliminarInstructor.mostrar();
        repaint();
        revalidate();
    }

    public void mostrarTarifasEditar() {
    	tarifas_editar = new EditarTarifa(this);
    	tarifas_editar.mostrar();
    	repaint();
        revalidate();
    }
    public void mostrarTarifasCrear() {
    	tarifas_crear = new CrearTarifa(this);
    	tarifas_crear.mostrar();
    	repaint();
        revalidate();
    }
    public void mostrarTarifasEliminar() {
    	tarifas_eliminar = new EliminarTarifa(this);
    	tarifas_eliminar.mostrar();
    	repaint();
        revalidate();
    }
}