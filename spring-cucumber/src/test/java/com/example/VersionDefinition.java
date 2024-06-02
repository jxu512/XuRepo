package com.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class VersionDefinition {

    WebDriver driver = null;

    @Before
    public void setup() {
        System.out.println("Setup...");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }
    @Given("^client call version ([a-zA-Z]*)$")
    public void gotoVersion(String type) {
        driver.navigate().to("http://localhost:8080/version?type=" + type);
    }
    @When("client receives status code of 200")
    public void status() {
        //driver.getPageSource();
        // Selenium doesn't support response status, be is alternate way to get
        try {
            HttpURLConnection cont=
                    (HttpURLConnection)new URL("http://localhost:8080/version")
                            .openConnection();
            cont.setRequestMethod("HEAD");
            cont.connect();
            int rs = cont.getResponseCode();
            System.out.println("Http response code: " + rs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Then("^client receives version ([a-zA-Z]*)$")
    public void getVersion(String type) {
        String response = driver.findElement(By.tagName("body")).getText();
        if (validateResponse(type, response)) {
            System.out.println("Test pass: version is " + response);
        } else {
            System.out.println("Test failed: version is " + response);
        }
    }
    @When("client call version2")
    public void gotoVersion2() {
        driver.navigate().to("http://localhost:8080/version2");
    }
    @Then("client receives version2")
    public void getVersion2() {
        String version2 = driver.findElement(By.tagName("pre")).getText();
        try {
            JSONObject json = new JSONObject(version2);
            String version = json.getString("version");
            if (version.equals("1.2")) {
                System.out.println("Test pass: version2 is " + version);
            }
        } catch (JSONException e) {
            System.out.println("Test failed.");
            throw new RuntimeException(e);
        }
    }

    @After
    public void cleanup() {
        driver.quit();
        System.out.println("Cleanup...");
    }
    private boolean validateResponse(String type, String response) {
        if (type == null || type.length() == 0) {
            return response.equals("type not specified") ? true : false;
        }
        if (type.equals("server")) {
            return response.equals("server-1.0") ? true : false;
        } else if (type.equals("component")) {
            return response.equals("component-1.0") ? true : false;
        } else {
            return response.equals("unknown type") ? true : false;
        }
    }

    public static void main(String[] args) {
        VersionDefinition versionDefinition = new VersionDefinition();
        versionDefinition.setup();
        versionDefinition.gotoVersion("server");
        versionDefinition.status();
        versionDefinition.getVersion("server");
        versionDefinition.cleanup();
    }
}
