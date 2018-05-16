package kr.co.hta.board.vo;

import java.util.Arrays;

public class Criteria {

	private String title;
	private String author;
	private String publisher;
	private String[] categories;
	private Integer minPrice;
	private Integer maxPrice;
	private String status;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String[] getCategories() {
		return categories;
	}
	public void setCategories(String[] categories) {
		this.categories = categories;
	}
	public Integer getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}
	public Integer getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Criteria [title=" + title + ", author=" + author + ", publisher=" + publisher + ", categories="
				+ Arrays.toString(categories) + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", status="
				+ status + "]";
	}
}
