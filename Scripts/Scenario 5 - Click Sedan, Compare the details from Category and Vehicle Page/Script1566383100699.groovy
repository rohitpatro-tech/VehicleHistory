import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
//import java.awt.geom.Arc2D.Double
import java.text.DecimalFormat as DecimalFormat
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

//WebUI.scrollToElement(findTestObject('Scenario5/SelectSedanByCategory'), 30)
WebUI.click(findTestObject('Scenario5/SelectSedanByCategory'))

String TitleBeforeClicking = WebUI.getText(findTestObject('Scenario5/TitleFirstCar'))

String[] powerCategory = WebUI.getText(findTestObject('Scenario5/powerCategory')).trim().split()

String priceRangeCategory = WebUI.getText(findTestObject('Scenario5/priceRange1')) + WebUI.getText(findTestObject('Scenario5/priceRange2'))

DecimalFormat value = new DecimalFormat('#.#')

String expertRating = String.valueOf(value.format(Double.parseDouble(WebUI.getText(findTestObject('Scenario5/RatingCategory')))))

WebUI.click(findTestObject('Scenario5/ClickfirstCar'))

WebUI.waitForPageLoad(20)

String TitleAfterClicking = WebUI.getText(findTestObject('Scenario5/TitleVehiclePage'))

String priceRangeVehicle = WebUI.getText(findTestObject('Scenario5/priceRangeVehiclePage1')) + WebUI.getText(findTestObject(
        'Scenario5/priceRangeVehiclePage2'))

String[] powerVehicle = WebUI.getText(findTestObject('Scenario5/powerVehicle')).trim().split(" ")

String expertRatingVehicle = String.valueOf(value.format(Double.parseDouble(WebUI.getText(findTestObject('Scenario5/RatingVehicle')))))

if (TitleAfterClicking.contains(TitleBeforeClicking)) {
    logger.logPassed('Title in category Page is matching the title in Vehicle Page')
} else {
    logger.logFailed('Title in category Page is not matching the title in Vehicle Page')
}

println(priceRangeVehicle)

println(priceRangeCategory)

if (priceRangeCategory.equals(priceRangeVehicle)) {
    logger.logPassed('Price in category Page is matching the Price in Vehicle Page')
} else {
    logger.logFailed('Price in category Page is not matching the Price in Vehicle Page')
}

if (powerCategory[0].equals(powerVehicle[3])) {
	logger.logPassed('MPG in category Page is matching the MPG in Vehicle Page')
} else {
	logger.logFailed('MPG in category Page is not matching the MPG in Vehicle Page')
}

if (expertRating.equals(expertRatingVehicle)) {
    logger.logPassed('Expert Rating in category Page is matching the Expert Rating in Vehicle Page')
} else {
    logger.logFailed('Expert Rating in category Page is not matching the Expert Rating in Vehicle Page')
}

WebUI.closeBrowser()

