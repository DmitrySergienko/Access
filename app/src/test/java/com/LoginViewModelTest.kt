//package com
//
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import com.access.domain.usecases.AccessRepoUseCase
//import com.access.presentation.login.LoginViewModel
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import org.junit.Assert
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import org.mockito.Mock
//import org.mockito.Mockito.`when`
//import org.mockito.MockitoAnnotations
//import androidx.lifecycle.Observer
//import com.access.domain.entity.LoginRequest
//import com.access.domain.entity.LoginResponse
//import io.reactivex.rxjava3.core.Observer
//import retrofit2.Response
//
//
//@ExperimentalCoroutinesApi
//class LoginViewModelTest {
//
//    @get:Rule
//    var instantExecutorRule = InstantTaskExecutorRule()
//
//    @get:Rule
//    var testCoroutineRule = TestCoroutineRule()
//
//    private lateinit var searchViewModel: LoginViewModel
//
//    @Mock
//    private lateinit var repository: AccessRepoUseCase
//
//    @Before
//    fun setUp() {
//        MockitoAnnotations.initMocks(this)
//        searchViewModel = LoginViewModel(repository)
//    }
//
//    @Test
//    fun coroutines_TestReturnValueIsNotNull() {
//        testCoroutineRule.runBlockingTest {
//            val observer = Observer<LoginResponse> {}
//            val liveData = searchViewModel.loginLiveData
//
//            `when`(repository.pushPostLog(LoginRequest("1", "1"))).thenReturn(
//                LoginResponse(
//                    "dem@gmail.com",
//                    "Demetri",
//                    "xyz",
//                    "xyz",
//                    "8972834",
//                    "Demetri"
//                )
//            )
//
//            try {
//                liveData.observeForever(observer)
//                searchViewModel.pushLogin(LoginRequest)
//                Assert.assertNotNull(liveData.value)
//            } finally {
//                liveData.removeObserver(observer)
//            }
//        }
//    }
//
//
//}