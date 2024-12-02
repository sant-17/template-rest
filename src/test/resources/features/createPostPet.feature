Feature: Create Pet

  @Post

  Scenario Outline: Successfully create a Pet

    When I send a request to the endpoint "<endpoint>" with the pet name "<pet>" category "<category>" and status "<status>"
    Then I validate the response code is "<code>"

    Examples:
    | endpoint  | pet | category  | status  | code  |
    | /pet  | Dante | Husky | available | 200 |