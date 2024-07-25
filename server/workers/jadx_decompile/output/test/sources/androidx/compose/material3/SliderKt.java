package androidx.compose.material3;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.GestureCancellationException;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Slider.kt */
@Metadata(d1 = {"\u0000ª\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aä\u0001\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0018\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\u0019\b\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\u0019\b\u0002\u0010)\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\u0019\b\u0002\u0010*\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010-\u001a\u007f\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0018\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010+\u001a\u00020,2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007¢\u0006\u0002\u0010.\u001aÈ\u0001\u0010/\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0018\u0012\u0004\u0012\u00020\u00160\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010+\u001a\u00020,2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(H\u0003¢\u0006\u0002\u00100\u001a³\u0001\u00101\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00102\u001a\u00020$2\u0019\b\u0002\u00103\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\u0019\b\u0002\u0010*\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00104\u001a}\u00101\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010+\u001a\u00020,2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00102\u001a\u00020$H\u0007¢\u0006\u0002\u00105\u001a\u0099\u0001\u00106\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00102\u001a\u00020$2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0017\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(2\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b(H\u0003¢\u0006\u0002\u00107\u001a1\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010>\u001a \u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH\u0002\u001a0\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bH\u0002\u001a<\u0010C\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bH\u0002\u001a(\u0010J\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\bH\u0002\u001a\u0010\u0010O\u001a\u00020L2\u0006\u0010+\u001a\u00020,H\u0002\u001a;\u0010P\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020\b\u0018\u00010Q*\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0082@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bX\u0010Y\u001a\u0098\u0001\u0010Z\u001a\u00020\u0001*\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\b0\\2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\b0\\2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020\u001d2\u0006\u0010N\u001a\u00020,2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0018\u0010_\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00160\u001a0\\2\u001e\u0010`\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160a0\\H\u0002\u001a\\\u0010b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010+\u001a\u00020,H\u0002\u001ad\u0010c\u001a\u00020\u0001*\u00020\u00012\u0006\u00109\u001a\u00020:2\u0006\u00102\u001a\u00020$2\u0006\u0010N\u001a\u00020,2\u0006\u0010^\u001a\u00020\u001d2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\b0\\2\u0012\u0010_\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160 0\\2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\b0f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u000b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\f\u001a\u00020\rX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000e\"\u0019\u0010\u000f\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\u0011\"\u0013\u0010\u0012\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u0013\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0014\u0010\u0011\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006g"}, d2 = {"DefaultSliderConstraints", "Landroidx/compose/ui/Modifier;", "SliderHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SliderMinWidth", "SliderToTickAnimation", "Landroidx/compose/animation/core/TweenSpec;", "", "ThumbDefaultElevation", "ThumbHeight", "ThumbPressedElevation", "ThumbSize", "Landroidx/compose/ui/unit/DpSize;", "J", "ThumbWidth", "getThumbWidth", "()F", "TickSize", "TrackHeight", "getTrackHeight", "RangeSlider", "", "value", "Lkotlin/ranges/ClosedFloatingPointRange;", "onValueChange", "Lkotlin/Function1;", "modifier", "enabled", "", "valueRange", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material3/SliderColors;", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumb", "Landroidx/compose/material3/SliderPositions;", "Landroidx/compose/runtime/Composable;", "endThumb", "track", "steps", "", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ILandroidx/compose/runtime/Composer;III)V", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "(Landroidx/compose/ui/Modifier;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Slider", "interactionSource", "thumb", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ILandroidx/compose/runtime/Composer;III)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;IFLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "animateToTarget", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "current", "target", "velocity", "(Landroidx/compose/foundation/gestures/DraggableState;FFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calcFraction", "a", "b", "pos", "scale", "a1", "b1", "x1", "a2", "b2", "x", "snapValueToTick", "tickFractions", "", "minPx", "maxPx", "stepsToTickFractions", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderPressDragModifier", "rawOffsetStart", "Landroidx/compose/runtime/State;", "rawOffsetEnd", "isRtl", "gestureEndAction", "onDrag", "Lkotlin/Function2;", "sliderSemantics", "sliderTapModifier", "rawOffset", "pressOffset", "Landroidx/compose/runtime/MutableState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SliderKt {
    private static final float ThumbWidth = SliderTokens.INSTANCE.m2435getHandleWidthD9Ej5fM();
    private static final float ThumbHeight = SliderTokens.INSTANCE.m2434getHandleHeightD9Ej5fM();
    private static final long ThumbSize = DpKt.m5240DpSizeYgX7TsA(ThumbWidth, ThumbHeight);
    private static final float ThumbDefaultElevation = Dp.m5218constructorimpl(1);
    private static final float ThumbPressedElevation = Dp.m5218constructorimpl(6);
    private static final float TickSize = SliderTokens.INSTANCE.m2441getTickMarksContainerSizeD9Ej5fM();
    private static final float TrackHeight = SliderTokens.INSTANCE.m2436getInactiveTrackHeightD9Ej5fM();
    private static final float SliderHeight = Dp.m5218constructorimpl(48);
    private static final float SliderMinWidth = Dp.m5218constructorimpl(144);
    private static final Modifier DefaultSliderConstraints = SizeKt.m519heightInVpY3zN4$default(SizeKt.m538widthInVpY3zN4$default(Modifier.INSTANCE, SliderMinWidth, 0.0f, 2, null), 0.0f, SliderHeight, 1, null);
    private static final TweenSpec<Float> SliderToTickAnimation = new TweenSpec<>(100, 0, null, 6, null);

    public static final void Slider(final float value, final Function1<? super Float, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> closedFloatingPointRange, int steps, Function0<Unit> function0, SliderColors colors, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        ClosedFloatingPointRange closedFloatingPointRange2;
        int i2;
        Function0 function02;
        SliderColors colors2;
        ClosedFloatingPointRange valueRange;
        Modifier modifier2;
        final boolean enabled2;
        ClosedFloatingPointRange valueRange2;
        int steps2;
        final SliderColors colors3;
        Function0 onValueChangeFinished;
        final int $dirty;
        final MutableInteractionSource interactionSource2;
        Object value$iv$iv;
        MutableInteractionSource interactionSource3;
        SliderColors colors4;
        boolean enabled3;
        Composer $composer2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-202044027);
        ComposerKt.sourceInformation($composer3, "C(Slider)P(7,4,3,1,8,6,5)155@7443L8,156@7503L39,160@7603L705:Slider.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                closedFloatingPointRange2 = closedFloatingPointRange;
                if ($composer3.changed(closedFloatingPointRange2)) {
                    i4 = 16384;
                    $dirty2 |= i4;
                }
            } else {
                closedFloatingPointRange2 = closedFloatingPointRange;
            }
            i4 = 8192;
            $dirty2 |= i4;
        } else {
            closedFloatingPointRange2 = closedFloatingPointRange;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i2 = steps;
        } else if (($changed & 458752) == 0) {
            i2 = steps;
            $dirty2 |= $composer3.changed(i2) ? 131072 : 65536;
        } else {
            i2 = steps;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty2 |= 1572864;
            function02 = function0;
        } else if (($changed & 3670016) == 0) {
            function02 = function0;
            $dirty2 |= $composer3.changedInstance(function02) ? 1048576 : 524288;
        } else {
            function02 = function0;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0) {
                colors2 = colors;
                if ($composer3.changed(colors2)) {
                    i3 = 8388608;
                    $dirty2 |= i3;
                }
            } else {
                colors2 = colors;
            }
            i3 = 4194304;
            $dirty2 |= i3;
        } else {
            colors2 = colors;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 191739611) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            enabled3 = enabled;
            interactionSource3 = interactionSource;
            colors4 = colors2;
            valueRange2 = closedFloatingPointRange2;
            onValueChangeFinished = function02;
            $composer2 = $composer3;
            steps2 = i2;
            modifier2 = modifier;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i5 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i6 != 0 ? true : enabled;
                if ((i & 16) != 0) {
                    valueRange = RangesKt.rangeTo(0.0f, 1.0f);
                    $dirty2 &= -57345;
                } else {
                    valueRange = closedFloatingPointRange2;
                }
                int steps3 = i7 != 0 ? 0 : i2;
                Function0 onValueChangeFinished2 = i8 != 0 ? null : function02;
                if ((i & 128) != 0) {
                    colors2 = SliderDefaults.INSTANCE.m1702colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 6, 1023);
                    $dirty2 &= -29360129;
                }
                if (i9 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    int $dirty3 = $dirty2;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    modifier2 = modifier3;
                    enabled2 = enabled4;
                    valueRange2 = valueRange;
                    steps2 = steps3;
                    colors3 = colors2;
                    onValueChangeFinished = onValueChangeFinished2;
                    $dirty = $dirty3;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    modifier2 = modifier3;
                    enabled2 = enabled4;
                    valueRange2 = valueRange;
                    steps2 = steps3;
                    colors3 = colors2;
                    onValueChangeFinished = onValueChangeFinished2;
                    $dirty = $dirty2;
                    interactionSource2 = interactionSource;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 128) != 0) {
                    colors3 = colors2;
                    valueRange2 = closedFloatingPointRange2;
                    onValueChangeFinished = function02;
                    steps2 = i2;
                    modifier2 = modifier;
                    enabled2 = enabled;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty2 & (-29360129);
                } else {
                    colors3 = colors2;
                    valueRange2 = closedFloatingPointRange2;
                    onValueChangeFinished = function02;
                    steps2 = i2;
                    modifier2 = modifier;
                    enabled2 = enabled;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-202044027, $dirty, -1, "androidx.compose.material3.Slider (Slider.kt:146)");
            }
            if (!(steps2 >= 0)) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            interactionSource3 = interactionSource2;
            colors4 = colors3;
            enabled3 = enabled2;
            $composer2 = $composer3;
            SliderImpl(modifier2, enabled2, interactionSource2, onValueChange, onValueChangeFinished, steps2, value, valueRange2, ComposableLambdaKt.composableLambda($composer3, -1522452856, true, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                    invoke(sliderPositions, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SliderPositions it, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer4, "C170@7936L142:Slider.kt#uh7d8r");
                    if (($changed2 & 81) != 16 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1522452856, $changed2, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:169)");
                        }
                        SliderDefaults.INSTANCE.m1701Thumb9LiSoMs(MutableInteractionSource.this, null, colors3, enabled2, 0L, $composer4, (($dirty >> 24) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (($dirty >> 15) & 896) | ($dirty & 7168), 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), ComposableLambdaKt.composableLambda($composer3, 686671625, true, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                    invoke(sliderPositions, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SliderPositions sliderPositions, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(sliderPositions, "sliderPositions");
                    ComposerKt.sourceInformation($composer4, "C177@8154L138:Slider.kt#uh7d8r");
                    int $dirty4 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty4 |= $composer4.changed(sliderPositions) ? 4 : 2;
                    }
                    if (($dirty4 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(686671625, $dirty4, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:176)");
                        }
                        SliderDefaults.INSTANCE.Track(sliderPositions, null, SliderColors.this, enabled2, $composer4, ($dirty4 & 14) | 24576 | (($dirty >> 15) & 896) | ($dirty & 7168), 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer3, (($dirty >> 6) & 14) | 905969664 | (($dirty >> 6) & 112) | (($dirty >> 18) & 896) | (($dirty << 6) & 7168) | (($dirty >> 6) & 57344) | (458752 & $dirty) | (($dirty << 18) & 3670016) | (($dirty << 9) & 29360128));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier2;
        final boolean z = enabled3;
        final ClosedFloatingPointRange closedFloatingPointRange3 = valueRange2;
        final int i10 = steps2;
        final Function0 function03 = onValueChangeFinished;
        final SliderColors sliderColors = colors4;
        final MutableInteractionSource mutableInteractionSource = interactionSource3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$5
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

            public final void invoke(Composer composer, int i11) {
                SliderKt.Slider(value, onValueChange, modifier4, z, closedFloatingPointRange3, i10, function03, sliderColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public static final void Slider(final float value, final Function1<? super Float, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> closedFloatingPointRange, Function0<Unit> function0, SliderColors colors, MutableInteractionSource interactionSource, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function32, int steps, Composer $composer, final int $changed, final int $changed1, final int i) {
        ClosedFloatingPointRange closedFloatingPointRange2;
        ClosedFloatingPointRange valueRange;
        final SliderColors colors2;
        Modifier modifier2;
        final MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        boolean z;
        Function3 thumb;
        int steps2;
        Function3 thumb2;
        Function3 track;
        boolean enabled2;
        ClosedFloatingPointRange valueRange2;
        Function0 onValueChangeFinished;
        SliderColors colors3;
        MutableInteractionSource interactionSource4;
        Modifier modifier3;
        int $dirty;
        Object value$iv$iv;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer2 = $composer.startRestartGroup(251663723);
        ComposerKt.sourceInformation($composer2, "C(Slider)P(9,4,3,1,10,5!2,7,8)250@11737L8,251@11797L39,271@12381L338:Slider.kt#uh7d8r");
        final int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changedInstance(onValueChange) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer2.changed(enabled) ? 2048 : 1024;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                closedFloatingPointRange2 = closedFloatingPointRange;
                if ($composer2.changed(closedFloatingPointRange2)) {
                    i3 = 16384;
                    $dirty2 |= i3;
                }
            } else {
                closedFloatingPointRange2 = closedFloatingPointRange;
            }
            i3 = 8192;
            $dirty2 |= i3;
        } else {
            closedFloatingPointRange2 = closedFloatingPointRange;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 131072 : 65536;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0 && $composer2.changed(colors)) {
                i2 = 1048576;
                $dirty2 |= i2;
            }
            i2 = 524288;
            $dirty2 |= i2;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty2 |= $composer2.changed(interactionSource) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty2 |= $composer2.changedInstance(function32) ? 536870912 : 268435456;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer2.changed(steps) ? 4 : 2;
        }
        if (($dirty2 & 1533916891) == 306783378 && ($dirty1 & 11) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            enabled2 = enabled;
            onValueChangeFinished = function0;
            colors3 = colors;
            interactionSource4 = interactionSource;
            thumb2 = function3;
            track = function32;
            steps2 = steps;
            valueRange2 = closedFloatingPointRange2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i4 != 0 ? Modifier.INSTANCE : modifier;
                final boolean enabled3 = i5 != 0 ? true : enabled;
                if ((i & 16) != 0) {
                    valueRange = RangesKt.rangeTo(0.0f, 1.0f);
                    $dirty2 &= -57345;
                } else {
                    valueRange = closedFloatingPointRange2;
                }
                Function0 onValueChangeFinished2 = i6 != 0 ? null : function0;
                if ((i & 64) != 0) {
                    colors2 = SliderDefaults.INSTANCE.m1702colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, 6, 1023);
                    $dirty2 &= -3670017;
                } else {
                    colors2 = colors;
                }
                if (i7 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer2.rememberedValue();
                    modifier2 = modifier4;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    modifier2 = modifier4;
                    interactionSource2 = interactionSource;
                }
                if (i8 != 0) {
                    Function3<SliderPositions, Composer, Integer, Unit> function33 = new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$7
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                            invoke(sliderPositions, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SliderPositions it, Composer $composer3, int $changed2) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            ComposerKt.sourceInformation($composer3, "C253@11914L126:Slider.kt#uh7d8r");
                            if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1998248322, $changed2, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:252)");
                                }
                                SliderDefaults.INSTANCE.m1701Thumb9LiSoMs(MutableInteractionSource.this, null, colors2, enabled3, 0L, $composer3, (($dirty2 >> 21) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (($dirty2 >> 12) & 896) | ($dirty2 & 7168), 18);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer3.skipToGroupEnd();
                        }
                    };
                    interactionSource3 = interactionSource2;
                    z = true;
                    thumb = ComposableLambdaKt.composableLambda($composer2, 1998248322, true, function33);
                } else {
                    interactionSource3 = interactionSource2;
                    z = true;
                    thumb = function3;
                }
                Function3 track2 = i9 != 0 ? ComposableLambdaKt.composableLambda($composer2, 1543282935, z, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$8
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                        invoke(sliderPositions, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SliderPositions sliderPositions, Composer $composer3, int $changed2) {
                        Intrinsics.checkNotNullParameter(sliderPositions, "sliderPositions");
                        ComposerKt.sourceInformation($composer3, "C260@12143L122:Slider.kt#uh7d8r");
                        int $dirty3 = $changed2;
                        if (($changed2 & 14) == 0) {
                            $dirty3 |= $composer3.changed(sliderPositions) ? 4 : 2;
                        }
                        if (($dirty3 & 91) != 18 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1543282935, $dirty3, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:259)");
                            }
                            SliderDefaults.INSTANCE.Track(sliderPositions, null, SliderColors.this, enabled3, $composer3, ($dirty3 & 14) | 24576 | (($dirty2 >> 12) & 896) | ($dirty2 & 7168), 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }) : function32;
                if (i10 != 0) {
                    thumb2 = thumb;
                    track = track2;
                    steps2 = 0;
                    enabled2 = enabled3;
                    valueRange2 = valueRange;
                    onValueChangeFinished = onValueChangeFinished2;
                    colors3 = colors2;
                    interactionSource4 = interactionSource3;
                    modifier3 = modifier2;
                    $dirty = $dirty2;
                } else {
                    steps2 = steps;
                    thumb2 = thumb;
                    track = track2;
                    enabled2 = enabled3;
                    valueRange2 = valueRange;
                    onValueChangeFinished = onValueChangeFinished2;
                    colors3 = colors2;
                    interactionSource4 = interactionSource3;
                    modifier3 = modifier2;
                    $dirty = $dirty2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 64) != 0) {
                    modifier3 = modifier;
                    enabled2 = enabled;
                    onValueChangeFinished = function0;
                    colors3 = colors;
                    interactionSource4 = interactionSource;
                    thumb2 = function3;
                    track = function32;
                    steps2 = steps;
                    valueRange2 = closedFloatingPointRange2;
                    $dirty = (-3670017) & $dirty2;
                    z = true;
                } else {
                    modifier3 = modifier;
                    enabled2 = enabled;
                    onValueChangeFinished = function0;
                    colors3 = colors;
                    interactionSource4 = interactionSource;
                    thumb2 = function3;
                    track = function32;
                    steps2 = steps;
                    valueRange2 = closedFloatingPointRange2;
                    z = true;
                    $dirty = $dirty2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(251663723, $dirty, $dirty1, "androidx.compose.material3.Slider (Slider.kt:243)");
            }
            if (!(steps2 >= 0 ? z : false)) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            SliderImpl(modifier3, enabled2, interactionSource4, onValueChange, onValueChangeFinished, steps2, value, valueRange2, thumb2, track, $composer2, (($dirty >> 6) & 14) | (($dirty >> 6) & 112) | (($dirty >> 15) & 896) | (($dirty << 6) & 7168) | (($dirty >> 3) & 57344) | (($dirty1 << 15) & 458752) | (($dirty << 18) & 3670016) | (($dirty << 9) & 29360128) | ($dirty & 234881024) | ($dirty & 1879048192));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final boolean z2 = enabled2;
        final ClosedFloatingPointRange closedFloatingPointRange3 = valueRange2;
        final Function0 function02 = onValueChangeFinished;
        final SliderColors sliderColors = colors3;
        final MutableInteractionSource mutableInteractionSource = interactionSource4;
        final Function3 function34 = thumb2;
        final Function3 function35 = track;
        final int i11 = steps2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$10
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

            public final void invoke(Composer composer, int i12) {
                SliderKt.Slider(value, onValueChange, modifier5, z2, closedFloatingPointRange3, function02, sliderColors, mutableInteractionSource, function34, function35, i11, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    public static final void RangeSlider(final ClosedFloatingPointRange<Float> value, final Function1<? super ClosedFloatingPointRange<Float>, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> closedFloatingPointRange, int steps, Function0<Unit> function0, SliderColors colors, Composer $composer, final int $changed, final int i) {
        boolean enabled2;
        ClosedFloatingPointRange valueRange;
        int steps2;
        Function0 onValueChangeFinished;
        SliderColors sliderColors;
        Modifier modifier2;
        final int $dirty;
        ClosedFloatingPointRange valueRange2;
        Function0 onValueChangeFinished2;
        int steps3;
        final boolean enabled3;
        final SliderColors colors2;
        Object value$iv$iv;
        Object value$iv$iv2;
        SliderColors colors3;
        boolean enabled4;
        Composer $composer2;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-743091416);
        ComposerKt.sourceInformation($composer3, "C(RangeSlider)P(6,3,2,1,7,5,4)328@15054L8,330@15126L39,331@15223L39,335@15320L988:Slider.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 7168) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                valueRange = closedFloatingPointRange;
                if ($composer3.changed(valueRange)) {
                    i3 = 16384;
                    $dirty2 |= i3;
                }
            } else {
                valueRange = closedFloatingPointRange;
            }
            i3 = 8192;
            $dirty2 |= i3;
        } else {
            valueRange = closedFloatingPointRange;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            steps2 = steps;
        } else if (($changed & 458752) == 0) {
            steps2 = steps;
            $dirty2 |= $composer3.changed(steps2) ? 131072 : 65536;
        } else {
            steps2 = steps;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            onValueChangeFinished = function0;
        } else if (($changed & 3670016) == 0) {
            onValueChangeFinished = function0;
            $dirty2 |= $composer3.changedInstance(onValueChangeFinished) ? 1048576 : 524288;
        } else {
            onValueChangeFinished = function0;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0) {
                sliderColors = colors;
                if ($composer3.changed(sliderColors)) {
                    i2 = 8388608;
                    $dirty2 |= i2;
                }
            } else {
                sliderColors = colors;
            }
            i2 = 4194304;
            $dirty2 |= i2;
        } else {
            sliderColors = colors;
        }
        if (($dirty2 & 23967451) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            enabled4 = enabled2;
            colors3 = sliderColors;
            valueRange2 = valueRange;
            onValueChangeFinished2 = onValueChangeFinished;
            steps3 = steps2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier;
                if (i5 != 0) {
                    enabled2 = true;
                }
                if ((i & 16) != 0) {
                    ClosedFloatingPointRange valueRange3 = RangesKt.rangeTo(0.0f, 1.0f);
                    $dirty2 &= -57345;
                    valueRange = valueRange3;
                }
                if (i6 != 0) {
                    steps2 = 0;
                }
                if (i7 != 0) {
                    onValueChangeFinished = null;
                }
                if ((i & 128) != 0) {
                    modifier2 = modifier3;
                    $dirty = $dirty2 & (-29360129);
                    valueRange2 = valueRange;
                    onValueChangeFinished2 = onValueChangeFinished;
                    steps3 = steps2;
                    colors2 = SliderDefaults.INSTANCE.m1702colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 6, 1023);
                    enabled3 = enabled2;
                } else {
                    modifier2 = modifier3;
                    $dirty = $dirty2;
                    valueRange2 = valueRange;
                    onValueChangeFinished2 = onValueChangeFinished;
                    steps3 = steps2;
                    enabled3 = enabled2;
                    colors2 = sliderColors;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 128) != 0) {
                    modifier2 = modifier;
                    $dirty = $dirty2 & (-29360129);
                    valueRange2 = valueRange;
                    onValueChangeFinished2 = onValueChangeFinished;
                    steps3 = steps2;
                    enabled3 = enabled2;
                    colors2 = sliderColors;
                } else {
                    modifier2 = modifier;
                    $dirty = $dirty2;
                    valueRange2 = valueRange;
                    onValueChangeFinished2 = onValueChangeFinished;
                    steps3 = steps2;
                    enabled3 = enabled2;
                    colors2 = sliderColors;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-743091416, $dirty, -1, "androidx.compose.material3.RangeSlider (Slider.kt:319)");
            }
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer3.endReplaceableGroup();
            final MutableInteractionSource startInteractionSource = (MutableInteractionSource) value$iv$iv;
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv2 = $composer3.rememberedValue();
            if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer3.endReplaceableGroup();
            final MutableInteractionSource endInteractionSource = (MutableInteractionSource) value$iv$iv2;
            if (!(steps3 >= 0)) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            colors3 = colors2;
            enabled4 = enabled3;
            $composer2 = $composer3;
            RangeSliderImpl(modifier2, value, onValueChange, enabled3, valueRange2, steps3, onValueChangeFinished2, startInteractionSource, endInteractionSource, ComposableLambdaKt.composableLambda($composer3, 1361279243, true, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                    invoke(sliderPositions, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SliderPositions it, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer4, "C346@15726L147:Slider.kt#uh7d8r");
                    if (($changed2 & 81) != 16 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1361279243, $changed2, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:345)");
                        }
                        SliderDefaults.INSTANCE.m1701Thumb9LiSoMs(MutableInteractionSource.this, null, colors2, enabled3, 0L, $composer4, (($dirty >> 15) & 896) | 196614 | ($dirty & 7168), 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), ComposableLambdaKt.composableLambda($composer3, 741565023, true, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                    invoke(sliderPositions, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SliderPositions it, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation($composer4, "C353@15933L145:Slider.kt#uh7d8r");
                    if (($changed2 & 81) != 16 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(741565023, $changed2, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:352)");
                        }
                        SliderDefaults.INSTANCE.m1701Thumb9LiSoMs(MutableInteractionSource.this, null, colors2, enabled3, 0L, $composer4, (($dirty >> 15) & 896) | 196614 | ($dirty & 7168), 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), ComposableLambdaKt.composableLambda($composer3, -298726816, true, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                    invoke(sliderPositions, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SliderPositions sliderPositions, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(sliderPositions, "sliderPositions");
                    ComposerKt.sourceInformation($composer4, "C360@16154L138:Slider.kt#uh7d8r");
                    int $dirty3 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty3 |= $composer4.changed(sliderPositions) ? 4 : 2;
                    }
                    if (($dirty3 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-298726816, $dirty3, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:359)");
                        }
                        SliderDefaults.INSTANCE.Track(sliderPositions, null, SliderColors.this, enabled3, $composer4, ($dirty3 & 14) | 24576 | (($dirty >> 15) & 896) | ($dirty & 7168), 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, (($dirty >> 6) & 14) | 918552576 | (($dirty << 3) & 112) | (($dirty << 3) & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | ($dirty & 3670016), 54, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier2;
        final boolean z = enabled4;
        final ClosedFloatingPointRange closedFloatingPointRange2 = valueRange2;
        final int i8 = steps3;
        final Function0 function02 = onValueChangeFinished2;
        final SliderColors sliderColors2 = colors3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$5
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

            public final void invoke(Composer composer, int i9) {
                SliderKt.RangeSlider(value, onValueChange, modifier4, z, closedFloatingPointRange2, i8, function02, sliderColors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public static final void RangeSlider(final ClosedFloatingPointRange<Float> value, final Function1<? super ClosedFloatingPointRange<Float>, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> closedFloatingPointRange, Function0<Unit> function0, SliderColors colors, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function32, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function33, int steps, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        ClosedFloatingPointRange valueRange;
        ClosedFloatingPointRange valueRange2;
        final int $dirty;
        final SliderColors colors2;
        final MutableInteractionSource startInteractionSource2;
        final MutableInteractionSource endInteractionSource2;
        MutableInteractionSource startInteractionSource3;
        boolean z;
        Function3 startThumb;
        ClosedFloatingPointRange valueRange3;
        int steps2;
        MutableInteractionSource endInteractionSource3;
        SliderColors colors3;
        Function3 startThumb2;
        Function3 endThumb;
        Function3 track;
        boolean enabled2;
        Function0 onValueChangeFinished;
        MutableInteractionSource startInteractionSource4;
        Modifier modifier3;
        int $dirty2;
        Object value$iv$iv;
        Object value$iv$iv2;
        Composer $composer2;
        int steps3;
        Function3 track2;
        Function3 track3;
        Function3 endThumb2;
        MutableInteractionSource endInteractionSource4;
        MutableInteractionSource endInteractionSource5;
        SliderColors colors4;
        Function0 onValueChangeFinished2;
        ClosedFloatingPointRange valueRange4;
        boolean enabled3;
        Modifier modifier4;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-1048796133);
        ComposerKt.sourceInformation($composer3, "C(RangeSlider)P(11,5,4,1,12,6!1,7!1,8!1,10)435@20161L8,436@20226L39,437@20320L39,464@21150L445:Slider.kt#uh7d8r");
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty3 |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0 && $composer3.changed(closedFloatingPointRange)) {
                i3 = 16384;
                $dirty3 |= i3;
            }
            i3 = 8192;
            $dirty3 |= i3;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty3 |= $composer3.changedInstance(function0) ? 131072 : 65536;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0 && $composer3.changed(colors)) {
                i2 = 1048576;
                $dirty3 |= i2;
            }
            i2 = 524288;
            $dirty3 |= i2;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty3 |= $composer3.changed(startInteractionSource) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty3 |= $composer3.changed(endInteractionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty3 |= $composer3.changedInstance(function3) ? 536870912 : 268435456;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changedInstance(function32) ? 4 : 2;
        }
        int i11 = i & 2048;
        if (i11 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty1 |= $composer3.changedInstance(function33) ? 32 : 16;
        }
        int i12 = i & 4096;
        if (i12 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty1 |= $composer3.changed(steps) ? 256 : 128;
        }
        if (($dirty3 & 1533916891) == 306783378 && ($dirty1 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier;
            enabled3 = enabled;
            valueRange4 = closedFloatingPointRange;
            onValueChangeFinished2 = function0;
            colors4 = colors;
            endInteractionSource5 = startInteractionSource;
            endInteractionSource4 = endInteractionSource;
            endThumb2 = function3;
            track3 = function32;
            track2 = function33;
            steps3 = steps;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i4 != 0 ? Modifier.INSTANCE : modifier;
                final boolean enabled4 = i5 != 0 ? true : enabled;
                if ((i & 16) != 0) {
                    modifier2 = modifier5;
                    valueRange = RangesKt.rangeTo(0.0f, 1.0f);
                    $dirty3 &= -57345;
                } else {
                    modifier2 = modifier5;
                    valueRange = closedFloatingPointRange;
                }
                Function0 onValueChangeFinished3 = i6 != 0 ? null : function0;
                if ((i & 64) != 0) {
                    valueRange2 = valueRange;
                    $dirty = $dirty3 & (-3670017);
                    colors2 = SliderDefaults.INSTANCE.m1702colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 6, 1023);
                } else {
                    valueRange2 = valueRange;
                    $dirty = $dirty3;
                    colors2 = colors;
                }
                if (i7 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv2 = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv2);
                    } else {
                        value$iv$iv2 = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    startInteractionSource2 = (MutableInteractionSource) value$iv$iv2;
                } else {
                    startInteractionSource2 = startInteractionSource;
                }
                if (i8 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv2 = $composer3.rememberedValue();
                    if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv2;
                    }
                    $composer3.endReplaceableGroup();
                    endInteractionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    endInteractionSource2 = endInteractionSource;
                }
                if (i9 != 0) {
                    Function3<SliderPositions, Composer, Integer, Unit> function34 = new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$8
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                            invoke(sliderPositions, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SliderPositions it, Composer $composer4, int $changed2) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            ComposerKt.sourceInformation($composer4, "C439@20442L131:Slider.kt#uh7d8r");
                            if (($changed2 & 81) != 16 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(585242822, $changed2, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:438)");
                                }
                                SliderDefaults.INSTANCE.m1701Thumb9LiSoMs(MutableInteractionSource.this, null, colors2, enabled4, 0L, $composer4, (($dirty >> 21) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (($dirty >> 12) & 896) | ($dirty & 7168), 18);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer4.skipToGroupEnd();
                        }
                    };
                    startInteractionSource3 = startInteractionSource2;
                    z = true;
                    startThumb = ComposableLambdaKt.composableLambda($composer3, 585242822, true, function34);
                } else {
                    startInteractionSource3 = startInteractionSource2;
                    z = true;
                    startThumb = function3;
                }
                Function3 endThumb3 = i10 != 0 ? ComposableLambdaKt.composableLambda($composer3, 1397395775, z, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$9
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                        invoke(sliderPositions, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SliderPositions it, Composer $composer4, int $changed2) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        ComposerKt.sourceInformation($composer4, "C446@20660L129:Slider.kt#uh7d8r");
                        if (($changed2 & 81) != 16 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1397395775, $changed2, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:445)");
                            }
                            SliderDefaults.INSTANCE.m1701Thumb9LiSoMs(MutableInteractionSource.this, null, colors2, enabled4, 0L, $composer4, (($dirty >> 24) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (($dirty >> 12) & 896) | ($dirty & 7168), 18);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }) : function32;
                Function3 track4 = i11 != 0 ? ComposableLambdaKt.composableLambda($composer3, -2139066097, z, new Function3<SliderPositions, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$10
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(SliderPositions sliderPositions, Composer composer, Integer num) {
                        invoke(sliderPositions, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SliderPositions sliderPositions, Composer $composer4, int $changed2) {
                        Intrinsics.checkNotNullParameter(sliderPositions, "sliderPositions");
                        ComposerKt.sourceInformation($composer4, "C453@20896L138:Slider.kt#uh7d8r");
                        int $dirty4 = $changed2;
                        if (($changed2 & 14) == 0) {
                            $dirty4 |= $composer4.changed(sliderPositions) ? 4 : 2;
                        }
                        if (($dirty4 & 91) != 18 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2139066097, $dirty4, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:452)");
                            }
                            SliderDefaults.INSTANCE.Track(sliderPositions, null, SliderColors.this, enabled4, $composer4, ($dirty4 & 14) | 24576 | (($dirty >> 12) & 896) | ($dirty & 7168), 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }) : function33;
                if (i12 != 0) {
                    valueRange3 = valueRange2;
                    endInteractionSource3 = endInteractionSource2;
                    colors3 = colors2;
                    startThumb2 = startThumb;
                    endThumb = endThumb3;
                    track = track4;
                    steps2 = 0;
                    enabled2 = enabled4;
                    onValueChangeFinished = onValueChangeFinished3;
                    startInteractionSource4 = startInteractionSource3;
                    modifier3 = modifier2;
                    $dirty2 = $dirty;
                } else {
                    valueRange3 = valueRange2;
                    steps2 = steps;
                    endInteractionSource3 = endInteractionSource2;
                    colors3 = colors2;
                    startThumb2 = startThumb;
                    endThumb = endThumb3;
                    track = track4;
                    enabled2 = enabled4;
                    onValueChangeFinished = onValueChangeFinished3;
                    startInteractionSource4 = startInteractionSource3;
                    modifier3 = modifier2;
                    $dirty2 = $dirty;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 64) != 0) {
                    modifier3 = modifier;
                    enabled2 = enabled;
                    valueRange3 = closedFloatingPointRange;
                    onValueChangeFinished = function0;
                    colors3 = colors;
                    startInteractionSource4 = startInteractionSource;
                    endInteractionSource3 = endInteractionSource;
                    startThumb2 = function3;
                    endThumb = function32;
                    track = function33;
                    steps2 = steps;
                    $dirty2 = (-3670017) & $dirty3;
                    z = true;
                } else {
                    modifier3 = modifier;
                    enabled2 = enabled;
                    valueRange3 = closedFloatingPointRange;
                    onValueChangeFinished = function0;
                    colors3 = colors;
                    startInteractionSource4 = startInteractionSource;
                    endInteractionSource3 = endInteractionSource;
                    startThumb2 = function3;
                    endThumb = function32;
                    track = function33;
                    steps2 = steps;
                    $dirty2 = $dirty3;
                    z = true;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1048796133, $dirty2, $dirty1, "androidx.compose.material3.RangeSlider (Slider.kt:428)");
            }
            if (!(steps2 >= 0 ? z : false)) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            $composer2 = $composer3;
            RangeSliderImpl(modifier3, value, onValueChange, enabled2, valueRange3, steps2, onValueChangeFinished, startInteractionSource4, endInteractionSource3, startThumb2, endThumb, track, $composer2, (($dirty2 >> 6) & 14) | (($dirty2 << 3) & 112) | (($dirty2 << 3) & 896) | ($dirty2 & 7168) | ($dirty2 & 57344) | (($dirty1 << 9) & 458752) | (($dirty2 << 3) & 3670016) | (29360128 & $dirty2) | (234881024 & $dirty2) | (1879048192 & $dirty2), ($dirty1 & 14) | ($dirty1 & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            steps3 = steps2;
            track2 = track;
            track3 = endThumb;
            endThumb2 = startThumb2;
            endInteractionSource4 = endInteractionSource3;
            endInteractionSource5 = startInteractionSource4;
            colors4 = colors3;
            onValueChangeFinished2 = onValueChangeFinished;
            valueRange4 = valueRange3;
            enabled3 = enabled2;
            modifier4 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier4;
        final boolean z2 = enabled3;
        final ClosedFloatingPointRange closedFloatingPointRange2 = valueRange4;
        final Function0 function02 = onValueChangeFinished2;
        final SliderColors sliderColors = colors4;
        final MutableInteractionSource mutableInteractionSource = endInteractionSource5;
        final MutableInteractionSource mutableInteractionSource2 = endInteractionSource4;
        final Function3 function35 = endThumb2;
        final Function3 function36 = track3;
        final Function3 function37 = track2;
        final int i13 = steps3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$12
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

            public final void invoke(Composer composer, int i14) {
                SliderKt.RangeSlider(value, onValueChange, modifier6, z2, closedFloatingPointRange2, function02, sliderColors, mutableInteractionSource, mutableInteractionSource2, function35, function36, function37, i13, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0566  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0572  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0696  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x06a2  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0805  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0811  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x08d0  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0815  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x06a6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x045e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x039b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0214  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SliderImpl(final androidx.compose.ui.Modifier r61, final boolean r62, final androidx.compose.foundation.interaction.MutableInteractionSource r63, final kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r64, final kotlin.jvm.functions.Function0<kotlin.Unit> r65, final int r66, final float r67, final kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r68, final kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, final kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r70, androidx.compose.runtime.Composer r71, final int r72) {
        /*
            Method dump skipped, instructions count: 2302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.SliderImpl(androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, int, float, kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float SliderImpl$scaleToUserValue(ClosedFloatingPointRange<Float> closedFloatingPointRange, float minPx, float maxPx, float offset) {
        return scale(minPx, maxPx, offset, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float SliderImpl$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, float minPx, float maxPx, float userValue) {
        return scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), userValue, minPx, maxPx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x067d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x079d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x07a9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0839  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x092c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0938  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0a08  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0ae5  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0af1  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0c4d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0c59  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0d17  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0c5d  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0af5  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0a15 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x093c  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0849 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x07ad  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x068b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0610 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0477 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01e1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0d20  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0d23  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0584  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void RangeSliderImpl(final androidx.compose.ui.Modifier r75, final kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r76, final kotlin.jvm.functions.Function1<? super kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit> r77, final boolean r78, final kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r79, int r80, final kotlin.jvm.functions.Function0<kotlin.Unit> r81, final androidx.compose.foundation.interaction.MutableInteractionSource r82, final androidx.compose.foundation.interaction.MutableInteractionSource r83, final kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r84, final kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r85, final kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r86, androidx.compose.runtime.Composer r87, final int r88, final int r89, final int r90) {
        /*
            Method dump skipped, instructions count: 3414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.RangeSliderImpl(androidx.compose.ui.Modifier, kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function1, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float RangeSliderImpl$lambda$25(MutableState<Float> mutableState) {
        MutableState<Float> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RangeSliderImpl$lambda$26(MutableState<Float> mutableState, float value) {
        mutableState.setValue(Float.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float RangeSliderImpl$lambda$28(MutableState<Float> mutableState) {
        MutableState<Float> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RangeSliderImpl$lambda$29(MutableState<Float> mutableState, float value) {
        mutableState.setValue(Float.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int RangeSliderImpl$lambda$31(MutableState<Integer> mutableState) {
        MutableState<Integer> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RangeSliderImpl$lambda$32(MutableState<Integer> mutableState, int value) {
        mutableState.setValue(Integer.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> RangeSliderImpl$scaleToUserValue$33(ClosedFloatingPointRange<Float> closedFloatingPointRange, float minPx, float maxPx, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        return scale(minPx, maxPx, closedFloatingPointRange2, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float RangeSliderImpl$scaleToOffset$34(ClosedFloatingPointRange<Float> closedFloatingPointRange, float minPx, float maxPx, float userValue) {
        return scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), userValue, minPx, maxPx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.collections.IntIterator] */
    public static final float snapValueToTick(float current, float[] tickFractions, float minPx, float maxPx) {
        Float valueOf;
        if (tickFractions.length == 0) {
            valueOf = null;
        } else {
            float minElem$iv = tickFractions[0];
            int lastIndex$iv = ArraysKt.getLastIndex(tickFractions);
            if (lastIndex$iv == 0) {
                valueOf = Float.valueOf(minElem$iv);
            } else {
                float minValue$iv = Math.abs(MathHelpersKt.lerp(minPx, maxPx, minElem$iv) - current);
                ?? it = new IntRange(1, lastIndex$iv).iterator();
                while (it.hasNext()) {
                    int i$iv = it.nextInt();
                    float e$iv = tickFractions[i$iv];
                    float v$iv = Math.abs(MathHelpersKt.lerp(minPx, maxPx, e$iv) - current);
                    if (Float.compare(minValue$iv, v$iv) > 0) {
                        minElem$iv = e$iv;
                        minValue$iv = v$iv;
                    }
                }
                valueOf = Float.valueOf(minElem$iv);
            }
        }
        if (valueOf != null) {
            float $this$snapValueToTick_u24lambda_u2449 = valueOf.floatValue();
            return MathHelpersKt.lerp(minPx, maxPx, $this$snapValueToTick_u24lambda_u2449);
        }
        return current;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: awaitSlop-8vUncbI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m1704awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, long r9, int r11, kotlin.coroutines.Continuation<? super kotlin.Pair<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float>> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.material3.SliderKt$awaitSlop$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = (androidx.compose.material3.SliderKt$awaitSlop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = new androidx.compose.material3.SliderKt$awaitSlop$1
            r0.<init>(r12)
        L19:
            r12 = r0
            java.lang.Object r6 = r12.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r12.label
            switch(r0) {
                case 0: goto L36;
                case 1: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L2d:
            java.lang.Object r8 = r12.L$0
            kotlin.jvm.internal.Ref$FloatRef r8 = (kotlin.jvm.internal.Ref.FloatRef) r8
            kotlin.ResultKt.throwOnFailure(r6)
            r9 = r6
            goto L56
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            r0 = r8
            r1 = r9
            r3 = r11
            kotlin.jvm.internal.Ref$FloatRef r8 = new kotlin.jvm.internal.Ref$FloatRef
            r8.<init>()
            androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1 r9 = new androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1
            r9.<init>()
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r12.L$0 = r8
            r10 = 1
            r12.label = r10
            r4 = r9
            r5 = r12
            java.lang.Object r9 = androidx.compose.material3.DragGestureDetectorCopyKt.m1497awaitHorizontalPointerSlopOrCancellationgDDlDlE(r0, r1, r3, r4, r5)
            if (r9 != r7) goto L56
            return r7
        L56:
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 == 0) goto L65
            float r10 = r8.element
            java.lang.Float r10 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r10)
            kotlin.Pair r10 = kotlin.TuplesKt.to(r9, r10)
            goto L66
        L65:
            r10 = 0
        L66:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.m1704awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float[] stepsToTickFractions(int steps) {
        if (steps == 0) {
            return new float[0];
        }
        int i = steps + 2;
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            fArr[i2] = i2 / (steps + 1);
        }
        return fArr;
    }

    private static final float scale(float a1, float b1, float x1, float a2, float b2) {
        return MathHelpersKt.lerp(a2, b2, calcFraction(a1, b1, x1));
    }

    private static final ClosedFloatingPointRange<Float> scale(float a1, float b1, ClosedFloatingPointRange<Float> closedFloatingPointRange, float a2, float b2) {
        return RangesKt.rangeTo(scale(a1, b1, closedFloatingPointRange.getStart().floatValue(), a2, b2), scale(a1, b1, closedFloatingPointRange.getEndInclusive().floatValue(), a2, b2));
    }

    private static final float calcFraction(float a, float b, float pos) {
        return RangesKt.coerceIn(((b - a) > 0.0f ? 1 : ((b - a) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (pos - a) / (b - a), 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sliderSemantics(Modifier $this$sliderSemantics, float value, final boolean enabled, final Function1<? super Float, Unit> function1, final Function0<Unit> function0, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final int steps) {
        final float coerced = RangesKt.coerceIn(value, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default($this$sliderSemantics, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$sliderSemantics$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                if (!enabled) {
                    SemanticsPropertiesKt.disabled(semantics);
                }
                final ClosedFloatingPointRange<Float> closedFloatingPointRange2 = closedFloatingPointRange;
                final int i = steps;
                final float f = coerced;
                final Function1<Float, Unit> function12 = function1;
                final Function0<Unit> function02 = function0;
                SemanticsPropertiesKt.setProgress$default(semantics, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material3.SliderKt$sliderSemantics$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Float f2) {
                        return invoke(f2.floatValue());
                    }

                    public final Boolean invoke(float targetValue) {
                        float newValue = RangesKt.coerceIn(targetValue, closedFloatingPointRange2.getStart().floatValue(), closedFloatingPointRange2.getEndInclusive().floatValue());
                        boolean z = true;
                        if (i > 0) {
                            float distance = newValue;
                            int i2 = 0;
                            int i3 = i + 1;
                            if (0 <= i3) {
                                while (true) {
                                    float stepValue = MathHelpersKt.lerp(closedFloatingPointRange2.getStart().floatValue(), closedFloatingPointRange2.getEndInclusive().floatValue(), i2 / (i + 1));
                                    if (Math.abs(stepValue - newValue) <= distance) {
                                        distance = Math.abs(stepValue - newValue);
                                        newValue = stepValue;
                                    }
                                    if (i2 == i3) {
                                        break;
                                    }
                                    i2++;
                                }
                            }
                        }
                        float resolvedValue = newValue;
                        if (resolvedValue == f) {
                            z = false;
                        } else {
                            function12.invoke(Float.valueOf(resolvedValue));
                            Function0<Unit> function03 = function02;
                            if (function03 != null) {
                                function03.invoke();
                            }
                        }
                        return Boolean.valueOf(z);
                    }
                }, 1, null);
            }
        }, 1, null), value, closedFloatingPointRange, steps);
    }

    private static final Modifier sliderTapModifier(Modifier $this$sliderTapModifier, final DraggableState draggableState, final MutableInteractionSource interactionSource, final int maxPx, final boolean isRtl, final State<Float> state, final State<? extends Function0<Unit>> state2, final MutableState<Float> mutableState, final boolean enabled) {
        return ComposedModifierKt.composed($this$sliderTapModifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("sliderTapModifier");
                $this$null.getProperties().set("draggableState", DraggableState.this);
                $this$null.getProperties().set("interactionSource", interactionSource);
                $this$null.getProperties().set("maxPx", Integer.valueOf(maxPx));
                $this$null.getProperties().set("isRtl", Boolean.valueOf(isRtl));
                $this$null.getProperties().set("rawOffset", state);
                $this$null.getProperties().set("gestureEndAction", state2);
                $this$null.getProperties().set("pressOffset", mutableState);
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.SliderKt$sliderTapModifier$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Modifier modifier;
                Object value$iv$iv$iv;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(2040469710);
                ComposerKt.sourceInformation($composer, "C1173@48923L24:Slider.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2040469710, $changed, -1, "androidx.compose.material3.sliderTapModifier.<anonymous> (Slider.kt:1171)");
                }
                if (!enabled) {
                    modifier = composed;
                } else {
                    $composer.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation($composer, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                    $composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv$iv = $composer.rememberedValue();
                    if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
                        $composer.updateRememberedValue(value$iv$iv$iv);
                    } else {
                        value$iv$iv$iv = it$iv$iv$iv;
                    }
                    $composer.endReplaceableGroup();
                    CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                    CoroutineScope scope = wrapper$iv.getCoroutineScope();
                    $composer.endReplaceableGroup();
                    modifier = SuspendingPointerInputFilterKt.pointerInput(composed, new Object[]{draggableState, interactionSource, Integer.valueOf(maxPx), Boolean.valueOf(isRtl)}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1(isRtl, maxPx, mutableState, state, scope, draggableState, state2, null));
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return modifier;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Slider.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "androidx.compose.material3.SliderKt$sliderTapModifier$2$1", f = "Slider.kt", i = {}, l = {1176}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$2$1, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ DraggableState $draggableState;
                final /* synthetic */ State<Function0<Unit>> $gestureEndAction;
                final /* synthetic */ boolean $isRtl;
                final /* synthetic */ int $maxPx;
                final /* synthetic */ MutableState<Float> $pressOffset;
                final /* synthetic */ State<Float> $rawOffset;
                final /* synthetic */ CoroutineScope $scope;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass1(boolean z, int i, MutableState<Float> mutableState, State<Float> state, CoroutineScope coroutineScope, DraggableState draggableState, State<? extends Function0<Unit>> state2, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$isRtl = z;
                    this.$maxPx = i;
                    this.$pressOffset = mutableState;
                    this.$rawOffset = state;
                    this.$scope = coroutineScope;
                    this.$draggableState = draggableState;
                    this.$gestureEndAction = state2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, this.$scope, this.$draggableState, this.$gestureEndAction, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: Slider.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(c = "androidx.compose.material3.SliderKt$sliderTapModifier$2$1$1", f = "Slider.kt", i = {}, l = {1181}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$2$1$1, reason: invalid class name and collision with other inner class name */
                /* loaded from: classes.dex */
                public static final class C00521 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                    final /* synthetic */ boolean $isRtl;
                    final /* synthetic */ int $maxPx;
                    final /* synthetic */ MutableState<Float> $pressOffset;
                    final /* synthetic */ State<Float> $rawOffset;
                    /* synthetic */ long J$0;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00521(boolean z, int i, MutableState<Float> mutableState, State<Float> state, Continuation<? super C00521> continuation) {
                        super(3, continuation);
                        this.$isRtl = z;
                        this.$maxPx = i;
                        this.$pressOffset = mutableState;
                        this.$rawOffset = state;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                        return m1705invoked4ec7I(pressGestureScope, offset.getPackedValue(), continuation);
                    }

                    /* renamed from: invoke-d-4ec7I, reason: not valid java name */
                    public final Object m1705invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                        C00521 c00521 = new C00521(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, continuation);
                        c00521.L$0 = pressGestureScope;
                        c00521.J$0 = j;
                        return c00521.invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        C00521 c00521;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                PressGestureScope $this$detectTapGestures = (PressGestureScope) this.L$0;
                                long pos = this.J$0;
                                float to = this.$isRtl ? this.$maxPx - Offset.m2710getXimpl(pos) : Offset.m2710getXimpl(pos);
                                this.$pressOffset.setValue(Boxing.boxFloat(to - this.$rawOffset.getValue().floatValue()));
                                try {
                                    this.label = 1;
                                } catch (GestureCancellationException e) {
                                    c00521 = this;
                                    c00521.$pressOffset.setValue(Boxing.boxFloat(0.0f));
                                    return Unit.INSTANCE;
                                }
                                if ($this$detectTapGestures.awaitRelease(this) != coroutine_suspended) {
                                    return Unit.INSTANCE;
                                }
                                return coroutine_suspended;
                            case 1:
                                c00521 = this;
                                try {
                                    ResultKt.throwOnFailure($result);
                                } catch (GestureCancellationException e2) {
                                    c00521.$pressOffset.setValue(Boxing.boxFloat(0.0f));
                                    return Unit.INSTANCE;
                                }
                                return Unit.INSTANCE;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object detectTapGestures;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                            C00521 c00521 = new C00521(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, null);
                            final CoroutineScope coroutineScope = this.$scope;
                            final DraggableState draggableState = this.$draggableState;
                            final State<Function0<Unit>> state = this.$gestureEndAction;
                            Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.material3.SliderKt.sliderTapModifier.2.1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                    m1706invokek4lQ0M(offset.getPackedValue());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                                public final void m1706invokek4lQ0M(long it) {
                                    BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new C00531(draggableState, state, null), 3, null);
                                }

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* compiled from: Slider.kt */
                                @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                @DebugMetadata(c = "androidx.compose.material3.SliderKt$sliderTapModifier$2$1$2$1", f = "Slider.kt", i = {}, l = {1188}, m = "invokeSuspend", n = {}, s = {})
                                /* renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$2$1$2$1, reason: invalid class name and collision with other inner class name */
                                /* loaded from: classes.dex */
                                public static final class C00531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ DraggableState $draggableState;
                                    final /* synthetic */ State<Function0<Unit>> $gestureEndAction;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    C00531(DraggableState draggableState, State<? extends Function0<Unit>> state, Continuation<? super C00531> continuation) {
                                        super(2, continuation);
                                        this.$draggableState = draggableState;
                                        this.$gestureEndAction = state;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new C00531(this.$draggableState, this.$gestureEndAction, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((C00531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* compiled from: Slider.kt */
                                    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                    @DebugMetadata(c = "androidx.compose.material3.SliderKt$sliderTapModifier$2$1$2$1$1", f = "Slider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$2$1$2$1$1, reason: invalid class name and collision with other inner class name */
                                    /* loaded from: classes.dex */
                                    public static final class C00541 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
                                        private /* synthetic */ Object L$0;
                                        int label;

                                        C00541(Continuation<? super C00541> continuation) {
                                            super(2, continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            C00541 c00541 = new C00541(continuation);
                                            c00541.L$0 = obj;
                                            return c00541;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
                                            return ((C00541) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch (this.label) {
                                                case 0:
                                                    ResultKt.throwOnFailure(obj);
                                                    DragScope $this$drag = (DragScope) this.L$0;
                                                    $this$drag.dragBy(0.0f);
                                                    return Unit.INSTANCE;
                                                default:
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                        }
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object $result) {
                                        C00531 c00531;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                this.label = 1;
                                                if (this.$draggableState.drag(MutatePriority.UserInput, new C00541(null), this) != coroutine_suspended) {
                                                    c00531 = this;
                                                    break;
                                                } else {
                                                    return coroutine_suspended;
                                                }
                                            case 1:
                                                c00531 = this;
                                                ResultKt.throwOnFailure($result);
                                                break;
                                            default:
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        c00531.$gestureEndAction.getValue().invoke();
                                        return Unit.INSTANCE;
                                    }
                                }
                            };
                            this.label = 1;
                            detectTapGestures = TapGestureDetectorKt.detectTapGestures($this$pointerInput, (r13 & 1) != 0 ? null : null, (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? TapGestureDetectorKt.NoPressGesture : c00521, (r13 & 8) != 0 ? null : function1, this);
                            if (detectTapGestures != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        case 1:
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object animateToTarget(DraggableState draggableState, float current, float target, float velocity, Continuation<? super Unit> continuation) {
        Object drag$default = DraggableState.drag$default(draggableState, null, new SliderKt$animateToTarget$2(current, target, velocity, null), continuation, 1, null);
        return drag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? drag$default : Unit.INSTANCE;
    }

    private static final Modifier rangeSliderPressDragModifier(Modifier $this$rangeSliderPressDragModifier, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, State<Float> state, State<Float> state2, boolean enabled, boolean isRtl, int maxPx, ClosedFloatingPointRange<Float> closedFloatingPointRange, State<? extends Function1<? super Boolean, Unit>> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4) {
        if (enabled) {
            return SuspendingPointerInputFilterKt.pointerInput($this$rangeSliderPressDragModifier, new Object[]{startInteractionSource, endInteractionSource, Integer.valueOf(maxPx), Boolean.valueOf(isRtl), closedFloatingPointRange}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SliderKt$rangeSliderPressDragModifier$1(startInteractionSource, endInteractionSource, state, state2, state4, isRtl, maxPx, state3, null));
        }
        return $this$rangeSliderPressDragModifier;
    }

    public static final float getThumbWidth() {
        return ThumbWidth;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }
}
