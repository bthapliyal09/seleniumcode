package org.iitwforce.automation.uclidmmpBabita;

		import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
		import java.io.IOException;
		public class example
		{
		public static void main(String[] args) throws IOException
		
		{
		int count=0;
		FileReader fr = new FileReader("inputData.txt");
		BufferedReader br = new BufferedReader(fr);

		////Replace the content of the file
		FileWriter fw = new FileWriter("outputData.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		String content,searchPattern = "Selenium";
		while((content=br.readLine())!=null) {
		System.out.println(content);
		if(content.contains(searchPattern)){
		count++;
		bw.write(content.replace(searchPattern,"QTP"));
		
		}
		else
		{
		bw.write(content);
		}
		bw.write("\n");
		}
		bw.close();
		fw.close();
		br.close();
		fr.close();
		System.out.println(count);
		}

	}

