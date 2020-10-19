package MOTORCIRCLES;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Clase que define el objeto circulo, donde se establecen, además de las variables de Shapes2D, los parametros lienzo y radius, que son
 * tipo Lienzo y entero respectivamente. En esta clase se manejan todos los getters y setters del circulo, además del manejo de
 * colisiones, la función booleana de la colision, el movimeinto del circulo en el lienzo y el que se pinten adecuadamente
 * @author Sergio Méndez, Jahaziel Nuño e Isaac Gutierrez
 *
 */
public class Circle extends Shapes2D {

	private int radius;

	public Lienzo lienzo;
	
	/**
	 * El constructor de circle, que recibe un objeto Lienzo, extensión de JPanel, para la parte gráfica, además de los datos de posición y
	 * velocidad que se utilizan para crear dos vectores, y los datos radio y masa que son parametros para la creación del circulo y que
	 * definen la interacción con las paredes y los otros circulos
	 * @param lienzo
	 * @param xPos
	 * @param yPos
	 * @param xSpeed
	 * @param ySpeed
	 * @param radius
	 * @param masa
	 */
	public Circle(Lienzo lienzo, int xPos, int yPos, int xSpeed, int ySpeed, int radius, int masa) {
		super(xPos,yPos,xSpeed,ySpeed, masa);
		this.lienzo = lienzo;	   
		this.radius = radius/2;
	}
	
	/**
	 * Regresa el valor del radio del circulo, que es un entero
	 * @return
	 */
	public int getRadius() {
		return this.radius;
	}
	
	/**
	 * Permite establecer el valor del radio del circulo
	 * @param radius
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	/**
	 * Este programa obtiene un objeto shapes, para que se pueda implementar con diferentes tipos de objetos, esto lo que realiza es
	 * el calculo del vector de fuerza que resultara de la interacción entre un circulo y el objeto recibido, y se lo asigan tanto al 
	 * circulo como al objeto con el que colisiono
	 * @param c1
	 */
	public void collisionHandle(Shapes2D c1) { 
		double e = 0.9; 
		Vector newDirection; 
		newDirection = this.position.sub(c1.position);
		newDirection = newDirection.normalize();
		
		double velocity1 = this.speed.dot(newDirection);
		double velocity2 = c1.speed.dot(newDirection);
		
		double newVelocity1 = ( ((this.getMass() - e*c1.getMass())*velocity1) + ((1+e)*c1.getMass()*velocity2) ) / (this.getMass() + c1.getMass());
		double newVelocity2 = ( ((c1.getMass() - e*this.getMass())*velocity2) + ((1+e)*this.getMass()*velocity1) ) / (this.getMass() + c1.getMass());
	
		Vector v1Final = this.speed.add(newDirection.scailing(newVelocity1 - velocity1));
		Vector v2Final = c1.speed.add(newDirection.scailing(newVelocity2-velocity2));

		this.speed.setX(v1Final.getX());
		this.speed.setY(v1Final.getY());
		c1.speed.setX(v2Final.getX());
		c1.speed.setY(v2Final.getY());
	}	

	/**
	 * Establece, según los valores de posición y velocidad, la nueva posción del circulo, además de que maneja la colisión con las paredes,
	 * dando la inversa de la velocidad correspondiente según la pared con la que choco, para que núnca se salga del marco establecido
	 */
	public void moveCircle() {
		
		if(super.speed.getY() + super.position.getY() + this.radius > 400)
			this.speed.setY(-1*this.speed.getY());
		
		else if(super.position.getY() <= 0)
			this.speed.setY(-1*this.speed.getY()); 
		
		else
			this.speed.setY(this.speed.getY() + .1);
		
		if(super.position.getX() + this.radius + this.speed.getX() > 600 || this.position.getX() - this.radius <= 0)
			this.speed.setX(-1*this.speed.getX()); 
		
		super.position.setY(super.position.getY() + super.speed.getY());	
		super.speed.setY(super.speed.getY());
		super.speed.setX(super.speed.getX());
		super.position.setX(super.speed.getX() + super.position.getX() + (0.1*0.6));
	}

	/**
	 * Recibe un parametro Graphics2D, el cual permite establecer elementos gráficos en un lienzo, este código lo que hace es dibujar
	 * el circulo que este dentro del objeto Graphics2D mandado, haciendo el marco negro y el relleno azul
	 * @param g
	 */
	public void paint(Graphics2D g) {
		g.setColor(Color.black);
		g.drawOval((int)(super.position.getX() - (radius)),(int) (super.position.getY() - (radius)), radius*2, radius*2);
		g.setColor(Color.blue);
		g.fillOval((int)(super.position.getX() - (radius)),(int) (super.position.getY() - (radius)), radius*2, radius*2);
	}
	
	/**
	 * Este metodo lo que hace es generar el vector booleano que nos dice si hubo una colision, además de donde fue esta, esta pensado para
	 * que pueda funcionar con cualquier objeto Shapes2D si se agrega el código adecuado, pero por ahora solo esta implementado con otro
	 * circulo, lo que hace es un algoritmo basado en la distancia y los radios de los circulos, regresa un vector de colision, el cual
	 * sirve en el manejo de colisión para establecer si se hace la interacción o no por medio de una bandera de otra clase, bandera para eje x(i)
	 * y para el eje Y(j)
	 * @param circleRectangle
	 * @param Col
	 * @return
	 */
	public isThereColVect detected(Shapes2D circleRectangle,isThereColVect Col) { 
		isThereColVect NewColision = Col;
		
		if(circleRectangle instanceof Circle) {
			
			float DistanceInX = (float) (circleRectangle.position.getX() - super.position.getX());
			float DistanceInY = (float) (circleRectangle.position.getY() - super.position.getY());
			double distance = Math.sqrt(( (DistanceInX * DistanceInX) + (DistanceInY * DistanceInY) ));
			double sumRadius = ((Circle) circleRectangle).radius + this.radius;
		
			if(distance < sumRadius) { //hay colision
				while(NewColision.thereIsColisionI == false && NewColision.thereIsColisionJ == false){
					collisionHandle(circleRectangle);
					NewColision.thereIsColisionI = true;
					NewColision.thereIsColisionJ = true;
				}
				return NewColision;
			}
			else if(distance >= sumRadius) {  
				NewColision.thereIsColisionI = false;
				NewColision.thereIsColisionJ = false;
			}
			return NewColision;
		}
	return NewColision;
	}
}
