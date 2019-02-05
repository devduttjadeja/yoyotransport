package practice;

class Parent{
	
	public void show() {
		System.out.println("parent show");
	}
	
}

class Child extends Parent{
	
	@Override
	public void show() {
		System.out.println("child show");
	}
	
	public void jump() {
		System.out.println("child jump");
	}
	
}



public class ParentChildExample {

	public static void main(String[] args) {

		Parent p = new Child();
		p.show();
		// p.jump(); compile time error
		
		Child c = new Child();
		
		c = (Child) p;
		c.jump(); // works
		
		Child c1 = (Child) new Parent(); // parent reference child object type casting is needed
	}

}
