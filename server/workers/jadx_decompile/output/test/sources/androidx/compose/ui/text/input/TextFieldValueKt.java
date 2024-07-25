package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldValue.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"getSelectedText", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/input/TextFieldValue;", "getTextAfterSelection", "maxChars", "", "getTextBeforeSelection", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldValueKt {
    public static final AnnotatedString getTextBeforeSelection(TextFieldValue $this$getTextBeforeSelection, int maxChars) {
        Intrinsics.checkNotNullParameter($this$getTextBeforeSelection, "<this>");
        return $this$getTextBeforeSelection.getText().subSequence(Math.max(0, TextRange.m4724getMinimpl($this$getTextBeforeSelection.getSelection()) - maxChars), TextRange.m4724getMinimpl($this$getTextBeforeSelection.getSelection()));
    }

    public static final AnnotatedString getTextAfterSelection(TextFieldValue $this$getTextAfterSelection, int maxChars) {
        Intrinsics.checkNotNullParameter($this$getTextAfterSelection, "<this>");
        return $this$getTextAfterSelection.getText().subSequence(TextRange.m4723getMaximpl($this$getTextAfterSelection.getSelection()), Math.min(TextRange.m4723getMaximpl($this$getTextAfterSelection.getSelection()) + maxChars, $this$getTextAfterSelection.getText().length()));
    }

    public static final AnnotatedString getSelectedText(TextFieldValue $this$getSelectedText) {
        Intrinsics.checkNotNullParameter($this$getSelectedText, "<this>");
        return $this$getSelectedText.getText().m4601subSequence5zctL8($this$getSelectedText.getSelection());
    }
}
