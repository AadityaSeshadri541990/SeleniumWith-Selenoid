$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/01.Counterparty.feature");
formatter.feature({
  "line": 2,
  "name": "Counterparty",
  "description": "",
  "id": "counterparty",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@CPM"
    }
  ]
});
formatter.before({
  "duration": 2614803227,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User Navigates to Login Page of Ilex",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.user_Navigates_to_Login_Page_of_Ilex()"
});
formatter.result({
  "duration": 1633952881,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Create User",
  "description": "",
  "id": "counterparty;create-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@Reg"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "User navigated to My Network homepage",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.user_navigated_to_My_Network_homepage()"
});
formatter.result({
  "duration": 135343,
  "status": "passed"
});
formatter.after({
  "duration": 56960709,
  "status": "passed"
});
});