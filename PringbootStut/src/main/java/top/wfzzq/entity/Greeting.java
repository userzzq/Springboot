package top.wfzzq.entity;

public class Greeting {
	private Integer id;
	private String content;

	public Greeting() {

	}

	public Greeting(Integer id, String content) {
		this.id = id;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Greeting [id=" + id + ", content=" + content + "]";
	}

}
