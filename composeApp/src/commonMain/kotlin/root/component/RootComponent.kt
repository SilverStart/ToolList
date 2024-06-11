package root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.*
import com.arkivanov.decompose.value.Value
import cubic.CubicComponent
import cubic.DefaultCubicComponent
import kotlinx.serialization.Serializable
import list.DefaultListComponent
import list.ListComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    // It's possible to pop multiple screens at a time on iOS
    fun onBackClicked(toIndex: Int)
    
    fun navigate(config: DefaultRootComponent.Config)

    // Defines all possible child components
    sealed class Child {

        data class ListChild(val component: ListComponent) : Child()
        data class CubicChild(val component: CubicComponent) : Child()
    }
}

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()
    override val stack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.List, // The initial child component is List
            handleBackButton = true, // Automatically pop from the stack on back button presses
            childFactory = ::child,
        )

    private fun child(config: Config, componentContext: ComponentContext): RootComponent.Child =
        when (config) {
            Config.List -> RootComponent.Child.ListChild(listComponent(componentContext))
            Config.Cubic -> RootComponent.Child.CubicChild(cubicComponent(componentContext))
        }

    private fun listComponent(componentContext: ComponentContext): ListComponent =
        DefaultListComponent(
            componentContext = componentContext,
        )

    private fun cubicComponent(componentContext: ComponentContext): CubicComponent =
        DefaultCubicComponent(
            componentContext = componentContext,
        )

    override fun onBackClicked(toIndex: Int) {
        navigation.popTo(index = toIndex)
    }
    
    override fun navigate(config: Config) {
        navigation.pushNew(config)
    }

    @Serializable
    sealed interface Config {

        @Serializable
        data object List : Config

        @Serializable
        data object Cubic : Config
    }
}


