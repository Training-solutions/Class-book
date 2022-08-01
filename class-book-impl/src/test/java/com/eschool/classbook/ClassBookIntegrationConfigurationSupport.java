package com.eschool.classbook;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.TestPropertySource;

@TestConfiguration
@TestPropertySource(locations = "/application.yml")
public class ClassBookIntegrationConfigurationSupport {
}
