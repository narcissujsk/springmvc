package learn.springInAction.aop;

public class User {
	
	public void Log(int id) {
		System.out.println("the log method run id is "+id);
	}
	public void Log() {
		System.out.println("the log method run  ");
	}

}
