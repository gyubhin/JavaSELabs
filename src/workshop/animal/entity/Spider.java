package workshop.animal.entity;

public class Spider extends Animal {

	public Spider() {
		super(8); //legs를 8로 설정
	}
	
	@Override
	public void eat() {
		System.out.println("거미는 벌레를 먹어요.");
	}
}