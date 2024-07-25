package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubcomposeLayout.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001aZ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001f\b\u0002\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\t2\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a9\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\r\u001ab\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001f\b\u0002\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\t2\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001aA\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"SubcomposeLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "intermediateMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeIntermediateMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "measurePolicy", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "state", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "(Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SubcomposeSlotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "maxSlotsToRetainForReuse", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SubcomposeLayoutKt {
    public static final void SubcomposeLayout(final Modifier modifier, final Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer $composer, final int $changed, final int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer $composer2 = $composer.startRestartGroup(-1298353104);
        ComposerKt.sourceInformation($composer2, "C(SubcomposeLayout)P(1)77@3566L36,76@3532L144:SubcomposeLayout.kt#80mrfh");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(measurePolicy) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1298353104, $dirty2, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:72)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new SubcomposeLayoutState();
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayout((SubcomposeLayoutState) value$iv$iv, modifier, measurePolicy, $composer2, (($dirty2 << 3) & 112) | 8 | (($dirty2 << 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i3) {
                SubcomposeLayoutKt.SubcomposeLayout(Modifier.this, measurePolicy, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public static final void SubcomposeLayout(Modifier modifier, Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult> function2, final Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer $composer, final int $changed, final int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer $composer2 = $composer.startRestartGroup(159215138);
        ComposerKt.sourceInformation($composer2, "C(SubcomposeLayout)P(2)139@6954L36,138@6920L207:SubcomposeLayout.kt#80mrfh");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(measurePolicy) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i3 != 0) {
                Function2 intermediateMeasurePolicy = new Function2<SubcomposeIntermediateMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeIntermediateMeasureScope subcomposeIntermediateMeasureScope, Constraints constraints) {
                        return m4279invoke0kLqBqw(subcomposeIntermediateMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m4279invoke0kLqBqw(SubcomposeIntermediateMeasureScope $this$null, long constraints) {
                        Intrinsics.checkNotNullParameter($this$null, "$this$null");
                        return $this$null.getLookaheadMeasurePolicy().invoke($this$null, Constraints.m5162boximpl(constraints));
                    }
                };
                function2 = intermediateMeasurePolicy;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(159215138, $dirty2, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:130)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new SubcomposeLayoutState();
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayout((SubcomposeLayoutState) value$iv$iv, modifier, function2, measurePolicy, $composer2, (($dirty2 << 3) & 112) | 8 | (($dirty2 << 3) & 896) | (($dirty2 << 3) & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier2 = modifier;
        final Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult> function22 = function2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i4) {
                SubcomposeLayoutKt.SubcomposeLayout(Modifier.this, function22, measurePolicy, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public static final void SubcomposeLayout(final SubcomposeLayoutState state, Modifier modifier, final Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer $composer, final int $changed, final int i) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer $composer2 = $composer.startRestartGroup(-511989831);
        ComposerKt.sourceInformation($composer2, "C(SubcomposeLayout)P(2,1)260@13431L80:SubcomposeLayout.kt#80mrfh");
        if ((i & 2) != 0) {
            Modifier modifier2 = Modifier.INSTANCE;
            modifier = modifier2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511989831, $changed, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:254)");
        }
        SubcomposeLayout(state, modifier, new Function2<SubcomposeIntermediateMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$6
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeIntermediateMeasureScope subcomposeIntermediateMeasureScope, Constraints constraints) {
                return m4280invoke0kLqBqw(subcomposeIntermediateMeasureScope, constraints.getValue());
            }

            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
            public final MeasureResult m4280invoke0kLqBqw(SubcomposeIntermediateMeasureScope SubcomposeLayout, long it) {
                Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                return SubcomposeLayout.getLookaheadMeasurePolicy().invoke(SubcomposeLayout, Constraints.m5162boximpl(it));
            }
        }, measurePolicy, $composer2, ($changed & 112) | 392 | (($changed << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$7
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i2) {
                SubcomposeLayoutKt.SubcomposeLayout(SubcomposeLayoutState.this, modifier3, measurePolicy, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SubcomposeLayout(final androidx.compose.ui.layout.SubcomposeLayoutState r20, androidx.compose.ui.Modifier r21, kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.SubcomposeIntermediateMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult> r22, final kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.SubcomposeMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult> r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout(androidx.compose.ui.layout.SubcomposeLayoutState, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final SubcomposeSlotReusePolicy SubcomposeSlotReusePolicy(int maxSlotsToRetainForReuse) {
        return new FixedCountSubcomposeSlotReusePolicy(maxSlotsToRetainForReuse);
    }
}
