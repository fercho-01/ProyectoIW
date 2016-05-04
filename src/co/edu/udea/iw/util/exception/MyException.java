package co.edu.udea.iw.util.exception;
/*
 * Esta clase captura las excepciones generadas por el sistema
 * @author LUIS FERNANDO OROZCO
 * @version 03/05/2016
 */

public class MyException extends Exception{
	public MyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public MyException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public MyException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public MyException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
