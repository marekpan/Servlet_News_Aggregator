package marekpan.news.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import marekpan.news.model.News;

public class MainController extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream inputStream = getClass().getResourceAsStream("/news.properties");
		Properties prop = new Properties();
		prop.load(inputStream);
		List<News> news = new ArrayList<>();
		for(Object str : prop.keySet()) {
			String key = (String) str;
			String val = prop.getProperty(key);
			if(Boolean.parseBoolean(val)) {
				News paper = null;
				try {
					paper = (News) Class.forName(key).newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				news.add(paper);
			}
			System.out.println(key);
		}
		request.setAttribute("news", news);
	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/main.jsp");
	    rd.forward(request, response);
	}
}
