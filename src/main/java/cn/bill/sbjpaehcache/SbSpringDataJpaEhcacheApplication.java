package cn.bill.sbjpaehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Description: <br/>
 * Date:2018年8月7日 下午5:10:55 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
//启用缓存@EnableCaching
@EnableCaching
@SpringBootApplication
public class SbSpringDataJpaEhcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbSpringDataJpaEhcacheApplication.class, args);
	}
}
