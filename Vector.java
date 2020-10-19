package MOTORCIRCLES;
import java.lang.Math;

/**
 * La clase Vector implementa un vector en R2. En esta clase encontramos el constructor vacio y en el que se reciben los 
 * dos valores de sus componentes. Además contamos con los setter y los getters de los dos componentes, que son doubles.
 * Además, tiene otros metodos, como lo son obtener la magnitud del vector, normalizarlo, escalarlo, sumar o restar vectores y
 * obtener el producto punto de dos vectores
 * @author Sergio Méndez, Jahaziel Nuño e Isaac Gallegos
 *
 */
public class Vector {

	private double x;
	private double y;

	/**
	 * Constructor vacio de Vector, genera un vector de mangnitud 0
	 */
	public Vector() {
		this.x = 0.0;
		this.y = 0.0;
	}

	/**
	 * Constructor de vector que recibe dos doubles, que corresponden a los valores de las dos componentes del vector
	 * @param x
	 * @param y
	 */
	public Vector( double x, double y ) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Setter del componente x, recibe de parametro un double y lo asigna al valor del componente x del vector
	 * @param x
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Setter del componente y, recibe de parametro un double y lo asigna al valor del componente y del vector
	 * @param y
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Getter del componente x, regresa un double que tiene el valor del componente x del objeto Vector
	 * @return
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * Getter del componente y, regresa un double que tiene el valor del componente y del objeto Vector
	 * @return
	 */
	public double getY() {
		return this.y;
	}

	/**
	 * El metodo length te permite obtener la magnitud del vector, este es un valor double obtenido de los componentes
	 * @return
	 */
	public double length() {
		return Math.sqrt ( x*x + y*y );
	}

	/**
	 * El metodo add regresa un vector equivalente a la suma del vector con el que se llama a este metodo y otro objeto
	 * tipo vector
	 * @param v1
	 * @return
	 */
	public Vector add( Vector v1 ) {
		Vector v2 = new Vector(this.x + v1.x, this.y + v1.y );
		return v2;
	}

	/**
	 * El metodo sub regresa un vector equivalente a la resta del vector con el que se llama al metodo menos otro objeto de
	 * tipo vector
	 * @param v1
	 * @return
	 */
	public Vector sub( Vector v1 ) {
		Vector res = new Vector( this.x - v1.x, this.y - v1.y );
		return res;
	}

	/**
	 * El metodo scaling regresa un vector, que es el equivalente a el escalamiento del vector con el que se llama a este
	 * metodo por una variable tipo double, multiplicando sus componentes por este parametro
	 * @param scale
	 * @return
	 */
	public Vector scailing( double scale ) {
		Vector res = new Vector( this.x*scale, this.y*scale );
		return res;
	}

	/**
	 * El meotodo normalize regresa un vector equivalente al vector normalizado del objeto vector que llamo a este metodo,
	 * un vector normalizado es aque que mantiene la misma dirección pero su magnitud es 1
	 * @return
	 */
	public Vector normalize() {
		Vector res = new Vector();
		double size = Math.sqrt( this.x*this.x + this.y*this.y );
		if ( size != 0) {
			res.x = this.x/size;
			res.y = this.y/size;
		}
		return res;
	}   

	/**
	 * El metodo dot regresa un double, que es equivalente a realizar la operación producto punto entre el vector que
	 * llamo a este metodo y otro objeto tipo Vector que se recibe de parametro 
	 * @param v1
	 * @return
	 */
	public double dot ( Vector v1 ) {
		double res =  this.x*v1.x + this.y*v1.y;
		return res;
	}



}
