import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Talker extends Character
{
	boolean displaying;
	String str;
	
	boolean unlocked;
	
	int code  = 1337;
	
	int attached;
	
	public Talker( int x, int y, int health, String str, ArrayList<Element> elements )
	{
		super( x, y, health, elements );
		this.str = str;
	}
	
	public void setAttached(Obstacle o){
		int index = 0;
		for(int i = 0; i < elements.size(); i++){
    		if(elements.get(i) instanceof Obstacle && ((Obstacle)elements.get(i)) == o){
    			index = i;
    		}
    	}
		attached = index;
	}
	
	public void update(){
		super.update();
		double dist = distanceTo(player);
		if(dist < 100){
			displayPrompt(str);
		}else{
			hidePrompt();
		}
		
	}
	
	public void displayPrompt(String str){
		this.str = str;
		displaying = true;
	}
	
	public void hidePrompt(){
		displaying = false;
	}
	
	
	public void action(  )
	{
		
	}
	
	public boolean unlock(int testCode){
		if(testCode == code){
			unlocked = true;
			elements.remove(attached);
		}
		return unlocked;
	}
	
	public void draw(Graphics g){
		g.setColor(new Color(139, 69, 19));
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		
		if(displaying){
			g.setColor(Color.GRAY);
			g.fillRect(getX() - 50, getY() - 50, g.getFontMetrics().stringWidth(str) + 5, 30);
		
			g.setColor(Color.black);
			g.drawString(str, getX() - 45, getY() - 30);
		}
	}
}
