//class for nagetive exception that inherite from exception class
class NegativeArgumentException extends Exception{
    public NegativeArgumentException(String argName, int argValue){
        super("Negative value found for argument");
    }
}

//class for throw custom exception
public class CustomException{
	
	//method to check nagetive arguments 
    public static void checkArguments(int[] args) throws NegativeArgumentException {
		for (int i = 0; i < args.length; i++) {
			int arg = args[i];
            if (arg < 0) {
                throw new NegativeArgumentException("Argument", arg);
            }
        }
    }

    public static void main(String[] args){
        try{
            if (args.length == 0){
                System.out.println("No arguments provided");
                return;
            }

            int[] arguments = new int[args.length];
            for (int i = 0; i < args.length; i++){
                arguments[i] = Integer.parseInt(args[i]);
            }

            checkArguments(arguments);
            System.out.println("All arguments are non-negative");
			
        }catch (NumberFormatException e){
            System.out.println("Please enter valid integer arguments");
        }catch (NegativeArgumentException e){
            System.out.println("" + e.getMessage());
        }
    }
}
