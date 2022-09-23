package br.com.fiap.fordclub.repository.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfiguration {

    @Bean
    public Flyway migrate(DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .locations("db/migration/")
                .dataSource(dataSource)
                .schemas("public")
                .load();

        flyway.migrate();
        return flyway;
    }

}
