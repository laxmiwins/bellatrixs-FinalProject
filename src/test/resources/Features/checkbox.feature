Feature: Bellatrix Solutions Multi-Select Checkboxes Testing

  Scenario: Select multiple checkboxes
    Given I am on the Bellatrix Solutions Contact Form page
    When I select the following checkboxes:
      | Option 1 |
      | Option 3 |
    Then the selected checkboxes should be checked

  Scenario: Deselect checkboxes
    Given I am on the Bellatrix Solutions Contact Form page
    When I select the following checkboxes:
      | Option 2 |
      | Option 3 |
    And I deselect the following checkboxes:
      | Option 2 |
    Then the selected checkboxes should be checked
    And the deselected checkboxes should not be checked