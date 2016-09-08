package marekpan.news.paper;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import marekpan.news.model.*;

public class BBCNews extends News {
	
	public BBCNews() {
		super("BBC", "http://www.bbc.com/russian/news");
	}
	
	@Override
	public List<NewsItem> getNews() {
		Document doc = getDoc();
		Elements news = doc.select(".title-link");
		List<NewsItem> result = new ArrayList<>();
		for(Element el : news) {
			String text = el.text();
			String link = "http://www.bbc.com/" + el.attr("href");
			result.add(new NewsItem(text, link));
		}
		return result;
	}
}
