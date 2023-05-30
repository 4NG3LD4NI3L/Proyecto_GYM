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
        mostrarPanelInstructor();
        //mostrarConsultarInstructor();
        //NuevoInstructor();
        //EditarInstructor();
        //mostarEliminarInstructor();
        ////////////////////////////////
        //mostrarClases();


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
}
