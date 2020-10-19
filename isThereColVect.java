package MOTORCIRCLES;

/**
 * Clase que define un vector de dos dimensiones booleano, que establece en que eje hubo colision de un objeto Shapes
 * @author Sergio Méndez, Jahaziel Nuño e Isaac Gallegos
 *
 */
public class isThereColVect {
	public boolean thereIsColisionI;
	public boolean thereIsColisionJ;

	/**
	 * El constructor de la clase, establece los valores del vector booleano de colision en false, ya que al principio no debería haber colision
	 */
	public isThereColVect() {
		thereIsColisionI = false;
		thereIsColisionJ = false;
	}

	/**
	 * Constructor de la clase, recibe dos datos booleanos y los asigna a los corrrespondientes componentes del vector, para establecer si hubo
	 * alguna colision en los ejes del objeto
	 * @param Xlim
	 * @param Ylim
	 */
	public isThereColVect(boolean Xlim, boolean Ylim) {
		this.thereIsColisionI = Xlim;
		this.thereIsColisionJ = Ylim;
	}

}
