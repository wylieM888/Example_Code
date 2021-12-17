import pdfkit
from selenium import webdriver
import selenium
from time import sleep
import autoit
from autoit.autoit import properties
from selenium.webdriver.common.keys import Keys
import json
import getpass

from xhtml2pdf import pisa
from io import StringIO
from django.http import HttpResponse
from django.template.loader import get_template
from django.template import Context

from weasyprint import HTML

# driver = webdriver.Chrome("C:\\Users\\guest1\\Desktop\\Internship\\chromedriver\\chromedriver")
# driver.get("http://nagios.stategdi.cloud/")


chrome_options = webdriver.ChromeOptions()
settings = {
        "plugins.plugins_list": [{"enabled": False, "name": "Chrome PDF Viewer"}],
       "recentDestinations": [{
            "id": "Save as PDF",
            "origin": "local",
            "account": "",
        }],
        "selectedDestinationId": "Save as PDF",
        "version": 2
    }
prefs = {'printing.print_preview_sticky_settings.appState': json.dumps(settings), 'savefile.default_directory': 'C:\\Users\\Desktop'}
chrome_options.add_experimental_option('prefs', prefs)
chrome_options.add_argument('--kiosk-printing')
driver = webdriver.Chrome("C:\\Users\\guest1\\Desktop\\Internship\\chromedriver\\chromedriver")
username = getpass.getuser()

if __name__ == "__main__":
    # Requires unpackaging of wkhtmltopdf. Paste the location of the unzipped exe below.
    target_path = "C:\\Users\\" + username + "\\Desktop\\NagiosData.pdf"
    target_url = "https://nagios.stategdi.cloud/nagios/cgi-bin/status.cgi?hostgroup=all&style=detail"
    aIFileSave = "C:\\Users\\guest1\\Desktop\\FileSave.exe"
    driver.get(target_url)
    test = driver.switch_to_window
    autoit.send("username")
    autoit.send("{TAB}")
    autoit.send("password")
    autoit.send("{TAB}")
    autoit.send("{ENTER}")
    driver.execute_script('window.print();')
    sleep(2)
    HTML(target_url).write_pdf(target_path)
    # config = pdfkit.configuration(wkhtmltopdf=path_wkhtmltopdf)
    # sleep(3)
    # pdfkit.from_url(target_url, target_path, configuration=config)