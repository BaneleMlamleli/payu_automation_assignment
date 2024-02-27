package com.soapui;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.model.iface.Submit.Status;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.*;
import com.eviware.soapui.tools.SoapUITestCaseRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SoapUITest {

    @Test
    public void testSoapUIIntegration() {
        // Path to your SoapUI project file
        String projectPath = "src\\resource\\automation_assignment_project.xml";

        // Create a new instance of SoapUITestCaseRunner
        SoapUITestCaseRunner runner = new SoapUITestCaseRunner();

        try {
            // Load the SoapUI project
            runner.setProjectFile(projectPath);

            // Run all test cases in the project
            runner.run();

            // Check if all failed cases
            assertFalse(runner.getFailedTests().isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIndividualTestCaseRunner() throws Exception {
        WsdlProject project = new WsdlProject( "src\\resource\\automation_assignment_project.xml" ); 
        TestSuite testSuite = project.getTestSuiteByName( "Test Suite 2" ); 
        TestCase testCase = testSuite.getTestCaseByName( "Test Case 1" );
        
        // create empty properties and run synchronously
        TestRunner runner = testCase.run( new PropertiesMap(), false ); 
        assertEquals(Status.FINISHED, runner.getStatus() ); 
    }
}