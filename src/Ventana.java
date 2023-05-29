import javax.swing.JFrame;


public class Ventana extends JFrame {
    Login login;
    Clientes clientes;
    NuevoCliente newcliente;

    public Ventana(){
        this.setVisible(true);
        this.setLayout(null);
        this.setSize(700,522);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NuevoCliente();
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


}
