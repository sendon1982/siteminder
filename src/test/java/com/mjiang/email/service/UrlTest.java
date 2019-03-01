package com.mjiang.email.service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class UrlTest {

    @Test
    void test_removeParamFromUrl() throws Exception {
        String url = "http://www.google.com?query=Shanghai&foo=bar";
        String expectedUrl = "http://www.google.com?foo=bar";

        String result = removeQueryParameter(url, "query");
        Assert.assertThat(result, equalTo(expectedUrl));

        List<String> testList = new ArrayList<>();
        testList.add("1");
        testList.add("2");
        testList.add("3");
        testList.removeIf(s -> s.equals("2"));

        assertThat(testList.size(), equalTo(2));
        assertThat(testList, allOf(
            hasItems(
                equalTo("1"),
                equalTo("3")
            )
        ));
    }

    public String removeQueryParameter(String url, String parameterName) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(url);
        List<NameValuePair> queryParameters = uriBuilder.getQueryParams();

        queryParameters.removeIf(queryParameter -> queryParameter.getName().equals(parameterName));

        uriBuilder.setParameters(queryParameters);

        return uriBuilder.build().toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    void test_removeQueryParameters() throws Exception {
        String url = "http://www.google.com?query=Shanghai&foo=bar";
        String expectedUrl = "http://www.google.com";

        String result = removeQueryParameters(url);
        Assert.assertThat(result, equalTo(expectedUrl));
    }

    public String removeQueryParameters(String url) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(url);
        uriBuilder.removeQuery();

        return uriBuilder.build().toString();
    }
}
