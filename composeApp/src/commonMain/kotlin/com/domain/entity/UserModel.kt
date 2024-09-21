import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserModel(
    @SerialName("age")
    val age: Int,
    @SerialName("birthDate")
    val birthDate: String,
    @SerialName("email")
    val email: String,
    @SerialName("firstName")
    val firstName: String,
    @SerialName("gender")
    val gender: String,
    @SerialName("image")
    val image: String,
    @SerialName("lastName")
    val lastName: String,
    @SerialName("maidenName")
    val maidenName: String,
    @SerialName("phone")
    val phone: String,
)