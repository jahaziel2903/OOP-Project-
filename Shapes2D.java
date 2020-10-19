package MOTORCIRCLES;

/**
 * La clase abstracta Shapes2D, que establece las caracteristicas basicas de cualquier objeto bidimensional, que son su masa, posición y velocidad.
 * En esta se tienen los constructores que necesitamos, además de los getter y setter necesarios para los parametros establecidos
 * @author Sergio Méndez, Jahaziel Nuño e Isaac Gallegos
 *
 */
public abstract class Shapes2D{

	private int mass;
	protected Vector position = new Vector();
	protected Vector speed = new Vector();

	/**
	 * El constructor de Shapes2D, recibe la posición en x además de en y, además de las componentes de velocidad, estos dos pares se convertiran en vectores
	 * de posición y velocidad, además recibe la masa del objeto, que es importante para la interacción con otros
	 * @param x_pos
	 * @param y_pos
	 * @param x_vel
	 * @param y_vel
	 * @param mass
	 */
	public Shapes2D(int x_pos, int y_pos, int x_vel, int y_vel ,int mass){  
		this.position.setX(x_pos);   
		this.position.setY(y_pos);
		this.speed.setX(x_vel);  
		this.speed.setY(y_vel);  
		this.mass = mass;  
	}

	/**
	 * Constructor de Shapes2D, que solo recibe posición, genera un vector de posición según los datos dados, y genera un vector de velocidad con
	 * magnitud 0, además de que asigna una masa de 1
	 * @param x_pos
	 * @param y_pos
	 */
	public Shapes2D(int x_pos, int y_pos) {
		this(x_pos, y_pos, 0, 0, 1);
	}

	/**
	 * El getter de posición en x, regresa el componente x del vector posición, el cual es un double
	 * @return
	 */
	public double getX_position() {
		return this.position.getX();
	}

	/**
	 * El getter de posición en y, regresa el componente y del vector posición, el cual es un double
	 * @return
	 */
	public double getY_position() {
		return this.position.getY();
	}

	/**
	 * El setter de la posición en x, recibe un double y lo asigna al valor del componente x del vector posición
	 * @param x
	 */
	public void setX_position(double x) {
		this.position.setX(x);
	}

	/**
	 * El setter de la posición en y, recibe un double y lo asigna al valor del componente y del vector posición
	 * @param y
	 */
	public void setY_position(double y) {
		this.position.setY(y);
	}

	/**
	 * El getter de la velocidad en x, obtiene el valor del componente en x del vector velocidad
	 * @return
	 */
	public double getX_vel() {
		return this.speed.getX();
	}

	/**
	 * El getter de la velocidad en y, obtiene el valor del componente en y del vector velocidad
	 * @return
	 */
	public double getY_vel() {
		return this.speed.getY();
	}

	/**
	 * El setter de la velocidad en x, recibe un double, que se asigna como el componente en x del vector velocidad
	 * @param x
	 */
	public void setX_vel(double x) {
		this.speed.setX(x);
	}

	/**
	 * El setter de la velocidad en y, recibe un double, que se asigna como el componente en y del vector velocidad
	 * @param y
	 */
	public void setY_vel(double y) {
		this.speed.setY(y);
	}

	/**
	 * El getter de la masa del objeto, obtiene el valor entero que representa la magnitud de la masa asignada
	 * @return
	 */
	public int getMass() {
		return this.mass;
	}

	/**
	 * El setter de la masa del objeto, recibe un entero y lo asigna al valor de la variable masa
	 * @param mass
	 */
	public void setMass(int mass) {
		this.mass = mass;
	}

}