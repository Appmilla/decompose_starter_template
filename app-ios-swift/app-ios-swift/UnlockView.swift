import SwiftUI
import shared


struct UnlockView: View {
    private let component: UnlockComponent

    @StateValue
    private var model: UnlockComponentModel

    init(_ component: UnlockComponent) {
        self.component = component
        _model = StateValue(component.model)
    }

    var body: some View {
        VStack {
            Button(action: component.onUpdateGreetingText) {
                Text(model.greetingText)
            }
        }
        .navigationBarTitle("Unlock Screen", displayMode: .inline)
    }
}

struct UnlockView_Previews: PreviewProvider {
    static var previews: some View {
        UnlockView(PreviewUnlockComponent())
    }
}

class PreviewUnlockComponent : UnlockComponent {
    let model: Value<UnlockComponentModel> = mutableValue(
        UnlockComponentModel(greetingText: "Unlock from Decompose!")
    )

    func onUpdateGreetingText() {}
    func onBackClicked() {}
}

