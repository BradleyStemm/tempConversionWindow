package tempConversionApp;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TempConversionWindow extends JFrame
	{
		private static final long serialVersionUID = 1L;
		
		JLabel celsius, fahrenheit;
		JTextField celBox, farBox;
		public JButton convertC, convertF;
		
		public String convCToF(String myString)
		{
			double derivedNum = 0;
			try
				{
					derivedNum = Double.parseDouble(myString);
				}
			catch(NumberFormatException NFE)
				{
					System.out.println("NO NUMBERS ENTERED 0 set");
					myString = "0";
					celBox.setText("0");
					derivedNum = Double.parseDouble(myString);
				}
			finally
				{
					derivedNum *= 1.8;
					derivedNum += 32;
					myString = Double.toString(derivedNum);
					myString = String.format("%.3f",derivedNum);
					if(myString.equals("-0.000"))
						{
							myString = "0";
						}
				}
			return myString; 
		}
		
		public String convFToC(String myString)
		{
			double derivedNum =0;
			try
				{
					derivedNum = Double.parseDouble(myString);
				}
			catch(NumberFormatException NFE)
				{
					System.out.println("NO NUMBERS ENTERED 0 set");
					myString = "0";
					farBox.setText("0");
					derivedNum = Double.parseDouble(myString);
				}
			finally
				{
					derivedNum = Double.parseDouble(myString);
					derivedNum -= 32;
					derivedNum /= 1.8;
					myString = Double.toString(derivedNum);
					myString = String.format("%.3f", derivedNum);
				}
			return myString;
		}
		
		@SuppressWarnings("unused")
		public TempConversionWindow()
			{
				super("Temperature Conversion Tool");
				System.out.print("Window Build\n");
				setLayout(new FlowLayout());
				celsius = new JLabel("Celsius");//Building the components
				add(celsius);
				
				//
				celBox = new JTextField("Enter Celsius Here",20);
				celBox.setToolTipText("Enter Celsius Here");
				add(celBox);
				
				//
				convertC = new JButton("Convert to Fahrenheit");
				convertC.setSize(150, 20);
				add(convertC);
				
				//
				fahrenheit = new JLabel("Fahrenheit");
				add(fahrenheit);
				
				//
				farBox = new JTextField("Enter Fahrenheit Here",20);
				farBox.setToolTipText("Enter Fahrenheit Here");
				add(farBox);
				
				//
				convertF = new JButton("Convert to Celsius");
				convertF.setSize(150, 20);
				add(convertF);
				
				
				celBoxListeners:
					{
						celBox.addActionListener
							(
								new ActionListener()
									{
										@Override
										public void actionPerformed(ActionEvent ae)
											{
												String string;
												farBox.setText(convCToF(celBox.getText()));
												string = String.format("Celsius Temperature: %s converts to %s degrees Fahrenheit", celBox.getText(), farBox.getText());
												JOptionPane.showMessageDialog((null), string);
											}
									}
							);
						celBox.addFocusListener
							(
								new FocusListener()
									{

										@Override
										public void focusGained(FocusEvent arg0) 
											{
												if (celBox.getText().equals("Enter Celsius Here"))
													{
														celBox.setText("");
													}	
											}

										@Override
										public void focusLost(FocusEvent arg0)
											{	
											}
									
									}
							);
					}
				farBoxListeners:
					{
						farBox.addActionListener
							(
								new ActionListener()
									{
										@Override
										public void actionPerformed(ActionEvent e)
											{
													String string;
												celBox.setText(convFToC(farBox.getText()));
												string = String.format("Fahrenheit Temperature: %s converts to %s degrees Celsius", farBox.getText(),celBox.getText() );
												JOptionPane.showMessageDialog((null), string);
											}
									}
							);
						farBox.addFocusListener
							(
									new FocusListener()
										{

											@Override
											public void focusGained(FocusEvent arg0) 
												{
													
													if (farBox.getText().equals("Enter Fahrenheit Here"))
														{
															farBox.setText("");
														}
												}

											@Override
											public void focusLost(FocusEvent arg0)
												{
												}
								
										}
							);
					}
				convertListeners:
					{
						
						convertC.addMouseListener
							(
		
								new MouseListener()
									{
										String set1;
									
										@Override
										public void mouseClicked(MouseEvent arg0)
											{
												System.out.println("Conversion to C");
												farBox.setText(convCToF(celBox.getText()));
												set1 = farBox.getText();
												System.out.println(celBox.getText() + " degrees C converted to " + set1 + " degrees F  {[(" + celBox.getText() + " x 1.8) + 32] = " + set1 +"}" );
												System.out.println("Done");
											}

										@Override
										public void mouseEntered(MouseEvent arg0)
											{
												System.out.println("Conversion peek initiated");
												set1 = farBox.getText();
												farBox.setText("Converted value = " + convCToF(celBox.getText()));
											}

										@Override
										public void mouseExited(MouseEvent arg0)
											{
												farBox.setText(set1);
												System.out.println("Conversion peek finished");
											}

										@Override
										public void mousePressed(MouseEvent arg0) 
										{
										}	

										@Override
										public void mouseReleased(MouseEvent arg0)
										{	
										 }
								}
						);
						
						convertF.addMouseListener
							(
								new MouseListener()
									{
										String set1;

										@Override
										public void mouseClicked(MouseEvent arg0) 
											{
												System.out.println("Conversion to F");													
												celBox.setText(convFToC(farBox.getText()));
												set1 = convFToC(farBox.getText());
												System.out.println(farBox.getText() + " degrees F converted to " + set1 + " degrees C  {[(" + farBox.getText() + " - 32)/1.8] = " + set1 +"}" );
												System.out.println("Done");
											}

										@Override
										public void mouseEntered(MouseEvent arg0) 
											{
												System.out.println("Conversion peek initiated");
												set1 = celBox.getText();
												celBox.setText("Converted value = " + convFToC(farBox.getText()));
											
												
											}

										@Override
										public void mouseExited(MouseEvent arg0) 
											{
												celBox.setText(set1);
												System.out.println("Conversion peek finished");
											}

										@Override
										public void mousePressed(MouseEvent arg0) 
										{
										}

										@Override
										public void mouseReleased(MouseEvent arg0)
										{
										}
									}
							);
					}
			}
	}
