package ly.umbrella.roomapplications.core

sealed class Recourc<T> {
    class Loading<T>:Recourc<T>()
    class Inti<T>:Recourc<T>()
    data class Success <T> (var data:T?):Recourc<T>()
    data class Error<T> (var message:String):Recourc<T>()
}