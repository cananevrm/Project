Feature: Rate certain products
  Agile Story: As a user, I should be able to leave my feedback so that I rate certain products


  @UI @S1
  Scenario: Leave feedback for certain products
    When Search for iphones and select a random product
    And Hit değerlendirmeler and Rank according to En Yeni Değerlendirme give thumbsUp
    Then Verify success message as "Teşekkür Ederiz."
