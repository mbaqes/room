package ly.umbrella.roomapplications.core.basemodols

abstract class BaseModel <M,E>{
    abstract fun converToEntity():E
}