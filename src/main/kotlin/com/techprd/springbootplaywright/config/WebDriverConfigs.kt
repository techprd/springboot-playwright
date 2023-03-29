package com.techprd.springbootplaywright.config

import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserType.LaunchOptions
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import jakarta.annotation.PreDestroy
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.context.annotation.Scope


@Configuration
class WebDriverConfigs(val appConfigs: AppConfigs) {

    var browser: Browser? = null

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    fun browser(): Browser {
        val playwright = Playwright.create()
        val launchOptions = LaunchOptions().apply {
            timeout = appConfigs.timeout.toDouble()
            headless = appConfigs.headless
        }
        val browser = playwright.chromium().launch(launchOptions)
        this.browser = browser
        return browser
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @DependsOn("browser")
    fun currentPage(): Page {
        return browser!!.newPage()
    }

    @PreDestroy
    fun preDestroy() {
        browser?.close()
    }
}
