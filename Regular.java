/**
 * The class Regular is a child class of the parent class Player which keeps track the total bets and the total winnings of Regular player(s)
 * @author Hoai An Luu (27187661)
 * @author Tri-Luong Steven Dien (27415281)
 *
 */
public class Regular extends Player{
	private final int TOKEN_VALUE = 5;
	
	/**
	 * Constructor that sets the player status to Regular and takes its parameters from the parent class using the method super()
	 */
	public Regular()
	{
		super();
		setPlayerStatus("Regular");
	}
	
	/**
	 * Accessor method that returns the value of tokens used by Regular
	 * @return TOKEN_VALUE the value of tokens
	 */
	public int getTokenValue()
	{
		return TOKEN_VALUE;
	}
	
	/**
	 * Accessor method that returns the total bets of Regular
	 * @return totalPlayersBets the total bets of Regular
	 */
	public int getTotalPlayerBets()
	{
		return totalPlayerBets;
	}
	
	/**
	 * Accessor method that returns the total winnings of Regular
	 * @return totalPlayerWinnings the total winnings of Regular
	 */
	public int getTotalPlayerWinnings()
	{
		return totalPlayerWinnings;
	}
	
	/**
	 * Mutator method that sets the total winning of Regular that takes an integer as parameter.
	 * @param playerWinnings the set Regular player's total winning
	 */
	public void setTotalPlayerWinnings(int playerWinnings)
	{
		totalPlayerWinnings += playerWinnings;
	}
	
	/**
	 * Mutator method that sets the total bets of Regular that takes an integer as parameter.
	 * @param playerBets the set Regular player's total bet.
	 */
	public void setTotalPlayerBets(int playerBets)
	{
		totalPlayerBets += playerBets; 
	}
	
	/**
	 * Redefinition of the method toString() to allow the printing of the token value of Regular players.
	 * @return the token value of Regular player(s).
	 */
	public String toString()
	{
		return ("Token value for a regular player: " + TOKEN_VALUE);
	}
	
	/**
	 * Redefinition of the method equals() to allow the comparison of two object of the given class (Regular)
	 * @param otherRegular the second of type Regular that we compare with
	 * @return true if the token values are the same, otherwise false
	 */
	public boolean equals(Regular otherRegular)
	{
		return (TOKEN_VALUE == otherRegular.TOKEN_VALUE);
	}
	
	/**
	 * Method that calculates the winnings of Regular player(s)
	 * @return winnings the winnings of Regular
	 */
	public int calculatesWinnings()
	{
		int winnings = 0;
		
		winnings = TOKEN_VALUE * getWinningTokenPayment();
		
		return winnings;
	}
}
