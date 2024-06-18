package androidx.compose.ui.text;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiParagraph.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u0006\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a-\u0010\u000b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00010\u000eH\u0082\b¨\u0006\u000f"}, d2 = {"findParagraphByIndex", "", "paragraphInfoList", "", "Landroidx/compose/ui/text/ParagraphInfo;", "index", "findParagraphByLineIndex", "lineIndex", "findParagraphByY", "y", "", "fastBinarySearch", "T", "comparison", "Lkotlin/Function1;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MultiParagraphKt {
    public static final int findParagraphByIndex(List<ParagraphInfo> paragraphInfoList, int index) {
        int i;
        Intrinsics.checkNotNullParameter(paragraphInfoList, "paragraphInfoList");
        int low$iv = 0;
        int high$iv = paragraphInfoList.size() - 1;
        while (low$iv <= high$iv) {
            int mid$iv = (low$iv + high$iv) >>> 1;
            Object midVal$iv = paragraphInfoList.get(mid$iv);
            ParagraphInfo paragraphInfo = (ParagraphInfo) midVal$iv;
            if (paragraphInfo.getStartIndex() > index) {
                i = 1;
            } else {
                i = paragraphInfo.getEndIndex() <= index ? -1 : 0;
            }
            int cmp$iv = i;
            if (cmp$iv < 0) {
                low$iv = mid$iv + 1;
            } else {
                if (cmp$iv <= 0) {
                    return mid$iv;
                }
                high$iv = mid$iv - 1;
            }
        }
        return -(low$iv + 1);
    }

    public static final int findParagraphByY(List<ParagraphInfo> paragraphInfoList, float y) {
        int i;
        Intrinsics.checkNotNullParameter(paragraphInfoList, "paragraphInfoList");
        int low$iv = 0;
        int high$iv = paragraphInfoList.size() - 1;
        while (low$iv <= high$iv) {
            int mid$iv = (low$iv + high$iv) >>> 1;
            Object midVal$iv = paragraphInfoList.get(mid$iv);
            ParagraphInfo paragraphInfo = (ParagraphInfo) midVal$iv;
            if (paragraphInfo.getTop() > y) {
                i = 1;
            } else {
                i = paragraphInfo.getBottom() <= y ? -1 : 0;
            }
            int cmp$iv = i;
            if (cmp$iv < 0) {
                low$iv = mid$iv + 1;
            } else {
                if (cmp$iv <= 0) {
                    return mid$iv;
                }
                high$iv = mid$iv - 1;
            }
        }
        return -(low$iv + 1);
    }

    public static final int findParagraphByLineIndex(List<ParagraphInfo> paragraphInfoList, int lineIndex) {
        int i;
        Intrinsics.checkNotNullParameter(paragraphInfoList, "paragraphInfoList");
        int low$iv = 0;
        int high$iv = paragraphInfoList.size() - 1;
        while (low$iv <= high$iv) {
            int mid$iv = (low$iv + high$iv) >>> 1;
            Object midVal$iv = paragraphInfoList.get(mid$iv);
            ParagraphInfo paragraphInfo = (ParagraphInfo) midVal$iv;
            if (paragraphInfo.getStartLineIndex() > lineIndex) {
                i = 1;
            } else {
                i = paragraphInfo.getEndLineIndex() <= lineIndex ? -1 : 0;
            }
            int cmp$iv = i;
            if (cmp$iv < 0) {
                low$iv = mid$iv + 1;
            } else {
                if (cmp$iv <= 0) {
                    return mid$iv;
                }
                high$iv = mid$iv - 1;
            }
        }
        return -(low$iv + 1);
    }

    private static final <T> int fastBinarySearch(List<? extends T> list, Function1<? super T, Integer> function1) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            Object midVal = list.get(mid);
            int cmp = function1.invoke(midVal).intValue();
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }
}
