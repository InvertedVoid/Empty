import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sylladex.Main;
import sylladex.Widget;


public class Pumpkin extends Widget {

	JPanel panel;
	Timer timer;
	Pumpkin thisPumpkin;
	Boolean reloaded;

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		if(card.isAccessible())
		{
			m.getModus().open(card);
			timer.schedule(new Reset(), (long)(3000 + Math.random()*7000));
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prepare() {
		//ImageIcon imageicon = Main.createImageIcon("widgets/Pumpkin/image.gif");
		//dock_icon = new JLabel(Main.getDockIcon(imageicon.getImage()));
		timer = new Timer();
		thisPumpkin = this;
	}

	@Override
	public void add() {
		ImageIcon imageicon = Main.createImageIcon("widgets/Pumpkin/image.gif");
		dock_icon = new JLabel(Main.getDockIcon(imageicon.getImage()));
		//timer = new Timer();
	}

	@Override
	public void load(String string) {
		reloaded = true;
		timer.schedule(new Reset(), 50);
	}

	@Override
	public void open() {}

	@Override
	public String getString() {
		return "Pumpkin";
	}

	@Override
	public String getSaveString() {
		return null;
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		
		//ImageIcon imageicon = Main.createImageIcon("widgets/Pumpkin/image.gif");
		//panel = new JPanel();
		//panel.add(new JLabel(imageicon));
		//panel.setOpaque(false);
		//return panel;
		
		JPanel panel = new JPanel();
		ImageIcon icon = Main.createImageIcon("widgets/Pumpkin/image.gif");
		int cardwidth = m.getModus().getModusSettings().get_card_width();
		int cardheight = m.getModus().getModusSettings().get_card_height();
		Icon image = Main.getSizedIcon(icon.getImage(), 24*cardwidth/37, 100*cardheight/188);
		JLabel image_label = new JLabel(image);
		image_label.setBounds(0, 0, 24*cardwidth/37, 100*cardheight/188);
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.add(image_label);
		return panel;
	}
	
	private class Reset extends TimerTask{

		@Override
		public void run() {
			if(reloaded = false)
			{
				Widget pumpkin;
				try
				{
					pumpkin = thisPumpkin.getClass().newInstance();
					pumpkin.setMain(m);
					pumpkin.prepare();
					m.getModus().addItem(pumpkin);	
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "There was never a pumpkin here. Now you're just being silly.\n" + e.getLocalizedMessage());
				}
			}
			else
			{
				m.getModus().open(thisPumpkin.getCard());
			}
		}
		
	}

}