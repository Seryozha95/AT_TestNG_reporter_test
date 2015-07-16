package testSuite;

import java.lang.reflect.Method;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestReporter {
	public static final String PROPERTY_JIRA_PROJECT_KEY = "JiraProjectKey";
	public static final String PROPERTY_JIRA_ASSIGNEE = "Assignee";
	public static final String PROPERTY_JIRA_COMPONENT = "Component";
	public static final String PROPERTY_JIRA_CUSTOMFIELDS = "CustomFields";
	public static final String PROPERTY_IGNORE_FAILURES = "IgnoreFailures";

	public TestReporter() {
		Logger.getLogger("org.apache.http").setLevel(Level.OFF);
		org.apache.log4j.BasicConfigurator.configure();

		System.setProperty(PROPERTY_JIRA_PROJECT_KEY, "CTQA");
		System.setProperty(PROPERTY_JIRA_ASSIGNEE, "");
		System.setProperty(PROPERTY_JIRA_COMPONENT, "UGC");
		System.setProperty(PROPERTY_IGNORE_FAILURES, "Authorization");
		System.setProperty(PROPERTY_JIRA_CUSTOMFIELDS,
				"[{\'field\':\'customfield_13912\',\'value\':\'CTQA-691\'}]");
	}

	@BeforeMethod(alwaysRun = true)
	public void startTestCase(Method method) {
		String testCaseId = method.getName();
		System.out.println("\n------------- Starting Test " + testCaseId
				+ " ------------");
	}

	@Test(description = "TTT_CMP_000")
	public void TTT_CMP_000() {
		for (int i = 0; i < 5; ++i) {
			System.out.println("-----" + i + "----");
		}
		assert true;
	}

	@Test(description = "TTT_CMP_001")
	public void TTT_CMP_001() throws Exception {
		for (int i = 0; i < 5; ++i) {
			System.out.println("-----" + i + "----");
		}
		throw new Exception(
				"[AT Test] Get campaign call returned 410 but expected 201");
	}

	@Test(description = "TTT_CMP_002")
	public void TTT_CMP_002() {
		for (int i = 0; i < 5; ++i) {
			System.out.println("-----" + i + "----");
		}
		assert true;
	}

	@Test(description = "TTT_CMP_003")
	public void TTT_CMP_003() throws Exception {
		for (int i = 0; i < 5; ++i) {
			System.out.println("-----" + i + "----");
		}
		throw new Exception(
				"[AT test] Get campaign call returned 410 but expected 201 Authorization");
	}
}
