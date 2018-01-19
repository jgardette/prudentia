package prudentia

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import prudentia.controller.DeputeController


/**
 * The main entry point to the application
 */
@EnableAutoConfiguration
@Configuration
internal class Application {
    @Bean
    fun controller() = DeputeController()


    @Bean
    fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurerAdapter() {
            override fun addCorsMappings(registry: CorsRegistry?) {
                registry!!.addMapping("/**")
            }
        }
    }
}
/**
 * Run the application
 * @param args The command line arguments
 */
fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
