package top.legend.configure;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Legend on 2017/10/15.
 */
@Configuration
public class WebMessageConvert extends WebMvcConfigurerAdapter {

    @Autowired ObjectMapper objectMapper ;

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.extendMessageConverters(converters);
        List<HttpMessageConverter> jacksonList = new ArrayList<>();
        if (converters != null && !converters.isEmpty()) {
            for (HttpMessageConverter<?> converter : converters) {
                if (converter instanceof AbstractJackson2HttpMessageConverter) {
                    jacksonList.add(converter);
                }
            }
        }

        converters.removeAll(jacksonList);
        converters.add(new JacksonHttpMessageConverter(objectMapper));
    }
}
