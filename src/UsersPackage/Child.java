package UsersPackage;

public class Child extends ProfileAbstract implements ChildInterface {
	private int age;
	public Child(String nome, int age) {
		super(nome);
		this.age=age;
		assert (age>=5 && age<=12);
	}
	@Override
	public int getAge() {
		return age;
	}

}
