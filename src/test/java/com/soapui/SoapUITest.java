package com.soapui;

// import static org.junit.Assert.assertTrue;
import com.eviware.soapui.tools.SoapUITestCaseRunner;
import org.junit.Test;

public class SoapUITest {

    @Test
    public void testRunner() throws Exception {
        SoapUITestCaseRunner runner = new SoapUITestCaseRunner();
        runner.setProjectFile( "C:\\Users\\ciphe\\Documents\\Programming_local\\API\\payu_automation_assignment\\Automation Assignment.xml");
        runner.run();
    }

    @Test
    public void testSoapUIIntegration() {
        // Path to your SoapUI project file
        String projectPath = "C:\\Users\\ciphe\\Documents\\Programming_local\\API\\SoapUI\\CountryInfoService-soapui-project_proj.xml";

        // Create a new instance of SoapUITestCaseRunner
        SoapUITestCaseRunner runner = new SoapUITestCaseRunner();

        try {
            // Load the SoapUI project
            runner.setProjectFile(projectPath);

            // Run all test cases in the project
            runner.run();

            // Check if all test cases passed
            // assertTrue(runner.getResults().getErrorCount() == 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
