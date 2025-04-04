Feature: User Login
	Scenario: Successful Login
		Given the user is on the nopcommerce login page
		When the user enters valid credentials(username:"test123@gmail.com", password :"test@123")
		And the user clicks on the login button
		Then the user should be redirected to the my account page
		And the user shoudl see a welcome message