package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.OffsetMapping;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ValidatingOffsetMapping.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/text/ValidatingOffsetMapping;", "Landroidx/compose/ui/text/input/OffsetMapping;", "delegate", "originalLength", "", "transformedLength", "(Landroidx/compose/ui/text/input/OffsetMapping;II)V", "originalToTransformed", "offset", "transformedToOriginal", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class ValidatingOffsetMapping implements OffsetMapping {
    private final OffsetMapping delegate;
    private final int originalLength;
    private final int transformedLength;

    public ValidatingOffsetMapping(OffsetMapping delegate, int originalLength, int transformedLength) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.originalLength = originalLength;
        this.transformedLength = transformedLength;
    }

    @Override // androidx.compose.ui.text.input.OffsetMapping
    public int originalToTransformed(int offset) {
        int transformedOffset = this.delegate.originalToTransformed(offset);
        boolean z = false;
        if (transformedOffset >= 0 && transformedOffset <= this.transformedLength) {
            z = true;
        }
        if (z) {
            return transformedOffset;
        }
        throw new IllegalStateException(("OffsetMapping.originalToTransformed returned invalid mapping: " + offset + " -> " + transformedOffset + " is not in range of transformed text [0, " + this.transformedLength + ']').toString());
    }

    @Override // androidx.compose.ui.text.input.OffsetMapping
    public int transformedToOriginal(int offset) {
        int originalOffset = this.delegate.transformedToOriginal(offset);
        boolean z = false;
        if (originalOffset >= 0 && originalOffset <= this.originalLength) {
            z = true;
        }
        if (z) {
            return originalOffset;
        }
        throw new IllegalStateException(("OffsetMapping.transformedToOriginal returned invalid mapping: " + offset + " -> " + originalOffset + " is not in range of original text [0, " + this.originalLength + ']').toString());
    }
}
