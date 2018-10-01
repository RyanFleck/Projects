from selenium import webdriver
from selenium.webdriver.firefox.firefox_binary import FirefoxBinary


FF_BINARY_PATH = "py/webdrivers/geckodriver.exe"
CHROME_BINARY_PATH = "py/webdrivers/chromedriver.exe"

def FF_DRIVER():
    return webdriver.Firefox(executable_path=FF_BINARY_PATH)

def CHROME_DRIVER():
    return webdriver.Chrome(executable_path=CHROME_BINARY_PATH)

driver = FF_DRIVER()

