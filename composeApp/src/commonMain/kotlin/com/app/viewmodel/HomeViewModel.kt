import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.data.repository.HomeRepositoryIml
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import com.app.utils.MainState
import com.app.utils.Resource
import com.domain.usecase.HomeUsers


class HomeViewModel(
    private val homeUsers: HomeUsers
) : ViewModel(), KoinComponent {

    private val _listUsers: MutableState<MainState> = mutableStateOf(MainState())
    val listUsers get() = _listUsers

    private val _error: MutableStateFlow<String> = MutableStateFlow("")
    val error: StateFlow<String> get() = _error

    init {
        _listUsers.value = MainState(isLoading = true)
    }

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                when (val products = homeUsers.fetchUsers()) {
                    is Resource.Error -> {
                        _listUsers.value = MainState(error = "Something went wrong")
                    }
                    is Resource.Success -> {
                        products.data?.let {
                            _listUsers.value = MainState(data = it.userModels.toList())
                        }
                    }
                    is Resource.Loading -> {
                        _listUsers.value = MainState(isLoading = true)
                    }
                }
            } catch (e: Exception) {
                _error.value = e.message.toString()
            }
        }
    }
}