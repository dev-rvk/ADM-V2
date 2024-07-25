package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringHelpers.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"findParagraphEnd", "", "", "startIndex", "findParagraphStart", "getParagraphBoundary", "Landroidx/compose/ui/text/TextRange;", "index", "(Ljava/lang/CharSequence;I)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class StringHelpersKt {
    public static final int findParagraphStart(CharSequence $this$findParagraphStart, int startIndex) {
        Intrinsics.checkNotNullParameter($this$findParagraphStart, "<this>");
        for (int index = startIndex - 1; index > 0; index--) {
            if ($this$findParagraphStart.charAt(index - 1) == '\n') {
                return index;
            }
        }
        return 0;
    }

    public static final int findParagraphEnd(CharSequence $this$findParagraphEnd, int startIndex) {
        Intrinsics.checkNotNullParameter($this$findParagraphEnd, "<this>");
        int length = $this$findParagraphEnd.length();
        for (int index = startIndex + 1; index < length; index++) {
            if ($this$findParagraphEnd.charAt(index) == '\n') {
                return index;
            }
        }
        int index2 = $this$findParagraphEnd.length();
        return index2;
    }

    public static final long getParagraphBoundary(CharSequence $this$getParagraphBoundary, int index) {
        Intrinsics.checkNotNullParameter($this$getParagraphBoundary, "<this>");
        return TextRangeKt.TextRange(findParagraphStart($this$getParagraphBoundary, index), findParagraphEnd($this$getParagraphBoundary, index));
    }
}
