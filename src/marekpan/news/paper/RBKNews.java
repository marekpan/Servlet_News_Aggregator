package marekpan.news.paper;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import marekpan.news.model.News;
import marekpan.news.model.NewsItem;

public class RBKNews extends News {
	
	public RBKNews() {
		super("РБК", "http://www.rbc.ru/");
	}

	@Override
	public List<NewsItem> getNews() {
		Document doc = getDoc();
		Elements news = doc.select(".main-feed__item");
		List<NewsItem> result = new ArrayList<>();
		for(Element el : news) {
			System.out.println(el.text());
			String text = el.text();
			String link = el.select("a").attr("href");
			result.add(new NewsItem(text, link));
		}
		
		return result;
	}
}
