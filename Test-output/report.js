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
formatter.step({
  "name": "User launches chrome browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.bonsai.project.BonsaiStepDefinitions.user_launches_chrome_browser()"
});
formatter.result({
  "error_message": "org.openqa.selenium.SessionNotCreatedException: session not created\nfrom chrome not reachable\n  (Session info: chrome\u003d80.0.3987.149)\nBuild info: version: \u00273.141.0\u0027, revision: \u00272ecb7d9a\u0027, time: \u00272018-10-31T20:09:30\u0027\nSystem info: host: \u0027OKTAY-XPS\u0027, ip: \u0027169.254.222.88\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: driver.version: ChromeDriver\nremote stacktrace: Backtrace:\n\tOrdinal0 [0x01020C83+1707139]\n\tOrdinal0 [0x00F868F1+1075441]\n\tOrdinal0 [0x00EFDE72+515698]\n\tOrdinal0 [0x00EF7CA8+490664]\n\tOrdinal0 [0x00EF839B+492443]\n\tOrdinal0 [0x00EF92F5+496373]\n\tOrdinal0 [0x00EF4F05+478981]\n\tOrdinal0 [0x00EFECA0+519328]\n\tOrdinal0 [0x00EACA67+182887]\n\tOrdinal0 [0x00EABDDD+179677]\n\tOrdinal0 [0x00EA9D4B+171339]\n\tOrdinal0 [0x00E91D4A+73034]\n\tOrdinal0 [0x00E92DC0+77248]\n\tOrdinal0 [0x00E92D59+77145]\n\tOrdinal0 [0x00F9BB67+1162087]\n\tGetHandleVerifier [0x010BA966+508998]\n\tGetHandleVerifier [0x010BA6A4+508292]\n\tGetHandleVerifier [0x010CF7B7+594583]\n\tGetHandleVerifier [0x010BB1D6+511158]\n\tOrdinal0 [0x00F9402C+1130540]\n\tOrdinal0 [0x00F9D4CB+1168587]\n\tOrdinal0 [0x00F9D633+1168947]\n\tOrdinal0 [0x00FB5B35+1268533]\n\tBaseThreadInitThunk [0x77106359+25]\n\tRtlGetAppContainerNamedObjectPath [0x77E47B74+228]\n\tRtlGetAppContainerNamedObjectPath [0x77E47B44+180]\n\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.W3CHandshakeResponse.lambda$errorHandler$0(W3CHandshakeResponse.java:62)\r\n\tat org.openqa.selenium.remote.HandshakeResponse.lambda$getResponseFunction$0(HandshakeResponse.java:30)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.lambda$createSession$0(ProtocolHandshake.java:123)\r\n\tat java.util.stream.ReferencePipeline$3$1.accept(Unknown Source)\r\n\tat java.util.Spliterators$ArraySpliterator.tryAdvance(Unknown Source)\r\n\tat java.util.stream.ReferencePipeline.forEachWithCancel(Unknown Source)\r\n\tat java.util.stream.AbstractPipeline.copyIntoWithCancel(Unknown Source)\r\n\tat java.util.stream.AbstractPipeline.copyInto(Unknown Source)\r\n\tat java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)\r\n\tat java.util.stream.FindOps$FindOp.evaluateSequential(Unknown Source)\r\n\tat java.util.stream.AbstractPipeline.evaluate(Unknown Source)\r\n\tat java.util.stream.ReferencePipeline.findFirst(Unknown Source)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:125)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:74)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:136)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.startSession(RemoteWebDriver.java:213)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.\u003cinit\u003e(RemoteWebDriver.java:131)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:181)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:168)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:123)\r\n\tat com.bonsaiui.utilities.BonsaiDrivers.chooseDriver(BonsaiDrivers.java:35)\r\n\tat com.bonsai.project.BonsaiStepDefinitions.user_launches_chrome_browser(BonsaiStepDefinitions.java:20)\r\n\tat ✽.User launches chrome browser(file:///C:/Users/oktay/eclipse-workspace/BonsaiUIProjectOktay/src/test/resources/Features/bonsaiutils.feature:5)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "User opens Bonsai URL",
  "keyword": "When "
});
formatter.match({
  "location": "com.bonsai.project.BonsaiStepDefinitions.user_opens_Bonsai_URL()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User enters valid login credentials",
  "keyword": "And "
});
formatter.match({
  "location": "com.bonsai.project.BonsaiStepDefinitions.user_enters_valid_login_credentials()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User should see Bonsai Dashboard",
  "keyword": "And "
});
formatter.match({
  "location": "com.bonsai.project.BonsaiStepDefinitions.user_should_see_Bonsai_Dashboard()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User clicks Projects tab",
  "keyword": "When "
});
formatter.match({
  "location": "com.bonsai.project.BonsaiStepDefinitions.user_clicks_Projects_tab()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User clicks NEW Project tab",
  "keyword": "When "
});
formatter.match({
  "location": "com.bonsai.project.BonsaiStepDefinitions.user_clicks_NEW_Project_tab()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User enters new project information and clicks Create Project",
  "rows": [
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "com.bonsai.project.BonsaiStepDefinitions.user_enters_new_project_information_and_clicks_Create_Project(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User should see newly added Project on the Project List",
  "keyword": "And "
});
formatter.match({
  "location": "com.bonsai.project.BonsaiStepDefinitions.user_should_see_newly_added_Project_on_the_Project_List()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User will close browser",
  "keyword": "Then "
});
formatter.match({
  "location": "com.bonsai.project.BonsaiStepDefinitions.user_will_close_browser()"
});
formatter.result({
  "status": "skipped"
});
});