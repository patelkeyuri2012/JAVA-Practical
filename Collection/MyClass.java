// create generic class
public class MyClass<T extends Comparable<T>> {

    public T findMaximum(T[] array) {
        if (array == null || array.length == 0) {
            return null; 
        }

        T max = array[0]; 

        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i]; 
            }
        }
        return max;
    }

    public static void main(String[] args) {
       
        Integer[] intArray = {34, 52, 71, 37, 89, 45, 36};
		// cretae integer object
        MyClass<Integer> intObject = new MyClass<>();
        Integer maxInteger = intObject.findMaximum(intArray);
        System.out.println("\nMaximum Integer Value : " + maxInteger);

   
        Character[] charArray = {'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd'};
		// cretae character object
        MyClass<Character> charObject = new MyClass<>();
        Character maxCharacter = charObject.findMaximum(charArray);
        System.out.println("Maximum Character Value : " + maxCharacter);
		

        Double[] doubleArray = {12.25, 38.41, 25.43, 60.57, 44.32, 52.34};
		// cretae double object
        MyClass<Double> doubleObject = new MyClass<>();
        Double maxDouble = doubleObject.findMaximum(doubleArray);
        System.out.println("Maximum Double Value : " + maxDouble);

     
        String[] stringArray = {"gandhinagar", "ahmedabad", "baroda", "porbandar", "patan", "mahesana", "surat"};
		// cretae string object
        MyClass<String> stringObject = new MyClass<>();
        String maxString = stringObject.findMaximum(stringArray);
        System.out.println("Maximum String Value : " + maxString);
    }
}
