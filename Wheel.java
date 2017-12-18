import java.util.Random;

/**
 * The class Wheel is a child class of the class RouletteTable which keeps track of the winning number and has the method spin the wheel.
 * @author Hoai An Luu (27187661)
 * @author Tri-Luong Steven Dien (27415281)
 *
 */
public class Wheel extends RouletteTable {
	private String winningNumber = "";

	/**
	 * Constructor that sets the roulette to the chosen roulette and that takes its parameter from the parent class with the method super().
	 * @param whichRoulette the chosen roulette.
	 */
	public Wheel(int whichRoulette) {
		super(whichRoulette);
		winningNumber = "";
	}

	/**
	 * Accessor method that returns the winning number on the wheel.
	 * @return winningNumber the winning number.
	 */
	public String getWinningNumber()
	{
		return winningNumber;
	}
	
	/**
	 * Mutator method that sets the winning number of the wheel and that takes a string as parameter.
	 * @param number the set winning number.
	 */
	public void setWinningNumber(String number)
	{
		winningNumber = number;
	}
	
	/**
	 * Redefinition of the method toString() to allow the printing of the data members of the winning number.
	 * @return the winning number.
	 */
	public String toString()
	{
		return ("The winning number is: " + winningNumber);
	}

	/**
	 * Redefinition of the method equals() to allow the comparison of two wheels.
	 * @param otherWheel the second object of Wheel used to compare.
	 * @return true if two winning numbers on two different wheels have the same value, else false.
	 */
	public boolean equals(Wheel otherWheel)
	{
		return (winningNumber.equals(otherWheel.winningNumber));
	}

	/**
	 * Method that generates a random winning number on the wheel when spun. 
	 * @param chosenRoulette the chosen roulette.
	 * @return the winning number.
	 */
	public String spinTheWheel(String[] chosenRoulette)
	{
		int randomIndexNumber = 0;
		Random rand = new Random();

		randomIndexNumber = rand.nextInt(chosenRoulette.length - 1);

		winningNumber = chosenRoulette[randomIndexNumber];

		return winningNumber;
	}
}
