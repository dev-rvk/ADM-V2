package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoxWithConstraints.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b¢\u0006\u0002\b\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"BoxWithConstraints", "", "modifier", "Landroidx/compose/ui/Modifier;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BoxWithConstraintsKt {
    public static final void BoxWithConstraints(Modifier modifier, Alignment contentAlignment, boolean propagateMinConstraints, final Function3<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Alignment alignment;
        boolean propagateMinConstraints2;
        Alignment contentAlignment2;
        Object value$iv$iv;
        Alignment contentAlignment3;
        boolean propagateMinConstraints3;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(1781813501);
        ComposerKt.sourceInformation($composer2, "C(BoxWithConstraints)P(2,1,3)65@3186L67,66@3285L218,66@3258L245:BoxWithConstraints.kt#2w3rfo");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            alignment = contentAlignment;
        } else if (($changed & 112) == 0) {
            alignment = contentAlignment;
            $dirty |= $composer2.changed(alignment) ? 32 : 16;
        } else {
            alignment = contentAlignment;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            propagateMinConstraints2 = propagateMinConstraints;
        } else if (($changed & 896) == 0) {
            propagateMinConstraints2 = propagateMinConstraints;
            $dirty |= $composer2.changed(propagateMinConstraints2) ? 256 : 128;
        } else {
            propagateMinConstraints2 = propagateMinConstraints;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 2048 : 1024;
        }
        final int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            contentAlignment3 = alignment;
            propagateMinConstraints3 = propagateMinConstraints2;
            modifier3 = modifier2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            Alignment contentAlignment4 = i3 != 0 ? Alignment.INSTANCE.getTopStart() : alignment;
            if (i4 != 0) {
                propagateMinConstraints2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1781813501, $dirty2, -1, "androidx.compose.foundation.layout.BoxWithConstraints (BoxWithConstraints.kt:58)");
            }
            final MeasurePolicy measurePolicy = BoxKt.rememberBoxMeasurePolicy(contentAlignment4, propagateMinConstraints2, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 112));
            int i5 = ($dirty2 >> 9) & 14;
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(content) | $composer2.changed(measurePolicy);
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                contentAlignment2 = contentAlignment4;
                value$iv$iv = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$BoxWithConstraints$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m421invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m421invoke0kLqBqw(SubcomposeMeasureScope SubcomposeLayout, long constraints) {
                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                        final BoxWithConstraintsScopeImpl scope = new BoxWithConstraintsScopeImpl(SubcomposeLayout, constraints, null);
                        Unit unit = Unit.INSTANCE;
                        final Function3<BoxWithConstraintsScope, Composer, Integer, Unit> function3 = content;
                        final int i6 = $dirty2;
                        List measurables = SubcomposeLayout.subcompose(unit, ComposableLambdaKt.composableLambdaInstance(-1945019079, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$BoxWithConstraints$1$1$measurables$1
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

                            public final void invoke(Composer $composer3, int $changed2) {
                                ComposerKt.sourceInformation($composer3, "C68@3420L9:BoxWithConstraints.kt#2w3rfo");
                                if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                                    $composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1945019079, $changed2, -1, "androidx.compose.foundation.layout.BoxWithConstraints.<anonymous>.<anonymous>.<anonymous> (BoxWithConstraints.kt:68)");
                                }
                                function3.invoke(scope, $composer3, Integer.valueOf((i6 >> 6) & 112));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        MeasurePolicy $this$invoke_0kLqBqw_u24lambda_u240 = MeasurePolicy.this;
                        return $this$invoke_0kLqBqw_u24lambda_u240.mo15measure3p2s80s(SubcomposeLayout, measurables, constraints);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                contentAlignment2 = contentAlignment4;
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier4, (Function2) value$iv$iv, $composer2, $dirty2 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentAlignment3 = contentAlignment2;
            propagateMinConstraints3 = propagateMinConstraints2;
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final Alignment alignment2 = contentAlignment3;
        final boolean z = propagateMinConstraints3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$BoxWithConstraints$2
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

            public final void invoke(Composer composer, int i6) {
                BoxWithConstraintsKt.BoxWithConstraints(Modifier.this, alignment2, z, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }
}
