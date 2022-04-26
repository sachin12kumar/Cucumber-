
@release1
Feature: Login functionality 

Background:
Given user should navigate url "http://localhost:100/"


@valid @sprint @regression @sanity
Scenario: Valid Login 
Then login page should be appear
When user enters valid userid and valid password
And click on login button
Then user should able to navigate home page
And can see logout link appear on top right corner


#@only 
@invalid
Scenario Outline: Invalid Login 
Then login page should be appear
When user enters Invalid userid = "<userid>" and Invalid password = "<password>"
And click on login button
#Then user should able to navigate home page
#And can see logout link appear on top right corner

Examples:
|userid|password|
|ad123 |pwd1    |
|ad124 |pwd2    |
|ad125 |pwd3    |

@invalid2
Scenario Outline: Invalid Login 
Then login page should be appear
When user enters Invalid userid = "<userid>" and Invalid password = "<password>" and click login
|userid|password|
|ad123 |pwd1    |
|ad124 |pwd2    |
|ad125 |pwd3    |

#Then user should able to navigate home page
#And can see logout link appear on top right corner



