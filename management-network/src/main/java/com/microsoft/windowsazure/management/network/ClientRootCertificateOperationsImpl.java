/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management.network;

import com.microsoft.windowsazure.AzureHttpStatus;
import com.microsoft.windowsazure.core.ServiceOperations;
import com.microsoft.windowsazure.core.utils.BOMInputStream;
import com.microsoft.windowsazure.core.utils.StreamUtils;
import com.microsoft.windowsazure.core.utils.XmlUtility;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.management.network.models.ClientRootCertificateCreateParameters;
import com.microsoft.windowsazure.management.network.models.ClientRootCertificateGetResponse;
import com.microsoft.windowsazure.management.network.models.ClientRootCertificateListResponse;
import com.microsoft.windowsazure.management.network.models.GatewayOperationResponse;
import com.microsoft.windowsazure.tracing.CloudTracing;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
* The Network Management API includes operations for managing the client root
* certificates for your subscription.  (see
* http://msdn.microsoft.com/en-us/library/windowsazure/jj154113.aspx for more
* information)
*/
public class ClientRootCertificateOperationsImpl implements ServiceOperations<NetworkManagementClientImpl>, ClientRootCertificateOperations {
    /**
    * Initializes a new instance of the ClientRootCertificateOperationsImpl
    * class.
    *
    * @param client Reference to the service client.
    */
    ClientRootCertificateOperationsImpl(NetworkManagementClientImpl client) {
        this.client = client;
    }
    
    private NetworkManagementClientImpl client;
    
    /**
    * Gets a reference to the
    * microsoft.windowsazure.management.network.NetworkManagementClientImpl.
    * @return The Client value.
    */
    public NetworkManagementClientImpl getClient() {
        return this.client;
    }
    
    /**
    * The Upload Client Root Certificate operation is used to upload a new
    * client root certificate to Azure.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn205129.aspx for
    * more information)
    *
    * @param networkName Required. The name of the virtual network for this
    * gateway.
    * @param parameters Required. Parameters supplied to the Upload Client Root
    * Certificate Virtual Network Gateway operation.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public Future<GatewayOperationResponse> createAsync(final String networkName, final ClientRootCertificateCreateParameters parameters) {
        return this.getClient().getExecutorService().submit(new Callable<GatewayOperationResponse>() { 
            @Override
            public GatewayOperationResponse call() throws Exception {
                return create(networkName, parameters);
            }
         });
    }
    
    /**
    * The Upload Client Root Certificate operation is used to upload a new
    * client root certificate to Azure.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn205129.aspx for
    * more information)
    *
    * @param networkName Required. The name of the virtual network for this
    * gateway.
    * @param parameters Required. Parameters supplied to the Upload Client Root
    * Certificate Virtual Network Gateway operation.
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @throws InterruptedException Thrown when a thread is waiting, sleeping,
    * or otherwise occupied, and the thread is interrupted, either before or
    * during the activity. Occasionally a method may wish to test whether the
    * current thread has been interrupted, and if so, to immediately throw
    * this exception. The following code can be used to achieve this effect:
    * @throws ExecutionException Thrown when attempting to retrieve the result
    * of a task that aborted by throwing an exception. This exception can be
    * inspected using the Throwable.getCause() method.
    * @throws ServiceException Thrown if the server returned an error for the
    * request.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public GatewayOperationResponse create(String networkName, ClientRootCertificateCreateParameters parameters) throws MalformedURLException, ProtocolException, ServiceException, IOException, ParserConfigurationException, SAXException, InterruptedException, ExecutionException {
        // Validate
        if (networkName == null) {
            throw new NullPointerException("networkName");
        }
        if (parameters == null) {
            throw new NullPointerException("parameters");
        }
        if (parameters.getCertificate() == null) {
            throw new NullPointerException("parameters.Certificate");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("networkName", networkName);
            tracingParameters.put("parameters", parameters);
            CloudTracing.enter(invocationId, this, "createAsync", tracingParameters);
        }
        
        // Construct URL
        String baseUrl = this.getClient().getBaseUri().toString();
        String url = "/" + (this.getClient().getCredentials().getSubscriptionId() != null ? this.getClient().getCredentials().getSubscriptionId().trim() : "") + "/services/networking/" + networkName.trim() + "/gateway/clientrootcertificates";
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        
        // Create HTTP transport objects
        URL serverAddress = new URL(url);
        HttpURLConnection httpRequest = ((HttpURLConnection) serverAddress.openConnection());
        httpRequest.setRequestMethod("POST");
        httpRequest.setDoOutput(true);
        
        // Set Headers
        httpRequest.setRequestProperty("Content-Type", "application/xml");
        httpRequest.setRequestProperty("x-ms-version", "2014-05-01");
        
        // Set Credentials
        this.getClient().getCredentials().processRequest(httpRequest);
        
        // Serialize Request
        String requestContent = parameters.getCertificate();
        httpRequest.setRequestProperty("Content-Type", "application/xml");
        
        // Send Request
        try {
            httpRequest.getOutputStream().write(requestContent.getBytes());
            int statusCode = httpRequest.getResponseCode();
            if (statusCode != AzureHttpStatus.ACCEPTED) {
                ServiceException ex = ServiceException.createFromXml(requestContent, httpRequest.getResponseMessage(), httpRequest.getResponseCode(), httpRequest.getContentType(), httpRequest.getInputStream());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            GatewayOperationResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpRequest.getInputStream();
            result = new GatewayOperationResponse();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document responseDoc = documentBuilder.parse(new BOMInputStream(responseContent));
            
            Element gatewayOperationAsyncResponseElement = XmlUtility.getElementByTagNameNS(responseDoc, "http://schemas.microsoft.com/windowsazure", "GatewayOperationAsyncResponse");
            if (gatewayOperationAsyncResponseElement != null) {
                Element idElement = XmlUtility.getElementByTagNameNS(gatewayOperationAsyncResponseElement, "http://schemas.microsoft.com/windowsazure", "ID");
                if (idElement != null) {
                    String idInstance;
                    idInstance = idElement.getTextContent();
                    result.setOperationId(idInstance);
                }
            }
            
            result.setStatusCode(statusCode);
            result.setRequestId(httpRequest.getHeaderField("x-ms-request-id"));
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpRequest != null) {
                httpRequest.disconnect();
            }
        }
    }
    
    /**
    * The Delete Client Root Certificate operation deletes a previously
    * uploaded client root certificate from Azure.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn205128.aspx for
    * more information)
    *
    * @param networkName Required. The name of the virtual network for this
    * gateway.
    * @param certificateThumbprint Required. The X509 certificate thumbprint.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public Future<GatewayOperationResponse> deleteAsync(final String networkName, final String certificateThumbprint) {
        return this.getClient().getExecutorService().submit(new Callable<GatewayOperationResponse>() { 
            @Override
            public GatewayOperationResponse call() throws Exception {
                return delete(networkName, certificateThumbprint);
            }
         });
    }
    
    /**
    * The Delete Client Root Certificate operation deletes a previously
    * uploaded client root certificate from Azure.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn205128.aspx for
    * more information)
    *
    * @param networkName Required. The name of the virtual network for this
    * gateway.
    * @param certificateThumbprint Required. The X509 certificate thumbprint.
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @throws InterruptedException Thrown when a thread is waiting, sleeping,
    * or otherwise occupied, and the thread is interrupted, either before or
    * during the activity. Occasionally a method may wish to test whether the
    * current thread has been interrupted, and if so, to immediately throw
    * this exception. The following code can be used to achieve this effect:
    * @throws ExecutionException Thrown when attempting to retrieve the result
    * of a task that aborted by throwing an exception. This exception can be
    * inspected using the Throwable.getCause() method.
    * @throws ServiceException Thrown if the server returned an error for the
    * request.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public GatewayOperationResponse delete(String networkName, String certificateThumbprint) throws MalformedURLException, ProtocolException, ServiceException, IOException, ParserConfigurationException, SAXException, InterruptedException, ExecutionException {
        // Validate
        if (networkName == null) {
            throw new NullPointerException("networkName");
        }
        if (certificateThumbprint == null) {
            throw new NullPointerException("certificateThumbprint");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("networkName", networkName);
            tracingParameters.put("certificateThumbprint", certificateThumbprint);
            CloudTracing.enter(invocationId, this, "deleteAsync", tracingParameters);
        }
        
        // Construct URL
        String baseUrl = this.getClient().getBaseUri().toString();
        String url = "/" + (this.getClient().getCredentials().getSubscriptionId() != null ? this.getClient().getCredentials().getSubscriptionId().trim() : "") + "/services/networking/" + networkName.trim() + "/gateway/clientrootcertificates/" + certificateThumbprint.trim();
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        
        // Create HTTP transport objects
        URL serverAddress = new URL(url);
        HttpURLConnection httpRequest = ((HttpURLConnection) serverAddress.openConnection());
        httpRequest.setRequestMethod("DELETE");
        httpRequest.setDoOutput(true);
        
        // Set Headers
        httpRequest.setRequestProperty("Content-Type", "application/xml");
        httpRequest.setRequestProperty("x-ms-version", "2014-05-01");
        
        // Set Credentials
        this.getClient().getCredentials().processRequest(httpRequest);
        
        // Send Request
        try {
            int statusCode = httpRequest.getResponseCode();
            if (statusCode != AzureHttpStatus.OK) {
                ServiceException ex = ServiceException.createFromXml(null, httpRequest.getResponseMessage(), httpRequest.getResponseCode(), httpRequest.getContentType(), httpRequest.getInputStream());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            GatewayOperationResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpRequest.getInputStream();
            result = new GatewayOperationResponse();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document responseDoc = documentBuilder.parse(new BOMInputStream(responseContent));
            
            Element gatewayOperationAsyncResponseElement = XmlUtility.getElementByTagNameNS(responseDoc, "http://schemas.microsoft.com/windowsazure", "GatewayOperationAsyncResponse");
            if (gatewayOperationAsyncResponseElement != null) {
                Element idElement = XmlUtility.getElementByTagNameNS(gatewayOperationAsyncResponseElement, "http://schemas.microsoft.com/windowsazure", "ID");
                if (idElement != null) {
                    String idInstance;
                    idInstance = idElement.getTextContent();
                    result.setOperationId(idInstance);
                }
            }
            
            result.setStatusCode(statusCode);
            result.setRequestId(httpRequest.getHeaderField("x-ms-request-id"));
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpRequest != null) {
                httpRequest.disconnect();
            }
        }
    }
    
    /**
    * The Get Client Root Certificate operation returns the public portion of a
    * previously uploaded client root certificate in a base-64-encoded format
    * from Azure.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn205127.aspx for
    * more information)
    *
    * @param networkName Required. The name of the virtual network for this
    * gateway.
    * @param certificateThumbprint Required. The X509 certificate thumbprint.
    * @return Response to the Get Client Root Certificate operation.
    */
    @Override
    public Future<ClientRootCertificateGetResponse> getAsync(final String networkName, final String certificateThumbprint) {
        return this.getClient().getExecutorService().submit(new Callable<ClientRootCertificateGetResponse>() { 
            @Override
            public ClientRootCertificateGetResponse call() throws Exception {
                return get(networkName, certificateThumbprint);
            }
         });
    }
    
    /**
    * The Get Client Root Certificate operation returns the public portion of a
    * previously uploaded client root certificate in a base-64-encoded format
    * from Azure.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn205127.aspx for
    * more information)
    *
    * @param networkName Required. The name of the virtual network for this
    * gateway.
    * @param certificateThumbprint Required. The X509 certificate thumbprint.
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return Response to the Get Client Root Certificate operation.
    */
    @Override
    public ClientRootCertificateGetResponse get(String networkName, String certificateThumbprint) throws MalformedURLException, ProtocolException, ServiceException, IOException, ParserConfigurationException, SAXException {
        // Validate
        if (networkName == null) {
            throw new NullPointerException("networkName");
        }
        if (certificateThumbprint == null) {
            throw new NullPointerException("certificateThumbprint");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("networkName", networkName);
            tracingParameters.put("certificateThumbprint", certificateThumbprint);
            CloudTracing.enter(invocationId, this, "getAsync", tracingParameters);
        }
        
        // Construct URL
        String baseUrl = this.getClient().getBaseUri().toString();
        String url = "/" + (this.getClient().getCredentials().getSubscriptionId() != null ? this.getClient().getCredentials().getSubscriptionId().trim() : "") + "/services/networking/" + networkName.trim() + "/gateway/clientrootcertificates/" + certificateThumbprint.trim();
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        
        // Create HTTP transport objects
        URL serverAddress = new URL(url);
        HttpURLConnection httpRequest = ((HttpURLConnection) serverAddress.openConnection());
        httpRequest.setRequestMethod("GET");
        httpRequest.setDoOutput(true);
        
        // Set Headers
        httpRequest.setRequestProperty("x-ms-version", "2014-05-01");
        
        // Set Credentials
        this.getClient().getCredentials().processRequest(httpRequest);
        
        // Send Request
        try {
            int statusCode = httpRequest.getResponseCode();
            if (statusCode != AzureHttpStatus.OK) {
                ServiceException ex = ServiceException.createFromXml(null, httpRequest.getResponseMessage(), httpRequest.getResponseCode(), httpRequest.getContentType(), httpRequest.getInputStream());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            ClientRootCertificateGetResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpRequest.getInputStream();
            result = new ClientRootCertificateGetResponse();
            result.setCertificate(StreamUtils.toString(responseContent));
            
            result.setStatusCode(statusCode);
            result.setRequestId(httpRequest.getHeaderField("x-ms-request-id"));
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpRequest != null) {
                httpRequest.disconnect();
            }
        }
    }
    
    /**
    * The List Client Root Certificates operation returns a list of all the
    * client root certificates that are associated with the specified virtual
    * network in Azure.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn205130.aspx for
    * more information)
    *
    * @param networkName Required. The name of the virtual network for this
    * gateway.
    * @return The response for the List Client Root Certificates operation.
    */
    @Override
    public Future<ClientRootCertificateListResponse> listAsync(final String networkName) {
        return this.getClient().getExecutorService().submit(new Callable<ClientRootCertificateListResponse>() { 
            @Override
            public ClientRootCertificateListResponse call() throws Exception {
                return list(networkName);
            }
         });
    }
    
    /**
    * The List Client Root Certificates operation returns a list of all the
    * client root certificates that are associated with the specified virtual
    * network in Azure.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn205130.aspx for
    * more information)
    *
    * @param networkName Required. The name of the virtual network for this
    * gateway.
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return The response for the List Client Root Certificates operation.
    */
    @Override
    public ClientRootCertificateListResponse list(String networkName) throws MalformedURLException, ProtocolException, ServiceException, IOException, ParserConfigurationException, SAXException {
        // Validate
        if (networkName == null) {
            throw new NullPointerException("networkName");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("networkName", networkName);
            CloudTracing.enter(invocationId, this, "listAsync", tracingParameters);
        }
        
        // Construct URL
        String baseUrl = this.getClient().getBaseUri().toString();
        String url = "/" + (this.getClient().getCredentials().getSubscriptionId() != null ? this.getClient().getCredentials().getSubscriptionId().trim() : "") + "/services/networking/" + networkName.trim() + "/gateway/clientrootcertificates";
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        
        // Create HTTP transport objects
        URL serverAddress = new URL(url);
        HttpURLConnection httpRequest = ((HttpURLConnection) serverAddress.openConnection());
        httpRequest.setRequestMethod("GET");
        httpRequest.setDoOutput(true);
        
        // Set Headers
        httpRequest.setRequestProperty("Content-Type", "application/xml");
        httpRequest.setRequestProperty("x-ms-version", "2014-05-01");
        
        // Set Credentials
        this.getClient().getCredentials().processRequest(httpRequest);
        
        // Send Request
        try {
            int statusCode = httpRequest.getResponseCode();
            if (statusCode != AzureHttpStatus.OK) {
                ServiceException ex = ServiceException.createFromXml(null, httpRequest.getResponseMessage(), httpRequest.getResponseCode(), httpRequest.getContentType(), httpRequest.getInputStream());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            ClientRootCertificateListResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpRequest.getInputStream();
            result = new ClientRootCertificateListResponse();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document responseDoc = documentBuilder.parse(new BOMInputStream(responseContent));
            
            Element clientRootCertificatesSequenceElement = XmlUtility.getElementByTagNameNS(responseDoc, "http://schemas.microsoft.com/windowsazure", "ClientRootCertificates");
            if (clientRootCertificatesSequenceElement != null) {
                for (int i1 = 0; i1 < com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(clientRootCertificatesSequenceElement, "http://schemas.microsoft.com/windowsazure", "ClientRootCertificate").size(); i1 = i1 + 1) {
                    org.w3c.dom.Element clientRootCertificatesElement = ((org.w3c.dom.Element) com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(clientRootCertificatesSequenceElement, "http://schemas.microsoft.com/windowsazure", "ClientRootCertificate").get(i1));
                    ClientRootCertificateListResponse.ClientRootCertificate clientRootCertificateInstance = new ClientRootCertificateListResponse.ClientRootCertificate();
                    result.getClientRootCertificates().add(clientRootCertificateInstance);
                    
                    Element expirationTimeElement = XmlUtility.getElementByTagNameNS(clientRootCertificatesElement, "http://schemas.microsoft.com/windowsazure", "ExpirationTime");
                    if (expirationTimeElement != null) {
                        Calendar expirationTimeInstance;
                        expirationTimeInstance = DatatypeConverter.parseDateTime(expirationTimeElement.getTextContent());
                        clientRootCertificateInstance.setExpirationTime(expirationTimeInstance);
                    }
                    
                    Element subjectElement = XmlUtility.getElementByTagNameNS(clientRootCertificatesElement, "http://schemas.microsoft.com/windowsazure", "Subject");
                    if (subjectElement != null) {
                        String subjectInstance;
                        subjectInstance = subjectElement.getTextContent();
                        clientRootCertificateInstance.setSubject(subjectInstance);
                    }
                    
                    Element thumbprintElement = XmlUtility.getElementByTagNameNS(clientRootCertificatesElement, "http://schemas.microsoft.com/windowsazure", "Thumbprint");
                    if (thumbprintElement != null) {
                        String thumbprintInstance;
                        thumbprintInstance = thumbprintElement.getTextContent();
                        clientRootCertificateInstance.setThumbprint(thumbprintInstance);
                    }
                }
            }
            
            result.setStatusCode(statusCode);
            result.setRequestId(httpRequest.getHeaderField("x-ms-request-id"));
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpRequest != null) {
                httpRequest.disconnect();
            }
        }
    }
}
