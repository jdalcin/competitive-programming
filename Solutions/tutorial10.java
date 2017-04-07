/*
 * creates a class with a monster theme
 */
public class tutorial10 
{
	public final String TOMBSTONE = "Here lies a dead monster.";
	
	private int health = 500; //another name for class variable is "field". Generally, a good idea to make fields private.
	private int attack = 20;
	private int movement = 2;
	private int xPosition = 0;
	private int yPosition = 0;
	private boolean alive = true;
	
	public String name = "Big Monster"; // a user can change the name of the monster from another class
	
	public int getAttack()
	{
		return attack;
	}
	
	public int getMovement()
	{
		return movement;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void setHealth(int decreaseHealth)
	{
		health = health - decreaseHealth;
		if (health < 0)
		{
			alive = false;
		}
	}
	
	public void setHealth(double decreaseHealth) //overloaded method. Same name but different attributes.
	{
		int intDecreaseHealth = (int) decreaseHealth;
		health = health - intDecreaseHealth;
		if (health < 0)
		{
			alive = false;
		}
	}
	
	public tutorial10 (int health, int attack, int movement) //constructor. Only constructed one time and never again. Cannot have any return value. Changes health, attack, and movement of your monster.
	{
		this.health = health;
		this.attack = attack;
		this.movement = movement;
	}
	
	public tutorial10 (){} //Default constructor and built in case people do not put input values. I just overloaded my constructor.
	
	public static void main(String[] args) 
	{
		tutorial10 Lemmy = new tutorial10 (400, 10, 4);
		System.out.println("Lemmy's attack is: " + Lemmy.attack);
		System.out.println("Lemmy's health is: " + Lemmy.health);
		System.out.println("Lemmy's movement is : " + Lemmy.movement);
	}
}
