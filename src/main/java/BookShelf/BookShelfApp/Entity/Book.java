package BookShelf.BookShelfApp.Entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	@ManyToOne
	@JoinColumn(name = "author_id", foreignKey = @ForeignKey(name = "FK_author_id"))
	private Author authorObj;
	
	@Id
	@GeneratedValue(strategy=jakarta.persistence.GenerationType.IDENTITY)
	private int id;
	
	@Column(name="title", nullable = false, length = 64)
	private String title;
	
	@Column(name="genre" , nullable = false, length = 64)
	private String genre;
	
	@Column(name="publish_year",  nullable = false)
	private LocalDate publish_year;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="publisher")
	private String publisher;
	
	@Column(name="author",  nullable = false, length = 32)
	private String author;
	
	@Column(name="pages")
	private int pages;
	
	@Column(name="rate")
	private String rate;
	
	@Column(name="reading_stage")
	private String reading_stage;
	
	@Column(name="comment")
	private String comment;

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

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getReading_stage() {
		return reading_stage;
	}

	public void setReading_stage(String reading_stage) {
		this.reading_stage = reading_stage;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Author getAuthorObj() {
		return authorObj;
	}

	public void setAuthorObj(Author authorObj) {
		this.authorObj = authorObj;
	}

	@Override
	public String toString() {
		return "Book [authorObj=" + authorObj + ", id=" + id + ", title=" + title + ", genre=" + genre
				+ ", publish_year=" + publish_year + ", description=" + description + ", publisher=" + publisher
				+ ", author=" + author + ", pages=" + pages + ", rate=" + rate + ", reading_stage=" + reading_stage
				+ ", comment=" + comment + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, authorObj, comment, description, genre, id, pages, publish_year, publisher, rate,
				reading_stage, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(authorObj, other.authorObj)
				&& Objects.equals(comment, other.comment) && Objects.equals(description, other.description)
				&& Objects.equals(genre, other.genre) && id == other.id && pages == other.pages
				&& Objects.equals(publish_year, other.publish_year) && Objects.equals(publisher, other.publisher)
				&& Objects.equals(rate, other.rate) && Objects.equals(reading_stage, other.reading_stage)
				&& Objects.equals(title, other.title);
	}

	
	

}