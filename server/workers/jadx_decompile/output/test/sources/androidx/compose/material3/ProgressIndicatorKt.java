package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.CircularProgressIndicatorTokens;
import androidx.compose.material3.tokens.LinearProgressIndicatorTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* compiled from: ProgressIndicator.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a3\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u0005H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aG\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a;\u0010\"\u001a\u00020#2\u0006\u00100\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u0005H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001aO\u0010\"\u001a\u00020#2\u0006\u00100\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a3\u00105\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020'H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001a=\u00105\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a;\u00105\u001a\u00020#2\u0006\u00100\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020'H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001aE\u00105\u001a\u00020#2\u0006\u00100\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a9\u0010>\u001a\u00020#*\u00020?2\u0006\u0010@\u001a\u00020\u00012\u0006\u0010A\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a)\u0010F\u001a\u00020#*\u00020?2\u0006\u0010&\u001a\u00020'2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010H\u001a9\u0010I\u001a\u00020#*\u00020?2\u0006\u0010@\u001a\u00020\u00012\u0006\u0010A\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u0010E\u001aA\u0010K\u001a\u00020#*\u00020?2\u0006\u0010@\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010M\u001aA\u0010N\u001a\u00020#*\u00020?2\u0006\u0010O\u001a\u00020\u00012\u0006\u0010P\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a1\u0010S\u001a\u00020#*\u00020?2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010U\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0004\u001a\u00020\u0005X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0014\u001a\u00020\u0005X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0015\u0010\u0007\"\u0019\u0010\u0016\u001a\u00020\u0005X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0007\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006V"}, d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "getCircularIndicatorDiameter", "()F", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "getLinearIndicatorHeight", "LinearIndicatorWidth", "getLinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "StartAngleOffset", "CircularProgressIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "trackColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", NotificationCompat.CATEGORY_PROGRESS, "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-DUhRLBM", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-_5eSR-E", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorTrack", "drawCircularIndicatorTrack-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "drawLinearIndicatorTrack", "drawLinearIndicatorTrack-AZGd3zU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFI)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    private static final CubicBezierEasing CircularEasing;
    private static final float CircularIndicatorDiameter;
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    private static final CubicBezierEasing FirstLineHeadEasing;
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    private static final CubicBezierEasing FirstLineTailEasing;
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    private static final CubicBezierEasing SecondLineHeadEasing;
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    private static final CubicBezierEasing SecondLineTailEasing;
    private static final float StartAngleOffset = -90.0f;
    private static final float LinearIndicatorWidth = Dp.m5218constructorimpl(240);
    private static final float LinearIndicatorHeight = LinearProgressIndicatorTokens.INSTANCE.m2265getTrackHeightD9Ej5fM();

    /* JADX WARN: Removed duplicated region for block: B:62:0x01b7  */
    /* renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1658LinearProgressIndicator_5eSRE(final float r23, androidx.compose.ui.Modifier r24, long r25, long r27, int r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m1658LinearProgressIndicator_5eSRE(float, androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: LinearProgressIndicator-2cYBFYY, reason: not valid java name */
    public static final void m1656LinearProgressIndicator2cYBFYY(Modifier modifier, long color, long trackColor, int strokeCap, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long j2;
        int i2;
        long color2;
        long trackColor2;
        long color3;
        long trackColor3;
        int strokeCap2;
        Modifier modifier3;
        int i3;
        int i4;
        int i5;
        Composer $composer2 = $composer.startRestartGroup(-476865359);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.StrokeCap)109@5065L11,110@5128L16,113@5249L28,117@5531L319,128@5894L319,139@6258L323,150@6626L323,165@7081L660,161@6954L787:ProgressIndicator.kt#uh7d8r");
        int $dirty = $changed;
        int i6 = i & 1;
        if (i6 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i5 = 32;
                    $dirty |= i5;
                }
            } else {
                j = color;
            }
            i5 = 16;
            $dirty |= i5;
        } else {
            j = color;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                j2 = trackColor;
                if ($composer2.changed(j2)) {
                    i4 = 256;
                    $dirty |= i4;
                }
            } else {
                j2 = trackColor;
            }
            i4 = 128;
            $dirty |= i4;
        } else {
            j2 = trackColor;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty |= 3072;
            i2 = strokeCap;
        } else if (($changed & 7168) == 0) {
            i2 = strokeCap;
            $dirty |= $composer2.changed(i2) ? 2048 : 1024;
        } else {
            i2 = strokeCap;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            color3 = j;
            trackColor3 = j2;
            strokeCap2 = i2;
            modifier3 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i6 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getLinearColor($composer2, 6);
                    $dirty &= -113;
                } else {
                    color2 = j;
                }
                if ((i & 4) != 0) {
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor($composer2, 6);
                    $dirty &= -897;
                } else {
                    trackColor2 = j2;
                }
                if (i7 != 0) {
                    modifier3 = modifier4;
                    color3 = color2;
                    trackColor3 = trackColor2;
                    strokeCap2 = ProgressIndicatorDefaults.INSTANCE.m1651getLinearStrokeCapKaPHkGw();
                } else {
                    color3 = color2;
                    trackColor3 = trackColor2;
                    strokeCap2 = i2;
                    modifier3 = modifier4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                color3 = j;
                trackColor3 = j2;
                strokeCap2 = i2;
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-476865359, $changed, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:107)");
            }
            InfiniteTransition infiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(null, $composer2, 0, 1);
            final State firstLineHead = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m95infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    CubicBezierEasing cubicBezierEasing;
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1800);
                    KeyframesSpec.KeyframeEntity<Float> at = keyframes.at(Float.valueOf(0.0f), 0);
                    cubicBezierEasing = ProgressIndicatorKt.FirstLineHeadEasing;
                    keyframes.with(at, cubicBezierEasing);
                    keyframes.at(Float.valueOf(1.0f), 750);
                }
            }), null, 0L, 6, null), null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            final State firstLineTail = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m95infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    CubicBezierEasing cubicBezierEasing;
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1800);
                    KeyframesSpec.KeyframeEntity<Float> at = keyframes.at(Float.valueOf(0.0f), 333);
                    cubicBezierEasing = ProgressIndicatorKt.FirstLineTailEasing;
                    keyframes.with(at, cubicBezierEasing);
                    keyframes.at(Float.valueOf(1.0f), 1183);
                }
            }), null, 0L, 6, null), null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            final State secondLineHead = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m95infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    CubicBezierEasing cubicBezierEasing;
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1800);
                    KeyframesSpec.KeyframeEntity<Float> at = keyframes.at(Float.valueOf(0.0f), 1000);
                    cubicBezierEasing = ProgressIndicatorKt.SecondLineHeadEasing;
                    keyframes.with(at, cubicBezierEasing);
                    keyframes.at(Float.valueOf(1.0f), 1567);
                }
            }), null, 0L, 6, null), null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            final State secondLineTail = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m95infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    CubicBezierEasing cubicBezierEasing;
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1800);
                    KeyframesSpec.KeyframeEntity<Float> at = keyframes.at(Float.valueOf(0.0f), 1267);
                    cubicBezierEasing = ProgressIndicatorKt.SecondLineTailEasing;
                    keyframes.with(at, cubicBezierEasing);
                    keyframes.at(Float.valueOf(1.0f), 1800);
                }
            }), null, 0L, 6, null), null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            Modifier m533sizeVpY3zN4 = SizeKt.m533sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(modifier3), LinearIndicatorWidth, LinearIndicatorHeight);
            Object[] keys$iv = {Color.m2939boximpl(trackColor3), StrokeCap.m3288boximpl(strokeCap2), firstLineHead, firstLineTail, Color.m2939boximpl(color3), secondLineHead, secondLineTail};
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Object value$iv$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
                final long j3 = trackColor3;
                i3 = 0;
                final int i8 = strokeCap2;
                final long j4 = color3;
                value$iv$iv = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$3$1
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
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        float strokeWidth = Size.m2776getHeightimpl(Canvas.mo3492getSizeNHjbRc());
                        ProgressIndicatorKt.m1670drawLinearIndicatorTrackAZGd3zU(Canvas, j3, strokeWidth, i8);
                        if (firstLineHead.getValue().floatValue() - firstLineTail.getValue().floatValue() > 0.0f) {
                            ProgressIndicatorKt.m1669drawLinearIndicatorqYKTg0g(Canvas, firstLineHead.getValue().floatValue(), firstLineTail.getValue().floatValue(), j4, strokeWidth, i8);
                        }
                        if (secondLineHead.getValue().floatValue() - secondLineTail.getValue().floatValue() > 0.0f) {
                            ProgressIndicatorKt.m1669drawLinearIndicatorqYKTg0g(Canvas, secondLineHead.getValue().floatValue(), secondLineTail.getValue().floatValue(), j4, strokeWidth, i8);
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                i3 = 0;
            }
            $composer2.endReplaceableGroup();
            CanvasKt.Canvas(m533sizeVpY3zN4, (Function1) value$iv$iv, $composer2, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final long j5 = color3;
        final long j6 = trackColor3;
        final int i9 = strokeCap2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$4
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

            public final void invoke(Composer composer, int i10) {
                ProgressIndicatorKt.m1656LinearProgressIndicator2cYBFYY(Modifier.this, j5, j6, i9, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-eaDK9VM, reason: not valid java name */
    public static final /* synthetic */ void m1659LinearProgressIndicatoreaDK9VM(final float progress, Modifier modifier, long color, long trackColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long j2;
        Modifier.Companion modifier3;
        long color2;
        long trackColor2;
        Modifier modifier4;
        long color3;
        long trackColor3;
        int i2;
        int i3;
        Composer $composer2 = $composer.startRestartGroup(-372717133);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.graphics.Color)194@7971L11,195@8034L16,196@8056L140:ProgressIndicator.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(progress) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i3 = 256;
                    $dirty |= i3;
                }
            } else {
                j = color;
            }
            i3 = 128;
            $dirty |= i3;
        } else {
            j = color;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                j2 = trackColor;
                if ($composer2.changed(j2)) {
                    i2 = 2048;
                    $dirty |= i2;
                }
            } else {
                j2 = trackColor;
            }
            i2 = 1024;
            $dirty |= i2;
        } else {
            j2 = trackColor;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            trackColor3 = j2;
            modifier4 = modifier2;
            color3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getLinearColor($composer2, 6);
                    $dirty &= -897;
                } else {
                    color2 = j;
                }
                if ((i & 8) != 0) {
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor($composer2, 6);
                    $dirty &= -7169;
                } else {
                    trackColor2 = j2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                modifier3 = modifier2;
                color2 = j;
                trackColor2 = j2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-372717133, $dirty, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:191)");
            }
            m1658LinearProgressIndicator_5eSRE(progress, modifier3, color2, trackColor2, ProgressIndicatorDefaults.INSTANCE.m1651getLinearStrokeCapKaPHkGw(), $composer2, ($dirty & 14) | 24576 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            color3 = color2;
            trackColor3 = trackColor2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier4;
        final long j3 = color3;
        final long j4 = trackColor3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$5
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

            public final void invoke(Composer composer, int i5) {
                ProgressIndicatorKt.m1659LinearProgressIndicatoreaDK9VM(progress, modifier5, j3, j4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-RIQooxk, reason: not valid java name */
    public static final /* synthetic */ void m1657LinearProgressIndicatorRIQooxk(Modifier modifier, long color, long trackColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long j2;
        Modifier.Companion modifier3;
        long color2;
        long trackColor2;
        Modifier modifier4;
        long color3;
        long trackColor3;
        int i2;
        int i3;
        Composer $composer2 = $composer.startRestartGroup(585576195);
        ComposerKt.sourceInformation($composer2, "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.graphics.Color)208@8403L11,209@8466L16,210@8488L126:ProgressIndicator.kt#uh7d8r");
        int $dirty = $changed;
        int i4 = i & 1;
        if (i4 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i3 = 32;
                    $dirty |= i3;
                }
            } else {
                j = color;
            }
            i3 = 16;
            $dirty |= i3;
        } else {
            j = color;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                j2 = trackColor;
                if ($composer2.changed(j2)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                j2 = trackColor;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            j2 = trackColor;
        }
        if (($dirty & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            trackColor3 = j2;
            modifier4 = modifier2;
            color3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getLinearColor($composer2, 6);
                    $dirty &= -113;
                } else {
                    color2 = j;
                }
                if ((i & 4) != 0) {
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor($composer2, 6);
                    $dirty &= -897;
                } else {
                    trackColor2 = j2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier3 = modifier2;
                color2 = j;
                trackColor2 = j2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(585576195, $dirty, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:206)");
            }
            m1656LinearProgressIndicator2cYBFYY(modifier3, color2, trackColor2, ProgressIndicatorDefaults.INSTANCE.m1651getLinearStrokeCapKaPHkGw(), $composer2, ($dirty & 14) | 3072 | ($dirty & 112) | ($dirty & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            color3 = color2;
            trackColor3 = trackColor2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier4;
        final long j3 = color3;
        final long j4 = trackColor3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$6
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

            public final void invoke(Composer composer, int i5) {
                ProgressIndicatorKt.m1657LinearProgressIndicatorRIQooxk(Modifier.this, j3, j4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawLinearIndicator-qYKTg0g, reason: not valid java name */
    public static final void m1669drawLinearIndicatorqYKTg0g(DrawScope $this$drawLinearIndicator_u2dqYKTg0g, float startFraction, float endFraction, long color, float strokeWidth, int strokeCap) {
        float width = Size.m2779getWidthimpl($this$drawLinearIndicator_u2dqYKTg0g.mo3492getSizeNHjbRc());
        float height = Size.m2776getHeightimpl($this$drawLinearIndicator_u2dqYKTg0g.mo3492getSizeNHjbRc());
        float f = 2;
        float yOffset = height / f;
        boolean isLtr = $this$drawLinearIndicator_u2dqYKTg0g.getLayoutDirection() == LayoutDirection.Ltr;
        float barStart = (isLtr ? startFraction : 1.0f - endFraction) * width;
        float barEnd = (isLtr ? endFraction : 1.0f - startFraction) * width;
        if (StrokeCap.m3291equalsimpl0(strokeCap, StrokeCap.INSTANCE.m3295getButtKaPHkGw()) || height > width) {
            DrawScope.m3479drawLineNGM6Ib0$default($this$drawLinearIndicator_u2dqYKTg0g, color, OffsetKt.Offset(barStart, yOffset), OffsetKt.Offset(barEnd, yOffset), strokeWidth, 0, null, 0.0f, null, 0, 496, null);
            return;
        }
        float strokeCapOffset = strokeWidth / f;
        ClosedFloatingPointRange coerceRange = RangesKt.rangeTo(strokeCapOffset, width - strokeCapOffset);
        float adjustedBarStart = ((Number) RangesKt.coerceIn(Float.valueOf(barStart), (ClosedFloatingPointRange<Float>) coerceRange)).floatValue();
        float adjustedBarEnd = ((Number) RangesKt.coerceIn(Float.valueOf(barEnd), (ClosedFloatingPointRange<Float>) coerceRange)).floatValue();
        if (Math.abs(endFraction - startFraction) > 0.0f) {
            DrawScope.m3479drawLineNGM6Ib0$default($this$drawLinearIndicator_u2dqYKTg0g, color, OffsetKt.Offset(adjustedBarStart, yOffset), OffsetKt.Offset(adjustedBarEnd, yOffset), strokeWidth, strokeCap, null, 0.0f, null, 0, 480, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawLinearIndicatorTrack-AZGd3zU, reason: not valid java name */
    public static final void m1670drawLinearIndicatorTrackAZGd3zU(DrawScope $this$drawLinearIndicatorTrack_u2dAZGd3zU, long color, float strokeWidth, int strokeCap) {
        m1669drawLinearIndicatorqYKTg0g($this$drawLinearIndicatorTrack_u2dAZGd3zU, 0.0f, 1.0f, color, strokeWidth, strokeCap);
    }

    /* renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    public static final void m1652CircularProgressIndicatorDUhRLBM(final float progress, Modifier modifier, long color, float strokeWidth, long trackColor, int strokeCap, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long color2;
        float strokeWidth2;
        long trackColor2;
        int i2;
        Modifier.Companion modifier3;
        int $dirty;
        float strokeWidth3;
        int strokeCap2;
        long trackColor3;
        long trackColor4;
        int strokeCap3;
        float strokeWidth4;
        long trackColor5;
        Modifier modifier4;
        long color3;
        int i3;
        int i4;
        Composer $composer2 = $composer.startRestartGroup(-1472321743);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.unit.Dp,5:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)289@11687L13,291@11821L18,*295@12015L7,298@12096L365:ProgressIndicator.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(progress) ? 4 : 2;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                color2 = color;
                if ($composer2.changed(color2)) {
                    i4 = 256;
                    $dirty2 |= i4;
                }
            } else {
                color2 = color;
            }
            i4 = 128;
            $dirty2 |= i4;
        } else {
            color2 = color;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
            strokeWidth2 = strokeWidth;
        } else if (($changed & 7168) == 0) {
            strokeWidth2 = strokeWidth;
            $dirty2 |= $composer2.changed(strokeWidth2) ? 2048 : 1024;
        } else {
            strokeWidth2 = strokeWidth;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                trackColor2 = trackColor;
                if ($composer2.changed(trackColor2)) {
                    i3 = 16384;
                    $dirty2 |= i3;
                }
            } else {
                trackColor2 = trackColor;
            }
            i3 = 8192;
            $dirty2 |= i3;
        } else {
            trackColor2 = trackColor;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i2 = strokeCap;
        } else if ((458752 & $changed) == 0) {
            i2 = strokeCap;
            $dirty2 |= $composer2.changed(i2) ? 131072 : 65536;
        } else {
            i2 = strokeCap;
        }
        if ((374491 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            color3 = color2;
            strokeWidth4 = strokeWidth2;
            trackColor5 = trackColor2;
            strokeCap3 = i2;
            modifier4 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor($composer2, 6);
                    $dirty2 &= -897;
                }
                if (i6 != 0) {
                    strokeWidth2 = ProgressIndicatorDefaults.INSTANCE.m1650getCircularStrokeWidthD9Ej5fM();
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor($composer2, 6);
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    strokeCap2 = ProgressIndicatorDefaults.INSTANCE.m1648getCircularDeterminateStrokeCapKaPHkGw();
                    strokeWidth3 = strokeWidth2;
                    trackColor3 = trackColor2;
                    trackColor4 = color2;
                } else {
                    $dirty = $dirty2;
                    strokeWidth3 = strokeWidth2;
                    strokeCap2 = i2;
                    trackColor3 = trackColor2;
                    trackColor4 = color2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 16) != 0) {
                    $dirty = $dirty2 & (-57345);
                    modifier3 = modifier2;
                    strokeWidth3 = strokeWidth2;
                    strokeCap2 = i2;
                    trackColor3 = trackColor2;
                    trackColor4 = color2;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    strokeWidth3 = strokeWidth2;
                    strokeCap2 = i2;
                    trackColor3 = trackColor2;
                    trackColor4 = color2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1472321743, $changed, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:286)");
            }
            final float coercedProgress = RangesKt.coerceIn(progress, 0.0f, 1.0f);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$CircularProgressIndicator_DUhRLBM_u24lambda_u242 = (Density) consume;
            final Stroke stroke = new Stroke($this$CircularProgressIndicator_DUhRLBM_u24lambda_u242.mo329toPx0680j_4(strokeWidth3), 0.0f, strokeCap2, 0, null, 26, null);
            Modifier modifier5 = modifier3;
            final long j = trackColor3;
            final long j2 = trackColor4;
            CanvasKt.Canvas(SizeKt.m531size3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier5, coercedProgress, null, 0, 6, null), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$1
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
                    Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                    float sweep = coercedProgress * 360.0f;
                    ProgressIndicatorKt.m1666drawCircularIndicatorTrackbw27NRU(Canvas, j, stroke);
                    ProgressIndicatorKt.m1667drawDeterminateCircularIndicator42QJj7c(Canvas, 270.0f, sweep, j2, stroke);
                }
            }, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            strokeCap3 = strokeCap2;
            strokeWidth4 = strokeWidth3;
            trackColor5 = trackColor3;
            modifier4 = modifier5;
            color3 = trackColor4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier4;
        final long j3 = color3;
        final float f = strokeWidth4;
        final long j4 = trackColor5;
        final int i8 = strokeCap3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$2
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

            public final void invoke(Composer composer, int i9) {
                ProgressIndicatorKt.m1652CircularProgressIndicatorDUhRLBM(progress, modifier6, j3, f, j4, i8, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* renamed from: CircularProgressIndicator-LxG7B9w, reason: not valid java name */
    public static final void m1653CircularProgressIndicatorLxG7B9w(Modifier modifier, long color, float strokeWidth, long trackColor, int strokeCap, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        float strokeWidth2;
        long trackColor2;
        int i2;
        long color2;
        Modifier modifier3;
        long color3;
        long trackColor3;
        int strokeCap2;
        float strokeWidth3;
        float strokeWidth4;
        int i3;
        int i4;
        Composer $composer2 = $composer.startRestartGroup(-115871647);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,3:c#ui.unit.Dp,4:c#ui.graphics.Color,2:c#ui.graphics.StrokeCap)330@13521L13,332@13655L18,*335@13799L7,339@13898L28,341@14055L278,353@14447L230,364@14794L345,375@15172L354,386@15531L737:ProgressIndicator.kt#uh7d8r");
        int $dirty = $changed;
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i4 = 32;
                    $dirty |= i4;
                }
            } else {
                j = color;
            }
            i4 = 16;
            $dirty |= i4;
        } else {
            j = color;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty |= 384;
            strokeWidth2 = strokeWidth;
        } else if (($changed & 896) == 0) {
            strokeWidth2 = strokeWidth;
            $dirty |= $composer2.changed(strokeWidth2) ? 256 : 128;
        } else {
            strokeWidth2 = strokeWidth;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                trackColor2 = trackColor;
                if ($composer2.changed(trackColor2)) {
                    i3 = 2048;
                    $dirty |= i3;
                }
            } else {
                trackColor2 = trackColor;
            }
            i3 = 1024;
            $dirty |= i3;
        } else {
            trackColor2 = trackColor;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            i2 = strokeCap;
        } else if ((57344 & $changed) == 0) {
            i2 = strokeCap;
            $dirty |= $composer2.changed(i2) ? 16384 : 8192;
        } else {
            i2 = strokeCap;
        }
        if ((46811 & $dirty) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            color3 = j;
            strokeWidth4 = strokeWidth2;
            trackColor3 = trackColor2;
            strokeCap2 = i2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor($composer2, 6);
                    $dirty &= -113;
                } else {
                    color2 = j;
                }
                if (i6 != 0) {
                    strokeWidth2 = ProgressIndicatorDefaults.INSTANCE.m1650getCircularStrokeWidthD9Ej5fM();
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    trackColor2 = ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor($composer2, 6);
                }
                if (i7 != 0) {
                    modifier3 = modifier4;
                    color3 = color2;
                    strokeCap2 = ProgressIndicatorDefaults.INSTANCE.m1649getCircularIndeterminateStrokeCapKaPHkGw();
                    strokeWidth3 = strokeWidth2;
                    trackColor3 = trackColor2;
                } else {
                    modifier3 = modifier4;
                    color3 = color2;
                    trackColor3 = trackColor2;
                    strokeCap2 = i2;
                    strokeWidth3 = strokeWidth2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                modifier3 = modifier2;
                color3 = j;
                trackColor3 = trackColor2;
                strokeCap2 = i2;
                strokeWidth3 = strokeWidth2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-115871647, $changed, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:328)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$CircularProgressIndicator_LxG7B9w_u24lambda_u243 = (Density) consume;
            final Stroke stroke = new Stroke($this$CircularProgressIndicator_LxG7B9w_u24lambda_u243.mo329toPx0680j_4(strokeWidth3), 0.0f, strokeCap2, 0, null, 26, null);
            InfiniteTransition transition = InfiniteTransitionKt.rememberInfiniteTransition(null, $composer2, 0, 1);
            final State currentRotation = InfiniteTransitionKt.animateValue(transition, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m95infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, $composer2, InfiniteTransition.$stable | 4528 | (InfiniteRepeatableSpec.$stable << 12), 16);
            final State baseRotation = InfiniteTransitionKt.animateFloat(transition, 0.0f, BaseRotationAngle, AnimationSpecKt.m95infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            final State endAngle = InfiniteTransitionKt.animateFloat(transition, 0.0f, JumpRotationAngle, AnimationSpecKt.m95infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$endAngle$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    CubicBezierEasing cubicBezierEasing;
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1332);
                    KeyframesSpec.KeyframeEntity<Float> at = keyframes.at(Float.valueOf(0.0f), 0);
                    cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                    keyframes.with(at, cubicBezierEasing);
                    keyframes.at(Float.valueOf(290.0f), 666);
                }
            }), null, 0L, 6, null), null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            final State startAngle = InfiniteTransitionKt.animateFloat(transition, 0.0f, JumpRotationAngle, AnimationSpecKt.m95infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$startAngle$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    invoke2(keyframesSpecConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
                    CubicBezierEasing cubicBezierEasing;
                    Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
                    keyframes.setDurationMillis(1332);
                    KeyframesSpec.KeyframeEntity<Float> at = keyframes.at(Float.valueOf(0.0f), 666);
                    cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                    keyframes.with(at, cubicBezierEasing);
                    keyframes.at(Float.valueOf(290.0f), keyframes.getDurationMillis());
                }
            }), null, 0L, 6, null), null, $composer2, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            final float strokeWidth5 = strokeWidth3;
            final long j2 = trackColor3;
            final long j3 = color3;
            CanvasKt.Canvas(SizeKt.m531size3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), CircularIndicatorDiameter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$3
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
                    Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                    ProgressIndicatorKt.m1666drawCircularIndicatorTrackbw27NRU(Canvas, j2, stroke);
                    float currentRotationAngleOffset = (currentRotation.getValue().floatValue() * 216.0f) % 360.0f;
                    float sweep = Math.abs(endAngle.getValue().floatValue() - startAngle.getValue().floatValue());
                    float offset = (-90.0f) + currentRotationAngleOffset + baseRotation.getValue().floatValue();
                    ProgressIndicatorKt.m1668drawIndeterminateCircularIndicatorhrjfTZI(Canvas, startAngle.getValue().floatValue() + offset, strokeWidth5, sweep, j3, stroke);
                }
            }, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            strokeWidth4 = strokeWidth5;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final long j4 = color3;
        final float f = strokeWidth4;
        final long j5 = trackColor3;
        final int i8 = strokeCap2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$4
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

            public final void invoke(Composer composer, int i9) {
                ProgressIndicatorKt.m1653CircularProgressIndicatorLxG7B9w(Modifier.this, j4, f, j5, i8, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-MBs18nI, reason: not valid java name */
    public static final /* synthetic */ void m1654CircularProgressIndicatorMBs18nI(final float progress, Modifier modifier, long color, float strokeWidth, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        float f;
        Modifier.Companion modifier3;
        long color2;
        float strokeWidth2;
        Modifier modifier4;
        long color3;
        float strokeWidth3;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(402841196);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.unit.Dp)415@16500L13,422@16713L18,417@16587L219:ProgressIndicator.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(progress) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                j = color;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            j = color;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            f = strokeWidth;
        } else if (($changed & 7168) == 0) {
            f = strokeWidth;
            $dirty |= $composer2.changed(f) ? 2048 : 1024;
        } else {
            f = strokeWidth;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            strokeWidth3 = f;
            color3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor($composer2, 6);
                    $dirty &= -897;
                } else {
                    color2 = j;
                }
                strokeWidth2 = i4 != 0 ? ProgressIndicatorDefaults.INSTANCE.m1650getCircularStrokeWidthD9Ej5fM() : f;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier3 = modifier2;
                color2 = j;
                strokeWidth2 = f;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(402841196, $dirty, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:412)");
            }
            m1652CircularProgressIndicatorDUhRLBM(progress, modifier3, color2, strokeWidth2, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor($composer2, 6), ProgressIndicatorDefaults.INSTANCE.m1648getCircularDeterminateStrokeCapKaPHkGw(), $composer2, 196608 | ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            color3 = color2;
            strokeWidth3 = strokeWidth2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier4;
        final long j2 = color3;
        final float f2 = strokeWidth3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$5
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

            public final void invoke(Composer composer, int i5) {
                ProgressIndicatorKt.m1654CircularProgressIndicatorMBs18nI(progress, modifier5, j2, f2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-aM-cp0Q, reason: not valid java name */
    public static final /* synthetic */ void m1655CircularProgressIndicatoraMcp0Q(Modifier modifier, long color, float strokeWidth, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        float f;
        Modifier.Companion modifier3;
        long color2;
        float strokeWidth2;
        Modifier modifier4;
        long color3;
        float strokeWidth3;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(947193756);
        ComposerKt.sourceInformation($composer2, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.unit.Dp)430@17015L13,436@17214L18,432@17102L207:ProgressIndicator.kt#uh7d8r");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i2 = 32;
                    $dirty |= i2;
                }
            } else {
                j = color;
            }
            i2 = 16;
            $dirty |= i2;
        } else {
            j = color;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            f = strokeWidth;
        } else if (($changed & 896) == 0) {
            f = strokeWidth;
            $dirty |= $composer2.changed(f) ? 256 : 128;
        } else {
            f = strokeWidth;
        }
        if (($dirty & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            strokeWidth3 = f;
            color3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    color2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor($composer2, 6);
                    $dirty &= -113;
                } else {
                    color2 = j;
                }
                strokeWidth2 = i4 != 0 ? ProgressIndicatorDefaults.INSTANCE.m1650getCircularStrokeWidthD9Ej5fM() : f;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                modifier3 = modifier2;
                color2 = j;
                strokeWidth2 = f;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(947193756, $dirty, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:428)");
            }
            m1653CircularProgressIndicatorLxG7B9w(modifier3, color2, strokeWidth2, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor($composer2, 6), ProgressIndicatorDefaults.INSTANCE.m1649getCircularIndeterminateStrokeCapKaPHkGw(), $composer2, ($dirty & 14) | 24576 | ($dirty & 112) | ($dirty & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            color3 = color2;
            strokeWidth3 = strokeWidth2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier4;
        final long j2 = color3;
        final float f2 = strokeWidth3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$6
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

            public final void invoke(Composer composer, int i5) {
                ProgressIndicatorKt.m1655CircularProgressIndicatoraMcp0Q(Modifier.this, j2, f2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m1665drawCircularIndicator42QJj7c(DrawScope $this$drawCircularIndicator_u2d42QJj7c, float startAngle, float sweep, long color, Stroke stroke) {
        float f = 2;
        float diameterOffset = stroke.getWidth() / f;
        float arcDimen = Size.m2779getWidthimpl($this$drawCircularIndicator_u2d42QJj7c.mo3492getSizeNHjbRc()) - (f * diameterOffset);
        DrawScope.m3472drawArcyD3GUKo$default($this$drawCircularIndicator_u2d42QJj7c, color, startAngle, sweep, false, OffsetKt.Offset(diameterOffset, diameterOffset), androidx.compose.ui.geometry.SizeKt.Size(arcDimen, arcDimen), 0.0f, stroke, null, 0, 832, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCircularIndicatorTrack-bw27NRU, reason: not valid java name */
    public static final void m1666drawCircularIndicatorTrackbw27NRU(DrawScope $this$drawCircularIndicatorTrack_u2dbw27NRU, long color, Stroke stroke) {
        m1665drawCircularIndicator42QJj7c($this$drawCircularIndicatorTrack_u2dbw27NRU, 0.0f, 360.0f, color, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawDeterminateCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m1667drawDeterminateCircularIndicator42QJj7c(DrawScope $this$drawDeterminateCircularIndicator_u2d42QJj7c, float startAngle, float sweep, long color, Stroke stroke) {
        m1665drawCircularIndicator42QJj7c($this$drawDeterminateCircularIndicator_u2d42QJj7c, startAngle, sweep, color, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawIndeterminateCircularIndicator-hrjfTZI, reason: not valid java name */
    public static final void m1668drawIndeterminateCircularIndicatorhrjfTZI(DrawScope $this$drawIndeterminateCircularIndicator_u2dhrjfTZI, float startAngle, float strokeWidth, float sweep, long color, Stroke stroke) {
        float strokeCapOffset;
        if (StrokeCap.m3291equalsimpl0(stroke.getCap(), StrokeCap.INSTANCE.m3295getButtKaPHkGw())) {
            strokeCapOffset = 0.0f;
        } else {
            float arg0$iv = CircularIndicatorDiameter;
            float other$iv = strokeWidth / Dp.m5218constructorimpl(arg0$iv / 2);
            strokeCapOffset = (other$iv * 57.29578f) / 2.0f;
        }
        float adjustedStartAngle = startAngle + strokeCapOffset;
        float adjustedSweep = Math.max(sweep, 0.1f);
        m1665drawCircularIndicator42QJj7c($this$drawIndeterminateCircularIndicator_u2dhrjfTZI, adjustedStartAngle, adjustedSweep, color, stroke);
    }

    static {
        float arg0$iv = CircularProgressIndicatorTokens.INSTANCE.m2037getSizeD9Ej5fM();
        float arg0$iv2 = CircularProgressIndicatorTokens.INSTANCE.m2036getActiveIndicatorWidthD9Ej5fM();
        CircularIndicatorDiameter = Dp.m5218constructorimpl(arg0$iv - Dp.m5218constructorimpl(2 * arg0$iv2));
        FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
        FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
        SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
        SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
        CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    }

    public static final float getLinearIndicatorWidth() {
        return LinearIndicatorWidth;
    }

    public static final float getLinearIndicatorHeight() {
        return LinearIndicatorHeight;
    }

    public static final float getCircularIndicatorDiameter() {
        return CircularIndicatorDiameter;
    }
}
