# JavaSeleniumAutomation

#have Maven ( Ex:3.9.1) and Java ( 15 or above ) installed

#checkout the project to local
git checkout https://github.com/pdhulipudi/JavaSeleniumAutomation.git
#Use an IDE ( Eclipse or IntelliJ) and open this maven project 

# Wait until all the dependencies are downloaded
# perform (mvn clean install -U ) wait until build is successful

#Run testng.xml 
#Verify allure-results files

--------------

Process to open allure results in local
-----------------------------------

#Install scoop (Windows OS) if not already installed
#Open PowerShell and run below command (https://www.makeuseof.com/windows-install-scoop/) 
iwr -useb get.scoop.sh | iex 
#wait for scoop successful installation

#Install Allure through Scoop
#Open Comandline and run below command
scoop install allure
#run allure command on command prompt to make sure allure is installed

#to open allure results locally, navigate to allure-results folder and open command prompt
allure serve "Path"
#Should be able to see ALlure results opened in browser
