package in.ashokit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import in.ashokit.intercepter.GeneralIntercepter;
import in.ashokit.intercepter.MessageIntercepter;

//public class IntercepterConfig extends WebMvcConfigurationSupport

@Configuration
public class IntercepterConfig implements WebMvcConfigurer {

	@Autowired
	private GeneralIntercepter generalIntercepter;
	
	@Autowired
	private MessageIntercepter messageIntercepter;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
//		registry.addInterceptor(generalIntercepter).order(2);
//		registry.addInterceptor(messageIntercepter).order(1);
		
		registry.addInterceptor(generalIntercepter).addPathPatterns("/welcome/**").excludePathPatterns("/welcome/siva");
		registry.addInterceptor(messageIntercepter).addPathPatterns("/message/**");
	}

}
