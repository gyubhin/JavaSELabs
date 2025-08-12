package workshop.animal.entity;

public class Cat extends Animal implements Pet{
	private String name;

	public Cat(String name) {
		super(4); //legs를 4로 설정 
		this.name = name;
	}
	
	public Cat() {
//		super(4);
		this(""); //Cat(String name) 생성자 부르는 것...
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void play() {
		System.out.println("고야잉는 장화를 신고 놀아요");
	}

	@Override
	public void eat() {
		System.out.println("고양이는 생선을 먹어요");
	}
	
	
}