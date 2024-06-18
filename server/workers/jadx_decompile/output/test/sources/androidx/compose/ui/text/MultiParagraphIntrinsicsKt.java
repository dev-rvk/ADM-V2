package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: MultiParagraphIntrinsics.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"getLocalPlaceholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "start", "", "end", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MultiParagraphIntrinsicsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final List<AnnotatedString.Range<Placeholder>> getLocalPlaceholders(List<AnnotatedString.Range<Placeholder>> list, int start, int end) {
        int i = end;
        List target$iv = new ArrayList(list.size());
        int size = list.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            AnnotatedString.Range range = list.get(index$iv$iv);
            AnnotatedString.Range it = range;
            if (AnnotatedStringKt.intersect(start, i, it.getStart(), it.getEnd())) {
                target$iv.add(range);
            }
        }
        List $this$fastMap$iv = target$iv;
        int $i$f$fastMap = 0;
        ArrayList target$iv2 = new ArrayList($this$fastMap$iv.size());
        int index$iv$iv2 = 0;
        int size2 = $this$fastMap$iv.size();
        while (index$iv$iv2 < size2) {
            Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv2);
            ArrayList arrayList = target$iv2;
            AnnotatedString.Range it2 = (AnnotatedString.Range) item$iv$iv;
            if (!(start <= it2.getStart() && it2.getEnd() <= i)) {
                throw new IllegalArgumentException("placeholder can not overlap with paragraph.".toString());
            }
            Object item = it2.getItem();
            List $this$fastMap$iv2 = $this$fastMap$iv;
            int start2 = it2.getStart() - start;
            int $i$f$fastMap2 = $i$f$fastMap;
            int $i$f$fastMap3 = it2.getEnd() - start;
            arrayList.add(new AnnotatedString.Range(item, start2, $i$f$fastMap3));
            index$iv$iv2++;
            i = end;
            $this$fastMap$iv = $this$fastMap$iv2;
            $i$f$fastMap = $i$f$fastMap2;
        }
        return target$iv2;
    }
}
