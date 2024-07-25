package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidOverscroll.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"StretchOverscrollNonClippingLayer", "Landroidx/compose/ui/Modifier;", "rememberOverscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/OverscrollEffect;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidOverscrollKt {
    private static final Modifier StretchOverscrollNonClippingLayer;

    public static final OverscrollEffect rememberOverscrollEffect(Composer $composer, int $changed) {
        NoOpOverscrollEffect noOpOverscrollEffect;
        Object value$iv$iv;
        $composer.startReplaceableGroup(-81138291);
        ComposerKt.sourceInformation($composer, "C(rememberOverscrollEffect)63@2804L7,64@2858L7,66@2907L80:AndroidOverscroll.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-81138291, $changed, -1, "androidx.compose.foundation.rememberOverscrollEffect (AndroidOverscroll.kt:62)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Context context = (Context) consume;
        ProvidableCompositionLocal<OverscrollConfiguration> localOverscrollConfiguration = OverscrollConfigurationKt.getLocalOverscrollConfiguration();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer.consume(localOverscrollConfiguration);
        ComposerKt.sourceInformationMarkerEnd($composer);
        OverscrollConfiguration config = (OverscrollConfiguration) consume2;
        if (config == null) {
            noOpOverscrollEffect = NoOpOverscrollEffect.INSTANCE;
        } else {
            $composer.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer.changed(context) | $composer.changed(config);
            Object it$iv$iv = $composer.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new AndroidEdgeEffectOverscrollEffect(context, config);
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            noOpOverscrollEffect = (OverscrollEffect) value$iv$iv;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return noOpOverscrollEffect;
    }

    static {
        Modifier.Companion companion;
        if (Build.VERSION.SDK_INT >= 31) {
            companion = LayoutModifierKt.layout(LayoutModifierKt.layout(Modifier.INSTANCE, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                    return m160invoke3p2s80s(measureScope, measurable, constraints.getValue());
                }

                /* renamed from: invoke-3p2s80s, reason: not valid java name */
                public final MeasureResult m160invoke3p2s80s(MeasureScope layout, Measurable measurable, long constraints) {
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    Intrinsics.checkNotNullParameter(measurable, "measurable");
                    final Placeable placeable = measurable.mo4186measureBRTryo0(constraints);
                    float arg0$iv = ClipScrollableContainerKt.getMaxSupportedElevation();
                    final int extraSizePx = layout.mo323roundToPx0680j_4(Dp.m5218constructorimpl(2 * arg0$iv));
                    return MeasureScope.layout$default(layout, placeable.getMeasuredWidth() - extraSizePx, placeable.getMeasuredHeight() - extraSizePx, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope layout2) {
                            Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                            Placeable.PlacementScope.placeWithLayer$default(layout2, Placeable.this, ((-extraSizePx) / 2) - ((Placeable.this.getWidth() - Placeable.this.getMeasuredWidth()) / 2), ((-extraSizePx) / 2) - ((Placeable.this.getHeight() - Placeable.this.getMeasuredHeight()) / 2), 0.0f, null, 12, null);
                        }
                    }, 4, null);
                }
            }), new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                    return m161invoke3p2s80s(measureScope, measurable, constraints.getValue());
                }

                /* renamed from: invoke-3p2s80s, reason: not valid java name */
                public final MeasureResult m161invoke3p2s80s(MeasureScope layout, Measurable measurable, long constraints) {
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    Intrinsics.checkNotNullParameter(measurable, "measurable");
                    final Placeable placeable = measurable.mo4186measureBRTryo0(constraints);
                    float arg0$iv = ClipScrollableContainerKt.getMaxSupportedElevation();
                    final int extraSizePx = layout.mo323roundToPx0680j_4(Dp.m5218constructorimpl(2 * arg0$iv));
                    int width = placeable.getWidth() + extraSizePx;
                    int height = placeable.getHeight() + extraSizePx;
                    return MeasureScope.layout$default(layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope layout2) {
                            Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                            Placeable.PlacementScope.place$default(layout2, Placeable.this, extraSizePx / 2, extraSizePx / 2, 0.0f, 4, null);
                        }
                    }, 4, null);
                }
            });
        } else {
            companion = Modifier.INSTANCE;
        }
        StretchOverscrollNonClippingLayer = companion;
    }
}
