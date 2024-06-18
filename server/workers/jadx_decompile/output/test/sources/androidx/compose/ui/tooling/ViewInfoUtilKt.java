package androidx.compose.ui.tooling;

import androidx.compose.ui.unit.IntRect;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ViewInfoUtil.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u001a2\u0010\u0006\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¨\u0006\n"}, d2 = {"filterTree", "", "Landroidx/compose/ui/tooling/ViewInfo;", "filter", "Lkotlin/Function1;", "", "toDebugString", "", "indentation", "", "ui-tooling_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ViewInfoUtilKt {
    static /* synthetic */ List filterTree$default(List list, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<ViewInfo, Boolean>() { // from class: androidx.compose.ui.tooling.ViewInfoUtilKt$filterTree$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ViewInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
        }
        return filterTree(list, function1);
    }

    private static final List<ViewInfo> filterTree(List<ViewInfo> list, Function1<? super ViewInfo, Boolean> function1) {
        Iterable list$iv$iv;
        Iterable listOf;
        List<ViewInfo> list$iv$iv2 = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : list$iv$iv2) {
            ViewInfo it = (ViewInfo) element$iv$iv;
            Iterable $this$flatMap$iv = filterTree(it.getChildren(), function1);
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv2 : $this$flatMap$iv) {
                ViewInfo child = (ViewInfo) element$iv$iv2;
                if (child.getLocation() == null) {
                    listOf = child.getChildren();
                } else {
                    listOf = CollectionsKt.listOf(child);
                }
                Iterable $this$flatMap$iv2 = list$iv$iv2;
                Iterable $this$flatMap$iv3 = listOf;
                CollectionsKt.addAll(destination$iv$iv2, $this$flatMap$iv3);
                list$iv$iv2 = $this$flatMap$iv2;
            }
            Iterable $this$flatMap$iv4 = list$iv$iv2;
            List acceptedNodes = (List) destination$iv$iv2;
            if (function1.invoke(it).booleanValue()) {
                list$iv$iv = CollectionsKt.listOf(new ViewInfo(it.getFileName(), it.getLineNumber(), it.getBounds(), it.getLocation(), acceptedNodes, it.getLayoutInfo()));
            } else {
                list$iv$iv = CollectionsKt.listOf(new ViewInfo("<root>", -1, IntRect.INSTANCE.getZero(), null, acceptedNodes, null));
            }
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            list$iv$iv2 = $this$flatMap$iv4;
        }
        return (List) destination$iv$iv;
    }

    public static /* synthetic */ String toDebugString$default(List list, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            function1 = new Function1<ViewInfo, Boolean>() { // from class: androidx.compose.ui.tooling.ViewInfoUtilKt$toDebugString$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ViewInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
        }
        return toDebugString(list, i, function1);
    }

    public static final String toDebugString(List<ViewInfo> list, int indentation, Function1<? super ViewInfo, Boolean> filter) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(filter, "filter");
        String indentString = StringsKt.repeat(".", indentation);
        StringBuilder builder = new StringBuilder();
        Iterable $this$forEach$iv = CollectionsKt.sortedWith(filterTree(list, filter), ComparisonsKt.compareBy(new Function1<ViewInfo, Comparable<?>>() { // from class: androidx.compose.ui.tooling.ViewInfoUtilKt$toDebugString$2
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(ViewInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getFileName();
            }
        }, new Function1<ViewInfo, Comparable<?>>() { // from class: androidx.compose.ui.tooling.ViewInfoUtilKt$toDebugString$3
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(ViewInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(it.getLineNumber());
            }
        }, new Function1<ViewInfo, Comparable<?>>() { // from class: androidx.compose.ui.tooling.ViewInfoUtilKt$toDebugString$4
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(ViewInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(it.allChildren().size());
            }
        }));
        for (Object element$iv : $this$forEach$iv) {
            ViewInfo it = (ViewInfo) element$iv;
            if (it.getLocation() != null) {
                StringBuilder append = builder.append(indentString + '|' + it.getFileName() + ':' + it.getLineNumber());
                Intrinsics.checkNotNullExpressionValue(append, "append(value)");
                Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append('\\n')");
            } else {
                StringBuilder append2 = builder.append(indentString + "|<root>");
                Intrinsics.checkNotNullExpressionValue(append2, "append(value)");
                Intrinsics.checkNotNullExpressionValue(append2.append('\n'), "append('\\n')");
            }
            String childrenString = StringsKt.trim((CharSequence) toDebugString(it.getChildren(), indentation + 1, filter)).toString();
            if (childrenString.length() > 0) {
                StringBuilder append3 = builder.append(childrenString);
                Intrinsics.checkNotNullExpressionValue(append3, "append(value)");
                Intrinsics.checkNotNullExpressionValue(append3.append('\n'), "append('\\n')");
            }
        }
        String sb = builder.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "builder.toString()");
        return sb;
    }
}
