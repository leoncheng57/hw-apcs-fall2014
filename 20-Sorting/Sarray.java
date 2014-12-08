public class Sarray{
        
    /*<----------------INSTANCE VARIABLES------------------->*/
    public String[] data; // should be object[]
    public int last; //last index of the list
    
    /*<----------------METHODS AND CONSTRUCTOR------------------->*/    
    //This was a method that I decided to include
    //prints the array in a readable fashion
    //finds the number for last, changes last, prints last
    public String toString(){
	String ret = ""; 
	for (int a=0;a<data.length;a++){
    	    ret += data[a]+", ";
	}
	ret+="\n";
	// int count = -1;
	// for (int a=0;a<data.length;a++){
	//     if (data[a]!=null){
	//  	count = a;
	//     }
	// }
	// last = count;	
	ret+="last: "+last;
	ret+="\n";
	return ret;
    }

    //set up the initial instance variables
    public Sarray() {
	// start array at size 10, don't use 0
	data = new String[10];
	last = -1;
    }

    public String[] getData(){
	return data;
    }

    public void setData(int index, String s){
	data[index] = s;
    }

    public int getLast(){
	return last;
    }

    
    //adds an item to the end of the list, grow if needed, returns true
    public boolean add (String s) {
	if (last == data.length-1){
	    //gotta create a new array with i as the last added element
	    String[] newArray = new String[data.length+1];
	    for (int a=0;a<data.length;a++){
		newArray[a]=data[a];
	    }
	    newArray[newArray.length-1] = s;
	    data=newArray;
	}
	else {
	    data[last+1]=s;
	}
	last++;
	return true;
    }

    //adds item s at index, shifting everything down as needed
    //also grows as needed
    public void add (int index, String s) {
    	// inserts at location index - shift everything else down
    	String[] newArray;
	if (index<data.length){
	    newArray=new String[data.length+1];
	    for (int a=0;a<newArray.length;a++) {
		if (a<index) {
		    newArray[a]=data[a];
		}
		if (a==index) {
		    newArray[a]=s;
		}
		if (a>index) {
		    newArray[a]=data[a-1];
		}
	    }
	    last++;
	}
	else {
	    newArray = new String[index+1];
	    for (int a=0;a<data.length;a++){
		newArray[a]=data[a];
	    }
	    newArray[index]=s;
	    last = index;
	}
    	data = newArray;
    }

    //return the number of items in the list (not counting null)
    public int size(){
    	int count = 0;
    	for (int a=0;a<data.length;a++){
    	    if (data[a]!=null){
    		count++;
    	    }
    	}
    	return count;
    }

    //returns the item at location index of the list
    public String get (int index) {
    	return data[index];
    }
    
    // sets the item at locaiton index to value i
    //returns the old value
    public String set (int index, String s) {
    	if (index>data.length){
    	    throw new ArrayIndexOutOfBoundsException();
    	    //throw new IndexOutOfBoundsException();
    	    //throw new ArithmeticException();
    	}
    	String ret = data[index];
    	data[index]=s;
    	return ret;
    }
        
    //removes the item at index i
    //returns the old value 
    public String remove(int index){
    	String ret = data[index];
        String[] newArray = new String[data.length-1];
    	// for(int a=0;a<newArray.length;a++){
    	//     if (a<index){newArray[a]=data[a];}
    	//     if (a>=index){newArray[a]=data[a+1];}
    	// }
    	int a=0;
    	for (a=a;a<index;a++){newArray[a]=data[a];}
    	for (a=a;a<newArray.length;a++){newArray[a]=data[a+1];}
    	data = newArray;
    	last--;
	return ret;
    }

    public void extend(){
	String[] newArray = new String[data.length+1];
	for (int i=0;i<data.length;i++){
	    newArray[i]=data[i];
	}
	data=newArray;
    }

    //NOTE:problems arise when there is a null in the array (NullPointerException)        
    public void isort(){
    	for (int j=0;j<data.length;j++){
    	    String newValue = data[j];
    	    int i;
    	    for (i=j;i>0 && data[i-1].compareTo(newValue)>0;i--){
    		data[i]=data[i-1];
    	    }
    	    data[i]=newValue;
    	}
    }

    public String min(){
	String winner = data[0];
	for (int i=0;i<data.length;i++){
	    if (data[i].compareTo(winner)>0){
		winner = data[i];
	    }
	}
	return winner;
    }

    public void ssort(){
	for (int j=0;j<data.length;j++){
	    String min = data[j];
	    int minIndex = j;
	    for (int i=j;i<data.length;i++){
		if (data[i].compareTo(min)<0){
		    min = data[i];
		    minIndex = i;
		}
	    }
	    //System.out.println("min: "+min);
	    //System.out.println("j: "+j);
	    String temp = data[j];
	    data[j]=min;
	    data[minIndex] = temp;
	}
    }

    public void bsort(){
	for (int repeat=0;repeat<data.length;repeat++){
	    for(int j=0;j<data.length-1;j++){
		String currentMax = data[j];
		System.out.println("j: "+j);
		System.out.println("data[j]: "+data[j]);
		if (currentMax.compareTo(data[j+1])<0){ //new currentMax
		    currentMax = data[j+1];
		}
		else{
		    data[j]=data[j+1];
		    data[j+1]=currentMax;
		}
	    }
	}
    }

    

    /*-----------------MAIN------------------*/
    public static void main(String[] args){
	Sarray s = new Sarray();
	//String[] wordsToAdd = {"hello","world","hola","mundo","a","sky","full","of","stars","clocks"};
	String[] wordsToAdd = {"hello","world","hola","mundo","a","sky","full","of","stars","clocks","hello","world","hola","mundo","a","sky","full","of","stars","clocks","hello","world","hola","mundo","a","sky","full","of","stars","clocks","hello","world","hola","mundo","a","sky","full","of","stars","clocks","hello","world","hola","mundo","a","sky","full","of","stars","clocks","hello","world","hola","mundo","a","sky","full","of","stars","clocks","hello","world","hola","mundo","a","sky","full","of","stars","clocks","hello","world","hola","mundo","a","sky","full","of","stars","clocks","hello","world","hola","mundo","a","sky","full","of","stars","clocks","hello","world","hola","mundo","a","sky","full","of","stars","clocks"};
	for (int i=0;i<wordsToAdd.length;i++){
	    s.add(wordsToAdd[i]);
	}
	System.out.println((int)1.2);
	System.out.println(s);
	s.isort();
	//s.ssort();
	//s.bsort();
	System.out.println(s);

    }
}
