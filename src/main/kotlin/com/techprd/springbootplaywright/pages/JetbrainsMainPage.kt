package com.techprd.springbootplaywright.pages

import com.microsoft.playwright.Browser
import com.microsoft.playwright.Locator
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import org.springframework.stereotype.Component

// page_url = https://www.jetbrains.com/
@Component
class JetbrainsMainPage(private val currentPage: Page) {

    val seeDeveloperToolsButton: Locator = currentPage.getByText("Developer Tools")
    val findYourToolsButton: Locator = currentPage.locator("[data-test='main-menu'] [data-test='suggestion-action']")
    val toolsMenu: Locator = currentPage.locator("//div[@data-test='main-menu-item' and @data-test-marker = 'Developer Tools']")
    val searchButton: Locator = currentPage.locator("[data-test='site-header-search-action']")

    fun open(): Page {
        currentPage.navigate("https://www.jetbrains.com/")
        return currentPage
    }
}
