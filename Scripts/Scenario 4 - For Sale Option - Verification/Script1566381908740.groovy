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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import java.awt.Robot as Robot
import java.awt.Toolkit as Toolkit
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.logging.KeywordLogger
KeywordLogger logger = new KeywordLogger()

WebUI.openBrowser('https://www.vehicleHistory.com')

WebUI.maximizeWindow()

WebUI.waitForPageLoad(20)

WebUI.click(findTestObject('Scenario4/forSaleOption'))

WebUI.waitForPageLoad(20)

WebUI.click(findTestObject('Scenario4/selectMake'))

Thread.sleep(2000)

WebUI.click(findTestObject('Scenario2/selectAudi'))

Thread.sleep(2000)

WebUI.click(findTestObject('Scenario4/selectModel'))

Thread.sleep(2000)

WebUI.click(findTestObject('Scenario2/selectA4'))

Thread.sleep(2000)

WebUI.click(findTestObject('Scenario4/enterZipcode'))

Robot robot = new Robot()

robot.keyPress(KeyEvent.VK_CONTROL)

robot.keyPress(KeyEvent.VK_A)

robot.keyRelease(KeyEvent.VK_CONTROL)

robot.keyRelease(KeyEvent.VK_A)

robot.keyPress(KeyEvent.VK_DELETE)

robot.keyRelease(KeyEvent.VK_DELETE)

//WebUI.clearText(findTestObject('Scenario4/enterZipcode'))
WebUI.waitForPageLoad(20)

WebUI.sendKeys(findTestObject('Scenario4/enterZipcode'), '89121')

Thread.sleep(5000)

WebUI.click(findTestObject('Scenario4/searchButton'))

Thread.sleep(10000)

String[] inventoryDis = WebUI.getText(findTestObject('Scenario4/totalCount')).split(' ')

int totalCountdisplay = Integer.parseInt(inventoryDis[0])

WebDriver driver = DriverFactory.getWebDriver()

int totalCountActual = driver.findElements(By.xpath('//div[contains(@class,\'VhContainer-main--withAside\')]/div')).size() - 
3

if (totalCountActual == totalCountdisplay) {
	logger.logPassed('The count of vehicles is matching with Actual count displayed')
} else {
    logger.logFailed('The count of vehicles is not matching with Actual count displayed')
}

//verifyFilters
if (WebUI.verifyElementVisible(findTestObject('Scenario4/filtersForSale'))) {
    logger.logPassed('All the Key filters are Present in For Sale page')
} else {
    logger.logFailed('All the Key filters are not Present in For Sale page')
}

//verifyFiltersforsorting
if (WebUI.verifyElementVisible(findTestObject('Scenario4/comboBoxFilters'))) {
    logger.logPassed('All the Key filters for sorting are Present in For Sale page')
} else {
    logger.logFailed('All the Key filters for sorting are not Present in For Sale page')
}

WebUI.closeBrowser()

