package com.techprd.springbootplaywright.pages

import com.microsoft.playwright.Page
import org.springframework.stereotype.Component

// page_url = https://todomvc.com/examples/typescript-react/#/
@Component
class TodoAppPage(private val currentPage: Page) {


    val h1Todos = currentPage.locator("h1")

    val todoInput = currentPage.locator("input[placeholder='What needs to be done?']")

    val todoList = currentPage.locator(".todo-list")

    val todoFooter = currentPage.locator("footer[class='footer']")

    val todoCount = currentPage.locator("span[class='todo-count']")

    val filters = currentPage.locator("ul[class='filters']")

    val filterAllSelect = currentPage.locator("ul[class='filters'] > li:nth-of-type(1)")

    val filterActiveSelect = currentPage.locator("ul[class='filters'] > li:nth-of-type(2)")

    val filterCompletedBtn = currentPage.locator("ul[class='filters'] > li:nth-of-type(3)")

    fun open(): Page {
        currentPage.navigate("https://todomvc.com/examples/typescript-react/#/")
        return currentPage
    }

    fun addTodoTask(task: String) {
        todoInput.clear()
        todoInput.type(task)
        currentPage.keyboard().press("Enter")
    }

}
