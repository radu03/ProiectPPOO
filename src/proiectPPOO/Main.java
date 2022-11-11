package proiectPPOO;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		List<FileObject> files = new ArrayList<>();
		
		 File file = new File(
				 System.getProperty("user.dir") + "/output.txt");
		 
		 try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String st;   
	        while ((st = br.readLine()) != null)
	        {
	        	files.add(new FileObject(st));
	        }
	   
	    
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		String string;
		HashMap<String, String> optionMessages = new HashMap<String, String>();
		optionMessages.put("2","Enter path to file: ");
		optionMessages.put("3","Choose the file you wish to delete (pick the number shown before it): ");
		optionMessages.put("4","Add path to existing file: ");
		
		
			System.out.println("File managing system. Choose an option: ");
			try (Scanner scanner = new Scanner(System.in)) {
				while (true) {
					System.out.println("1. List all saved files \n2. Create a new file \n3. Delete file \n4. Add existing file");
					String command = scanner.next();
					if (command == null || "exit".equals(command)) {
						
						FileWriter writer = new FileWriter("output.txt"); 
						for(FileObject fo: files) {
							  writer.write(fo + System.lineSeparator());
							}
						writer.close();
						break;
						
					}
					else {
						
						switch(command) {
						  case "1":
							FileObject[] array = new FileObject[files.size()];
							files.toArray(array); // fill the array
							for(int i = 0; i < array.length; i++)
								System.out.println(array[i].toString()+ "\n");
						    
						    break;
						  case "2":
							  System.out.println(optionMessages.get("2"));
							  Scanner scannerCreate = new Scanner(System.in);
							  
								  try {
									  	String s = scannerCreate.nextLine();
									  	if(s=="") throw new NullStringException();								
										FileObject f2 = new FileObject(s);
										f2.createNewFile();
										files.add(f2);
										System.out.println("File created and saved! Extension: " + f2.getExtensionByStringHandling());
										//scannerCreate.close();
									} catch (IOException e) {						
										e.printStackTrace();	
									} catch (NullStringException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}


							  break;
						  case "3":	 
							  try {
								  
							  System.out.println(optionMessages.get("3"));
							  int count = 0;
							  
							  for(FileObject f : files) {
								  
								  System.out.println("[" + count++ + "] - " + f.toString());
								  
							  }

							  Scanner scannerDelete = new Scanner(System.in);
							  files.remove(Integer.parseInt(scannerDelete.next()));
							  System.out.println("File successfully deleted.");
							  //scannerDelete.close();
							  
							  } catch(Exception e) {
								  e.printStackTrace();
								 
							  }
							  break;
						  case "4":
							  System.out.println(optionMessages.get("4"));
							  Scanner scannerAdd = new Scanner(System.in);
							  
								  
									  	FileObject f4 = new FileObject(scannerAdd.nextLine());				
									  	if(f4.exists() && !f4.isDirectory()) { 
									  	    files.add(f4);						  	    
									  	    //scannerAdd.close();
									  	}
									  	else System.out.println("File doesn't exist!");
									  	//scannerAdd.close();

							  
							 
						    break;
						  default:
						   
						}
							
						
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		

	}

}
