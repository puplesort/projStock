package Board;

import java.sql.Date;

public class Board {
	private int num;
	private int writer;
	private Date wdate;
	private String title;
	private String content;
	
	public Board() {
	}

	public Board(int num, int writer, Date wdate, String title, String content) {
		super();
		this.num = num;
		this.writer = writer;
		this.wdate = wdate;
		this.title = title;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getWriter() {
		return writer;
	}

	public void setWriter(int writer) {
		this.writer = writer;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [num=" + num + ", writer=" + writer + ", wdate=" + wdate + ", title=" + title + ", content="
				+ content + "]";
	}
	
}
