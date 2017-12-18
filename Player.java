/**
 * The class Player keeps track of the total bets, the total winnings and the player status of each player.
 * @author Hoai An Luu (27187661)
 * @author Tri-Luong Steven Dien (27415281)
 *
 */
public class Player {
	protected int totalPlayerBets = 0;
	protected int totalPlayerWinnings = 0;
	private String playerStatus = "";
	private final int WINNING_TOKEN_PAYMENT = 35;
	
	/**
	 * Default constructor.
	 */
	public Player()
	{
		totalPlayerBets = 0;
		totalPlayerWinnings = 0;
		playerStatus = "";
	}
	
	/**
	 * Accessor method that returns the total bet of a player.
	 * @return totalPlayerBets the total bet of a player.
	 */
	public int getTotalPlayerBets()
	{
		return totalPlayerBets;
	}
	
	/**
	 * Accessor method that returns the total winning of a player.
	 * @return getTotalPlayerWinnings the total winning of a player.
	 */
	public int getTotalPlayerWinnings()
	{
		return totalPlayerWinnings;
	}
	
	/**
	 * Accessor method that returns the status of a player.
	 * @return playerStatus player status.
	 */
	public String getPlayerStatus()
	{
		return playerStatus;
	}
	
	/**
	 * Accessor method that returns the winning token payment.
	 * @return WINNING_TOKEN_PAYMENT winning token payment.
	 */
	public int getWinningTokenPayment()
	{
		return WINNING_TOKEN_PAYMENT;
	}
	
	/**
	 * Mutator method that sets the player bet variable with an integer given as parameter.
	 * @param playerBets the player's bet.
	 */
	public void setTotalPlayerBets(int playerBets)
	{
		totalPlayerBets = playerBets; 
	}
	
	/**
	 * Mutator method that sets the player winning variable with an integer given as parameter.
	 * @param playerWinnings the player's winning
	 */
	public void setTotalPlayerWinnings(int playerWinnings)
	{
		totalPlayerWinnings = playerWinnings;
	}
	
	/**
	 * Mutator method that sets the player status variable with a string given as parameter.
	 * @param status the player's status
	 */
	public void setPlayerStatus(String status)
	{
		playerStatus = status;
	}
	
	/**
	 * Redefinition of the method toString() to allow the printing of the data member of the class
	 * @return the total bets, the total winnings and the player's status
	 */
	public String toString()
	{
		return ("Total bets: " + totalPlayerBets
				+ "\nTotal Winnings: " + totalPlayerWinnings
				+ "\nPlayer Status:" + playerStatus);
	}
	
	/**
	 * Redefinition of the method equals() to allow the comparison of two object of the given class (Player)
	 * @param otherPlayer the second object of type Player that we compare with
	 * @return a boolean, true if it is the same total winnings, total bets and status information or false otherwise
	 */
	public boolean equals(Player otherPlayer)
	{
		return (totalPlayerBets == otherPlayer.totalPlayerBets
				&& totalPlayerWinnings == otherPlayer.totalPlayerWinnings
				&& playerStatus.equals(otherPlayer.playerStatus));
	}
	
	/**
	 * Method which allows the user to increase the player's bet by the indicated number.
	 * @param totalBets the bets added
	 */
	public void addTotalPlayerBets(int totalBets)
	{
		totalPlayerBets += totalBets;
	}
	
	/**
	 * Method which allows the user to increase the player's winning by the indicated number
	 * @param totalWinnings the winnings added
	 */
	public void addTotalPlayerWinnings(int totalWinnings)
	{
		totalPlayerWinnings += totalWinnings;
	}
}
