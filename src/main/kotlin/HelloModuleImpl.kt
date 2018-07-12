class HelloModuleImpl(private val helloModel:HelloModel):HelloModule{

    override fun hello()="Hello ${helloModel.who}"

}