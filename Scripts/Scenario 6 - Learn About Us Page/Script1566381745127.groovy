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
import com.kms.katalon.core.logging.KeywordLogger
KeywordLogger logger = new KeywordLogger()

WebUI.openBrowser('https://www.vehicleHistory.com')

WebUI.maximizeWindow()

WebUI.waitForPageLoad(20)

WebUI.click(findTestObject('Scenario6/learnAboutUsButton'))

WebUI.waitForPageLoad(20)

String aboutURL = WebUI.getUrl()

WebUI.click(findTestObject('Scenario6/careersButton'))

WebUI.waitForPageLoad(20)

String careerURL = WebUI.getUrl()

WebUI.click(findTestObject('Scenario6/contactButton'))

WebUI.waitForPageLoad(20)

String contactURL = WebUI.getUrl()

if (aboutURL.contains('about')) {
    logger.logPassed('The Navigation is proper for the About Page after clicking on Learn About Us')
} else {
    logger.logFailed('The Navigation is not proper for the About Page after clicking on Learn About Us')
}

if (careerURL.contains('careers')) {
    logger.logPassed('The Navigation is proper for the Career Page after clicking on Career button')
} else {
    logger.logFailed('The Navigation is not proper for the Career Page after clicking on Career button')
}

if (contactURL.contains('contact')) {
    logger.logPassed('The Navigation is proper for the Contact Page after clicking on Contact button')
} else {
    logger.logFailed('The Navigation is not proper for the Contact Page after clicking on Contact button')
}

WebUI.closeBrowser()

