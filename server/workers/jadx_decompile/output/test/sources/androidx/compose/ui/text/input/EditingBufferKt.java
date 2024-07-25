package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: EditingBuffer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", "target", "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m4868updateRangeAfterDeletepWDy79M(long target, long deleted) {
        int targetMin = TextRange.m4724getMinimpl(target);
        int targetMax = TextRange.m4723getMaximpl(target);
        if (TextRange.m4728intersects5zctL8(deleted, target)) {
            if (TextRange.m4716contains5zctL8(deleted, target)) {
                targetMin = TextRange.m4724getMinimpl(deleted);
                targetMax = targetMin;
            } else if (TextRange.m4716contains5zctL8(target, deleted)) {
                targetMax -= TextRange.m4722getLengthimpl(deleted);
            } else if (TextRange.m4717containsimpl(deleted, targetMin)) {
                targetMin = TextRange.m4724getMinimpl(deleted);
                targetMax -= TextRange.m4722getLengthimpl(deleted);
            } else {
                targetMax = TextRange.m4724getMinimpl(deleted);
            }
        } else if (targetMax > TextRange.m4724getMinimpl(deleted)) {
            targetMin -= TextRange.m4722getLengthimpl(deleted);
            targetMax -= TextRange.m4722getLengthimpl(deleted);
        }
        return TextRangeKt.TextRange(targetMin, targetMax);
    }
}
