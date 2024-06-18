package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: TextSelectionColors.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0006\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"DefaultSelectionColor", "Landroidx/compose/ui/graphics/Color;", "J", "DefaultTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "getDefaultTextSelectionColors$annotations", "()V", "LocalTextSelectionColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalTextSelectionColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextSelectionColorsKt {
    private static final SelectionColors DefaultTextSelectionColors;
    private static final ProvidableCompositionLocal<SelectionColors> LocalTextSelectionColors = CompositionLocalKt.compositionLocalOf$default(null, new Function0<SelectionColors>() { // from class: androidx.compose.foundation.text.selection.TextSelectionColorsKt$LocalTextSelectionColors$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SelectionColors invoke() {
            SelectionColors selectionColors;
            selectionColors = TextSelectionColorsKt.DefaultTextSelectionColors;
            return selectionColors;
        }
    }, 1, null);
    private static final long DefaultSelectionColor = ColorKt.Color(4282550004L);

    private static /* synthetic */ void getDefaultTextSelectionColors$annotations() {
    }

    static {
        long m2947copywmQWz5c;
        long j = DefaultSelectionColor;
        m2947copywmQWz5c = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.4f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(DefaultSelectionColor) : 0.0f);
        DefaultTextSelectionColors = new SelectionColors(j, m2947copywmQWz5c, null);
    }

    public static final ProvidableCompositionLocal<SelectionColors> getLocalTextSelectionColors() {
        return LocalTextSelectionColors;
    }
}
