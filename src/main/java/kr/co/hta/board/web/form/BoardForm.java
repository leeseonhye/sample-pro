package kr.co.hta.board.web.form;

import org.springframework.web.multipart.MultipartFile;

public class BoardForm {
	private int no;
	private String title;
	private String contents;
	private MultipartFile upfile;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public MultipartFile getUpfile() {
		return upfile;
	}
	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}
	@Override
	public String toString() {
		return "BoardForm [no=" + no + ", title=" + title + ", contents=" + contents + ", upfile=" + upfile + "]";
	}
}
