package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectionAdjustment.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"ensureAtLeastOneChar", "Landroidx/compose/ui/text/TextRange;", "text", "", "offset", "", "lastOffset", "isStartHandle", "", "previousHandlesCrossed", "(Ljava/lang/String;IIZZ)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SelectionAdjustmentKt {
    public static final long ensureAtLeastOneChar(String text, int offset, int lastOffset, boolean isStartHandle, boolean previousHandlesCrossed) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (lastOffset == 0) {
            return TextRangeKt.TextRange(offset, offset);
        }
        if (offset == 0) {
            return isStartHandle ? TextRangeKt.TextRange(StringHelpers_androidKt.findFollowingBreak(text, 0), 0) : TextRangeKt.TextRange(0, StringHelpers_androidKt.findFollowingBreak(text, 0));
        }
        if (offset == lastOffset) {
            if (isStartHandle) {
                return TextRangeKt.TextRange(StringHelpers_androidKt.findPrecedingBreak(text, lastOffset), lastOffset);
            }
            return TextRangeKt.TextRange(lastOffset, StringHelpers_androidKt.findPrecedingBreak(text, lastOffset));
        }
        if (isStartHandle) {
            if (!previousHandlesCrossed) {
                return TextRangeKt.TextRange(StringHelpers_androidKt.findPrecedingBreak(text, offset), offset);
            }
            return TextRangeKt.TextRange(StringHelpers_androidKt.findFollowingBreak(text, offset), offset);
        }
        if (!previousHandlesCrossed) {
            return TextRangeKt.TextRange(offset, StringHelpers_androidKt.findFollowingBreak(text, offset));
        }
        return TextRangeKt.TextRange(offset, StringHelpers_androidKt.findPrecedingBreak(text, offset));
    }
}
