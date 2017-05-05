package sample.war;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Sample WAR application
 */
@SpringBootApplication
@PropertySource(value = { "WEB-INF/custom.properties" })
public class SampleWarApplication extends SpringBootServletInitializer {
    public static WebApplicationContext ctx;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        ctx = this.createRootApplicationContext(servletContext);
    }

	public static void main(String[] args) {
		SpringApplication.run(SampleWarApplication.class, args);
	}

}
