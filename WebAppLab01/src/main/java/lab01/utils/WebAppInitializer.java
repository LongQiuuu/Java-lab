package lab01.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;

@WebListener
public class WebAppInitializer implements ServletContextListener {
	//將Session工廠定義在外 變成區域變數
	SessionFactory factory; 
	//啟動伺服器的時候會做的事情
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("系統啟動中...");
		System.out.println("1.-----------------------------");
		//建立一個SessionFactory
		//建立之後他就會自動抓取並下載永續類別到資料庫 
		factory =HibernateUtils.getSessionFactory();
		System.out.println("2.-----------------------------");
	}
	//關閉伺服器的時候會做的事情
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("3.-----------------------------");
		//將Session工廠關閉
		factory.close();
		System.out.println("4.-----------------------------");
	}

}
