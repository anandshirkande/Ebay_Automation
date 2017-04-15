Feature: To verify search and sort related functionality


  Scenario Outline: Search for an item and verify search guidance/intelligence

    Given I am on ebay home page
    When I search for "<SearchItem>"
    Then I can see search results for "<SearchItem>"

    Examples:
    |SearchItem|
    |iPhone    |

  @runRegression
  Scenario Outline: Sort searched item list with different sort criterion

    Given I am on ebay home page
    When I search for "<SearchItem>"
    And I sort result list based on "<SortCriterion>"
    Then Search result list is sorted on "<SortCriterion>"

    Examples:
    |SearchItem|SortCriterion|
    |iPhone    |Highest price|
