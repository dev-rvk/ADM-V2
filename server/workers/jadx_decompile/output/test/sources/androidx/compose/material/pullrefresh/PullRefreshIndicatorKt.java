package androidx.compose.material.pullrefresh;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.google.android.material.internal.ViewUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: PullRefreshIndicator.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002\u001a-\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aM\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001a2\b\b\u0002\u0010#\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020!H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001aA\u0010'\u001a\u00020\u0016*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0013H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0007\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\n\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u000b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\f\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0011\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00061²\u0006\n\u00102\u001a\u00020!X\u008a\u0084\u0002²\u0006\n\u00103\u001a\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"AlphaTween", "Landroidx/compose/animation/core/TweenSpec;", "", "ArcRadius", "Landroidx/compose/ui/unit/Dp;", "F", "ArrowHeight", "ArrowWidth", "CrossfadeDurationMs", "", "Elevation", "IndicatorSize", "MaxAlpha", "MaxProgressArc", "MinAlpha", "SpinnerShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "StrokeWidth", "ArrowValues", "Landroidx/compose/material/pullrefresh/ArrowValues;", NotificationCompat.CATEGORY_PROGRESS, "CircularArrowIndicator", "", "state", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "color", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "CircularArrowIndicator-iJQMabo", "(Landroidx/compose/material/pullrefresh/PullRefreshState;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "PullRefreshIndicator", "refreshing", "", "backgroundColor", "contentColor", "scale", "PullRefreshIndicator-jB83MbM", "(ZLandroidx/compose/material/pullrefresh/PullRefreshState;Landroidx/compose/ui/Modifier;JJZLandroidx/compose/runtime/Composer;II)V", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "alpha", "values", "drawArrow-Bx497Mc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material/pullrefresh/ArrowValues;)V", "material_release", "showElevation", "targetAlpha"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PullRefreshIndicatorKt {
    private static final int CrossfadeDurationMs = 100;
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final float IndicatorSize = Dp.m5218constructorimpl(40);
    private static final RoundedCornerShape SpinnerShape = RoundedCornerShapeKt.getCircleShape();
    private static final float ArcRadius = Dp.m5218constructorimpl((float) 7.5d);
    private static final float StrokeWidth = Dp.m5218constructorimpl((float) 2.5d);
    private static final float ArrowWidth = Dp.m5218constructorimpl(10);
    private static final float ArrowHeight = Dp.m5218constructorimpl(5);
    private static final float Elevation = Dp.m5218constructorimpl(6);
    private static final TweenSpec<Float> AlphaTween = AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null);

    /* JADX WARN: Removed duplicated region for block: B:23:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e9  */
    /* renamed from: PullRefreshIndicator-jB83MbM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1272PullRefreshIndicatorjB83MbM(final boolean r42, final androidx.compose.material.pullrefresh.PullRefreshState r43, androidx.compose.ui.Modifier r44, long r45, long r47, boolean r49, androidx.compose.runtime.Composer r50, final int r51, final int r52) {
        /*
            Method dump skipped, instructions count: 767
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt.m1272PullRefreshIndicatorjB83MbM(boolean, androidx.compose.material.pullrefresh.PullRefreshState, androidx.compose.ui.Modifier, long, long, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean PullRefreshIndicator_jB83MbM$lambda$1(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CircularArrowIndicator-iJQMabo, reason: not valid java name */
    public static final void m1271CircularArrowIndicatoriJQMabo(final PullRefreshState state, final long color, final Modifier modifier, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Composer $composer2 = $composer.startRestartGroup(-486016981);
        ComposerKt.sourceInformation($composer2, "C(CircularArrowIndicator)P(2,0:c#ui.graphics.Color)134@5303L61,136@5389L119,142@5531L74,145@5644L1000:PullRefreshIndicator.kt#t44y28");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-486016981, $changed, -1, "androidx.compose.material.pullrefresh.CircularArrowIndicator (PullRefreshIndicator.kt:129)");
        }
        $composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer2.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            Path $this$CircularArrowIndicator_iJQMabo_u24lambda_u244_u24lambda_u243 = AndroidPath_androidKt.Path();
            $this$CircularArrowIndicator_iJQMabo_u24lambda_u244_u24lambda_u243.mo2844setFillTypeoQ8Xj4U(PathFillType.INSTANCE.m3225getEvenOddRgk1Os());
            value$iv$iv = $this$CircularArrowIndicator_iJQMabo_u24lambda_u244_u24lambda_u243;
            $composer2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer2.endReplaceableGroup();
        final Path path = (Path) value$iv$iv;
        $composer2.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer2.changed(state);
        Object it$iv$iv2 = $composer2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv2 = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$targetAlpha$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(PullRefreshState.this.getProgress() < 1.0f ? 0.3f : 1.0f);
                }
            });
            $composer2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer2.endReplaceableGroup();
        State targetAlpha$delegate = (State) value$iv$iv2;
        final State alphaState = AnimateAsStateKt.animateFloatAsState(CircularArrowIndicator_iJQMabo$lambda$6(targetAlpha$delegate), AlphaTween, 0.0f, null, null, $composer2, 48, 28);
        CanvasKt.Canvas(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
            }
        }, 1, null), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope Canvas) {
                ArrowValues values;
                float f;
                float f2;
                float f3;
                Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                values = PullRefreshIndicatorKt.ArrowValues(PullRefreshState.this.getProgress());
                float alpha = alphaState.getValue().floatValue();
                float degrees$iv = values.getRotation();
                long j = color;
                Path path2 = path;
                long pivot$iv = Canvas.mo3491getCenterF1C5BW0();
                DrawContext $this$withTransform_u24lambda_u246$iv$iv = Canvas.getDrawContext();
                long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo3417getSizeNHjbRc();
                $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
                DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
                $this$rotate_Rg1IO4c_u24lambda_u240$iv.mo3423rotateUv8p0NA(degrees$iv, pivot$iv);
                f = PullRefreshIndicatorKt.ArcRadius;
                float f4 = Canvas.mo329toPx0680j_4(f);
                f2 = PullRefreshIndicatorKt.StrokeWidth;
                float arcRadius = f4 + (Canvas.mo329toPx0680j_4(f2) / 2.0f);
                Rect arcBounds = new Rect(Offset.m2710getXimpl(SizeKt.m2789getCenteruvyYCjk(Canvas.mo3492getSizeNHjbRc())) - arcRadius, Offset.m2711getYimpl(SizeKt.m2789getCenteruvyYCjk(Canvas.mo3492getSizeNHjbRc())) - arcRadius, Offset.m2710getXimpl(SizeKt.m2789getCenteruvyYCjk(Canvas.mo3492getSizeNHjbRc())) + arcRadius, Offset.m2711getYimpl(SizeKt.m2789getCenteruvyYCjk(Canvas.mo3492getSizeNHjbRc())) + arcRadius);
                float startAngle = values.getStartAngle();
                float endAngle = values.getEndAngle() - values.getStartAngle();
                long m2745getTopLeftF1C5BW0 = arcBounds.m2745getTopLeftF1C5BW0();
                long m2743getSizeNHjbRc = arcBounds.m2743getSizeNHjbRc();
                f3 = PullRefreshIndicatorKt.StrokeWidth;
                DrawScope.m3472drawArcyD3GUKo$default(Canvas, j, startAngle, endAngle, false, m2745getTopLeftF1C5BW0, m2743getSizeNHjbRc, alpha, new Stroke(Canvas.mo329toPx0680j_4(f3), 0.0f, StrokeCap.INSTANCE.m3297getSquareKaPHkGw(), 0, null, 26, null), null, 0, ViewUtils.EDGE_TO_EDGE_FLAGS, null);
                PullRefreshIndicatorKt.m1275drawArrowBx497Mc(Canvas, path2, arcBounds, j, alpha, values);
                $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                $this$withTransform_u24lambda_u246$iv$iv.mo3418setSizeuvyYCjk(previousSize$iv$iv);
            }
        }, $composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                PullRefreshIndicatorKt.m1271CircularArrowIndicatoriJQMabo(PullRefreshState.this, color, modifier, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    private static final float CircularArrowIndicator_iJQMabo$lambda$6(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrowValues ArrowValues(float progress) {
        float adjustedPercent = (Math.max(Math.min(1.0f, progress) - 0.4f, 0.0f) * 5) / 3;
        float overshootPercent = Math.abs(progress) - 1.0f;
        float linearTension = RangesKt.coerceIn(overshootPercent, 0.0f, 2.0f);
        float tensionPercent = linearTension - (((float) Math.pow(linearTension, 2)) / 4);
        float endTrim = MaxProgressArc * adjustedPercent;
        float rotation = (((0.4f * adjustedPercent) - 0.25f) + tensionPercent) * 0.5f;
        float f = 360;
        float startAngle = rotation * f;
        float endAngle = (rotation + endTrim) * f;
        float scale = Math.min(1.0f, adjustedPercent);
        return new ArrowValues(rotation, startAngle, endAngle, scale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawArrow-Bx497Mc, reason: not valid java name */
    public static final void m1275drawArrowBx497Mc(DrawScope $this$drawArrow_u2dBx497Mc, Path arrow, Rect bounds, long color, float alpha, ArrowValues values) {
        arrow.reset();
        arrow.moveTo(0.0f, 0.0f);
        arrow.lineTo($this$drawArrow_u2dBx497Mc.mo329toPx0680j_4(ArrowWidth) * values.getScale(), 0.0f);
        arrow.lineTo(($this$drawArrow_u2dBx497Mc.mo329toPx0680j_4(ArrowWidth) * values.getScale()) / 2, $this$drawArrow_u2dBx497Mc.mo329toPx0680j_4(ArrowHeight) * values.getScale());
        float radius = Math.min(bounds.getWidth(), bounds.getHeight()) / 2.0f;
        float inset = ($this$drawArrow_u2dBx497Mc.mo329toPx0680j_4(ArrowWidth) * values.getScale()) / 2.0f;
        arrow.mo2846translatek4lQ0M(OffsetKt.Offset((Offset.m2710getXimpl(bounds.m2740getCenterF1C5BW0()) + radius) - inset, Offset.m2711getYimpl(bounds.m2740getCenterF1C5BW0()) + ($this$drawArrow_u2dBx497Mc.mo329toPx0680j_4(StrokeWidth) / 2.0f)));
        arrow.close();
        float degrees$iv = values.getEndAngle();
        long pivot$iv = $this$drawArrow_u2dBx497Mc.mo3491getCenterF1C5BW0();
        DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$drawArrow_u2dBx497Mc.getDrawContext();
        long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo3417getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
        DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
        $this$rotate_Rg1IO4c_u24lambda_u240$iv.mo3423rotateUv8p0NA(degrees$iv, pivot$iv);
        DrawScope.m3483drawPathLG529CI$default($this$drawArrow_u2dBx497Mc, arrow, color, alpha, null, null, 0, 56, null);
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv$iv.mo3418setSizeuvyYCjk(previousSize$iv$iv);
    }
}
