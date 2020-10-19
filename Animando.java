package MOTORCIRCLES;
import javax.swing.JFrame;

import  MOTORCIRCLES.Lienzo;

/**
 * La clase animando es lo equivalente a nuestro main, aqu� establecemos las caracteristicas del lienzo y lo ejecutamos en un
 * loop para que se pueda ver la parte gr�fica hasta que el usuario la cierre
 * @author Sergio Mendez, Jahaziel Nu�o e Isaac Gallegos
 *
 */
public class Animando extends JFrame {
	/**
	 * Poner ID al usar un Frame, pone warning en caso de no tenerlo 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * La funci�n Animando, que establece las caracteristicas del lienzo, adem�s de que contiene el loop que ejecuta todo el tiempo.
	 * Se hace un manejo de la excepci�n de interrupci�n, la cual ocurre cuando el usuario cierra la ventana de ejecuci�n
	 * @throws InterruptedException
	 */
	public Animando() throws InterruptedException {

		JFrame MotorFrame = new JFrame("Motor Jahaziel, Isaac, Sergio");
		MotorFrame.setSize(600,400);
		Lienzo motorAnimando = new Lienzo();
		MotorFrame.add(motorAnimando);
		MotorFrame.setLocationRelativeTo(null);
		MotorFrame.setVisible(true);
		MotorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		motorAnimando.addArray();
		motorAnimando.colWebInteraction();
		motorAnimando.repaint();

		while(true) {
			motorAnimando.move();
			motorAnimando.repaint();
			Thread.sleep(10);
		}
	}

	/**
	 * El main del programa, este solo ejecuta la funci�n animando
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		new Animando();
	}

}
