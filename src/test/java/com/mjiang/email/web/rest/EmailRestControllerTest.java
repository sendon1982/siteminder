package com.mjiang.email.web.rest;

import com.mjiang.email.model.EmailRequest;
import com.mjiang.email.service.FailOverEmailService;
import com.mjiang.email.service.TestUtil;
import com.mjiang.email.util.JsonUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class EmailRestControllerTest {

    static final String SEND_MAIL_URL = "/rest/email/send";

    MockMvc mockMvc;

    @Mock
    FailOverEmailService emailService;

    @InjectMocks
    EmailRestController controller;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        controller.setFailOverEmailService(emailService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void test_sendEmail_from_null() throws Exception {
        EmailRequest emailRequest = TestUtil.buildEmailRequest();
        emailRequest.setFrom(null);

        String requestBodyJson =  JsonUtil.convertToString(emailRequest);

        mockMvc.perform(MockMvcRequestBuilders.post(SEND_MAIL_URL)
                                              .contentType(MediaType.APPLICATION_JSON)
                                              .content(requestBodyJson))
               .andExpect(status().isOk());
    }

    @Test
    public void test_sendEmail_success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(SEND_MAIL_URL)
                                              .contentType(MediaType.APPLICATION_JSON)
                                              .content(getValidRequestBodyForPost()))
               .andExpect(status().isOk());
    }

    String getValidRequestBodyForPost() {
        return JsonUtil.convertToString(TestUtil.buildEmailRequest());
    }

}
