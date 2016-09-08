package marekpan.news.model;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class News {
	private String url;
	private Document doc;
	private String name;
	
	protected News(String newsName, String newsUrl) {
		url = newsUrl;
		name = newsName;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getURL() {
		return url;
	}
	
	public String getName() {
		return name;
	}
	
	protected Document getDoc() {
		return doc;
	}
	
	public abstract List<NewsItem> getNews();
}
