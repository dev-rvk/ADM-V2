package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* compiled from: AnimateAsState.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aK\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aU\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aM\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\b\b\u0002\u0010 \u001a\u00020\u00022\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010!\u001aW\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010\"\u001aC\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010$\u001aM\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010%\u001aK\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u0013\u001a\u00020\b2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aU\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u0013\u001a\u00020\b2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aK\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0013\u001a\u00020\n2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010(\u001aU\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0013\u001a\u00020\n2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010*\u001aK\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\u0006\u0010\u0013\u001a\u00020\f2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010(\u001aU\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\u0006\u0010\u0013\u001a\u00020\f2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010*\u001aC\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u00102\u001aM\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u00103\u001aK\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u0010(\u001aU\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u0010*\u001as\u00107\u001a\b\u0012\u0004\u0012\u0002H80\u0012\"\u0004\b\u0000\u00108\"\b\b\u0001\u00109*\u00020:2\u0006\u0010\u0013\u001a\u0002H82\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H90<2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H80\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u0001H82\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010=\u001a}\u00107\u001a\b\u0012\u0004\u0012\u0002H80\u0012\"\u0004\b\u0000\u00108\"\b\b\u0001\u00109*\u00020:2\u0006\u0010\u0013\u001a\u0002H82\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H90<2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H80\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u0001H82\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010>\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006?²\u0006(\u0010@\u001a\u0010\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\"\u0004\b\u0000\u00108\"\b\b\u0001\u00109*\u00020:X\u008a\u0084\u0002²\u0006 \u0010A\u001a\b\u0012\u0004\u0012\u0002H80\u0015\"\u0004\b\u0000\u00108\"\b\b\u0001\u00109*\u00020:X\u008a\u0084\u0002"}, d2 = {"defaultAnimation", "Landroidx/compose/animation/core/SpringSpec;", "", "dpDefaultSpring", "Landroidx/compose/ui/unit/Dp;", "intDefaultSpring", "", "intOffsetDefaultSpring", "Landroidx/compose/ui/unit/IntOffset;", "intSizeDefaultSpring", "Landroidx/compose/ui/unit/IntSize;", "offsetDefaultSpring", "Landroidx/compose/ui/geometry/Offset;", "rectDefaultSpring", "Landroidx/compose/ui/geometry/Rect;", "sizeDefaultSpring", "Landroidx/compose/ui/geometry/Size;", "animateDpAsState", "Landroidx/compose/runtime/State;", "targetValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "finishedListener", "Lkotlin/Function1;", "", "animateDpAsState-Kz89ssw", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "label", "", "animateDpAsState-AjpBEmI", "(FLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloatAsState", "visibilityThreshold", "(FLandroidx/compose/animation/core/AnimationSpec;FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(FLandroidx/compose/animation/core/AnimationSpec;FLjava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntAsState", "(ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(ILandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntOffsetAsState", "animateIntOffsetAsState-8f6pmRE", "(JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntOffsetAsState-HyPO7BM", "(JLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntSizeAsState", "animateIntSizeAsState-zTRF_AQ", "animateIntSizeAsState-4goxYXU", "animateOffsetAsState", "animateOffsetAsState-N6fFfp4", "animateOffsetAsState-7362WCg", "animateRectAsState", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateSizeAsState", "animateSizeAsState-LjSzlW0", "animateSizeAsState-YLp_XPw", "animateValueAsState", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation-core_release", "listener", "animSpec"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AnimateAsStateKt {
    private static final SpringSpec<Float> defaultAnimation = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
    private static final SpringSpec<Dp> dpDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Dp.m5216boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.INSTANCE)), 3, null);
    private static final SpringSpec<Size> sizeDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Size.m2767boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Size.INSTANCE)), 3, null);
    private static final SpringSpec<Offset> offsetDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Offset.m2699boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.INSTANCE)), 3, null);
    private static final SpringSpec<Rect> rectDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.INSTANCE), 3, null);
    private static final SpringSpec<Integer> intDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Integer.valueOf(VisibilityThresholdsKt.getVisibilityThreshold(IntCompanionObject.INSTANCE)), 3, null);
    private static final SpringSpec<IntOffset> intOffsetDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m5327boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 3, null);
    private static final SpringSpec<IntSize> intSizeDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m5370boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 3, null);

    public static final State<Float> animateFloatAsState(float targetValue, AnimationSpec<Float> animationSpec, float visibilityThreshold, String label, Function1<? super Float, Unit> function1, Composer $composer, int $changed, int i) {
        float visibilityThreshold2;
        String label2;
        Function1 finishedListener;
        AnimationSpec resolvedAnimSpec;
        Object key1$iv;
        $composer.startReplaceableGroup(668842840);
        ComposerKt.sourceInformation($composer, "C(animateFloatAsState)P(3!1,4,2)75@3368L173:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i & 2) != 0 ? defaultAnimation : animationSpec;
        if ((i & 4) == 0) {
            visibilityThreshold2 = visibilityThreshold;
        } else {
            visibilityThreshold2 = 0.01f;
        }
        if ((i & 8) == 0) {
            label2 = label;
        } else {
            label2 = "FloatAnimation";
        }
        if ((i & 16) == 0) {
            finishedListener = function1;
        } else {
            finishedListener = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(668842840, $changed, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:62)");
        }
        $composer.startReplaceableGroup(841393662);
        ComposerKt.sourceInformation($composer, "71@3220L83");
        if (animationSpec2 != defaultAnimation) {
            resolvedAnimSpec = animationSpec2;
        } else {
            Object key1$iv2 = Float.valueOf(visibilityThreshold2);
            int i2 = ($changed >> 6) & 14;
            $composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer.changed(key1$iv2);
            Object it$iv$iv = $composer.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                key1$iv = AnimationSpecKt.spring$default(0.0f, 0.0f, Float.valueOf(visibilityThreshold2), 3, null);
                $composer.updateRememberedValue(key1$iv);
            } else {
                key1$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            resolvedAnimSpec = (AnimationSpec) key1$iv;
        }
        $composer.endReplaceableGroup();
        State<Float> animateValueAsState = animateValueAsState(Float.valueOf(targetValue), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), resolvedAnimSpec, Float.valueOf(visibilityThreshold2), label2, finishedListener, $composer, ($changed & 14) | (($changed << 3) & 7168) | (($changed << 3) & 57344) | (($changed << 3) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValueAsState;
    }

    /* renamed from: animateDpAsState-AjpBEmI, reason: not valid java name */
    public static final State<Dp> m84animateDpAsStateAjpBEmI(float targetValue, AnimationSpec<Dp> animationSpec, String label, Function1<? super Dp, Unit> function1, Composer $composer, int $changed, int i) {
        String label2;
        Function1 finishedListener;
        $composer.startReplaceableGroup(-1407150062);
        ComposerKt.sourceInformation($composer, "C(animateDpAsState)P(3:c#ui.unit.Dp!1,2)114@5081L165:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i & 2) != 0 ? dpDefaultSpring : animationSpec;
        if ((i & 4) == 0) {
            label2 = label;
        } else {
            label2 = "DpAnimation";
        }
        if ((i & 8) == 0) {
            finishedListener = function1;
        } else {
            finishedListener = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1407150062, $changed, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:108)");
        }
        State<Dp> animateValueAsState = animateValueAsState(Dp.m5216boximpl(targetValue), VectorConvertersKt.getVectorConverter(Dp.INSTANCE), animationSpec2, null, label2, finishedListener, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 6) & 57344) | (458752 & ($changed << 6)), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValueAsState;
    }

    /* renamed from: animateSizeAsState-YLp_XPw, reason: not valid java name */
    public static final State<Size> m93animateSizeAsStateYLp_XPw(long targetValue, AnimationSpec<Size> animationSpec, String label, Function1<? super Size, Unit> function1, Composer $composer, int $changed, int i) {
        String label2;
        Function1 finishedListener;
        $composer.startReplaceableGroup(1374633148);
        ComposerKt.sourceInformation($composer, "C(animateSizeAsState)P(3:c#ui.geometry.Size!1,2)155@6928L167:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i & 2) != 0 ? sizeDefaultSpring : animationSpec;
        if ((i & 4) == 0) {
            label2 = label;
        } else {
            label2 = "SizeAnimation";
        }
        if ((i & 8) == 0) {
            finishedListener = function1;
        } else {
            finishedListener = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1374633148, $changed, -1, "androidx.compose.animation.core.animateSizeAsState (AnimateAsState.kt:149)");
        }
        State<Size> animateValueAsState = animateValueAsState(Size.m2767boximpl(targetValue), VectorConvertersKt.getVectorConverter(Size.INSTANCE), animationSpec2, null, label2, finishedListener, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 6) & 57344) | (458752 & ($changed << 6)), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValueAsState;
    }

    /* renamed from: animateOffsetAsState-7362WCg, reason: not valid java name */
    public static final State<Offset> m90animateOffsetAsState7362WCg(long targetValue, AnimationSpec<Offset> animationSpec, String label, Function1<? super Offset, Unit> function1, Composer $composer, int $changed, int i) {
        String label2;
        Function1 finishedListener;
        $composer.startReplaceableGroup(357896800);
        ComposerKt.sourceInformation($composer, "C(animateOffsetAsState)P(3:c#ui.geometry.Offset!1,2)195@8761L169:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i & 2) != 0 ? offsetDefaultSpring : animationSpec;
        if ((i & 4) == 0) {
            label2 = label;
        } else {
            label2 = "OffsetAnimation";
        }
        if ((i & 8) == 0) {
            finishedListener = function1;
        } else {
            finishedListener = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(357896800, $changed, -1, "androidx.compose.animation.core.animateOffsetAsState (AnimateAsState.kt:189)");
        }
        State<Offset> animateValueAsState = animateValueAsState(Offset.m2699boximpl(targetValue), VectorConvertersKt.getVectorConverter(Offset.INSTANCE), animationSpec2, null, label2, finishedListener, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 6) & 57344) | (458752 & ($changed << 6)), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValueAsState;
    }

    public static final State<Rect> animateRectAsState(Rect targetValue, AnimationSpec<Rect> animationSpec, String label, Function1<? super Rect, Unit> function1, Composer $composer, int $changed, int i) {
        String label2;
        Function1 finishedListener;
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        $composer.startReplaceableGroup(536062978);
        ComposerKt.sourceInformation($composer, "C(animateRectAsState)P(3!1,2)236@10633L167:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i & 2) != 0 ? rectDefaultSpring : animationSpec;
        if ((i & 4) == 0) {
            label2 = label;
        } else {
            label2 = "RectAnimation";
        }
        if ((i & 8) == 0) {
            finishedListener = function1;
        } else {
            finishedListener = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(536062978, $changed, -1, "androidx.compose.animation.core.animateRectAsState (AnimateAsState.kt:230)");
        }
        State<Rect> animateValueAsState = animateValueAsState(targetValue, VectorConvertersKt.getVectorConverter(Rect.INSTANCE), animationSpec2, null, label2, finishedListener, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 6) & 57344) | (458752 & ($changed << 6)), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValueAsState;
    }

    public static final State<Integer> animateIntAsState(int targetValue, AnimationSpec<Integer> animationSpec, String label, Function1<? super Integer, Unit> function1, Composer $composer, int $changed, int i) {
        String label2;
        Function1 finishedListener;
        $composer.startReplaceableGroup(428074472);
        ComposerKt.sourceInformation($composer, "C(animateIntAsState)P(3!1,2)274@12363L166:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i & 2) != 0 ? intDefaultSpring : animationSpec;
        if ((i & 4) == 0) {
            label2 = label;
        } else {
            label2 = "IntAnimation";
        }
        if ((i & 8) == 0) {
            finishedListener = function1;
        } else {
            finishedListener = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(428074472, $changed, -1, "androidx.compose.animation.core.animateIntAsState (AnimateAsState.kt:268)");
        }
        State<Integer> animateValueAsState = animateValueAsState(Integer.valueOf(targetValue), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), animationSpec2, null, label2, finishedListener, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 6) & 57344) | (458752 & ($changed << 6)), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValueAsState;
    }

    /* renamed from: animateIntOffsetAsState-HyPO7BM, reason: not valid java name */
    public static final State<IntOffset> m87animateIntOffsetAsStateHyPO7BM(long targetValue, AnimationSpec<IntOffset> animationSpec, String label, Function1<? super IntOffset, Unit> function1, Composer $composer, int $changed, int i) {
        String label2;
        Function1 finishedListener;
        $composer.startReplaceableGroup(-696782904);
        ComposerKt.sourceInformation($composer, "C(animateIntOffsetAsState)P(3:c#ui.unit.IntOffset!1,2)314@14224L172:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i & 2) != 0 ? intOffsetDefaultSpring : animationSpec;
        if ((i & 4) == 0) {
            label2 = label;
        } else {
            label2 = "IntOffsetAnimation";
        }
        if ((i & 8) == 0) {
            finishedListener = function1;
        } else {
            finishedListener = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-696782904, $changed, -1, "androidx.compose.animation.core.animateIntOffsetAsState (AnimateAsState.kt:308)");
        }
        State<IntOffset> animateValueAsState = animateValueAsState(IntOffset.m5327boximpl(targetValue), VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE), animationSpec2, null, label2, finishedListener, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 6) & 57344) | (458752 & ($changed << 6)), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValueAsState;
    }

    /* renamed from: animateIntSizeAsState-4goxYXU, reason: not valid java name */
    public static final State<IntSize> m88animateIntSizeAsState4goxYXU(long targetValue, AnimationSpec<IntSize> animationSpec, String label, Function1<? super IntSize, Unit> function1, Composer $composer, int $changed, int i) {
        String label2;
        Function1 finishedListener;
        $composer.startReplaceableGroup(582576328);
        ComposerKt.sourceInformation($composer, "C(animateIntSizeAsState)P(3:c#ui.unit.IntSize!1,2)352@16009L170:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i & 2) != 0 ? intSizeDefaultSpring : animationSpec;
        if ((i & 4) == 0) {
            label2 = label;
        } else {
            label2 = "IntSizeAnimation";
        }
        if ((i & 8) == 0) {
            finishedListener = function1;
        } else {
            finishedListener = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(582576328, $changed, -1, "androidx.compose.animation.core.animateIntSizeAsState (AnimateAsState.kt:346)");
        }
        State<IntSize> animateValueAsState = animateValueAsState(IntSize.m5370boximpl(targetValue), VectorConvertersKt.getVectorConverter(IntSize.INSTANCE), animationSpec2, null, label2, finishedListener, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 6) & 57344) | (458752 & ($changed << 6)), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValueAsState;
    }

    public static final <T, V extends AnimationVector> State<T> animateValueAsState(final T t, TwoWayConverter<T, V> typeConverter, AnimationSpec<T> animationSpec, T t2, String label, Function1<? super T, Unit> function1, Composer $composer, int $changed, int i) {
        AnimationSpec animationSpec2;
        Object value$iv$iv;
        Object value$iv$iv2;
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        $composer.startReplaceableGroup(-1994373980);
        ComposerKt.sourceInformation($composer, "C(animateValueAsState)P(3,4!1,5,2)393@18031L21,399@18213L44,400@18279L79,401@18379L38,402@18456L339,413@18814L42,414@18861L55,417@18921L721:AnimateAsState.kt#pdpnli");
        if ((i & 4) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                $composer.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            animationSpec2 = (AnimationSpec) value$iv$iv2;
        } else {
            animationSpec2 = animationSpec;
        }
        Object visibilityThreshold = (i & 8) != 0 ? null : t2;
        String label2 = (i & 16) != 0 ? "ValueAnimation" : label;
        Function1 finishedListener = (i & 32) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1994373980, $changed, -1, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:390)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv2 = $composer.rememberedValue();
        if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        MutableState toolingOverride = (MutableState) value$iv$iv;
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object value$iv$iv3 = $composer.rememberedValue();
        if (value$iv$iv3 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv3 = new Animatable(t, typeConverter, visibilityThreshold, label2);
            $composer.updateRememberedValue(value$iv$iv3);
        }
        $composer.endReplaceableGroup();
        Animatable animatable = (Animatable) value$iv$iv3;
        State listener$delegate = SnapshotStateKt.rememberUpdatedState(finishedListener, $composer, ($changed >> 15) & 14);
        AnimationSpec $this$animateValueAsState_u24lambda_u245 = animationSpec2;
        State animSpec$delegate = SnapshotStateKt.rememberUpdatedState((visibilityThreshold == null || !($this$animateValueAsState_u24lambda_u245 instanceof SpringSpec) || Intrinsics.areEqual(((SpringSpec) $this$animateValueAsState_u24lambda_u245).getVisibilityThreshold(), visibilityThreshold)) ? $this$animateValueAsState_u24lambda_u245 : AnimationSpecKt.spring(((SpringSpec) $this$animateValueAsState_u24lambda_u245).getDampingRatio(), ((SpringSpec) $this$animateValueAsState_u24lambda_u245).getStiffness(), visibilityThreshold), $composer, 0);
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object value$iv$iv4 = $composer.rememberedValue();
        if (value$iv$iv4 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv4 = ChannelKt.Channel$default(-1, null, null, 6, null);
            $composer.updateRememberedValue(value$iv$iv4);
        }
        $composer.endReplaceableGroup();
        final Channel channel = (Channel) value$iv$iv4;
        EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                channel.mo7116trySendJP2dKIU(t);
            }
        }, $composer, 0);
        EffectsKt.LaunchedEffect(channel, new AnimateAsStateKt$animateValueAsState$3(channel, animatable, animSpec$delegate, listener$delegate, null), $composer, 72);
        State<T> state = (State) toolingOverride.getValue();
        if (state == null) {
            state = animatable.asState();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Function1<T, Unit> animateValueAsState$lambda$4(State<? extends Function1<? super T, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> AnimationSpec<T> animateValueAsState$lambda$6(State<? extends AnimationSpec<T>> state) {
        Object thisObj$iv = state.getValue();
        return (AnimationSpec) thisObj$iv;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateFloatAsState(float targetValue, AnimationSpec animationSpec, float visibilityThreshold, Function1 finishedListener, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(1091643291);
        ComposerKt.sourceInformation($composer, "C(animateFloatAsState)P(2!1,3)446@20047L143:AnimateAsState.kt#pdpnli");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = defaultAnimation;
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            visibilityThreshold = 0.01f;
        }
        if ((i & 8) != 0) {
            finishedListener = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1091643291, $changed, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:441)");
        }
        State<Float> animateFloatAsState = animateFloatAsState(targetValue, animationSpec, visibilityThreshold, null, finishedListener, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | (($changed << 3) & 57344), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateFloatAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* renamed from: animateDpAsState-Kz89ssw, reason: not valid java name */
    public static final /* synthetic */ State m85animateDpAsStateKz89ssw(float targetValue, AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(704104481);
        ComposerKt.sourceInformation($composer, "C(animateDpAsState)P(2:c#ui.unit.Dp)463@20491L142:AnimateAsState.kt#pdpnli");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = dpDefaultSpring;
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            finishedListener = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(704104481, $changed, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:458)");
        }
        State animateValueAsState = animateValueAsState(Dp.m5216boximpl(targetValue), VectorConvertersKt.getVectorConverter(Dp.INSTANCE), animationSpec, null, null, finishedListener, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* renamed from: animateSizeAsState-LjSzlW0, reason: not valid java name */
    public static final /* synthetic */ State m92animateSizeAsStateLjSzlW0(long targetValue, AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i) {
        Function1 finishedListener2;
        $composer.startReplaceableGroup(875212471);
        ComposerKt.sourceInformation($composer, "C(animateSizeAsState)P(2:c#ui.geometry.Size)481@20948L144:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i & 2) != 0 ? sizeDefaultSpring : animationSpec;
        if ((i & 4) == 0) {
            finishedListener2 = finishedListener;
        } else {
            finishedListener2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(875212471, $changed, -1, "androidx.compose.animation.core.animateSizeAsState (AnimateAsState.kt:476)");
        }
        State animateValueAsState = animateValueAsState(Size.m2767boximpl(targetValue), VectorConvertersKt.getVectorConverter(Size.INSTANCE), animationSpec2, null, null, finishedListener2, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* renamed from: animateOffsetAsState-N6fFfp4, reason: not valid java name */
    public static final /* synthetic */ State m91animateOffsetAsStateN6fFfp4(long targetValue, AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i) {
        Function1 finishedListener2;
        $composer.startReplaceableGroup(-456513133);
        ComposerKt.sourceInformation($composer, "C(animateOffsetAsState)P(2:c#ui.geometry.Offset)499@21419L122:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i & 2) != 0 ? offsetDefaultSpring : animationSpec;
        if ((i & 4) == 0) {
            finishedListener2 = finishedListener;
        } else {
            finishedListener2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-456513133, $changed, -1, "androidx.compose.animation.core.animateOffsetAsState (AnimateAsState.kt:494)");
        }
        State animateValueAsState = animateValueAsState(Offset.m2699boximpl(targetValue), VectorConvertersKt.getVectorConverter(Offset.INSTANCE), animationSpec2, null, null, finishedListener2, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateRectAsState(Rect targetValue, AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        $composer.startReplaceableGroup(-782613967);
        ComposerKt.sourceInformation($composer, "C(animateRectAsState)P(2)514@21856L120:AnimateAsState.kt#pdpnli");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = rectDefaultSpring;
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            finishedListener = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-782613967, $changed, -1, "androidx.compose.animation.core.animateRectAsState (AnimateAsState.kt:509)");
        }
        State animateValueAsState = animateValueAsState(targetValue, VectorConvertersKt.getVectorConverter(Rect.INSTANCE), animationSpec, null, null, finishedListener, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateIntAsState(int targetValue, AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(-842612981);
        ComposerKt.sourceInformation($composer, "C(animateIntAsState)P(2)529@22285L119:AnimateAsState.kt#pdpnli");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = intDefaultSpring;
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            finishedListener = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-842612981, $changed, -1, "androidx.compose.animation.core.animateIntAsState (AnimateAsState.kt:524)");
        }
        State animateValueAsState = animateValueAsState(Integer.valueOf(targetValue), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), animationSpec, null, null, finishedListener, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* renamed from: animateIntOffsetAsState-8f6pmRE, reason: not valid java name */
    public static final /* synthetic */ State m86animateIntOffsetAsState8f6pmRE(long targetValue, AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i) {
        Function1 finishedListener2;
        $composer.startReplaceableGroup(1010307371);
        ComposerKt.sourceInformation($composer, "C(animateIntOffsetAsState)P(2:c#ui.unit.IntOffset)544@22749L125:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i & 2) != 0 ? intOffsetDefaultSpring : animationSpec;
        if ((i & 4) == 0) {
            finishedListener2 = finishedListener;
        } else {
            finishedListener2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1010307371, $changed, -1, "androidx.compose.animation.core.animateIntOffsetAsState (AnimateAsState.kt:539)");
        }
        State animateValueAsState = animateValueAsState(IntOffset.m5327boximpl(targetValue), VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE), animationSpec2, null, null, finishedListener2, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* renamed from: animateIntSizeAsState-zTRF_AQ, reason: not valid java name */
    public static final /* synthetic */ State m89animateIntSizeAsStatezTRF_AQ(long targetValue, AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i) {
        Function1 finishedListener2;
        $composer.startReplaceableGroup(-1749239765);
        ComposerKt.sourceInformation($composer, "C(animateIntSizeAsState)P(2:c#ui.unit.IntSize)559@23207L123:AnimateAsState.kt#pdpnli");
        AnimationSpec animationSpec2 = (i & 2) != 0 ? intSizeDefaultSpring : animationSpec;
        if ((i & 4) == 0) {
            finishedListener2 = finishedListener;
        } else {
            finishedListener2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1749239765, $changed, -1, "androidx.compose.animation.core.animateIntSizeAsState (AnimateAsState.kt:554)");
        }
        State animateValueAsState = animateValueAsState(IntSize.m5370boximpl(targetValue), VectorConvertersKt.getVectorConverter(IntSize.INSTANCE), animationSpec2, null, null, finishedListener2, $composer, ($changed & 14) | (($changed << 3) & 896) | (($changed << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateValueAsState(Object targetValue, TwoWayConverter typeConverter, AnimationSpec animationSpec, Object visibilityThreshold, Function1 finishedListener, Composer $composer, int $changed, int i) {
        AnimationSpec animationSpec2;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        $composer.startReplaceableGroup(-846382129);
        ComposerKt.sourceInformation($composer, "C(animateValueAsState)P(2,3!1,4)572@23613L21,575@23730L240:AnimateAsState.kt#pdpnli");
        if ((i & 4) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            animationSpec2 = (AnimationSpec) value$iv$iv;
        } else {
            animationSpec2 = animationSpec;
        }
        Object visibilityThreshold2 = (i & 8) != 0 ? null : visibilityThreshold;
        Function1 finishedListener2 = (i & 16) != 0 ? null : finishedListener;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-846382129, $changed, -1, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:569)");
        }
        State animateValueAsState = animateValueAsState(targetValue, typeConverter, animationSpec2, visibilityThreshold2, "ValueAnimation", finishedListener2, $composer, ($changed & 8) | 24576 | ($changed & 14) | ($changed & 112) | ($changed & 896) | (($changed & 8) << 9) | ($changed & 7168) | (($changed << 3) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValueAsState;
    }
}
