package com.mangocity.jodd.http;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

public class HttpClient {

	private static final String HTTP_TEST_URL = "http://localhost:8080/b2/doGet";

	public static void main(String[] args) {
		doGet1();
		doGet2();
		doPost();
		requestJSON();
	}

	/**
	 * parameterMap: {ok=[Ljava.lang.String;@539e6f73} JSONStr:
	 */
	public static void doGet1() {
		HttpResponse response = HttpRequest.get(HTTP_TEST_URL)
				.query("ok", "123").send();
		printHttpResponse("【doGet1】", response);
	}

	/**
	 * parameterMap: {ok=[Ljava.lang.String;@5a97acef,
	 * bad=[Ljava.lang.String;@1bdaad60} JSONStr:
	 */
	public static void doGet2() {
		HttpResponse response = HttpRequest.get(
				"http://localhost:8080/b2/doGet?ok=123&bad=321").send();
		printHttpResponse("【doGet2】", response);
	}

	/**
	 * parameterMap: {ok=[Ljava.lang.String;@2e0693ca} JSONStr:
	 */
	public static void doPost() {
		HttpResponse response = HttpRequest.post(HTTP_TEST_URL)
				.form("ok", "123").send();
		printHttpResponse("【doPost】", response);
	}

	public static void requestJSON() {
		HttpResponse response = HttpRequest.get(HTTP_TEST_URL).form("ok", "json").send();
		printHttpResponse("【requestJSON】", response);
	}

	private static void printHttpResponse(String methodName,
			HttpResponse response) {
		System.out.println("methodName: " + methodName
				+ " response statusCode: " + response.statusCode());
		System.out.println("===========================");
		System.out.println("methodName: " + methodName + " response text: "
				+ response);
		System.out.println("***************************");
	}

}
