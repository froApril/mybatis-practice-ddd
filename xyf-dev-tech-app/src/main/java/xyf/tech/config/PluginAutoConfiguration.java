package xyf.tech.config;

import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyf.tech.plugin.FieldEncryptionAndDecryptionMyBatisPlugin;

@Configuration
public class PluginAutoConfiguration {
    @Bean
    public Interceptor plugin() {
        return new FieldEncryptionAndDecryptionMyBatisPlugin();
    }

}
