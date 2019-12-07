package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {
        // Create an active task
        val tasks = emptyList<Task>()

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.completedTasksPercent).isEqualTo(0f)
        assertThat(result.activeTasksPercent).isEqualTo(0f)
    }

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // Create an active task
        val tasks = listOf<Task>(
                Task("title","desc", isCompleted = false)
        )

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.activeTasksPercent).isEqualTo(100f)
        assertThat(result.completedTasksPercent).isEqualTo(0f)
    }


    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {
        // Create an active task
        val tasks = null

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.completedTasksPercent).isEqualTo(0f)
        assertThat(result.activeTasksPercent).isEqualTo(0f)
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
        assertThat(result.completedTasksPercent).isEqualTo(50f)
        assertThat(result.activeTasksPercent).isEqualTo(50f)
    }

    @Test
    fun getActiveAndCompletedStats_twothirds_returnstwothirds() {
        // Create an active task
        val tasks = listOf<Task>(
                Task("title","desc", isCompleted = false),
                Task("title","desc", isCompleted = true),
                Task("title","desc", isCompleted = true)
        )

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
//        assertThat(result.completedTasksPercent).isWithin(1.0e-5f).of(100f * (2f / 3f))
//        assertThat(result.activeTasksPercent).isWithin(1.0e-5f).of(100f * (1f / 3f))
        assertThat(result.completedTasksPercent).isEqualTo(100f * (2f / 3f))
        assertThat(result.activeTasksPercent).isEqualTo(100f * (1f / 3f))

    }
}