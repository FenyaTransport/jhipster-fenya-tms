package com.fenya.tms;

import com.fenya.tms.FenyaTmsApp;
import com.fenya.tms.config.AsyncSyncConfiguration;
import com.fenya.tms.config.EmbeddedElasticsearch;
import com.fenya.tms.config.EmbeddedKafka;
import com.fenya.tms.config.EmbeddedSQL;
import com.fenya.tms.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { FenyaTmsApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedElasticsearch
@EmbeddedKafka
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public @interface IntegrationTest {
}
