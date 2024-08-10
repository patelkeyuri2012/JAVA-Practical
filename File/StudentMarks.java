import java.io.*;

public class StudentMarks{
    public static void main(String[] args){
		//to check user provide argument or not
        if (args.length != 1){
            System.out.println("usage: java StudentMarks <file_name>");
            System.exit(0);
        }

		//object for take file or directory name
        File f = new File(args[0]);

		//check provide argument if file or not
        if (f.isFile() == false){
            System.out.println("usage : java StudentMarks <file_name>");
            System.exit(0);
        }

        try{

			FileReader fr = new FileReader(f);		//call file object of FileReader calss
            BufferedReader br = new BufferedReader(fr);		//call file object of BufferedReader class
			 
            String line;

			//read data of student marks from file
            while ((line = br.readLine()) != null){
				
                String[] data = line.split("\t");		//to split two data
				
                if (data.length == 5){
                    String rollNo = data[0];
                    String name = data[1];
                    double subject1 = Double.parseDouble(data[2]);
                    double subject2 = Double.parseDouble(data[3]);
                    double subject3 = Double.parseDouble(data[4]);

                    double per = Percentage(subject1, subject2, subject3);		//call percentage method

					System.out.println();
                    System.out.println("Roll No : " + rollNo);
                    System.out.println("Name : " + name);
                    System.out.println("Percentage : " + per + "%");
                    System.out.println();
					
                } else{
                    System.out.println("Data are in invalid format : " + line);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static double Percentage(double subject1, double subject2, double subject3){
        return (subject1 + subject2 + subject3) / 3;
    }
}
