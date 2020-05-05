# WebpageAccessibilitySupportAPI

WebpageAccessibilitySupportAPI is a project that supports the Webpage Design Manipulator Extension by handling requests from the Extension.

*Users can make modifications to a webpage, which the user can then save and have the changes be injected into the webpage each time they revisit.
*Users can enable tools that inject general modifications to all the pages they browse 

## Prerequisites
Installed latest Version of Java

## Installing WebpageAccessibilitySupportAPI
An installer has been created to aid install.

## Running the Extension Service API
An Exe has been created that will run the application

## Server Details 
Port Number : 51058

## Return CSS Endpoint
URL: /getInjectionCssRules

Parameters: None

Body: {"userId":<UserID>,"url":<URL>}

Body Example: {"userId":61,"url":"file:///D:/jonny/Documents/University/FinalYearProject/TestWebsite/TestWebsite.html"}

Output: Returns a list of all the CSS rules to inject on the specified URL for the specified User

## Delete Webpage Design Modification
URL: /deleteWebpageModification

Parameters: None

Body: {"userId":<UserID>,"url":<URL>}
  
Body Example: {"userId":61,"url":"file:///D:/jonny/Documents/University/FinalYearProject/TestWebsite/TestWebsite.html"}

Output: Returns true or false depending on if the Injection CSS was deleted or not

## Save Injection 
URL: /saveInjectionCssRules

Parameters: None

Body: {"userId":userId, "url": webpageUrl, "cssRules": cssToSave}

Body Example: {"userId":61, "url": "file:///D:/jonny/Documents/University/FinalYearProject/TestWebsite/TestWebsite.html", "cssRules": ["* { box-sizing: border-box; }","body { font-family: Arial, Helvetica, sans-serif; }","header { background-color: rgb(102, 102, 102);]}

Output: Returns true or false depending on if the Injection CSS was saved or not. 

Additional Details: If the User ID doesnt exist it will be created as a new one

## Font Size Calculation

URL: /fontCalculation

Parameters: currentFontSize: <double> & desiredIncrease: <double>
 
Example URL: http://localhost:51058/fontCalculation?currentFontSize=10&desiredIncreaseParam=5

## Contact
Email: jhughes61@qub.ac.uk

