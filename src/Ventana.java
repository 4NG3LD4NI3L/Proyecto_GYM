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
    TarifasEditar tarifas_editar;
    TarifasCrear tarifas_crear;
    TarifasEliminar tarifas_eliminar;
    
    
    public Ventana(){
        this.setVisible(true);
        this.setLayout(null);
        this.setSize(700,522);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //mostrarLogin();

        //Clientes

        //mostrarConsultaCliente();
        // mostrarPanelCliente();
        //NuevoCliente();
        //EditarCliente();
        //mostarEliminarCliente();
        //mostrarConsultaCliente();

        //Instructor
        //mostrarPanelInstructor();
        //mostrarConsultarInstructor();
        //NuevoInstructor();
        //EditarInstructor();
        //mostarEliminarInstructor();
        ////////////////////////////////
        //mostrarClases();

        //Tarifas
        mostrarTarifas();

        repaint();
        revalidate();
    }

    public void mostrarLogin(){
        login = new Login(this); 
        login.agregar();
    }

    public void mostrarPanelCliente(){
        clientes = new Clientes(this); 
        clientes.mostrar();

    }
    
    
    public void NuevoCliente(){
        newcliente = new NuevoCliente(this);
        newcliente.mostrar();
        repaint();
        revalidate();
    }

    public void EditarCliente(){
        editCliente = new EditarCliente(this);
        editCliente.mostrar();
        repaint();
        revalidate();
    }

    public void mostrarClases(){
        clases = new Clases(this);
        clases.mostrar();
        repaint();
        revalidate();
    }

    public void mostarEliminarCliente(){
        eliminarCliente = new EliminarCliente(this);
        eliminarCliente.mostrar();
        repaint();
        revalidate();
    }

    public void mostrarConsultaCliente(){
        consultaCliente = new ConsultarCliente(this);
        consultaCliente.mostrar();
        repaint();
        revalidate();
    }

    public void mostrarMenu(){
        menu = new Menu(this);
        menu.mostrar();
        repaint();
        revalidate();
    }
    public void mostrarPanelInstructor(){
    	instructor = new Instructor(this);
    	instructor.mostrar();
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

    public void mostrarTarifas(){
        tarifa = new Tarifas(this);
        tarifa.mostrar();
        repaint();
        revalidate();
    }
    public void mostrarTarifasEditar() {
    	tarifas_editar = new TarifasEditar(this);
    	this.add(tarifas_editar);
    	repaint();
        revalidate();
    }
    public void mostrarTarifasCrear() {
    	tarifas_crear = new TarifasCrear(this);
    	this.add(tarifas_crear);
    	repaint();
        revalidate();
    }
    public void mostrarTarifasEliminar() {
    	tarifas_eliminar = new TarifasEliminar(this);
    	this.add(tarifas_eliminar);
    	repaint();
        revalidate();
    }
}