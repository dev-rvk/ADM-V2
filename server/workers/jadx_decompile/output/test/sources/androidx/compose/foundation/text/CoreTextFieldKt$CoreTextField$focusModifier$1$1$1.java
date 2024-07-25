package androidx.compose.foundation.text;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CoreTextField.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1$1", f = "CoreTextField.kt", i = {}, l = {311}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class CoreTextFieldKt$CoreTextField$focusModifier$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
    final /* synthetic */ TextLayoutResultProxy $layoutResult;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextFieldValue $value;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextFieldState textFieldState, TextLayoutResultProxy textLayoutResultProxy, OffsetMapping offsetMapping, Continuation<? super CoreTextFieldKt$CoreTextField$focusModifier$1$1$1> continuation) {
        super(2, continuation);
        this.$bringIntoViewRequester = bringIntoViewRequester;
        this.$value = textFieldValue;
        this.$state = textFieldState;
        this.$layoutResult = textLayoutResultProxy;
        this.$offsetMapping = offsetMapping;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(this.$bringIntoViewRequester, this.$value, this.$state, this.$layoutResult, this.$offsetMapping, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoreTextFieldKt$CoreTextField$focusModifier$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (CoreTextFieldKt.bringSelectionEndIntoView(this.$bringIntoViewRequester, this.$value, this.$state.getTextDelegate(), this.$layoutResult.getValue(), this.$offsetMapping, this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
