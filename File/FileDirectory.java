import java.io.*;

class FileDirectory {
    public static void main(String[] args) {
        try {
			//to check user provide argument or not
            if (args.length != 1){
                System.out.println("Usage: java FileDirectory <file_name> or <directory_name>");
                System.exit(0);
            }
			
			//object for take file or directory name
            File f = new File(args[0]);
			
			//check provide argument if file or not and print size of file
            if (f.isFile()){
                System.out.println("\nSize or Length of file is: " + f.length()+ " bytes");
            } 
			//check provide argument if directory or not 
			else if (f.isDirectory()){
                File[] files = f.listFiles();
				
				//print contents of directory
                if (files != null){
                    System.out.println("\nContents of Directory are : \n");
					
                    for (int i = 0; i < files.length; i++){
                        System.out.println(files[i].getName());
                    }
                }
            }else{
				//if user provide another argument
                System.out.println("Usage: java FileDirectory <file_name> or <directory_name>");
                System.exit(0);
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
