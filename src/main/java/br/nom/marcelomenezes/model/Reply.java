package br.nom.marcelomenezes.model;

public class Reply {

	private final long id;
	private final String content;

	public Reply() {
		this.id = 0L;
		this.content = "o brave new world that has such people in it";
	}
	
	public Reply(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
}
