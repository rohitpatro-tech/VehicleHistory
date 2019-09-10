import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import org.openqa.selenium.Keys as Keys
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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import java.awt.Robot as Robot
import java.awt.Toolkit as Toolkit
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.logging.KeywordLogger

KeywordLogger logger = new KeywordLogger()

WebUI.openBrowser('https://www.vehicleHistory.com')

WebUI.maximizeWindow()

WebUI.waitForPageLoad(20)

WebUI.click(findTestObject('Scenario2/carResearch'))

WebUI.waitForPageLoad(30)

WebUI.click(findTestObject('Scenario2/selectMake'))

WebUI.waitForPageLoad(20)

WebUI.click(findTestObject('Scenario2/selectAudi'))

WebUI.waitForPageLoad(20)

WebUI.click(findTestObject('Scenario2/selectModel'))

WebUI.waitForPageLoad(20)

WebUI.click(findTestObject('Scenario2/selectA4'))

Thread.sleep(5000)

//WebUI.click(findTestObject('Scenario2/heroContainer'))

//String text = WebUI.getText(findTestObject('Scenario2/searchButton')).trim()
WebUI.click(findTestObject('Scenario2/searchButton'))

//int x = WebUI.getElementHeight(findTestObject('Scenario2/searchButton'))
//int y = WebUI.getElementWidth(findTestObject('Scenario2/searchButton'))
//WebUI.clickOffset(findTestObject('Scenario2/searchButton'), 56, 124)
WebUI.waitForPageLoad(20)

String url = WebUI.getUrl()

//Verify URL after navigation
if (url.contains('audi/a4')) {
    logger.logPassed('Navigation for the car is successfully completed')
} else {
    logger.logFailed('Navigation for the car is not completed')
}

//Verify Title
String TitleVehiclePage = WebUI.getText(findTestObject('Scenario2/TitleVehiclePage'))

if (TitleVehiclePage.contains('Audi A4')) {
    logger.logPassed('Title in Vehicle Page is matching with the Search Criteria')
} else {
    logger.logFailed('Title in Vehicle Page is not matching with the Search Criteria')
}

//Verify Key Features
if (WebUI.verifyElementVisible(findTestObject('Scenario2/keyFeatures'))) {
    logger.logPassed('All the Key Features are Present in Vehicle page')
} else {
    logger.logFailed('All the key Features are not present in Vehicle page')
}

//verify Images are displayed or not
if (WebUI.verifyElementVisible(findTestObject('Scenario2/keyFeatures'))) {
    logger.logPassed('All the Images related to Audi A4 are displayed')
} else {
    logger.logFailed('All the Images related to Audi A4 are not Displayed')
}

// Verify Report Features
if (WebUI.verifyElementVisible(findTestObject('Scenario2/reportFeatures'))) {
    logger.logPassed('All the Report Features related to Audi A4 are displayed')
} else {
    logger.logFailed('All the Report Features related to Audi A4 are not Displayed')
}

// Verify Expert Reviews
if (WebUI.verifyElementVisible(findTestObject('Scenario2/expertReviews'))) {
    logger.logPassed('All the Expert Reviews related to Audi A4 are displayed')
} else {
    logger.logFailed('All the Expert Reviews related to Audi A4 are not Displayed')
}

//Verify if Trims are displayed
if (WebUI.verifyElementVisible(findTestObject('Scenario2/trims'))) {
    logger.logPassed('All the Trims related to Audi A4 are displayed')
} else {
    logger.logFailed('All the Trims related to Audi A4 are not Displayed')
}

//verify if Compare Section is available or not
if (WebUI.verifyElementVisible(findTestObject('Scenario2/compareModels'))) {
    logger.logPassed('All the Compare Models related to Audi A4 are displayed')
} else {
    logger.logFailed('All the Compare Models related to Audi A4 are not Displayed')
}

//verify if reliability Section is available or not
if (WebUI.verifyElementVisible(findTestObject('Scenario2/reliability'))) {
    logger.logPassed('All the Reliability related to Audi A4 are displayed')
} else {
    logger.logFailed('All the Reliability related to Audi A4 are not Displayed')
}

WebUI.closeBrowser()

