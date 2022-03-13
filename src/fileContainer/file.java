package fileContainer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import slangWord.slangWordDefinition;

public class file {
	
	
	public slangWordDefinition splitString(String line) {
		slangWordDefinition slang= new slangWordDefinition();
		int position=line.indexOf("`");
		if(position==-1)
		{
			// khong tim thay 
			System.out.println("Loi file");
			
		}
		else {
			String slangWord=line.substring(0,position);
			String definition=line.substring(position+1,line.length());
			slang.slangWord=slangWord;
			slang.definition=definition;
			
		}
		
		
		return slang;
	}
	//ham doc file
	public void readFile(ArrayList<slangWordDefinition> slang,String directory)
	{
		String fileName=System.getProperty("user.dir");
		fileName=fileName+"\\src\\fileContainer\\slang.txt";
		if(fileName!=null)
		{
			// doc file slang.txt
			try {
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				String line="";
				while((line=br.readLine())!=null)
				{
					slang.add(splitString(line));
				}
				br.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
