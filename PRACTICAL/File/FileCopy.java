import java.io.*;

class FileCopy{
	public static void main (String [] args){
		try{
			File fin = new File (args[0]);		//object for source file
			File fout = new File (args [1]);		//object for destination file
			
			//check and info how to enter command to copy file
			if(fin.isFile() == false && fout.isFile() == false){
				System.out.println("usage : java FileCopy <file_name> <file_name>");
				System.exit(0);
			}
			
			FileInputStream fis = new FileInputStream (fin);		//call file object for input (source)
			FileOutputStream fos = new FileOutputStream (fout);		//call file object for output (destination)
			
			byte [] b = new byte [500];
			int cnt = 0;
			
			//print content one file to another file
			while ((cnt = fis.read(b)) != -1){
				fos.write(b, 0, cnt);
			}
			
			System.out.println("File Copy Successfully..!!");
			
			fis.close();		//close file input stream
			fos.close();		//close file output stream
			
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}

