Feature: BookCart Website Test

  Background:
  And User Clicks Account Login Icon
  #Given User navigate BookCart Website
  #@prod
  @cleanCart
  Scenario Outline: Add to Cart
    And user login into the application with "<username>" and "<password>"
    And user search for a "<bookname>"
    When user add the book to the cart
    Then the cart badge should get updated

    Examples: 
      | username | password    | bookname        |
      | pwood    | Cucumber123 | Roomies         |
      | pwood    | Cucumber123 | The Simple Wild |
