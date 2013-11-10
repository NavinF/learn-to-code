import java.awt.*;
import java.util.*;
import javax.swing.*;
 
public class GamePanel extends JPanel implements Runnable {
	private static final int FPS = 1000 / 36;
	
	public static void main(String[] args)
    {
    	JFrame parentWindow = new JFrame("Learn Programming v0");
    	
    	parentWindow.getContentPane().add(new GamePanel());
    	
    	parentWindow.setSize(800 , 600);
        parentWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        parentWindow.setVisible(true);
    }
	
	private Collection<Element> elements = new ArrayList<Element>();
    
	//private Ball e1;

	public GamePanel() {
		//elements.add(e1 = new Ball(10, 10, 32, 32));
		//elements.add(new Rectangle(20, 20, 32, 32));
		
		new Thread(this).start();
	}
	
    public void run() {
    	// Remember the starting time
    	long tm = System.currentTimeMillis();

        while(true){
            update();
            repaint();

            try {
                tm += FPS;
                Thread.sleep(Math.max(0, tm - System.currentTimeMillis()));
            }
            catch(InterruptedException e)
            {
            	System.err.println(e);
            }
        }
    }
	
    public void update(){
    	Iterator iterator = elements.iterator();
		
		while(iterator.hasNext())
			((Element) iterator.next()).update();
    }
    
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		Iterator iterator = elements.iterator();
		
		while(iterator.hasNext())
			((Element) iterator.next()).draw(g);
		
		g.setColor(Color.red);
		g.drawString("test", 100, 100);
	}
}