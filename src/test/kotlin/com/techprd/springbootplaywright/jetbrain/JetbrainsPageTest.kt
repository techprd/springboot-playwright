package com.techprd.springbootplaywright.jetbrain

import com.microsoft.playwright.Page
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import com.techprd.springbootplaywright.pages.JetbrainsMainPage
import io.kotest.assertions.retry
import io.kotest.core.annotation.Tags
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldBeEqualIgnoringCase
import org.springframework.boot.test.context.SpringBootTest
import kotlin.time.Duration.Companion.seconds

@SpringBootTest
@Tags("Jetbrains")
class JetbrainsPageTest(jetbrainsMainPage: JetbrainsMainPage) : BehaviorSpec() {

    val page: Page = jetbrainsMainPage.open()

    init {

        beforeContainer {
            jetbrainsMainPage.open()
        }

        given("I want to test main page") {

            When("I search for Playwright term") {
                jetbrainsMainPage.searchButton.click()

                page.locator("[data-test='search-input']").type("Playwright")
                page.locator("button[data-test='full-search-button']").click()

                then("search input should exists") {
                    assertThat(page.locator("input[data-test='search-input']")).hasValue("Playwright")
                }
            }

            When("toolsMenu") {
                jetbrainsMainPage.toolsMenu.click()

                assertThat(page.locator("div[data-test='main-submenu']").first()).isVisible()
            }

            When("navigationToAllTools") {
                jetbrainsMainPage.seeDeveloperToolsButton.first().click()

                retry(2, 30.seconds) {
                    jetbrainsMainPage.findYourToolsButton.click()
                }

                assertThat(page.locator("#products-page")).isVisible()

                page.title() shouldBeEqualIgnoringCase "All Developer Tools and Products by JetBrains"

            }
        }
    }

}
