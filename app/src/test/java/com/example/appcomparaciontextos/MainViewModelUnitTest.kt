package com.example.appcomparaciontextos

//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.appcomparaciontextos.MainViewModel
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {
    private lateinit var viewModel: MainViewModel
    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    private val dispatcher=StandardTestDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitValid() = runTest {
        val valor1 = viewModel.comparar.value?.texto1
        val valor2 = viewModel.comparar.value?.texto2
        assertEquals("Ingrese primer texto",valor1)
        assertEquals("Ingrese segundo texto",valor2)
    }

    @Test
    fun mainViewModel_TestBoton() = runTest {
        launch {
            viewModel.cargaDatos("A","A")

        }
        advanceUntilIdle()
        val valor1 = viewModel.comparar.value?.texto1
        val valor2 = viewModel.comparar.value?.texto2
        assertEquals("A",valor1)
        assertEquals("A",valor2)
    }
}