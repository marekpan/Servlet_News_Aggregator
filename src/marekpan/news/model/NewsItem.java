package marekpan.news.model;

public class NewsItem {
	private String text;
	private String link;
	
	public NewsItem(String text, String link) {
		this.text = text;
		this.link = link;
	}
	
	public String getText() {
		return text;
	}
	
	public String getLink() {
		return link;
	}
}
