package org.iitwforce.automation.uclidmmpBabita;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadTextFile {

	public static void main(String[] args) throws Exception {
	
		File file = new File ("C:\\Users\\Owner\\Desktop\\ReadAFile.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
				
		String st;
		String sword = "Selenium";
		int icount=0;
		
		while ((st = br.readLine()) != null)
		{	
			System.out.println(st);
			if(st.indexOf(sword)> 0)
			{
			  icount = icount + 1;
			}			
		}
		System.out.println("Selenium word count is " + icount);		
	}
}
