package BookShelf.BookShelfApp.Dto;

import java.time.LocalDate;
import java.util.Objects;

public class DTOBook {

	private int id;
	private String title;
	private String genre;
	private LocalDate publish_year;
	private String description;
	private String publisher;
	private String author;
	private int pages;
	private String rate;
	private String reading_progress;
	private String comment;
	
	

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getReading_progress() {
		return reading_progress;
	}

	public void setReading_progress(String reading_progress) {
		this.reading_progress = reading_progress;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public LocalDate getPublish_year() {
		return publish_year;
	}

	public void setPublish_year(LocalDate publish_year) {
		this.publish_year = publish_year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "DTOBook [id=" + id + ", title=" + title + ", genre=" + genre + ", publish_year=" + publish_year
				+ ", description=" + description + ", publisher=" + publisher + ", author=" + author + ", pages="
				+ pages + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, description, genre, id, pages, publish_year, publisher, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTOBook other = (DTOBook) obj;
		return Objects.equals(author, other.author) && Objects.equals(description, other.description)
				&& Objects.equals(genre, other.genre) && id == other.id && pages == other.pages
				&& Objects.equals(publish_year, other.publish_year) && Objects.equals(publisher, other.publisher)
				&& Objects.equals(title, other.title);
	}

}
