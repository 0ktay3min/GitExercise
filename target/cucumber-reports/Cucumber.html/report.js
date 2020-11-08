$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/bonsaiutils.feature");
formatter.feature({
  "name": "Bonsai Utils Project",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@wip1"
    }
  ]
});
formatter.scenario({
  "name": "Bonsai Utils",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip1"
    }
  ]
});
formatter.before({
  "error_message": "java.lang.NullPointerException\r\n\tat com.bonsaiui.utilities.BonsaiUtils.endExtentReport(BonsaiUtils.java:95)\r\n\tat com.bonsaiui.stepdefinitions.HelloBonsaiHookClass.setupBonsaiAppication(HelloBonsaiHookClass.java:26)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "User launches chrome browser",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User opens Bonsai URL",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User enters valid login credentials",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User should see Bonsai Dashboard",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User clicks Projects tab",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User clicks NEW Project tab",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User enters new project information and clicks Create Project",
  "rows": [
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User should see newly added Project on the Project List",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User will close browser",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\r\n\tat com.bonsaiui.utilities.BonsaiUtils.endExtentReport(BonsaiUtils.java:95)\r\n\tat com.bonsaiui.stepdefinitions.HelloBonsaiHookClass.tearDownBonsaiApplication(HelloBonsaiHookClass.java:35)\r\n",
  "status": "failed"
});
});