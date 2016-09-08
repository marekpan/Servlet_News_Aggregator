package marekpan.news.paper;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import marekpan.news.model.News;
import marekpan.news.model.NewsItem;

public class YandexNews extends News {
	
	public YandexNews() {
		super("Yandex", "https://www.yandex.ru/");
	}

	public List<NewsItem> getNews() {
		Document doc = getDoc();
		Elements news = doc.select(".b-news-list .list__item-content");
		List<NewsItem> result = new ArrayList<>();
		//First five items - main news. More than five - other news
		for(int i = 0; i<5; i++) {
			String text = news.get(i).text();
			String link = news.get(i).select("a").attr("href");
			result.add(new NewsItem(text, link));
		}
		return result;
	}
}
