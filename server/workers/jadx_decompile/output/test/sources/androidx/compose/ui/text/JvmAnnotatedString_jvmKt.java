package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: JvmAnnotatedString.jvm.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u001a,\u0010\b\u001a\u00020\t*\u00020\t2\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nH\u0000¨\u0006\f"}, d2 = {"collectRangeTransitions", "", "ranges", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "target", "Ljava/util/SortedSet;", "", "transform", "Landroidx/compose/ui/text/AnnotatedString;", "Lkotlin/Function3;", "", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class JvmAnnotatedString_jvmKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final AnnotatedString transform(final AnnotatedString $this$transform, final Function3<? super String, ? super Integer, ? super Integer, String> transform) {
        ArrayList newSpanStyles;
        ArrayList newParaStyles;
        ArrayList target$iv;
        Intrinsics.checkNotNullParameter($this$transform, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        TreeSet transitions = SetsKt.sortedSetOf(0, Integer.valueOf($this$transform.getText().length()));
        collectRangeTransitions($this$transform.getSpanStylesOrNull$ui_text_release(), transitions);
        collectRangeTransitions($this$transform.getParagraphStylesOrNull$ui_text_release(), transitions);
        collectRangeTransitions($this$transform.getAnnotations$ui_text_release(), transitions);
        final Ref.ObjectRef resultStr = new Ref.ObjectRef();
        resultStr.element = "";
        final Map offsetMap = MapsKt.mutableMapOf(TuplesKt.to(0, 0));
        CollectionsKt.windowed$default(transitions, 2, 0, false, new Function1<List<? extends Integer>, Integer>() { // from class: androidx.compose.ui.text.JvmAnnotatedString_jvmKt$transform$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r2v3, types: [T, java.lang.String] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Integer invoke2(List<Integer> list) {
                Intrinsics.checkNotNullParameter(list, "<name for destructuring parameter 0>");
                int start = list.get(0).intValue();
                int end = list.get(1).intValue();
                resultStr.element += transform.invoke($this$transform.getText(), Integer.valueOf(start), Integer.valueOf(end));
                return offsetMap.put(Integer.valueOf(end), Integer.valueOf(resultStr.element.length()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(List<? extends Integer> list) {
                return invoke2((List<Integer>) list);
            }
        }, 6, null);
        List $this$fastMap$iv = $this$transform.getSpanStylesOrNull$ui_text_release();
        if ($this$fastMap$iv != null) {
            ArrayList target$iv2 = new ArrayList($this$fastMap$iv.size());
            int index$iv$iv = 0;
            int size = $this$fastMap$iv.size();
            while (index$iv$iv < size) {
                Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
                AnnotatedString.Range it = (AnnotatedString.Range) item$iv$iv;
                SpanStyle item = it.getItem();
                TreeSet transitions2 = transitions;
                Object obj = offsetMap.get(Integer.valueOf(it.getStart()));
                Intrinsics.checkNotNull(obj);
                int intValue = ((Number) obj).intValue();
                List $this$fastMap$iv2 = $this$fastMap$iv;
                Object obj2 = offsetMap.get(Integer.valueOf(it.getEnd()));
                Intrinsics.checkNotNull(obj2);
                target$iv2.add(new AnnotatedString.Range(item, intValue, ((Number) obj2).intValue()));
                index$iv$iv++;
                transitions = transitions2;
                $this$fastMap$iv = $this$fastMap$iv2;
            }
            newSpanStyles = target$iv2;
        } else {
            newSpanStyles = null;
        }
        List $this$fastMap$iv3 = $this$transform.getParagraphStylesOrNull$ui_text_release();
        if ($this$fastMap$iv3 == null) {
            newParaStyles = null;
        } else {
            int $i$f$fastMap = 0;
            ArrayList target$iv3 = new ArrayList($this$fastMap$iv3.size());
            List $this$fastForEach$iv$iv = $this$fastMap$iv3;
            int $i$f$fastForEach = 0;
            int index$iv$iv2 = 0;
            int size2 = $this$fastForEach$iv$iv.size();
            while (index$iv$iv2 < size2) {
                Object item$iv$iv2 = $this$fastForEach$iv$iv.get(index$iv$iv2);
                AnnotatedString.Range it2 = (AnnotatedString.Range) item$iv$iv2;
                int $i$f$fastMap2 = $i$f$fastMap;
                ParagraphStyle item2 = it2.getItem();
                List $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                Object obj3 = offsetMap.get(Integer.valueOf(it2.getStart()));
                Intrinsics.checkNotNull(obj3);
                int intValue2 = ((Number) obj3).intValue();
                int $i$f$fastForEach2 = $i$f$fastForEach;
                Object obj4 = offsetMap.get(Integer.valueOf(it2.getEnd()));
                Intrinsics.checkNotNull(obj4);
                target$iv3.add(new AnnotatedString.Range(item2, intValue2, ((Number) obj4).intValue()));
                index$iv$iv2++;
                $this$fastMap$iv3 = $this$fastMap$iv3;
                $i$f$fastMap = $i$f$fastMap2;
                $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                $i$f$fastForEach = $i$f$fastForEach2;
            }
            newParaStyles = target$iv3;
        }
        List $this$fastMap$iv4 = $this$transform.getAnnotations$ui_text_release();
        if ($this$fastMap$iv4 == null) {
            target$iv = null;
        } else {
            int $i$f$fastMap3 = 0;
            ArrayList target$iv4 = new ArrayList($this$fastMap$iv4.size());
            List $this$fastForEach$iv$iv3 = $this$fastMap$iv4;
            int $i$f$fastForEach3 = 0;
            int index$iv$iv3 = 0;
            int size3 = $this$fastForEach$iv$iv3.size();
            while (index$iv$iv3 < size3) {
                Object item$iv$iv3 = $this$fastForEach$iv$iv3.get(index$iv$iv3);
                AnnotatedString.Range it3 = (AnnotatedString.Range) item$iv$iv3;
                int $i$f$fastMap4 = $i$f$fastMap3;
                Object item3 = it3.getItem();
                List $this$fastForEach$iv$iv4 = $this$fastForEach$iv$iv3;
                Object obj5 = offsetMap.get(Integer.valueOf(it3.getStart()));
                Intrinsics.checkNotNull(obj5);
                int intValue3 = ((Number) obj5).intValue();
                int $i$f$fastForEach4 = $i$f$fastForEach3;
                Object obj6 = offsetMap.get(Integer.valueOf(it3.getEnd()));
                Intrinsics.checkNotNull(obj6);
                target$iv4.add(new AnnotatedString.Range(item3, intValue3, ((Number) obj6).intValue()));
                index$iv$iv3++;
                $this$fastMap$iv4 = $this$fastMap$iv4;
                $i$f$fastMap3 = $i$f$fastMap4;
                $this$fastForEach$iv$iv3 = $this$fastForEach$iv$iv4;
                $i$f$fastForEach3 = $i$f$fastForEach4;
            }
            target$iv = target$iv4;
        }
        ArrayList newAnnotations = target$iv;
        return new AnnotatedString((String) resultStr.element, newSpanStyles, newParaStyles, newAnnotations);
    }

    private static final void collectRangeTransitions(List<? extends AnnotatedString.Range<?>> list, SortedSet<Integer> sortedSet) {
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            AnnotatedString.Range item$iv$iv = list.get(index$iv$iv);
            AnnotatedString.Range range = item$iv$iv;
            sortedSet.add(Integer.valueOf(range.getStart()));
            sortedSet.add(Integer.valueOf(range.getEnd()));
        }
    }
}
