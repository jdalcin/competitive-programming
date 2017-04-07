import org.apache.commons.lang3.ArrayUtils;

/*
 * allows you to draw the monster videogame board using methods made in class tutorial11
 */

public class tutorial11_2 
{

	public static void main(String[] args) 
	{
		tutorial11.buildBattleBoard();

		char[][] tempBattleBoard = new char[10][10];
		
		// ObjectName[] Monsters = new ObjectName[4];
		
		tutorial11[] Monsters = new tutorial11[5];
		
		Monsters[0] = new tutorial11(1000, 20, 4, "Dom");
		Monsters[1] = new tutorial11(1000, 20, 4, "Bennie");
		Monsters[2] = new tutorial11(1000, 20, 4, "Andrew");
		Monsters[3] = new tutorial11(1000, 20, 4, "Matthew");
		Monsters[4] = new tutorial11(1000, 20, 4, "Babies");
		
		tutorial11.redrawBoard();
		
		for (tutorial11 m : Monsters){
			if(m.getAlive()){
				int arrayItemIndex = ArrayUtils.indexOf(Monsters, m);
				m.moveMonster(Monsters, arrayItemIndex);
			}
		}
	
	tutorial11.redrawBoard();
	}

}
