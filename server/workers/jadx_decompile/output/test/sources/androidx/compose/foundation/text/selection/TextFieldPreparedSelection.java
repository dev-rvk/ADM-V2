package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextPreparedSelection.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ)\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0019\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0015¢\u0006\u0002\b\u0016J\u0006\u0010\u0017\u001a\u00020\u0000J\u0006\u0010\u0018\u001a\u00020\u0000J\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldPreparedSelection;", "Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "currentValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "layoutResultProxy", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/TextLayoutResultProxy;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;)V", "getCurrentValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "getLayoutResultProxy", "()Landroidx/compose/foundation/text/TextLayoutResultProxy;", "value", "getValue", "deleteIfSelectedOr", "", "Landroidx/compose/ui/text/input/EditCommand;", "or", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "moveCursorDownByPage", "moveCursorUpByPage", "jumpByPagesOffset", "", "pagesAmount", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldPreparedSelection extends BaseTextPreparedSelection<TextFieldPreparedSelection> {
    private final TextFieldValue currentValue;
    private final TextLayoutResultProxy layoutResultProxy;

    public /* synthetic */ TextFieldPreparedSelection(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResultProxy textLayoutResultProxy, TextPreparedSelectionState textPreparedSelectionState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldValue, (i & 2) != 0 ? OffsetMapping.INSTANCE.getIdentity() : offsetMapping, textLayoutResultProxy, (i & 8) != 0 ? new TextPreparedSelectionState() : textPreparedSelectionState);
    }

    public final TextFieldValue getCurrentValue() {
        return this.currentValue;
    }

    public final TextLayoutResultProxy getLayoutResultProxy() {
        return this.layoutResultProxy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldPreparedSelection(TextFieldValue currentValue, OffsetMapping offsetMapping, TextLayoutResultProxy layoutResultProxy, TextPreparedSelectionState state) {
        super(currentValue.getText(), currentValue.getSelection(), layoutResultProxy != null ? layoutResultProxy.getValue() : null, offsetMapping, state, null);
        Intrinsics.checkNotNullParameter(currentValue, "currentValue");
        Intrinsics.checkNotNullParameter(offsetMapping, "offsetMapping");
        Intrinsics.checkNotNullParameter(state, "state");
        this.currentValue = currentValue;
        this.layoutResultProxy = layoutResultProxy;
    }

    public final TextFieldValue getValue() {
        return TextFieldValue.m4939copy3r_uNRQ$default(this.currentValue, getAnnotatedString(), getSelection(), (TextRange) null, 4, (Object) null);
    }

    public final List<EditCommand> deleteIfSelectedOr(Function1<? super TextFieldPreparedSelection, ? extends EditCommand> or) {
        Intrinsics.checkNotNullParameter(or, "or");
        if (TextRange.m4720getCollapsedimpl(getSelection())) {
            EditCommand it = or.invoke(this);
            if (it != null) {
                return CollectionsKt.listOf(it);
            }
            return null;
        }
        return CollectionsKt.listOf((Object[]) new EditCommand[]{new CommitTextCommand("", 0), new SetSelectionCommand(TextRange.m4724getMinimpl(getSelection()), TextRange.m4724getMinimpl(getSelection()))});
    }

    public final TextFieldPreparedSelection moveCursorUpByPage() {
        TextFieldPreparedSelection $this$moveCursorUpByPage_u24lambda_u242;
        TextLayoutResultProxy textLayoutResultProxy;
        TextFieldPreparedSelection this_$iv = this;
        if ((this_$iv.getText$foundation_release().length() > 0) && (textLayoutResultProxy = ($this$moveCursorUpByPage_u24lambda_u242 = this).layoutResultProxy) != null) {
            int it = $this$moveCursorUpByPage_u24lambda_u242.jumpByPagesOffset(textLayoutResultProxy, -1);
            $this$moveCursorUpByPage_u24lambda_u242.setCursor(it);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        TextFieldPreparedSelection this_$iv2 = this;
        return this_$iv2;
    }

    public final TextFieldPreparedSelection moveCursorDownByPage() {
        TextFieldPreparedSelection $this$moveCursorDownByPage_u24lambda_u244;
        TextLayoutResultProxy textLayoutResultProxy;
        TextFieldPreparedSelection this_$iv = this;
        if ((this_$iv.getText$foundation_release().length() > 0) && (textLayoutResultProxy = ($this$moveCursorDownByPage_u24lambda_u244 = this).layoutResultProxy) != null) {
            int it = $this$moveCursorDownByPage_u24lambda_u244.jumpByPagesOffset(textLayoutResultProxy, 1);
            $this$moveCursorDownByPage_u24lambda_u244.setCursor(it);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        TextFieldPreparedSelection this_$iv2 = this;
        return this_$iv2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
    
        if (r3 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int jumpByPagesOffset(androidx.compose.foundation.text.TextLayoutResultProxy r10, int r11) {
        /*
            r9 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r10.getInnerTextFieldCoordinates()
            if (r0 == 0) goto L16
            r1 = 0
            androidx.compose.ui.layout.LayoutCoordinates r2 = r10.getDecorationBoxCoordinates()
            r3 = 0
            if (r2 == 0) goto L14
            r4 = 0
            r5 = 2
            androidx.compose.ui.geometry.Rect r3 = androidx.compose.ui.layout.LayoutCoordinates.localBoundingBoxOf$default(r2, r0, r4, r5, r3)
        L14:
            if (r3 != 0) goto L1c
        L16:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.INSTANCE
            androidx.compose.ui.geometry.Rect r3 = r0.getZero()
        L1c:
            r0 = r3
            androidx.compose.ui.text.input.OffsetMapping r1 = r9.getOffsetMapping()
            androidx.compose.ui.text.input.TextFieldValue r2 = r9.currentValue
            long r2 = r2.getSelection()
            int r2 = androidx.compose.ui.text.TextRange.m4721getEndimpl(r2)
            int r1 = r1.originalToTransformed(r2)
            androidx.compose.ui.text.TextLayoutResult r2 = r10.getValue()
            androidx.compose.ui.geometry.Rect r2 = r2.getCursorRect(r1)
            float r3 = r2.getLeft()
            float r4 = r2.getTop()
            long r5 = r0.m2743getSizeNHjbRc()
            float r5 = androidx.compose.ui.geometry.Size.m2776getHeightimpl(r5)
            float r6 = (float) r11
            float r5 = r5 * r6
            float r4 = r4 + r5
            androidx.compose.ui.text.input.OffsetMapping r5 = r9.getOffsetMapping()
            androidx.compose.ui.text.TextLayoutResult r6 = r10.getValue()
            long r7 = androidx.compose.ui.geometry.OffsetKt.Offset(r3, r4)
            int r6 = r6.m4698getOffsetForPositionk4lQ0M(r7)
            int r5 = r5.transformedToOriginal(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldPreparedSelection.jumpByPagesOffset(androidx.compose.foundation.text.TextLayoutResultProxy, int):int");
    }
}
