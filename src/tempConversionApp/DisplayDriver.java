package tempConversionApp;

import javax.swing.JFrame;

public class DisplayDriver 
	{

		public DisplayDriver()
			{
				System.out.println("Application Start");
				TempConversionWindow newWindow = new TempConversionWindow();
				newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				newWindow.setSize(450,110);
				newWindow.setResizable(true);
				newWindow.setVisible(true);		
				newWindow.convertC.grabFocus();
			}
		public String toString()
			{
				return "Display SimDriver for temp Conversion Tool";
			}
		
		public static void main(String[] args)
			{
				System.out.println("Application Start");
				TempConversionWindow newWindow = new TempConversionWindow();
				newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				newWindow.setSize(550,110);
				newWindow.setResizable(false);
				newWindow.setVisible(true);		
				newWindow.convertC.grabFocus();	
			}

	}
