/**
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at

 *  http://www.apache.org/licenses/LICENSE-2.0

 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.stratos.cli;

import java.io.IOException;
import java.net.ConnectException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class RestClient implements GenericRestClient{

    private String baseURL;
    private String username;
    private String password;

    private final int TIME_OUT_PARAM = 6000000;

    public RestClient(String baseURL, String username, String password) {
        this.baseURL = baseURL;
        this.username = username;
        this.password = password;
    }

    public String getBaseURL() {
		return baseURL;
	}

	/**
     * Handle http post request. Return String
     *
     * @param  httpClient
     *              This should be httpClient which used to connect to rest endpoint
     * @param resourcePath
     *              This should be REST endpoint
     * @param jsonParamString
     *              The json string which should be executed from the post request
     * @param username
     *              User name for basic auth
     * @param password
     *              Password for basic auth
     * @return The HttpResponse
     * @throws org.apache.http.client.ClientProtocolException and IOException
     *             if any errors occur when executing the request
     */
    public HttpResponse doPost(DefaultHttpClient httpClient, String resourcePath, String jsonParamString) throws Exception{
        try {
            HttpPost postRequest = new HttpPost(resourcePath);

            StringEntity input = new StringEntity(jsonParamString);
            input.setContentType("application/json");
            postRequest.setEntity(input);

            String userPass = username + ":" + password;
            String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userPass.getBytes("UTF-8"));
            postRequest.addHeader("Authorization", basicAuth);

            httpClient = (DefaultHttpClient) WebClientWrapper.wrapClient(httpClient);

            HttpParams params = httpClient.getParams();
            HttpConnectionParams.setConnectionTimeout(params, TIME_OUT_PARAM);
            HttpConnectionParams.setSoTimeout(params, TIME_OUT_PARAM);

            HttpResponse response = httpClient.execute(postRequest);

            return response;
        } catch (ClientProtocolException e) {
            throw new ClientProtocolException();
        } catch (ConnectException e) {
            throw new ConnectException();
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Handle http get request. Return String
     *
     * @param  httpClient
     *              This should be httpClient which used to connect to rest endpoint
     * @param resourcePath
     *              This should be REST endpoint
     * @param username
     *              User name for basic auth
     * @param password
     *              Password for basic auth
     * @return The HttpResponse
     * @throws org.apache.http.client.ClientProtocolException and IOException
     *             if any errors occur when executing the request
     */
    public HttpResponse doGet(DefaultHttpClient httpClient, String resourcePath) throws Exception{
        try {
            HttpGet getRequest = new HttpGet(resourcePath);
            getRequest.addHeader("Content-Type", "application/json");

            String userPass = username + ":" + password;
            String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userPass.getBytes("UTF-8"));
            getRequest.addHeader("Authorization", basicAuth);

            httpClient = (DefaultHttpClient) WebClientWrapper.wrapClient(httpClient);

            HttpParams params = httpClient.getParams();
            HttpConnectionParams.setConnectionTimeout(params, TIME_OUT_PARAM);
            HttpConnectionParams.setSoTimeout(params, TIME_OUT_PARAM);

            HttpResponse response = httpClient.execute(getRequest);

            return response;
        } catch (ClientProtocolException e) {
            throw new ClientProtocolException();
        } catch (ConnectException e) {
            throw new ConnectException();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public HttpResponse doDelete(DefaultHttpClient httpClient, String resourcePath) {
        try {
            HttpDelete httpDelete = new HttpDelete(resourcePath);
            httpDelete.addHeader("Content-Type", "application/json");

            String userPass = username + ":" + password;
            String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userPass.getBytes("UTF-8"));
            httpDelete.addHeader("Authorization", basicAuth);

            httpClient = (DefaultHttpClient) WebClientWrapper.wrapClient(httpClient);

            HttpParams params = httpClient.getParams();
            HttpConnectionParams.setConnectionTimeout(params, TIME_OUT_PARAM);
            HttpConnectionParams.setSoTimeout(params, TIME_OUT_PARAM);

            HttpResponse response = httpClient.execute(httpDelete);

            return  response;

        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void doPut() {
        // Not implemented
    }

}