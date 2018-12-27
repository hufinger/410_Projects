package Assignment0;

public class HelloWorld implements HelloWorld_Interface {
	
	public HelloWorld ( ) { 
		// default constructor
	    // explicitly include this
	    // we need to have the default constructor
	    // if you then write others, this one will still be there
	  }

	public String say_it() {
		String quiet = "hello world";
		return quiet;
	}

	public String say_it_loud() {
		String loud = "HELLO WORLD";
		return loud;
	}
}
