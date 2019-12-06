package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat


import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // Create an active task
        val tasks = listOf<Task>(
                Task("title","desc", isCompleted = false)
        )

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_fiftyfifty_returns5050() {
        // Create an active task
        val tasks = listOf<Task>(
                Task("title","desc", isCompleted = false),
                Task("title2","desc2", isCompleted = true)
        )

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.completedTasksPercent, `is`(50f))
        assertThat(result.activeTasksPercent, `is`(50f))
    }

//    @Test
//    fun getActiveAndCompletedStats_twothirds_returnstwothirds() {
//        // Create an active task
//        val tasks = listOf<Task>(
//                Task("title","desc", isCompleted = false),
//                Task("title2","desc2", isCompleted = true),
//                Task("title3","desc3", isCompleted = true)
//        )
//
//        // Call your function
//        val result = getActiveAndCompletedStats(tasks)
//
//        // Check the result
//        assertThat(result.completedTasksPercent, closeTo(66.6666, 0.001))
//        assertThat(result.activeTasksPercent, `is`(100f * (1f / 3f)))
//    }

    
}