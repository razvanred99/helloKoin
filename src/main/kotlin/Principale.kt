import org.koin.dsl.module.applicationContext
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject

val hello = applicationContext {
    bean("you") { HelloModel(getProperty(WHO)) }
    bean("re") { HelloModel() }
    bean { HelloModuleImpl(get("you")) as HelloModule }
}

private const val WHO = "WHO"

fun main(vararg args: String) {
    startKoin(listOf(hello), extraProperties = mapOf(WHO to "Koin :)"))
    Principale()
}

class Principale : KoinComponent {

    private val helloModule by inject<HelloModule>()

    init {
        println(helloModule.hello())
    }

}