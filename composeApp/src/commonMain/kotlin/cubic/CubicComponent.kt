package cubic

import com.arkivanov.decompose.ComponentContext

interface CubicComponent

class DefaultCubicComponent(
    componentContext: ComponentContext,
): CubicComponent, ComponentContext by componentContext {
    
}

