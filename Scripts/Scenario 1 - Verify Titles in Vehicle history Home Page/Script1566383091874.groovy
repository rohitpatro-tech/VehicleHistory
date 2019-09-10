import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.logging.KeywordLogger

KeywordLogger logger = new KeywordLogger()

WebUI.openBrowser('https://www.vehicleHistory.com')

WebUI.maximizeWindow()

WebUI.waitForPageLoad(40)

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> head = driver.findElements(By.xpath('//h2'))

String headingExp = 'Browse by Category, Best Cars under $30,000 of 2018, Best Full Size SUVs of 2018, Best Full Size Pickup Trucks, Popular Makes, '

String headingsAct = ''

for (WebElement h : head) {
    headingsAct = ((headingsAct + h.getText().trim()) + ', ')
}

if (headingExp.equals(headingsAct)) {
	logger.logPassed('Heading for all categories are Matching the Expected in the Home Page')
} else {
    logger.logFailed('Heading for all categories are not Matching the Expected in the Home Page')
}

//Browse by Category Verification
List<WebElement> cat = driver.findElements(By.xpath('//h2[contains(@data-cy,\'browse-by-category\')]/following-sibling::section//span[contains(@class,\'Suggestive-label\')]'))

String categoryExp = ('Sedans, SUVs, Crossovers, Hybrid/Electric, Sports, Luxury,' + ' Trucks, Vans/Minivans, Hatchbacks, Coupes, Wagons, ') + 
'Convertibles, Compacts, CPO, '

String categoryAct = ''

for (WebElement c : cat) {
    categoryAct = ((categoryAct + c.getText().trim()) + ', ')
}

if (categoryExp.equals(categoryAct)) {
    logger.logPassed('Category for vehicles are Matching the Expected in the Home Page' + categoryAct)
} else {
    logger.logFailed('Category for vehicles are not Matching the Expected in the Home Page')
}

// All Sections, if 5 Cars are displayed or not
List<WebElement> bestCars = driver.findElements(By.xpath('//*[contains(text(),\'Best Cars under\')]/following-sibling::div//a'))

int bestCar = bestCars.size()

List<WebElement> suvs = driver.findElements(By.xpath('//*[contains(text(),\'Best Full Size SUVs\')]/following-sibling::div//a'))

int bestSuv = suvs.size()

List<WebElement> pick = driver.findElements(By.xpath('//*[contains(text(),\'Best Full Size Pick\')]/following-sibling::div//a'))

int bestPickUp = pick.size()

if (((bestCar == 5) && (bestSuv == 5)) && (bestPickUp == 5)) {
    logger.logPassed('All the Sections have 5 Cars each present in the Home page')
} else {
    logger.logFailed('All the Sections deosn\'t have 5 Cars each present in the Home page')
}

//verifying Popular Makes category in Home Page
List<WebElement> mak = driver.findElements(By.xpath('//*[contains(@class,\'VhList\')]//a'))

String makeExp = 'Acura, Aston Martin, Audi, Bentley, BMW, Buick, Cadillac, Chevrolet, Chrysler, ' + 'Dodge, Ferrari, FIAT, Ford, Genesis, GMC, Honda, Hyundai, INFINITI, Isuzu, Jaguar, ' + 
'Jeep, Kia, Lamborghini, Land Rover, Lexus, Lincoln, Maserati, Mazda, McLaren, Mercedes-Benz, ' + 'MINI, Mitsubishi, Nissan, Porsche, Ram, Rolls-Royce, Scion, Subaru, Tesla, Toyota, Volkswagen, Volvo, '

String makeAct = ''

for (WebElement m : mak) {
    makeAct = ((makeAct + m.getText().trim()) + ', ')
}

if (makeExp.equals(makeAct)) {
    logger.logPassed('Popular Makes for vehicles are Matching the Expected in the Home Page' + makeExp)
} else {
    logger.logFailed('Popular Makes for vehicles are not Matching the Expected in the Home Page.')
}

WebUI.closeBrowser()

