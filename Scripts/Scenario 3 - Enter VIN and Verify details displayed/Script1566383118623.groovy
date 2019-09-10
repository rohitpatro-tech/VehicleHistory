import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import java.awt.Robot as Robot
import java.awt.Toolkit as Toolkit
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.logging.KeywordLogger

KeywordLogger logger = new KeywordLogger()

WebUI.openBrowser('https://randomlicenseplate.com/vin')

WebUI.waitForPageLoad(20)

WebUI.click(findTestObject('Scenario3/randomRealButton'))

WebUI.waitForPageLoad(20)

String vinNumber = WebUI.getText(findTestObject('Scenario3/realVIN')).trim()

WebUI.closeBrowser()

WebUI.openBrowser('https://www.vehicleHistory.com')

WebUI.waitForPageLoad(20)

WebUI.maximizeWindow()

WebUI.sendKeys(findTestObject('Scenario3/objectVIN'), vinNumber)

WebUI.click(findTestObject('Scenario3/searchButton'))

String vinNumberAfter = WebUI.getText(findTestObject('Scenario3/numberAfterClicking')).trim()

if (vinNumberAfter.equals(vinNumber)) {
    logger.logPassed('The Vin is successfully Navigated')
} else {
    logger.logFailed('The Vin is not successfully Navigated')
}

if (WebUI.verifyElementVisible(findTestObject('Scenario3/SummarySection'))) {
    logger.logPassed('The Summary Section is successfully Navigated')
} else {
    logger.logFailed('The Summary Section is not successfully Navigated')
}

if (WebUI.verifyElementVisible(findTestObject('Scenario3/detailedRecords'))) {
    logger.logPassed('The Detailed Records is successfully Navigated')
} else {
    logger.logFailed('The Detailed Records is not successfully Navigated')
}

if (WebUI.verifyElementVisible(findTestObject('Scenario3/salesRecords'))) {
    logger.logPassed('The Sales Records is successfully Navigated')
} else {
    logger.logFailed('The Sales Records is not successfully Navigated')
}

if (WebUI.verifyElementVisible(findTestObject('Scenario3/accidents'))) {
    logger.logPassed('The Accident Records is successfully Navigated')
} else {
    logger.logFailed('The Accident Records is not successfully Navigated')
}

if (WebUI.verifyElementVisible(findTestObject('Scenario3/theftRecords'))) {
    logger.logPassed('The Theft Records is successfully Navigated')
} else {
    logger.logFailed('The Theft Records is not successfully Navigated')
}

WebUI.closeBrowser()

