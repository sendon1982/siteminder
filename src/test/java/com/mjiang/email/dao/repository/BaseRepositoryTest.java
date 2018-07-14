package com.mjiang.email.dao.repository;

import com.mjiang.email.config.JpaConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { JpaConfig.class })
@TestPropertySource(value = {"classpath:application.test.properties"})
class BaseRepositoryTest {

}
