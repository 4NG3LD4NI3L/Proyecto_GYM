import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;


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
    private int contador = 0;
    
    
    public Ventana(){
        this.setVisible(true);
        this.setLayout(null);
        this.setSize(700,522);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        pantallaCarga();
        if(contador == 2 ) {
        	mostrarLogin();	
        }
        
        repaint();
        revalidate();
    }

    public void mostrarLogin(){
        login = new Login(this); 
        login.agregar();
    }
    
    public void pantallaCarga() {
    	
    	Carga carga = new Carga();
	    add(carga);
	    Tiempo(carga);
    }
    
    public void Tiempo(JPanel panelCarga) {
  		
  		Timer timer = new Timer();
  		TimerTask tarea = new TimerTask() {
  			@Override
  			public void run() {
  				contador++;
  				if(contador == 2) {
  					mostrarLogin();
  					panelCarga.setVisible(false);
                    repaint();
  					timer.cancel();	
  				}
  			}
  		};
  		timer.schedule(tarea,0,1000);
  	}
}
