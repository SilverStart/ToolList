import Foundation

class AppDelegate: NSObject, UIApplicationDelegate {
    let component: RootComponent = ListComponent(
        componentContext: DefaultComponentContext(lifecycle: ApplicationLifecycle())
    )
}