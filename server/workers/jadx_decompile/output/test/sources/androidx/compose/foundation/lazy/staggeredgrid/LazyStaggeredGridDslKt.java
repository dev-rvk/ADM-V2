package androidx.compose.foundation.lazy.staggeredgrid;

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
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyStaggeredGridDsl.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0086\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0086\u0001\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a?\u0010 \u001a\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0!¢\u0006\u0002\b\u00162\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0001¢\u0006\u0002\u0010%\u001a?\u0010&\u001a\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0!¢\u0006\u0002\b\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0001¢\u0006\u0002\u0010'\u001aÓ\u0001\u0010(\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0*2%\b\n\u0010+\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\u00142%\b\u0006\u00100\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\u00142%\b\n\u00101\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010\u001423\b\u0004\u00103\u001a-\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0002¢\u0006\u0002\u00106\u001aÓ\u0001\u0010(\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)072%\b\n\u0010+\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\u00142%\b\u0006\u00100\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\u00142%\b\n\u00101\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010\u001423\b\u0004\u00103\u001a-\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0002¢\u0006\u0002\u00108\u001a§\u0002\u00109\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0*2:\b\n\u0010+\u001a4\u0012\u0013\u0012\u00110:¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010!2:\b\u0006\u00100\u001a4\u0012\u0013\u0012\u00110:¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0!2:\b\n\u00101\u001a4\u0012\u0013\u0012\u00110:¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010!2H\b\u0004\u00103\u001aB\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u00110:¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010<¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0002¢\u0006\u0002\u0010=\u001a§\u0002\u00109\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)072:\b\n\u0010+\u001a4\u0012\u0013\u0012\u00110:¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010!2:\b\u0006\u00100\u001a4\u0012\u0013\u0012\u00110:¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0!2:\b\n\u00101\u001a4\u0012\u0013\u0012\u00110:¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010!2H\b\u0004\u00103\u001aB\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u00110:¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010<¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0002¢\u0006\u0002\u0010>\u0082\u0002\u0012\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006?"}, d2 = {"LazyHorizontalStaggeredGrid", "", "rows", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalItemSpacing", "Landroidx/compose/ui/unit/Dp;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyHorizontalStaggeredGrid-cJHQLPU", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalStaggeredGrid", "columns", "verticalItemSpacing", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "LazyVerticalStaggeredGrid-zadm560", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZFLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberColumnSlots", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "rememberRowSlots", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "items", "T", "", "key", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "item", "", "contentType", "span", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "itemContent", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyStaggeredGridDslKt {
    /* JADX WARN: Removed duplicated region for block: B:46:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a9  */
    /* renamed from: LazyVerticalStaggeredGrid-zadm560, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m655LazyVerticalStaggeredGridzadm560(final androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells r29, androidx.compose.ui.Modifier r30, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r31, androidx.compose.foundation.layout.PaddingValues r32, boolean r33, float r34, androidx.compose.foundation.layout.Arrangement.Horizontal r35, androidx.compose.foundation.gestures.FlingBehavior r36, boolean r37, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 703
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.m655LazyVerticalStaggeredGridzadm560(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, androidx.compose.foundation.layout.PaddingValues, boolean, float, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Function2<Density, Constraints, LazyStaggeredGridSlots> rememberColumnSlots(final StaggeredGridCells columns, final Arrangement.Horizontal horizontalArrangement, final PaddingValues contentPadding, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(-1038659655);
        ComposerKt.sourceInformation($composer, "C(rememberColumnSlots)P(!1,2)94@4216L1127:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1038659655, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberColumnSlots (LazyStaggeredGridDsl.kt:90)");
        }
        int i = ($changed & 14) | ($changed & 112) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(columns) | $composer.changed(horizontalArrangement) | $composer.changed(contentPadding);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new LazyStaggeredGridSlotCache(new Function2<Density, Constraints, LazyStaggeredGridSlots>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$rememberColumnSlots$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyStaggeredGridSlots invoke(Density density, Constraints constraints) {
                    return m656invoke0kLqBqw(density, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyStaggeredGridSlots m656invoke0kLqBqw(Density $receiver, long constraints) {
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    if (!(Constraints.m5174getMaxWidthimpl(constraints) != Integer.MAX_VALUE)) {
                        throw new IllegalArgumentException("LazyVerticalStaggeredGrid's width should be bound by parent.".toString());
                    }
                    float arg0$iv = PaddingKt.calculateStartPadding(PaddingValues.this, LayoutDirection.Ltr);
                    float other$iv = PaddingKt.calculateEndPadding(PaddingValues.this, LayoutDirection.Ltr);
                    int gridWidth = Constraints.m5174getMaxWidthimpl(constraints) - $receiver.mo323roundToPx0680j_4(Dp.m5218constructorimpl(arg0$iv + other$iv));
                    StaggeredGridCells $this$invoke_0kLqBqw_u24lambda_u243 = columns;
                    Arrangement.Horizontal $this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241 = horizontalArrangement;
                    int[] sizes = $this$invoke_0kLqBqw_u24lambda_u243.calculateCrossAxisCellSizes($receiver, gridWidth, $receiver.mo323roundToPx0680j_4($this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241.getSpacing()));
                    int[] positions = new int[sizes.length];
                    $this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241.arrange($receiver, gridWidth, sizes, LayoutDirection.Ltr, positions);
                    return new LazyStaggeredGridSlots(positions, sizes);
                }
            });
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function2<Density, Constraints, LazyStaggeredGridSlots> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01aa  */
    /* renamed from: LazyHorizontalStaggeredGrid-cJHQLPU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m654LazyHorizontalStaggeredGridcJHQLPU(final androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells r29, androidx.compose.ui.Modifier r30, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r31, androidx.compose.foundation.layout.PaddingValues r32, boolean r33, androidx.compose.foundation.layout.Arrangement.Vertical r34, float r35, androidx.compose.foundation.gestures.FlingBehavior r36, boolean r37, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 704
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.m654LazyHorizontalStaggeredGridcJHQLPU(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, float, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Function2<Density, Constraints, LazyStaggeredGridSlots> rememberRowSlots(final StaggeredGridCells rows, final Arrangement.Vertical verticalArrangement, final PaddingValues contentPadding, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(-675899235);
        ComposerKt.sourceInformation($composer, "C(rememberRowSlots)P(1,2)184@8133L953:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-675899235, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberRowSlots (LazyStaggeredGridDsl.kt:180)");
        }
        int i = ($changed & 14) | ($changed & 112) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(rows) | $composer.changed(verticalArrangement) | $composer.changed(contentPadding);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new LazyStaggeredGridSlotCache(new Function2<Density, Constraints, LazyStaggeredGridSlots>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$rememberRowSlots$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyStaggeredGridSlots invoke(Density density, Constraints constraints) {
                    return m657invoke0kLqBqw(density, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyStaggeredGridSlots m657invoke0kLqBqw(Density $receiver, long constraints) {
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    if (!(Constraints.m5173getMaxHeightimpl(constraints) != Integer.MAX_VALUE)) {
                        throw new IllegalArgumentException("LazyHorizontalStaggeredGrid's height should be bound by parent.".toString());
                    }
                    float arg0$iv = PaddingValues.this.getTop();
                    float other$iv = PaddingValues.this.getBottom();
                    int gridHeight = Constraints.m5173getMaxHeightimpl(constraints) - $receiver.mo323roundToPx0680j_4(Dp.m5218constructorimpl(arg0$iv + other$iv));
                    StaggeredGridCells $this$invoke_0kLqBqw_u24lambda_u243 = rows;
                    Arrangement.Vertical $this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241 = verticalArrangement;
                    int[] sizes = $this$invoke_0kLqBqw_u24lambda_u243.calculateCrossAxisCellSizes($receiver, gridHeight, $receiver.mo323roundToPx0680j_4($this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241.getSpacing()));
                    int[] positions = new int[sizes.length];
                    $this$invoke_0kLqBqw_u24lambda_u243_u24lambda_u242_u24lambda_u241.arrange($receiver, gridHeight, sizes, positions);
                    return new LazyStaggeredGridSlots(positions, sizes);
                }
            });
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function2<Density, Constraints, LazyStaggeredGridSlots> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope $this$items_u24default, List items, Function1 key, Function1 contentType, Function1 span, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            Function1 contentType2 = new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke((LazyStaggeredGridDslKt$items$1) p1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }
            };
            contentType = contentType2;
        }
        if ((i & 8) != 0) {
            span = null;
        }
        Intrinsics.checkNotNullParameter($this$items_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$items_u24default.items(items.size(), key != null ? new LazyStaggeredGridDslKt$items$2$1(key, items) : null, new LazyStaggeredGridDslKt$items$3(contentType, items), span != null ? new LazyStaggeredGridDslKt$items$4$1(span, items) : null, ComposableLambdaKt.composableLambdaInstance(-886456479, true, new LazyStaggeredGridDslKt$items$5(itemContent, items)));
    }

    public static final <T> void items(LazyStaggeredGridScope $this$items, List<? extends T> items, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> contentType, Function1<? super T, StaggeredGridItemSpan> function12, Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Function1 it;
        LazyStaggeredGridDslKt$items$4$1 lazyStaggeredGridDslKt$items$4$1;
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (function1 == null) {
            it = null;
        } else {
            it = new LazyStaggeredGridDslKt$items$2$1(function1, items);
        }
        LazyStaggeredGridDslKt$items$3 lazyStaggeredGridDslKt$items$3 = new LazyStaggeredGridDslKt$items$3(contentType, items);
        if (function12 == null) {
            lazyStaggeredGridDslKt$items$4$1 = null;
        } else {
            lazyStaggeredGridDslKt$items$4$1 = new LazyStaggeredGridDslKt$items$4$1(function12, items);
        }
        $this$items.items(size, it, lazyStaggeredGridDslKt$items$3, lazyStaggeredGridDslKt$items$4$1, ComposableLambdaKt.composableLambdaInstance(-886456479, true, new LazyStaggeredGridDslKt$items$5(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope $this$itemsIndexed_u24default, List items, Function2 key, Function2 contentType, Function2 span, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            Function2 contentType2 = new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$1
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
        if ((i & 8) != 0) {
            span = null;
        }
        Intrinsics.checkNotNullParameter($this$itemsIndexed_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$itemsIndexed_u24default.items(items.size(), key != null ? new LazyStaggeredGridDslKt$itemsIndexed$2$1(key, items) : null, new LazyStaggeredGridDslKt$itemsIndexed$3(contentType, items), span != null ? new LazyStaggeredGridDslKt$itemsIndexed$4$1(span, items) : null, ComposableLambdaKt.composableLambdaInstance(284833944, true, new LazyStaggeredGridDslKt$itemsIndexed$5(itemContent, items)));
    }

    public static final <T> void itemsIndexed(LazyStaggeredGridScope $this$itemsIndexed, List<? extends T> items, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> contentType, Function2<? super Integer, ? super T, StaggeredGridItemSpan> function22, Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        LazyStaggeredGridDslKt$itemsIndexed$2$1 lazyStaggeredGridDslKt$itemsIndexed$2$1;
        LazyStaggeredGridDslKt$itemsIndexed$4$1 lazyStaggeredGridDslKt$itemsIndexed$4$1;
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int size = items.size();
        if (function2 == null) {
            lazyStaggeredGridDslKt$itemsIndexed$2$1 = null;
        } else {
            lazyStaggeredGridDslKt$itemsIndexed$2$1 = new LazyStaggeredGridDslKt$itemsIndexed$2$1(function2, items);
        }
        LazyStaggeredGridDslKt$itemsIndexed$3 lazyStaggeredGridDslKt$itemsIndexed$3 = new LazyStaggeredGridDslKt$itemsIndexed$3(contentType, items);
        if (function22 == null) {
            lazyStaggeredGridDslKt$itemsIndexed$4$1 = null;
        } else {
            lazyStaggeredGridDslKt$itemsIndexed$4$1 = new LazyStaggeredGridDslKt$itemsIndexed$4$1(function22, items);
        }
        $this$itemsIndexed.items(size, lazyStaggeredGridDslKt$itemsIndexed$2$1, lazyStaggeredGridDslKt$itemsIndexed$3, lazyStaggeredGridDslKt$itemsIndexed$4$1, ComposableLambdaKt.composableLambdaInstance(284833944, true, new LazyStaggeredGridDslKt$itemsIndexed$5(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope $this$items_u24default, Object[] items, Function1 key, Function1 contentType, Function1 span, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            Function1 contentType2 = new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$6
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke((LazyStaggeredGridDslKt$items$6) p1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }
            };
            contentType = contentType2;
        }
        if ((i & 8) != 0) {
            span = null;
        }
        Intrinsics.checkNotNullParameter($this$items_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$items_u24default.items(items.length, key != null ? new LazyStaggeredGridDslKt$items$7$1(key, items) : null, new LazyStaggeredGridDslKt$items$8(contentType, items), span != null ? new LazyStaggeredGridDslKt$items$9$1(span, items) : null, ComposableLambdaKt.composableLambdaInstance(2101296000, true, new LazyStaggeredGridDslKt$items$10(itemContent, items)));
    }

    public static final <T> void items(LazyStaggeredGridScope $this$items, T[] items, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> contentType, Function1<? super T, StaggeredGridItemSpan> function12, Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Function1 it;
        LazyStaggeredGridDslKt$items$9$1 lazyStaggeredGridDslKt$items$9$1;
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (function1 == null) {
            it = null;
        } else {
            it = new LazyStaggeredGridDslKt$items$7$1(function1, items);
        }
        LazyStaggeredGridDslKt$items$8 lazyStaggeredGridDslKt$items$8 = new LazyStaggeredGridDslKt$items$8(contentType, items);
        if (function12 == null) {
            lazyStaggeredGridDslKt$items$9$1 = null;
        } else {
            lazyStaggeredGridDslKt$items$9$1 = new LazyStaggeredGridDslKt$items$9$1(function12, items);
        }
        $this$items.items(length, it, lazyStaggeredGridDslKt$items$8, lazyStaggeredGridDslKt$items$9$1, ComposableLambdaKt.composableLambdaInstance(2101296000, true, new LazyStaggeredGridDslKt$items$10(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope $this$itemsIndexed_u24default, Object[] items, Function2 key, Function2 contentType, Function2 span, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            Function2 contentType2 = new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$6
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
        if ((i & 8) != 0) {
            span = null;
        }
        Intrinsics.checkNotNullParameter($this$itemsIndexed_u24default, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        $this$itemsIndexed_u24default.items(items.length, key != null ? new LazyStaggeredGridDslKt$itemsIndexed$7$1(key, items) : null, new LazyStaggeredGridDslKt$itemsIndexed$8(contentType, items), span != null ? new LazyStaggeredGridDslKt$itemsIndexed$9$1(span, items) : null, ComposableLambdaKt.composableLambdaInstance(-804487775, true, new LazyStaggeredGridDslKt$itemsIndexed$10(itemContent, items)));
    }

    public static final <T> void itemsIndexed(LazyStaggeredGridScope $this$itemsIndexed, T[] items, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> contentType, Function2<? super Integer, ? super T, StaggeredGridItemSpan> function22, Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        LazyStaggeredGridDslKt$itemsIndexed$7$1 lazyStaggeredGridDslKt$itemsIndexed$7$1;
        LazyStaggeredGridDslKt$itemsIndexed$9$1 lazyStaggeredGridDslKt$itemsIndexed$9$1;
        Intrinsics.checkNotNullParameter($this$itemsIndexed, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        int length = items.length;
        if (function2 == null) {
            lazyStaggeredGridDslKt$itemsIndexed$7$1 = null;
        } else {
            lazyStaggeredGridDslKt$itemsIndexed$7$1 = new LazyStaggeredGridDslKt$itemsIndexed$7$1(function2, items);
        }
        LazyStaggeredGridDslKt$itemsIndexed$8 lazyStaggeredGridDslKt$itemsIndexed$8 = new LazyStaggeredGridDslKt$itemsIndexed$8(contentType, items);
        if (function22 == null) {
            lazyStaggeredGridDslKt$itemsIndexed$9$1 = null;
        } else {
            lazyStaggeredGridDslKt$itemsIndexed$9$1 = new LazyStaggeredGridDslKt$itemsIndexed$9$1(function22, items);
        }
        $this$itemsIndexed.items(length, lazyStaggeredGridDslKt$itemsIndexed$7$1, lazyStaggeredGridDslKt$itemsIndexed$8, lazyStaggeredGridDslKt$itemsIndexed$9$1, ComposableLambdaKt.composableLambdaInstance(-804487775, true, new LazyStaggeredGridDslKt$itemsIndexed$10(itemContent, items)));
    }
}
