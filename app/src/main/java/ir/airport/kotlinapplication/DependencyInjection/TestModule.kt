package ir.airport.kotlinapplication.DependencyInjection

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

//sakht module baraye sakht instance az Class Retroft(chon besoorat mostaghim ghabel dastres nist)
@Module
class TestModule {
    //baraye ijad darkhast be Dagger baraye sakht instance az Class Retrofit
    @Provides
    fun retrofitProvider(): Retrofit = Retrofit.Builder().build()

}