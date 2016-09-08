package marekpan.news.paper;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import marekpan.news.model.News;
import marekpan.news.model.NewsItem;

public class MailNews extends News {

	public MailNews() {
		super("Mail.Ru", "https://mail.ru/");
	}
	
	@Override
	public List<NewsItem> getNews() {
		Document doc = getDoc();
		Element newsBlock = doc.getElementById("news:main");
		Elements news = newsBlock.select(".news__list__item__link");
		List<NewsItem> result = new ArrayList<>();
		//First div with .news__list__item__link is image. Last two items - ad
		for(int i = 1; i<news.size()-2; i++) {
			String text = news.get(i).text();
			String link = news.get(i).select("a").attr("href");
			result.add(new NewsItem(text, link));
		}
		return result;
	}
}
