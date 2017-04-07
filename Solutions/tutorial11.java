import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

/*
 * creating a game where a bunch of monsters kill each other
 */

public class tutorial11 
{
	static char[][] battleBoard = new char[10][10];
	
	public static void buildBattleBoard()
	{
		for(char[] row : battleBoard)
		{
			Arrays.fill(row,'*');
		}
	}
	
	public static void redrawBoard()
	{
		
		int k = 1;
		while(k <= 30){ System.out.print('-'); k++; }
		System.out.println();
		
		for(int i = 0; i < battleBoard.length; i++)
		{
			for(int j= 0; j < battleBoard[i].length; j++)
			{
				System.out.print("|" + battleBoard[i][j] + "|");
			}
			System.out.println();
		}
	}
	
	public final String TOMBSTONE = "Here lies a dead monster.";
	
	private int health = 500; //another name for class variable is "field". Generally, a good idea to make fields private.
	private int attack = 20;
	private int movement = 4;
	private boolean alive = true;
	
	public int xPosition = 0;
	public int yPosition = 0;
	public char nameChar1 = 'B';
	public String name = "Big Monster"; // a user can change the name of the monster from another class
	public static int numOfMonsters = 0;
	
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
	
	public boolean getAlive() { return alive; }
	
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
	
	public void moveMonster(tutorial11[] monster, int arrayItemIndex){
		
		boolean isSpaceOpen = true;
		
		int maxXBoardSpace = battleBoard.length - 1;
		int maxYBoardSpace = battleBoard[0].length - 1;
		
		while(isSpaceOpen){
			
			int randMoveDirection = (int) (Math.random() * 4); // 0(north), 1(east), 2(south), 3(west)
			int randMoveDistance = (int) (Math.random() * this.getMovement() );
			
			System.out.println(randMoveDistance + " " + randMoveDirection);
			
			battleBoard[this.xPosition][this.yPosition] = '*'; // makes monster space a star because monster has moved
			
			if(randMoveDirection == 0){ //moving north
				if(this.yPosition - randMoveDistance < 0){ //makes sure object does not fall off gameboard when going north
					this.yPosition = 0;
				} else {
					this.yPosition = this.yPosition - randMoveDistance;
				}
			} else if(randMoveDirection == 1){ //moving east
				if(this.xPosition - randMoveDistance > maxXBoardSpace){ //makes sure object does not fall off gameboard when going east
					this.xPosition = maxXBoardSpace;
				} else {
					this.xPosition = this.xPosition - randMoveDistance;
				}
			} else if(randMoveDirection == 2){ //moving south
				if(this.yPosition - randMoveDistance > maxYBoardSpace){ //makes sure object does not fall off gameboard when going south
					this.yPosition = maxXBoardSpace;
				} else {
					this.yPosition = this.yPosition - randMoveDistance;
				}
			} else { //moving west
				if(this.xPosition - randMoveDistance < 0){ //makes sure object does not fall off gameboard when going west
					this.xPosition = 0;
				} else {
					this.xPosition = this.xPosition - randMoveDistance;
				}
			}
			for(int i = 0; i < monster.length;i++){
				//Monster Frank x = 1 y = 3
				/*
				 * makes sure monsters are not jumping on top of other monsters
				 */
				if(i == arrayItemIndex){ //so I do not check the monster against itself. without this there would be an infinite loop.
					continue; // will jump back to beginning of for loop so monster is not checked against itself
				}
				
				if(onMySpace(monster, i, arrayItemIndex)){
					
					isSpaceOpen = true;
					break; // jump out of for loop (not while loop)
				} else{
					
					isSpaceOpen = false;
				}
			}
		} // END OF WHILE LOOP
		
			battleBoard[this.xPosition][this.yPosition] = this.nameChar1;
	} // END OF moveMonster
	
	public boolean onMySpace(tutorial11[] monster, int indexToChk1, int indexToChk2){
		
		if(monster[indexToChk1].xPosition == monster[indexToChk2].xPosition && monster[indexToChk1].yPosition == monster[indexToChk2].yPosition){
			
			return true; // there is monster
		} else{
			
			return false; // there is no monster
		}
	}
	
	public tutorial11 (int health, int attack, int movement, String name) //constructor. Only constructed one time and never again. Cannot have any return value. Changes health, attack, and movement of your monster.
	{
		this.health = health;
		this.attack = attack;
		this.movement = movement;
		this.name = name;
		
		int maxXBoardSpace = battleBoard.length - 1;
		int maxYBoardSpace = battleBoard[0].length - 1;
		
		int randNumX, randNumY;
		
		do
		{
			randNumX = (int) (Math.random() * maxXBoardSpace);
			randNumY = (int) (Math.random() * maxYBoardSpace);
		} while (battleBoard[randNumX][randNumY] != '*');
		
		this.xPosition = randNumX;
		this.yPosition = randNumY;
		
		this.nameChar1 = this.name.charAt(0); //can do object.variable.method
		
		battleBoard[this.xPosition][this.yPosition] = this.nameChar1;
		
		numOfMonsters++;
		
	}
	
	public tutorial11 () //Default constructor and built in case people do not put input values. I just overloaded my constructor.
	{
		numOfMonsters++;
	}
	public static void main(String[] args) 
	{
		tutorial11 Lemmy = new tutorial11 (400, 10, 4, "Lemmy");
		System.out.println("Lemmy's attack is: " + Lemmy.attack);
		System.out.println("Lemmy's health is: " + Lemmy.health);
		System.out.println("Lemmy's movement is : " + Lemmy.movement);
	}
}