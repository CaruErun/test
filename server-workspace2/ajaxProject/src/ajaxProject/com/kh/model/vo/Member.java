package ajaxProject.com.kh.model.vo;

public class Member {
	private int memberNo;
	private String memberName;
	private int age;

	public Member() {
		super();
	}

	public Member(int memberNo, String memberName, int age) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.age = age;
	}

	public Member(String memberName, int age) {
		super();
		this.memberName = memberName;
		this.age = age;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberName=" + memberName + ", age=" + age + "]";
	}

	
	
}