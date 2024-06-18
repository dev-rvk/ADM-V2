package androidx.compose.foundation.lazy.grid;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyGridDsl.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a~\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001a\u001a&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0002\u001a?\u0010!\u001a\u0019\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0\"¢\u0006\u0002\b\u00162\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010&\u001a?\u0010'\u001a\u0019\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0\"¢\u0006\u0002\b\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010(\u001aá\u0001\u0010)\u001a\u00020\u0001\"\u0004\b\u0000\u0010**\u00020\u00152\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H*0+2%\b\n\u0010,\u001a\u001f\u0012\u0013\u0012\u0011H*¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010\u001420\b\n\u00101\u001a*\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u0011H*¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000203\u0018\u00010\"¢\u0006\u0002\b\u00162%\b\n\u00104\u001a\u001f\u0012\u0013\u0012\u0011H*¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u0001000\u001423\b\u0004\u00105\u001a-\u0012\u0004\u0012\u000206\u0012\u0013\u0012\u0011H*¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b7¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u00108\u001aá\u0001\u0010)\u001a\u00020\u0001\"\u0004\b\u0000\u0010**\u00020\u00152\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H*0\u001c2%\b\n\u0010,\u001a\u001f\u0012\u0013\u0012\u0011H*¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010\u001420\b\n\u00101\u001a*\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u0011H*¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000203\u0018\u00010\"¢\u0006\u0002\b\u00162%\b\n\u00104\u001a\u001f\u0012\u0013\u0012\u0011H*¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u0001000\u001423\b\u0004\u00105\u001a-\u0012\u0004\u0012\u000206\u0012\u0013\u0012\u0011H*¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b7¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u00109\u001aµ\u0002\u0010:\u001a\u00020\u0001\"\u0004\b\u0000\u0010**\u00020\u00152\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H*0+2:\b\n\u0010,\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H*¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010\"2E\b\n\u00101\u001a?\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H*¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000203\u0018\u00010<¢\u0006\u0002\b\u00162:\b\u0006\u00104\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H*¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u0001000\"2H\b\u0004\u00105\u001aB\u0012\u0004\u0012\u000206\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H*¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00010<¢\u0006\u0002\b7¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010=\u001aµ\u0002\u0010:\u001a\u00020\u0001\"\u0004\b\u0000\u0010**\u00020\u00152\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H*0\u001c2:\b\n\u0010,\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H*¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010\"2E\b\n\u00101\u001a?\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H*¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000203\u0018\u00010<¢\u0006\u0002\b\u00162:\b\u0006\u00104\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H*¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u0001000\"2H\b\u0004\u00105\u001aB\u0012\u0004\u0012\u000206\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H*¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00010<¢\u0006\u0002\b7¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010>\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006?"}, d2 = {"LazyHorizontalGrid", "", "rows", "Landroidx/compose/foundation/lazy/grid/GridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalGrid", "columns", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "calculateCellsCrossAxisSizeImpl", "", "", "gridSize", "slotCount", "spacing", "rememberColumnWidthSums", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "items", "T", "", "key", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "item", "", "span", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyGridDslKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LazyVerticalGrid(final androidx.compose.foundation.lazy.grid.GridCells r29, androidx.compose.ui.Modifier r30, androidx.compose.foundation.lazy.grid.LazyGridState r31, androidx.compose.foundation.layout.PaddingValues r32, boolean r33, androidx.compose.foundation.layout.Arrangement.Vertical r34, androidx.compose.foundation.layout.Arrangement.Horizontal r35, androidx.compose.foundation.gestures.FlingBehavior r36, boolean r37, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 737
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid(androidx.compose.foundation.lazy.grid.GridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LazyHorizontalGrid(final androidx.compose.foundation.lazy.grid.GridCells r29, androidx.compose.ui.Modifier r30, androidx.compose.foundation.lazy.grid.LazyGridState r31, androidx.compose.foundation.layout.PaddingValues r32, boolean r33, androidx.compose.foundation.layout.Arrangement.Horizontal r34, androidx.compose.foundation.layout.Arrangement.Vertical r35, androidx.compose.foundation.gestures.FlingBehavior r36, boolean r37, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 738
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid(androidx.compose.foundation.lazy.grid.GridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Function2<Density, Constraints, LazyGridSlots> rememberColumnWidthSums(final GridCells columns, final Arrangement.Horizontal horizontalArrangement, final PaddingValues contentPadding, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(-1355301804);
        ComposerKt.sourceInformation($composer, "C(rememberColumnWidthSums)P(!1,2)148@6622L992:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1355301804, $changed, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:144)");
        }
        int i = ($changed & 14) | ($changed & 112) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(columns) | $composer.changed(horizontalArrangement) | $composer.changed(contentPadding);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new GridSlotCache(new Function2<Density, Constraints, LazyGridSlots>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$rememberColumnWidthSums$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridSlots invoke(Density density, Constraints constraints) {
                    return m612invoke0kLqBqw(density, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyGridSlots m612invoke0kLqBqw(Density $receiver, long constraints) {
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    if (!(Constraints.m5174getMaxWidthimpl(constraints) != Integer.MAX_VALUE)) {
                        throw new IllegalArgumentException("LazyVerticalGrid's width should be bound by parent.".toString());
                    }
                    float arg0$iv = PaddingKt.calculateStartPadding(PaddingValues.this, LayoutDirection.Ltr);
                    float other$iv = PaddingKt.calculateEndPadding(PaddingValues.this, LayoutDirection.Ltr);
                    int gridWidth = Constraints.m5174getMaxWidthimpl(constraints) - $receiver.mo323roundToPx0680j_4(Dp.m5218constructorimpl(arg0$iv + other$iv));
                    GridCells $this$invoke_0kLqBqw_u24lambda_u243 = columns;
                    Arrangement.Horizontal $this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241 = horizontalArrangement;
                    int[] sizes = CollectionsKt.toIntArray($this$invoke_0kLqBqw_u24lambda_u243.calculateCrossAxisCellSizes($receiver, gridWidth, $receiver.mo323roundToPx0680j_4($this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241.getSpacing())));
                    int[] positions = new int[sizes.length];
                    $this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241.arrange($receiver, gridWidth, sizes, LayoutDirection.Ltr, positions);
                    return new LazyGridSlots(sizes, positions);
                }
            });
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function2<Density, Constraints, LazyGridSlots> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }

    private static final Function2<Density, Constraints, LazyGridSlots> rememberRowHeightSums(final GridCells rows, final Arrangement.Vertical verticalArrangement, final PaddingValues contentPadding, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(239683573);
        ComposerKt.sourceInformation($composer, "C(rememberRowHeightSums)P(1,2)181@7812L926:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(239683573, $changed, -1, "androidx.compose.foundation.lazy.grid.rememberRowHeightSums (LazyGridDsl.kt:177)");
        }
        int i = ($changed & 14) | ($changed & 112) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(rows) | $composer.changed(verticalArrangement) | $composer.changed(contentPadding);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new GridSlotCache(new Function2<Density, Constraints, LazyGridSlots>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$rememberRowHeightSums$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridSlots invoke(Density density, Constraints constraints) {
                    return m613invoke0kLqBqw(density, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyGridSlots m613invoke0kLqBqw(Density $receiver, long constraints) {
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    if (!(Constraints.m5173getMaxHeightimpl(constraints) != Integer.MAX_VALUE)) {
                        throw new IllegalArgumentException("LazyHorizontalGrid's height should be bound by parent.".toString());
                    }
                    float arg0$iv = PaddingValues.this.getTop();
                    float other$iv = PaddingValues.this.getBottom();
                    int gridHeight = Constraints.m5173getMaxHeightimpl(constraints) - $receiver.mo323roundToPx0680j_4(Dp.m5218constructorimpl(arg0$iv + other$iv));
                    GridCells $this$invoke_0kLqBqw_u24lambda_u243 = rows;
                    Arrangement.Vertical $this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241 = verticalArrangement;
                    int[] sizes = CollectionsKt.toIntArray($this$invoke_0kLqBqw_u24lambda_u243.calculateCrossAxisCellSizes($receiver, gridHeight, $receiver.mo323roundToPx0680j_4($this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241.getSpacing())));
                    int[] positions = new int[sizes.length];
                    $this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241.arrange($receiver, gridHeight, sizes, positions);
                    return new LazyGridSlots(sizes, positions);
                }
            });
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function2<Density, Constraints, LazyGridSlots> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Integer> calculateCellsCrossAxisSizeImpl(int gridSize, int slotCount, int spacing) {
        int gridSizeWithoutSpacing = gridSize - ((slotCount - 1) * spacing);
        int slotSize = gridSizeWithoutSpacing / slotCount;
        int remainingPixels = gridSizeWithoutSpacing % slotCount;
        ArrayList arrayList = new ArrayList(slotCount);
        for (int i = 0; i < slotCount; i++) {
            int it = i;
            arrayList.add(Integer.valueOf((it < remainingPixels ? 1 : 0) + slotSize));
        }
        return arrayList;
    }

    public static /* synthetic */ void items$default(LazyGridScope $this$items_u24default, List items, Function1 key, Function2 span, Function1 contentType, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            span = null;
        }
        if ((i & 8) != 0) {
            Function1 contentType2 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke((LazyGridDslKt$items$1) p1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }
            };
            contentType = contentType2;
        }
        Intrinsics.checkNotNullParameter($this$items_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$items_u24default.items(items.size(), key != null ? new LazyGridDslKt$items$2(key, items) : null, span != null ? new LazyGridDslKt$items$3(span, items) : null, new LazyGridDslKt$items$4(contentType, items), ComposableLambdaKt.composableLambdaInstance(699646206, true, new LazyGridDslKt$items$5(itemContent, items)));
    }

    public static final <T> void items(LazyGridScope $this$items, List<? extends T> items, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> contentType, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$items.items(items.size(), function1 != null ? new LazyGridDslKt$items$2(function1, items) : null, function2 != null ? new LazyGridDslKt$items$3(function2, items) : null, new LazyGridDslKt$items$4(contentType, items), ComposableLambdaKt.composableLambdaInstance(699646206, true, new LazyGridDslKt$items$5(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope $this$itemsIndexed_u24default, List items, Function2 key, Function3 span, Function2 contentType, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            span = null;
        }
        if ((i & 8) != 0) {
            Function2 contentType2 = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    return invoke(((Number) p1).intValue(), (int) p2);
                }

                public final Void invoke(int i2, T t) {
                    return null;
                }
            };
            contentType = contentType2;
        }
        Intrinsics.checkNotNullParameter($this$itemsIndexed_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$itemsIndexed_u24default.items(items.size(), key != null ? new LazyGridDslKt$itemsIndexed$2(key, items) : null, span != null ? new LazyGridDslKt$itemsIndexed$3(span, items) : null, new LazyGridDslKt$itemsIndexed$4(contentType, items), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new LazyGridDslKt$itemsIndexed$5(itemContent, items)));
    }

    public static final <T> void itemsIndexed(LazyGridScope $this$itemsIndexed, List<? extends T> items, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> contentType, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$itemsIndexed.items(items.size(), function2 != null ? new LazyGridDslKt$itemsIndexed$2(function2, items) : null, function3 != null ? new LazyGridDslKt$itemsIndexed$3(function3, items) : null, new LazyGridDslKt$itemsIndexed$4(contentType, items), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new LazyGridDslKt$itemsIndexed$5(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyGridScope $this$items_u24default, Object[] items, Function1 key, Function2 span, Function1 contentType, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            span = null;
        }
        if ((i & 8) != 0) {
            Function1 contentType2 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$6
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke((LazyGridDslKt$items$6) p1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }
            };
            contentType = contentType2;
        }
        Intrinsics.checkNotNullParameter($this$items_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$items_u24default.items(items.length, key != null ? new LazyGridDslKt$items$7(key, items) : null, span != null ? new LazyGridDslKt$items$8(span, items) : null, new LazyGridDslKt$items$9(contentType, items), ComposableLambdaKt.composableLambdaInstance(407562193, true, new LazyGridDslKt$items$10(itemContent, items)));
    }

    public static final <T> void items(LazyGridScope $this$items, T[] items, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> contentType, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$items.items(items.length, function1 != null ? new LazyGridDslKt$items$7(function1, items) : null, function2 != null ? new LazyGridDslKt$items$8(function2, items) : null, new LazyGridDslKt$items$9(contentType, items), ComposableLambdaKt.composableLambdaInstance(407562193, true, new LazyGridDslKt$items$10(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope $this$itemsIndexed_u24default, Object[] items, Function2 key, Function3 span, Function2 contentType, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            span = null;
        }
        if ((i & 8) != 0) {
            Function2 contentType2 = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    return invoke(((Number) p1).intValue(), (int) p2);
                }

                public final Void invoke(int i2, T t) {
                    return null;
                }
            };
            contentType = contentType2;
        }
        Intrinsics.checkNotNullParameter($this$itemsIndexed_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$itemsIndexed_u24default.items(items.length, key != null ? new LazyGridDslKt$itemsIndexed$7(key, items) : null, span != null ? new LazyGridDslKt$itemsIndexed$8(span, items) : null, new LazyGridDslKt$itemsIndexed$9(contentType, items), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new LazyGridDslKt$itemsIndexed$10(itemContent, items)));
    }

    public static final <T> void itemsIndexed(LazyGridScope $this$itemsIndexed, T[] items, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> contentType, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$itemsIndexed.items(items.length, function2 != null ? new LazyGridDslKt$itemsIndexed$7(function2, items) : null, function3 != null ? new LazyGridDslKt$itemsIndexed$8(function3, items) : null, new LazyGridDslKt$itemsIndexed$9(contentType, items), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new LazyGridDslKt$itemsIndexed$10(itemContent, items)));
    }
}
