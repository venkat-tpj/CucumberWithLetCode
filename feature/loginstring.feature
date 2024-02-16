Feature: BookCart Application Test Login String

Background:
And User Clicks Account Login Icon
#	Given User Navigate BookCart Application String  //This step is moved to MyHooks
 	
 							 	Scenario: Login should be successful
						 			And User enter username as "pwood"
							    And User enter password as "Cucumber123"
							    When User click on login icon
							    Then Login should be positive

						  	Scenario: Login should not be successful
							    And User enter username as "pfern"
							    And User enter password as "Cucumber123"
							    When User click on login icon
							    But Login should be negative