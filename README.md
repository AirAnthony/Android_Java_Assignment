# Android_Java_Assignment
Calculator that reads input for hours worked and calculates pay with two activities

Your task is to build an Android application that satisfies the following requirements:
• Has two activities: MainActivity that implements the main functionality of the 
application and AboutActivity that shows your full name as per college record and
student id
• The AboutActivity should be available through a menu 
• A back button should appear in the ActionBar of the AboutActivity that takes user back 
to the MainActivity. It should be done through configuration!
• MainActivity should implement the following functionality
o read the following input from the user:
§ number of hours worked
§ hourly rate 
o calculate the pay using the following formula
§ if no of hours is less or equal than 40 then pay=no_of_hours*hourly_rate
§ else, pay=(no_of_hours-40)*hourly_rate*1.5 + 40*hourly_rate
o calculate the tax using the following formula 
§ tax=pay*0.18
o present following data to the user
§ pay
§ overtime pay
§ total pay
§ tax
MARKING SCHEME:
• AboutActivity: 1 point
• Menu implementation: 2 point
• MainActivity:
o Input impelemntation: 2 points
o Calculation: 3 points
o Output implementation: 2 points
