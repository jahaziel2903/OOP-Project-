package MOTORCIRCLES;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


/**
 * Esta clase maneja toda la parte gráfica del motor. Aquí se establece el tamaño, el número de objetos a representar, parametros de control
 * de los objetos y se crean los objetos junto con sus vectores booleanos de manejo de colision. Si se desea agregar un objeto al simulador
 * entonces se tiene que agregar aquí. Es una extensión de JPanel, para poder simplificar el trabajo gráfico
 * @author Sergio Méndez, Jahaziel Nuño e Isaac Gallegos
 *
 */
public class Lienzo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int width = 600;
	public static int height = 400;
	static int numCrcl = 8;
	public static int maxRadius = 10;
	static Circle crclArray[] = new Circle[numCrcl];
	public static isThereColVect[][] interactionCol = new isThereColVect[crclArray.length][crclArray.length];

	/**
	 * Esta función permite agregar un arreglo de circulos al lienzo, se puede hacer por medio de un for, que establece valores aleatorios
	 * a la cantidad de ciruclos establecido en los parametros, usando como ayuda otros parametros tambien establecidos, pero tambien se puede
	 * usar para definir uno por uno los circulos que se quieren, pero teniendo cuidado con que si se establezcan exactamente los circulos que
	 * se establecieron en los parametros
	 */
	public void addArray() {

		crclArray[0] = new Circle(this, 20, 10, 5, -3, 30, 4);
		crclArray[1] = new Circle(this, 100, 45, 2, 2, 10, 1);
		crclArray[2] = new Circle(this, 500, 300, -1, 2, 15, 3);
		crclArray[3] = new Circle(this, 300, 150, 1, 1, 23, 6);
		crclArray[4] = new Circle(this, 20, 10, 5, -3, 30, 4);
		crclArray[5] = new Circle(this, 100, 45, 2, 2, 10, 1);
		crclArray[6] = new Circle(this, 500, 300, -1, 2, 15, 3);
		crclArray[7] = new Circle(this, 300, 150, 1, 1, 23, 6);
	}


	/**
	 * Esta función usa dos ciclos for, uno anidado en otro, lo que hace es que a una matrix de 2 dimensiones de vectores booleanos 
	 * de colision les asigna un nuevo vector, que iniciara con sus valores en falsos, esto para poder manejar las colisiones entre
	 * todos los objetos
	 */
	public void colWebInteraction() {
		for(int i = 0; i < crclArray.length; i++) {
			for(int j = 0; j < crclArray.length; j++) {
				if(j > i)
					interactionCol[i][j] = new isThereColVect();
			}
		}
	}

	/**
	 * La función move de lienzo, que llama a la función move de todos los circulos que esten en el lienzo, luego lo que hace es actualizar
	 * los vectores de colision de todos los objetos, usando tambien el algoritmo de detección que esta en la clase Circle, por medio de 
	 * ciclos for andidados que usan el numero total de circulos en el lienzo
	 */
	public void move() {
		for(Circle Circle: crclArray) {
			Circle.moveCircle();
		}

		int maximo = crclArray.length;
		for(int i = 0; i < maximo; i++) {
			for(int j = 0; j < maximo; j++) {
				if(j > i) {
					interactionCol[i][j] = crclArray[i].detected(crclArray[j], interactionCol[i][j]);
				}
			}
		}

	}

	/**
	 * La función de paint, que recibe un parametro de tipo Graphics, lo que hace es llamar al paint de JPanel, y luego instancia el
	 * parametro Graphics para convertirlo en Graphics2D, con el fin de luego pintar cada uno de los circulos creados en el lienzo,
	 * este metodo maneja la excepcion de que uno de los objetos circulo sea un apuntador nulo
	 */
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		for(Circle Circle: crclArray) {
			try {
				Circle.paint(g2d);

			}catch(NullPointerException ex){

			}
		}
	}
}
